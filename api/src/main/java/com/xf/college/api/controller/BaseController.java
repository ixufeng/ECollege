package com.xf.college.api.controller;

import com.xf.college.common.Auth;
import com.xf.college.common.utils.StringUtil;
import com.xf.college.model.apiwrapper.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 基础的控制器，里面放公用方法
 */
public class BaseController {

	protected <T> APIResult<T> asSuccess(T t) {
		return new APIResult<>(APIResultCode.SUCCESS.getValue(), null, t);
	}

	protected APIResult<String> asError(String message) {
		return new APIResult<>(APIResultCode.ERROR.getValue(), message, null);
	}

    protected APIResult<String> asError(String message, Throwable e) {
        return new APIResult<>(APIResultCode.ERROR.getValue(), message + "[" + e.getMessage() + "]", null);
    }

    protected APIResult<String> asNotFound(String message) {
        return new APIResult<>(APIResultCode.NOTFOUND.getValue(), message, null);
    }

    protected APIResult<String> asBadRequest(String message) {
        return new APIResult<>(APIResultCode.BADREQUEST.getValue(), message, null);
    }

    protected APIResult<String> asUnLogin(String message) {
        return new APIResult<>(APIResultCode.UNLOGIN.getValue(), message, null);
    }

	protected APIResult<String> asUnAuthError(String message) {
		return new APIResult<>(APIResultCode.UNAUTHORITY.getValue(), message, null);
	}

	protected <T> APIListResult<T> asSuccess(List<T> t, int count) {
		ListPackage<T> list = new ListPackage<>();
		list.setList(t);
		list.setCount(count);
		return new APIListResult<>(APIResultCode.SUCCESS.getValue(), "SUCCESS", list);
	}

	protected APIResult handleNoAuth(Integer auth) {

        if (Objects.equals(auth, Auth.BLACK)) {
            return asUnAuthError("权限被限制，请联系管理员！");
        }
        if (Objects.equals(auth,Auth.NO_AUTH)) {
            return asUnLogin("请先登陆");
        }
        return asUnAuthError("没有权限！");
    }

    protected PageParameter getPageParameter(ServletRequest request){
        PageParameter pageParam = new PageParameter();
        int _offset = StringUtil.convert(request.getParameter("offset"), 0);
        int _limit = StringUtil.convert(request.getParameter("limit"), 99);
        String _sort = StringUtil.convert(request.getParameter("sort"));
        String _columns = StringUtil.convert(request.getParameter("cols"));

        pageParam.setOffset(_offset);
        pageParam.setLimit(_limit);
        // 排序
        if(_sort != null){
            Map<String,Boolean> sorts = new HashMap<>();
            String[] s = _sort.split(","); // eg:  +id,-name
            for(String sItem : s){
                if(sItem.length() > 1) {
                    sorts.put(sItem.substring(1, sItem.length()),
                            (sItem.charAt(0) == '+' ? true : false));
                }
            }
            pageParam.setSort(sorts);
        }
        // 限制列
        if(_columns != null){
            String[] cols = _columns.trim().split(",");
            pageParam.setColumns(cols);
        }

        return pageParam;
    }

    protected Map<String,Object> getPageParams(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String,Object> params = new HashMap<>();
        PageParameter page = getPageParameter(request);
        params.put("offset",page.getOffset());
        params.put("limit",page.getLimit());

        // 筛选条件
        String _configLevel = StringUtil.convert(request.getParameter("configLevel")); // 配置级别，0：全局，1：机器，2：应用
        String _agentIp = StringUtil.convert(request.getParameter("agentIp")); // 具体机器ip查询
        String _appId = StringUtil.convert(request.getParameter("appId")); // 应用ids
        String _startTime = StringUtil.convert(request.getParameter("startTime"));
        String _endTime = StringUtil.convert(request.getParameter("endTime"));
        String _ip = StringUtil.convert(request.getParameter("ip")); // agent页面ip模糊查询
        params.put("configLevel", _configLevel);
        params.put("agentIp", _agentIp);
        params.put("appId", _appId);
        params.put("startTime", _startTime);
        params.put("endTime", _endTime);
        params.put("ip", _ip);
        return params;
    }

    public String getBodyStr(HttpServletRequest request) {
        InputStream is = null;
        StringBuilder sb = new StringBuilder();
        try {
            is = request.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}

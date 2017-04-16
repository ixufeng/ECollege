package com.xf.college.api.interceptor;

import com.xf.college.common.Auth;
import com.xf.college.model.student.Student;
import com.xf.college.model.teacher.Teacher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by xufeng on 2017/4/16.
 * 接口权限拦截
 */
public class ApiFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        request.setAttribute("auth",getAuth(session));
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
    }

    /**
     * 学生和老师的默认权限都为 1 ，如果是0 则是管理员 ，如果是-1 则为黑名单
     * @param session
     * @return
     */
    public int getAuth(HttpSession session) {
        Object obj = session.getAttribute("user");
        if (obj != null) {
            if (obj instanceof Teacher)  {
                Teacher teacher = (Teacher) obj;
                if (teacher.getLimit() == -1) {
                    return Auth.BLACK;
                }
                if (teacher.getLimit()==0) {
                    return Auth.ADMIN;
                }
                return Auth.TEACHER;
            }else if (obj instanceof Student) {
                Student student = (Student) obj;
                return Auth.STUDENT;
            }
        }
        return Auth.NO_AUTH;
    }

}

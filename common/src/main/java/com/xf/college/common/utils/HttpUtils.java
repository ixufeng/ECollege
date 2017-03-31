package com.xf.college.common.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by xf44397 on 2017/2/10.
 */
public class HttpUtils {


    /**
     * 发送http get 请求
     * @return
     */
    public static String httpGet(String url) throws Exception{

        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(url);
            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(final HttpResponse response) throws IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            return httpclient.execute(httpget, responseHandler);
        } finally {
            httpclient.close();
        }
    }

    public static String httpPost(String url,List<NameValuePair> params){

        String uriAPI = url;//Post方式没有参数在这里
        String result = "";
        HttpPost httpRequst = new HttpPost(uriAPI);//创建HttpPost对象
        CloseableHttpClient httpclient = HttpClients.createDefault();


        try {
            httpRequst.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            HttpResponse httpResponse = httpclient.execute(httpRequst);
            if(httpResponse.getStatusLine().getStatusCode() == 200) {
                HttpEntity httpEntity = httpResponse.getEntity();
                result = EntityUtils.toString(httpEntity);//取出应答字符串
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            result = e.getMessage().toString();
        }
        catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            result = e.getMessage().toString();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            result = e.getMessage().toString();
        }
        return result;
    }
    public static String httpPostWithJson(String url,String JsonStr){
        HttpClient httpClient = HttpClientBuilder.create().build();
        String result = "";
        try{
            HttpPost request = new HttpPost(url);
            request.setHeader("content-type", "application/json");
            StringEntity entity = new StringEntity(JsonStr);
            entity.setContentEncoding("utf-8");
            entity.setContentType("application/json");
            request.setEntity(entity);
            HttpResponse response = httpClient.execute(request);

            if (response.getStatusLine().getStatusCode()>=200&&response.getStatusLine().getStatusCode()<300){
                HttpEntity httpEntity = response.getEntity();
                result = EntityUtils.toString(httpEntity);//取出应答字符串
            }

        }catch (Exception e){
            e.printStackTrace();
            result = e.getMessage().toString();
        }
        return  result;
    }
}

package com.anzhi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.anzhi.util.Base64;


/**
 * notify 用户在线情况查询demo
 * @author gbf
 *
 */
public class Login {

    public static void main(String[] args) throws IOException {

        System.out.println("notify client--------------------------queryIsLogin");
        HttpClient httpclient = new HttpClient();
        String appkey = "1411570967l6aQ4204aISizP9R2M2b";
        String account = "20150424103705b5NMT9McgG";
        String sid = "MzY0MTU5Mjh8MTQyOTg0MzAyNXwwMDJ8TU9WRV9URVJNSU5BTHw2NDUxMjU=";
        String appsecret = "2C5Q6a5597mQ2aNNAJE67goR";
        System.out.println("sign str:" + appkey+account+sid+appsecret);
        String sign = Base64.encodeToString(appkey+account+sid+appsecret);
        System.out.println("sign:" + sign);
        String time = "20130709161023120";

        PostMethod post = new PostMethod("http://user.anzhi.com/web/api/sdk/third/1/queryislogin");
        String respStr = null;

        post.setRequestHeader("Content-type", "text/xml; charset=UTF-8");
        NameValuePair[] data ={ new NameValuePair("appkey",appkey),new NameValuePair("account",account),new NameValuePair("sid",sid),new NameValuePair("sign",sign),new NameValuePair("time",time)};
        post.setQueryString(data);
        httpclient.getHostConfiguration().setHost("http://user.anzhi.com/web/api/sdk/third/1/queryislogin");
        int result = 0;
        result = httpclient.executeMethod(post);
        if (result == HttpStatus.SC_OK) {
            respStr = post.getResponseBodyAsString();
        }

        System.out.println("queryIsLogins HttpURLConnection is OK strs:"+respStr);
        /*
        String tem = Base64.decode((String)map.get("msg"),"UTF-8");
        System.out.println(tem);
        response.setContentType("text/html;charset=GBK");
        response.getWriter().println(respStr);
        response.getWriter().println("msgs: "+tem);
        */
    }
}

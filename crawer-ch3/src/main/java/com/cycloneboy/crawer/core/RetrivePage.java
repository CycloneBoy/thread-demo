package com.cycloneboy.crawer.core;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import jdk.internal.org.objectweb.asm.tree.FieldInsnNode;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 读取一个网页
 * Created by CycloneBoy on 2017/7/24.
 */
public class RetrivePage {

    public static String downloadPage(String path) throws IOException {
        // 根据传入的路径构造URL
        URL pageURL = new URL(path);
        // 创建网络流
        BufferedReader reader = new BufferedReader(new InputStreamReader(pageURL.openStream()));
        String line ;
        // 读取网页的内容
        StringBuilder pageBuffer = new StringBuilder();
        while ((line = reader.readLine()) != null){
            pageBuffer.append(line);
        }

        return pageBuffer.toString();
    }

    public  static String downloadPageUseHttpClient(String path) throws IOException{
        // 创建一个客户端，类似打开一个浏览器
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        // 创建一个GET方法，类似在浏览器地址栏输入一个链接
        HttpGet httpGet = new HttpGet(path);

        HttpResponse response = httpClient.execute(httpGet);
        // 查看返回的内容
        HttpEntity httpEntity = response.getEntity();
        if(httpEntity != null){
            String html = EntityUtils.toString(httpEntity,"UTF-8");
            EntityUtils.consume(httpEntity);
            return  html;
        }
        return  null;
    }

    public static String downHtml(String url){
        HttpClient httpClient = HttpClientBuilder.create().build();

        try {
            HttpGet httpGet = new HttpGet(url);
            HttpResponse response = httpClient.execute(httpGet);

            Pattern pattern = Pattern.compile("text/html;[\\s]*charset=(.*)");
            Header[] arr = response.getHeaders("Content-Type");
            String charset = "utf-8";
            if(arr != null || arr.length != 0){
                String content = arr[0].getValue().toLowerCase();
                Matcher m = pattern.matcher(content);
                if(m.find()){
                    charset = m.group(1);
                }
            }

            HttpEntity entity = response.getEntity();
            if(entity != null){
                InputStream instream = entity.getContent();
                InputStreamReader ir = new InputStreamReader(instream,charset);
                BufferedReader reader = new BufferedReader(ir);

                StringBuilder builder = new StringBuilder();
                char[] chars = new char[4096];
                int length = 0;
                while (0 < (length = reader.read(chars))){
                    builder.append(chars,0,length);
                }
                return  builder.toString();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(RetrivePage.downloadPage("http://www.baidu.com"));
        System.out.println(RetrivePage.downloadPageUseHttpClient("http://www.baidu.com"));
    }
}

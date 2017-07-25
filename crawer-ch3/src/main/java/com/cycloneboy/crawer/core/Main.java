package com.cycloneboy.crawer.core;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.print.DocFlavor;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by CycloneBoy on 2017/7/24.
 */
public class Main {

    public static void main(String[] args) throws MalformedURLException {
        String urlString = "http://www.baidu.com/index.jsp";
        URL url = new URL(urlString);
        String protocol = url.getProtocol();
        System.out.println(protocol);
    }
}

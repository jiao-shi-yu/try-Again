package com.webserver.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * WebServer是模拟Tomcat的一个Web容器，实现了Tomcat的基础功能
 *
 * Web容器主要有两个任务
 * 1.管理部署在容器中的网络应用
 * 2.与客户端（通常是浏览器）建立TCP连接并基于HTTP协议进行交互，
 * 使得浏览器可以调用部署的网络应用提供的功能（浏览网页，业务处理等）
 *
 * 网络应用（WebApp)，网络应用通常包含：网页，素材，处理业务的逻辑代码等。
 * 就是我们俗称的一个网站。
 */
public class WebServerApplication {

    private ServerSocket serverSocket;

    public WebServerApplication() {
        try {
            System.out.println("正在启动服务端……");
            serverSocket = new ServerSocket(8088);
            System.out.println("服务端启动完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start() {
        try {
            System.out.println("等待客户端连接……");
            Socket socket = serverSocket.accept();
            System.out.println("一个客户端连接了！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WebServerApplication serverApplication = new WebServerApplication();
        serverApplication.start();
    }
}

package com.webserver.core;

import com.webserver.http.HttpServletRequest;
import com.webserver.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 线程任务
 * 负责与特定客户端进行HTTP交互
 */
public class ClientHandler implements Runnable{

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //1 解析请求
            // 读取消息头
            HttpServletRequest request = new HttpServletRequest(socket);
            HttpServletResponse response = new HttpServletResponse(socket);


            DispatcherServlet dispatcher = DispatcherServlet.getInstance();
            dispatcher.serve(request, response);
            response.response();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}

package com.webserver.core;

import com.webserver.http.HttpServletRequest;
import com.webserver.http.HttpServletResponse;

import java.io.File;

/**
 * Dispatcher：签派员或调度员，是某些组织机构中负责接收和发送可靠的消息、跟踪车辆和设备、以及记录其他重要信息的一个或几个重要的人员。
 * 在公共服务组织中如警察、消防部门、邮政部门，商业机构中如出租车公司、货运公司及航空公司等，需要签派员整理和传递信息，以协调组织机构整体的活动。
 */
public class DispatcherServlet {

    /*
    单例模式：
    只需要一个当前类的实例。
    如何实现：
    1.私有化构造方法
    2.定义一个静态变量，储存当前类的实例。
    3.getInstance() 静态方法，返回该静态对象。
     */
    private static DispatcherServlet obj;
    private DispatcherServlet() {

    }

    public static DispatcherServlet getInstance() {
        if (obj==null) {
            obj = new DispatcherServlet();
        }
        return obj;
    }
    public void serve(HttpServletRequest request, HttpServletResponse response) {
        //2 处理请求
        String path = request.getUri();
        System.out.println("path:" + path);

        //3 使用HttpServletResponse 发送响应

        File file = new File("./webapps" + path);

        // 如果定位是文件，则 200 OK
        if (file.isFile()) {


        } else { // 不是文件,要么不存在，要么是目录，则 404

            file = new File("./webapps/root/404.html");
            response.setStatusCode(404);
            response.setStatusReason("Not Found");
        }

        response.setEntity(file);


    }
}

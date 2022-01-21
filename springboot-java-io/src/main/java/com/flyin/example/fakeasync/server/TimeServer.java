package com.flyin.example.fakeasync.server;

/**
 * @author 王军
 * @description
 * @date 2022/1/18 15:37
 */
import com.flyin.example.fakeasync.TimeServerHandlerExecutePool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 伪异步式I/O
 * @author Joanna.Yan
 * @date 2017年10月24日上午10:16:10
 */
public class TimeServer {

    public static void main(String[] args) {
        int port=9090;
        if(args!=null&&args.length>0){
            try {
                port=Integer.valueOf(args[0]);
            } catch (Exception e) {
                // 采用默认值
            }
        }

        ServerSocket server=null;
        try {
            server=new ServerSocket(port);
            System.out.println("The time server is start in port :"+ port);
            Socket socket=null;
            //创建一个时间服务器类的线程池
            TimeServerHandlerExecutePool singleExecutor=new
                    TimeServerHandlerExecutePool(50, 10000);//创建I/O任务

            while(true){
                socket=server.accept();
                //当接收到新的客户端连接时，将请求Socket封装成一个Task，然后调用execute方法执行。从而避免了每个请求接入都创建一个新的线程。
                singleExecutor.execute(new TimeServerHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(server!=null){
                try {
                    System.out.println("The time server close");
                    server=null;
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
package com.flyin.example.socket.sync.server;

/**
 * @author 王军
 * @description
 * @date 2022/1/13 17:43
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {

    public static void main(String[] args) {
        int port=9090;

        ServerSocket server=null;

        try {
            server=new ServerSocket(port);
            System.out.println("The time server is start in port:"+port);
            Socket socket=null;
            while(true){//通过一个无限循环来监听客户端的连接
                socket=server.accept();//如果没有客户端接入，则主线程阻塞在ServerSocket的accept操作上。
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(server!=null){
                System.out.println("The time server close");
                try {
                    server.close();
                    server=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
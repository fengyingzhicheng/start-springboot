package com.flyin.example.socket.nio.server;

/**
 * @author 王军
 * @description
 * @date 2022/1/18 16:41
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

        MultiplexerTimeServer timeServer=new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
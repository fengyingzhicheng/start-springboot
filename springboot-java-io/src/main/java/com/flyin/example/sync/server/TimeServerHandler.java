package com.flyin.example.sync.server;

/**
 * @author 王军
 * @description
 * @date 2022/1/13 17:44
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TimeServerHandler implements Runnable{
    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
        System.out.println("connectSocket"+socket);
    }

    @Override
    public void run() {
        BufferedReader in=null;
        PrintWriter out=null;

        try {
            in=new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out=new PrintWriter(this.socket.getOutputStream(), true);
            String currentTime=null;
            String body=null;
            while(true){
                body=in.readLine();
                if(body==null){
                    break;
                }
                System.out.println("The time server receive order:"+body);
                //如果请求消息为查询时间的指令"QUERY TIME ORDER"则获取当前最新的系统时间。
                currentTime="QUERY TIME ORDER".equalsIgnoreCase(body) ?
                        new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
                out.println(currentTime);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                out.close();
                out=null;
            }
            if(this.socket!=null){
                try {
                    this.socket.close();
                    this.socket=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
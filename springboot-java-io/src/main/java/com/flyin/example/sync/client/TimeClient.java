package com.flyin.example.sync.client;

/**
 * @author 王军
 * @description
 * @date 2022/1/13 17:45
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient {
    public static void main(String[] args) {
        new Thread(() -> connectServer()).start();
    }


    public static void connectServer() {
        Socket socket=null;
        BufferedReader in=null;
        PrintWriter out=null;

        try {
            socket=new Socket("127.0.0.1", 9090);
            System.out.println("clientSock"+socket);

            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(socket.getOutputStream(),true);
            Thread.sleep(5000);
            out.println("QUERY TIME ORDER");
            System.out.println("Send order 2 server succeed.");
            String resp=in.readLine();
            System.out.println("Now is:"+resp);

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        } finally{
            if(out!=null){
                out.close();
                out=null;
            }
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in=null;
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket=null;
            }
        }
    }
}
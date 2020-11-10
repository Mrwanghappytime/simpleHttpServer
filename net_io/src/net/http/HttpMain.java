package net.http;


import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpMain {
    HttpServer httpServer;

    public HttpMain(HttpServer httpServer) {
        this.httpServer = httpServer;
    }

    public HttpMain() {
    }
    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer();
        httpServer.initServer();
        Socket socket = httpServer.startServer();
        byte[] bytes = new byte[1024*2];
        if(socket == null){
            return;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new DataInputStream(socket.getInputStream()));
            bufferedInputStream.read(bytes);
            BufferedOutputStream outputStream = new BufferedOutputStream(new DataOutputStream(socket.getOutputStream()));
            System.out.println(new String(bytes));
            HttpRequestPacket httpRequestPacket = new HttpRequestPacket();
            if(HttpUtils.parseStringToHttpPacket(httpRequestPacket,new String(bytes))){
                System.out.println(httpRequestPacket);
                HttpResponsePacket httpResponsePacket = new HttpResponsePacket();
                try {
                    HttpUtils.packedHttpResponsePacket(httpResponsePacket,httpRequestPacket);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                System.out.println(httpResponsePacket.toString());
                System.out.println(httpResponsePacket.parsePacketToString());
                httpResponsePacket.setBody("{status:ok}");
                outputStream.write(httpResponsePacket.parsePacketToString().getBytes());
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

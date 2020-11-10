package net.http;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public int port;
    public int maxLog = 10;
    public String addr;
    public final static String config = "web.txt";
    public HttpServer() {
    }

    public HttpServer(int port, int maxLog, String addr) {
        this.port = port;
        this.maxLog = maxLog;
        this.addr = addr;
    }

    public HttpServer(int port, String addr) {
        this.port = port;
        this.addr = addr;
    }
    public void initServer(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("web.txt"));
            String s;
            while((s=bufferedReader.readLine()) != null){
                parseStringtoSub(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void parseStringtoSub(String s){
        if(s.indexOf("ip")!=-1){
            this.addr = s.substring(3);
        }else if(s.indexOf("port")!=-1){
            this.port = Integer.valueOf(s.substring(5));
        }else if(s.indexOf("maxconncet")!=-1){
            this.maxLog = Integer.valueOf(s.substring(11));
        }
    }
    public Socket startServer(){
        ServerSocket serverSocket = null;
        try {
             serverSocket = new ServerSocket(this.port,this.maxLog,InetAddress.getByName(this.addr));
             Socket socket = serverSocket.accept();
             return socket;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

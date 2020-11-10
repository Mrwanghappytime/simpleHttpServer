package net.http;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class HttpServetGet {
    public void hello(HttpResponsePacket httpResponsePacket,HttpRequestPacket httpRequestPacket){
        System.out.println("printf hello");
        try {
            httpResponsePacket.body = "";
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("hello.html"),"utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String s;
            while((s = bufferedReader.readLine()) != null){
                httpResponsePacket.body += s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HttpServetGet() {
    }
}

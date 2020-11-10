package net.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public String host = "localhost";
    public int port = 8189;

    public ChatClient() {
    }

    public ChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void chat() {
        Socket socket = null;
        try {
            socket = new Socket(host,port);

             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             Scanner scanner = new Scanner(System.in);
             while(true){
                String send = scanner.nextLine();
                out.writeUTF("客户端" + send);
                String accept = in.readUTF();
                System.out.println("接受到信息" + accept);
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

    public static void main(String[] args) {
        new ChatClient().chat();
    }
}

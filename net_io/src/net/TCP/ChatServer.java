package net.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    private  int port = 8189;

    public ChatServer(int port) {
        this.port = port;
    }

    public ChatServer() {
    }
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out  = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String accpet = in.readUTF();// 读取来自客户端的信息
            System.out.println(accpet);//输出来自客户端的信息
            String send = scanner.nextLine();//nextLine方式接受字符串
            System.out.println("服务器：" + send);//输出提示信息
            out.writeUTF("服务器：" + send);//把服务器端的输入发给客户端
        }
    }

    public static void main(String[] args) throws IOException {
        new ChatServer().server();
    }
}

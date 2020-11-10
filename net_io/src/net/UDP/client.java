package net.UDP;

import java.io.IOException;
import java.net.*;

public class client {
    public String ip;
    public int port = 8888;

    public client() {
    }

    public client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public client(String ip) {
        this.ip = ip;
    }
    public void cli() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(port, InetAddress.getByName("localhost"));
        datagramSocket.send(new DatagramPacket("aaaa".getBytes(),"aaaa".getBytes().length,
                InetAddress.getByName("localhost"),8081));
        datagramSocket.close();
    }

    public static void main(String[] args) throws IOException {
        new client().cli();
    }
}

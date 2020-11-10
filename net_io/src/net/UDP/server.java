package net.UDP;



import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class server {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8081);
        byte[] bytes = new byte[50];
        DatagramPacket datagramPacket = new DatagramPacket(bytes,50);
        datagramSocket.receive(datagramPacket);
        System.out.println(new String(datagramPacket.getData()) + datagramPacket.getLength() + datagramPacket.getAddress() + datagramPacket.getPort());
        datagramSocket.close();
    }


}

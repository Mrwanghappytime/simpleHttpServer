package io.inputstream;

import java.io.*;

public class TestBufferedStream {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new BufferedInputStream(new FileInputStream("222.png"));
        byte[] bytes = new byte[1024*1024];
        inputStream.read(bytes);
        String s = new String(bytes);
        System.out.println(s);
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("333.png"));
        outputStream.write(s.getBytes());
    }
}

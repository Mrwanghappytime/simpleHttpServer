package io.inputstream;

import java.io.*;

public class TestFileInputStream {
    public static void main(String[] args) throws IOException {
        InputStream stream = new FileInputStream("C:\\Users\\汪浩锋\\Desktop\\vhr\\vhr\\jav\\src\\io\\inputstream\\111.png");
        byte[] bytes = new byte[1024];
        FileOutputStream fileOutputStream = new FileOutputStream("222.png");
        while(stream.read(bytes) != -1){
            fileOutputStream.write(bytes);
        }
    }
}

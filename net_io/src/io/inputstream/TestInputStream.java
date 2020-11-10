package io.inputstream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestInputStream {
    public static void main(String[] args) throws IOException {
        String s = "string";
        byte[] bytes = s.getBytes();
        InputStream stream = new ByteArrayInputStream(bytes);
        byte[] bytes1 = new byte[20];
        stream.read(bytes1);
        System.out.println(bytes1.toString());
    }
}

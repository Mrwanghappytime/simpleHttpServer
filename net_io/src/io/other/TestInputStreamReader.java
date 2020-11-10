package io.other;

import sun.text.normalizer.UTF16;

import java.io.*;
import java.nio.charset.Charset;

public class TestInputStreamReader {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("student.txt"), "gbk");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s ;
        while((s = bufferedReader.readLine())!=null) {
            System.out.println(s);
        }
    }
}

package io.other;

import java.io.*;

public class TestOutputStreamWrute {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter streamWriter = new OutputStreamWriter(new FileOutputStream("Student.txt",true),"UTF-8");
        streamWriter.write("ddddddd");
        streamWriter.flush();
        streamWriter.close();

    }
}

package io.inputstream;

import java.io.*;

public class TestObjectStream {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Student.txt"));
        objectOutputStream.writeObject(new Student(1,1,1,"111"));
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Student.txt"));
        Student student = (Student) inputStream.readObject();
        System.out.println(student);
    }
}

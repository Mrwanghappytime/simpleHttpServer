package io.inputstream;

import java.io.Serializable;

public class Student implements Serializable {
    private int a;
    private int b;
    private int c;
    private String d;

    public Student(int a, int b, int c, String d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "Student{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d='" + d + '\'' +
                '}';
    }
}

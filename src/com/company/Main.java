package com.company;

public class Main {
    public static void main(String[] args) {
        ExpressionTree e = new ExpressionTree("/*+34-52+6*35");
        System.out.println(e.evaluate());
    }
}

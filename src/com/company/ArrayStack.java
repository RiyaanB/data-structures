package com.company;

public class ArrayStack{
    int[] stack;
    int top;
    public ArrayStack(int sz){
        stack = new int[sz];
        top = -1;
    }
    public int peak()
    {
        if (top == -1)
            throw new ArrayIndexOutOfBoundsException();
        return stack[top];
    }
    public boolean push(int data)
    {
        if (top == stack.length)
            return false;
        stack[++top] = data;
        return true;
    }
    public int pull()
    {
        if (top == -1)
            throw new ArrayIndexOutOfBoundsException();
        return stack[top--];
    }
    public String toString()
    {
        String s = "";
        for(int i = top; i >= 0;i--)
            s += stack[i] + " ";
        return s;
    }
}

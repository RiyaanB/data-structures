package com.company;


public class CircularQueue {
    int count;
    int rear;
    int front;
    int[] queue;
    public CircularQueue(int size) {
        queue = new int[size];
        count = 0;
        rear = -1;
        front = -1;
    }
    public boolean insert(int data){
        if(count == queue.length)
            return false;
        count++;
        queue[++rear] = data;
        return true;
    }
    public int delete()
    {
        count--;
        if (count == -1)
            throw new ArrayIndexOutOfBoundsException();
        return queue[++front];
    }
}

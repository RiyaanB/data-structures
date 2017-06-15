package com.company;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.setAdj(0,1);
        g.setAdj(0,2);
        g.setAdj(0,6);
        g.setAdj(1,0);
        g.setAdj(1,3);
        g.setAdj(1,6);
        g.setAdj(2,0);
        g.setAdj(2,4);
        g.setAdj(2,6);
        g.setAdj(3,1);
        g.setAdj(3,5);
        g.setAdj(3,6);
        g.setAdj(4,2);
        g.setAdj(4,5);
        g.setAdj(4,6);
        g.setAdj(5,3);
        g.setAdj(5,4);
        g.setAdj(5,6);
        g.setAdj(6,0);
        g.setAdj(6,1);
        g.setAdj(6,2);
        g.setAdj(6,3);
        g.setAdj(6,4);
        g.setAdj(6,5);
        g.bfs();
    }
}

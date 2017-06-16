package com.company;

public class Main {
    public static void main(String[] args) {
        WeightedGraph g = new WeightedGraph(7);
        g.setAdj(0,1,8);
        g.setAdj(0,3,5);
        g.setAdj(0,6,2);
        g.setAdj(1,0,8);
        g.setAdj(1,2,7);
        g.setAdj(1,6,3);
        g.setAdj(2,1,7);
        g.setAdj(2,4,8);
        g.setAdj(2,5,2);
        g.setAdj(2,6,9);
        g.setAdj(3,0,5);
        g.setAdj(3,4,4);
        g.setAdj(3,6,6);
        g.setAdj(4,3,4);
        g.setAdj(4,5,5);
        g.setAdj(4,6,7);
        g.setAdj(5,2,2);
        g.setAdj(5,4,5);
        g.setAdj(5,6,3);
        g.setAdj(6,0,2);
        g.setAdj(6,1,3);
        g.setAdj(6,2,9);
        g.setAdj(6,3,6);
        g.setAdj(6,4,7);
        g.setAdj(6,5,3);
        g.dijkstra(0);
    }
}

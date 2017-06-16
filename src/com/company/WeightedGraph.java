package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class WeightedGraph{
    int[][] adj;
    final static int INF=10000;
    public WeightedGraph(int n){
        adj = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                adj[i][j] = INF;
        }
    }
    public void setAdj(int i, int j, int weight){
        adj[i][j] = weight;
    }
    public void dfs(){
        boolean[] visited = new boolean[adj.length];
        dfs(0,visited);
        System.out.println();
    }
    private void dfs(int i, boolean[] visited){
        visited[i] = true;
        System.out.print(i + " ");
        int[] adjacent = adj[i];
        for(int j = 0; j < adjacent.length; j++){
            if(!visited[j])
                dfs(j,visited);
        }
    }
    public void bfs(){
        Queue<Integer> toVisit = new Queue<Integer>();
        boolean[] visited = new boolean[adj.length];
        toVisit.insert(0);
        while (!toVisit.isEmpty()){
            int j = toVisit.delete();
            if(!visited[j]) {
                System.out.println(j);
                visited[j] = true;
                for (int i = 0; i < adj[j].length; i++) {
                    if(adj[j][i] != -1)
                        toVisit.insert(i);
                }
            }
        }
    }
    public void prims() {
        for(int[] m:adj){
            System.out.println(Arrays.toString(m));
        }
        boolean[] settled = new boolean[adj.length];
        int[] distance = new int[adj.length];
        for (int i = 0; i < distance.length; i++)
            distance[i] = INF;
        int[] path = new int[adj.length];
        int start=0;
        distance[start] = 0;
        settled[start]=true;
        for (int i = 0; i < adj.length; i++) {
            for(int j = 0; j < adj.length; j++) {
                if( distance[j] > adj[start][j]&& !settled[j]){
                    distance[j] = adj[start][j];
                    path[j] = start;
                }
            }

            int min = INF;
            int minLoc = start;

            for(int j = 0; j < adj.length; j++) {
                if(distance[j] < min && !settled[j]){
                    min = distance[j];
                    minLoc = j;
                }
            }
            start = minLoc;
            settled[minLoc] = true;
        }
        for (int i : distance)
            System.out.print(i + " ");
        System.out.println();
        for (int i : path)
            System.out.print(i + " ");
        System.out.println();
    }

    public void dijkstra(int start){
        for(int[] m:adj){
            System.out.println(Arrays.toString(m));
        }
        boolean[] settled = new boolean[adj.length];
        int[] distance = new int[adj.length];
        for (int i = 0; i < distance.length; i++)
            distance[i] = INF;
        int[] path = new int[adj.length];
        distance[start] = 0;
        settled[start]=true;
        for (int i = 0; i < adj.length; i++) {
            for(int j = 0; j < adj.length; j++) {
                if( distance[j] > adj[start][j]&& !settled[j]){
                    if(distance[j] == INF)
                        distance[j] = adj[start][j];
                    else
                        distance[j] += adj[start][j];
                    path[j] = start;
                }
            }
            int min = INF;
            int minLoc = start;
            for(int j = 0; j < adj.length; j++) {
                if(distance[j] < min && !settled[j]){
                    min = distance[j];
                    minLoc = j;
                }
            }
            start = minLoc;
            settled[minLoc] = true;
        }
        for (int i : distance)
            System.out.print(i + " ");
        System.out.println();
        for (int i : path)
            System.out.print(i + " ");
        System.out.println();
    }
}
package com.company;

public class WeightedGraph {

    int[][] adj;
    public WeightedGraph(int n){
        adj = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                adj[i][j] = -1;
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
    public void prims(){
        int[] distance = new int[adj.length];
        for(int i = 0; i < distance.length; i++)
            distance[i] = 100000;
        int[] path = new int[adj.length];
        for(int i = 0; i < adj.length; i++){
            for(int j = 0; j < adj.length; j++){
                if(adj[i][j] != -1 && adj[i][j] < distance[j]){
                    distance[j] = adj[i][j];
                    path[j] = i;
                }
            }
        }
        for(int i:distance)
            System.out.print(i);
        System.out.println();
        for(int i:path)
            System.out.print(i);
        System.out.println();
    }
}
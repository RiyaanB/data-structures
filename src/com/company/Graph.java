package com.company;

public class Graph {
    boolean[][] adj;
    public Graph(){}
    public Graph(int n){
        adj = new boolean[n][n];
    }
    public void setAdj(int i,int j){
        adj[i][j]=true;
    }
    public void dfs(){
        boolean[] visited = new boolean[adj.length];
        dfs(0,visited);
        System.out.println();
    }
    private void dfs(int i, boolean[] visited){
        visited[i] = true;
        System.out.print(i + " ");
        boolean[] adjacent = adj[i];
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
                    if(adj[j][i])
                        toVisit.insert(i);
                }
            }
        }
    }
}

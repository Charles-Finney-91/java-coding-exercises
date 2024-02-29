package org.charles.coding.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class UndirectedGraph {
    public static void main(String[] args) {
        // 0 ------ 1
        // |        |
        // |        |
        // 3 ------ 2
//        UndirectedGraphMatrix matrix = new UndirectedGraphMatrix(4);
//        matrix.addEdges(0,1);
//        matrix.addEdges(1,2);
//        matrix.addEdges(2,3);
//        matrix.addEdges(3,0);
//        System.out.println("Edges: " + matrix.getEdges());
//        System.out.println(matrix);

        // 0 ------ 1
        // |        |
        // |        |
        // 2 ------ 3 ------ 4
        UndirectedGraphLinkedList ll = new UndirectedGraphLinkedList(5);
        ll.addEdge(0,1);
        ll.addEdge(0,2);
        ll.addEdge(1,3);
        ll.addEdge(2,3);
        ll.addEdge(3,4);
        System.out.println(ll);

        ll.traverseThroughGraph(GraphTraversalType.DFS_RECURSIVE);
    }
}

class UndirectedGraphMatrix{
    private int vertices;
    private int edges;
    private final int[][] adjacencyMatrix;

    public UndirectedGraphMatrix(int vertices) {
        edges = 0;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdges(int i, int j){
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
        edges++;
    }

    public int getEdges() {
        return edges;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            sb.append(i).append(": ");
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                sb.append(adjacencyMatrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

class UndirectedGraphLinkedList{
    private final int vertices;
    private final int edges;
    private final LinkedList<Integer>[] adjacentLL;

    public UndirectedGraphLinkedList(int vertices) {
        this.vertices = vertices;
        this.edges = 0;
        adjacentLL = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacentLL[i] = new LinkedList<>();
        }
    }

    public void addEdge(int from, int to){
        adjacentLL[from].add(to);
        adjacentLL[to].add(from);
    }
    public int getVertices() {
        return vertices;
    }

    public int getEdges() {
        return edges;
    }

    public LinkedList<Integer>[] getAdjacentLL() {
        return adjacentLL;
    }

    public void traverseThroughGraph(GraphTraversalType traversalType){
        if (traversalType.equals(GraphTraversalType.BFS))
            breadthFirstTraversal();
        else if(traversalType.equals(GraphTraversalType.DFS))
            depthFirstTraversal();
        else
            dfsRecursive();
    }

    private void breadthFirstTraversal() {
        // Using this to have the state of vertices visited
        boolean[] visited = new boolean[this.vertices];

        // Using this to load multiple vertices attached to one vertice
        // so that we can process them one by one
        Queue<Integer> queue = new LinkedList<>();

        // Setting up the first vertice visit
        queue.offer(0);
        visited[0] = true;

        // traversing through the queue to visit all other vertices
        while(!queue.isEmpty()){
            int visitedVertice = queue.poll();
            System.out.print(visitedVertice + " ");
            for (int i = 0; i < adjacentLL[visitedVertice].size(); i++) {
                int v = adjacentLL[visitedVertice].get(i);
                if (!visited[v]){
                    // Adding non visited vertices to the queue for next traversal
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }

    private void depthFirstTraversal(){
        // Using this to have the state of vertices visited
        boolean[] visited = new boolean[this.vertices];

        // Using this to load multiple vertices attached to one vertice
        // so that we can process them one by one
        Stack<Integer> stack = new Stack<>();

        // Loading the initial vertice
        stack.push(0);
        visited[0] = true;

        // traversing through the queue to visit all other vertices
        while(!stack.isEmpty()){
            int verticeVisited = stack.pop();
            System.out.print(verticeVisited + " ");
            for (Integer connectedVertice : adjacentLL[verticeVisited]) {
                if (!visited[connectedVertice]) {
                    stack.push(connectedVertice);
                    visited[connectedVertice] = true;
                }
            }
        }

    }

    private void dfsRecursive(){
        // Using this to have the state of vertices visited
        boolean[] visited = new boolean[this.vertices];

        // Traversing through all the vertices
        for (int i = 0; i < this.vertices; i++) {
            if(!visited[i])
                dfs(i, visited);
        }
    }

    private void dfs(int i, boolean[] visited) {
        visited[i] = true;
        System.out.print(i + " ");
        for (Integer connectedVertice : adjacentLL[i]) {
            if (!visited[connectedVertice])
                dfs(connectedVertice, visited);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < adjacentLL.length; i++) {
            sb.append(i).append(": ");
            for (int j = 0; j < adjacentLL[i].size(); j++) {
                sb.append(adjacentLL[i].get(j)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

enum GraphTraversalType{
    BFS,
    DFS,
    DFS_RECURSIVE;
    GraphTraversalType() {
    }
}

package adjacencymatrix;

import java.util.Stack;
import queue.Queue;
import queue.ArrayQueue;

/**
 * A directed graph represented using an adjacency matrix.
 * If adjacencyMatrix[i][j] is 1, then there is an edge that goes from i to j.
 */
public class Graph {
    private int[][] adjacencyMatrix;

    /**
     * Constructor
     * @param n number of nodes
     */
    public Graph(int n) {
        adjacencyMatrix = new int[n][n];
    }

    /** Add an edge from node n1 to node n2
     *
     * @param n1 node n1
     * @param n2 node n2
     */
    public void addEdge(int n1, int n2) {
        adjacencyMatrix[n1][n2] = 1;
    }

    /** A helper method for dfsMain - runs DFS once from the given source vertex
     *
     * @param vertex source vertex
     * @param visited an array, where for each vertex id we store true if it has been visited,
     * and false otherwise
     */
    public void dfs(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println(vertex);
        for (int j = 0; j < adjacencyMatrix.length; j++) {
            if (adjacencyMatrix[vertex][j] == 1 && !visited[j])
                dfs(j,visited);
        }
    }

    /**
     * Iterative DFS implementation that uses a stack.
     * @param vertex source vertex
     * @param visited array that stores true for each vertex id that was visited during DFS
     */
    public void dfsWithStack(int vertex, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);
        while (!stack.isEmpty()) {
            int currVertex = stack.pop();
            System.out.println(currVertex);
            // check if currVertex has been visited
            // Go over neighbors

        }

    }


    /** Runs dfs starting from each vertex that has not been visited.
     * Makes sure all vertices are visited (may involve running dfs several times).
     * If the graph is connected, it would be enough to run dfs once.
     */
    public void dfsMain() {
        boolean visited[]  = new boolean[adjacencyMatrix.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                dfs(i, visited);
                // dfsWithStack(i, visited); // instead of calling recursive dfs, we could call dfsWithStack
        }
    }

    /**
     * Run BFS from a given vertex
     * @param vertex source vertex
     * @param visited boolean array that for each vertex id stores true if it has been visited
     */
    void bfs(int vertex, boolean visited[]) {
        Queue queue = new ArrayQueue(10);
        queue.enqueue(vertex);
        visited[vertex] = true;
        System.out.println(vertex);
        while (!queue.empty()) {
            // FILL IN CODE: dequeue and go over neighbors


        } // white queue is not empty
    }


    /** Runs BFS starting from every vertex that has not been visited.
     *
     */
    public void bfsMain() {
        boolean visited[]  = new boolean[adjacencyMatrix.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                bfs(i, visited);
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph(6); // 5 nodes
        graph.addEdge(0, 1);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(1, 4);
        graph.addEdge(5, 3);
        /**

         0 ------- 1------>4
         |
         |
         |
         2---------------->3<--- 5
         */

        // graph.dfsMain();
        // graph.bfsMain();

    }
}


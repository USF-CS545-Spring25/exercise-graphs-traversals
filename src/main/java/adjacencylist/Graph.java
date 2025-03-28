package adjacencylist;

import java.util.Arrays;
import java.util.Stack;
import queue.ArrayQueue;
import queue.Queue;

public class Graph {
    private Edge[] graph; // adjacency list for this graph
    private int timeCounter = 0; // counter to use in the discovery/finish time computation

    public static class Edge {
        private int neighbor; // id of the neighbor (id of the destination node)
        private Edge next; // reference to the next outgoing "edge"

        public Edge(int neighbor) {
            this.neighbor = neighbor;
            next = null;
        }
    }

    public Graph(int numVertices) {
        graph = new Edge[numVertices];
    }

    /**
     * Adds the given edge as an outgoing edge for the given vertex.
     * Modifies the adjacency list.
     *
     * @param vertexId id of the vertex
     * @param edge     outgoing edge
     *                 Do not modify.
     */
    public void addEdge(int vertexId, Edge edge) {
        Edge head = graph[vertexId]; // head of the linked list for this  node
        // insert in front
        edge.next = head;
        graph[vertexId] = edge;
    }


    /** A helper method for dfsMain - runs DFS once from the given source vertex
     *
     * @param vertex source vertex
     * @param visited an array, where for each vertex id we store true if it has been visited,
     * and false otherwise
     */
    public void dfs(int vertex, boolean[] visited) {
        // TODO: where can we print that we are backtracking?
        visited[vertex] = true;
        System.out.println(vertex);
        Edge curr = graph[vertex];
        while (curr != null) {
            if (!visited[curr.neighbor]) {
                dfs(curr.neighbor, visited);
            }
            curr = curr.next;
        }
    }

    /**
     * Iterative DFS implementation that uses a stack.
     * @param vertex source vertex
     * @param visited array that stores true for each vertex id that has been visited, and false otherwise
     */
    public void dfsWithStack(int vertex, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex); // push the source vertex onto the stack

        while (!stack.isEmpty()) {
            // FILL IN CODE
            // pop the vertex nextV from the stack,
            // if it's not visited:
                // mark it as visited
                // print
                // iterate over the neighbors
                // push neighbor onto the stack

         // TODO: If we want to print where we backtrack, how do we do it?
        }
    }


    /** Runs dfs starting from each vertex that has not been visited.
     * Makes sure all vertices are visited (may involve running dfs several times).
     * If the graph is connected, it would be enough to run dfs once.
     */
    public void dfsMain() {
        boolean visited[]  = new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                dfs(i, visited);
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
        boolean visited[]  = new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                bfs(i, visited);
        }
    }


    /**
     * Return true if there is a path between source and target
     * @param source starting vertex
     * @param target destination vertex
     * @param visited visited[i] stores true if the vertex i has been visited
     * @return true if there is a path, false othewise
     */
    boolean hasPath(int source, int target, boolean[] visited) {
        // FILL IN CODE

        return false;
    }

    /**
     * A public method that is called to check if there is a path from source to target
     * @param source vertex where we start the path
     * @param target target vertex
     * @return true if there is a path, false otherwise
     */
    public boolean hasPathMain(int source, int target) {
        boolean[] visited = new boolean[graph.length];
        return hasPath(source, target, visited);
    }


    /**
     * DFS implementation that also computes discovery and finish times
     * @param vertex source vertex
     * @param visited array that stores true for each vertex id that has been visited, and false otherwise
     * @param discovery array of "discovery" times when each vertex is visited
     * @param finish  array of "finish" times (when we are done with each vertex because we explored all of its neighbors)
     */
    public void dfsWithDiscoverFinishTimes(int vertex, boolean[] visited, int[] discovery, int[] finish) {
        visited[vertex] = true;
        // FILL IN CODE: update discovery and finish time for vertex

        Edge curr = graph[vertex];
        while (curr != null) {
            if (!visited[curr.neighbor]) {
                dfsWithDiscoverFinishTimes(curr.neighbor, visited, discovery, finish);
            }
            curr = curr.next;
        }

    }


    /** Computes the arrays of discovery and finish times
     * @return array of finish times, that may be used by some other algorithms
     */
    public int[] dfsMainWithDiscoverFinishTimes() {
        boolean visited[]  = new boolean[graph.length];
        int discovery[]  = new int[graph.length];
        int finish[]  = new int[graph.length];

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                dfsWithDiscoverFinishTimes(i, visited, discovery, finish);
        }
        for (int i = 0; i < discovery.length; i++) {
            System.out.println(i + ", d: " + discovery[i] + " f: " + finish[i]);
        }
        return finish;
    }

    public static void main(String[] args) {
        Graph g = new Graph(8);

        // edges going out of vertex 1
        Edge edge10 = new Edge(0);
        Edge edge12 = new Edge(2);
        g.addEdge(1, edge10);
        g.addEdge(1, edge12);

        // edge going out of 0
        Edge edge05 = new Edge(5);
        g.addEdge(0, edge05);

        //edge going out of 2
        Edge edge26 = new Edge(6);
        g.addEdge(2, edge26);

        // edges going out of 5
        Edge edge54 = new Edge(4);
        Edge edge56 = new Edge(6);
        g.addEdge(5, edge54);
        g.addEdge(5, edge56);

        // edge going out of 6
        Edge edge67 = new Edge(7);
        g.addEdge(6, edge67);

        //edge going out of 4
        Edge edge47 = new Edge(7);
        g.addEdge(4, edge47);

        // edge going out of 7
        Edge edge75 = new Edge(5);
        g.addEdge(7, edge75);

        //g.dfsMain();
        //g.bfsMain();
        // System.out.println(g.hasPathMain(1, 5));

        // System.out.println(Arrays.toString(g.dfsMainWithDiscoverFinishTimes()));
    }
}




package grafalgoritmer;

import java.util.*;

import grafalgoritmer.EdgeListGraph;

public class GraphAlgortihms {


    /**
     * Returnerer en liste af grafens knuder fundet ved et dybddeførst gennemløb af
     * grafen med startknude v.
     */

    public static <V> List<V> dfs(Graph<V> graph, V v) {
        return dfsHelper(graph, v, new ArrayList<>());
    }

    private static <V> List<V> dfsHelper(Graph<V> graph, V v, List<V> visitedNodes) {
        visitedNodes.add(v);

        for (V node : graph.neighbors(v)) {
            if (!visitedNodes.contains(node)) {
                dfsHelper(graph, node, visitedNodes);
            }
        }
        return visitedNodes;
    }

    public static void main(String[] args)
    {
        EdgeListGraph<Integer> graph = new EdgeListGraph<>();

        graph.addVertex(123);
        graph.addVertex(38);
        graph.addVertex(15);
        graph.addVertex(6);
        graph.addVertex(66);

        graph.addEdge(123,38,55);
        graph.addEdge(123,66,76);
        graph.addEdge(123,6,7);

        graph.addEdge(38,15,10);
        graph.addEdge(38,66,2);

        graph.addEdge(66,6,8);
        graph.addEdge(66,15,90);

        graph.addEdge(15,6,23);

        System.out.println(dfs(graph,123));
        System.out.println(bfs(graph, 123));
        System.out.println(connected(graph));
        System.out.println(mst(graph));
    }

    /**
     * Returnerer en liste af grafens knuder fundet ved et breddeførst gennemløb af
     * grafen med startknude v.
     */
    public static <V> List<V> bfs(Graph<V> graph, V start) {
        List<V> visitedNodes = new ArrayList<>();
        Queue<V> queue = new LinkedList<>();
        Set<V> seen = new HashSet<>();

        queue.add(start);
        seen.add(start);

        while (!queue.isEmpty()) {
            V node = queue.poll();
            visitedNodes.add(node);

            for (V neighbor : graph.neighbors(node)) {
                if (!seen.contains(neighbor)) {

                    queue.add(neighbor);
                    seen.add(neighbor);
                }
            }
        }

        return visitedNodes;
    }
    /**
     * Returnerer om grafen er sammenhængende
     * Pre: grafen er ikke tom
     */
    public static <V> boolean connected(Graph<V> graph) {
        if (graph.numVertices() == 0) {
            System.out.println("No nodes in graph");
            return false;

        }
        V start = graph.vertices().iterator().next();
        List<V> visitedNodes = bfs(graph, start);
        return visitedNodes.size() == graph.numVertices();
    }

    /**
     * Returnerer om der er en vej fra v1 til v2 i graph
     */
    public static <V> boolean isPath(Graph<V> graph, V v1, V v2) {
        if (bfs(graph, v1).contains(v2))
        {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Returnerer en mængde af grafens kanter der udgør det letteste udspændende træ for grafen.
     * Grafen er en simpel vægtet graf
     */


    private static class DisjointSet<V> {
        private final Map<V, V> parent = new HashMap<>();
        private final Map<V, Integer> rank = new HashMap<>();

        public void makeSet(V v) {
            parent.put(v, v);
            rank.put(v, 0);
        }

        public V find(V v) {
            if (!v.equals(parent.get(v))) {
                parent.put(v, find(parent.get(v)));
            }
            return parent.get(v);
        }

        public void union(V v1, V v2) {
            V root1 = find(v1);
            V root2 = find(v2);

            if (!root1.equals(root2)) {
                if (rank.get(root1) > rank.get(root2)) {
                    parent.put(root2, root1);
                } else if (rank.get(root1) < rank.get(root2)) {
                    parent.put(root1, root2);
                } else {
                    parent.put(root2, root1);
                    rank.put(root1, rank.get(root1) + 1);
                }
            }
        }

        public boolean connected(V v1, V v2) {
            return find(v1).equals(find(v2));
        }
    }

    public static <V> Set<Edge<V>> mst(Graph<V> graph) {
        Set<Edge<V>> mstEdges = new HashSet<>();
        PriorityQueue<Edge<V>> edgeQueue = new PriorityQueue<>(graph.edges());
        DisjointSet<V> disjointSet = new DisjointSet<>();

        for (V vertex : graph.vertices()) {
            disjointSet.makeSet(vertex);
        }

        while (mstEdges.size() < graph.numVertices() - 1 && !edgeQueue.isEmpty()) {
            Edge<V> edge = edgeQueue.poll();
            V u = edge.getU();
            V v = edge.getV();

            if (!disjointSet.connected(u, v)) {
                mstEdges.add(edge);
                disjointSet.union(u, v);
            }
        }
        return mstEdges;
    }

}

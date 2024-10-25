package graphimplementationStuderende;

public class App {

    public static void main(String[] args) {
        EdgeListGraph<Integer> graph = new EdgeListGraph<>();

        // Add vertices
        graph.addVertex(15);
        graph.addVertex(6);
        graph.addVertex(66);
        graph.addVertex(123);
        graph.addVertex(38);

        graph.addEdge(15, 6, 23);
        graph.addEdge(15, 38, 10);
        graph.addEdge(15, 66, 90);
        graph.addEdge(6, 66, 8);
        graph.addEdge(6, 123, 7);
        graph.addEdge(38, 123, 55);
        graph.addEdge(38, 66, 2);
        graph.addEdge(66, 123, 76);

        System.out.println("Graph before removal:");
        graph.printGraph();

        System.out.println("\nRemoving edge between 15 and 66:");
        graph.removeEdge(15, 66);
        graph.printGraph();

        System.out.println("\nRemoving vertex 38:");
        graph.removeVertex(38);
        graph.printGraph();

        System.out.println("\nTrying to remove edge between 15 and 66 again:");
        graph.removeEdge(15, 66);
        graph.printGraph();

        System.out.println("\nTrying to remove vertex 38 again:");
        graph.removeVertex(38);
        graph.printGraph();

        graph.areAdjacent(6,123);
    }
}
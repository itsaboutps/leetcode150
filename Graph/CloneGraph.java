package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CloneGraph {
    public static void main(String[] args) {
        // Step 1: Create a test graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // Establish connections (undirected graph)
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Step 2: Clone the graph
        CloneGraphSolution solution = new CloneGraphSolution();
        Node clonedGraph = solution.cloneGraph(node1);

        // Step 3: Print the original and cloned graphs
        System.out.println("Original Graph:");
        printGraph(node1, new HashSet<>());

        System.out.println("\nCloned Graph:");
        printGraph(clonedGraph, new HashSet<>());

    }

    // Helper function to print a graph
    private static void printGraph(Node node, Set<Node> visited) {
        if (node == null || visited.contains(node))
            return;

        visited.add(node);
        System.out.print("Node " + node.val + " -> ");
        for (Node neighbor : node.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();

        for (Node neighbor : node.neighbors) {
            printGraph(neighbor, visited);
        }
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class CloneGraphSolution {

    public Node cloneGraph(Node node) {
        HashMap<Node, Node> oldToNew = new HashMap<>();

        return dfs(node, oldToNew);
    }

    private Node dfs(Node node, Map<Node, Node> oldToNew) {
        if (node == null) {
            return null;
        }
        if (oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }

        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        for (Node neighbour : node.neighbors) {
            copy.neighbors.add(dfs(neighbour, oldToNew));

        }
        return copy;

    }
}
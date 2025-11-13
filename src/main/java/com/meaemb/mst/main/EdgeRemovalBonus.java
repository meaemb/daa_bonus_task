package com.meaemb.mst.main;

import com.meaemb.mst.algorithms.KruskalMST;
import com.meaemb.mst.model.Edge;
import com.meaemb.mst.model.Graph;
import com.meaemb.mst.model.MSTResult;
import com.meaemb.mst.unionfind.UnionFind;

import java.util.*;

public class EdgeRemovalBonus {

    public static void main(String[] args) {
        Graph graph = new Graph();

        // add graph nodes
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        // add graph edges
        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 1);
        graph.addEdge("B", "D", 4);
        graph.addEdge("C", "D", 2);
        graph.addEdge("C", "E", 5);
        graph.addEdge("D", "E", 1);

        // build the MST
        KruskalMST kruskal = new KruskalMST();
        MSTResult mst = kruskal.findMST(graph);

        System.out.println("Original MST:");
        mst.getMstEdges().forEach(System.out::println);
        System.out.println("Total cost = " + mst.getTotalCost());

        // remove one edge from the MST
        Edge removed = mst.getMstEdges().get(0);
        System.out.println("\nRemoved edge: " + removed);

        // we will find the two components formed after removing this edge
        Set<String> component1 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        // start DFS from the first node of the removed edge
        component1.add(removed.getFrom());
        buildComponent(mst.getMstEdges(), removed, removed.getFrom(), component1, visited);

        // all remaining nodes are in the second component
        Set<String> component2 = new HashSet<>(graph.getNodes());
        component2.removeAll(component1);

        System.out.println("\nComponent 1: " + component1);
        System.out.println("Component 2: " + component2);

        // pick the lightest edge that reconnects these two components
        Edge replacement = null;

        for (Edge e : graph.getEdges()) {
            boolean connects =
                    (component1.contains(e.getFrom()) && component2.contains(e.getTo())) ||
                            (component1.contains(e.getTo()) && component2.contains(e.getFrom()));

            if (connects) {
                if (replacement == null || e.getWeight() < replacement.getWeight()) {
                    replacement = e;
                }
            }
        }

        System.out.println("\nReplacement edge found: " + replacement);

        // build the new MST after replacing the removed edge
        List<Edge> newMST = new ArrayList<>(mst.getMstEdges());
        newMST.remove(removed);
        newMST.add(replacement);

        System.out.println("\nNEW MST:");
        newMST.forEach(System.out::println);
    }

    // simple DFS on MST edges to collect all reachable nodes
    private static void buildComponent(List<Edge> mstEdges, Edge removed,
                                       String node, Set<String> component, Set<String> visited) {

        visited.add(node);

        for (Edge e : mstEdges) {
            if (e == removed) continue; // skip the removed edge

            // if the edge connects to the current node, continue DFS
            if (e.getFrom().equals(node) && !visited.contains(e.getTo())) {
                component.add(e.getTo());
                buildComponent(mstEdges, removed, e.getTo(), component, visited);
            }

            if (e.getTo().equals(node) && !visited.contains(e.getFrom())) {
                component.add(e.getFrom());
                buildComponent(mstEdges, removed, e.getFrom(), component, visited);
            }
        }
    }
}

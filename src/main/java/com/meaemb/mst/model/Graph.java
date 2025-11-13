package com.meaemb.mst.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final List<String> nodes;
    private final List<Edge> edges;

    public Graph() {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public void addNode(String node) {
        nodes.add(node);
    }

    public void addEdge(String from, String to, int weight) {
        edges.add(new Edge(from, to, weight));
    }

    public List<String> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }
}

package com.meaemb.mst.model;

import java.util.List;

public class MSTResult {
    private final List<Edge> mstEdges;
    private final int totalCost;

    public MSTResult(List<Edge> mstEdges, int totalCost) {
        this.mstEdges = mstEdges;
        this.totalCost = totalCost;
    }

    public List<Edge> getMstEdges() {
        return mstEdges;
    }

    public int getTotalCost() {
        return totalCost;
    }
}

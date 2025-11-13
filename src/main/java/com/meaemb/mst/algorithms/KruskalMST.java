package com.meaemb.mst.algorithms;

import com.meaemb.mst.model.Edge;
import com.meaemb.mst.model.Graph;
import com.meaemb.mst.model.MSTResult;
import com.meaemb.mst.unionfind.UnionFind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalMST {

    public MSTResult findMST(Graph graph) {
        List<Edge> edges = new ArrayList<>(graph.getEdges());
        List<Edge> mst = new ArrayList<>();

        Collections.sort(edges);

        UnionFind uf = new UnionFind(graph.getNodes());

        int cost = 0;

        for (Edge e : edges) {
            String root1 = uf.find(e.getFrom());
            String root2 = uf.find(e.getTo());

            if (!root1.equals(root2)) {
                uf.union(root1, root2);
                mst.add(e);
                cost += e.getWeight();

                if (mst.size() == graph.getNodes().size() - 1)
                    break;
            }
        }

        return new MSTResult(mst, cost);
    }
}

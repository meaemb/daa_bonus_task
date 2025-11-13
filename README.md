# Edge Removal from an MST (Bonus Task)

This small project shows how to remove an edge from a Minimum Spanning Tree
and then find the best replacement edge to connect the graph back again.

I used Kruskal’s algorithm to build the MST.  
After that, the program removes one MST edge, splits the tree into two parts,
and looks for the lightest edge that connects these two components.

Everything is written in simple Java with Maven.


## How to run

1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Make sure Maven imports automatically (it usually does)
4. Open the file:
   src/main/java/com/meaemb/mst/main/EdgeRemovalBonus.java


5. Press **Run** — the program should start right away

## What the program prints

- the original MST
- which edge was removed
- the two components after removal
- the replacement edge
- the new MST after reconnecting

This makes it easy to see how the MST changes after removing an edge.


## Project structure

src/main/java/com/meaemb/mst/
model/ (Graph, Edge, MSTResult)
algorithms/ (KruskalMST)
unionfind/ (UnionFind structure)
main/ (EdgeRemovalBonus - the main class)


## Notes

The graph is created inside the main class.  
You can change the edges or add your own graph if you want to test different cases.

This project is made for the Bonus Task (5%) of the DAA endterm,
where the goal is to show how to handle MST updates efficiently.
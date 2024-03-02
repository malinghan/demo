package data.graph.table;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-02
 * 临接表表示的图的DFS遍历
 */
public class GraphDfs {
        private LinkedList<Integer>[] adjLists;
        private boolean[] visited;

        // HasDirectionGraph constructor
        // vertices: 一共有多少个顶点数
        public GraphDfs(int vertices) {
            adjLists = new LinkedList[vertices];
            visited = new boolean[vertices];

            for (int i = 0; i < vertices; i++) {
                adjLists[i] = new LinkedList<Integer>();
            }
        }

        // Add edges
        void addEdge(int src, int dest) {
            adjLists[src].add(dest);
        }

    /**
     * 查找某个顶点
     * @param vertex
     */
    // DFS algorithm
        void DFS(int vertex) {
            visited[vertex] = true;
            System.out.print(vertex + " ");

            Iterator<Integer> ite = adjLists[vertex].listIterator();
            while (ite.hasNext()) {
                int adj = ite.next();
                if (!visited[adj])
                    DFS(adj);
            }
        }

        public static void main(String args[]) {
            GraphDfs g = new GraphDfs(4);

            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 2);
            g.addEdge(2, 0);
            g.addEdge(2, 3);
            g.addEdge(3, 3);

            System.out.println("Depth First Traversal (starting from vertex 2):");

            g.DFS(2);
        }
}

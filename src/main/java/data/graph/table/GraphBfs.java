package data.graph.table;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-02
 */
public class GraphBfs {
        private int V;   // 顶点的数量
        private LinkedList<Integer> adj[]; // 邻接表

        // 构造函数
        GraphBfs(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i=0; i<v; ++i)
                adj[i] = new LinkedList();
        }

        // 添加边到图中
        void addEdge(int v,int w) {
            adj[v].add(w);
        }

        // 从给定源顶点开始进行BFS遍历
        void BFS(int s) {
            // 标记所有顶点为未访问过
            boolean visited[] = new boolean[V];

            // 创建一个队列用于BFS
            LinkedList<Integer> queue = new LinkedList<Integer>();

            // 标记当前节点为已访问并入队
            visited[s]=true;
            queue.offer(s);

            while (!queue.isEmpty()) {
                // 出队一个顶点并打印
                s = queue.poll();
                System.out.print(s+" ");

                // 获取所有邻接顶点。如果一个邻接顶点未被访问，则标记它为已访问并入队
                Iterator<Integer> i = adj[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.offer(n);
                    }
                }
            }
        }

        // 驱动程序来测试上面的函数
        public static void main(String args[]) {
            GraphBfs g = new GraphBfs(4);

            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 2);
            g.addEdge(2, 0);
            g.addEdge(2, 3);
            g.addEdge(3, 3);

            System.out.println("从顶点2开始的广度优先遍历(Breadth First Traversal):");

            g.BFS(2);
        }
}
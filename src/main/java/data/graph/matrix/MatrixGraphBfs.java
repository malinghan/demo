package data.graph.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-02
 */
public class MatrixGraphBfs {
    private int V; // 图的顶点数
    private int[][] adjMatrix; // 邻接矩阵

    // 构造函数，初始化图
    public MatrixGraphBfs(int V) {
        this.V = V;
        adjMatrix = new int[V][V];
    }

    // 添加边
    void addEdge(int src, int dest) {
        // 无向图的情况
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;
        // 如果是有向图，则只需要一条边 adjMatrix[src][dest] = 1;
    }

    // 执行BFS遍历
    void BFS(int startVertex) {
        boolean visited[] = new boolean[V]; // 标记所有顶点最初都未访问过
        Queue<Integer> queue = new LinkedList<>();

        // 当前顶点标记为已访问并入队
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            // 访问队头顶点并出队
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            // 访问当前顶点的所有邻接顶点
            for (int i = 0; i < V; i++) {
                if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String args[]) {
        MatrixGraphBfs g = new MatrixGraphBfs(4);

        g.addEdge(0, 2);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("从顶点2开始的广度优先遍历(Breadth First Traversal)：");
        g.BFS(2);
    }
}


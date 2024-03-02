package data.graph.matrix;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-02
 */
public class MatrixGraphDfs {
        private int V; // 顶点的数量
        private int[][] adjMatrix; // 邻接矩阵
        private boolean[] visited; // 访问标记数组

        // 构造函数
        public MatrixGraphDfs(int V) {
            this.V = V;
            adjMatrix = new int[V][V];
            visited = new boolean[V];
        }

        // 添加边
        public void addEdge(int src, int dest) {
            // 无向图
            adjMatrix[src][dest] = 1;
            adjMatrix[dest][src] = 1;
            // 对于有向图，只需要一条语句
        }

    /**
     * DFS算法
     * @param vertex 表示顶点的入口
     * 不同的入口，遍历出来的结果不一样
     */
    public void DFS(int vertex) {
            visited[vertex] = true;
            System.out.print(vertex + " ");

            for (int i = 0; i < V; i++) {
                if (adjMatrix[vertex][i] == 1 && (!visited[i])) {
                    DFS(i);
                }
            }
        }

        public static void main(String[] args) {
            MatrixGraphDfs g = new MatrixGraphDfs(4);

            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 2);
            g.addEdge(2, 3);

            System.out.println("深度优先遍历（从顶点0开始）:");
            g.DFS(2);
        }
}

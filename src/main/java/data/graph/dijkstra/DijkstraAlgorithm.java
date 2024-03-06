package data.graph.dijkstra;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-05
 *
 * Dijkstra算法是一种用于计算图中从一个节点到所有其他节点的最短路径的经典算法。
 * 它使用了贪心的策略，每次找到当前节点到其他节点的最短路径，并将这些节点添加到一个优先队列中。
 * 在这个队列中，节点按照到起始节点的距离排序，每次从队列中取出距离最短的节点，
 * 然后更新与这个节点相邻的节点的距离，并重新排列队列。
 * 这样不断地进行下去，直到所有节点的最短路径都被找到。
 */
import java.util.*;

public class DijkstraAlgorithm {
    private int[] dist; // 最短距离数组
    private Set<Integer> visited; // 记录已经找到最短路径的节点
    private PriorityQueue<Node> pq; // 优先队列

    private int V; // 图中节点的数量
    private List<List<Node>> adj; // 邻接表

    // 节点类，用于构建邻接表
    class Node implements Comparable<Node> {
        int vertex;
        int weight;

        Node(int v, int w) {
            vertex = v;
            weight = w;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    public DijkstraAlgorithm(int V) {
        this.V = V;
        dist = new int[V];
        visited = new HashSet<>();
        pq = new PriorityQueue<>(V, Comparator.comparingInt(a -> a.weight));
        adj = new ArrayList<>();
        for (int i = 0; i < V; ++i) {
            adj.add(new ArrayList<>());
        }
    }

    // 添加边到邻接表
    public void addEdge(int u, int v, int weight) {
        adj.get(u).add(new Node(v, weight));
        adj.get(v).add(new Node(u, weight));
    }

    // Dijkstra算法的主要逻辑
    public void dijkstra(int src) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            int u = pq.remove().vertex;
            visited.add(u);
            //核心函数
            relax(u);
        }
    }

    // 更新相邻节点的最短距离
    private void relax(int u) {
        for (Node neighbor : adj.get(u)) {
            if (!visited.contains(neighbor.vertex)) {
                int newDist = dist[u] + neighbor.weight;
                if (newDist < dist[neighbor.vertex]) {
                    dist[neighbor.vertex] = newDist;
                    pq.add(new Node(neighbor.vertex, newDist));
                }
            }
        }
    }

    // 打印最短路径
    public void printShortestPaths() {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5;
        int source = 0;

        DijkstraAlgorithm graph = new DijkstraAlgorithm(V);

        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 10);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 20);
        graph.addEdge(2, 3, 2);
        graph.addEdge(2, 4, 15);
        graph.addEdge(3, 4, 11);

        graph.dijkstra(source);
        graph.printShortestPaths();
    }
}

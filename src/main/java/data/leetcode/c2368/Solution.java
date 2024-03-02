package data.leetcode.c2368;

import java.util.LinkedList;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-02
 */
class Solution {
    boolean[] visited;
    LinkedList<Integer>[] adj;
    int nodeCount;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        visited = new boolean[n];
        adj = new LinkedList[n];
        for(int i = 0 ; i < restricted.length; i++) {
            visited[restricted[i]] = true;
        }
        for (int i = 0 ; i < n; i++) {
            adj[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        dfs(0);
        return nodeCount;
    }

    void dfs (int x) {
        //step1: 终止条件
        visited[x] = true;
        nodeCount++;
        //step2: 递归遍历所有出度
        for(int i = 0; i < adj[x].size(); i++) {
            int y = adj[x].get(i);
            if (!visited[y]) {
                dfs(y);
            }
        }
        //step3: 其他信息
    }
}

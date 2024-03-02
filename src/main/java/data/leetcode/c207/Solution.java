package data.leetcode.c207;

import java.util.ArrayList;
import java.util.List;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-02
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create adjacency list representation of the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Populate the adjacency list
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph.get(course).add(prerequisiteCourse);
        }

        // Track visited nodes
        boolean[] visited = new boolean[numCourses];
        // Track visiting nodes (to detect cycles)
        boolean[] visiting = new boolean[numCourses];

        // Perform DFS
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(graph, visited, visiting, i)) {
                return false;
            }
        }

        return true;
    }

    // DFS function to detect cycles
    private boolean hasCycle(List<List<Integer>> graph, boolean[] visited, boolean[] visiting, int course) {
        if (visiting[course]) {
            // If the course is currently being visited, a cycle is detected
            return true;
        }

        if (visited[course]) {
            // If the course has already been visited and no cycle was detected,
            // then there's no need to visit it again.
            return false;
        }

        // Mark the current course as being visited
        visiting[course] = true;

        // Recursively visit all prerequisites of the current course
        for (int prerequisiteCourse : graph.get(course)) {
            if (hasCycle(graph, visited, visiting, prerequisiteCourse)) {
                return true;
            }
        }

        // Mark the current course as visited and stop visiting
        visiting[course] = false;
        visited[course] = true;

        return false;
    }

    public static void main(String[] args) {
        Solution courseSchedule = new Solution();
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        boolean canFinish = courseSchedule.canFinish(numCourses, prerequisites);
        System.out.println("Can finish all courses: " + canFinish);
    }
}


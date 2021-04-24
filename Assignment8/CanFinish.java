package Assignment8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj;
        int v = numCourses;
        adj = new ArrayList<>(v);

        for (int i = 0; i < numCourses; i++){
            adj.add(new LinkedList<>());
        }

        for (int i = 0; i < prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        boolean [] visited = new boolean[numCourses];
        boolean [] recursionStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (isCycle(i, visited, recursionStack, adj, numCourses)){
                return false;
            }
        }
        return true;
    }

    public boolean isCycle(int v, boolean [] visited, boolean [] rs, List<List<Integer>> adj, int numCourses){
        if (rs[v]){
            return true;
        }

        if (visited[v]){
            return false;
        }

        visited[v] = true;
        rs[v] = true;

        List<Integer> children = adj.get(v);
        for (Integer child:children) {
            if (isCycle(child, visited, rs, adj, numCourses)){
                return true;
            }
        }

        rs[v] = false;
        return false;
    }

    public static void main(String[] args) {
        CanFinish cf = new CanFinish();

        int arr1[][] = {{1,0}};
        boolean res = cf.canFinish(2, arr1);
        System.out.println(res);

        int arr2[][] = {{1,0}, {0,1}};
        res = cf.canFinish(2, arr2);
        System.out.println(res);
    }
}
package algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nizy
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 * https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 * 注意：图的邻接表形式
 * @date 2021/12/12 10:28 下午
 */
public class AllPathsSourceTarget {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, new LinkedList<>(), 0);
        return result;
    }

    public void dfs(int[][] graph, LinkedList<Integer> list, int index) {
        list.addLast(index);
        if (index == graph.length - 1) {
            List<Integer> tmpList = new ArrayList<>();
            tmpList.addAll(list);
            result.add(tmpList);
            list.removeLast();
            return;
        }
        for (int num : graph[index]) {
            dfs(graph, list, num);
        }
        list.removeLast();
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,2},{3},{3},{}};
        AllPathsSourceTarget allPathsSourceTarget = new AllPathsSourceTarget();
        List<List<Integer>> list = allPathsSourceTarget.allPathsSourceTarget(graph);
        System.out.println(list);

    }


}

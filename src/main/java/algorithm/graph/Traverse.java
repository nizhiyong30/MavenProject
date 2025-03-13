package algorithm.graph;

/**
 * @author nizy
 * @date 2021/12/13 9:25 下午
 */
public class Traverse {
    public boolean[] visit;
    public void dfs(int[][] graph, int index) {
        if (visit[index]) {
            return;
        }
        System.out.println(index);
        visit[index] = true;
        for (int num : graph[index]) {
            dfs(graph, num);
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,2},{3},{3},{}};
        Traverse traverse = new Traverse();
        traverse.visit = new boolean[graph.length];
        traverse.dfs(graph, 0);
    }
}

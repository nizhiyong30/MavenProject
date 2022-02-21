package algorithm.graph;

/**
 * @author nizy
 * @date 2021/12/14 2:04 下午
 * https://leetcode-cn.com/problems/is-graph-bipartite/
 * 二分图
 */
public class IsBipartite {

    boolean[] visit;
    boolean[] color;
    boolean result = true;
    public boolean isBipartite(int[][] graph) {
        visit = new boolean[graph.length];
        color = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (result && !visit[i]) {
                dfs(graph, i);
            }
        }
        return result;
    }

    public void dfs(int[][] graph, int index) {
        if (visit[index] || !result) {
            return;
        }
        visit[index] = true;
        for(int i : graph[index]) {
            if(visit[i]) {
                if (color[i] == color[index]) {
                    result = false;
                    return;
                }
             } else {
                color[i] = !color[index];
                dfs(graph, i);
            }
        }
    }

    public static void main(String[] args) {
        IsBipartite isBipartite = new IsBipartite();
        int[][] graph = new int[][]{{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartite.isBipartite(graph));
    }
}

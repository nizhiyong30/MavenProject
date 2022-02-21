package algorithm.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nizy
 * @date 2021/12/13 9:44 下午
 * 课程表
 * https://leetcode-cn.com/problems/course-schedule/
 */
public class CanFinish {

    // 防止无环节点的重复遍历
    boolean[] visit;
    //判断节点是否被重复遍历。
    boolean[] onPath;

    boolean hasCycle = false;
    //首先根据拓扑关系构造图，判断该图是不是有向无环图，即可判断课程是否完成。
    //对图进行遍历，在遍历的过程中判断节点是否重复，若重复，说明存在环。主要，在遍历图的过程中要避免无环节点的重复遍历。
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //注意：课程数量是确定的，但是每个课程所指向的下个课程是不确定的，因此采用 List<Integer>[] graph结构
        List<Integer>[] graph = new List[numCourses];
        visit = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        //构造图
        for (int[] array : prerequisites) {
            int from = array[1];
            int to = array[0];
            graph[from].add(to);
        }
        //图未必是联通的，每个节点都需要判断一下
        for (int i = 0; i < numCourses; i++) {
            dfs(graph, i);
        }
        return !hasCycle;
    }

    public void dfs(List<Integer>[] graph, int index) {
        if (onPath[index]) {
            hasCycle = true;
        }
        if(hasCycle || visit[index]) {
            return;
        }
        visit[index] = true;
        onPath[index] = true;
        for (int num : graph[index]) {
            dfs(graph, num);
        }
        onPath[index] = false;
    }

    public static void main(String[] args) {
        CanFinish canFinish = new CanFinish();
        boolean result = canFinish.canFinish(2, new int[][]{{1,0},{0,1}});
        System.out.println(result);
    }
}

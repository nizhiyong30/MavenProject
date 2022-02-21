package leetcode.round1.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nizy
 * @date 2021/11/24 10:06 上午
 */
public class CombinationSum2 {

    boolean[] visit;
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        visit = new boolean[candidates.length];
        LinkedList<Integer> current = new LinkedList<>();
        backTrace(candidates, target, 0, current);
        return result;
    }

    public void backTrace(int[] candidates, int target, int index, LinkedList<Integer> current) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            List<Integer> tmpList = new ArrayList<>();
            tmpList.addAll(current);
            result.add(tmpList);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > 0 && (candidates[i] == candidates[i-1] && !visit[i - 1])) {
                continue;
            }
            visit[i] = true;
            current.addLast(candidates[i]);
            backTrace(candidates, target - candidates[i], i + 1, current);
            current.removeLast();
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        // 1,1,2,5,6,7,10
        combinationSum2.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
}

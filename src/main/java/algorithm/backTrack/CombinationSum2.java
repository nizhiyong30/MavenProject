package algorithm.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 II
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * @author nizy
 * @date 2021/3/2 1:45 下午
 */
public class CombinationSum2 {

    private List<List<Integer>> result = new ArrayList<>();
    private boolean[] visit;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        LinkedList<Integer> current = new LinkedList<>();
        visit = new boolean[candidates.length];
        Arrays.sort(candidates);
        find(candidates, target, 0, current);
        return result;
    }

    public void find(int[] nums, int target, int index, LinkedList<Integer> current) {
        if (target == 0) {
            List<Integer> list = new ArrayList();
            list.addAll(current);
            result.add(list);
            return;
        }
        if (target > 0) {
            for (int i = index; i < nums.length; i++) {
                if (i > 0 && (nums[i] == nums[i - 1]) && !visit[i-1]) {
                    continue;
                }
                current.addLast(nums[i]);
                visit[i] = true;
                find(nums, target - nums[i], i + 1, current);
                current.removeLast();
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2.combinationSum2(nums, 8));
    }
}

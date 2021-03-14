package algorithm.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集 II
 * https://leetcode-cn.com/problems/subsets-ii/
 *
 * @author nizy
 * @date 2021/3/3 1:07 下午
 */
public class SubsetsWithDup {

    List<List<Integer>> result = new ArrayList<>();
    boolean[] visit;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedList<Integer> current = new LinkedList<>();
        visit = new boolean[nums.length];
        Arrays.sort(nums);
        find(nums, current, 0);
        return result;
    }

    public void find(int[] nums, LinkedList<Integer> current, int index) {
        if (nums.length < current.size()) {
            return;
        }
        List<Integer> list = new ArrayList<>(current);
        result.add(list);
        if (nums.length == current.size()) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if ((i > 0 && nums[i] == nums[i - 1] && !visit[i - 1])) {
                continue;
            }
            visit[i] = true;
            current.addLast(nums[i]);
            find(nums, current, i + 1);
            current.removeLast();
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup.subsetsWithDup(nums));
    }
}

package leetcode.round1.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nizy
 * @date 2021/11/23 5:05 下午
 */
public class SubsetsWithDup {
    boolean visited[];
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        visited = new boolean[nums.length];
        LinkedList<Integer> current = new LinkedList<>();
        backTrace(nums, 0, current);
        return result;
    }

    private void backTrace(int[] nums, int index, LinkedList<Integer> current) {
        if (index > nums.length) {
            return;
        }
        List<Integer> tmpList = new ArrayList<>();
        tmpList.addAll(current);
        result.add(tmpList);
        if (nums.length == index) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]) {
                continue;
            }
            current.addLast(nums[i]);
            visited[i] = true;
            backTrace(nums, i + 1, current);
            current.removeLast();
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        subsetsWithDup.subsetsWithDup(new int[]{1,2,2});
    }
}

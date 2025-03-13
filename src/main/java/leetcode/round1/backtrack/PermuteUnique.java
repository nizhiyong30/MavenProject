package leetcode.round1.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nizy
 * @date 2021/11/23 6:51 下午
 */
public class PermuteUnique {

    List<List<Integer>> result = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        StringBuilder sb;
        LinkedList<Integer> current = new LinkedList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        backTrace(nums, current);
        return result;
    }

    public void backTrace(int[] nums, LinkedList<Integer> current) {
        if (current.size() == nums.length) {
            List<Integer> tmpList = new ArrayList<>();
            tmpList.addAll(current);
            result.add(tmpList);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && (nums[i] == nums[i - 1]) && !visited[i-1])) {
                continue;
            }
            visited[i] = true;
            current.addLast(nums[i]);
            backTrace(nums, current);
            current.removeLast();
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        permuteUnique.permuteUnique(new int[]{1,1,2});
    }
}

package algorithm.backTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集
 * https://leetcode-cn.com/problems/subsets/
 *
 * @author nizy
 * @date 2021/3/2 8:00 下午
 */
public class Subsets {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> current = new LinkedList<>();
        find(nums, current, 0);
        return result;
    }

    public void find(int[] nums, LinkedList<Integer> current, int index) {
        if (nums.length < current.size()) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(current);
        result.add(list);
        if (nums.length == current.size()) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            current.addLast(nums[i]);
            find(nums, current, i + 1);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3};
        System.out.println(subsets.subsets(nums));
    }
}


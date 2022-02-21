package leetcode.round1.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nizy
 * @date 2021/11/23 4:21 下午
 */
public class SubSets {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> current = new LinkedList<>();
        backTrace(nums, 0, current);
        return list;
    }

    public void backTrace(int nums[], int index, LinkedList<Integer> current) {
        if (index > nums.length) {
            return;
        }
        List<Integer> tmpList = new ArrayList<>();
        tmpList.addAll(current);
        list.add(tmpList);
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            current.addLast(nums[i]);
            backTrace(nums,  i + 1, current);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        subSets.subsets(new int[]{1,2,3});
        System.out.println(subSets.list);
    }
}

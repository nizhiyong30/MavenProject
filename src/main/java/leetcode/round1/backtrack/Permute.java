package leetcode.round1.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nizy
 * @date 2021/11/23 6:27 下午
 */
public class Permute {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> current = new LinkedList<>();
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
            if (current.contains(nums[i])) {
                continue;
            }
            current.addLast(nums[i]);
            backTrace(nums, current);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        System.out.println(permute.permute(new int[]{1,2,3}));
    }


}

package algorithm.backTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * @author nizy
 * @date 2021/3/1 4:29 下午
 */
public class Permute {

    private List<List<Integer>> result = new LinkedList<>();
    private LinkedList<Integer> combine = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        find(nums);
        return result;
    }

    public void find(int[] nums) {
        if (nums.length == combine.size()) {
            List<Integer> list = new LinkedList<>();
            list.addAll(combine);
            result.add(list);
        } else {
            for (int num : nums) {
                if (!combine.contains(num)) {
                    combine.add(num);
                    find(nums);
                    combine.removeLast();
                }
            }
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        int nums[] = {1,2,3};
        System.out.println(permute.permute(nums));
    }
}


package algorithm.backTrack;

import java.beans.Visibility;
import java.util.*;

/**
 * 全排列er
 * https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
 * @author nizy
 * @date 2021/3/1 11:09 下午
 */
public class PermuteUnique {

    private boolean[] visit = null;
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> selected = new LinkedList<>();
        visit = new boolean[nums.length];
        Arrays.sort(nums);
        find(nums, selected);
        return ans;
    }

    public void find(int[] nums, LinkedList<Integer> selected) {
        if (selected.size() == nums.length) {
            List<Integer> list = new ArrayList<>();
            list.addAll(selected);
            ans.add(list);
        } else if (selected.size() < nums.length) {
            // 从列表中选择符合条件的。
            for (int i = 0; i < nums.length; i++) {
                if ((visit[i] || (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1]))) {
                    continue;
                }
                visit[i] = true;
                selected.addLast(nums[i]);
                find(nums, selected);
                selected.removeLast();
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique.permuteUnique(nums));
    }
}

package algorithm.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nizy
 * @date 2021/3/1 3:49 下午
 */
public class CombinationSum {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> combine = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        find(candidates, target, 0);
        return result;
    }

    public void find(int[] candidates, int target, int index) {
        if (target == 0) {
            List<Integer> list = new ArrayList<>();
            list.addAll(combine);
            result.add(list);
        } else if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                combine.add(candidates[i]);
                find(candidates, target - candidates[i], i);
                combine.remove(combine.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {1,2,3,5};
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(candidates, 5));
    }
}

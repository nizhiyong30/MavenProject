package leetcode.round1.backtrack;

import scala.collection.generic.BitOperations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nizy
 * @date 2021/11/24 9:49 上午
 */
public class CombinationSum {

    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> current = new LinkedList<>();
        backTrace(candidates, target, 0, current);
        return result;
    }

    public void backTrace(int[] candidates, int target, int index, LinkedList<Integer> current) {
        if (target == 0) {
            List<Integer> tmpList = new ArrayList<>();
            tmpList.addAll(current);
            result.add(tmpList);
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i ++ ) {
            current.addLast(candidates[i]);
            backTrace(candidates, target - candidates[i], i, current);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        combinationSum.combinationSum(new int[]{2,3,5}, 8);
    }
}

package algorithm.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合总和 III
 * https://leetcode-cn.com/problems/combination-sum-iii/
 * @author nizy
 * @date 2021/3/2 6:06 下午
 */
public class CombinationSum3 {
    private List<List<Integer>> result = new ArrayList<>();
    private boolean[] visit;

    public List<List<Integer>> combinationSum3(int k, int n) {
        LinkedList<Integer> current = new LinkedList<>();
        find(k, n, current, 1);
        return result;
    }

    public void find(int k, int n, LinkedList<Integer> current, int index) {
        if (n == 0 && k == 0) {
            List<Integer> list = new ArrayList();
            list.addAll(current);
            result.add(list);
            return;
        }
        if (n > 0 && k > 0) {
            for (int i = index; i <= 9; i++) {
                current.addLast(i);
                find(k - 1, n - i,  current, i + 1);
                current.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        System.out.println(combinationSum3.combinationSum3(3, 9));
    }
}

package leetcode.round1.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author nizy
 * @date 2021/11/23 5:35 下午
 */
public class Combine {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> current = new LinkedList<>();
        backTrace(1, n, k, current);
        return result;
    }

    public void backTrace(int index, int n, int k, LinkedList<Integer> current) {
        if (0 == k) {
            List<Integer> tmpResult = new ArrayList<>();
            tmpResult.addAll(current);
            result.add(tmpResult);
            return;
        }
        for (int i = index; i <= n; i++) {
            current.addLast(i);
            backTrace(i + 1, n, k-1, current);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        combine.combine(4, 2);
        System.out.println(combine.result);
    }
}

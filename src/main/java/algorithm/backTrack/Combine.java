package algorithm.backTrack;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 *
 * @author nizy
 * @date 2021/3/1 3:14 下午
 */
public class Combine {

    private static List<List<Integer>> result = new ArrayList<>();
    private static List<Integer> combine = new ArrayList<>();

    public static List<List<Integer>> solution(int n, int k) {
        find(n, k, 0);
        return result;
    }

    public static void find(int n, int k, int index) {
        if (k == 0) {
            List<Integer> list = new ArrayList<>();
            list.addAll(combine);
            result.add(list);
        } else if (k > 0) {
            for (int i = index + 1; i <= n; i++) {
                combine.add(i);
                find(n, k - 1, i);
                combine.remove(combine.size() - 1);

            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 2));
    }
}

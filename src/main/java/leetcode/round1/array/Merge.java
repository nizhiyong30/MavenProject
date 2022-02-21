package leetcode.round1.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author nizy
 * https://leetcode-cn.com/problems/merge-intervals/ leetcode
 * @date 2021/11/28 1:10 下午
 */

public class Merge {

    public int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][intervals[0].length];
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            int leftValue = intervals[i][0];
            int rightValue = intervals[i][1];
            if (i == 0 || list.get(list.size() - 1)[1] < leftValue) {
                list.add(intervals[i]);
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], rightValue);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        merge.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }
}

package leetcode.round1.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author nizy
 * @date 2021/11/22 10:56 下午
 */
public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) {
            return 0;
        }
        return intervals.length - getNoOverlapIntervals(intervals);
    }

    public int getNoOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int result = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= end) {
                result++;
                end = intervals[i][1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        EraseOverlapIntervals eraseOverlapIntervals = new EraseOverlapIntervals();
        eraseOverlapIntervals.getNoOverlapIntervals(new int[][]{{1,2},{1,2}, {1,2}});
    }
}

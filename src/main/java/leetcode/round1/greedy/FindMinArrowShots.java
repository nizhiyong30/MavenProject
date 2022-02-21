package leetcode.round1.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author nizy
 * @date 2021/11/22 11:22 下午
 */
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) {
            return points.length;
        }
        return getNoOverlapIntervals(points);
    }

    public int getNoOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int result = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > end) {
                result++;
                end = intervals[i][1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindMinArrowShots findMinArrowShots = new FindMinArrowShots();
        findMinArrowShots.findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}});
    }
}

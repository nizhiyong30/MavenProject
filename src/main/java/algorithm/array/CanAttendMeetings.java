package algorithm.array;

import java.util.Arrays;

/**
 * @author nizy
 * @date 2022/2/13 4:29 下午
 */
public class CanAttendMeetings {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (arr1, arr2) -> {
            return arr1[0] - arr2[0];
        });
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i-1][0] > intervals[i].length) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{0,30},{5,10},{15,20}};
        CanAttendMeetings canAttendMeetings = new CanAttendMeetings();
        canAttendMeetings.canAttendMeetings(nums);

    }
}

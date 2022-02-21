package leetcode.round1.greedy;

/**
 * @author nizy
 * @date 2021/11/22 4:15 下午
 */
public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int preDiff = nums[1] - nums[0];
        int ret = nums[1] == nums[0] ? 1 : 2;
        int curDiff = 0;
        for (int i = 2; i < nums.length; i++) {
            curDiff = nums[i] - nums[i-1];
            //==号是考虑到{2,2,3}，这种case下也属于
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0  && preDiff >= 0)) {
                ret++;
                preDiff = curDiff;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        WiggleMaxLength wiggleMaxLength = new WiggleMaxLength();
        System.out.println(wiggleMaxLength.wiggleMaxLength(new int[]{3,3,3,2,5}));
    }
}

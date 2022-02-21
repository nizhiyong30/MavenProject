package leetcode.round1.array.prefixsum;

/**
 * @author nizy
 * 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * @date 2022/2/17 10:57 上午
 */
public class Trap {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max_left = height[0];
        int max_right = height[height.length - 1];
        int result = 0;
        while(left <= right) {
            max_left = Math.max(height[left], max_left);
            max_right = Math.max(height[right], max_right);
            if(max_left < max_right) {
                result += (max_left - height[left]);
                left++;
            } else {
                result += (max_right - height[right]);
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap.trap(height));
    }
}

package leetcode.round1.array.sildewindow;

import java.util.Collections;

/**
 * @author nizy
 * @date 2022/2/8 5:51 下午
 * 接水最多的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class MaxArea {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int result = 0;
        while(l  < r) {
             int area = (r - l) * Math.min(height[l], height[r]);
             result = Math.max(area, result);
             if(height[l] <= height[r]) {
                 l++;
             } else {
                 r--;
             }
        }
        return result;
    }
}

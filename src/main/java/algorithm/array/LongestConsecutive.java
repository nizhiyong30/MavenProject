package algorithm.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author nizy
 * 最长连续序列
 * [100,4,200,1,3,2]
 * @date 2022/2/17 3:22 下午
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        for(int num : nums) {
            int len = 1;
            if(!set.contains(num-1)) {
                while(set.contains(num + 1)) {
                    len++;
                    num++;
                }
            }
            result = Math.max(result, len);
        }
        return result;
    }

    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        longestConsecutive.longestConsecutive(new int[]{100,4,200,1,3,2});
    }
}

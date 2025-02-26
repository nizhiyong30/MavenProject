package algorithm;

import java.util.HashMap;

/**
 * @author kelai 2021-11-16 20:46
 */
public class Test {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int [] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result = new int[]{i, map.get(nums[i])};
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
    public static void main(String[] args) {
        int [] nums = new int[]{2, 7, 11, 5};
        System.out.println(twoSum(nums, 9));
    }
}

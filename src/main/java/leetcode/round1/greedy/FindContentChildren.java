package leetcode.round1.greedy;

import java.util.Arrays;

/**
 * @author nizy
 * @date 2021/11/22 3:35 下午
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int gIndex = g.length - 1;
        int sIndex = s.length - 1;
        for (; gIndex >= 0 && sIndex >= 0; gIndex--) {
            if (s[sIndex] >= g[gIndex]) {
                result++;
                sIndex--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindContentChildren findContentChildren = new FindContentChildren();
        System.out.println(findContentChildren.findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
    }
}

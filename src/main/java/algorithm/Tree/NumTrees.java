package algorithm.Tree;

/**
 * @author nizy
 * 不同的搜索树 https://leetcode-cn.com/problems/unique-binary-search-trees/
 * @date 2021/12/8 2:14 下午
 */
public class NumTrees {

    int[][] memos;
    public int numTrees(int n) {
        memos = new int[n+1][n+1];
        traverse(1, n);
        return memos[1][n];
    }

    public int traverse(int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        if (memos[lo][hi] != 0) {
            return memos[lo][hi];
        }
        int res = 0;
        for (int i = lo; i <= hi; i++) {
            int left = traverse(lo, i - 1);
            int right = traverse(i + 1, hi);
            res += left * right;
        }
        memos[lo][hi] = res;
        return res;
    }
}

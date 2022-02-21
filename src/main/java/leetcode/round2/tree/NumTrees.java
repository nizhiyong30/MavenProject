package leetcode.round2.tree;

/**
 * @author nizy
 * @date 2022/1/28 6:12 下午
 */
public class NumTrees {
    int[][] memos;

    public int numTrees(int n) {
        memos = new int[n + 1][n + 1];
        traverse(1, n);
        return memos[1][n];
    }

    public int traverse(int start, int end) {
        if(start == end) {
           return 1;
        }
        if(memos[start][end] != 0) {
            return memos[start][end];
        }
        int res = 0;
        for(int i = start; i <= end; i++) {
            int left = traverse(start, i - 1);
            int right = traverse( i + 1, end);
            res += left * right;
        }
        memos[start][end] = res;
        return res;
    }
}

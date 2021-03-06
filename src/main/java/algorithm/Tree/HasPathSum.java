package algorithm.Tree;

import algorithm.structure.TreeNode;

/**
 * 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 * @author nizy
 * @date 2021/3/4 1:01 下午
 */
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int val = (int) root.val;
        if (root.left == null && root.right == null && targetSum - val == 0) {
            return true;
        }
        return hasPathSum(root.left, targetSum - val) || hasPathSum(root.right, targetSum - val);
    }
}

package algorithm.Tree;

/**
 * @author nizy
 * https://leetcode-cn.com/problems/balanced-binary-tree/ 是否是平衡二叉树
 * @date 2021/12/6 12:07 上午
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = height(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        return (Math.abs(rightHeight - leftHeight) > 1) ? -1 : Math.max(leftHeight, rightHeight) + 1;
    }
}

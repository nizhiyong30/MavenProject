package algorithm.Tree;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *  二叉树展开为链表
 * @author nizy
 * @date 2021/12/7 1:53 下午
 */
public class Flatten {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode node = root;
        while(node.right != null) {
            node = right.right;
        }
        node.right = right;
    }
}

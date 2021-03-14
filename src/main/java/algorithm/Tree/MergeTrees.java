package algorithm.Tree;

import algorithm.structure.TreeNode;

/**
 * @author nizy
 * @date 2021/2/27 6:45 下午
 */
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        merge(root1, root2);
        return root1;
    }

    public void merge(TreeNode<Integer> node1, TreeNode<Integer> node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.val = node1.val + node2.val;
        if (node1.left == null) {
            node1.left = node2.left;
        }
        if (node1.right == null) {
            node1.right = node2.right;
        }
        merge(node1.left, node2.left);
        mergeTrees(node1.right, node2.right);
    }
}

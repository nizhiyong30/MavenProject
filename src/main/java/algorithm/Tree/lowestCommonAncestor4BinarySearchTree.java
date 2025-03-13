package algorithm.Tree;

/**
 * @author nizy
 * 二叉搜索树的最近公共祖先 https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * @date 2021/12/4 9:18 下午
 */
public class lowestCommonAncestor4BinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode ancestor = root;
        if (root == null) {
            return root;
        }
        while(true) {
            if (p.val < ancestor.val && q.val < root.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > root.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }
}

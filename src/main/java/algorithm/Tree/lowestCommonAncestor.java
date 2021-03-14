package algorithm.Tree;

import algorithm.structure.TreeNode;

/**
 * 最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * @author nizy
 * @date 2021/3/3 6:10 下午
 */
public class lowestCommonAncestor {

    private TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return result;
    }

    /**
     * 思路：判断以root为根节点的树是否包含p或q节点。即:
     * root.val == p.val || root.val == q.val  || left(roo.left, p, q) || right(roo.right, p, q).
     * 如果root为根节点的树同时包含p和q节点，则表示找到最近公共祖先。
     * 注意隐含条件，p和q只能出现一次。因此，当以root为根节点的树同时包含p和q节点时，root的左子树和右子树必然至少包含一个p或q。
     * 此时可以判断，root的父节点的左右子树不可能必然有一个子树同时包含p和q，并且另一个子树不包含q和q.
     * @param root
     * @param p
     * @param q
     * @return
     */
    public boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        } else {
            boolean left = find(root.left, p, q);
            boolean right = find(root.right, p, q);
            if ((left && right) || (left || right && (root.val == p.val || root.val == q.val))) {
                result = root;
            }
            return (left || right) || (root.val == p.val || root.val == q.val);
        }
    }
}

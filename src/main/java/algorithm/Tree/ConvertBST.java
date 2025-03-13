package algorithm.Tree;

/**
 * @author nizy
 * @date 2021/12/8 2:00 下午
 */
public class ConvertBST {

    private int sum;

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }
}

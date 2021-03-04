package algorithm.Tree;

import algorithm.structure.TreeNode;
import apple.laf.JRSUIUtils;

import java.util.Stack;

/**
 * @author nizy
 * @date 2021/2/28 3:51 下午
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.empty()) {
                TreeNode node = stack.pop();
                if (--k == 0) {
                    return (int) node.val;
                }
                root = node.right;
            }
        }
    }
}

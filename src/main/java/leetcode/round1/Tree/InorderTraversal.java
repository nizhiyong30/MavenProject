package leetcode.round1.Tree;

import java.util.*;

/**
 * @author nizy
 * @date 2021/12/3 9:39 下午
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        };
        Stack<TreeNode> queue = new Stack<>();
        while(root != null || !queue.isEmpty()) {
            while(root != null) {
                queue.push(root);
                root = root.left;
            }
            root = queue.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}

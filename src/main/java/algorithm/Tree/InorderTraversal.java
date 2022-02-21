package algorithm.Tree;

import java.util.*;

/**
 * @author nizy
 * @date 2022/1/28 5:38 下午
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(! stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}

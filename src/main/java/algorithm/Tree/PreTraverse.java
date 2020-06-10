package algorithm.Tree;

import algorithm.structure.TreeNode;

import java.util.Stack;

/**
 * @author kelai 2020-06-06 10:36
 */
public class PreTraverse {

    public static void preTraverseRecursive(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node);
        preTraverseRecursive(node.getLeft());
        preTraverseRecursive(node.getRight());
    }

    public static void preTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()) {
            TreeNode tmpNode = stack.pop();
            System.out.println(tmpNode);
            if (tmpNode.getLeft() != null) {
                stack.push(tmpNode.getLeft());
            }
            if (tmpNode.getRight() != null) {
                stack.push(tmpNode.getRight());
            }
        }
    }
}

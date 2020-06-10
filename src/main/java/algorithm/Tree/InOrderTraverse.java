package algorithm.Tree;

import algorithm.structure.TreeNode;

import java.util.Stack;

/**
 * @author kelai 2020-06-06 10:42
 */
public class InOrderTraverse {

    public static void inOrderTraverseRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrderTraverseRecursive(treeNode.getLeft());
        System.out.println(treeNode);
        inOrderTraverseRecursive(treeNode.getRight());
    }

    public static void inOrderTraverse(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(treeNode);
        while(!stack.isEmpty()) {
            TreeNode head = stack.peek();
            while(head.getLeft() != null) {
                stack.push(head.getLeft());
            }
            head = stack.pop();
            System.out.println(head);
            if (head.getRight() != null) {
                stack.push(head.getRight());
            }
        }
    }
}

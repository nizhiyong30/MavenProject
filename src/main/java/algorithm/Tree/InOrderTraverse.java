package algorithm.Tree;

import algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
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

    public static void inOrderTraverse(TreeNode root) {
        TreeNode current = root;
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.empty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            if(!stack.empty()) {
                TreeNode node = stack.pop();
                result.add((Integer) node.val);
                current = node.right;
            }
        }
    }
}

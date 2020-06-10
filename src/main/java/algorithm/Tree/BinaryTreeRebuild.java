package algorithm.Tree;

import algorithm.structure.TreeNode;

import java.util.ArrayList;

/**
 * @author kelai 2020-06-06 12:14
 */
public class BinaryTreeRebuild {

    public static TreeNode solution(ArrayList<String> preOrder, ArrayList<String> inOrder)  {
        if (preOrder == null || preOrder.size() == 0 || inOrder == null || inOrder.size() == 0 || inOrder.size() != preOrder.size()) {
            return null;
        }
        return rebuild(preOrder, 0, preOrder.size(), inOrder, 0, inOrder.size());
    }

    public static TreeNode rebuild(ArrayList<String> preOrder, int preOrderStart, int preOrderLength, ArrayList<String> inOrder, int inOrderStart, int inOrderLength) {
        TreeNode rootNode = new TreeNode();
        rootNode.setValue(preOrder.get(preOrderStart));
        if (preOrderLength == 1) {
            if (preOrder.get(preOrderStart).equals(inOrder.get(inOrderStart))) {
                return rootNode;
            }
        }

        int count = 1;
        for (int i = inOrderStart + 1; i < inOrderStart + inOrderLength; i++) {
            if (rootNode.getValue().equals(inOrder.get(i))) {
                break;
            } else {
                count++;
            }
        }
        int leftLength = count - 1;
        int rigthLength = inOrderLength - count;
        if (leftLength > 0) {
            rootNode.setLeft(rebuild(preOrder, preOrderStart, leftLength, inOrder, inOrderStart, leftLength));
        }
        if (rigthLength > 0) {
            rootNode.setLeft(rebuild(preOrder, preOrderStart + leftLength + 1, rigthLength, inOrder, inOrderStart + count, rigthLength));
        }
        return rootNode;

    }

    public static void main(String[] args) {
        String s = "ab";
        System.out.println(s.substring(2).length());
    }
}

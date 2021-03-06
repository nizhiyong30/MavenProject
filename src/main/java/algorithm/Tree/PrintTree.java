package algorithm.Tree;

import algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输出二叉树
 * https://leetcode-cn.com/problems/print-binary-tree/
 * @author nizy
 * @date 2021/3/4 2:21 下午
 */
public class PrintTree {

    List<List<String>> result = new LinkedList<>();

    public List<List<String>> printTree(TreeNode root) {
        int depth = getDepth(root);
        int length = (int) Math.pow(2, depth) - 1;
        List<String> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            list.add("");
        }
        for (int i = 0; i < depth; i++) {
            result.add(new LinkedList<>(list));
        }
        find(root, 0, 0, length - 1);
        return result;
    }

    public void find(TreeNode node, int level, int start, int end) {
        if (node == null) {
            return;
        }
        int index = (start + end) / 2;
        result.get(level).set(index, ("" + node.val));
        find(node.left, level + 1, start, (start + end) / 2 - 1);
        find(node.right, level + 1, (start + end) / 2 + 1, end);
    }


    public int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(0 & 0);
    }
}

package algorithm.Tree;

import algorithm.structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/smallest-string-starting-from-leaf/
 * @author nizy
 * @date 2021/3/5 1:13 下午
 */
public class SmallestFromLeaf {

    private String result = "~";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return result;
    }

    public void dfs(TreeNode node, StringBuilder current) {
        if (node == null) {
            return;
        }
        current.append(node.val);
        if (node.left == null && node.right == null) {
            String reverse = current.reverse().toString();
            if (reverse.compareTo(result) < 0) {
                result = reverse;
            }
            current.reverse();
        }
        dfs(node.left, current);
        dfs(node.right, current);
        current.deleteCharAt(current.length() - 1);
    }
}

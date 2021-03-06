package algorithm.Tree;

import algorithm.structure.TreeNode;

/**
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 *
 * @author nizy
 * @date 2021/3/5 12:44 下午
 */
public class SumNumbers {
    private int result = 0;

    public int sumNumbers(TreeNode root) {
        find(root, new StringBuilder());
        return result;
    }

    public void find(TreeNode node, StringBuilder stringBuilder) {
        if (node == null) {
            return;
        }
        stringBuilder.append(node.val);
        if (node.left == null && node.right == null) {
            result += Integer.parseInt(stringBuilder.toString());
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            return;
        }
        find(node.left, stringBuilder);
        find(node.right, stringBuilder);
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
    }

    public int find2(TreeNode node, int preSum) {
        if (node == null) {
            return 0;
        }
        int sum = preSum * 10 + (int) node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }
        return find2(node.left, sum) + find2(node.right, sum);
    }
}

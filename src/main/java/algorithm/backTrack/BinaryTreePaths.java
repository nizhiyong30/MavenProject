package algorithm.backTrack;

import algorithm.structure.TreeNode;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** leetcode 257。二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * @author nizy
 * @date 2021/3/1 2:34 下午
 */
public class BinaryTreePaths {

    private static List<String> result = new ArrayList<>();

    public static List<String> binaryTreePaths(TreeNode root) {
        List<Integer> paths = new ArrayList<Integer>();
        constructPaths(root, paths);
        return result;
    }

    public static void constructPaths(TreeNode node, List<Integer> paths) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            paths.add((Integer) node.val);
            result.add(join(paths));
            paths.remove(paths.size() - 1);
        } else {
            paths.add((Integer) node.val);
            constructPaths(node.left, paths);
            constructPaths(node.right, paths);
            paths.remove(paths.size() - 1);
        }
    }

    public static String join(List<Integer> paths) {
        StringBuilder value = new StringBuilder();
        value.append(String.valueOf(paths.get(0)));
        for (int i = 1; i < paths.size(); i++) {
            value.append("->").append(paths.get(i));
        }
        return value.toString();
    }

    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Integer> stack = new Stack<Integer>();
        binartSearch(root, result, stack);
        return result;
    }

    public void binartSearch(TreeNode node, List<String> result, Stack<Integer> stack) {
        if (node.left == null && node.right == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer num : stack) {
                stringBuilder.append(num).append("->");
            }
            stringBuilder.append(node.val);
            result.add(stringBuilder.toString());
            return;
        }
        stack.add((Integer) node.val);
        if (node.left != null) {
            binartSearch(node.left, result, stack);
        }
        if (node.right != null) {
            binartSearch(node.right, result, stack);
        }
        stack.pop();
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.right = new TreeNode(5);
        node.right = new TreeNode(3);
        System.out.println(binaryTreePaths(node));
    }
}

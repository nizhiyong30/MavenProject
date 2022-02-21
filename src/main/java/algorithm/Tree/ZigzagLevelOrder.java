package algorithm.Tree;


import java.util.*;

/**
 * @author nizy
 * @date 2021/12/3 9:18 下午
 */
public class ZigzagLevelOrder {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isLeft = true;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0 ; i < length; i++) {
                TreeNode treeNode = queue.poll();
                if (isLeft) {
                    deque.addLast(treeNode.val);
                } else {
                    deque.addFirst(treeNode.val);
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            result.add(new ArrayList<>(deque));
            isLeft = !isLeft;
        }
        return result;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

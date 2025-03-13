package leetcode.round1.Tree;

import java.util.*;

/**
 * @author nizy
 * @date 2021/12/3 9:56 下午
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> deque = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> innerList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                innerList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            deque.addFirst(innerList);
        }
        return new ArrayList<List<Integer>>(deque);
    }
}

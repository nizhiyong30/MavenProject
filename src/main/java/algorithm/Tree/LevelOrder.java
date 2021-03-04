package algorithm.Tree;

import algorithm.structure.TreeNode;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

/**
 * @author nizy
 * @date 2021/2/27 3:06 下午
 */
public class LevelOrder {
    /**
     * 从上到下打印二叉树(剑指 Offer 32 - I; leetcode)
     * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
     *
     * @param root
     * @return
     */
    public int[] solution(TreeNode<Integer> root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                list.add((Integer) node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        int[] result = new int[list.size()];
        int index = 0;
        for (int num : list) {
            result[index++] = num;
        }
        return result;
    }

    /**
     * 剑指 Offer 32 - II. 从上到下打印二叉树 II
     * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
     *
     * @param root
     * @return
     */
    public List<List<Integer>> solution1(TreeNode<Integer> root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> innerList = new ArrayList();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                innerList.add((Integer) node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(innerList);
        }
        return list;
    }

    /**
     * 剑指 Offer 32 - III. 从上到下打印二叉树 III
     * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> solution2(TreeNode<Integer> root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> innerList = new LinkedList<>();
            for (int i = queue.size(); i > 0; i++) {
                TreeNode node = queue.poll();
                if (list.size() % 2 == 0) {
                    // 奇数层顺序添加
                    innerList.addFirst((Integer) node.val);
                } else {
                    //偶数层逆序添加
                    innerList.addLast((Integer) node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(innerList);
        }
        return list;
    }

    public static void main(String[] args) {
        LinkedList<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(3);
        System.out.println(deque);
    }
}

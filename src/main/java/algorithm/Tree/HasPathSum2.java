package algorithm.Tree;

import algorithm.structure.TreeNode;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 * @author nizy
 * @date 2021/3/4 1:21 下午
 */
public class HasPathSum2 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> current = new LinkedList<Integer>();
        depth(root, targetSum, current);
        return result;
    }

    public void depth(TreeNode root, int targetSum, LinkedList<Integer> current) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && targetSum == 0) {
            LinkedList<Integer> list = new LinkedList<>(current);
            list.addLast((Integer) root.val);
            result.add(list);
        }
        int val = (int) root.val;
        current.addLast((Integer) root.val);
        depth(root.left, targetSum - val, current);
        current.removeLast();

        current.addLast((Integer) root.val);
        depth(root.right, targetSum - val, current);
        current.removeLast();
    }

}

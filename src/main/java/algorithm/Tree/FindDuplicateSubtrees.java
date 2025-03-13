package algorithm.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 寻找重复子树
 * https://leetcode-cn.com/problems/find-duplicate-subtrees/
 *
 * @author nizy
 * @date 2022/1/24 4:33 下午
 */
public class FindDuplicateSubtrees {

    private HashMap<String, Integer> hashMap = new HashMap<>();

    private List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return result;
    }

    public String traverse(TreeNode node) {
        if (node == null) {
            return "null";
        }
        String leftValue = traverse(node.left);
        String rightValue = traverse(node.right);
        String value = node.val + "," + leftValue + "," + rightValue;
        int count = 0;
        if ((count = hashMap.getOrDefault(value, 0)) == 1) {
            result.add(node);
        }
        hashMap.put(value, ++count);
        return value;
    }


}

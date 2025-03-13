package algorithm.Tree;

/**
 * @author nizy
 * @date 2021/12/7 9:55 下午
 */
public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int index =  start;
        int maxIndex = index;
        while(index <= end) {
            if (nums[index] > nums[maxIndex]) {
                maxIndex = index;
            }
            index++;
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructMaximumBinaryTree(nums, start, maxIndex - 1);
        root.right = constructMaximumBinaryTree(nums, maxIndex + 1, end);
        return root;
    }
}

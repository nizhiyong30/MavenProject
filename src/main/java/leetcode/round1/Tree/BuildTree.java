package leetcode.round1.Tree;

import java.util.HashMap;

/**
 * @author nizy
 * @date 2021/12/5 12:20 下午
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preOrderStart, int preOrderEnd, int inOrderStart, int inOrderEnd) {
        if (preOrderStart > preOrderEnd) {
            return null;
        }

        int rootValue = preorder[preOrderStart];
        TreeNode node = new TreeNode(rootValue);
        int i = inOrderStart;
        while(i <= inOrderEnd) {
            if (inorder[i] == rootValue) {
                break;
            }
            i++;
        }
        int leftLength = i - inOrderStart;
        node.left = buildTree(preorder, inorder, preOrderStart + 1, preOrderStart + leftLength, inOrderStart, i - 1);
        node.right = buildTree(preorder, inorder, preOrderStart + leftLength + 1, preOrderEnd, i + 1, inOrderEnd);
        return node;
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        int nums1[] = {1, 2, 3};
        int nums2[] = {3, 2, 1};
        buildTree.buildTree(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1);
    }
}

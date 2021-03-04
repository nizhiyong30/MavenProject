package algorithm.Tree;


import algorithm.structure.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 剑指 Offer 07. 重建二叉树
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 *
 * @author nizy
 * @date 2021/2/28 11:07 上午
 */
public class BuildTree {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int rootValue = preorder[0];
        TreeNode node = new TreeNode(rootValue);
        int index = 0;
        while (index < inorder.length) {
            if (inorder[index] == rootValue) {
                break;
            }
            index++;
        }
        int leftNum = index;
        int rightNum = inorder.length - index - 1;
        if (leftNum > 0) {
            int[] leftPreorder = new int[leftNum];
            int[] leftInorder = new int[leftNum];
            leftPreorder = Arrays.copyOfRange(preorder, 1, index + 1);
            leftInorder = Arrays.copyOfRange(inorder, 0, index);
            node.left = buildTree(leftPreorder, leftInorder);
        }
        if (rightNum > 0) {
            int[] rightPreorder = new int[rightNum];
            int[] rightInorder = new int[rightNum];
            rightPreorder = Arrays.copyOfRange(preorder, index + 1, preorder.length);
            rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
            node.right = buildTree(rightPreorder, rightInorder);
        }
        return node;
    }

    public static TreeNode buildTree1(int[] preorder, int[] inorder, int preOrderStart, int preOrderEnd, int inorderStart, int inorderEnd) {
        if (preOrderStart > preOrderEnd) {
            return null;
        }
        int rootValue = preorder[preOrderStart];
        TreeNode node = new TreeNode(rootValue);
        int index = inorderStart;
        while (index <= inorderEnd) {
            if (inorder[index] == rootValue) {
                break;
            }
            index++;
        }
        int leftNum = index - preOrderStart;
        node.left = buildTree1(preorder, inorder, preOrderStart + 1, preOrderStart + leftNum, inorderStart, index - 1);
        node.right = buildTree1(preorder, inorder, preOrderStart + 1 + leftNum, preOrderEnd, index + 1, inorderEnd);
        return node;
    }

    public static void main(String[] args) {
        int nums1[] = {1, 2, 3};
        int nums2[] = {3, 2, 1};
        buildTree1(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1);
        HashMap indexMap  = new HashMap<Integer, Integer>();


    }

}

package algorithm.Tree;

import java.util.Collections;

/**
 * @author nizy
 * @date 2022/2/3 11:45 上午
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int start, int end) {
        if(start >= end) {
            return true;
        }
        int rootvalue = postorder[end];
        int rightStart = start;
        boolean flag = true;
        while(rightStart < end) {
            if(postorder[rightStart] > rootvalue) {
                break;
            }
            rightStart++;
        }
        for(int i = rightStart; i < end; i++) {
            if(postorder[i] < rootvalue) {
                flag = false;
                break;
            }
        }
        return flag && verifyPostorder(postorder, start, rightStart - 1) &&  verifyPostorder(postorder, rightStart,end - 1);
    }

    public static void main(String[] args) {
        VerifyPostorder verifyPostorder = new VerifyPostorder();
        int[] nums = new int[]{1,2,5,10,6,9,4,3};
        verifyPostorder.verifyPostorder(nums);
    }
}

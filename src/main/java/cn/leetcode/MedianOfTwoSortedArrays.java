package cn.leetcode;

/**
 * Created by nizy on 2019/4/30.
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int i = 0;
        int j = 0;
        int index = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 == 0) {
            return nums2.length % 2 == 0 ? (((double) nums2[length2/2] + (double) nums2[length2/2 - 1]) / 2) : (double) nums2[length2/2];
        }
        if (length2 == 0) {
            return nums1.length % 2 == 0 ? (((double) nums1[length1/2] + (double) nums1[length1/2 - 1]) / 2) : (double) nums1[length1/2];
        }

        while (i < length1 && j < length2) {
            if (index == (length1 + length2 - 1) / 2) {
                break;
            }
            if (nums1[i] <= nums2[j]) {
                i++;
            } else {
                j++;
            }
            index++;
        }
        if (index == (length1 + length2 - 1) / 2) {
            if ((length1 + length2) % 2 == 0) {
                return (((double)nums1[i] + (double)nums2[j]) / 2);
            } else {
                return Math.min(nums1[i], nums2[j]);
            }
        } else {
            if (i < length1) {
                while (i < length1 && index < (length1 + length2 - 1) / 2) {
                    i++;
                    index++;
                }
                if ((length1 + length2) % 2 == 0) {
                    return (((double)nums1[i] + (double)nums1[2]) / 2);
                } else {
                    return nums1[i];
                }
            } else {
                while (j < length2 && index < (length1 + length2 - 1) / 2) {
                    j++;
                    index++;
                }
                if ((length1 + length2) % 2 == 0) {
                    return (((double)nums2[j] + (double)nums2[j]) / 2);
                } else {
                    return nums2[j];
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] num1 = {2,2,2};
        int [] nums2 = {2,2,2,2};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(num1, nums2));

    }
}


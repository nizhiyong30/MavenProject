package algorithm.array;

/**
 * @author nizy
 * @date 2022/2/5 10:45 上午
 */
public class ReversePairs {
    private int[] tmp;
    public int reversePairs(int[] nums) {
        tmp = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int l, int r) {
        if(l >= r) {
            return 0;
        }
        int mid = l + (r -l ) / 2;
        int leftCount = mergeSort(nums, l, mid);
        int rightCount = mergeSort(nums, mid + 1, r);
        int count = sort(nums, l, r, mid);
        return leftCount + rightCount + count;
    }

    private int sort(int[] nums, int l, int r, int mid) {
        if(l >= r) {
            return 0;
        }
        int i = l;
        int j = mid + 1;
        int count = 0;
        for(int k = l; k <= r; k++) {
            tmp[k] = nums[k];
        }
        for(int k = l; k <= r; k++) {
            if(i == mid + 1) {
                nums[k] = tmp[j++];
            }  else if(j == r + 1) {
                nums[k] = tmp[i++];
            } else if(tmp[i] <= tmp[j]) {
                nums[k] = tmp[i++];
            } else {
                nums[k] = tmp[j++];
                count += mid - i + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        reversePairs.reversePairs(new int[]{7,5,6,5});
    }
}

package algorithm.array.sort;

/**
 * @author nizy
 * @date 2021/3/8 7:07 下午
 */
public class HeapSort {

    /**
     * 调整第index节点。
     * length会变化
     * @param index
     * @param nums
     */
    public void adjustHead(int index, int[] nums, int lenght) {
        for (int i = 2 * index + 1; i < lenght; i = 2 * i + 1) {
            int value = nums[index];
            if (i < lenght - 1 && nums[i + 1] > nums[i]) {
                i++;
            }
            if (nums[i] < value) {
                break;
            }
            nums[index] = nums[i];
            nums[i] = value;
            index = i;
        }
    }

    public void sort(int nums[]) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHead(i, nums, nums.length);
        }

        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjustHead(0, nums, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 7, 6, 5, 8, 4};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(nums);
        System.out.println(nums);
    }


}

package algorithm;

import java.util.List;

/**
 * @author kelai 2020-03-22 21:28
 */
public class Heap {
    public static void delete(List<Integer> heap, int index) {
        heap.set(index, heap.get(heap.size() - 1));
        heapDown(heap, index); // 节点下沉
        // 把最后一个位置的数字删除
        heap.remove(heap.size() - 1);
    }

    // 下沉
    public static void heapDown(List<Integer> heap, int index) {
        // index1是空值
        int n = heap.size() - 2;
        // 记录最大的那个儿子节点的位置
        int child = -1;
        // 2*index>n说明该节点没有左右儿子节点了，那么就返回
        if (2 * index > n) {
            return;
        } // 如果左右儿子都存在
        else if (2 * index < n) {
            // 定义左儿子节点
            child = 2 * index;
            // 如果左儿子小于右儿子的数值，取右儿子的下标
            if ((Integer) heap.get(child) < (Integer) heap.get(child + 1)) {
                child++;
            }
        }// 如果只有一个儿子（左儿子节点）
        else if (2 * index == n) {
            child = 2 * index;
        }

        if ((Integer) heap.get(child) > (Integer) heap.get(index)) {
            // 交换堆中的child，和index位置的值
            swap(heap, child, index);

            // 完成交换后递归调用，继续下降
            heapDown(heap, child);
        }
    }

    // 打印
    public static void print(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void swap(List<Integer> heap, int a, int b) {
        int temp = (Integer) heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, temp);
    }

    // 插入元素
    public static void insert(List<Integer> heap, int value) {
        // 在数组的尾部添加要插入的元素
        if (heap.size() == 0) {
            heap.add(0);// 数组下标为0的位置不放元素
        }
        heap.add(value);
        heapUp(heap, heap.size() - 1);//上升操作
    }

    // 节点上浮，让插入的数和父节点的数值比较，当大于父节点的时候就和节点的值相交换
    public static void heapUp(List<Integer> heap, int index) {
        if (index > 1) {
            int parent = index / 2;
            // 获取相应位置的数值
            int parentValue = (Integer) heap.get(parent);
            int indexValue = (Integer) heap.get(index);
            // 如果父亲节点比index的数值小，就交换二者的数值
            if (parentValue < indexValue) {
                // 交换数值
                swap(heap, parent, index);
                // 递归
                heapUp(heap, parent);
            }
        }
    }

    // 初始化堆
    public static void adjust(List<Integer> heap) {
        for (int i = heap.size() / 2; i > 0; i--) {
            adjust(heap, i, heap.size() - 1);
        }
    }

    public static void adjust(List<Integer> heap, int i, int n) {
        int child;
        for (; i <= n / 2;) {
            child = i * 2;
            if (child + 1 <= n && heap.get(child) < heap.get(child + 1)) {
                child += 1;/* 使child指向值较大的孩子 */
            }
            if (heap.get(i) < heap.get(child)) {
                swap(heap, i, child);
                i = child;
            } else {
                break;
            }
        }
    }

    // 对一个最大堆heap排序
    public static void heapSort(List<Integer> heap) {
        for (int i = heap.size() - 1; i > 0; i--) {
            /* 把根节点跟最后一个元素交换位置，调整剩下的n-1个节点，即可排好序 */
            swap(heap, 1, i);
            adjust(heap, 1, i - 1);
        }
    }

    public static int getHeapRoot(List<Integer> heap) {
        return heap.get(1);
    }

}

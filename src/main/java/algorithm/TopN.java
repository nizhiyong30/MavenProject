import algorithm.Heap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;

//评测题目: 假设现在有5个文本文件，每个文件中存放了n行数据，以\n作为换行符号，
//每行内容是个数字，范围在4字节整型，文件内容未经过排序。用最快的速度求出top50，并打印出来

// 多线程读文件，每个文件内堆排序，再将5个结果merge后的list进行排序

public class TopN {
    public static List<Integer> readTop50(String path) {
        File file = new File(path);


        List<Integer> nums = new ArrayList<Integer>();

        try {
            BufferedReader bw = new BufferedReader(new FileReader(file));
            String line = null;
            line = bw.readLine();
            // 先构造堆
            int tmp = Integer.parseInt(line);
            nums.add(tmp);
            Heap.adjust(nums);
            Heap.heapSort(nums);
            while((line = bw.readLine()) != null){
                tmp = Integer.parseInt(line);
                if (nums.size() < 50) {
                    Heap.insert(nums, tmp);
                } else {
                    if (Heap.getHeapRoot(nums) < tmp) {
                        Heap.delete(nums, 1);
                        Heap.insert(nums, tmp);
                        Heap.heapSort(nums);
                    }
                }
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nums;
    }

    public static class ThreadRuning extends Thread{

        private String filename;

        private CountDownLatch countDownLatch;

        private CopyOnWriteArrayList<Integer> tmpList;


        public ThreadRuning(String name, String filename, CountDownLatch countDownLatch, CopyOnWriteArrayList<Integer> tmpList){
            super(name);
            this.filename = filename;
            this.countDownLatch = countDownLatch;
            this.tmpList = tmpList;
        }
        @Override
        public void run() {
            try {
                List<Integer> tmp = readTop50("path"+filename+".txt");
                for (int i = 1; i < tmp.size(); i++) {
                    tmpList.add(tmp.get(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
        }
    }

    public static void main(String[] args) {
        final int COUNT_DOWN = 5;

        CountDownLatch countDownLatch = new CountDownLatch(COUNT_DOWN);
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();

        try {
            for (int i = 0; i < COUNT_DOWN; i++) {
                Thread coutThread = new ThreadRuning(String.valueOf(i), String.valueOf(i), countDownLatch, list);
                coutThread.start();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // merge 5个结果
        Collections.sort(list);
        Collections.reverse(list);
        int MAX = 50;
        if (list.size() < MAX) {
            MAX = list.size();
        }
        for (int i = 0; i < MAX; i++) {
            System.out.println(list.get(i));
        }

    }
}

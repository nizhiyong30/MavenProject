package cn.current;

import org.checkerframework.common.util.report.qual.ReportUnqualified;

import java.util.concurrent.*;

public class FutureTaskTest {

    private static ExecutorService threadPoolExecutor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws InterruptedException{

        FutureTask futureTask = new FutureTask(new MyTaCsk(), "default");
        FutureTask futureTask1 = new FutureTask(new MyTaCsk(), "default");
        threadPoolExecutor.submit(futureTask);
        Thread.sleep(1000);
        if (!futureTask.isDone()) {
            futureTask.cancel(true);
        } else {
            System.out.println("futureTask is done");
        }
        threadPoolExecutor.submit(futureTask1);
        Thread.sleep(100);
        if (!futureTask1.isDone()) {
            futureTask1.cancel(true);
        } else {
            System.out.println("futureTask1 is done");
        }
        System.out.println(futureTask.isCancelled());
        System.out.println(futureTask1.isCancelled());
        threadPoolExecutor.shutdownNow();
    }

}

class MyTaCsk implements Runnable {

    @Override
    public void run() {
        int i = 0;
        int j = 1;
        try {
            if (i < j) {
                Thread.sleep(10000);
                System.out.println("--");
            }
            System.out.println("finish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

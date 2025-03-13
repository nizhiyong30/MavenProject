package cn.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author nizy
 * @date 2022/1/8 10:48 上午
 */
public class AccountTest {
    private static Random random = new Random(20);
    private static List<Account> accountList = new ArrayList<>();
    private static CountDownLatch startCount = new CountDownLatch(1);
    private static CountDownLatch endCount = new CountDownLatch(10);

    public static void main(String[] args) throws Exception{
        AccountTest.init(20);
        System.out.println("转账开始-------------------");
        AccountTest.print();
        startCount.countDown();;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        for (int i = 0; i < 10; i++) {
            new Thread(new Task(cyclicBarrier)).start();
        }
        System.out.println("转账结束-------------------");
        endCount.await();
        print();
    }

    public static void init(int accountNum) {
        for (int i = 0; i < accountNum; i++) {
            Account account = new Account("account-" + i, 1000);
            accountList.add(account);
        }
    }

    public static void print() {
        AtomicInteger sum = new AtomicInteger();
        accountList.forEach(account -> {
            sum.addAndGet(account.amount.get());
            System.out.println(account);
        });
        System.out.println("sum = " + sum);
    }


    public static class Task implements Runnable {

        private CyclicBarrier cyclicBarrier;

        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
                startCount.await();
                int count = 0;
                while (count < 100) {
                    transfer();
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                endCount.countDown();
            }
        }

        public void transfer() {
            int fromAccountIndex = random.nextInt(20);
            int toAccountIndex = random.nextInt(20);
            while (fromAccountIndex == toAccountIndex) {
                toAccountIndex = random.nextInt(20);
            }
            int money = random.nextInt(101);
            Account fromAccount = accountList.get(fromAccountIndex);
            Account toAccount = accountList.get(toAccountIndex);
            fromAccount.transfer(-money);
            toAccount.transfer(money);
        }
    }


    public static class Account {
        private String name;
        private AtomicInteger amount;

        public Account() {

        }

        public Account(String name, int amount) {
            this.name = name;
            this.amount = new AtomicInteger(amount);
        }

        public String getName() {
            return this.name;
        }


        public void transfer(int money) {
            amount.addAndGet(money);
        }

        @Override
        public String toString() {
            return "name:" + this.name + ", amount:" + this.amount.get();
        }
    }


}

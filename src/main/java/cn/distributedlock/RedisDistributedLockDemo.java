package cn.distributedlock;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by nizy on 2018/12/17.
 */
public class RedisDistributedLockDemo {

    static private RedisDistributedLock lock = new RedisDistributedLock(RedisClient.getJedisPool());

    static private AtomicLong n = new AtomicLong();

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            ThreadA threadA = new ThreadA();
            threadA.setName("Thread" + i);
            threadA.start();
        }
    }


    static public class ThreadA extends Thread {

        RedisDistributedLock lock = null;

        public ThreadA() {
            try {
                JedisPoolConfig config = new JedisPoolConfig();
                config.setMaxTotal(1024);
                config.setMaxIdle(200);
                config.setMaxWaitMillis(10000);
                config.setTestOnBorrow(true);
                JedisPool jedisPool = new JedisPool(config, "192.168.10.222", 6549);
                lock = new RedisDistributedLock(jedisPool);

            } catch (Exception e) {

                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String requestId = UUID.randomUUID().toString();
            Boolean indentifier = lock.lockWithTimeout("resource", requestId, 1000, 2000);
            if (indentifier) {
                System.out.println(Thread.currentThread().getName() + "获得了锁");
                System.out.println(n.decrementAndGet());
//                lock.releaseLock("resource", requestId);
            }
        }

    }


}
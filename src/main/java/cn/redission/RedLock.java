package cn.redission;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @author nizy
 * @date 2022/1/10 4:19 下午
 */
public class RedLock {

    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + "192.168.200.214:7679").setPassword("3SleghivCarlex9");
        RedissonClient redissonClient = Redisson.create(config);
        RLock lock = redissonClient.getLock("key");
        lock.lock();
        System.out.println("");
    }
}

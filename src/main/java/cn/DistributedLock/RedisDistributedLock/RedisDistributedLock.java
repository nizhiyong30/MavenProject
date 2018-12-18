package cn.DistributedLock.RedisDistributedLock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;

/**
 * Created by nizy on 2018/12/17.
 */
public class RedisDistributedLock {
    private  JedisPool jedisPool;
    private Jedis jedis;
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final Long RELEASE_SUCCESS = 1L;

    public RedisDistributedLock(JedisPool jedispool) {
        this.jedisPool = jedispool;
        this.jedis = jedispool.getResource();
    }

    /**
     * 加锁
     *
     * @param acquireTimeout 获取超时时间
     * @param timeout        锁的超时时间
     * @return 锁标识
     */
    public Boolean lockWithTimeout(String lockKey,String requestId,
                                  long acquireTimeout, long timeout) {
        long end = System.currentTimeMillis() + acquireTimeout;
        String result = null;
        while (System.currentTimeMillis() < end) {

            result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, timeout);
            if (LOCK_SUCCESS.equals(result)) {
                return true;
            }
        }
        System.out.println("等待时间超时");
        return false;
    }

    /**
     * 释放锁
     *
     * @param lockKey   锁的key
     * @param requestId 释放锁的标识
     * @return
     */
    public boolean releaseLock(String lockKey, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        if (RELEASE_SUCCESS.equals(result)) {
            jedis.close();
            return true;
        }
        jedis.close();
        return false;
    }


}

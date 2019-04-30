package cn.distributedlock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by nizy on 2018/12/17.
 */
public class RedisClient {

    private  static JedisPool jedisPool = null;

    static {

        try {

            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(1024);
            config.setMaxIdle(200);
            config.setMaxWaitMillis(10000);
            config.setTestOnBorrow(true);
            jedisPool = new JedisPool(config, "192.168.10.222", 6549);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public synchronized  static JedisPool getJedisPool() {
        try {

            if (jedisPool != null) {
                return jedisPool;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public static void returnResource(final Jedis jedis) {
        if(jedis != null) {
            jedis.close();
        }

    }

    public static void main(String[] args) {
        Jedis jedis = RedisClient.getJedisPool().getResource();
//        jedis.set("test", "nzy");
        System.out.println(jedis.get("test"));
    }
}

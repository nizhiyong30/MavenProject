package cn.learnguava;

import com.google.common.util.concurrent.RateLimiter;

/**
 * Created by nizy on 2019/4/2.
 */
public class RateLimiterTest {
    public static void main(String[] args) {
        RateLimiter rateLimiter =  RateLimiter.create(5);
       while(true) {
           System.out.println("get 1 tokens: " + rateLimiter.acquire() + "s");
       }
    }
}

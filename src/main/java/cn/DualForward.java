//package cn;
//
//import org.quartz.Calendar;
//
//import java.util.concurrent.Executors;
//import java.util.concurrent.ThreadPoolExecutor;
//
//public class DualForward {
//
//    ThreadPoolExecutor trafficThreadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
//            Executors.defaultThreadFactory(), defaultHandler);
//
//    int maxTryTimes;
//    int timeout;
//
//    /**
//     *
//     * @param uri 请求uri，简化起见假设所有请求都是get请求，没有request body。例如http://api.huami.com/users/-/profile
//     * @param targetServiceHost 下游微服务host，例如 http://a.huami.com
//     * @param trafficRepositoryHost 流量存储服务host，例如 http://traffic.huami.com
//     * @return 应该返回客户端的http status code，例如200，404，或者500等
//     */
//    int forward(String uri, String targetServiceHost, String trafficRepositoryHost) {
//        // 返回http status code
//        String key = MD5Util.getMD5(uri);
//        Result result = null;
//        // 先取缓存
//        Object obj = jedis.hget("dualForward", "uri", key);
//        if (obj != null) {
//            result = (Result) obj;
//            return result.getStatus;
//        }
//        trafficThreadPoolExecutor.execute(new TrafficTask(uri, trafficRepositoryHost));
//        int count = 0;
//        while(count < maxTryTimes) {
//            try {
//                result = httpClient.get(targetServiceHost, uri, timeout);
//                if(result.isSuccess) {
//                    jedis.hset("dualForward", "uri", key, result);
//                    return result.getStatus;
//                }
//                count ++;
//            } catch (Exception e) {
//                count ++;
//            }
//        }
//        return result.getStatus;
//    }
//
//    class TrafficTask implements Runnable {
//        String uri;
//        String trafficRepositoryHost;
//        public TrafficTask(String uri, String trafficRepositoryHost) {
//            this.uri = uri;
//            this.trafficRepositoryHost = trafficRepositoryHost
//        }
//        @Override
//        public void run() {
//            int count = 0;
//            while(cout < maxTryTimes) {
//                try {
//                    Result result = httpClient.get(trafficRepositoryHost, uri, timeout);
//                    if (result.isSuccess) {
//                        return;
//                    }
//                    count++;
//                } catch (Exception e) {
//                    count++;
//                }
//            }
//        }
//    }
//}
//

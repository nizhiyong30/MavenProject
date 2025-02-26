package cn.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.concurrent.CountDownLatch;

/**
 * @author kelai 2021-03-27 11:01
 */
public class CuratorTest implements PathChildrenCacheListener {


    private CuratorFramework curatorFramework;


    public void init() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(
                100, 5, 10000);

        curatorFramework = CuratorFrameworkFactory.builder()
                .connectString("192.168.31.207:2181")
                .namespace("nizy")
                .sessionTimeoutMs(45000)
                .connectionTimeoutMs(30000)
                .retryPolicy(retryPolicy)
                .build();
    }

    public void start() {
        curatorFramework.start();
    }

    public void testTmpPath(String path) throws Exception{
        curatorFramework.create()
                .creatingParentContainersIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .forPath(path,"init".getBytes());
    }

    public void createPath(String path) throws Exception{
        curatorFramework.create().forPath(path,"init".getBytes());
    }

    public void deletePath(String path) throws Exception{
        curatorFramework.delete().forPath(path);
    }

    public static void main(String[] args) throws Exception{
        CuratorTest curatorTest = new CuratorTest();
        curatorTest.init();
        curatorTest.start();
        curatorTest.testTmpPath("/tmpPath");
        PathChildrenCache cache = new PathChildrenCache(curatorTest.curatorFramework, "/path1", true);
        cache.getListenable().addListener(curatorTest);
        cache.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);
        NodeCache nodeCache = new NodeCache(curatorTest.curatorFramework, "/path/add2");
        //NodeCacheListener
        NodeCacheListener listener = () -> {
            ChildData data = nodeCache.getCurrentData();
            if (null != data) {
                System.out.println("节点数据：" + new String(nodeCache.getCurrentData().getData()));
            } else {
                System.out.println("节点被删除!");
            }
        };
        nodeCache.getListenable().addListener(listener);
        nodeCache.start();
        while(true) {
            Thread.sleep(5000);
        }
    }

    @Override
    public void  childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
        PathChildrenCacheEvent.Type type = event.getType();
        ChildData childData =  event.getData();
        System.out.println(childData);
    }


}

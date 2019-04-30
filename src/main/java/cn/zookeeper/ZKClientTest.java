package cn.zookeeper;


import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by nizy on 2019/3/20.
 */
public class ZKClientTest {
    private static ZkClient zkClient;

    private static ZooKeeper zooKeeper;

    static {
        zkClient = new ZkClient("192.168.10.218:2181");
        try {
            zooKeeper = new ZooKeeper("192.168.10.218:2181", 5000, (WatchedEvent watchedEvent) -> {
                System.out.println("listening1");
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createNode(String path, String content) throws KeeperException, InterruptedException {
        zooKeeper.create(path, content.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public static List<String> getDataAndWatch(String path) throws KeeperException, InterruptedException {
        List<String> datas = zooKeeper.getChildren("path", false);
        return datas;
    }


    public static void main(String[] args) throws Exception {
        List<String> datas = getDataAndWatch("/");
        for(String data : datas) {
            System.out.println(data);
        }

    }
}

package cn.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

import java.util.List;

/**
 * Created by nizy on 2019/3/21.
 */
public class DistributedClient {
    private String zkAddr = "192.168.10.218:2181,192.168.10.222:2181,192.168.10.223:2181";

    private int SessionTime = 5000;

    private int index = 0;

    private ZkClient zkClient;
    public static void main(String[] args) throws InterruptedException{
        DistributedClient  distributedClient = new DistributedClient();
        distributedClient.connect();
        distributedClient.watch();
        distributedClient.business();
    }

    public void connect() {
        zkClient = new ZkClient(new ZkConnection(zkAddr), SessionTime);
    }

    public void watch() {
        zkClient.subscribeChildChanges("/Distributed", (String parentPath, List<String> currentChilds) ->  {
            System.out.println("第" + (++index) + "变化：");
            System.out.println("parentPath: " + parentPath);
            for(String child : currentChilds) {
                System.out.print(child + " ");
            }
            System.out.println();
            System.out.println("======================");
        });

    }
    public void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }

}

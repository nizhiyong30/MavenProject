package cn.distributedlock.zookeeperdistributedlock;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

/**
 * Created by nizy on 2019/3/21.
 */
public class ZKDistributedLock {

    private String zkAddr = "192.168.10.218:2181,192.168.10.222:2181,192.168.10.223:2181";

    private int SessionTime = 5000;

    private ZkClient zkClient;

    public void register(String hostName) throws InterruptedException {
        synchronized (this) {
            zkClient.createEphemeral("/Distributed/nzy");
            Thread.sleep(5000);
        }
    }

    public void connect() {
        zkClient = new ZkClient(new ZkConnection(zkAddr), SessionTime);

    }

    public static void main(String[] args) {

    }
}

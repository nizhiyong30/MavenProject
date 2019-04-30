package cn.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;
import org.apache.zookeeper.CreateMode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by nizy on 2019/3/21.
 */
public class DistributedServer {
    private String zkAddr = "192.168.10.218:2181,192.168.10.222:2181,192.168.10.223:2181";

    private int SessionTime = 5000;

    private ZkClient zkClient;

    private AtomicInteger index = new AtomicInteger(1);


    public static void main(String[] args) throws InterruptedException {
        DistributedServer distributedClient = new DistributedServer();
        distributedClient.connect();
//        distributedClient.initialize();
        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    distributedClient.register("nzy");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        distributedClient.business();
    }

    public void initialize() throws InterruptedException {
        zkClient.createPersistent("/Distributed");
    }

    public void register(String hostName) throws InterruptedException {
        synchronized (this) {
            zkClient.createEphemeralSequential("/Distributed/nzy", (hostName + String .valueOf(index.getAndAdd(1))).getBytes());
            Thread.sleep(5000);
            System.out.println(zkClient.create("/Distributed/nzy", null, CreateMode.EPHEMERAL));
        }
    }

    public void connect() {
        zkClient = new ZkClient(new ZkConnection(zkAddr), SessionTime);
    }

    public void business() throws InterruptedException {
        Thread.sleep(Long.MAX_VALUE);
    }
}


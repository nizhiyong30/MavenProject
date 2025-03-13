package cn.distributedlock.zookeeperdistributedlock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

/**
 * @author kelai 2020-04-29 15:26
 */
public class InterProcessMutexTest {

    public static void main(String[] args) throws Exception{
        InterProcessMutex interProcessMutex = null;
        interProcessMutex.acquire();
    }
}

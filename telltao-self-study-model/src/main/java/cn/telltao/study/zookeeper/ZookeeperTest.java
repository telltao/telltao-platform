package cn.telltao.study.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooDefs;

import java.util.List;

/**
 * Created By telltao
 * telltao@qq.com
 *  Zookeeper测试相关
 *  使用本地虚拟机的docker进行安装
 *
 *  docker pull zookeeper:3.6.2
 *  docker inspect  zookeeper
 *  docker run -itd --name zookeeper3.6.2 -p 2181:2181 zookeeper
 *  docker exec -it zookeeper3.6.2  bash
 *  cd /apache-zookeeper-3.6.2-bin/
 *  ./zkCli.sh
 *
 *
 * @Date 2020/12/1 10:57
 */
public class ZookeeperTest {

    public static void main(String[] args) throws Exception{
        CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", new RetryNTimes(10, 5000));
        client.start();// 连接
        // 获取子节点，顺便监控子节点
        List<String> children = client.getChildren().usingWatcher(new CuratorWatcher() {
            @Override
            public void process(WatchedEvent event) throws Exception
            {
                System.out.println("监控： " + event);
            }
        }).forPath("/");
        System.out.println(children);
        // 创建节点
        String result = client.create().withMode(CreateMode.PERSISTENT).withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE).forPath("/test", "Data".getBytes());
        System.out.println(result);
        // 设置节点数据
        client.setData().forPath("/test", "111".getBytes());
        client.setData().forPath("/test", "222".getBytes());
        // 删除节点
        //System.out.println(client.checkExists().forPath("/test"));
        /*client.delete().withVersion(-1).forPath("/test");
        System.out.println(client.checkExists().forPath("/test"));*/
        client.close();
        System.out.println("OK！");
    }



}

package cn.NIO;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by nizy on 2019/2/19.
 */
public class NIOServer {

    private int port = 8000;

    private InetSocketAddress address = null;

    public Selector selector;

    public NIOServer(int port) {
        try {
            this.port = port;
            address = new InetSocketAddress(port);
            ServerSocketChannel server = ServerSocketChannel.open();
            server.socket().bind(address);
            selector = Selector.open();
            server.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务器启动成功： " + this.port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        try {
            //轮询
            while(true) {
                int wait = this.selector.select();
                if (wait == 0) {
                    continue;
                }
                Set<SelectionKey> keys = this.selector.selectedKeys();
                Iterator<SelectionKey> i = keys.iterator();
                while(i.hasNext()) {
                    SelectionKey key = i.next();
                    //针对每一个客户端进行操作。
                    process(key);
                    i.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void process(SelectionKey key) throws  Exception{
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        if (key.isAcceptable()) {
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            SocketChannel client = server.accept();
            client.configureBlocking(false);
            //客户端一旦连接上来，读写。往这个selector上注册 read,接下来可以读。
            client.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            SocketChannel client = (SocketChannel) key.channel();
            int len = client.read(buffer);
            if (len > 0) {
                buffer.flip();
                String content = new String(buffer.array(),0, len);
                System.out.println(content);
                client.register(selector, SelectionKey.OP_WRITE);
            }
            buffer.clear();
        } else if (key.isWritable()) {
            SocketChannel client = (SocketChannel) key.channel();
            client.write(ByteBuffer.wrap("write something".getBytes()));
            client.close();
        }
    }

    public static void main(String[] args) {
        new NIOServer(8000).listen();
    }
}

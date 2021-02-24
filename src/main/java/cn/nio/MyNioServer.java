package cn.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;


public class MyNioServer {
    //创建一个选择器
    private Selector selector;
    private final static int port = 8686;
    private final static int BUF_SIZE = 10240;

    private void initServer() throws IOException {
        //创建通道管理器对象selector
        this.selector = Selector.open();

        //创建一个通道对象channel
        ServerSocketChannel channel = ServerSocketChannel.open();
        //将通道设置为非阻塞
        channel.configureBlocking(false);
        //将通道绑定在8686端口
        channel.socket().bind(new InetSocketAddress(port));

        //将上述的通道管理器和通道绑定，并为该通道注册OP_ACCEPT事件
        //注册事件后，当该事件到达时，selector.select()会返回（一个key），如果该事件没到达selector.select()会一直阻塞
        SelectionKey selectionKey = channel.register(selector, SelectionKey.OP_ACCEPT);

        //轮询
        while (true) {
            //这是一个阻塞方法，一直等待直到有数据可读，返回值是key的数量（可以有多个）
            selector.select();
            //如果channel有数据了，将生成的key访入keys集合中
            Set keys = selector.selectedKeys();
            //得到这个keys集合的迭代器
            Iterator iterator = keys.iterator();
            //使用迭代器遍历集合
            while (iterator.hasNext()) {
                //得到集合中的一个key实例
                SelectionKey key = (SelectionKey) iterator.next();
                //拿到当前key实例之后记得在迭代器中将这个元素删除，非常重要，否则会出错
                iterator.remove();
                //判断当前key所代表的channel是否在Acceptable状态，如果是就进行接收
                if (key.isAcceptable()) {
                    doAccept(key);
                } else if (key.isReadable()) {
                    doRead(key);
                } else if (key.isWritable() && key.isValid()) {
                    doWrite(key);
                } else if (key.isConnectable()) {
                    System.out.println("连接成功！");
                }
            }
        }
    }

    public void doAccept(SelectionKey key) throws IOException {
        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
        System.out.println("ServerSocketChannel正在循环监听");
        SocketChannel clientChannel = serverChannel.accept();
        clientChannel.configureBlocking(false);
        //向客户端发消息
//        clientChannel.write(ByteBuffer.wrap(new String("send message to client").getBytes()));
        clientChannel.register(key.selector(), SelectionKey.OP_READ);
    }

    public void doRead(SelectionKey key) throws IOException {
        SocketChannel clientChannel = (SocketChannel) key.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(BUF_SIZE);
        long bytesRead = clientChannel.read(byteBuffer);
        while (bytesRead > 0) {
            byteBuffer.flip();
            byte[] data = byteBuffer.array();
            String info = new String(data).trim();
            System.out.println("从客户端发送过来的消息是：" + info);
            byteBuffer.clear();
            bytesRead = clientChannel.read(byteBuffer);
        }
//        clientChannel.register(key.selector(),SelectionKey.OP_WRITE);
        if (bytesRead == -1) {
            clientChannel.close();
        }

    }

    public void doWrite(SelectionKey key) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(BUF_SIZE);
        byteBuffer.flip();
        SocketChannel clientChannel = (SocketChannel) key.channel();
        while (byteBuffer.hasRemaining()) {
            clientChannel.write(byteBuffer);
        }
        byteBuffer.compact();
    }

    public static void main(String[] args) throws IOException {
        MyNioServer myNioServer = new MyNioServer();
        myNioServer.initServer();
    }
}

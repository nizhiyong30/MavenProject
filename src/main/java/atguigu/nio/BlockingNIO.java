package atguigu.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;

/**
 * @author kelai 2020-02-29 18:29
 */
public class BlockingNIO {


    @Test
    public void client() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8071));
        FileChannel inChannel = new FileInputStream("/Users/nizhiyong/Study/code/MavenProject/src/main/java/atguigu/nio/test.java").getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while(inChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        socketChannel.shutdownOutput();
        //接收服务端反馈
        int len = 0;
        while((len = socketChannel.read(byteBuffer)) != -1) {
            byteBuffer.flip();
            System.out.println(new String(byteBuffer.array(), 0, len));
            byteBuffer.clear();
        }
        inChannel.close();
        socketChannel.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8071));
        FileChannel outChannle = new FileOutputStream("/Users/nizhiyong/Study/code/MavenProject/src/main/java/atguigu/nio/2.java").getChannel();
        SocketChannel clientSocketChannel = serverSocketChannel.accept();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (clientSocketChannel.read(buffer) != -1) {
            buffer.flip();
            outChannle.write(buffer);
            buffer.clear();
        }
        buffer.put("服务端接受成功".getBytes());
        buffer.flip();
        clientSocketChannel.write(buffer);
        clientSocketChannel.close();
        outChannle.close();
        serverSocketChannel.close();
    }
}

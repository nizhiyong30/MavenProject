package netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import netty.handler.ChildChannelHandler;

/**
 * @author kelai 2020-03-06 16:42
 */
public class TimeServer {

    public static void bind(int port) {
        EventLoopGroup masterGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(masterGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChildChannelHandler());
            //绑定端口，同步等待成功
            System.out.println("绑定端口，同步等待成功.......");
            ChannelFuture future = bootstrap.bind(port).sync();
            //等待服务端监听端口关闭
            future.channel().closeFuture().sync();
            System.out.println("等待服务端口监听端口失败....");
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            // 优雅退出释放线程池
            masterGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
            System.out.println("优雅退出释放线程池");
        }
    }

    public static void main(String[] args) {
        TimeServer.bind(8092);
    }
}

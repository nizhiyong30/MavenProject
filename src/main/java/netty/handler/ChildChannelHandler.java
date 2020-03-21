package netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;

import javax.xml.bind.SchemaOutputResolver;

/**
 * @author kelai 2020-03-05 21:55
 */
public class ChildChannelHandler extends ChannelInitializer {

    @Override
    protected void initChannel(Channel channel) throws Exception {
        System.out.println(Thread.currentThread().getName());
        channel.pipeline().addLast(new TimeServerHandler());
    }

    private static class TimeServerHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            // channelRead方法中的msg参数（服务器中接收到的客户端发送的消息）强转换为ByteBuf类型
            System.out.println(Thread.currentThread().getName());
            ByteBuf buf = (ByteBuf) msg;
            byte[] req = new byte[buf.readableBytes()];
            buf.readBytes(req);
            String body = new String(req, "UTF-8");
            System.out.println("TimeServer 接收到的消息 :" + body);
            ByteBuf resp = Unpooled.copiedBuffer("what do u say".getBytes());
            ctx.write(resp);
        }


        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            //将消息队列中信息写入到SocketChannel中去，解决了频繁唤醒Selector所带来的不必要的性能开销
            //netty的write只是将消息放到缓冲数组，再通过调用flush才会把缓冲区的数据写入到SocketChannle
            ctx.flush();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            ctx.close();
        }
    }

    public static void main(String[] args) {
    }
}

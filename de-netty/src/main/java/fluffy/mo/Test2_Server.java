package fluffy.mo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.CharsetUtil;

/**
 * 目标 ：理解处理链 ChannelHandler  
 * 两个子类
 * 处理输入数据的ChannelInboundHandlerAdapter. 
 * 处理输出数据的ChannelOutboundHandlerAdapter. 
 *
 */
public class Test2_Server {

  static final boolean SSL = System.getProperty("ssl") != null;
  static final int PORT = Integer.parseInt(System.getProperty("port", "8009"));

  public static void main(String[] args) throws Exception {
    final ByteBuf buf = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Hi!\r\n", CharsetUtil.UTF_8));

    EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    try {
      ServerBootstrap b = new ServerBootstrap();
      // 一个用Group来接受客户端请求，连接建立后会转给另一个Group来处理具体的通信交互逻辑
      b.group(bossGroup, workerGroup)
          //
          .option(ChannelOption.TCP_NODELAY, true)
          //
          .option(ChannelOption.RCVBUF_ALLOCATOR, AdaptiveRecvByteBufAllocator.DEFAULT)
          // 通过设置不同的class可以实现nio oio
          .channel(NioServerSocketChannel.class).handler(new LoggingHandler(LogLevel.INFO))
          .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) {
              ChannelPipeline p = ch.pipeline();
              // 依次添加处理器
              p.addLast("decoder", new StringDecoder());
              p.addLast("encoder", new StringEncoder());
              p.addLast(new Test2_ServerHandler());
              p.addLast(new Test2_ServerHandler2());
              p.addLast(new Test2_ServerHandler3());
            }
          });

      // Bind and start to accept incoming connections.
      ChannelFuture f = b.bind(PORT).sync();

      System.out.println("server 启动成功");
      f.channel().closeFuture().sync();
      System.out.println("server 停止阻塞解除");
    } finally {
      workerGroup.shutdownGracefully();
      bossGroup.shutdownGracefully();
    }
  }
}

package fluffy.mo.test3;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Test3_Client {

  static final String HOST = System.getProperty("host", "127.0.0.1");
  static final int PORT = Integer.parseInt(System.getProperty("port", "8009"));

  public static void main(String[] args) throws Exception {

    EventLoopGroup group = new NioEventLoopGroup();
    try {
      Bootstrap b = new Bootstrap();
      b.group(group).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
        @Override
        protected void initChannel(SocketChannel ch) throws Exception {
          ch.pipeline()
          .addLast("decoder", new RpcDecoder(Test3_person.class))
          .addLast("encoder", new RpcEncoder(Test3_person.class))
          .addLast(new Test3_ClientHandler());
        }
      });

      ChannelFuture f = b.connect(HOST, PORT).sync();

      f.channel().closeFuture().sync();
    } finally {
      group.shutdownGracefully();
    }
  }

}

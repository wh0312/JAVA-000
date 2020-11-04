package io.github.kimmking.gateway.inbound;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpInboundServer {

    private static Logger logger = LoggerFactory.getLogger(HttpInboundServer.class);
    String proxyServer;
    private int port;
    public HttpInboundServer(int port, String serverAddress)
    {
        this.port = port;
        this.proxyServer = serverAddress;
    }

    public void run() throws InterruptedException {
        NioEventLoopGroup bossEventLoopGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workerEventLoopGroup = new NioEventLoopGroup(16);

        try
        {
            ServerBootstrap b = new ServerBootstrap();

            b.option(ChannelOption.SO_BACKLOG, 128);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.option(ChannelOption.SO_RCVBUF, 32 * 1024).option(ChannelOption.SO_SNDBUF, 32*1024);
            b.group(bossEventLoopGroup, workerEventLoopGroup).channel(NioServerSocketChannel.class).handler(new LoggingHandler(LogLevel.INFO)).childHandler(new HttpInitializer(proxyServer));

            Channel c = b.bind(port).sync().channel();
            logger.info("开始监听端口" + port);
            System.out.print("开始监听端口" + port);
            c.closeFuture().sync();

        } finally {
            bossEventLoopGroup.shutdownGracefully();
            workerEventLoopGroup.shutdownGracefully();
        }

    }
}

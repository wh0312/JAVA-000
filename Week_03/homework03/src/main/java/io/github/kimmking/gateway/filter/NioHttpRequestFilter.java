package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class NioHttpRequestFilter implements HttpRequestFilter{
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx)
    {
        fullRequest.headers().set("NIO", "WUHAO");
        System.out.println("NioHttpRequestFilter is filtered");
    }
}

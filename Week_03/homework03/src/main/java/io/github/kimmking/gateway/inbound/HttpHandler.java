package io.github.kimmking.gateway.inbound;

import io.github.kimmking.gateway.filter.NioHttpRequestFilter;
import io.github.kimmking.gateway.outbound.httpclient4.HttpOutboundHandler;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import static io.netty.handler.codec.http.HttpHeaderNames.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaderValues.KEEP_ALIVE;
import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

public class HttpHandler extends ChannelInboundHandlerAdapter {

    HttpOutboundHandler handler;
    public HttpHandler(String serverURL)
    {
        handler = new HttpOutboundHandler(serverURL);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try
        {
            FullHttpRequest request = (FullHttpRequest)msg;
            System.out.println("channelRead");
            NioHttpRequestFilter filter = new NioHttpRequestFilter();
            filter.filter(request, ctx);
            handler.handle(request, ctx);
            HttpHeaders headers = request.headers();
            List<Map.Entry<String, String>> lists =  headers.entries();
            for(int i = 0; i < lists.size();i++)
            {
                Map.Entry<String, String> item = lists.get(i);
                System.out.println(item.getKey() + " " + item.getValue());
            }

        }finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

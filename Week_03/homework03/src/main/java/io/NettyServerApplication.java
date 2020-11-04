package io;

import io.github.kimmking.gateway.inbound.HttpInboundServer;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class NettyServerApplication {
    public static void main(String[] args)
    {
        HttpInboundServer server = new HttpInboundServer(8188, "http://localhost:8808");
        try {
            server.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

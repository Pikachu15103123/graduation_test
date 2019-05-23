import java.util.Iterator;
import java.util.Map;

import okhttp3.Request;//OkHttp是一个高效的HTTP客户端,它的请求/响应 API 使用构造器模式builders来设计，它支持阻塞式的同步请求和带回调的异步请求。

//TextMap 是一个Opentracing内置的carrier 用于对Span上下文进行序列化和反序列化
public class RequestBuilderCarrier implements io.opentracing.propagation.TextMap {
    private final Request.Builder builder;

    RequestBuilderCarrier(Request.Builder builder) {
        this.builder = builder;
    }

    @Override
    public Iterator<Map.Entry<String, String>> iterator() {
        throw new UnsupportedOperationException("carrier is write-only");
    }

    @Override
    public void put(String key, String value) {
        builder.addHeader(key, value);
    }
}

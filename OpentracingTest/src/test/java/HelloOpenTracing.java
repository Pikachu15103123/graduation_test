
import com.google.common.collect.ImmutableMap;

import io.jaegertracing.internal.JaegerTracer;
import io.opentracing.Span;
import io.opentracing.Tracer;
//import lib.Tracing;

public class HelloOpenTracing {

	private final Tracer tracer; // 来自Opentracing的开发接口Tracer,里面有SpanBuilder初始化Span的attribute

	public HelloOpenTracing(Tracer tracer) {
		this.tracer = tracer; //tracer接口是来自与Opentracing API
	}

	private void sayHellotoOpentracing(String helloTo) {
		Span span = tracer.buildSpan("sayHello").start();// tracer创建一个span并使激活它
		span.setTag("hello-to", helloTo); // 设置span的tag标签

		String helloStr = String.format("Hello, %s!", helloTo);
		span.log(ImmutableMap.of("event", "string-format", "value", helloStr));
		// 对span设置日志

		System.out.println(helloStr);
		span.log(ImmutableMap.of("event", "println"));
		// ImmutableMap是一个不可变集合，简单地说，如果一个
		//对象实例不能被更改就是一个Immutable的对象，Java SDK提供的大量值对象，
		//比如String等都是Immutable的对象。
		span.finish();
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("Expecting one argument");
		}

		String helloTo = args[0];
		try (JaegerTracer tracer = Tracing.init("Hello-Opentracing")) {
			//for(int i=0;i<1000000;i++) {
			new HelloOpenTracing(tracer).sayHellotoOpentracing(helloTo);
			//}
			//new HelloOpenTracing(tracer).sayHello(helloTo);
		}
	}
	
	
}

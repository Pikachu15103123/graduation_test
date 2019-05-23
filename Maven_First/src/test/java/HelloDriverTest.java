
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import com.sun.jmx.snmp.Timestamp;

import io.opentracing.SpanContext;
import io.opentracing.mock.MockSpan;
import io.opentracing.mock.MockTracer;
import io.opentracing.propagation.Format;
import io.opentracing.propagation.TextMap;
import io.opentracing.propagation.Format.Builtin;
import io.opentracing.tag.Tags;

public class HelloDriverTest {
	
	public static void main(String args[]) {
//		Hello h = new Hello();
//		h.sayName("Durant");

		// Initialize MockTracer with the default values.
		MockTracer tracer = new MockTracer();

		// Create a new Span, representing an operation.
		MockSpan span = tracer.buildSpan("foo").start();

		// Add a tag to the Span.
		span.setTag(Tags.COMPONENT.toString(), "my-own-application");
		span.log("Test logs.");
		// Finish the Span.
		span.finish();
		
		//tracer.inject(span.context(), Format.Builtin.HTTP_HEADERS, Format.Builtin.HTTP_HEADERS);
		
		System.out.println(span.toString());
		
		MockSpan span2 = tracer.buildSpan("Create a graph noew").start();
		span2.setTag(Tags.COMPONENT.toString(), "my-own-application");
		span2.context();
		span2.finish();
		System.out.println(span2.toString());
		//System.out.println();
		
		//span.finish();
		// Analize the saved Span.
		/*
		long millis = TimeUnit.MILLISECONDS.convert(span.startMicros(), TimeUnit.MICROSECONDS);
		Timestamp time = new Timestamp(millis);
		long millis2 = TimeUnit.MILLISECONDS.convert(span.finishMicros(), TimeUnit.MICROSECONDS);
		Timestamp time2 = new Timestamp(millis2);
		
		System.out.println("Operation name = " + span.operationName());
		System.out.println("Start = " + span.startMicros());
		//System.out.println("Start Date:"+TimeStamp2Date(String.valueOf(1000000*span.startMicros())));
		System.out.println("Start Date:"+time);
		System.out.println("Finish = " + span.finishMicros());
		//System.out.println("Start Date:"+TimeStamp2Date(String.valueOf(1000000*span.finishMicros())));
		System.out.println("Start Date:"+time2);
		System.out.println("Diff:"+(span.finishMicros()-span.startMicros()));
		
		// Inspect the Span's tags.
		Map<String, Object> tags = span.tags();
		System.out.println("The value of tags:"+tags);
		
		*/

	}
	
	
	//Convert Unix timestamp to normal date style  
	public static String TimeStamp2Date(String timestampString){  
	    Long timestamp = Long.parseLong(timestampString)*1000;  
	    String date = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(timestamp));  
	    return date;  
	} 
	
	
//	public static void test(int count) {
//		Timer nTimer = new Timer();
//        nTimer.schedule(new TimerTask() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				
//			}
//        },2000);
//        
//		int j=0;
//		for(int k=0;k<count;k++) {
//			for(int i=0;i<1000000000;i++) {
//				j++;
//			}
//		}
//		
//	}
	
}

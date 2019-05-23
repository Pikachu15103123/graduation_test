
import java.util.Map;
import io.opentracing.mock.MockTracer;
import io.opentracing.mock.MockSpan;
import io.opentracing.tags.Tags;

// Initialize MockTracer with the default values.
MockTracer tracer = new MockTracer();

// Create a new Span, representing an operation.
MockSpan span = tracer.buildSpan("foo").start();

// Add a tag to the Span.
span.setTag(Tags.COMPONENT, "my-own-application");

// Finish the Span.
span.finish();

// Analize the saved Span.
System.out.println("Operation name = " + span.operationName());
System.out.println("Start = " + span.startMicros());
System.out.println("Finish = " + span.finishMicros());

// Inspect the Span's tags.
Map<String, Object> tags = span.tags();
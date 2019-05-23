import java.util.HashMap;
import java.util.Map;

public class Node { // span node
	
	
	//Node nextNode; // next field
	
	String x_request_id;
    String x_b3_traceid;
    String x_b3_spanid;
    String x_b3_parentspanid; 
    String x_b3_sampled; // 采样率
    String x_b3_flags;
    String x_ot_span_context; //The x-ot-span-context HTTP header is used by Envoy to establish proper parent-child relationships between tracing spans when used with the LightStep tracer. 
    
    String tagString;
    String keyValue;
    Map<Object, Object> map = new HashMap<>();
    
    public void setTag(String keyValue,String tagString) {
    	this.tagString = tagString;
    	this.keyValue = keyValue;
    	map.put(this.keyValue,this.tagString);
    }

}
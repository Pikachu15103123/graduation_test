import java.io.IOException;

public class Testdriver {
	public static void main(String []args) throws IOException {
		test test = new test();
		
		for(int i=1;i<=10000;i++) {
			test.tt();
		}
				
	}
}

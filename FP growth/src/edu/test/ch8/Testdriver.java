package edu.test.ch8;

import java.io.IOException;

public class Testdriver {
	public static void main(String []args) throws IOException {
		FPGrowth test = new FPGrowth();
		
		for(int i=1;i<=10000;i++) {
			FPGrowth.tt();
		}
				
	}
}

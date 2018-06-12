package chapter3;

import java.util.Vector;

public class DumpOOM {
	public static void main(String[] args) {
		Vector<byte[]> v = new Vector<byte[]>();
		for(int i=0;i<25;i++){
			v.add(new byte[1*1024*1024]);
		}
	}
}

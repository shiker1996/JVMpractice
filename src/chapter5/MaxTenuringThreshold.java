package chapter5;

import java.util.HashMap;
import java.util.Map;

public class MaxTenuringThreshold {
	public static final int _1M = 1024*1024;
	public static final int _1k = 1024;
	public static void main(String[] args) {
		Map<Integer, byte[]> map = new HashMap<Integer, byte[]>();
		for(int i=0;i<5*_1k;i++){
			byte[] b = new byte[_1k];
			map.put(i, b);
		}
		for (int k = 0; k < 17; k++) {
			for(int i=0;i<270;i++){
				byte[] g = new byte[_1M];
			}
		}
	}
}

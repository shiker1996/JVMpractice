package chapter5;

public class GCtools {
	private final static int _1MB = 1024 * 1024;

	public static void allocation() {
		byte[] allocation1, allocation2, allocation3, allocation4, allocation5;
		allocation1 = new byte[6 * _1MB];
		allocation2 = new byte[6 * _1MB];
		allocation3 = new byte[1 * _1MB];
		allocation3 = null;
		allocation4 = new byte[1 * _1MB];
		allocation4 = null;
		allocation5 = new byte[1 * _1MB];
	}

	public static void main(String[] args) {
		allocation();
	}
}

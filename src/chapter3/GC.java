package chapter3;

/**
 * 创建实例，演示垃圾回收
 * 
 * @author shiker 
 * -verbose:gc -Xms20M -Xmx20M(设置堆容量为20M) -Xmn10M(新生代容量10M) -XX:SurvivorRatio=8(survivor占比8：1)
 *         -XX:+UseSerialGC(串行收集)
 */
public class GC {

	private final static int _1MB = 1024 * 1024;

	public static void allocation() {
		byte[] allocation1, allocation2, allocation3, allocation4, allocation5;
		allocation1 = new byte[6 * _1MB];
		allocation1 = null;
		allocation2 = new byte[6 * _1MB];
		allocation2 = null;
		allocation3 = new byte[6 * _1MB];
		allocation3 = null;
		allocation4 = new byte[6 * _1MB];
		allocation4 = null;
		allocation5 = new byte[6 * _1MB];
	}

	public static void main(String[] args) {
		allocation();
	}
}

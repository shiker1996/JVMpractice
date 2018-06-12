package chapter3;

public class HeapAlloc {
	private final static int _1MB = 1024*1024;
	public static void main(String[] args) {
		
		System.out.print("maxMemory=");
		System.out.println(Runtime.getRuntime().maxMemory()/_1MB+"MB");
		System.out.print("free mem=");
		System.out.println(Runtime.getRuntime().freeMemory()/_1MB+"MB");
		System.out.print("total meme");
		System.out.println(Runtime.getRuntime().totalMemory()/_1MB+"MB");
		
		byte[] b = new byte[1*_1MB];
		System.out.println("分配1M空间给数组");
		
		System.out.print("maxMemory=");
		System.out.println(Runtime.getRuntime().maxMemory()/_1MB+"MB");
		System.out.print("free mem=");
		System.out.println(Runtime.getRuntime().freeMemory()/_1MB+"MB");
		System.out.print("total meme");
		System.out.println(Runtime.getRuntime().totalMemory()/_1MB+"MB");
		
		b = new byte[4*_1MB];
		System.out.println("分配4M空间给数组");
		
		System.out.print("maxMemory=");
		System.out.println(Runtime.getRuntime().maxMemory()/_1MB+"MB");
		System.out.print("free mem=");
		System.out.println(Runtime.getRuntime().freeMemory()/_1MB+"MB");
		System.out.print("total meme");
		System.out.println(Runtime.getRuntime().totalMemory()/_1MB+"MB");
	}
}

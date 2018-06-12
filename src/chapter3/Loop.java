package chapter3;

public class Loop {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			System.out.println("hello world!");
			Thread.sleep(10000);
		}
	}
}

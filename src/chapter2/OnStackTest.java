package chapter2;

public class OnStackTest {
	public static class User{
		public int id;
		public String name;
	}
	//private static User u;//逃逸对象
	public static void alloc(){
		User u = new User();//非逃逸对象，该对象没有被alloc函数返回，未发生逃逸
		u.id = 5;
		u.name = "geym";
	}
	public static void main(String[] args) {
		long b = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {
			alloc();
		}
		long e = System.currentTimeMillis();
		System.out.println(e-b);
	}
}

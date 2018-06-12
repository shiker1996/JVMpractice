package chapter4;

import java.lang.ref.SoftReference;

public class SoftRef {
	public static void main(String[] args) {
		User u = new User(1, "geym");
		SoftReference<User> userSoftRef = new SoftReference<User>(u);
		u = null;
		System.out.println(userSoftRef.get());
		// 进行一次垃圾回收
		System.gc();
		System.out.print("After first GC:");
		System.out.println(userSoftRef.get());
		// 创建对象，进行第二次垃圾回收
		try {
			byte[] b = new byte[1024 * 894 * 7];
			System.gc();
		} catch (OutOfMemoryError e) {
			System.out.println("After second GC:"+userSoftRef.get());
		}
	}
}

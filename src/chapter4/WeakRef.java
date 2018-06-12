package chapter4;

import java.lang.ref.WeakReference;

public class WeakRef {
	public static void main(String[] args) {
		User u = new User(1, "geym");
		WeakReference<User> userWeakRef = new WeakReference<User>(u);
		u=null;
		System.out.println(userWeakRef.get());
		System.gc();
		System.out.print("After first GC:");
		System.out.println(userWeakRef.get());
	}
}

package chapter4;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class SoftRefQ {

	public static class UserSoftReference extends SoftReference<User> {
		int uid;

		public UserSoftReference(User referent, ReferenceQueue<? super User> q) {
			super(referent, q);
			uid = referent.id;
		}
	}

	static ReferenceQueue<User> softQueue = null;
	//创建守护线程，判断引用更改后的对象是否在引用队列中
	public static class checkRefQueue extends Thread {
		@Override
		public void run() {
			while (true) {
				if (softQueue != null) {//如果引用队列不为null，则获取引用队列中的元素
					UserSoftReference obj = null;
					try {
						obj = (UserSoftReference) softQueue.remove();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (obj != null) {
						System.out.println("user id " + obj.uid + " is delete");
					}
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t = new checkRefQueue();
		t.setDaemon(true);
		t.start();
		User u = new User(1, "geym");
		softQueue = new ReferenceQueue<User>();
		UserSoftReference userSoftRef = new UserSoftReference(u, softQueue);
		u = null;
		System.out.println(userSoftRef.get());
		System.gc();
		System.out.print("After first GC:");
		System.out.println(userSoftRef.get());
		System.out.println("try to create byte array and GC");
		// 创建对象，进行第二次垃圾回收
		try {
			byte[] b = new byte[1024 * 894 * 7];
			System.gc();
		} catch (OutOfMemoryError e) {
			Thread.sleep(1000); 
			System.out.println("After second GC:" + userSoftRef.get());
		}
	}
}

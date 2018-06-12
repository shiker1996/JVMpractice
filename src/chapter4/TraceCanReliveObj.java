package chapter4;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class TraceCanReliveObj {
	public static TraceCanReliveObj obj;
	static ReferenceQueue<TraceCanReliveObj> phantomQueue=null;
	public static class CheckRefQueue extends Thread{
		@Override
		public void run() {
			while(true){
				if(phantomQueue!=null){
					PhantomReference<TraceCanReliveObj> objt = null;
					try{
						objt = (PhantomReference<TraceCanReliveObj>)phantomQueue.remove();
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					if(objt!=null){
						System.out.println("TraceCanReliveObj is delete by GC");
					}
				}
			}
		}
	}
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("CanReliveObj finalize called");
		obj=this;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "l am CanReliveObj";
	}
	public static void main(String[] args) throws InterruptedException {
		Thread t = new CheckRefQueue();
		t.setDaemon(true);
		t.start();
		phantomQueue = new ReferenceQueue<TraceCanReliveObj>();
		obj = new TraceCanReliveObj();
		PhantomReference<TraceCanReliveObj> phantomRef = new PhantomReference<TraceCanReliveObj>(obj, phantomQueue);
		obj = null;
		System.gc();
		Thread.sleep(1000);
		if(obj==null){
			System.out.println("obj is null");
		}else{
			System.out.println("obj is used");
		}
		System.out.println("second GC");
		obj = null;
		System.gc();
		Thread.sleep(1000);
		if(obj==null){
			System.out.println("obj is null");
		}else{
			System.out.println("obj is used");
		}
	}
}

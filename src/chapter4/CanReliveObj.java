package chapter4;

public class CanReliveObj {
	public static CanReliveObj obj;
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("CanReliveObj finalize called");
		obj = this;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "I am CanReliceObj";
	}
	public static void main(String[] args) throws InterruptedException {
		obj = new CanReliveObj();
		obj =null;
		System.gc();
		Thread.sleep(1000);
		if(obj==null){
			System.out.println("obj is null");
		}else{
			System.out.println("obj is useful");
		}
		System.out.println("second GC");
		obj=null;
		System.gc();
		Thread.sleep(1000);
		if(obj==null){
			System.out.println("obj is null");
		}else{
			System.out.println("obj is useful");
		}
	}
}

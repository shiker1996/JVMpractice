package chapter2;

public class LocalvarGC {
	public void localcarGC1(){
		byte[] a = new byte[6*1024*1024];
		System.gc();
	}
	public void localcarGC2(){
		byte[] a = new byte[6*1024*1024];
		a=null;
		System.gc();
	}
	public void localcarGC3(){
		{
			byte[] a = new byte[6*1024*1024];
		}
		System.gc();
	}
	public void localcarGC4(){
		{
			byte[] a = new byte[6*1024*1024];
		}
		int c=10;
		System.gc();
	}
	public void localcarGC5(){
		localcarGC1();
		System.gc();
	}
	public static void main(String[] args) {
		LocalvarGC gc = new LocalvarGC();
		gc.localcarGC1();
		gc.localcarGC2();
		gc.localcarGC3();
		gc.localcarGC4();
		gc.localcarGC5();
	}
}

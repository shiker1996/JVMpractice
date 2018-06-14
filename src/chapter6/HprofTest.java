package chapter6;

public class HprofTest {
	public void slowMethod(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void slowerMethod(){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void fastMethod(){
		try{
			Thread.yield();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		HprofTest test = new HprofTest();
		test.fastMethod();
		test.slowMethod();
		test.slowerMethod();
	}
}

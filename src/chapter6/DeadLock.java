package chapter6;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLock extends Thread	{
	protected Object myDirect;
	static ReentrantLock south = new ReentrantLock();
	static ReentrantLock north = new ReentrantLock();
	public DeadLock(Object myDirect) {
		super();
		this.myDirect = myDirect;
		if(this.myDirect==south){
			this.setName("south");
		}
		if(this.myDirect==north){
			this.setName("north");
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		if(myDirect==south){
			try {
				north.lockInterruptibly();
				Thread.sleep(500);
				south.lockInterruptibly();
				System.out.println("car to south has passed");
			} catch (InterruptedException e) {
				System.out.println("car to south is killed");
			}finally{
				if(north.isHeldByCurrentThread())
					north.unlock();
				if(south.isHeldByCurrentThread())
					south.unlock();
			}
		}
		if(myDirect==north){
			try {
				south.lockInterruptibly();
				Thread.sleep(500);
				north.lockInterruptibly();
				System.out.println("car to north has passed");
			} catch (InterruptedException e) {
				System.out.println("car to north is killed");
			}finally{
				if(north.isHeldByCurrentThread())
					north.unlock();
				if(south.isHeldByCurrentThread())
					south.unlock();
			}
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		DeadLock car2south = new DeadLock(south);
		DeadLock car2north = new DeadLock(north);
		car2south.start();
		car2north.start();
		Thread.sleep(1000);
	}
}

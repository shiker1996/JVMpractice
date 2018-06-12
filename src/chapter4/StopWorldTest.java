package chapter4;

import java.util.HashMap;

public class StopWorldTest {
	public static class MyThread extends Thread{
		HashMap<Long, byte[]> map = new HashMap<Long, byte[]>();
		@Override
		public void run() {
			try{
				while(true){
					if(map.size()/1024>=550){
						map.clear();
						System.out.println("clean map");
					}
					byte[] b1;
					for(int i=0;i<100;i++){
						b1 = new byte[1024];
						map.put(System.nanoTime(), b1);
					}
					Thread.sleep(1);
				}
			}catch(Exception e){
				
			}
		}
	}
	public static class PrintThread extends Thread{
		public static final long starttime = System.currentTimeMillis();
		@Override
		public void run() {
			try{
				while(true){
					long t = System.currentTimeMillis()-starttime;
					System.out.println(t/1000+"."+t%1000);
					Thread.sleep(100);
				}
			}catch(InterruptedException e){
				
			}
		}
	}
	public static void main(String[] args) {
		MyThread t = new MyThread();
		PrintThread p = new PrintThread();
		t.start();
		p.start();
	}
}

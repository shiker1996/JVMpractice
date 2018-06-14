package chapter6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class HostIOMian {
	public static class HoldIOTask implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				try{
					FileOutputStream fos = new FileOutputStream(new File("temp"));
					for(int i=0;i<10000;i++)
						fos.write(i);
					fos.close();
					FileInputStream fis = new FileInputStream(new File("temp"));
					while(fis.read()!=-1);
				}catch(Exception e){
				}
			}
		}
	}
	public static class LazyTask implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				while(true){
					Thread.sleep(1000);
				}
			}catch(Exception e){
			}
		}
	}
	public static void main(String[] args) {
		new Thread(new HoldIOTask()).start();
		new Thread(new LazyTask()).start();
		new Thread(new LazyTask()).start();
		new Thread(new LazyTask()).start();
	}
}

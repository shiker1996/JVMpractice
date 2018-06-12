package chapter3;

import java.nio.ByteBuffer;

public class AccessDirecBuffer1 {
	public void directAccess(){
		long starttime = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) {
			ByteBuffer b = ByteBuffer.allocateDirect(1000);
		}
		long endtime = System.currentTimeMillis();
		System.out.println("testDirectWrite:"+(endtime-starttime));
	}
	public void bufferAccess(){
		long starttime = System.currentTimeMillis();
		for (int i = 0; i < 200000; i++) {
			ByteBuffer b = ByteBuffer.allocate(1000);
		}
		long endtime = System.currentTimeMillis();
		System.out.println("testBufferWrite:"+(endtime-starttime));
	}
	public static void main(String[] args) {
		AccessDirecBuffer1 alloc = new AccessDirecBuffer1();
		alloc.bufferAccess();
		alloc.directAccess();
		alloc.bufferAccess();
		alloc.directAccess();
	}
}

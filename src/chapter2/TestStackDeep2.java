package chapter2;

public class TestStackDeep2 {
	private static int count =0 ;
	public static void recursion(long a,long b,long c){
		long e=1,f=2,g=3,h=4,i=5,k=6,q=7,x=8,y=9,z=10;
		count++;
		recursion(a, b, c);
	}
	public static void recursion(){
		count++;
		recursion();
	}
	public static void main(String[] args) {
		try{
			recursion(0, 0, 0);
			//recursion();
		}catch(Throwable e){
			System.out.println("deep of calling = "+count);
			e.printStackTrace();
		}
	}
}

package Thread;

public class Th2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1=new Thread();
		//System.out.println(t1);  //Thread[#20,Thread-0,5,main]
		//System.out.println(Thread.currentThread());  //Thread[#1,main,5,main]
		//System.out.println(Thread.currentThread().getName());
		t1.setName("My 1st Thread");
		System.out.println(t1.getName());
		System.out.println("child status "+(t1.isAlive()));
		System.out.println("Main status "+Thread.currentThread().isAlive());
	}
}

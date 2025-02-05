package Thread;

public class Th3 extends Thread {
	Th3()
	{
		start();
	}
	public void run()
	{
		x();
	}
	synchronized static void x()    //it allows the multiple thread one by one.
	{
		try
		{
			for(int i=1;i<=10;i++)
			{
				System.out.println("\t"+ i);
				Thread.sleep(500);
			}
		}
		catch(InterruptedException e)
		{	
		}
	}

	public static void main(String[] args) {
		new Th3();
		new Th3();
		

	}

}

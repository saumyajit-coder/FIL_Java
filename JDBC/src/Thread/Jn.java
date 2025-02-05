package Thread;

public class Jn extends Thread {
	Jn()
	{
		start();
	}
	public void run()
	{
		System.out.println("Child Thread start");
		try
		{
			for(int i=1;i<=5;i++)
			{
				System.out.println("\t"+ i);
				Thread.sleep(500);
			}
		}
		catch(InterruptedException e)
		{	
		}
		System.out.println("End of the child thread");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main Thread started");
		Jn j1=new Jn();
		try
		{
			j1.join();    //at first the child class executed then the parent class end 
		}
		catch(InterruptedException e)
		{
		}
		System.out.println("End of the Main Thread");

	}

}

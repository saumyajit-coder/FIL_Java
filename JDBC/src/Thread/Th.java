package Thread;

public class Th extends Thread {
	Th()
	{
		start();
	}
	public void run()
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
		new Th();
		try
		{
			for(int i=101;i<=110;i++)
			{
				System.out.println("\t"+ i);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e)
		{
			
		}
		
	}

}

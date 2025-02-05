package Thread;

public class RT {
	public static void main(String ar[])
	{
		try
		{
			Runtime r=Runtime.getRuntime();
			Process p=r.exec("cmd /c start excel");
			Process q=r.exec("MSPaint");                     //start the built_in function
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}

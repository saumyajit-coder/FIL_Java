package Thread;
import java.lang.reflect.*;

public class Ref {

	public static void main(String[] args) {
		try
		{
			Class c=Class.forName("java.awt.Button");
			Constructor cn[]=c.getConstructors();
			//Method cn[] = c.getMethods();
			//Field cn[]=c.getFields();
			for(int i=0;i<cn.length;i++)
			{
				System.out.println(cn[i]);
			}
			System.out.println("\t"+cn.length);
		}
		catch(Exception e)
		{
			System.err.println(e);
		}

	}

}

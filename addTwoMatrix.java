package Day_2;
import java.util.*;
public class addTwoMatrix {

	public static void main(String[] args) {
		int a[][]=new int[5][5];
		Scanner sc =new Scanner(System.in);
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				a[i][j]=sc.nextInt();
			}
		}
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				a[i][j]=i+j;
			}
		}
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				System.out.println(a[i][j]);
			}
		}
		sc.close();
		

	}

}

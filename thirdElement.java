package Day_2;
import java.util.Arrays;
import java.util.Scanner;
public class thirdElement {
		public static void main(String[] args) {
			int []arr=new int[5];
			Scanner sc =new Scanner(System.in);
			for(int i=0;i<5;i++)
			{
				arr[i]=sc.nextInt();
			}
			for(int i=0;i<5;i++)
			{
				System.out.println(arr[i]);
			}
			Arrays.sort(arr);
			for(int i=0;i<5;i++)
			{
				System.out.println(arr[i]);
			}
			System.out.println(arr[2]);

		}

	}

//Selection sort
//insertion sort
//radix sort
//add,difference,multiplication and division of the two matrix
/**problem if the matrix is 1 2 3
  *                        4 5 6
  *                         7 8 9
  *                         then print 1 2 3 6 9 8 7 4 5
  **/
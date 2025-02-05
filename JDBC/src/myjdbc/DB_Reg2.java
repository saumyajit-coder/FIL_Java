package myjdbc;

import java.util.Scanner;

public class DB_Reg2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name: ");
		String nm=sc.nextLine();
		System.out.println("Enter the Password: ");
		String pass=sc.nextLine();
		System.out.println("Enter the Salary: ");
		double sal=sc.nextDouble();
		DbConn db=new DbConn();
		try
		{
			//String qry="insert into table1 values('" +nm +"','"+ pass +"'," + sal + ")";
			//System.out.println(qry);
			//db.stat.executeUpdate(qry);
			String qry="insert into table1 values (?,?,?)";
			db.pstat=db.conn.prepareStatement(qry);
			db.pstat.setString(1,nm);
			db.pstat.setString(2,pass);
			db.pstat.setDouble(3,sal);
			db.pstat.executeUpdate();
			System.out.println("Congratulation!!");
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
	}

}

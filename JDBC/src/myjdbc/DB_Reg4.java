package myjdbc;

import java.util.Scanner;

public class DB_Reg4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name: ");
		String nm=sc.nextLine();
		System.out.println("Enter the Password: ");
		String pass=sc.nextLine();
		System.out.println("Enter the Email: ");
		String eml=sc.nextLine();
		System.out.println("Enter the MobileNo: ");
		String mob=sc.nextLine();
		System.out.println("");
		DbConn db=new DbConn();
		try
		{
			String cq = "SELECT email,mob FROM table2 WHERE email = ? OR mob = ?";
            db.pstat = db.conn.prepareStatement(cq);
            db.pstat.setString(1, eml);
            db.pstat.setString(2, mob);
            db.rs = db.pstat.executeQuery();
            boolean emailExists = false;
            boolean mobileExists = false;
            while (db.rs.next()) {
                String existingEmail = db.rs.getString("email");
                String existingMobile = db.rs.getString("mob");
                if (existingEmail.equals(eml)) 
                	emailExists = true;
                if (existingMobile.equals(mob)) 
                	mobileExists = true;
            }
            if (emailExists && mobileExists) {
                System.out.println("Email and Mobile No exist!");
                return;
            } else if (emailExists) {
                System.out.println("Email already exists!");
                return;
            } else if (mobileExists) {
                System.out.println("Mobile No already exists!");
                return;
            }
			db.rs=db.stat.executeQuery("Select e_id from table2 order by e_id desc");
			String e_id="";
			if(!db.rs.next())
			{
				e_id="E0001";
			}
			else
			{
				e_id=db.rs.getString("e_id");
				e_id=e_id.substring(1);
				int n=Integer.parseInt(e_id);
				n++;
				if(n>=0 && n<10)
				{
					e_id="E000"+n;
				}
				else if(n>=10 && n<100)
				{
					e_id="E00"+n;
				}
				else if(n>=100 && n<1000)
				{
					e_id="E0"+n;
				}
				else if(n>=1000 && n<10000)
				{
					e_id="E"+n;
				}
			}
			String qry="insert into table2 values (?,?,?,?,?)";
			db.pstat=db.conn.prepareStatement(qry);
			db.pstat.setString(1,e_id);
			db.pstat.setString(2,nm);
			db.pstat.setString(3,pass);
			db.pstat.setString(4,eml);
			db.pstat.setString(5,mob);
			db.pstat.executeUpdate();
			System.out.println("Congratulation!!");
		}
		catch(Exception e)
		{
			System.err.println(e);
		}

	}

	}


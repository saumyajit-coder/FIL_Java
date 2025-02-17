package myjdbc;

import java.sql.*;
import java.util.Scanner;

public class DB_Reg5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DbConn db = new DbConn();
        while (true) {
            System.out.println("\n========= USER MANAGEMENT SYSTEM =========");
            System.out.println("1. Register New User");
            System.out.println("2. Update User Details");
            System.out.println("3. Delete User");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    registerUser(sc, db);
                    break;
                case 2:
                    updateUser(sc, db);
                    break;
                case 3:
                    deleteUser(sc, db);
                    break;
                case 4:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    
    public static void registerUser(Scanner sc,DbConn db) {
        try {
            System.out.println("\nEnter the name: ");
            String nm = sc.nextLine();
            
            System.out.println("Enter the Password: ");
            String pass = sc.nextLine();
            
            System.out.println("Enter the Email: ");
            String eml = sc.nextLine();
            
            System.out.println("Enter the Mobile No: ");
            String mob = sc.nextLine();
            String cq = "SELECT email, mob FROM table2 WHERE email = ? OR mob = ?";
            db.pstat = db.conn.prepareStatement(cq);
            db.pstat.setString(1, eml);
            db.pstat.setString(2, mob);
            db.rs = db.pstat.executeQuery();
            
            boolean emailExists = false, mobileExists = false;
            while (db.rs.next()) {
                if (db.rs.getString("email").equals(eml)) 
                	emailExists = true;
                if (db.rs.getString("mob").equals(mob)) 
                	mobileExists = true;
            }

            if (emailExists && mobileExists) {
                System.out.println("Email and Mobile No already exist!");
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
			
            String qr = "INSERT INTO table2 VALUES (?, ?, ?, ?, ?)";
            db.pstat = db.conn.prepareStatement(qr);
            db.pstat.setString(1, e_id);
            db.pstat.setString(2, nm);
            db.pstat.setString(3, pass);
            db.pstat.setString(4, eml);
            db.pstat.setString(5, mob);
            db.pstat.executeUpdate();
            System.out.println("Congratulations!");
        } catch(Exception e)
		{
			System.err.println(e);
		}
    }
    
    public static void updateUser(Scanner sc,DbConn db) {
        try {
            System.out.println("\nEnter the E_ID to update: ");
            String e_id = sc.nextLine();

            //System.out.println("Enter new Name: ");
            //String newName = sc.nextLine();

            System.out.println("Enter new Password: ");
            String newPassword = sc.nextLine();

            System.out.println("Enter new Email: ");
            String newEmail = sc.nextLine();

            System.out.println("Enter new Mobile No: ");
            String newMobile = sc.nextLine();

            String uq = "UPDATE table2 SET password = ?, email = ?, mob = ? WHERE e_id = ?";
            db.pstat = db.conn.prepareStatement(uq);
            db.pstat.setString(1, newPassword);
            db.pstat.setString(2, newEmail);
            db.pstat.setString(3, newMobile);
            db.pstat.setString(4, e_id);

            int rowsUpdate = db.pstat.executeUpdate();
            if (rowsUpdate > 0) {
                System.out.println("User details updated successfully!");
            } else {
                System.out.println("E_ID not found! Update failed.");
            }

        } 
        catch(Exception e)
		{
			System.err.println(e);
		}
    }
    
    public static void deleteUser(Scanner sc, DbConn db) {
        try {
            System.out.println("\nEnter the E_ID to delete: ");
            String e_id = sc.nextLine();
            String dq = "DELETE FROM table2 WHERE e_id = ?";
            db.pstat = db.conn.prepareStatement(dq);
            db.pstat.setString(1, e_id);

            int rowsDeleted = db.pstat.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("User deleted successfully!");
            } else {
                System.out.println("E_ID not found! Deletion failed.");
            }

        } 
        catch(Exception e)
		{
			System.err.println(e);
		}
    }
}


package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Model.Student;

public class Controller
{
	int n,i;
	Student s1[];
	Student s;
	
	public Controller() 
	{
		s=new Student();
	}
	
	public static Connection connectivity() throws ClassNotFoundException, SQLException
	{
		String url="jdbc:mysql://localhost:3306/MvcDatabaseProj";
		String uname="root";
		String password="abc123";
		Class.forName("com.mysql.cj.jdbc.Driver");
	    System.out.println("Driver registered");
	    Connection con=DriverManager.getConnection(url, uname, password);
	    System.out.println("Connected");
        return con;
		
	}
	
	public void insert() throws ClassNotFoundException, SQLException
	{
		  Scanner sc=new Scanner(System.in);
          Connection con=Controller.connectivity();
          PreparedStatement ps=con.prepareStatement("INSERT INTO MvcDatabaseProj.student VALUES(?,?,?)");
          System.out.println("Statement created");
    	  System.out.println("Enter how many number of students you need to enter :");
    	  n=Integer.parseInt(sc.nextLine());
    	  s1=new Student[n];
    	  for(i=0;i<s1.length;i++)
    	  {
    		  s1[i]=new Student();
    	  System.out.println("....Student "+(i+1)+" details....");
    	  System.out.println("Enter roll number :");
    	  int rollno=Integer.parseInt(sc.nextLine());
    	  s1[i].setRollno(rollno);
    	  System.out.println("Enter Firstname :");
    	  String Firstname=sc.nextLine();
    	  s1[i].setFirstname(Firstname);
    	  System.out.println("Enter Lastname :");
    	  String Lastname=sc.nextLine();
    	  ps.setInt(1, rollno);
    	  ps.setString(2, Firstname);
    	  ps.setString(3, Lastname);
    	  int a=ps.executeUpdate();
    	  if(a>0)
    	  {
    		  System.out.println("Done data inserted");
    	  }
    	  else
    	  {
    		  System.out.println("Sorry data not inserted");
    	  }
    	  }
    	  con.close();
    	  System.out.println("Close connection");
		
	}
	
	public void show() throws ClassNotFoundException, SQLException
	{
		Connection con=Controller.connectivity();
	    PreparedStatement ps=con.prepareStatement("SELECT * from MvcDatabaseProj.student");
	    System.out.println("Statement created");
	    ResultSet rs=ps.executeQuery();
		System.out.println("***********************SHOW**********************");
		System.out.println("Roll number\tFirstname\tLastname");
		 while(rs.next())
		  {	 
			  System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3));
		  }
		  System.out.println("-------------------------------------------------------------------------------------------------");
		  con.close();
		  System.out.println("Close connection");
		
	}
	
	public void update() throws ClassNotFoundException, SQLException
	{
		 int i;
		   Scanner sc=new Scanner(System.in);
		   System.out.println("Enter number who's record is to be updated :");
		   int updatestudroll=Integer.parseInt(sc.nextLine());
		   System.out.println("***********************UPDATE***************************");
		   System.out.println("OK....What do you want to update :");
		   System.out.println("1.Firstname");
		   System.out.println("2.Lastname");
		   System.out.println("Enter you choice :");
		   int c=Integer.parseInt(sc.nextLine());
		   Connection con=Controller.connectivity();
		   PreparedStatement ps;
		   switch(c)
		   {
		   case 1:
			   ps=con.prepareStatement("select Firstname from MvcDatabaseProj.student where rollno=?");
			   ps.setInt(1, updatestudroll);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				  System.out.println("previous student firstname is "+ rs.getString("Firstname"));
			   }
			   System.out.println("Enter new student updated name ");
			   String updatefirstname=sc.nextLine();
			   ps=con.prepareStatement("UPDATE MvcDatabaseProj.student SET FirstName=? Where rollno=?");
			   ps.setString(1, updatefirstname);
			   ps.setInt(2, updatestudroll);
			   int a=ps.executeUpdate();
				  if(a>0)
				  {
					  System.out.println("Student Firstname is successfully updated");
				  }
				  else
				  {
					  System.out.println("not updated");
				  }
				  con.close();
				  System.out.println("Close connection");
				  break;
				  
		   case 2:
			   ps=con.prepareStatement("select Lastname from MvcDatabaseProj.student where rollno=?");
			   ps.setInt(1, updatestudroll);
			   ResultSet r=ps.executeQuery();
			   while(r.next())
			   {
				   System.out.println("previous student Lastname is "+ r.getString("Lastname"));
			   }
			   System.out.println("Enter new student updated name ");
			   String updateLastname=sc.nextLine();
			   ps=con.prepareStatement("UPDATE MvcDatabaseProj.student SET LastName=? Where rollno=?");
			   ps.setString(1, updateLastname);
			   ps.setInt(2, updatestudroll);
			   int b=ps.executeUpdate();
				  if(b>0)
				  {
					  System.out.println("Student Lastname is successfully updated");
				  }
				  else
				  {
					  System.out.println("Lastname not updated");
				  }
				  con.close();
				  System.out.println("Close connection");
				  break;
				  
		   case 0:
			   c=0;
			   break;
		   }
	}
	
	public void delete() throws ClassNotFoundException, SQLException
	{
		 Scanner sc=new Scanner(System.in);
		   System.out.println("Enter who's record you want to delete ?");
		   int delstudroll=Integer.parseInt(sc.nextLine());
		   Connection con=Controller.connectivity();
		   System.out.println("***********************DELETE***************************");
		   PreparedStatement ps=con.prepareStatement("DELETE FROM MvcDatabaseProj.student WHERE rollno=?");
		   System.out.println("Statement created");
			  ps.setInt(1, delstudroll); 
			  
			  int rowsAffected = ps.executeUpdate();

			    if (rowsAffected > 0) {
			        System.out.println("Record deleted successfully");
			    } else {
			        System.out.println("No records found for deletion");
			    }

			    con.close();
			    System.out.println("Close connection");
//			  int a=ps.executeUpdate();
//				
//				if(a>0)
//				{
//					System.out.println("query executed");
//				}
//				else
//				{
//					System.out.println("query not executed");
//				}
//				System.out.println("Successfully record deleted");
//				con.close();
//				System.out.println("close connection");
		
	}
	
	public void search() throws ClassNotFoundException, SQLException
	{
		 Scanner sc=new Scanner(System.in);
		   System.out.println("Enter who's record you want to search ?");
		   int searchstudroll=Integer.parseInt(sc.nextLine());
		   Connection con=Controller.connectivity();
		   PreparedStatement ps;
		   System.out.println("***********************SEARCH***************************");
		   ps=con.prepareStatement("select * from MvcDatabaseProj.student where rollno=?");
		   ps.setInt(1, searchstudroll);
		   ResultSet rs=ps.executeQuery();
		   System.out.println("Query executed");
		   
		   boolean found = false;

		   while (rs.next()) {
		       found = true;
		       System.out.println("Roll number: " + rs.getInt(1) + " Firstname: " + rs.getString(2) + " Lastname: " + rs.getString(3));
		   }

		   if (!found) {
		       System.out.println("No data found for the provided roll number.");
		   }

		   con.close();
		   		   System.out.println("Close connection");
		   		
//		   while(rs.next())
//		   {
//			   System.out.println("Roll number :"+rs.getInt(1)+" Firstname :"+rs.getString(2)+" Lastname :"+rs.getString(3));
//		   }
//		   System.out.println("Entry not found");
//		   con.close();
//		   System.out.println("Close connection");
		
	}
	
}

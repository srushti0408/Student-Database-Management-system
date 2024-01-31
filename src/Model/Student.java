package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Student 
{
	int rollno;
    String Firstname,Lastname;
	public int getRollno() 
	{
		return rollno;
	}
	public void setRollno(int rollno) 
	{
		this.rollno = rollno;
	}
	public String getFirstname() 
	{
		return Firstname;
	}
	public void setFirstname(String firstname) 
	{
		Firstname = firstname;
	}
	public String getLastname()
	{
		return Lastname;
	}
	public void setLastname(String lastname) 
	{
		Lastname = lastname;
	}   
	
}

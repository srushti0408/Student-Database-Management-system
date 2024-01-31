package View;

import java.sql.SQLException;
import java.util.Scanner;

import Controller.Controller;

public class View 
{
	 int ch;
	 Controller c;
	 
	 public View() throws ClassNotFoundException, SQLException 
	 {
       c=new Controller();
       this.itemList();
	 }
	 
	 void itemList() throws ClassNotFoundException, SQLException
	 {
		 Scanner sc=new Scanner(System.in);
		 
		 do
		 {
			 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			 System.out.println("||            LIST OF STUDENT RECORD           ||");
		     System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			 System.out.println("||   1. Add student details                    ||");
			 System.out.println("||   2. Show student details                   ||");
			 System.out.println("||   3. Update student details                 ||");
			 System.out.println("||   4. Search student details                 ||");
			 System.out.println("||   5. Delete student details                 ||");
			 System.out.println("||   0. Exit                                   ||");
			 System.out.println("=================================================");
			 System.out.println("Enter choice :");
			 ch=Integer.parseInt(sc.nextLine()); 
			 
			 switch(ch)
			{
				case 1:
					c.insert();
					break;
					
				case 2:
					c.show();
					break;
					
				case 3:
					c.update();
					break;
					
				case 4:
					c.search();
					break;
					
				case 5:
					c.delete();
					break;
					
				case 0:
					ch=0;
					break;
					
				default:
					System.out.println("Sorry... Wrong choice ");
			}
		 }while(ch!=0);
	 }
}

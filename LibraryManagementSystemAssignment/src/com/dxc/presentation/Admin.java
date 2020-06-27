package com.dxc.presentation;

import java.util.List;
import java.util.Scanner;

import com.dxc.pojos.Books;
import com.dxc.pojos.User;
import com.dxc.services.AdminServiceImpl;
import com.dxc.services.IAdminService;

public class Admin 
{
	public void adminOperation()
	{
		int choice;
		Scanner sc=new Scanner(System.in);
		IAdminService ias=new AdminServiceImpl();
		while(true) 
		{
			System.out.println("Enter your choice...");
			System.out.println("1.Add book to library");
			System.out.println("2.Add user to library system");
			System.out.println("3.Get list of books issued by particular user");
			System.out.println("4.Get balance amount of particular user");
			System.out.println("5.Delete user from library system");
			System.out.println("6.Get list of books present in the library");
			System.out.println("7.Get list of users present in the library system");
			System.out.println("8.Exit");
			
			choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter book id,book name,author name & quantity");
				ias.addBook(sc.nextInt(), sc.next(), sc.next(), sc.nextInt());
				break;
			case 2:
				System.out.println("Enter user id,user name,password");
				double balance=1000;
				ias.addUser(sc.nextInt(), sc.next(), sc.next(), balance);
				break;
			case 3:
				System.out.println("Enter user id");
				List<Books> ls=ias.getUserBookList(sc.nextInt());
				System.out.println();
				for(Books bp:ls)
				{
					bp.display();
				}
				System.out.println();
				break;
			case 4:
				System.out.println("Enter user id");
				double bal=ias.getUserBalance(sc.nextInt());
				System.out.println("balance="+bal);
				break;
			case 5:
				System.out.println("Enter user id");
				ias.deleteUser(sc.nextInt());
				break;
			case 6:
				List<Books> ls2=ias.getTotalBookList();
				System.out.println();
				for(Books bp:ls2)
				{
					bp.display();
				}
				System.out.println();
				break;
			case 7:
			    List<User> users=ias.getUserList();
			    System.out.println();
			    for(User us:users)
			   {
				    us.show();
			   }
			System.out.println();
			break;
			case 8:
				ias.closeConnection();
				System.exit(0);
				break;
			default:
				System.out.println("Please enter your choice again..");
				break;
			}
		}
	}
}

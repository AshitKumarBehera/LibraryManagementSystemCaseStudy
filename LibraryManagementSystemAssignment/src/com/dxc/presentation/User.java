package com.dxc.presentation;

import java.util.List;
import java.util.Scanner;

import com.dxc.pojos.Books;
import com.dxc.services.UserServiceImpl;
import com.dxc.services.IUserService;

public class User 
{	
	public void userOperation(String name)
	{
		String userName=name;
		Scanner sc=new Scanner(System.in);
		Library lb=new Library();
		IUserService ius=new UserServiceImpl();
		int uId=ius.getUserId(userName);
		int choice;
		while(true)
		{
			System.out.println("Enter your choice...");
			System.out.println("1.Issue books from library");
			System.out.println("2.Get list of books by particular author");
			System.out.println("3.Check available balance in library account");
			System.out.println("4.Return book");
			System.out.println("5.Issued books");
			System.out.println("6.Exit");
		
			choice=sc.nextInt();
			
			switch (choice)
			{
			case 1:	
				System.out.println("Enter book id");
				int bookId=sc.nextInt();
				System.out.println("Enter no of day you want the book");
				int day=sc.nextInt();
				if(day<=15)
				{
					double balance=day*5;
					ius.issueBook(uId,bookId,day,balance);
				}
				else
				{
					System.out.println("You can issue a book for 15 days maximum");
				}
				break;
			case 2:
				System.out.println("Enter name of author ");
				List<Books> list1=ius.getBookListOfParticularAuthor(sc.next());
				System.out.println();
				for(Books b:list1)
				{
					b.display();
				}
				System.out.println();
				break;
				
			case 3:
				double balance=ius.getBalance(uId);
				System.out.println(+balance);
				break;
			case 4:
				System.out.println("Enter book id");
				ius.returnBook(uId,sc.nextInt());
				break;
			case 5:
				List<Books> list2=ius.getIssuedBook(uId);
				for(Books b:list2)
				{
					b.displayBook();
				}
				break;
			case 6:
				ius.closeConnection();
				System.exit(0);
				break;
				
			default:
				System.out.println("Please enter your choice again");
				break;
			}
		}
	}
}

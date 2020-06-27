package com.dxc.presentation;

import java.util.Scanner;

import com.dxc.services.AdminServiceImpl;
import com.dxc.services.UserServiceImpl;
import com.dxc.services.IAdminService;
import com.dxc.services.IUserService;

public class Library 
{	
	public static void main(String[] args) {
		
		IAdminService ias=new AdminServiceImpl();
		IUserService ius=new UserServiceImpl();
		User user=new User();
		Admin admin=new Admin();
		
		int choice;
		while(true) 
		{	
			Scanner sc=new Scanner(System.in);
			System.out.println("1.Admin");
			System.out.println("2.User");
			System.out.println("Please enter your choice...");
			choice=sc.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter your name & password");
				String name1=sc.next();
				String password1=sc.next();
				boolean b1=ias.passwordCheck(name1, password1);
				if(b1==true)
				{
					System.out.println(" "+name1+" Logged in successfully!!!");
					admin.adminOperation();
				}
				else
					System.out.println("Login failure!!!");
				break;
				
				
			case 2:
				System.out.println("Enter your name & password");
				String name2=sc.next();
				String password2=sc.next();
				boolean b2=ius.PasswordCheck(name2, password2);
				if(b2==true)
				{
					System.out.println("Logged in successfully!!!");
					user.userOperation(name2);
				}
				else
					System.out.println("Login failure!!!");
				break;
				
				
			default:
				System.out.println("Please enter your choice again...");
			}
		}
	}

}

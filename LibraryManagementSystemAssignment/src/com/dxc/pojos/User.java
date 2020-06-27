package com.dxc.pojos;

public class User 
{
	private int userId;
	private String userName;
	private String userPassword;
	private double balance;
	private int noOfDaysTaken;
	private int noOfBooksTaken;
	
	public User() 
	{
		
	}
	public User(int userId, String userName) 
	{
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.balance = balance;
		this.noOfDaysTaken = noOfDaysTaken;
		this.noOfBooksTaken = noOfBooksTaken;
	}
	public int getUserId() 
	{
		return userId;
	}
	public void setUserId(int userId) 
	{
		this.userId = userId;
	}
	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	public String getUserPassword() 
	{
		return userPassword;
	}
	public void setUserPassword(String userPassword) 
	{
		this.userPassword = userPassword;
	}
	public double getBalance() 
	{
		return balance;
	}
	public void setBalance(double balance) 
	{
		this.balance = balance;
	}
	public int getNoOfDaysTaken() 
	{
		return noOfDaysTaken;
	}
	public void setNoOfDaysTaken(int noOfDaysTaken) 
	{
		this.noOfDaysTaken = noOfDaysTaken;
	}
	public int getNoOfBooksTaken() {
		return noOfBooksTaken;
	}
	public void setNoOfBooksTaken(int noOfBooksTaken) 
	{
		this.noOfBooksTaken = noOfBooksTaken;
	}
	public void display()
	{
		System.out.println(userId+"--->"+userName+"--->"+balance);
	}
	public void show() 
	{
	    System.out.println(userId+"--->"+userName);
	}
	
	
}

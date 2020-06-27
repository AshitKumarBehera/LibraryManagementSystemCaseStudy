package com.dxc.pojos;

public class BooksIssued {

	private int userId;
	private int bookId;
	private int noOfDaysTaken;
	private int noOfBooksTaken;
	
	public BooksIssued() 
	{
		
	}

	public BooksIssued(int userId, int bookId, int noOfDaysTaken, int noOfBooksTaken) {
		super();
		this.userId = userId;
		this.bookId = bookId;
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

	public int getBookId() 
	{
		return bookId;
	}

	public void setBookId(int bookId) 
	{
		this.bookId = bookId;
	}

	public int getNoOfDaysTaken() 
	{
		return noOfDaysTaken;
	}

	public void setNoOfDaysTaken(int noOfDaysTaken) 
	{
		this.noOfDaysTaken = noOfDaysTaken;
	}

	public int getNoOfBooksTaken() 
	{
		return noOfBooksTaken;
	}

	public void setNoOfBooksTaken(int noOfBooksTaken) 
	{
		this.noOfBooksTaken = noOfBooksTaken;
	}	
}

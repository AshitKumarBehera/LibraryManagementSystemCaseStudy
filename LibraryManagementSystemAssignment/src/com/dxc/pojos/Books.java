package com.dxc.pojos;

public class Books 
{
	private int bookid;
	private String bookName;
	private String authorName;
	private int quantity;
	
	public Books() 
	{
		
	}
	public Books(int bookid, String bookName, String authorName, int quantity) 
	{
		this.bookid = bookid;
		this.bookName = bookName;
		this.authorName = authorName;
		this.quantity = quantity;
	}

	public int getId() 
	{
		return bookid;
	}

	public void setId(int id) 
	{
		this.bookid = id;
	}

	public String getBookName() 
	{
		return bookName;
	}

	public void setBookName(String bookName) 
	{
		this.bookName = bookName;
	}

	public String getAuthorName() 
	{
		return authorName;
	}

	public void setAuthorName(String authorName) 
	{
		this.authorName = authorName;
	}

	public int getQuantity() 
	{
		return quantity;
	}

	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	
	public void display()
	{
		System.out.println(bookid+"--->"+bookName+"--->"+ authorName);
	}
	public void displayBook() 
	{
		System.out.println("\n"+bookid+"--->"+bookName+"--->("+authorName+")\n");
	}
	
}

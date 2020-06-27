package com.dxc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dxc.dao.IAdminDao;
import com.dxc.pojos.Books;
import com.dxc.pojos.User;

public class AdminDaoImpl implements IAdminDao
{
	private static Connection conn;	
	static
	{
		try
			{
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ashit", "root", "1742");
			}
		catch(Exception e)
			{
				e.printStackTrace();
			}
	}
	
	
	@Override
	public boolean passwordCheck(String name,String password) 
	{
		boolean b=false;
		try 
		{
			PreparedStatement pstmt=conn.prepareStatement("select * from admin");
			ResultSet rset=pstmt.executeQuery();
			while(rset.next())
			{
				if(name.equals(rset.getString(2)) && password.equals(rset.getString(3)))
					b=true;
			}
			pstmt.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return b;
	}
	
	public void closeConn()
	{
		if(conn!=null)
		{
			try 
			{
				conn.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public void addBook(int bookid, String bookName, String author, int quan) 
	{
		try 
		{
			PreparedStatement pstmt=conn.prepareStatement("insert into books values(?,?,?,?)");
			pstmt.setInt(1, bookid);
			pstmt.setString(2, bookName);
			pstmt.setString(3, author);
			pstmt.setInt(4, quan);
			pstmt.execute();
			System.out.println("One book added successfully!!!");
			pstmt.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void addUser(int id, String name, String password, double balance) {
		try {
			PreparedStatement pstmt=conn.prepareStatement("insert into user values(?,?,?,?)");
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, password);
			pstmt.setDouble(4, balance);
			pstmt.execute();
			System.out.println("One user added successfully");
			pstmt.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	

	@Override
	public List<Books> getUserBookList(int userid) 
	{
		int bookId=0;
		List<Books> bo=new ArrayList<Books>();
			try 
			{
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery("select * from issuedbooks");
				while(rs.next())
				{
					if(userid==rs.getInt(1))
					{
						bookId=rs.getInt(2);
					}
				}
				stmt.close();
				Statement stmt2=conn.createStatement();
				ResultSet rs1=stmt2.executeQuery("select * from books");
				while(rs1.next())
				{
					if(bookId==rs1.getInt(1))
					{
						Books books=new Books(rs1.getInt(1),rs1.getString(2),rs1.getString(3),rs1.getInt(4));
						bo.add(books);
					}
				}
				stmt2.close();
		} 
			catch (Exception e) 
			{
			e.printStackTrace();
		}	
		return bo;
	}
	

	
	
	
	@Override
	public double getUserBalance(int id) 
	{
		double balance=0;
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from user");
			while(rs.next())
			{
				if(id==rs.getInt(1))
				{
					balance=rs.getDouble(4);
				}
			}
			stmt.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return balance;
	}
	
	
	
	@Override
	public List<Books> getTotalBookList() 
	{	
		List<Books> ls=new ArrayList<Books>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from books");
			while(rs.next())
			{
				Books books=new Books(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(1));
				ls.add(books);
			}
			stmt.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return ls;
	}

	
	
	
	@Override
	public void deleteUser(int id) 
	{
		PreparedStatement pstmt;
		try 
		{
			pstmt = conn.prepareStatement("delete from user where userid=?");
			pstmt.setInt(1, id);
			pstmt.execute();
			pstmt.close();
			System.out.println("user account deleted from database successfully");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getUserList() 
	{
		List<User> lu=new ArrayList<User>();
		try {
			
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from user");
			while(rs.next())
			{
				User user=new User(rs.getInt(1),rs.getString(2));
				lu.add(user);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return lu;
	}
	
	
	@Override
	public void closeConnection() 
	{
		if(conn!=null)
		{
			try {
				conn.close();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}


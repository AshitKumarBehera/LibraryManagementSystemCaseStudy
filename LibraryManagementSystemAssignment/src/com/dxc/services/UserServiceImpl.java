package com.dxc.services;

import java.util.List;
import com.dxc.dao.UserDaoImpl;
import com.dxc.dao.IUserDao;
import com.dxc.pojos.Books;
import com.dxc.services.IUserService;

public class UserServiceImpl implements IUserService 
{

	IUserDao dao=new UserDaoImpl();
	@Override
	public boolean PasswordCheck(String name, String password) 
	{
		return dao.passwordCheck(name,password);
	}
	
	@Override
	public List<Books> getBookListOfParticularAuthor(String authorName) 
	{
		return dao.getBookListOfParticularAuthor(authorName);
	}
	@Override
	public void issueBook(int uId, int bookId, int day,double balance) 
	{

		dao.issueBook(uId,bookId,day, balance);
	}
	@Override
	public double getBalance(int userId) 
	{
		return dao.getBalance(userId);
	}
	@Override
	public void closeConnection() 
	{
		dao.closeConnection();
	}
	@Override
	public int getUserId(String name) 
	{
		return dao.getUserId(name);
	}
	@Override
	public void returnBook(int uId, int bId) 
	{
		dao.returnBook(uId,bId);
	}
	@Override
	public List<Books> getIssuedBook(int uId) 
	{
		return dao.getIssuedBook(uId);
	}


	
}

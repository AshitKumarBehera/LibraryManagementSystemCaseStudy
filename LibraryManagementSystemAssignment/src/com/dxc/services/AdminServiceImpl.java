package com.dxc.services;

import java.util.List;

import com.dxc.dao.*;
import com.dxc.dao.IAdminDao;
import com.dxc.pojos.Books;
import com.dxc.pojos.User;
import com.dxc.services.*;

public class AdminServiceImpl implements IAdminService 
{	
	IAdminDao admindao=new AdminDaoImpl();
	
	@Override
	public boolean passwordCheck(String name,String password) 
	{
		return admindao.passwordCheck(name,password);
	}

	@Override
	public void addBook(int bookid, String bookName, String author, int quan) 
	{
		admindao.addBook(bookid,bookName,author,quan);
	}
	
	
	@Override
	public void addUser(int id, String name, String password, double balance) {
		admindao.addUser(id,name,password,balance);
	}

	@Override
	public List<Books> getUserBookList(int id) 
	{
	
		return admindao.getUserBookList(id);
	}

	@Override
	public double getUserBalance(int id) 
	{
		return admindao.getUserBalance(id);
	}



	@Override
	public void deleteUser(int id) 
	{
		admindao.deleteUser(id);
	}
	
	
	@Override
	public List<User> getUserList() 
	{
		return admindao.getUserList();
	}
	
	
	@Override
	public void closeConnection() 
	{
		admindao.closeConnection();
	}

	@Override
	public List<Books> getTotalBookList() 
	{
		return admindao.getTotalBookList();
	}
	

}

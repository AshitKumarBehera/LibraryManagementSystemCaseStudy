package com.dxc.dao;

import java.util.List;

import com.dxc.pojos.Books;
import com.dxc.pojos.User;

public interface IAdminDao 
{	
	public boolean passwordCheck(String name,String password);

	public List<Books> getUserBookList(int id);

	public void closeConnection();

	public double getUserBalance(int id);

	public void deleteUser(int id);

	public List<Books> getTotalBookList();

	public List<User> getUserList();

	public void addUser(int id, String name, String password, double balance);

	public void addBook(int bookid, String bookName, String author, int quan);

}

package com.dxc.services;

import java.util.List;

import com.dxc.pojos.Books;
import com.dxc.pojos.User;

public interface IAdminService {
	public boolean passwordCheck(String name,String password);


	public void addBook(int bookid,String bookName,String author,int quan);

	public List<Books> getUserBookList(int id);

	public double getUserBalance(int id);
	
	public List<User> getUserList();
	
	public List<Books> getTotalBookList();
	
	public void deleteUser(int id);

	public void closeConnection();
    
	public void addUser(int id, String name, String password, double balance);
	
}

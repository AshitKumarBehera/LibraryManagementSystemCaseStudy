package com.dxc.dao;

import java.util.List;
import com.dxc.pojos.Books;

public interface IUserDao 
{

	boolean passwordCheck(String name, String password);
	public void closeConnection();
	List<Books> getBookListOfParticularAuthor(String author);
	double getBalance(int userId);
	int getUserId(String name);
    void returnBook(int uId, int bId);
	List<Books> getIssuedBook(int uId);
	void issueBook(int uId, int bookId, int day, double balance);

}

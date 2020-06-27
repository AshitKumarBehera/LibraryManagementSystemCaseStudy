package com.dxc.services;

import java.util.List;
import com.dxc.pojos.Books;

public interface IUserService {

	boolean PasswordCheck(String name, String password);

	public void issueBook(int uId, int bookId, int day,double balance);

	public double getBalance(int userId);

	public void closeConnection();

	public int getUserId(String name);

	void returnBook(int uId, int bId);

	List<Books> getIssuedBook(int uId);

	public List<Books> getBookListOfParticularAuthor(String authorName);
	

}

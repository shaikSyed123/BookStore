package com.tsarit.BookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsarit.BookStore.model.MyBookList;
import com.tsarit.BookStore.repository.MyBookRepository;

@Service
public class MyBookService {
 
	@Autowired
	private MyBookRepository mybook;
	
	public void saveMyBook(MyBookList book) {
		mybook.save(book);
	}
	
	
	public List<MyBookList> getAllMyBooks(){
		return mybook.findAll();
	}
	
	public void deleteById(int id) {
		mybook.deleteById(id);
	}
}

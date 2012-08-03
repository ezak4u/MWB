package com.rest.ezak;

import java.util.HashMap;
import java.util.Map;


public enum BookDAO {
	instance;
	
	private Map<String, Book> contentProvider = new HashMap<String, Book>();
	
	private BookDAO() {
		
		Book book = new Book();
		book.setBookName("Java5");
		contentProvider.put("1", book);
		book = new Book();
		book.setBookName("HTML5");
		contentProvider.put("2", book);
		
	}
	public Map<String, Book> getModel(){
		return contentProvider;
	}
}

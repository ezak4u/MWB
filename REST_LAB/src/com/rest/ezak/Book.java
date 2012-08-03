package com.rest.ezak;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
private String bookName;

public String getBookName() {
	return bookName;
}

public void setBookName(String bookName) {
	this.bookName = bookName;
}
}

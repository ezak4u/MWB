package com.rest.ezak;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;





@Path("/course")
public class BookService {
	
		// Return the list of book to the user in the browser
		@GET
		@Produces(MediaType.TEXT_XML)
		public List<Book> getBooksBrowser() {
			List<Book> books = new ArrayList<Book>();
			books.addAll(BookDAO.instance.getModel().values());
			return books; 
		}
		
		// Return the list of book for applications
		@GET
		@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
		public List<Book> getBooks() {
			List<Book> books = new ArrayList<Book>();
			books.addAll(BookDAO.instance.getModel().values());
			return books;
		}
		
		@GET
		@Path("count")
		@Produces(MediaType.TEXT_PLAIN)
		public String getCount() {
			int count = BookDAO.instance.getModel().size();
			return String.valueOf(count);
		}
		
		//Application integration 		
		@GET
		@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
		@Path("/show/{id}")
		public Book getBook(@PathParam("id") String name) {
			Book book = BookDAO.instance.getModel().get(name);
			if(book==null)
				throw new RuntimeException("Get: Book with " + name +  " not found");
			return book;
		}
		
		// For the browser
		@GET
		@Produces(MediaType.TEXT_XML)
		@Path("/show/{id}")
		public Book getBookHTML(@PathParam("id") String name) {
			Book book = BookDAO.instance.getModel().get(name);
			if(book==null)
				throw new RuntimeException("Get: Book with " + name +  " not found");
			return book;
		}
		
		@DELETE
		@Path("/delete/{book_id}")
		@Produces(MediaType.TEXT_XML)
		public String deleteBook(@PathParam("book_id") String book_id) {
			Book book = BookDAO.instance.getModel().remove(book_id);
			if(book==null)
				throw new RuntimeException("Delete: Book with " + book_id +  " not found");
			return "Delete: Book Id "+book_id+" done";
		}
		
		@PUT
		@Path("/add/{bookName}")
		@Produces(MediaType.TEXT_XML)
		public String addBook(@PathParam("bookName") String bookName) {			
			Book bookAdd =new Book();
			bookAdd.setBookName(bookName);
			int count = BookDAO.instance.getModel().size();
			Book book = BookDAO.instance.getModel().put(String.valueOf(count+1), bookAdd);
			if(book==null)
				throw new RuntimeException("Delete: Book with " + bookName +  " not found");
			return "Add: Book Id "+bookName+" done";
		}


}

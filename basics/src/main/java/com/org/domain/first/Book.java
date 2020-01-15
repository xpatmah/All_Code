package com.org.domain.first;

public class Book implements Comparable<Book>{

	private String authname;
	
	private String title;
	
	private Integer noOfPages;
	
	public Book() {
	}

	public Book(String authname, String title, Integer noOfPages) {
		super();
		this.authname = authname;
		this.title = title;
		this.noOfPages = noOfPages;
	}

	public String getAuthname() {
		return authname;
	}

	public void setAuthname(String authname) {
		this.authname = authname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(Integer noOfPages) {
		this.noOfPages = noOfPages;
	}

	
	
	@Override
	public String toString() {
		return "Book [authname=" + authname + ", title=" + title + ", noOfPages=" + noOfPages + "]";
	}

	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return this.authname.compareTo(o.getAuthname());
	}
	
	
	
}

package domain;

import java.util.Observable;
import java.util.Observer;

public class Book extends Observable implements Comparable<Book>{
	
	private String title, author, publisher;
	private Shelf shelf;
	
	public Book(String name) {
		this.title = name;
	}

	public String getName() {
		return title;
	}

	public void setName(String name) {
		this.title = name;
		System.out.println("this: "  + title + " " + name);
		setChanged();
		notifyObservers();
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String autor) {
		this.author = autor;
		setChanged();
		notifyObservers();
	}
	
	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
		setChanged();
		notifyObservers();
	}
	
	public Shelf getShelf() {
		return shelf;
	}
	
	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
		setChanged();
		notifyObservers();
	}
	
	@Override
	public String toString() {
		return title + ", " + author + ", " + publisher;
	}
	
	

	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return (o.getName()).compareTo(this.getName());
	}}

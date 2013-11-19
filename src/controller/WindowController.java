package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;

import view.AddLoanWindow;
import view.DetailBookWindow;
import view.DetailLoanWindow;
import view.ListenerJFrame;
import view.StartWindow;
import domain.Book;
import domain.Customer;
import domain.Library;
import domain.Loan;

public class WindowController {
	
	Library library;
	Map<Book, ListenerJFrame> openBooks = new TreeMap<>();
	Map<Loan, ListenerJFrame> openLoans = new TreeMap<>();
	Map<Customer, JFrame> openCustomers = new TreeMap<>();
	
	
	public WindowController (Library lib) {
		this.library = lib;
		openMainWindow();
	}
	
	public void openMainWindow() {
		new StartWindow(library, this);
	}
	
	public void openDetailBookWindow(Book book){	
		if (openBooks.containsKey(book)){
			ListenerJFrame frame = openBooks.get(book);
			frame.setVisible(true);
			
		}else{	
			DetailBookWindow detailFrame = new DetailBookWindow(library);
		    detailFrame.setBook(book);
		    openBooks.put(book, detailFrame);
		}    
	}
	
	public void openAddBookWindow(){
		DetailBookWindow detailFrame = new DetailBookWindow(library);
	    detailFrame.setBook(null);	
	}

	public void openDetailLoanWindow(Loan loan){
		if(loan != null) {
			DetailLoanWindow detailFrame = new DetailLoanWindow(loan, library);
			detailFrame.setVisible(true);
		} else {
			System.out.println("Ausleihe nicht gefunden");
		}
	}
	
	public void openAddLoanWindow() {
		AddLoanWindow newWindow = new AddLoanWindow(library, this);
		newWindow.setVisible(true);
	}
	
	
	
	
	

}

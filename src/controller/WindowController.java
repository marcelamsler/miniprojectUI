package controller;

import domain.Book;
import domain.Customer;
import domain.Library;
import domain.Loan;
import view.AddLoanWindow;
import view.DetailBookWindow;
import view.DetailLoanWindow;
import view.StartWindow;

import javax.swing.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class WindowController {
        
	Library library;
	Map<Book, JFrame> openBooks = new TreeMap<>();
	Map<Loan, JFrame> openLoans = new TreeMap<>();
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
			JFrame frame = openBooks.get(book);
			frame.toFront();
			frame.setVisible(true);
		} else{        
			DetailBookWindow detailFrame = new DetailBookWindow(library, this);
			detailFrame.setBook(book);
			openBooks.put(book, detailFrame);
		}
	}
    
	public void openAddBookWindow(){
		DetailBookWindow detailFrame = new DetailBookWindow(library, this);
		detailFrame.setBook(null);        
	}

	public void openDetailLoanWindow(Loan loan){
		if (openLoans.containsKey(loan)){
			JFrame frame = openLoans.get(loan);
			frame.toFront();
			frame.setVisible(true);
		} else {
			DetailLoanWindow detailFrame = new DetailLoanWindow(loan, library, this);
			detailFrame.setVisible(true);
			openLoans.put(loan, detailFrame);
		}        
	}

	public void openCustomerWindow (Customer customer) {
		if (openCustomers.containsKey(customer)) {
			JFrame frame = openCustomers.get(customer);
			frame.setVisible(true);
		} else {
			AddLoanWindow newWindow = new AddLoanWindow(library, this);
			newWindow.setVisible(true);
			newWindow.setCustomer(customer);
			openCustomers.put(customer, newWindow);
		}
	}
    
	public void remove(JFrame o){
		
		Iterator<Entry<Loan, JFrame>> itLoan = openLoans.entrySet().iterator();
		while(itLoan.hasNext()) {
		    if (itLoan.next().getValue().equals(o)){
		    	itLoan.remove();
		    }
		}
		
		Iterator<Entry<Book, JFrame>> itBook = openBooks.entrySet().iterator();
		while(itBook.hasNext()) {
		    if (itBook.next().getValue().equals(o)){
		    	itBook.remove();
		    }
		}
		
		Iterator<Entry<Customer, JFrame>> itCustomer = openCustomers.entrySet().iterator();
		while(itCustomer.hasNext()) {
		    if (itCustomer.next().getValue().equals(o)){
		        itCustomer.remove();
		    }
		}
	     
	}

	public void openAddLoanWindow() {
        AddLoanWindow newWindow = new AddLoanWindow(library, this);
        newWindow.setVisible(true);
	}
}

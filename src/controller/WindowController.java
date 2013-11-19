package controller;

import view.AddLoanWindow;
import view.DetailBookWindow;
import view.DetailLoanWindow;
import view.StartWindow;
import domain.Book;
import domain.Library;
import domain.Loan;

public class WindowController {
	
	Library library;
	
	
	
	public WindowController (Library lib) {
		this.library = lib;
		openMainWindow();
	}
	
	public void openMainWindow() {
		StartWindow window = new StartWindow(library, this);
	}
	
	public void openDetailBookWindow(Book book){		
		DetailBookWindow detailFrame = new DetailBookWindow(library);
	    detailFrame.setBook(book);			        	 
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

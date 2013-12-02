package test;

import domain.*;
import junit.framework.TestCase;

import java.util.GregorianCalendar;

public class LoanTest extends TestCase {

    public void testLoanCreation() {
        Loan l = createSampleLoan();
        assertTrue(new GregorianCalendar().equals(l.getPickupDate()));
        assertEquals("Keller", l.getCustomer().getName());
        assertEquals("Design Pattern", l.getCopy().getBook().getName());
    }

    private Loan createSampleLoan() {
        Customer customer = new Customer("Keller", "Peter");
        Book title = new Book("Design Pattern");
        Copy copy = new Copy(title);
        Loan loan = new Loan(customer, copy);
        return loan;
    }

    public void testReturn() {
        Loan l = createSampleLoan();
        assertTrue(l.isLent());
        l.returnCopy();
        assertFalse(l.isLent());
    }


    public void testDateConsistency() throws IllegalLoanOperationException {
        Loan l = createSampleLoan();
        l.setPickupDate(new GregorianCalendar(2009, 01, 01));
        assertTrue(l.isLent());
        try {
            l.returnCopy(new GregorianCalendar(2008, 12, 31));
            fail("Book cannot retuned before the pickup date");
        } catch (IllegalLoanOperationException e) {

        }
        assertTrue(l.isLent());
        l.returnCopy(new GregorianCalendar(2009, 12, 31));
        assertFalse(l.isLent());
        try {
            l.setPickupDate(new GregorianCalendar(2008, 10, 31));
            fail("pickup date cannot be set after the book was returned");
        } catch (IllegalLoanOperationException e) {
        }
    }
}

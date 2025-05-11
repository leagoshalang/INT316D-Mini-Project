/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bl;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.ac.tut.model.entity.Book;
import za.ac.tut.model.entity.Transaction;
import za.ac.tut.model.entity.User;

/**
 *
 * @author morak
 */
@Stateless
public class TransactionFacade extends AbstractFacade<Transaction> implements TransactionFacadeLocal {

    @PersistenceContext(unitName = "LibraryManagerEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransactionFacade() {
        super(Transaction.class);
    }

    @Override
    public String borrowBook(String isbn, User user) {
        try {
            Book book = em.createQuery("SELECT b FROM Book b WHERE b.isbn = :isbn", Book.class)
                          .setParameter("isbn", isbn)
                          .getSingleResult();

            if (book.getQuantity() <= book.getBorrowedCount()) {
                return "This book is not available at the moment.";
            }

            Transaction tx = new Transaction();
            tx.setBook(book);
            tx.setUser(user);
            tx.setIssueDate(new Date());
            em.persist(tx);

            book.borrowCopy();
            em.merge(book);

            return "Book borrowed successfully.";
        } catch (Exception e) {
            return "Error occurred while borrowing book: " + e.getMessage();
        }
    }

    @Override
    public void returnBook(Long transactionId, String isbn) {
        Transaction tx = em.find(Transaction.class, transactionId);
        if (tx != null && tx.getReturnDate() == null && isbn.equalsIgnoreCase(tx.getBook().getIsbn())) {
            tx.setReturnDate(new Date());
            tx.getBook().returnCopy();
            em.merge(tx);
            em.merge(tx.getBook());
        }
    }

    @Override
    public List<Transaction> currentBorrowings() {
        String qs = "SELECT t FROM Transaction t WHERE t.returnDate IS NULL";
        Query q = em.createQuery(qs);
        List<Transaction> transaction = q.getResultList();
        return transaction;
    }

    @Override
    public List<Book> getAllBorrowedBooks() {
        String qs = "SELECT DISTINCT t.book FROM Transaction t WHERE t.returnDate IS NULL";
        Query q = em.createQuery(qs);
        List<Book> book = q.getResultList();
        return book;
    }

    @Override
    public List<Transaction> getUserBorrowings(Long userId) {
        String qs = "SELECT t FROM Transaction t WHERE t.user.id = :uid AND t.returnDate IS NULL";
        Query q = em.createQuery(qs);
        List<Transaction> tran =q.getResultList();
        return tran;
    }
    
}

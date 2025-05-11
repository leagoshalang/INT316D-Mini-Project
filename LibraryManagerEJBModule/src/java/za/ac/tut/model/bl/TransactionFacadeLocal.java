/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.model.entity.Book;
import za.ac.tut.model.entity.Transaction;
import za.ac.tut.model.entity.User;

/**
 *
 * @author morak
 */
@Local
public interface TransactionFacadeLocal {

    void create(Transaction transaction);

    void edit(Transaction transaction);

    void remove(Transaction transaction);

    Transaction find(Object id);

    List<Transaction> findAll();

    List<Transaction> findRange(int[] range);

    int count();
    
    String borrowBook(String isbn, User user);
    
    void returnBook(Long transactionId, String isbn);
    
    List<Transaction> currentBorrowings();
    
    List<Book> getAllBorrowedBooks();
    
    List<Transaction> getUserBorrowings(Long userId);
    
}

package za.ac.tut.model.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import za.ac.tut.model.entity.Book;
import za.ac.tut.model.entity.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-11T19:31:17")
@StaticMetamodel(Transaction.class)
public class Transaction_ { 

    public static volatile SingularAttribute<Transaction, Date> returnDate;
    public static volatile SingularAttribute<Transaction, Book> book;
    public static volatile SingularAttribute<Transaction, Long> id;
    public static volatile SingularAttribute<Transaction, Date> issueDate;
    public static volatile SingularAttribute<Transaction, User> user;

}
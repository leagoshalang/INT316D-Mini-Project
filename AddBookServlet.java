
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.ejb.bl.BookFacadeLocal;
import za.ac.tut.entity.Author;
import za.ac.tut.entity.Book;


public class AddBookServlet extends HttpServlet {
    @EJB BookFacadeLocal bfl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        try {
            Long isbn = Long.parseLong(request.getParameter("isbn"));
            String title = request.getParameter("title");
            Double price = Double.parseDouble(request.getParameter("price"));
            String pubDate = request.getParameter("pubDate");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            Date pDate = dateFormat.parse(pubDate);
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            
            Book book = createBook(isbn, title, price, pDate, name, surname);
            bfl.create(book);
            
            RequestDispatcher disp = request.getRequestDispatcher("add_book_outcome.jsp");
            disp.forward(request, response);
            
        } catch (ParseException ex) {
            Logger.getLogger(AddBookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Book createBook(Long bn, String title, Double price, Date pDate, String name, String surname) {
        Book book = new Book();
        Author au = new Author();
        au.setName(name);
        au.setSurname(surname);
        book.setId(bn);
        book.setTitle(title);
        book.setPrice(price);
        book.setPublicationDate(new Date());
        book.setAuthor(au);
        book.setCreationDate(pDate);
        return book;
    }

}

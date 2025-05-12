
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.ejb.bl.BookFacadeLocal;
import za.ac.tut.entity.Book;


public class DeleteBookServlet extends HttpServlet {

    @EJB BookFacadeLocal bfl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Long isbn = Long.parseLong(request.getParameter("isbn"));
        Book book = bfl.find(isbn);
        
        bfl.remove(book);
        
        RequestDispatcher disp = request.getRequestDispatcher("delete_book_outcome.jsp");
        disp.forward(request, response);
        //processRequest(request, response);
    }

    
}

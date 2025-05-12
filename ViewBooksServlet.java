
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.ejb.bl.BookFacadeLocal;
import za.ac.tut.entity.Book;


public class ViewBooksServlet extends HttpServlet {
    @EJB BookFacadeLocal bfl;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List <Book> books = bfl.findAll();
        session.setAttribute("books", books);
        
        RequestDispatcher disp = request.getRequestDispatcher("view_books_outcome.jsp");
        disp.forward(request, response);
    }

}

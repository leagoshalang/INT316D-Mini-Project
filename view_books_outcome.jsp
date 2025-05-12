<%-- 
    Document   : view_books_outcome
    Created on : 07 Apr 2025, 8:32:39 PM
    Author     : marve
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entity.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Books Outcome Page</title>
    </head>
    <body>
        <h1>View books outcome</h1>
        <%
            List<Book> books = (List<Book>)session.getAttribute("books");
        %>
        <p>Below Are the books available</p>
        <table border="1">
            <thead>
                <th>ISBN</th>
                <th>Title</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Price</th>
                <th>Publish Date</th>
            </thead>
            <%
                for(int x=0;x<books.size();x++){
                    Book b = books.get(x);
                    Long id = b.getId();
                    String title = b.getTitle();
                    String name = b.getAuthor().getName();
                    String surname = b.getAuthor().getSurname();
                    Double price = b.getPrice();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                    Date pubDate = b.getPublicationDate();
                    String date = dateFormat.format(pubDate);
            %>
            
            <tr>
                <td><%=id%></td>
                <td><%=title%></td>
                <td><%=name%></td>
                <td><%=surname%></td>
                <td><%=price%></td>
                <td><%=date%></td>
            </tr>
            <%
                }
            %>
        </table>
        <p>
            Click <a href="menu.jsp">here</a> to go to menu or <a href="index.html">here</a> to go to main page
        </p>
    </body>
</html>

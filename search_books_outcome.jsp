<%-- 
    Document   : search_books_outcome
    Created on : 12 May 2025, 2:27:34 PM
    Author     : morak
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entity.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>search outcome Page</title>
    </head>
    <body>
        <h1>search book outcome</h1>
        
        <%
            List<Book> book = (List<Book>)session.getAttribute("book");
        %>
        <p>Below Are the books available</p>
        <table >
            
            <%
                for(int x=0;x<book.size();x++){
                    Book b = book.get(x);
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
                <td>ID</td>
                <td><b><%=id%></b></td>
            </tr>
            <tr>
                <td>Title</td>
                <td><b><%=title%></b></td>
            </tr>
            <tr>
                <td>Author</td>
                <td><b><%=name%></b></td>
            </tr>
            <tr>
                <td>Surname</td>
                <td><b><%=surname%></b></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><b><%=price%></b></td>
            </tr>
            <tr>
                <td>Publish Date</td>
                <td><b><%=date%></b></td>
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

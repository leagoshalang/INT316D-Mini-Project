<%-- 
   
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book Page</title>
    </head>
    <body>
        <h1>Add book</h1>
        <p>
            Fill the Form below to add a book
        </p>
        <form action="AddBookServlet.do" method="POST">
            <table>
                <tr>
                    <td>ISBN:</td>
                    <td><input type="text" name="isbn" required="" /></td>
                </tr>
                <tr>
                    <td>Title:</td>
                    <td><input type="text" name="title" required="" /></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input type="text" name="price" required="" /></td>
                </tr>
                <tr>
                    <td>Publish date:</td>
                    <td><input type="date" name="pubDate" required="" /></td>
                </tr>
                <tr>
                    <td>Author name:</td>
                    <td><input type="text" name="name" required="" /></td>
                </tr>
                <tr>
                    <td>Author surname:</td>
                    <td><input type="text" name="surname" required="" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Add Book" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>

<%-- 
  
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete book Page</title>
    </head>
    <body>
        <h1>Delete book</h1>
        <p>
            Enter the isbn to delete book
        </p>
        <form action="DeleteBookServlet.do" method="POST">
            <table>
                <tr>
                    <td>Isbn:</td>
                    <td><input type="text" name="isbn" required="" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Delete Book" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>

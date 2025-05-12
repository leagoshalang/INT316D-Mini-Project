<%-- 
   
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>search for book Page</title>
    </head>
    <body>
        <h1>search book</h1>
        <p>
            Enter the title to search
        </p>
        <form action="SearchBookServlet.do" method="POST">
            <table>
                <tr>
                    <td>Title:</td>
                    <td><input type="text" name="title" required="" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Add Book" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>

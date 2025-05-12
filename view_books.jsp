<%-- 
 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Books Page</title>
    </head>
    <body>
        <h1>View Books</h1>
        <p>
            Click a button below to get All book available
        </p>
        <form action="ViewBooksServlet.do" method="GET">
            <table>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Get Book" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>

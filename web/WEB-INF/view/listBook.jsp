<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>ListBook</title>
</head>
<body>
<%--<form method="post" action="LoginServlet"  align="right">--%>
    <%--<p>--%>
        <%--Login: <input type="text" name="username">--%>
        <%--Password: <input type="text" name="password">--%>
        <%--<input type="submit" value="Login">--%>
    <%--</p>--%>
<%--</form>--%>
<%--<form method="post" action="RegServlet"  align="right">--%>
    <%--<p><button type="submit">Registration</button></p>--%>
    <%--<hr />--%>
<%--</form>--%>
    <%--<h1 align="center">List of books</h1>--%>
<%--<table border="1" cellpadding="7" cellspacing="1">--%>
    <%--<tr>--%>
        <%--<td width="5%" align="center">#</td>--%>
        <%--<td width="50%" align="center">BookName</td>--%>
        <%--<td width="50%" align="center">AuthorName</td>--%>
        <%--<td width="50%" align="center">AddedName</td>--%>
    <%--</tr>--%>
<%--<% List<Book> book = (List<Book>) request.getAttribute("listBook");--%>
    <%--for(int i = 0; i < book.size(); i++) { // ???? %>--%>
    <%--<tr>--%>
        <%--<form method="post" action="DeleteServlet">--%>
            <%--<td width="5%" align="center"><%= i + 1 %></td>--%>
            <%--<td width="50%" align="center"><%=BOOK_LIST.get(i).getBookName()%></td>--%>
            <%--<td width="50%" align="center"><%=BOOK_LIST.get(i).getAuthorName()%></td>--%>
            <%--<td width="50%" align="center"><%=BOOK_LIST.get(i).getAddedName()%></td>--%>
            <%--&lt;%&ndash;<td width="50%" align="center"><button name="button" type="submit" value="button<%=i%>">Del</button></td>&ndash;%&gt;--%>
        <%--</form>--%>
    <%--</tr>--%>
   <%--<% } %>--%>
<%--</table>--%>
<%--<br>--%>
    <%--<a href='http://localhost:8080/addingBook.jsp'><< Add a book</a>--%>
    <%--<a href='http://localhost:8080/userListBook.jsp'><< User page</a>--%>
    <c:if test="${not empty books}">
        <ul>
            <c:forEach var="book" items="${books}">
                <li>${book.bookName}, ${book.authors}, ${book.user}</li>
            </c:forEach>
        </ul>
    </c:if>
    <a href="/book/add">Add Book</a>

</body>
</html>







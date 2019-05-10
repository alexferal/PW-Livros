<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h1>Lista de Livros</h1>
<ul>
<c:forEach items="${livros}" var="livro">
	<li>${livro.titulo}</li>
</c:forEach>
</ul>
</body>
</html>

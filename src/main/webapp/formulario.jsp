<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link href="css/formulario.css" type="text/css" rel="stylesheet" />
</head>
<body>
<h1>Álbum de fotos</h1>
<form method="post" enctype="multipart/form-data" action="albuns">

	<fieldset>
		<label>Título do álbum: </label>
		<input type="text" name="titulo" />
	</fieldset>

	<fieldset>
		<label>Autor: </label>
		<input type="text" name="autor" />
	</fieldset>

	<fieldset>
		<label>Publicado: </label>
		<input type="checkbox" name="publicado" value="True"/>
	</fieldset>

	<fieldset>
		<label>Arquivo: </label>
		<input type="file" name="file" id="file" accept="image/*" multiple/>
	</fieldset>

	<input type="submit" value="enviar" class="btn" />
</form>

</body>
</html>

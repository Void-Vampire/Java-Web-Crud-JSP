<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edição do Usuário</title>
</head>
<body>

	<%@page import="com.crudJSP.bean.Usuario, com.crudJSP.dao.UsuarioDAO" %>
	
	<% 
		String id = request.getParameter("id");
		Usuario usuario = UsuarioDAO.getRegistroById(Integer.parseInt(id));	
	%>
	
	<h1>Edição do Usuário</h1>
	
	<form action="editusuario.jsp" method="post">
	<input type="hidden" name="id" value="<%=usuario.getId()%>"/>
	<table>
		<tr>
			<td>Nome: </td>
			<td><input type="text" name="nome" value="<%=usuario.getNome()%>"/></td>
		</tr>
		<tr>
			<td>Password: </td>
			<td><input type="password" name="password" value="<%=usuario.getPassword()%>"/></td>
		</tr>
		<tr>
			<td>Email: </td>
			<td><input type="email" name="email" value="<%=usuario.getEmail()%>"/></td>
		</tr>
		<tr>
			<td>Sexo: </td>
			<td><input type="radio" name="sexo" value="Masculino"/>Masculino
				<input type="radio" name="sexo" value="Feminino"/>Feminino</td>
		</tr>
		<tr>
			<td>País: </td>
			<td>
				<select name="pais">
				<option>Alemanha</option>
				<option>Argentina</option>
				<option>Brasil</option>
				<option>Chile</option>
				<option>ColÔmbia</option>
				<option>Estados Unidos</option>
				<option>França</option>
				<option>Portugal</option>
				<option>Uruguai</option>
				<option>Outro</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Idade: </td>
			<td><input type="number" name="idade" value="<%=usuario.getIdade()%>"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Editar Usuário"></input></td>
		</tr>
	</table>
	</form>

</body>
</html>
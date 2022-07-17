<%@page import="com.crudJSP.dao.UsuarioDAO"%>
<jsp:useBean id="u" class="com.crudJSP.bean.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
UsuarioDAO.deletarUsuario(u);
response.sendRedirect("viewusuarios.jsp");
%>
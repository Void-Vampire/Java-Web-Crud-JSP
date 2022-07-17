<%@page import="com.crudJSP.dao.UsuarioDAO"%>
<jsp:useBean id="u" class="com.crudJSP.bean.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
int i = UsuarioDAO.updateUsuario(u);
response.sendRedirect("viewusuarios.jsp");
%>
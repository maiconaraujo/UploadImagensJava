<%-- 
    Document   : JSPexemplo
    Created on : 26/01/2018, 10:34:04
    Author     : sala308b
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="dao" class="dao.UploadDAO"></jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     
        <h1>Listagem de Produtos</h1>
        <table border="1">
            <c:forEach var="i" items="${dao.listaImagens()}">
                <tr>
                    <td>${i.codigo}</td>
                    <td><img src="<c:url value="/CarregarImagem?id=${i.codigo}" />" width="200" height="200"></td>                    
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

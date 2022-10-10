<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%//A nota��p @ indica q ser� feito uma importa��o %>    
<%@ page import="java.util.List, br.com.JavaServelet.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
	Lista de empresas: <br />
    <ul>
        <c:forEach items="${empresas}" var="empresa">
            <li>${empresa.nome} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> </li>
            
            <a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id} ">edita</a>
            <!-- Link para remover uma empresa levando para o jsp removerEmpresa -->
            <!-- Inserido no link o atributo opcional para passar o ID junto com a url da requisi��o -->
            <a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${empresa.id} ">remove</a>
        </c:forEach>
    </ul>
	</body>
</html>
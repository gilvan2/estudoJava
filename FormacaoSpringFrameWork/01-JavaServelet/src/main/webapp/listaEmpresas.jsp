<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%//A notaçãp @ indica q será feito uma importação %>    
<%@ page import="java.util.List, br.com.JavaServelet.gerenciador.servlet.Empresa"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <ul>
    <%
    //Uma lista de empresas recuperada da request e um cast informando que o objeto é do tipo List<Empresa> 
    List<Empresa> lista = (List<Empresa>)request.getAttribute("empresas");
        for (Empresa empresa : lista) { 
    %>
        <li><%= empresa.getNome() %></li>
    <%
        }
    %>
    </ul>

</body>
</html>
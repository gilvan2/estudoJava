<%
//scriptlet
String nomeEmpresa = (String)request.getAttribute("empresa");
System.out.println(nomeEmpresa);
%>
<html><body>
<!--    Abrevia��o para n�o precisar usar  out.println(nomeEmpresa) -->
Empresa <%=  (nomeEmpresa) %> cadastrada com sucesso!
</body></html>
 
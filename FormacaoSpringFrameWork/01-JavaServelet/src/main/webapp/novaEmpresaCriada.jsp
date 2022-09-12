<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<body>
		<!--    Abrevia��o para n�o precisar usar  out.println(nomeEmpresa) -->
		<c:if test="${not empty empresa}">
			Empresa ${ empresa } cadastrada com sucesso!
		</c:if>
		<c:if test="${empty empresa }">
			Nenhuma empreasa cadastrada!
		</c:if>
		
	</body>
</html>
 
 <!-- Foi simplificado para usar express�o (expression language outra forma de escrecer c�digo java de forma mais simples)-->
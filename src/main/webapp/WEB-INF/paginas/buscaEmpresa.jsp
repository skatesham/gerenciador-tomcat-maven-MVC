<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/paginas/base/header.jsp"%>
<%@ include file="/WEB-INF/paginas/base/navbar.jsp"%>
<h3>Resultado da busca:</h3>
<ol>
	<c:forEach var="empresa" items="${empresas}">
		<li>${empresa.getNome()}</li>
	</c:forEach>
</ol>
<%@ include file="/WEB-INF/paginas/base/footer.jsp"%>
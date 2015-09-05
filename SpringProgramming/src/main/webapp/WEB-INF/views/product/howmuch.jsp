<%@ page contentType="text/html; charset=UTF-8"%>

<% 
String amount=request.getParameter("amount");
%>
<div style="width:100%; height:100%">
	${product.name} * <%=amount%>
</div>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%	
	String cp = request.getContextPath();
	request.setCharacterEncoding("UTF-8");
	
	String msg = (String)request.getAttribute("msg");
	String url = (String)request.getAttribute("url");
%>

<script>
    alert('<%=msg %>');
    location.href = <%=url %>;
</script>
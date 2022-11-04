<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World this is index.js</title>
</head>
<body>
<header>
    <%@ include file="menu.jsp" %>
</header>
</h1>
<ol>
    <% for(int i=1;i<10;i++){%>
    <li>
        <%= "value "+ i %>
    </li>
    <% }%>
</ol>

name is ${o.getName()}
<br/>
<c:set var="a" value="98"/>

<c:out value="${a}" default="this is a default value"/>
<c:if test="${a>50}" var="b" scope="page">
    <c:out value="condition is satisfied !"/>
    ${b}

</c:if>
loop
<ul>
<c:forEach begin="1" step="1" end="10" var="i">
    <li>${i}</li>
</c:forEach>
</ul>
</body>
</html>
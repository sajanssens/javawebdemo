<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contacts</title>
</head>
<body>
<table>
    <c:forEach var="contact" items="${contacts}">
        <tr>
            <td><c:out value="${contact.firstname}" escapeXml="true"/></td>
            <td><c:out value="${contact.lastname}" escapeXml="true"/></td>
            <td><c:out value="${contact.email}" escapeXml="true"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
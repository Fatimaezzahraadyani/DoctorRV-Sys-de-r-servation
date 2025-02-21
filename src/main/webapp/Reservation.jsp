<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reservations</title>
</head>
<body>

    <h1>Mes reservations</h1>

    <c:if test="${not empty error}">
        <div style="color: red;">${error}</div>
    </c:if>

    <c:if test="${not empty reservations}">
        <table border="1">
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Heure</th>
                    <th>Nom d'utilisateur</th>
                    <th>Email</th>
                    <th>Téléphone</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="reservation" items="${reservations}">
                    <tr>
                        <td>${reservation.dateRv}</td>
                        <td>${reservation.heure}</td>
                        <td>${reservation.username}</td>
                        <td>${reservation.email}</td>
                        <td>${reservation.telephone}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

</body>
</html>

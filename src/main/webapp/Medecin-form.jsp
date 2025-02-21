<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.reservation.model.Reservation" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mes Réservations</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Mes Réservations</h2>
        
        <%
            // Récupérer la liste des réservations stockées dans la requête
            List<Reservation> reservations = (List<Reservation>) request.getAttribute("reservations");
            if (reservations == null || reservations.isEmpty()) {
        %>
            <div class="alert alert-info text-center">Aucune réservation trouvée.</div>
        <%
            } else {
        %>
            <table class="table table-bordered">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>userName</th>
                        <th>Email</th>
                        <th>Telephone</th>
                        <th>Motif</th>
                        <th>Date</th>
                        <th>heure</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Reservation res : reservations) {
                    %>
                    <tr>
                        <td><%= res.getId() %></td>
                        <td><%= res.getDateRdv() %></td>
                        <td><%= res.getHeure() %></td>
                        <td><%= res.getMedecinNom() %></td>
                        <td>
                            <form action="ReservationServlet" method="post">
                                <input type="hidden" name="idReservation" value="<%= res.getId() %>">
                                <input type="hidden" name="action" value="annuler">
                                <button type="submit" class="btn btn-danger btn-sm">Annuler</button>
                            </form>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        <% } %>
        
        <a href="index.jsp" class="btn btn-primary">Retour à l'accueil</a>
    </div>
</body>
</html>

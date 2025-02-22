<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire de Réservation</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body class="bg-light">
    <div class="container mt-5">
        <h2 class="text-center">Réservez un rendez-vous médical</h2>

        <form action="patientServlet" method="POST">
            <div class="mb-3">
                <label for="username" class="form-label">Nom d'utilisateur</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="mb-3">
                <label for="telephone" class="form-label">Téléphone</label>
                <input type="tel" class="form-control" id="telephone" name="telephone" required>
            </div>
            <div class="mb-3">
                <label for="dateRdv" class="form-label">Date du rendez-vous</label>
                <input type="date" class="form-control" id="dateRdv" name="dateRdv" required>
            </div>
            <div class="mb-3">
                <label for="heureRdv" class="form-label">Heure du rendez-vous</label>
                <input type="time" class="form-control" id="heureRdv" name="heureRdv" required>
            </div>
            <div class="mb-3">
                <label for="motif" class="form-label">Motif de la visite</label>
                <input type="text" class="form-control" id="motif" name="motif" required>
            </div>

            <button type="submit" class="btn btn-primary">Réserver</button>
        </form>
    </div>
</body>
</html>

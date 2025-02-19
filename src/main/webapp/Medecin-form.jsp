
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire Médecin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container mt-5">
        <h3>Formulaire Médecin</h3>
        <form action="MedecinServlet" method="post">
            <div class="mb-3">
                <label class="form-label">Nom :</label>
                <input type="text" name="nom" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Spécialité :</label>
                <input type="text" name="specialite" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-success">Continuer</button>
        </form>
    </div>

</body>
</html>

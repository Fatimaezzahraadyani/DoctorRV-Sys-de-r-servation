<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DoctorRV App</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body class="bg-light">

    <div class="container mt-5">
        <h2 class="text-center">Bienvenue sur l'application de gestion des rendez-vous</h2>
        <p class="text-center">Choisissez votre rôle :</p>

        <div class="text-center">
          
            <a href="PatientServlet" class="btn btn-primary me-2">Je suis un Patient</a>
           
            <a href="MedecinServlet" class="btn btn-success">Je suis un Médecin</a>
        </div>
    </div>

</body>
</html>

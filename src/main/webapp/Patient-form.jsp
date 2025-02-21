<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire Patient</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container mt-5">
        <h3>Formulaire Patient</h3>
        <form action="PatientServlet" method="post">
            <div class="mb-3">
                <label class="form-label">nom d'utilisateur :</label>
                <input type="text" name="nom" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Email :</label>
                <input type="email" name="email" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Téléphone :</label>
                <input type="text" name="telephone" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Motif :</label>
                <input type="text" name="telephone" class="form-control" required>
            </div>
            <div class="mb-3">
   				 <label class="form-label">Date du rendez-vous :</label>
    			 <input type="date" name="dateRdv" class="form-control" required>
			</div>

			<div class="mb-3">
 			   <label class="form-label">Heure du rendez-vous :</label>
    			<input type="time" name="heureRdv" class="form-control" required>
			</div>
            
            <a href="" type="submit" class="btn btn-primary">Continuer</a>
        </form>
    </div>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Page d'Inscription</title>
</head>
<body>

<h2>Veuillez vous inscrire pour continuer.</h2>

	<center><form action="SaveUser">
	<input  type="text" name="nom" placeholder="Nom *">
	<input  type="text" name="prenom" placeholder="Prénom *">
	<input  type="text" name="mail" placeholder="Email *">
	<input  type="password" name="mdp" placeholder="Mot de passe *">
	<input  type="submit" value="Valider">
	</form></center>

</body>
</html>
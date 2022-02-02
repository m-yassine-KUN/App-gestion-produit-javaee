<%@page import="modele.Produit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%  Produit p= (Produit) request.getAttribute("prd"); %>


<form action="controleur" method="post">

ID: <input type="text"  name="id"    value= "<%= p.getId()%>"/><br>
Nom: <input type="text"  name="nom"  value= "<%= p.getNom()%>" /><br>
Prix: <input type="text"  name="prix"   value= "<%= p.getPrix()%>"/><br>
Quantite: <input type="text"  name="quantite"  value= "<%= p.getQuantite()%>"/><br>
<input type="submit"  value="ajouter"/><br>
</form>

</body>
</html>
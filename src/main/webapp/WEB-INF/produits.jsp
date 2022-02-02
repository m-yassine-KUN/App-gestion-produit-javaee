<%@page import="modele.Produit"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LISTE DES PRODUITS</title>
<link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="card container mt-5 mx-auto" >
  <div class="card-body">
    <h5 class="card-title">Gestion des produits</h5>
    <p class="card-text">Cette application web permet la gestion des produits online.</p>
    <a href="index.html" class="btn btn-warning">Back</a>
    
  </div>
</div>



<div>
<%  Produit produit= (Produit) request.getAttribute("prd"); 
if(produit==null) produit= new Produit();
%>
<div class="container mt-5">
<form action="controleur" method="post">



  <div class="row">
    <div class="col">
    <div class="input-group flex-nowrap">
  <span class="input-group-text" id="addon-wrapping">ID:</span>
  <input type="int" class="form-control" name="id"    value= "<%= produit.getId()%>">
</div>
      
    </div>
    
    <div class="col">
    <div class="input-group flex-nowrap">
  <span class="input-group-text" id="addon-wrapping">Nom:</span>
  <input type="text" class="form-control" name="nom"    value= "<%= produit.getNom()%>">
</div>
    </div>
    
    <div class="col">
    <div class="input-group flex-nowrap">
  <span class="input-group-text" id="addon-wrapping">Prix:</span>
  <input type="int" class="form-control" name="prix"     value= "<%= produit.getPrix()%>">
</div>
    
    </div>
    <div class="col">
    
    <div class="input-group flex-nowrap">
  <span class="input-group-text" id="addon-wrapping">Quantite</span>
  <input type="int" class="form-control" name="quantite"     value= "<%= produit.getQuantite()%>">
    
    
    
    </div>
  </div>
  <div class="row mt-4 mx-auto">
    <div class="col">
     <span><div class="d-grid gap-2">
     <input type="submit" class="btn btn-success btn-lg btn-block"  value="ajouter"/>
  </div>
    </div>
  </div>
 </form>
</div>

</div>



<div class="container mx-auto  mt-5">
<%  Collection<Produit>  liste= (Collection<Produit>) request.getAttribute("produits"); 

if(liste!=null){

%>

<table border="1" class="table table-striped ">
<tr><th>ID</th><th>NOM</th><th>PRIX</th><th>QTE</th><th>Actions</th></tr>

<% for(Produit p: liste){ %>

<tr>
<td class="col-1"><%= p.getId() %></td>
<td class="col-3"><%= p.getNom() %></td>
<td class="col-2"><%= p.getPrix() %></td>
<td class="col-2"><%= p.getQuantite() %></td>
<td>
<div class="row"><div class="col-sm">
      <a href="controleur?action=delete&id=<%= p.getId() %>"><i class="ri-delete-bin-2-line"></i>Supprimer</a>
    </div>
    <div class="col-sm">
      <a href="controleur?action=edit&id=<%= p.getId()%>"><i class="ri-edit-box-line"></i>Editer</a>
    </div> 
    </div>
 
 </td>

</tr>

<%} }%>
</table>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
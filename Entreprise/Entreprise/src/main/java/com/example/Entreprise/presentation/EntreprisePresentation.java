package com.example.Entreprise.presentation;
import java.util.ArrayList;
import java.util.List;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
@Path("entreprises")
public class EntreprisePresentation {
@GET
@Produces("application/json")
public List<EntrepriseDTO> getEntreprises(){
//ici on met new ArrayList en attendant les autres
//classes permettant d'aller chercher les données en bdd
return new ArrayList<>();
}
}
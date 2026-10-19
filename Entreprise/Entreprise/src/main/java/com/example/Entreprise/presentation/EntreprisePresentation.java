package com.example.Entreprise.presentation;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Entreprise.application.Entreprise;
import com.example.Entreprise.application.EntrepriseService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("entreprises")
public class EntreprisePresentation {
//permet à Spring de récupérer l'instance EntrepriseService afin de manipulerson contenu
@Autowired
private EntrepriseService service;
@GET
@Produces("application/json")
public List<EntrepriseDTO> getEntreprises(){
//ne pas oublier de mapper les données :)
EntrepriseMapper em = new EntrepriseMapper();
List<Entreprise> entreprisesBdd = service.getEntreprise();
List<EntrepriseDTO> entreprisesRetournees = new ArrayList<>();
//dans cette partie, on transforme les données en EntrepriseDTO
for(Entreprise e : entreprisesBdd){
entreprisesRetournees.add(em.mapEntrepriseToEntrepriseDTO(e));
}
return entreprisesRetournees;
}



//verbe de création
@POST
//permet de dire que le webservice attend un json avec la requête
@Consumes("application/json")
public void creationEntreprise(CreationEntrepriseDTO entrepriseDTO){
Entreprise entrepriseToSave = new
EntrepriseMapper().mapEntrepriseDTOToEntreprise(entrepriseDTO);
service.creationEntreprise(entrepriseToSave);
}


}
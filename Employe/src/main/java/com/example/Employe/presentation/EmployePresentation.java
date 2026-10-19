package com.example.Employe.presentation;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Employe.application.Employe;
import com.example.Employe.application.EmployeService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("entreprises")
public class EmployePresentation {
//permet Ã  Spring de rÃ©cupÃ©rer l'instance EmployeService afin de manipulerson contenu
@Autowired
private EmployeService service;
@GET
@Produces("application/json")
public List<EmployeDTO> getEmployes(){
//ne pas oublier de mapper les donnÃ©es :)
EmployeMapper em = new EmployeMapper();
List<Employe> entreprisesBdd = service.getEmploye();
List<EmployeDTO> entreprisesRetournees = new ArrayList<>();
//dans cette partie, on transforme les donnÃ©es en EmployeDTO
for(Employe e : entreprisesBdd){
entreprisesRetournees.add(em.mapEmployeToEmployeDTO(e));
}
return entreprisesRetournees;
}



//verbe de crÃ©ation
@POST
//permet de dire que le webservice attend un json avec la requÃªte
@Consumes("application/json")
public void creationEmploye(CreationEmployeDTO entrepriseDTO){
Employe entrepriseToSave = new
EmployeMapper().mapEmployeDTOToEmploye(entrepriseDTO);
service.creationEmploye(entrepriseToSave);
}


}
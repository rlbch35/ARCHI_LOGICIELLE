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
import jakarta.ws.rs.QueryParam;

@Path("employes")
public class EmployePresentation {
//permet Ã  Spring de rÃ©cupÃ©rer l'instance EmployeService afin de manipulerson contenu
@Autowired
private EmployeService service;
@GET
@Produces("application/json")
public List<EmployeDTO> getEmployes(@QueryParam("idEmployes") List<Integer> idEmployes){
//ne pas oublier de mapper les donnÃ©es :)
EmployeMapper em = new EmployeMapper();
List<Employe> employesBdd;
if(idEmployes == null || idEmployes.isEmpty()){
employesBdd = service.getEmploye();
}else{
employesBdd = service.getEmployesByIds(idEmployes);
}
List<EmployeDTO> employesRetournees = new ArrayList<>();
//dans cette partie, on transforme les donnÃ©es en EmployeDTO
for(Employe e : employesBdd){
employesRetournees.add(em.mapEmployeToEmployeDTO(e));
}
return employesRetournees;
}



//verbe de crÃ©ation
@POST
//permet de dire que le webservice attend un json avec la requÃªte
@Consumes("application/json")
@Produces("application/json")
public void creationEmploye(CreationEmployeDTO entrepriseDTO){
Employe entrepriseToSave = new
EmployeMapper().mapEmployeDTOToEmploye(entrepriseDTO);
service.creationEmploye(entrepriseToSave);
}


}
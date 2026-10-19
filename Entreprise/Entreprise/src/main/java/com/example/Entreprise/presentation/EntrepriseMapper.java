package com.example.Entreprise.presentation;

import java.util.ArrayList;
import java.util.List;

import com.example.Entreprise.application.EmployeDAO;
import com.example.Entreprise.application.Entreprise;


public class EntrepriseMapper {

public EntrepriseDTO mapEntrepriseToEntrepriseDTO(Entreprise entreprise){
return new EntrepriseDTO(entreprise.getId(), entreprise.getNom(), new ArrayList<>());
}

public Entreprise mapEntrepriseDTOToEntreprise(CreationEntrepriseDTO entrepriseDTO){
return new Entreprise(entrepriseDTO.getId(),entrepriseDTO.getNom(),entrepriseDTO.getIdEmployes());
}

public List<EmployeDTO> mapEmployeDAOToEmployeDTO(List<EmployeDAO> employesDAO){
List<EmployeDTO> employesDTO = new ArrayList<>();
for(EmployeDAO employeDAO : employesDAO){
employesDTO.add(new EmployeDTO(employeDAO.getId(), employeDAO.getNom()));
}
return employesDTO;
}

}
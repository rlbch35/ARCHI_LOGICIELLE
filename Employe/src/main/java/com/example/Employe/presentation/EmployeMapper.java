package com.example.Employe.presentation;

import com.example.Employe.application.Employe;

public class EmployeMapper {

public EmployeDTO mapEmployeToEmployeDTO(Employe entreprise){
return new EmployeDTO(entreprise.getId(), entreprise.getNom());
}

public Employe mapEmployeDTOToEmploye(CreationEmployeDTO entrepriseDTO){
return new Employe(entrepriseDTO.getId(),entrepriseDTO.getNom(),entrepriseDTO.getIdEmployes());
}

}
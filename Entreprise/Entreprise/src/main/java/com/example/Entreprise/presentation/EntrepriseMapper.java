package com.example.Entreprise.presentation;

import com.example.Entreprise.application.Entreprise;
public class EntrepriseMapper {
public EntrepriseDTO mapEntrepriseToEntrepriseDTO(Entreprise entreprise){
return new EntrepriseDTO(entreprise.getId(), entreprise.getNom());
}
}
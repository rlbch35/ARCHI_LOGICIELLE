package com.example.Entreprise.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entreprise.infrastructure.EntrepriseRepository;
//permet à Spring d'initialiser cet objet et de le configurer
@Service
public class EntrepriseService {
//permet de récupérer l'instance de EntrepriseRepository dans Spring et demanipuler JPA à travers cette dernière
@Autowired
private EntrepriseRepository repo;
public List<Entreprise> getEntreprise(){
return repo.findAll();//retourne toutes les entreprises contenues en bdd
}

public void creationEntreprise(Entreprise entreprise){
repo.save(entreprise);
}

}
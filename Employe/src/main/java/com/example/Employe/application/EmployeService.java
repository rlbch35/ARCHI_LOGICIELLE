package com.example.Employe.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Employe.infrastructure.EmployeRepository;
//permet Ã  Spring d'initialiser cet objet et de le configurer
@Service
public class EmployeService {
//permet de rÃ©cupÃ©rer l'instance de EmployeRepository dans Spring et demanipuler JPA Ã  travers cette derniÃ¨re
@Autowired
private EmployeRepository repo;
public List<Employe> getEmploye(){
return repo.findAll();//retourne toutes les entreprises contenues en bdd
}

public void creationEmploye(Employe entreprise){
repo.save(entreprise);
}

}
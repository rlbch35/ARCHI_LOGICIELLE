package com.example.Employe.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Employe.infrastructure.EmployeRepository;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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

public List<Employe> getEmployesByIds(List<Integer> idEmployes){
List<Employe> employesRetournes = new ArrayList<>();
//parcoure tous les identifiants reçus et va chercher les infos employés unpar un
//ce n'est pas la méthode la plus optimisée mais c'est une solution simple
for(int id : idEmployes){
Optional<Employe> e = repo.findById(id);
//ce controle permet d'ajouter les infos employé seulement si ellesexistent
if(e.isPresent()){
employesRetournes.add(e.get());
}
}
return employesRetournes;
}


public List<EmployeDAO> getEmployes(List<Integer> idEmployes){
//déclaration de l'objet permettant de déclencher un appel REST
Client client = ClientBuilder.newClient();
//on paramètre le lien d'appel, notre module Employe
WebTarget target = client.target("http://localhost:8081/api/employes");
// Ajout des query params représentant les identifiants d'employés
for (var id : idEmployes) {
target = target.queryParam("idEmployes", id);
}
Response response = target.request(MediaType.APPLICATION_JSON).get();
//ici, cela nous permet de convertir directement la réponse du webserviceen objet EmployeDAO
List<EmployeDAO> employes = response.readEntity(new
GenericType<List<EmployeDAO>>() {});
response.close();
client.close();
return employes;
}

}
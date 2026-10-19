package com.example.Employe.infrastructure;

import com.example.Employe.application.Employe;
import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.JpaRepository;

//permet Ã  Spring de crÃ©er l'objet et de le configurer correctement
@Component
//ici on indique Ã  JPARepository qu'on manipule des objets Employe
//et ces derniers possÃ¨dent un identifiant en format entier
public interface EmployeRepository extends JpaRepository<Employe, Integer>{
}
package com.example.Employe;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.ws.rs.ApplicationPath;
import com.example.Employe.presentation.EmployePresentation;

@Component
//donne un chemin de base aux liens qui vont Ãªtre exposÃ©s
@ApplicationPath("api")
//indique Ã  Spring que le composant qui va Ãªtre crÃ©Ã© qu'il s'agit d'une configuration globale
@Configuration

public class JerseyConfig extends ResourceConfig {//permet de configurer l'instanciation avec Spring
public JerseyConfig(){
//enregistre la classe oÃ¹ les webservices vont Ãªtre exposÃ©s
register(EmployePresentation.class);
}
}

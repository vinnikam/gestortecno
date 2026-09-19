package edu.ucentral.vinni.dominio;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PortatilRepositorio implements PanacheRepository<Portatil> {
}

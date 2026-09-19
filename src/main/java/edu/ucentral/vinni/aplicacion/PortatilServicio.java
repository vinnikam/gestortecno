package edu.ucentral.vinni.aplicacion;

import edu.ucentral.vinni.dominio.Portatil;
import edu.ucentral.vinni.dominio.PortatilRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PortatilServicio {

    @Inject
    PortatilRepositorio portatilRepositorio;

    @Transactional
    public void crear(Portatil portatil){
        portatilRepositorio.persist(portatil);
    }
}

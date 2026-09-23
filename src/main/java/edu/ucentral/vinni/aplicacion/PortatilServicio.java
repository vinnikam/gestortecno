package edu.ucentral.vinni.aplicacion;


import edu.ucentral.vinni.dominio.Portatil;
import edu.ucentral.vinni.dominio.PortatilRepositorio;
import edu.ucentral.vinni.infraestructura.dto.PortatilPayLoad;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;


@ApplicationScoped
public class PortatilServicio {

    private static final Logger LOG = Logger.getLogger(PortatilServicio.class);


    @Inject
    PortatilRepositorio portatilRepositorio;

    @Transactional
    public void crear(PortatilPayLoad portatilPayLoad){
        // Se mapea el Dto que llega por el Entity
        Portatil portatil = new Portatil(
                portatilPayLoad.serial(),
                portatilPayLoad.marca(),
                portatilPayLoad.memoria());

            portatilRepositorio.persist(portatil);
    }
}

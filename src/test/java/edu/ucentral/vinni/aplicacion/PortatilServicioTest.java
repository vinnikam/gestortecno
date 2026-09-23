package edu.ucentral.vinni.aplicacion;

import edu.ucentral.vinni.dominio.Portatil;
import edu.ucentral.vinni.dominio.PortatilRepositorio;
import edu.ucentral.vinni.infraestructura.dto.PortatilPayLoad;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@QuarkusTest
public class PortatilServicioTest {
    @Inject
    PortatilServicio portatilServicio;

    @InjectMock
    PortatilRepositorio portatilRepositorio;
    @Test
    public void testCrearPortatil(){
        PortatilPayLoad portatil = new
                PortatilPayLoad("LG", "123",16);


        portatilServicio.crear(portatil);
        verify(portatilRepositorio,
                times(1))
                .persist(any(Portatil.class));
    }
    @Test
    public void testCrearPortatilVacios(){
        PortatilPayLoad portatil = new PortatilPayLoad("", "", 0);

        portatilServicio.crear(portatil);
        verify(portatilRepositorio,
                times(1))
                .persist(any(Portatil.class));
    }
}

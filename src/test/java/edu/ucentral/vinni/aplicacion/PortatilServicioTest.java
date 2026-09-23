package edu.ucentral.vinni.aplicacion;

import edu.ucentral.vinni.dominio.Portatil;
import edu.ucentral.vinni.dominio.PortatilRepositorio;
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
        Portatil portatil = Portatil.builder()
                .marca("LG")
                .memoria(16)
                .serial("123")
                .build();

        portatilServicio.crear(portatil);
        verify(portatilRepositorio,
                times(1))
                .persist(any(Portatil.class));
    }
    @Test
    public void testCrearPortatilVacios(){
        Portatil portatil = Portatil.builder()
                .build();

        portatilServicio.crear(portatil);
        verify(portatilRepositorio,
                times(1))
                .persist(any(Portatil.class));
    }
}

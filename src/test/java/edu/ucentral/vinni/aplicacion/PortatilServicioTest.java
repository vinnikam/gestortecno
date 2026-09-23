package edu.ucentral.vinni.aplicacion;

import edu.ucentral.vinni.dominio.Portatil;
import edu.ucentral.vinni.dominio.PortatilRepositorio;
import edu.ucentral.vinni.infraestructura.dto.PortatilPayLoad;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
    @Test
    public void testListarPortatilVacios(){

        when(portatilRepositorio.listAll()).thenReturn(Collections.emptyList());

        List<PortatilPayLoad> datos = portatilServicio.consultarTodos();

        assertTrue(datos.isEmpty(), "La lista de payloads debería estar vacía");

        verify(portatilRepositorio, times(1)).listAll();

    }
    @Test
    public void testListarPortatilConUnRegistro() {
        Portatil portatilSimulado = new Portatil();
        portatilSimulado.serial = "XYZ123";
        portatilSimulado.marca = "Dell";
        portatilSimulado.memoria = 16;

        when(portatilRepositorio.listAll()).thenReturn(List.of(portatilSimulado));

        List<PortatilPayLoad> datos = portatilServicio.consultarTodos();

        assertNotNull(datos, "La lista devuelta no debería ser nula");
        assertFalse(datos.isEmpty(), "La lista no debería estar vacía");
        assertEquals(1, datos.size(), "La lista debería contener exactamente 1 registro");

        // Validar que el mapeo de los datos del Record
        PortatilPayLoad resultado = datos.get(0);
        assertEquals("XYZ123", resultado.serial(), "El serial mapeado no coincide");
        assertEquals("Dell", resultado.marca(), "La marca mapeada no coincide");
        assertEquals(16, resultado.memoria(), "La memoria mapeada no coincide");

        verify(portatilRepositorio, times(1)).listAll();
    }
}

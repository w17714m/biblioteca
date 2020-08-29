package com.w17714m.biblioteca.aplicacion.manejadores.libro;

import com.w17714m.biblioteca.aplicacion.comando.ComandoLibro;
import com.w17714m.biblioteca.aplicacion.fabrica.FabricaLibro;
import com.w17714m.biblioteca.dominio.Libro;
import com.w17714m.biblioteca.dominio.servicio.libro.ServicioCrearLibro;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorCrearLibro {

    private final ServicioCrearLibro servicioCrearLibro;
    private final FabricaLibro fabricaLibro;

    public ManejadorCrearLibro(ServicioCrearLibro servicioCrearLibro, FabricaLibro fabricaLibro) {
        this.servicioCrearLibro = servicioCrearLibro;
        this.fabricaLibro = fabricaLibro;
    }

    @Transactional
    public void ejecutar(ComandoLibro comandoLibro) {
        Libro libro = this.fabricaLibro.crearLibro(comandoLibro);
        this.servicioCrearLibro.ejecutar(libro);
    }
}

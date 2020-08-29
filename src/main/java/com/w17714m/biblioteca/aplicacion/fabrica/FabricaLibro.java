package com.w17714m.biblioteca.aplicacion.fabrica;

import com.w17714m.biblioteca.aplicacion.comando.ComandoLibro;
import com.w17714m.biblioteca.dominio.Libro;
import org.springframework.stereotype.Component;

@Component
public class FabricaLibro {
    public Libro crearLibro(ComandoLibro comandoLibro) {
        return new Libro(comandoLibro.getIsbn(), comandoLibro.getTitulo(), comandoLibro.getAnio());
    }
}

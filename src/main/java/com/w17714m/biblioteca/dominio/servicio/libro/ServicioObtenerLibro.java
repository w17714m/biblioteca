package com.w17714m.biblioteca.dominio.servicio.libro;

import com.w17714m.biblioteca.dominio.Libro;
import com.w17714m.biblioteca.infraestructura.persistencia.repositorio.RepositorioLibroPersistente;
import org.springframework.stereotype.Component;

@Component
public class ServicioObtenerLibro {

    private final RepositorioLibroPersistente repositorioLibro;

    public ServicioObtenerLibro(RepositorioLibroPersistente repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public Libro ejecutar(String isbn) {
        return this.repositorioLibro.obtenerPorIsbn(isbn);
    }
}

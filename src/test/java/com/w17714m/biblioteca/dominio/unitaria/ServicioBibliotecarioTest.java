
package com.w17714m.biblioteca.dominio.unitaria;


import com.w17714m.biblioteca.dominio.Libro;
import com.w17714m.biblioteca.dominio.repositorio.RepositorioLibro;
import com.w17714m.biblioteca.dominio.repositorio.RepositorioPrestamo;
import com.w17714m.biblioteca.dominio.servicio.bibliotecario.ServicioBibliotecario;
import com.w17714m.biblioteca.dominio.util.Utils;
import com.w17714m.biblioteca.testdatabuilder.LibroTestDataBuilder;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServicioBibliotecarioTest {

    @Test
    public void libroYaEstaPrestadoTest() {

        // arrange
        Libro libro = new LibroTestDataBuilder().build();

        RepositorioPrestamo repositorioPrestamo = mock(RepositorioPrestamo.class);
        RepositorioLibro repositorioLibro = mock(RepositorioLibro.class);

        when(repositorioPrestamo.obtenerLibroPrestadoPorIsbn(libro.getIsbn())).thenReturn(libro);

        ServicioBibliotecario servicioBibliotecario = new ServicioBibliotecario(repositorioLibro, repositorioPrestamo);

        // act
        boolean existeProducto = servicioBibliotecario.esPrestado(libro.getIsbn());

        //assert
        assertTrue(existeProducto);
    }

    @Test
    public void libroNoEstaPrestadoTest() {
        // test deploy
        // arrange
        Libro libro = new LibroTestDataBuilder().build();

        RepositorioPrestamo repositorioPrestamo = mock(RepositorioPrestamo.class);
        RepositorioLibro repositorioLibro = mock(RepositorioLibro.class);

        when(repositorioPrestamo.obtenerLibroPrestadoPorIsbn(libro.getIsbn())).thenReturn(null);

        ServicioBibliotecario servicioBibliotecario = new ServicioBibliotecario(repositorioLibro, repositorioPrestamo);

        // act
        boolean existeProducto = servicioBibliotecario.esPrestado(libro.getIsbn());

        //assert
        assertFalse(existeProducto);
    }

    @Test
    public void max15DiasTest() {
        //assert
        assertTrue(
                Utils.calcularDiasSinDomingos(
                        LocalDate.of(2017,05,24),14)
                        .equals(LocalDate.of(2017,06,9))
        );

        assertTrue(
                Utils.calcularDiasSinDomingos(
                        LocalDate.of(2017,05,26),14)
                        .equals(LocalDate.of(2017,06,12))
        );
    }

}


package com.w17714m.biblioteca.dominio.servicio.bibliotecario;

import com.w17714m.biblioteca.dominio.Libro;
import com.w17714m.biblioteca.dominio.Prestamo;
import com.w17714m.biblioteca.dominio.excepcion.PrestamoException;
import com.w17714m.biblioteca.dominio.repositorio.RepositorioLibro;
import com.w17714m.biblioteca.dominio.repositorio.RepositorioPrestamo;
import com.w17714m.biblioteca.dominio.util.Utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ServicioBibliotecario {

    public static final String EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE = "El libro no se encuentra disponible";
    public static final String MSG_EXCEPTION_PALINDROMO = "los libros palíndromos solo se pueden utilizar en la biblioteca";
    public static final long CONDICION_MAX_15_DIAS = 30l;
    public static final int QUINCE_DIAS = 14;

    private final RepositorioLibro repositorioLibro;
    private final RepositorioPrestamo repositorioPrestamo;

    public ServicioBibliotecario(RepositorioLibro repositorioLibro, RepositorioPrestamo repositorioPrestamo) {
        this.repositorioLibro = repositorioLibro;
        this.repositorioPrestamo = repositorioPrestamo;
    }

    public void prestar(String isbn, String nombreUsuario) {
        if(!esPrestado(isbn)){
            if(Utils.esPalindromo(isbn))
                throw new PrestamoException(MSG_EXCEPTION_PALINDROMO);

            Libro libro = this.repositorioLibro.obtenerPorIsbn(isbn);
            if(Utils.sumaNumerosIsbn(isbn)> CONDICION_MAX_15_DIAS){
                this.repositorioPrestamo.agregar(new Prestamo(
                        Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                        libro,
                        Date.from(Utils.calcularDiasSinDomingos(LocalDate.now(),QUINCE_DIAS).atStartOfDay(ZoneId.systemDefault()).toInstant()),
                        nombreUsuario
                ));
            }else{
                this.repositorioPrestamo.agregar(new Prestamo(
                        Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                        libro,
                        null,
                        nombreUsuario
                ));
            }
        }else{
            throw new PrestamoException(EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE);
        }
    }

    public boolean esPrestado(String isbn) {
        // se verifica unicamente con la existencia del isbn en la tabla prestamo porque no hay otra
        // columna para indicar si ya fue entregado y en que fecha fue.
        Libro libro = this.repositorioPrestamo.obtenerLibroPrestadoPorIsbn(isbn);
        return libro == null ? false : true;
    }
}

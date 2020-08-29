package com.w17714m.biblioteca.aplicacion.fabrica;

import com.w17714m.biblioteca.aplicacion.comando.ComandoPrestamo;
import com.w17714m.biblioteca.dominio.Prestamo;

public class FabricaPrestamo {

    public Prestamo crearPrestamo(ComandoPrestamo comandoPrestamo) {
        return new Prestamo(
                comandoPrestamo.getFechaSolicitud(),
                comandoPrestamo.getLibro(),
                comandoPrestamo.getFechaEntregaMaxima(),
                comandoPrestamo.getNombreUsuario()
        );
    }
}

package com.w17714m.biblioteca.aplicacion.manejadores.prestamo;

import com.w17714m.biblioteca.dominio.servicio.bibliotecario.ServicioBibliotecario;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorGenerarPrestamo {

    private final ServicioBibliotecario servicioBibliotecario;

    public ManejadorGenerarPrestamo(ServicioBibliotecario servicioBibliotecario) {
        this.servicioBibliotecario = servicioBibliotecario;
    }

    @Transactional
    public void ejecutar(String isbn, String nombreUsuarioPrestamo) {
        this.servicioBibliotecario.prestar(isbn,nombreUsuarioPrestamo);
    }
}

package com.w17714m.biblioteca.infraestructura.configuracion;

import com.w17714m.biblioteca.dominio.repositorio.RepositorioLibro;
import com.w17714m.biblioteca.dominio.repositorio.RepositorioPrestamo;
import com.w17714m.biblioteca.dominio.servicio.bibliotecario.ServicioBibliotecario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioBibliotecario servicioCrearUsuario2(RepositorioLibro repositorioLibro, RepositorioPrestamo repositorioPrestamo) {
        return new ServicioBibliotecario(repositorioLibro, repositorioPrestamo);
    }
}

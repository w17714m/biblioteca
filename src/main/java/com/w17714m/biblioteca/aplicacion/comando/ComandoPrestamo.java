package com.w17714m.biblioteca.aplicacion.comando;

import com.w17714m.biblioteca.dominio.Libro;

import java.util.Date;

public class ComandoPrestamo {
    private  Date fechaSolicitud;
    private  Libro libro;
    private Date fechaEntregaMaxima;
    private String nombreUsuario;

    public ComandoPrestamo(Libro libro) {
        this.fechaSolicitud = new Date();
        this.libro = libro;
    }

    public ComandoPrestamo(Date fechaSolicitud, Libro libro, Date fechaEntregaMaxima, String nombreUsuario) {
        this.fechaSolicitud = fechaSolicitud;
        this.libro = libro;
        this.fechaEntregaMaxima = fechaEntregaMaxima;
        this.nombreUsuario = nombreUsuario;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public Libro getLibro() {
        return libro;
    }

    public Date getFechaEntregaMaxima() {
        return fechaEntregaMaxima;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setFechaEntregaMaxima(Date fechaEntregaMaxima) {
        this.fechaEntregaMaxima = fechaEntregaMaxima;
    }
}



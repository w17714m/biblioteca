package com.w17714m.biblioteca.infraestructura;

import com.w17714m.biblioteca.aplicacion.comando.ComandoLibro;
import com.w17714m.biblioteca.dominio.excepcion.PrestamoException;
import com.w17714m.biblioteca.testdatabuilder.LibroTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ControladorPrestamoTest {
    public static final String ESTE_PRODUCTO_NO_CUENTA_CON_GARANTIA = "Este producto no cuenta con garantía extendida";
    public static final String ISBN_LIBRO_PD5121 = "PD5121";
    public static final String ISBN_LIBRO_121PDP121 = "121PDP121";
    public static final String ISBN_LIBRO_MAYOR30 = "PD99HP99";
    public static final String NOMBRE_CLIENTE_PEDRO = "PEDRO";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void generarPrestamoLibro() throws Exception {
        ComandoLibro comandoLibro = new LibroTestDataBuilder().buildComando();
        mvc.perform(MockMvcRequestBuilders
                .post("/prestamos/{isbn}/{nombreCliente}", ISBN_LIBRO_PD5121, NOMBRE_CLIENTE_PEDRO)
                .content(objectMapper.writeValueAsString(comandoLibro))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void generarPrestamoPalindromo() throws Exception {
        ComandoLibro comandoLibro = new LibroTestDataBuilder().buildComando();
        mvc.perform(MockMvcRequestBuilders
                .post("/prestamos/{isbn}/{nombreCliente}", ISBN_LIBRO_121PDP121, NOMBRE_CLIENTE_PEDRO)
                .content(objectMapper.writeValueAsString(comandoLibro))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof PrestamoException));

    }

   @Test
    public void sumaIsbnMayorA30Prestamo() throws Exception {
        ComandoLibro comandoLibro = new LibroTestDataBuilder().buildComando();
        mvc.perform(MockMvcRequestBuilders
                .post("/prestamos/{isbn}/{nombreCliente}", ISBN_LIBRO_MAYOR30, NOMBRE_CLIENTE_PEDRO)
                .content(objectMapper.writeValueAsString(comandoLibro))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}

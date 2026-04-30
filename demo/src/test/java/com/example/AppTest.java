package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void libroRecienCreadoTieneTituloCorrector() {
        Libro libro = new Libro("El Quijote");
        assertEquals("El Quijote", libro.getTitulo());
    }

    @Test
    void libroRecienCreadoNoEstaPrestado() {
        Libro libro = new Libro("El Quijote");
        assertFalse(libro.isPrestado());
    }

    @Test
    void prestarLibroCambiaSuEstado() {
        Libro libro = new Libro("El Quijote");
        libro.prestar();
        assertTrue(libro.isPrestado());
    }

    @Test
    void prestarLibroYaPrestadoLanzaExcepcion() {
        Libro libro = new Libro("El Quijote");
        libro.prestar();
        assertThrows(IllegalStateException.class, () -> libro.prestar());
    }

    @Test
    void devolverLibroCambiaSuEstado() {
        Libro libro = new Libro("El Quijote");
        libro.prestar();
        libro.devolver();
        assertFalse(libro.isPrestado());
    }

    @Test
    void devolverLibroNoPrestadoLanzaExcepcion() {
        Libro libro = new Libro("El Quijote");
        assertThrows(IllegalStateException.class, () -> libro.devolver());
    }

    @Test
    void añadirUnLibroABiblioteca() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.añadirLibro(new Libro("El Quijote"));
        assertEquals(1, biblioteca.getNumeroLibros());
    }

    @Test
    void añadirVariosLibrosABiblioteca() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.añadirLibro(new Libro("El Quijote"));
        biblioteca.añadirLibro(new Libro("1984"));
        biblioteca.añadirLibro(new Libro("Dune"));
        assertEquals(3, biblioteca.getNumeroLibros());
    }
}
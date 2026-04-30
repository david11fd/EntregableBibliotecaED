package com.example;

public class Libro {

    private String titulo;
    private boolean prestado;

    public Libro(String titulo) {
        this.titulo = titulo;
        this.prestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void prestar() {
        if (prestado) {
            throw new IllegalStateException("El libro ya está prestado");
        }
        prestado = true;
    }

    public void devolver() {
        if (!prestado) {
            throw new IllegalStateException("El libro no está prestado");
        }
        prestado = false;
    }
}
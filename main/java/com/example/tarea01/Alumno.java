package com.example.tarea01;

public class Alumno {

    public String Nombre;
    public String Telefono;
    public String Escoladridad;
    public String Genero;
    public String Libro;
    public Boolean Deporte;

    public Alumno() { }

    public Alumno(String nombre, String telefono, String escoladridad, String genero, String libro, Boolean deporte)
    {

        this.Nombre = nombre;
        this.Telefono = telefono;
        this.Escoladridad = escoladridad;
        this.Genero = genero;
        this.Libro = libro;
        this.Deporte = deporte;

    }

    public String getNombre() {
        return Nombre;
    }

    public String getTelefono() {
        return Telefono;
    }


    public String getEscoladridad() {
        return Escoladridad;
    }


    public String getGenero() {
        return Genero;
    }

    public String getLibro() {
        return Libro;
    }

    public Boolean getDeporte() {
        return Deporte;
    }
}

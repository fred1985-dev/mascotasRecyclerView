package com.servicsofts.miscontactos;

public class Mascota {
    private String nombre;
    private String apellido;
    private String email;
    private int  foto;


    public Mascota(int foto, String nombre, String email) {
        this.nombre = nombre;
        this.email = email;

        this.foto= foto;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

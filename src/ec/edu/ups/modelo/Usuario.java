/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Objects;

/**
 *
 * @author GAMER PC
 */
public class Usuario {

    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;

    public Usuario(String cedula, String nombre, String apellido, String correo, String contrasena) {
        this.setCedula(cedula);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setCorreo(correo);
        this.setContrasena(contrasena);
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = validarEspacios(cedula, 10);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = validarEspacios(nombre, 25);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = validarEspacios(apellido, 25);
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = validarEspacios(correo, 50);
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = validarEspacios(contrasena, 8);
    }

    public String validarEspacios(String cadena, int lon){
        if(cadena.length() == lon){
            return cadena;
        } else {
            if(cadena.length() < lon){
                return llenarEspacios(cadena, lon);
            }
            else {
                return cortarEspacios(cadena, lon);
            }
        }
    }
    
    public String llenarEspacios(String cadena, int lon){
        return String.format("%-" + lon + "s", cadena);
    }
    
    public String cortarEspacios(String cadena, int lon){
        return cadena.substring(0, lon);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.cedula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", contrasena=" + contrasena + '}';
    }
}

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
    private String correoElectronico;
    private String contrasenia;

   
    public Usuario(String cedula, String nombre, String apellido, String correoElectronico, String contrasenia) {
        //pasa por procesos de validación correspondientes 
        this.setCedula(cedula);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setCorreoElectronico(correoElectronico);
        this.setContrasenia(contrasenia);
        
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        
        this.cedula = validarEspacios(cedula,10);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = validarEspacios(nombre,25);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido =validarEspacios(apellido,25);
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = validarEspacios(correoElectronico,50);
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = validarEspacios(contrasenia,8);
    }

   

    public String validarEspacios(String cadena, int lon) {
        if (cadena.length() == lon) {
            return cadena;
        } else {
            if (cadena.length() < lon) {
                return llenarEspacios(cadena, lon);
            } else {
                return cortarEspacios(cadena, lon);
            }
        }
    }
    
    
    public String llenarEspacios(String cadena, int lon) {
        return String.format("%-" + lon + "s", cadena);
    }

    public String cortarEspacios(String cadena, int lon) {
        return cadena.substring(0, lon);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.cedula);
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
        return "Usuario{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correoElectronico=" + correoElectronico + ", contrasenia=" + contrasenia + '}';
    }

}

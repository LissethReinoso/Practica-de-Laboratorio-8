/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GAMER PC
 */
public class Telefono {
    
    private int codigo;
    private String numero;
    private String tipo;
    private String operadora;
    private Usuario u;
    

    public Telefono(int codigo, String numero, String tipo, String operadora) {
        this.setCodigo(codigo);
        this.setNumero(numero);
        this.setTipo(tipo);
        this.setOperadora(operadora);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = validarEspacios(numero, 25);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = validarEspacios(tipo, 25);
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = validarEspacios(operadora, 25);
    }

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
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
        int hash = 3;
        hash = 23 * hash + this.codigo;
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
        final Telefono other = (Telefono) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  "Telefono{" + "codigo=" + codigo + ", numero=" + numero + ", tipo=" + tipo + ", operadora=" + operadora + '}' + u.getNombre();
    }
}

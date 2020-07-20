/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.modelo.Telefono;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GAMER PC
 */

     /**
 *
 * private int codigo;  | 4 bytes
 * private String numero;| 20 bytes +2 extras
 * private String tipo;| 25 bytes +2extras
 * private String operadora; | 25 bytes +2 extras 
 * private Usuario usuario; |cedula ID  10 bytes +2 extras
 * total:97 bytes por registro
 */
    
public class TelefonoDAO implements ITelefonoDAO{
    
      private List<Telefono> listaTelefonos;
     private RandomAccessFile archivo;
     private int tamañor;
     private int codigo;
     private int salto;
    public TelefonoDAO() {
        
         try {
             codigo=0;
             tamañor=97;
            archivo = new RandomAccessFile("datos/telefono.dat", "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
     
     
    public TelefonoDAO(List<Telefono> listaTelefonos) {
        this.listaTelefonos = listaTelefonos;
    }
    
    
    @Override
    public void create(Telefono telefono) {
     try{
         archivo.seek(archivo.length());
            archivo.writeInt(telefono.getCodigo());
            archivo.writeUTF(telefono.getNumero());
            archivo.writeUTF(telefono.getOperadora());
            archivo.writeUTF(telefono.getTipo());
        } catch (IOException ex) {
            System.out.println("Error (create Telefono)");
        }
        
    }

    @Override
    public Telefono read(int codigo) {
      for(Telefono telefono: listaTelefonos){
            if(telefono.getCodigo()==codigo){
                return telefono;
            }
        }
        return null;
    }

    @Override
    public void update(Telefono telefono) {
     int salto = 0;
        int codigo = telefono.getCodigo();
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoArchivo = archivo.readInt();
                if (codigo == codigoArchivo) {
                    archivo.writeUTF(telefono.getNumero());
                    archivo.writeUTF(telefono.getOperadora());
                    archivo.writeUTF(telefono.getTipo());
                    break;
                }
                salto += tamañor;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura o escritura(update:Telefono)");
        }
    
       
    }

    @Override
    public void delete(int codigo,Telefono telefono) {
      salto=0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoArchivo = archivo.readInt();
                if (codigo == codigoArchivo) {
                    archivo.seek(salto);
                    archivo.writeInt(0);
                    archivo.writeUTF(llenarEspacios(20));
                    archivo.writeUTF(llenarEspacios(25));
                    archivo.writeUTF(llenarEspacios(25));
                    archivo.writeUTF(llenarEspacios(10));
                    break;
                }
                salto += tamañor;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura o escritura(delete: Telefono)");
        }

    }

    @Override
    public List<Telefono> findAll() {
        return listaTelefonos;
    }
    
    
    
    public String llenarEspacios(int espacios) {
        String formato = "";
        return String.format("%-" + espacios + "s", formato);
    }
   
    
    
    public int  obtenerUltimoCodigo(){
        
         try {
             if(archivo.length()>tamañor){
                 archivo.seek(archivo.length()-tamañor);
                 archivo.readInt();
             }
         } catch (IOException ex) {
             System.out.println("Error de lectura y escritura(obtenerUltimoCodigo:TelefonoDAO)");
         }
         return codigo;
    }
  
   
}

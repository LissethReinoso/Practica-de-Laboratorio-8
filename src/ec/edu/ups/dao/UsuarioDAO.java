/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.modelo.Usuario;
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
 * Estructura del archivo
 * 
 * cedula |10 caracteres| (validar cedula)
 * nombre |25 caracteres| (llenar con espacio; cortar a 25 caracteres) 
 * apellido |25 caracteres| (llenar con espacio; cortar a 25 caracteres)
 * correo |50 caracteres| (llenar conespacio; cortar a 50 caracteres)
 * contraseña |8 caracteres|(validar contraseña) 
 * 118 bytes mas 10 bytes por usuario String=128 bytes
 */

public class UsuarioDAO implements IUsuarioDAO {

    private List<Usuario> listaUsuarios;

   private RandomAccessFile archivo;
   private Usuario usuario;
   private int registro;
    //constructor
    public UsuarioDAO() {
        registro=128;
        try {
            archivo = new RandomAccessFile("datos/usuario.dat", "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    

    @Override
    public void create(Usuario usuario) {
       try {
            archivo.seek(archivo.length());
            archivo.writeUTF(usuario.getCedula());
            archivo.writeUTF(usuario.getNombre());
            archivo.writeUTF(usuario.getApellido());
            archivo.writeUTF(usuario.getCorreoElectronico());
            archivo.writeUTF(usuario.getContrasenia());
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura(create:UsuarioDAO)");
            ex.printStackTrace();
        }
    }

    
    @Override
    public Usuario read(String cedula) {

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCedula().equals(cedula)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public void update(Usuario usuario) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario u = listaUsuarios.get(i);
            if (u.getCedula().equals(usuario.getCedula())) {
                listaUsuarios.set(i, usuario);
                break;
            }
        }

    }

    @Override
    public void delete(Usuario usuario) {
        Iterator<Usuario> it = listaUsuarios.iterator();
        while (it.hasNext()) {
            Usuario u = it.next();
            if (u.getCedula().equals(usuario.getCedula())) {
                it.remove();
                break;
            }
        }
    }

    @Override
    public List<Usuario> findAll() {
        return listaUsuarios;
    }

    @Override
    public Usuario iniciarSesion(String correo, String contrasenia) {
         try {
            int salto = 66;
            int registro = 128;
            byte correoArray[] = new byte[50];
            byte contraseñaArray[] = new byte[8];
            while (salto < archivo.length()) {
                archivo.seek(66);
                String correoArchivo = archivo.readUTF();
                String contraseñaArchivo = archivo.readUTF();
                if (correo.equals(correoArchivo.trim()) && contrasenia.equals(contraseñaArchivo.trim())) {
                    archivo.seek(salto - 66);
                    usuario = new Usuario(archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim(), correoArchivo.trim(), contraseñaArchivo.trim());
                    return usuario;
                }
            }
            salto += registro;
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura(iniciarSesion:UsuarioDAO)");
            ex.printStackTrace();
        }

        return null;
    }

}

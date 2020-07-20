/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.modelo.Usuario;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

/**
 *
 * @author GAMER PC
 */
public class UsuarioDAO implements IUsuarioDAO {

    /**
     *
     * private String cedula 10 bytes
     * private String nombre 25 bytes 
     * private String apellido 25 bytes
     * private String correo 50 bytes
     * private String contraseña 8 bytes
     *
     * 128 bytes (10 extras)
     *
     */
    private RandomAccessFile archivo;
    
    private int tamanioRegistro;

    public UsuarioDAO() {
        try {
            archivo = new RandomAccessFile("C:\\Users\\GAMER PC\\Desktop\\Nueva carpeta/usuario.dat", "rw");
            tamanioRegistro = 128;
        } catch (IOException ex) {
            System.out.println("error de lectura y escritura");
            ex.printStackTrace();
        }
    }

    @Override
    public void create(Usuario usuario) {
        try {
            archivo.seek(archivo.length());
            archivo.writeUTF(usuario.getCedula());
            archivo.writeUTF(usuario.getNombre());
            archivo.writeUTF(usuario.getApellido());
            archivo.writeUTF(usuario.getCorreo());
            archivo.writeUTF(usuario.getContrasena());
        } catch (IOException ex) {
            System.out.println("error de lectura y escritura");
            ex.printStackTrace();
        }
    }

    @Override
    public Usuario read(String cedula) {

        return null;
    }

    @Override
    public void update(Usuario usuario) {

    }

    @Override
    public void delete(Usuario usuario) {

    }

    @Override
    public List<Usuario> findAll() {
        return null;
    }

    @Override
    public Usuario iniciarSesion(String correo, String contrasenia) {
        try {
            int salto = 66;
            int registro = 128;
            byte[] correoArreglo = new byte[50];
            byte[] contrasenaArreglo = new byte[8];
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String correoArchivo = archivo.readUTF();
                String contrasenaArchivo = archivo.readUTF();
                if (correo.equals(correoArchivo.trim()) && contrasenia.equals(contrasenaArchivo.trim())) {
                    archivo.seek(salto - 66);
                    return new Usuario(archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim());
                }

                salto += tamanioRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura");
            ex.printStackTrace();
        }
        return null;
    }

}

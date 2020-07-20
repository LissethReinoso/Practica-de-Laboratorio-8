/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.*;
import ec.edu.ups.modelo.*;
import java.util.List;

/**
 *
 * @author GAMER PC
 */
public class ControladorUsuario {

    private Usuario usuario;
    private Telefono telefono;
    private IUsuarioDAO usuarioDAO;
    private ITelefonoDAO telefonoDAO;
    
    public ControladorUsuario(IUsuarioDAO usuarioDAO,ITelefonoDAO telefonoDAO) {
        this.usuarioDAO = usuarioDAO;
        this.telefonoDAO=telefonoDAO;
    }

   
    public void crearUsuario(String cedula, String nombre, String apellido, String correo, String contrasenia){
        
        usuario=new Usuario(cedula,nombre,apellido,correo,contrasenia);
        usuarioDAO.create(usuario);
    }
    
  
    public Usuario verUsuario(String cedula) {
        usuario = usuarioDAO.read(cedula);
        return usuario;
    }

    public void actualizar(Usuario usuario) {
        
        usuarioDAO.update(usuario);
    }

    public void eliminar(Usuario usuario) {
        usuarioDAO.delete(usuario);
    }

    public boolean iniciarSecion(String correo, String contrasenia) {

        usuario = usuarioDAO.iniciarSesion(correo, contrasenia);

        if (usuario == null) {
            return false;
        } else {
            return true;
        }
    }

    public Usuario usuario(String correo, String contrasenia) {
        usuario = usuarioDAO.iniciarSesion(correo, contrasenia);
        return usuario;
    }

    public List<Usuario> verUsuarios() {
        List<Usuario> usuarios;
        usuarios = usuarioDAO.findAll();
        return usuarios;
    }
}

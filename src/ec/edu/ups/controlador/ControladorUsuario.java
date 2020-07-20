/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.ITelefonoDAO;
import ec.edu.ups.dao.IUsuarioDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import java.util.List;

/**
 *
 * @author GAMER PC
 */
public class ControladorUsuario {

    private Usuario usuario;

    private IUsuarioDAO usuarioDAO;
    
    private ITelefonoDAO telefonoDAO;
    
    Telefono telefono;

    public ControladorUsuario(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public void registrar(String cedula, String nombre, String apellido, String corrreo, String contrasena) {
        usuario = new Usuario(cedula, nombre, apellido, corrreo, contrasena);
        usuarioDAO.create(usuario);
    }

    public void verUsuario() {
        
    }

    public void actualizar() {
        
    }

    public void eliminar() {
        
    }

    public Usuario iniciarSesion(String correo, String contrasenia) {
        return usuarioDAO.iniciarSesion(correo, contrasenia); 
    }

    public Usuario usuario(String correo, String contrasenia) {
        //usuario = usuarioDAO.iniciarSesion(correo, contrasenia);
        return usuario;
    }

    public List<Usuario> verUsuarios() {
        List<Usuario> usuarios;
        usuarios = usuarioDAO.findAll();
        return usuarios;
    }
    
    public List<Telefono> listarTelefonos(){
        return null;
    }
    
    public void agregarTelefono(int codigo, String numero, String tipo, String operadora){
        telefono = new Telefono(codigo, numero, tipo, operadora);
        telefono.setU(usuario);
        telefonoDAO.create(telefono);
    }
    
    public boolean validarUsuario(String correo, String contrasena){
        usuario = usuarioDAO.iniciarSesion(correo, contrasena);
        if(usuario != null){
            return true;
        } else {
            return false;
        }
    }
}

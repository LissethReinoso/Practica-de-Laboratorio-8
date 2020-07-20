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
public class ControladorTelefono {

    private ITelefonoDAO telefonoDAO;
    
    IUsuarioDAO usuarioDAO;

    private Telefono telefono;
    
   

    public ControladorTelefono(ITelefonoDAO telefonoDAO) {
        this.telefonoDAO = telefonoDAO;
    }
    
    public void registrar(Telefono telefono) {
        telefonoDAO.create(telefono);
    }

    public Telefono verTelefono(int codigo) {
        telefono = telefonoDAO.read(codigo);
        return telefono;
    }

    public void actualizar(int codigo,String numero,String tipo,String operadora) {
        telefono = new Telefono(codigo, numero, tipo, operadora);
     
        telefonoDAO.update(telefono);
    }

    public void eliminar(int codigo,Telefono telefono) {
        
        telefonoDAO.delete(codigo,telefono);
        
    }

    public List<Telefono> verTelefonos() {
        List<Telefono> telefonos;
        telefonos = telefonoDAO.findAll();
        return telefonos;
    }
    
    /*public void agregarUsuario(String cedula){
        usuario = usuarioDAO.read(cedula);
        telefono.agregarUsuario(usuario);
        telefonoDAO.update(telefono);
    }*/
}

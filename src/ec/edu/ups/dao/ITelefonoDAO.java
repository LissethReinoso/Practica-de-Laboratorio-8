/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.modelo.Telefono;
import java.util.List;

/**
 *
 * @author GAMER PC
 */
public interface ITelefonoDAO {
    
    public void create(Telefono telefono);
    public Telefono read(int codigo);
    public void update(Telefono telefono);
    public void delete(int codigo, Telefono telefono);
    
    public List<Telefono> findAll();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.modelo.Telefono;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GAMER PC
 */
public class TelefonoDAO implements ITelefonoDAO {

    private int codigo;
    private int tamanioRegistro;
    
    private String cedula;

    private RandomAccessFile archivo;

    /**
     * private int codigo 4 bytes private String numero 25 bytes + 2 extras
     * private String tipo 25 byte + 2 extras private string operadora 25 bytes
     * + 2 extras private Usuario usuario (cedula) 10 bytes
     *
     * total 97 bytes + 3 extras
     */
    public TelefonoDAO() {
        try {
            codigo = 0;
            tamanioRegistro = 100;
            archivo = new RandomAccessFile("C:\\Users\\GAMER PC\\Desktop\\Nueva carpeta/telefono.dat", "rw");
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura");
            ex.printStackTrace();
        }
    }

    @Override
    public void create(Telefono telefono) {
        try {
            archivo.seek(archivo.length());
            archivo.writeInt(telefono.getCodigo());
            archivo.writeUTF(telefono.getNumero());
            archivo.writeUTF(telefono.getTipo());
            archivo.writeUTF(telefono.getOperadora());
            archivo.writeUTF(telefono.getU().getCedula());
            cedula = telefono.getU().getCedula();
            archivo.writeUTF("\n");
        } catch (IOException ex) {
            System.out.println("error de lectura y escritura");
            ex.printStackTrace();
        }
    }

    @Override
    public Telefono read(int codigo) {

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
                    archivo.writeInt(telefono.getCodigo());
                    archivo.writeUTF(telefono.getNumero());
                    archivo.writeUTF(telefono.getTipo());
                    archivo.writeUTF(telefono.getOperadora());
                    archivo.writeUTF(cedula);
                    archivo.writeUTF("\n");
                    break;
                }
                salto += tamanioRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura");
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int codigo, Telefono telefono) {
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoArchivo = archivo.readInt();
                if (codigo == codigoArchivo) {
                    archivo.writeInt(0);
                    archivo.writeUTF(llenarEspacios(25));
                    archivo.writeUTF(llenarEspacios(25));
                    archivo.writeUTF(llenarEspacios(25));
                    archivo.writeUTF(llenarEspacios(10));
                    archivo.writeUTF("\n");
                    break;
                }
                salto += tamanioRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura");
            ex.printStackTrace();
        }
    }

    @Override
    public List<Telefono> findAll() {
        return null;
    }

    public int obtenerUltimoCodigo() {
        try {
            if (archivo.length() > tamanioRegistro) {
                archivo.seek(archivo.length() - tamanioRegistro);
                codigo = archivo.readInt();
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura");
            ex.printStackTrace();
        }
        return codigo;
    }
    
    public String llenarEspacios(int espacios){
        String formato = "";
        return String.format("%-" + espacios + "s", formato);
    }
}

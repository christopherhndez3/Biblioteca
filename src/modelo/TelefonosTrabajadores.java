/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author MegaJoc
 */
public class TelefonosTrabajadores {
    private int id_telefonotrab;
    private int id_trabajador;
    private int telefono;

    public TelefonosTrabajadores() {
    }

    public TelefonosTrabajadores(int id_telefonotrab, int id_trabajador, int telefono) {
        this.id_telefonotrab = id_telefonotrab;
        this.id_trabajador = id_trabajador;
        this.telefono = telefono;
    }
    
    public int getId_telefonotrab() {
        return id_telefonotrab;
    }

    public void setId_telefonotrab(int id_telefonotrab) {
        this.id_telefonotrab = id_telefonotrab;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}

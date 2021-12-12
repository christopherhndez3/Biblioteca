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
public class DireccionesTrabajadores {
    private int id_direc;
    private int id_trabajador;
    private String direccion;

    public DireccionesTrabajadores() {
    }

    public DireccionesTrabajadores(int id_direc, int id_trabajador, String direccion) {
        this.id_direc = id_direc;
        this.id_trabajador = id_trabajador;
        this.direccion = direccion;
    }
 
    public int getId_direc() {
        return id_direc;
    }

    public void setId_direc(int id_direc) {
        this.id_direc = id_direc;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

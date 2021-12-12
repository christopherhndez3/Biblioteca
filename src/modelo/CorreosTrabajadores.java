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
public class CorreosTrabajadores {
    public CorreosTrabajadores() {
    }

    public CorreosTrabajadores(int id_correotrab, int id_trabajador) {
        this.id_correotrab = id_correotrab;
        this.id_trabajador = id_trabajador;
    }
    
    private int id_correotrab;
    private int id_trabajador;
    private String correo;

    public int getId_correotrab() {
        return id_correotrab;
    }

    public void setId_correotrab(int id_correotrab) {
        this.id_correotrab = id_correotrab;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

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
public class CorreosClientes {

    public CorreosClientes() {
    }

    public CorreosClientes(int id_correocliente, int id_cliente) {
        this.id_correocliente = id_correocliente;
        this.id_cliente = id_cliente;
    }
    
    private int id_correocliente;
    private int id_cliente;
    private String correo;

    public int getId_correocliente() {
        return id_correocliente;
    }

    public void setId_correocliente(int id_correocliente) {
        this.id_correocliente = id_correocliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

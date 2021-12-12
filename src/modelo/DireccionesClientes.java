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
public class DireccionesClientes {
    private int id_direccioncliente;
    private int id_cliente;
    private String direcciones;

    public DireccionesClientes() {
    }

    public DireccionesClientes(int id_direccioncliente, int id_cliente, String direcciones) {
        this.id_direccioncliente = id_direccioncliente;
        this.id_cliente = id_cliente;
        this.direcciones = direcciones;
    }
 
    public int getId_direccioncliente() {
        return id_direccioncliente;
    }

    public void setId_direccioncliente(int id_direccioncliente) {
        this.id_direccioncliente = id_direccioncliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(String direcciones) {
        this.direcciones = direcciones;
    }
}

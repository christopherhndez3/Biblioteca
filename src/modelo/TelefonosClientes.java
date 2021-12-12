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
public class TelefonosClientes {
    private int id_telefonocliente;
    private int id_cliente;
    private int telefono;

    public TelefonosClientes() {
    }

    public TelefonosClientes(int id_telefonocliente, int id_cliente, int telefono) {
        this.id_telefonocliente = id_telefonocliente;
        this.id_cliente = id_cliente;
        this.telefono = telefono;
    }
    
    public int getId_telefonocliente() {
        return id_telefonocliente;
    }

    public void setId_telefonocliente(int id_telefonocliente) {
        this.id_telefonocliente = id_telefonocliente;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}

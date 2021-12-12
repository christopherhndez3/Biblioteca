/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.MySQLManager;

/**
 *
 * @author Gn3p
 */
public class Compra {

    private int id_compra;
    private int id_libro;
    private int id_factura;
    private int id_distribuidor;

    public Compra() {
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getId_distribuidor() {
        return id_distribuidor;
    }

    public void setId_distribuidor(int id_distribuidor) {
        this.id_distribuidor = id_distribuidor;
    }

    public void agregarCompra(int id_libro, int id_dist, int id_fact) {

        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `compras`(`id_libro`, `id_dist`, `id_fact`) VALUES ("+id_libro+","+id_dist+","+id_fact+")");

    }

    
}

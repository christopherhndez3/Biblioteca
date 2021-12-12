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
public class Venta {
    private int id_venta;
    private int libros_vendidos;
    private int id_cliente;
    private int id_trabajador;
    private int id_boleta;

    public Venta() {
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getLibros_vendidos() {
        return libros_vendidos;
    }

    public void setLibros_vendidos(int libros_vendidos) {
        this.libros_vendidos = libros_vendidos;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public int getId_boleta() {
        return id_boleta;
    }

    public void setId_boleta(int id_boleta) {
        this.id_boleta = id_boleta;
    }
     public void agregarVenta( int libros_vendidos,int id_cliente,int id_trabajador, int id_boleta) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `ventas`(`libros_vendidos`, `id_cliente`, `id_trabajador`, `id_boleta`) VALUES("+libros_vendidos+","+id_cliente+","+id_trabajador+","+id_boleta+")");

    }
    
    
}

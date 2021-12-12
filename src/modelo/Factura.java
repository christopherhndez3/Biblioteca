/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.MySQLManager;

/**
 *
 * @author MegaJoc
 */
public class Factura {
    private int id_factura;
    private int folio;
    private double precio_neto;
    private double precio_iva;
    private double costo_iva;
    private String fecha_compra;

    private int id_dist;
    private int metodo_pago;

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public double getPrecio_neto() {
        return precio_neto;
    }

    public void setPrecio_neto(double precio_neto) {
        this.precio_neto = precio_neto;
    }

    public double getPrecio_iva() {
        return precio_iva;
    }

    public void setPrecio_iva(double precio_iva) {
        this.precio_iva = precio_iva;
    }

    public double getCosto_iva() {
        return costo_iva;
    }

    public void setCosto_iva(double costo_iva) {
        this.costo_iva = costo_iva;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }



    public int getId_dist() {
        return id_dist;
    }

    public void setId_dist(int id_dist) {
        this.id_dist = id_dist;
    }

    public int getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(int metodo_pago) {
        this.metodo_pago = metodo_pago;
    }
    //-----------------METODOS DE FACTURA-----------------------
    
    public void agregarFactura( int folio, double precio_neto,double precio_iva, double costo_iva,String fecha_compra,int id_dist, int metodo_pago) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `factura`(`folio`, `precio_neto`, `precio_iva`, `costo_iva`, `fecha_compra`, `id_dist`, `metodo_pago`) VALUES ("+folio+","+precio_neto+","+precio_iva+","+costo_iva+",'"+fecha_compra+"',"+id_dist+","+ metodo_pago+")");

    }
}

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
public class Boleta {
    private int id_boleta;
    private String folio;
    private double precio_neto;
    private double precio_iva;
    private double costo_iva;
    private String fecha;
    private int id_cliente;
    private int id_trabajador;
    private int metodo_pago;

    public Boleta() {
    }

    public int getId_boleta() {
        return id_boleta;
    }

    public void setId_boleta(int id_boleta) {
        this.id_boleta = id_boleta;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public int getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(int metodo_pago) {
        this.metodo_pago = metodo_pago;
    }
    //Agregar boleta
    
     public void agregarBoleta( String folio, double precio_neto,double precio_iva, double costo_iva,String fecha,int id_cliente,int id_trabajador, int metodo_pago) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `boleta`(`folio`, `precio_neto`, `precio_iva`, `costo_iva`, `fecha_venta`, `id_cliente`, `id_trabajador`, `metodo_pago`) VALUES ('"+folio+"',"+precio_neto+","+precio_iva+","+costo_iva+",'"+fecha+"',"+id_cliente+","+id_trabajador+","+ metodo_pago+")");

    }
    
    
    
}

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
public class Cliente {
    
    
    
    
    
    private int id_cliente;
    private String rut;
    private String nombre;
    private String apellido_pat;
    private String apellido_mat;
    private String direcciones;
    private int telefonos;
    private String correos;
    private int fecha_nac;

    public Cliente(int id_cliente, String rut, String nombre, String apellido_pat, String apellido_mat, String direcciones, int telefonos, String correos, int fecha_nac) {
        this.id_cliente = id_cliente;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido_pat = apellido_pat;
        this.apellido_mat = apellido_mat;
        this.direcciones = direcciones;
        this.telefonos = telefonos;
        this.correos = correos;
        this.fecha_nac = fecha_nac;
    }

    public Cliente() {
    }

    public Cliente(String rut, String nombre, String apellido_pat, String apellido_mat, int fecha_nac) {
    }

    public Cliente(int id_cliente, String rut, String nombre, String apellido_pat, String apellido_mat, int fecha_nac) {
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_pat() {
        return apellido_pat;
    }

    public void setApellido_pat(String apellido_pat) {
        this.apellido_pat = apellido_pat;
    }

    public String getApellido_mat() {
        return apellido_mat;
    }

    public void setApellido_mat(String apellido_mat) {
        this.apellido_mat = apellido_mat;
    }

    public String getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(String direcciones) {
        this.direcciones = direcciones;
    }

    public int getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(int telefonos) {
        this.telefonos = telefonos;
    }

    public String getCorreos() {
        return correos;
    }

    public void setCorreos(String correos) {
        this.correos = correos;
    }

    public int getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(int fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    
    //---------------METODOS CLIENTE......................
    
    public void agregarCliente(String rut, String nombre, String apellido_pat, String apellido_mat, int fecha_nac) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `clientes`( `rut`, `nombre`, `apellido_pat`, `apellido_mat`, `fecha_nac`) VALUES ('" + rut + "', '" + nombre + "','" + apellido_pat + "','" + apellido_mat + "', " + fecha_nac + ")");

    }

    public void actualizarCliente(int id_cliente,String rut, String nombre, String apellido_pat, String apellido_mat, int fecha_nac) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("UPDATE `clientes` SET `id_cliente`="+id_cliente+",`rut`='"+rut+"', `nombre`='"+nombre+"',`apellido_pat`='"+apellido_pat+"',`apellido_mat`='"+apellido_mat+"', `fecha_nac`="+fecha_nac+" WHERE`id_cliente`="+id_cliente+"");
    }

    public void borrarCliente(int id_cliente) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("DELETE FROM `clientes` WHERE `id_cliente`= "+id_cliente+"");
    }
    
    public void agregarDireccionCliente(int id_cliente, String direccion){
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `direcciones_clientes`(`id_cliente`, `direccion`) VALUES ("+id_cliente+", '"+direccion+"')");
    }
    
    public void editarDireccionCliente(int id_cliente, String direccion){
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("UPDATE `direcciones_clientes` SET `id_cliente`="+id_cliente+",`direccion`= '"+direccion+"' WHERE `id_cliente` = "+id_cliente+"");
    }
    
    public void agregarTelefonoCliente(int id_cliente, int telefono){
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `telefonos_clientes`(`id_cliente`, `telefono`) VALUES ("+id_cliente+", "+telefono+")");
    }
    
    public void editarTelefonoCliente(int id_cliente, int telefono){
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("UPDATE `telefonos_clientes` SET `id_cliente`="+id_cliente+",`telefono`= "+telefono+" WHERE `id_cliente` = "+id_cliente+"");
    }
    
    public void agregarCorreoCliente(int id_cliente, String correo){
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `correos_clientes`(`id_cliente`, `correo`) VALUES ("+id_cliente+", '"+correo+"')");
    }
    
    public void editarCorreoCliente(int id_cliente, String correo){
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("UPDATE `correos_clientes` SET `id_cliente`="+id_cliente+",`correo`= '"+correo+"' WHERE `id_cliente` = "+id_cliente+"");
    }
}
    
    
       
    
    
    


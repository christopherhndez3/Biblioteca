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
public class Trabajador {
    private int id_trabajador;
    private String rut;
    private String nombre;
    private String apellido_pat;
    private String apellido_mat;
    private String direcciones;
    private int telefonos;
    private String correos;
    private int fecha_cont;

    public Trabajador(int id_trabajador, String rut, String nombre, String apellido_pat, String apellido_mat, String direcciones, int telefonos, String correos, int fecha_cont) {
        this.id_trabajador = id_trabajador;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido_pat = apellido_pat;
        this.apellido_mat = apellido_mat;
        this.direcciones = direcciones;
        this.telefonos = telefonos;
        this.correos = correos;
        this.fecha_cont = fecha_cont;
    }

    public Trabajador() {
    }

    public Trabajador(String rut, String nombre, String apellido_pat, String apellido_mat, int fecha_cont) {
    }

    public Trabajador(int id_trabajador, String rut, String nombre, String apellido_pat, String apellido_mat, int fecha_cont) {
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
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

    public int getFecha_cont() {
        return fecha_cont;
    }

    public void setFecha_cont(int fecha_cont) {
        this.fecha_cont = fecha_cont;
    }
    
    //---------------METODOS TRABAJADOR......................
    
    public void agregarTrabajador(String rut, String nombre, String apellido_pat, String apellido_mat, int fecha_cont) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `trabajadores`( `rut`, `nombre`, `apellido_pat`, `apellido_mat`, `fecha_cont`) VALUES ('" + rut + "', '" + nombre + "','" + apellido_pat + "','" + apellido_mat + "', " + fecha_cont + ")");

    }

    public void actualizarTrabajador(int id_trabajador,String rut, String nombre, String apellido_pat, String apellido_mat, int fecha_cont) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("UPDATE `trabajadores` SET `id_trabajador`="+id_trabajador+",`rut`='"+rut+"', `nombre`='"+nombre+"',`apellido_pat`='"+apellido_pat+"',`apellido_mat`='"+apellido_mat+"', `fecha_cont`="+fecha_cont+" WHERE`id_trabajador`="+id_trabajador+"");
    }

    public void borrarTrabajador(int id_trabajador) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("DELETE FROM `trabajadores` WHERE `id_trabajador`= "+id_trabajador+"");
    }
    
    public void agregarDireccionTrabajador(int id_trabajador, String direccion){
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `direcciones_trabajadores`(`id_trabajador`, `direccion`) VALUES ("+id_trabajador+", '"+direccion+"')");
    }
    
    public void editarDireccionTrabajador(int id_trabajador, String direccion){
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("UPDATE `direcciones_trabajadores` SET `id_trabajador`="+id_trabajador+",`direccion`= '"+direccion+"' WHERE `id_trabajador` = "+id_trabajador+"");
    }
    
    public void agregarTelefonoTrabajador(int id_trabajador, int telefono){
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `telefonos_trabajadores`(`id_trabajador`, `telefono`) VALUES ("+id_trabajador+", "+telefono+")");
    }
    
    public void editarTelefonoTrabajador(int id_trabajador, int telefono){
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("UPDATE `telefonos_trabajadores` SET `id_trabajador`="+id_trabajador+",`telefono`= "+telefono+" WHERE `id_trabajador` = "+id_trabajador+"");
    }
    
    public void agregarCorreoTrabajador(int id_trabajador, String correo){
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `correos_trabajadores`(`id_trabajador`, `correo`) VALUES ("+id_trabajador+", '"+correo+"')");
    }
    
    public void editarCorreoTrabajador(int id_trabajador, String correo){
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("UPDATE `correos_trabajadores` SET `id_trabajador`="+id_trabajador+",`correo`= '"+correo+"' WHERE `id_trabajador` = "+id_trabajador+"");
    }
}

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
public class Autor {
    
    private int id_autor;
    private String nombre;
    private String ap_pat;
    private String ap_mat;
   final private  String nombretabla = "autor";

    public Autor() {
    }

    public Autor(String nombre, String ap_pat, String ap_mat) {
        this.nombre = nombre;
        this.ap_pat = ap_pat;
        this.ap_mat = ap_mat;
        
    }

    public Autor(int id_autor, String nombre, String ap_pat, String ap_mat) {
        this.id_autor = id_autor;
        this.nombre = nombre;
        this.ap_pat = ap_pat;
        this.ap_mat = ap_mat;
    }
    
    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
       public String getAp_pat() {
        return ap_pat;
    }

    public void setAp_pat(String ap_pat) {
        this.ap_pat = ap_pat;
    }

    public String getAp_mat() {
        return ap_mat;
    }

    public void setAp_mat(String ap_mat) {
        this.ap_mat = ap_mat;
    }

    @Override
    public String toString() {
        return "Autor{" + "id_autor=" + id_autor + ", nombre=" + nombre + ", ap_pat=" + ap_pat + ", ap_mat=" + ap_mat + '}';
    }


    
    
    //------------------------------ 1.4 Autor Libros---------------------------------------------------------
    public void agregarAutor(String nombre, String apellido_pat, String apellido_mat) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `autor`( `nombre`, `apellido_pat`, `apellido_mat`) VALUES ('" + nombre + "','" + apellido_pat + "','" + apellido_mat + "')");

    }

    public void actualizarAutor(int id_autor,String nombre, String apellido_pat, String apellido_mat) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("UPDATE `autor` SET `id_autor`="+id_autor+",`nombre`='"+nombre+"',`apellido_pat`='"+apellido_pat+"',`apellido_mat`='"+apellido_mat+"' WHERE`id_autor`="+id_autor+"");
    }

    public void borrarAutor(int id_autor,String nombre, String apellido_pat, String apellido_mat) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("DELETE FROM `autor` WHERE `id_autor`= "+id_autor+"");
        
    }

    public void verAutor() {
    }
   
    
    
    
}

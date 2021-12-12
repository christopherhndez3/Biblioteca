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
public class Distribuidor {
    private int id_dist;
    private String rut;
    private String nom_empresa;
    private String direccion;
    private int telefono;
    private int anho_apertura;

    public Distribuidor(int id_dist, String rut, String nom_empresa, String direccion, int telefono, int anho_apertura) {
        this.id_dist = id_dist;
        this.rut = rut;
        this.nom_empresa = nom_empresa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.anho_apertura = anho_apertura;
    }

    public Distribuidor() {
    }

    public Distribuidor(String rut, String nombre, String direccion, int telefono, int anho_apertura) {

    }


    public int getId_dist() {
        return id_dist;
    }

    public void setId_dist(int id_dist) {
        this.id_dist = id_dist;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNom_empresa() {
        return nom_empresa;
    }

    public void setNom_empresa(String nom_empresa) {
        this.nom_empresa = nom_empresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getAnho_apertura() {
        return anho_apertura;
    }

    public void setAnho_apertura(int anho_apertura) {
        this.anho_apertura = anho_apertura;
    }

    @Override
    public String toString() {
        return "Distribuidor{" + "id_dist=" + id_dist + ", rut=" + rut + ", nom_empresa=" + nom_empresa + ", direccion=" + direccion + ",telefono=" + telefono + ", anho_apertura=" + anho_apertura +'}';
    }
//------------------------------------ Metodos de distribuidor -----------------------------------------------

public void agregarDistribuidor(String rut, String nom_empresa, String direccion, int telefono, int anho_apertura) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `distribuidores`( `rut`, `nom_empresa`, `direccion`, `telefono`, `anho_apertura`) VALUES ('" + rut + "','" + nom_empresa + "','" + direccion + "', '" + telefono + "', '" + anho_apertura + "')");

    }

    public void actualizarDistribuidor(int id_dist, String rut, String nom_empresa, String direccion, int telefono, int anho_apertura) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("UPDATE `distribuidores` SET `id_dist`="+id_dist+",`rut`='"+rut+"',`nom_empresa`='"+nom_empresa+"',`direccion`='"+direccion+"',`telefono`='"+telefono+"',`anho_apertura`='"+anho_apertura+"' WHERE`id_dist`="+id_dist+"");
    }

    public void borrarDistribuidor(int id_dist) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("DELETE FROM `distribuidores` WHERE `id_dist`= "+id_dist+"");
        
    }

    public void verDistribuidor() {
    }
}
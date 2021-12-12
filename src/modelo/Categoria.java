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
public class Categoria {
    private int id_cat;
    private String nom_cat;

    public Categoria(int id_cat, String nom_cat) {
        this.id_cat = id_cat;
        this.nom_cat = nom_cat;       
    }

    public Categoria() {
    }

    public Categoria(String nom_cat) {
    }
    

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public String getNom_cat() {
        return nom_cat;
    }

    public void setNom_cat(String nom_cat) {
        this.nom_cat = nom_cat;
    }
    
    @Override
    public String toString(){
        return "Categoria{" + "id_cat=" + id_cat + ", nom_cat=" + nom_cat +'}';
    }
    //------------------------------------ Metodos de distribuidor -----------------------------------------------
    
    public void agregarCategoria(String nom_cat) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `categorias`( `nom_cat`) VALUES ('" + nom_cat+ "')");

    }

    public void actualizarCategoria(int id_cat, String nom_cat) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("UPDATE `categorias` SET `id_cat`="+id_cat+",`nom_cat`='"+nom_cat+"'");
    }

    public void borrarCategoria(int id_cat) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("DELETE FROM `categorias` WHERE `id_cat`= "+id_cat+"");
        
    }

    public void verCategoría() {
    }
}

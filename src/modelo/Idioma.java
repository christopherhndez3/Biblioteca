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
public class Idioma {
    private int id_idioma;
    private String nom_idioma;

    public Idioma(int id_idioma, String nom_idioma) {
        this.id_idioma = id_idioma;
        this.nom_idioma = nom_idioma;       
    }

    public Idioma() {
    }

    public Idioma(String nom_idioma) {
    }
    

    public int getId_idioma() {
        return id_idioma;
    }

    public void setId_idioma(int id_idioma) {
        this.id_idioma = id_idioma;
    }

    public String getNom_idioma() {
        return nom_idioma;
    }

    public void setNom_idioma(String nom_idioma) {
        this.nom_idioma = nom_idioma;
    }
    
    @Override
    public String toString(){
        return "Idioma{" + "id_idioma=" + id_idioma + ", nom_idioma=" + nom_idioma +'}';
    }
    //------------------------------------ Metodos de distribuidor -----------------------------------------------
    
    public void agregarIdioma(String nom_idioma) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `idiomas`( `nom_idioma`) VALUES ('" + nom_idioma+ "')");

    }

    public void actualizarIdioma(int id_idioma, String nom_idioma) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("UPDATE `idiomas` SET `id_idioma`="+id_idioma+",`nom_idioma`='"+nom_idioma+"'");
    }

    public void borrarIdioma(int id_idioma) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("DELETE FROM `idiomas` WHERE `id_idioma`= "+id_idioma+"");
        
    }

    public void verIdioma() {
    }
}
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
public class Editorial {
 
    
    private int id_editorial;
    private String nom_editorial;

    public int getId_editorial() {
        return id_editorial;
    }

    public void setId_editorial(int id_editorial) {
        this.id_editorial = id_editorial;
    }

    public String getNom_editorial() {
        return nom_editorial;
    }

    public void setNom_editorial(String nom_editorial) {
        this.nom_editorial = nom_editorial;
    }

    public Editorial() {
    }

    public Editorial(int id_editorial, String nom_editorial) {
        this.id_editorial = id_editorial;
        this.nom_editorial = nom_editorial;
    }

    public Editorial(String nom_editorial) {
        this.nom_editorial = nom_editorial;
    }
    

    @Override
    public String toString() {
        return "Editorial{" + "id_editorial=" + id_editorial + ", nom_editorial=" + nom_editorial + '}';
    }
    

   

    


    
    
    //------------------------------ 1.4 Editorial Libros---------------------------------------------------------
    public void agregarEditorial(String nom_editorial ) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `editorial`(`nom_editorial`) VALUES ('"+nom_editorial+"')");

    }

    public void actualizarEditorial(int id_editorial,String nom_editorial) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("UPDATE `editorial` SET `id_editorial`="+id_editorial+",`nom_editorial`='"+nom_editorial+"' WHERE "+id_editorial+"");
    }

    public void borrarEditorial(int id_editorial) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("DELETE FROM `editorial` WHERE `id_editorial`="+id_editorial+"");
        
    }

    public void verAutor() {
    }
   
    
    
    
}
    


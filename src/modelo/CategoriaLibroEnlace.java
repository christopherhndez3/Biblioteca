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
public class CategoriaLibroEnlace {
    private int id_catenlace;
    private int id_cat;
    private int id_libro;

    public CategoriaLibroEnlace() {
    }

    public CategoriaLibroEnlace(int id_catenlace, int id_cat, int id_libro) {
        this.id_catenlace = id_catenlace;
        this.id_cat = id_cat;
        this.id_libro = id_libro;
    }

    public int getId_catenlace() {
        return id_catenlace;
    }

    public void setId_catenlace(int id_catenlace) {
        this.id_catenlace = id_catenlace;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    @Override
    public String toString() {
        return "EnlaceCategoriaLibro{" + "id_catenlace=" + id_catenlace + ", id_cat=" + id_cat + ", id_libro=" + id_libro + '}';
    }
    
    public void agregaRelacion(int id_libro,int id_cat) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `categorias_enlace`( `id_cat`, `id_libro`) VALUES ("+id_cat+","+id_libro+")");

    }
     
    
}

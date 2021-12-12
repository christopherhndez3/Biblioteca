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
public class IdiomaLibroEnlace {
    
    private int id_idiomaenlace;
    private int id_idioma; 
    private int id_libro;

    public IdiomaLibroEnlace() {
    }

    public IdiomaLibroEnlace(int id_idiomaenlace, int id_idioma, int id_libro) {
        this.id_idiomaenlace = id_idiomaenlace;
        this.id_idioma = id_idioma;
        this.id_libro = id_libro;
    }

    public int getId_idiomaenlace() {
        return id_idiomaenlace;
    }

    public void setId_idiomaenlace(int id_idiomaenlace) {
        this.id_idiomaenlace = id_idiomaenlace;
    }

    public int getId_idioma() {
        return id_idioma;
    }

    public void setId_idioma(int id_idioma) {
        this.id_idioma = id_idioma;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }
    
    public void agregaRelacion(int id_libro,int id_idioma) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `idioma_enlace`(`id_idioma`, `id_libro`) VALUES ("+id_idioma+","+id_libro+")");

    }
    
    
    
}

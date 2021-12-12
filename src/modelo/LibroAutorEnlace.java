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
public class LibroAutorEnlace {
    private int id_enlace;
    private int id_libro;
    private int id_autor;

    public LibroAutorEnlace() {
    }

    public LibroAutorEnlace(int id_enlace, int id_libro, int id_autor) {
        this.id_enlace = id_enlace;
        this.id_libro = id_libro;
        this.id_autor = id_autor;
    }

    public int getId_enlace() {
        return id_enlace;
    }

    public void setId_enlace(int id_enlace) {
        this.id_enlace = id_enlace;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }
    
    /////////////////////------------AGREGAR RELACION LIBRO AUTOR
    
    public void agregaRelacion(int id_libro,int id_autor) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `autores_enlace`( `id_autor`, `id_libro`) VALUES ("+id_autor+","+id_libro+")");

    }
    
    
}

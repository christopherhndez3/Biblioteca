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
public class Libro {

    private int id_libro;
    private int id_editorial;
    private int num_serie;
    private int num_pag;
    private String isbn;
    private String titulo;
    private int precio_ref;
    private int anho_publ;
    private int estado;
  

    public Libro() {
       
    }
    public Libro(int id_libro, int id_editorial, int num_serie, int num_pag, String isbn, String titulo, int precio_ref, int anho_publ, int estado) {
        this.id_libro = id_libro;
        this.id_editorial = id_editorial;
        this.num_serie = num_serie;
        this.num_pag = num_pag;
        this.isbn = isbn;
        this.titulo = titulo;
        this.precio_ref = precio_ref;
        this.anho_publ = anho_publ;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Libro{" + "id_libro=" + id_libro + ", id_editorial=" + id_editorial + ", num_serie=" + num_serie + ", num_pag=" + num_pag + ", isbn=" + isbn + ", titulo=" + titulo + ", precio_ref=" + precio_ref + ", anho_publ=" + anho_publ + ", estado=" + estado + '}';
    }

    

   
 
    
  

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    

    public int getId_editorial() {
        return id_editorial;
    }

    public void setId_editorial(int id_editorial) {
        this.id_editorial = id_editorial;
    }

    public int getNum_serie() {
        return num_serie;
    }

    public void setNum_serie(int num_serie) {
        this.num_serie = num_serie;
    }

    public int getNum_pag() {
        return num_pag;
    }

    public void setNum_pag(int num_pag) {
        this.num_pag = num_pag;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPrecio_ref() {
        return precio_ref;
    }

    public void setPrecio_ref(int precio_ref) {
        this.precio_ref = precio_ref;
    }

    public int getAnho_publ() {
        return anho_publ;
    }

    public void setAnho_publ(int anho_publ) {
        this.anho_publ = anho_publ;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
    //-----------------METODOS DE LIBRO-----------------------
    
    public void agregarLibro( int id_editorial, int num_serie, int num_pag, String isbn, String titulo, int precio_ref, int anho_publ, int estado) {
        MySQLManager manager = new MySQLManager("localhost", "3306", "bibliotecafastdevelopment", "root", "");
        manager.executeUpdate("INSERT INTO `libro`(`id_editorial`, `num_serie`, `isbn`, `titulo`, `num_pag`, `precio_ref`, `anho_publi`, `estado`) VALUES ("+id_editorial+","+num_serie+",'"+isbn+"','"+titulo+"',"+num_pag+","+precio_ref+","+anho_publ+","+estado+")");

    }
    
    
    public void compraLibro(){};
    
    public void ventaLibro(){};
    
    
}

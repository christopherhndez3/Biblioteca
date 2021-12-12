/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Autor;
import modelo.Boleta;
import modelo.Categoria;
import modelo.CategoriaLibroEnlace;
import modelo.Cliente;
import modelo.CorreosClientes;
import modelo.CorreosTrabajadores;
import modelo.DireccionesClientes;
import modelo.DireccionesTrabajadores;
import modelo.Distribuidor;
import modelo.Editorial;
import modelo.Factura;
import modelo.Idioma;
import modelo.IdiomaLibroEnlace;
import modelo.Libro;
import modelo.LibroAutorEnlace;
import modelo.TelefonosClientes;
import modelo.TelefonosTrabajadores;
import modelo.Trabajador;
import modelo.Venta;

public class MySQLManager {

    private String host;
    private String port;
    private String database;
    private String user;
    private String password;

    public MySQLManager(String host, String port, String database, String user, String password) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
    }

    private Connection createConnection() {
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user,
                    password);
            return connection;
        } catch (SQLException e) {
            System.out.println("Could not connect to MySQL server! because: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
        }
        return null;
    }

    public void executeUpdate(String update) {
        Connection connection = createConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(update);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
    }

    public ResultSet executeQuery(String query) {
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;
        try {
            statement = connection.createStatement();
            set = statement.executeQuery(query);
            return set;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public Libro executeQueryConsultaLibro(String query) {
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;
        Libro libro = new Libro();
        try {
            statement = connection.createStatement();
            set = statement.executeQuery(query);
            while (set.next()) {
                libro.setId_libro(set.getInt("id_libro"));
                libro.setId_editorial(set.getInt("id_editorial"));
                libro.setNum_serie(set.getInt("num_serie"));
                libro.setIsbn(set.getString("isbn"));
                libro.setTitulo(set.getString("titulo"));
                libro.setNum_pag(set.getInt("num_pag"));
                libro.setPrecio_ref(set.getInt("precio_ref"));
                libro.setAnho_publ(set.getInt("anho_publi"));
                libro.setEstado(set.getInt("estado"));

            }

            return libro;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
      public ArrayList<Libro> executeQueryConsultaLLenaTablaLibro(ArrayList<Libro> listaLibro) {
        System.out.println("Consultando Libros");
        String query = "SELECT * FROM `libro`";
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;

        try {
            System.out.println("Entrando al try");
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            System.out.println("Entrando al while");
            while (set.next()) {
                System.out.println("Aca hay un libro");
                Libro libro = new Libro();
                libro.setId_libro(set.getInt("id_libro"));
                libro.setId_editorial(set.getInt("id_editorial"));
                libro.setNum_serie(set.getInt("num_serie"));
                libro.setIsbn(set.getString("isbn"));
                libro.setTitulo(set.getString("titulo"));
                libro.setNum_pag(set.getInt("num_pag"));
                libro.setPrecio_ref(set.getInt("precio_ref"));
                libro.setAnho_publ(set.getInt("anho_publi"));
                libro.setEstado(set.getInt("estado"));
;

                System.out.println(libro.toString());

                listaLibro.add(libro);
            }

            return listaLibro;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
    
    
    

    public Autor executeQueryConsultaAutor(String query) {
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;
        Autor a = new Autor();
        try {
            statement = connection.createStatement();
            set = statement.executeQuery(query);
            while (set.next()) {
                a.setId_autor(set.getInt("id_autor"));
                a.setNombre(set.getString("nombre"));
                a.setAp_pat(set.getString("apellido_pat"));
                a.setAp_mat(set.getString("apellido_mat"));

            }

            return a;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public ArrayList<Autor> executeQueryConsultaLLenaTablaAutores(ArrayList<Autor> listaAutor) {
        System.out.println("ESTOY ENTRANDO Al METODO");
        String query = "SELECT * FROM `autor`";
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;

        try {
            System.out.println("Entrando al try");
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            System.out.println("Entrando al while");
            while (set.next()) {
                Autor a = new Autor();
                a.setId_autor(set.getInt("id_autor"));
                a.setNombre(set.getString("nombre"));
                a.setAp_pat(set.getString("apellido_pat"));
                a.setAp_mat(set.getString("apellido_mat"));

                System.out.println(a.toString());

                listaAutor.add(a);
            }

            return listaAutor;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public Distribuidor executeQueryConsultaDistribuidor(String query) {
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;
        Distribuidor d = new Distribuidor();
        try {
            statement = connection.createStatement();
            set = statement.executeQuery(query);
            while (set.next()) {
                d.setId_dist(set.getInt("id_dist"));
                d.setRut(set.getString("rut"));
                d.setNom_empresa(set.getString("nom_empresa"));
                d.setDireccion(set.getString("direccion"));
                d.setTelefono(set.getInt("telefono"));
                d.setAnho_apertura(set.getInt("anho_apertura"));

            }

            return d;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public ArrayList<Distribuidor> executeQueryConsultaLLenaTablaDistribuidores(ArrayList<Distribuidor> listaDistribuidor) {
        System.out.println("ESTOY ENTRANDO Al METODO");
        String query = "SELECT * FROM `distribuidores`";
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;

        try {
            System.out.println("Entrando al try");
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            System.out.println("Entrando al while");
            while (set.next()) {
                Distribuidor d = new Distribuidor();
                d.setId_dist(set.getInt("id_dist"));
                d.setRut(set.getString("rut"));
                d.setNom_empresa(set.getString("nom_empresa"));
                d.setDireccion(set.getString("direccion"));
                d.setTelefono(set.getInt("telefono"));
                d.setAnho_apertura(set.getInt("anho_apertura"));

                System.out.println(d.toString());

                listaDistribuidor.add(d);
            }

            return listaDistribuidor;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public Editorial executeQueryConsultaEditorial(String query) {
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;
        Editorial d = new Editorial();
        try {
            statement = connection.createStatement();
            set = statement.executeQuery(query);
            while (set.next()) {

                d.setId_editorial(set.getInt("id_editorial"));
                d.setNom_editorial(set.getString("nom_editorial"));
            }

            return d;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public ArrayList<Editorial> executeQueryConsultaLLenaTablaEditoriales(ArrayList<Editorial> listaEditoriales) {
        System.out.println("ESTOY ENTRANDO Al METODO");
        String query = "SELECT * FROM `editorial`";
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;

        try {
            System.out.println("Entrando al try");
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            System.out.println("Entrando al while");
            while (set.next()) {
                Editorial d = new Editorial();
                d.setId_editorial(set.getInt("id_editorial"));
                d.setNom_editorial(set.getString("nom_editorial"));

                System.out.println(d.toString());

                listaEditoriales.add(d);
            }

            return listaEditoriales;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;

    }
    //Consultar idiomas:
    
    public Idioma executeQueryConsultaIdioma(String query) {
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;
        Idioma i = new Idioma();
        try {
            statement = connection.createStatement();
            set = statement.executeQuery(query);
            while (set.next()) {
                i.setId_idioma(set.getInt("id_idioma"));
                i.setNom_idioma(set.getString("nom_idioma"));

            }
            
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
    
    public ArrayList<Idioma> executeQueryConsultaLLenaTablaIdioma(ArrayList<Idioma> listaIdiomas) {
        System.out.println("ESTOY ENTRANDO Al METODO");
        String query = "SELECT * FROM `idiomas`";
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;

        try {
            System.out.println("Entrando al try");
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            System.out.println("Entrando al while");
            while (set.next()) {
                Idioma i = new Idioma();
                i.setId_idioma(set.getInt("id_idioma"));
                i.setNom_idioma(set.getString("nom_idioma"));

                System.out.println(i.toString());

                listaIdiomas.add(i);
            }

            return listaIdiomas;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
    //Consultar categorias:
    
    public Categoria executeQueryConsultaCategoria(String query) {
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;
        Categoria c = new Categoria();
        try {
            statement = connection.createStatement();
            set = statement.executeQuery(query);
            while (set.next()) {
                c.setId_cat(set.getInt("id_cat"));
                c.setNom_cat(set.getString("nom_cat"));

            }
            
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
    
    public ArrayList<Categoria> executeQueryConsultaLLenaTablaCategoria(ArrayList<Categoria> listaCategorias) {
        System.out.println("ESTOY ENTRANDO Al METODO");
        String query = "SELECT * FROM `categorias`";
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;

        try {
            System.out.println("Entrando al try");
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            System.out.println("Entrando al while");
            while (set.next()) {
                Categoria c = new Categoria();
                c.setId_cat(set.getInt("id_cat"));
                c.setNom_cat(set.getString("nom_cat"));

                System.out.println(c.toString());

                listaCategorias.add(c);
            }

            return listaCategorias;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
       public ArrayList<DireccionesClientes> executeQueryConsultaLLenaTablaDireccionesClientes(ArrayList<DireccionesClientes> listaDireccionesClientes) {
        System.out.println("ESTOY ENTRANDO Al METODO");
        String query = "SELECT * FROM `direcciones_clientes`";
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;

        try {
            System.out.println("Entrando al try");
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            System.out.println("Entrando al while");
            while (set.next()) {
                DireccionesClientes dcl = new DireccionesClientes();
                dcl.setId_direccioncliente(set.getInt("id_direccioncliente"));
                dcl.setId_cliente(set.getInt("id_cliente"));
                dcl.setDirecciones(set.getString("direccion"));

                System.out.println(dcl.toString());

                listaDireccionesClientes.add(dcl);
            }

            return listaDireccionesClientes;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
    
    //Consulta telefonos clientes:
    
     public ArrayList<TelefonosClientes> executeQueryConsultaLLenaTablaTelefonosClientes(ArrayList<TelefonosClientes> listaTelefonosClientes) {
        System.out.println("ESTOY ENTRANDO Al METODO");
        String query = "SELECT * FROM `telefonos_clientes`";
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;

        try {
            System.out.println("Entrando al try");
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            System.out.println("Entrando al while");
            while (set.next()) {
                TelefonosClientes tcl = new TelefonosClientes();
                tcl.setId_telefonocliente(set.getInt("id_telefonocliente"));
                tcl.setId_cliente(set.getInt("id_cliente"));
                tcl.setTelefono(set.getInt("telefono"));

                System.out.println(tcl.toString());

                listaTelefonosClientes.add(tcl);
            }

            return listaTelefonosClientes;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
     
     //Consultar correos clientes:
     
    public ArrayList<CorreosClientes> executeQueryConsultaLLenaTablaCorreosClientes(ArrayList<CorreosClientes> listaCorreosClientes) {
        System.out.println("ESTOY ENTRANDO Al METODO");
        String query = "SELECT * FROM `correos_clientes`";
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;

        try {
            System.out.println("Entrando al try");
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            System.out.println("Entrando al while");
            while (set.next()) {
                CorreosClientes ccl = new CorreosClientes();
                ccl.setId_correocliente(set.getInt("id_correocliente"));
                ccl.setId_cliente(set.getInt("id_cliente"));
                ccl.setCorreo(set.getString("correo"));

                System.out.println(ccl.toString());

                listaCorreosClientes.add(ccl);
            }

            return listaCorreosClientes;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
    
    //Consultar trabajadores:
    
    public Trabajador executeQueryConsultaTrabajadores(String query) {
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;
        Trabajador tr = new Trabajador();
        try {
            statement = connection.createStatement();
            set = statement.executeQuery(query);
            while (set.next()) {
                tr.setId_trabajador(set.getInt("id_trabajador"));
                tr.setRut(set.getString("rut"));
                tr.setNombre(set.getString("nombre"));
                tr.setApellido_pat(set.getString("apellido_pat"));
                tr.setApellido_mat(set.getString("apellido_mat"));
                tr.setFecha_cont(set.getInt("fecha_cont"));

            }

            return tr;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    public ArrayList<Trabajador> executeQueryConsultaLLenaTablaTrabajadores(ArrayList<Trabajador> listaTrabajador) {
        System.out.println("ESTOY ENTRANDO Al METODO");
        String query = "SELECT * FROM `trabajadores`";
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;

        try {
            System.out.println("Entrando al try");
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            System.out.println("Entrando al while");
            while (set.next()) {
                Trabajador tr = new Trabajador();
                tr.setId_trabajador(set.getInt("id_trabajador"));
                tr.setRut(set.getString("rut"));
                tr.setNombre(set.getString("nombre"));
                tr.setApellido_pat(set.getString("apellido_pat"));
                tr.setApellido_mat(set.getString("apellido_mat"));
                tr.setFecha_cont(set.getInt("fecha_cont"));

                System.out.println(tr.toString());

                listaTrabajador.add(tr);
            }

            return listaTrabajador;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }

    //Consulta direcciones de trabajadores:
    
    public ArrayList<DireccionesTrabajadores> executeQueryConsultaLLenaTablaDireccionesTrabajadores(ArrayList<DireccionesTrabajadores> listaDireccionesTrabajadores) {
        System.out.println("ESTOY ENTRANDO Al METODO");
        String query = "SELECT * FROM `direcciones_trabajadores`";
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;

        try {
            System.out.println("Entrando al try");
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            System.out.println("Entrando al while");
            while (set.next()) {
                DireccionesTrabajadores dtr = new DireccionesTrabajadores();
                dtr.setId_direc(set.getInt("id_direc"));
                dtr.setId_trabajador(set.getInt("id_trabajador"));
                dtr.setDireccion(set.getString("direccion"));

                System.out.println(dtr.toString());

                listaDireccionesTrabajadores.add(dtr);
            }

            return listaDireccionesTrabajadores;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
    
    //Consultar teléfonos de trabajadores:
    
    public ArrayList<TelefonosTrabajadores> executeQueryConsultaLLenaTablaTelefonosTrabajadores(ArrayList<TelefonosTrabajadores> listaTelefonosTrabajadores) {
        System.out.println("ESTOY ENTRANDO Al METODO");
        String query = "SELECT * FROM `telefonos_trabajadores`";
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;

        try {
            System.out.println("Entrando al try");
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            System.out.println("Entrando al while");
            while (set.next()) {
                TelefonosTrabajadores ttr = new TelefonosTrabajadores();
                ttr.setId_telefonotrab(set.getInt("id_telefonotrab"));
                ttr.setId_trabajador(set.getInt("id_trabajador"));
                ttr.setTelefono(set.getInt("telefono"));

                System.out.println(ttr.toString());

                listaTelefonosTrabajadores.add(ttr);
            }

            return listaTelefonosTrabajadores;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
    
    //Consulta correos de trabajadores:
    
    public ArrayList<CorreosTrabajadores> executeQueryConsultaLLenaTablaCorreosTrabajadores(ArrayList<CorreosTrabajadores> listaCorreosTrabajadores) {
        System.out.println("ESTOY ENTRANDO Al METODO");
        String query = "SELECT * FROM `correos_trabajadores`";
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;

        try {
            System.out.println("Entrando al try");
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            System.out.println("Entrando al while");
            while (set.next()) {
                CorreosTrabajadores ctr = new CorreosTrabajadores();
                ctr.setId_correotrab(set.getInt("id_correotrab"));
                ctr.setId_trabajador(set.getInt("id_trabajador"));
                ctr.setCorreo(set.getString("correo"));

                System.out.println(ctr.toString());

                listaCorreosTrabajadores.add(ctr);
            }

            return listaCorreosTrabajadores;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
    
    public ArrayList<Cliente> executeQueryConsultaLLenaTablaClientes(ArrayList<Cliente> listaCliente) {
        System.out.println("ESTOY ENTRANDO Al METODO");
        String query = "SELECT * FROM `clientes`";
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;

        try {
            System.out.println("Entrando al try");
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            System.out.println("Entrando al while");
            while (set.next()) {
                Cliente cl = new Cliente();
                cl.setId_cliente(set.getInt("id_cliente"));
                cl.setRut(set.getString("rut"));
                cl.setNombre(set.getString("nombre"));
                cl.setApellido_pat(set.getString("apellido_pat"));
                cl.setApellido_mat(set.getString("apellido_mat"));
                cl.setFecha_nac(set.getInt("fecha_nac"));

                System.out.println(cl.toString());

                listaCliente.add(cl);
            }

            return listaCliente;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
    public ArrayList<LibroAutorEnlace> executeQueryConsultaLLenaListaLibroAutorEnlace(ArrayList<LibroAutorEnlace> lista) {
        System.out.println("ESTOY ENTRANDO Al METODO");
        String query = "SELECT * FROM `autores_enlace`";
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;

        try {
            System.out.println("Entrando al try");
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            System.out.println("Entrando al while");
            while (set.next()) {
                LibroAutorEnlace e = new LibroAutorEnlace();
                e.setId_enlace(set.getInt("id_autorenlace"));//Id_cliente(set.getInt("id_cliente"));
                e.setId_autor(set.getInt("id_autor"));
                e.setId_libro(set.getInt("id_libro"));

                System.out.println(e.toString());

                lista.add(e);
            }

            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
    public ArrayList<CategoriaLibroEnlace> executeQueryConsultaLLenaListaCategoriaLibroEnlace(ArrayList<CategoriaLibroEnlace> lista) {
        System.out.println("ESTOY ENTRANDO Al METODO");
        String query = "SELECT * FROM  `categorias_enlace`";
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;

        try {
            System.out.println("Entrando al try");
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            System.out.println("Entrando al while");
            while (set.next()) {
                CategoriaLibroEnlace e = new CategoriaLibroEnlace();
                e.setId_catenlace(set.getInt("id_catenlace"));//Id_cliente(set.getInt("id_cliente"));
                e.setId_cat(set.getInt("id_cat"));
                e.setId_libro(set.getInt("id_libro"));

                System.out.println(e.toString());

                lista.add(e);
            }

            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
    public ArrayList<IdiomaLibroEnlace> executeQueryConsultaLLenaListaIdiomaLibroEnlace(ArrayList<IdiomaLibroEnlace> lista) {
        System.out.println("ESTOY ENTRANDO Al METODO");
        String query = "SELECT * FROM `idioma_enlace`";
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;

        try {
            System.out.println("Entrando al try");
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            System.out.println("Entrando al while");
            while (set.next()) {
                IdiomaLibroEnlace e = new IdiomaLibroEnlace();
                e.setId_idiomaenlace(set.getInt("id_idiomaenlace"));//Id_cliente(set.getInt("id_cliente"));
                e.setId_idioma(set.getInt("id_idioma"));
                e.setId_libro(set.getInt("id_libro"));

                System.out.println(e.toString());

                lista.add(e);
            }

            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
     public ArrayList<Factura> executeQueryConsultaLLenaTablaFactura(ArrayList<Factura> listaFactura) {
        System.out.println("ESTOY ENTRANDO Al METODO");
        String query = "SELECT * FROM `factura`";
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;

        try {
            System.out.println("Entrando al try");
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            System.out.println("Entrando al while");
            while (set.next()) {
                Factura factura = new Factura();
                factura.setId_factura(set.getInt("id_fact"));
                factura.setFolio(set.getInt("folio"));
                factura.setPrecio_neto(set.getDouble("precio_neto"));
                factura.setPrecio_iva(set.getDouble("precio_iva"));
                factura.setCosto_iva(set.getDouble("costo_iva"));
                factura.setFecha_compra(set.getString("fecha_compra"));
                factura.setId_dist(set.getInt("id_dist"));
                factura.setMetodo_pago(set.getInt("metodo_pago"));

                listaFactura.add(factura);
            }

            return listaFactura;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
     public ArrayList<Venta> executeQueryConsultaLLenaTablaVenta(ArrayList<Venta> listaVenta) {
        System.out.println("ESTOY ENTRANDO Al METODO");
        String query = "SELECT * FROM `ventas`";
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;

        try {
            System.out.println("Entrando al try");
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            System.out.println("Entrando al while");
            while (set.next()) {
               Venta v = new Venta(); 
               v.setId_venta(set.getInt("id_venta"));
               v.setLibros_vendidos(set.getInt("libros_vendidos"));
               v.setId_cliente(set.getInt("id_cliente"));
               v.setId_trabajador(set.getInt("id_trabajador"));
               v.setId_boleta(set.getInt("id_boleta"));
               listaVenta.add(v);
            }

            return listaVenta;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    
    
    
     }
     public ArrayList<Boleta> executeQueryConsultaTodasBoletas(ArrayList<Boleta> listaBoleta) {
        System.out.println("ESTOY ENTRANDO Al METODO");
        String query = "SELECT * FROM `boleta`";
        Connection connection = createConnection();
        Statement statement = null;
        ResultSet set = null;

        try {
            System.out.println("Entrando al try");
            statement = connection.createStatement();
            set = statement.executeQuery(query);

            System.out.println("Entrando al while");
            while (set.next()) {
               Boleta v = new Boleta(); 
               v.setId_boleta(set.getInt("id_boleta"));
               v.setFolio(set.getString("folio"));
               v.setPrecio_neto(set.getDouble("precio_neto"));
               v.setPrecio_iva(set.getDouble("precio_iva"));
               v.setFecha(set.getString("fecha_venta"));
               v.setId_cliente(set.getInt("id_cliente"));
               v.setId_trabajador(set.getInt("id_trabajador"));
               v.setMetodo_pago(set.getInt("metodo_pago"));
               listaBoleta.add(v);
            }

            return listaBoleta;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // Close in order: ResultSet, Statement, Connection.
            try {
                set.close();
            } catch (Exception e) {
            }
            try {
                statement.close();
            } catch (Exception e) {
            }
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return null;
    
    
    
     }
     
    
}



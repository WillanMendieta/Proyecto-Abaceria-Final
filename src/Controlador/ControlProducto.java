/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.*;
import Controlador.*;
import java.sql.SQLException;
import Conexion.*;

/**
 *
 * @author Macao
 */
public class ControlProducto {
    
    private ArrayList<Producto> listaProductos;
    private ResultSet resultado = null;
    private PreparedStatement psentencia = null;
    
    public ControlProducto() {
        listaProductos = new ArrayList<Producto>();
    }
    
    public void addProducto (Producto producto){
        listaProductos.add(producto);
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    public ArrayList<Producto> listarProductos (conexionDB con){
        int i =1;
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            psentencia = con.getConexion().prepareStatement("SELECT *"
                          + " FROM wmendietaaba.aba_productos");
            resultado = psentencia.executeQuery();

            //Se presenta el resultado
            while (resultado.next()) {
                Producto pro = new Producto();
               // GestionPersona gp = new GestionPersona();
               // Proveedor prove = new Proveedor();
                Categoria cat = new Categoria();
               // pro.setId(i);
              //  i++;
                pro.setId(resultado.getInt("pro_id"));
                pro.setNombre(resultado.getString("pro_nombre"));
                pro.setDescuento(resultado.getInt("pro_descuento"));
                pro.setEstado(resultado.getString("pro_estado"));
                pro.setPrecio(resultado.getDouble("pro_precio"));
                pro.setStock(resultado.getInt("pro_stock"));
                pro.setIdentificarIVA(resultado.getString("pro_identificador_iva"));
                pro.setEstado(resultado.getString("pro_estado"));
                pro.setTipo(resultado.getString("pro_tipo"));
                pro.setDescipcion(resultado.getString("pro_descripcion"));
                pro.getCategoria().setId(resultado.getInt("aba_categorias_cat_id"));
                productos.add(pro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        for (Producto producto : productos) {
            producto.setCategoria(buscarCategoria(con, producto.getCategoria().getId()));            
           // producto.setProveedor(gp.buscarProveedor(con, producto.getProveedor().getId()));
        }
    return productos;
        
    }
    
    
    
    public Producto buscarProducto (conexionDB con, int codigo){
        Producto pro = new Producto();
       // GestionPersona gp = new GestionPersona();
        try {
            psentencia = con.getConexion().prepareStatement("select * "
                    + " from aba_productos "
                    + " where pro_id = ?");

            psentencia.setInt(1, codigo);
         //   resultado = psentencia.executeQuery();
            resultado = psentencia.executeQuery();

            //Se presenta el resultado
            while (resultado.next()) {
                pro.setId(resultado.getInt("pro_id"));
                pro.setNombre(resultado.getString("pro_nombre"));
                pro.setDescuento(resultado.getInt("pro_descuento"));
                pro.setEstado(resultado.getString("pro_estado"));
                pro.setPrecio(resultado.getDouble("pro_precio"));
                pro.setStock(resultado.getInt("pro_stock"));
                pro.setIdentificarIVA(resultado.getString("pro_identificador_iva"));
                pro.setEstado(resultado.getString("pro_estado"));
                pro.setTipo(resultado.getString("pro_tipo"));
                pro.setDescipcion(resultado.getString("pro_descripcion"));
                pro.getCategoria().setId(resultado.getInt("aba_categorias_cat_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }        
           pro.setCategoria(buscarCategoria(con, pro.getCategoria().getId()));            
           // pro.setProveedor(gp.buscarProveedor(con, pro.getProveedor().getId()));
        return pro;
    }

    public Categoria buscarCategoria(conexionDB con, int codigo) {
        Categoria cate = new Categoria();
        try {
            psentencia = con.getConexion().prepareStatement("select * " 
                          + " FROM aba_categorias"
                    + " WHERE cat_id = ?" );
            psentencia.setInt(1, codigo);
            resultado = psentencia.executeQuery();

            //Se presenta el resultado
            while (resultado.next()) {
                cate.setId(codigo);
                cate.setNombre(resultado.getString("cat_nombre"));
                cate.setEstado(resultado.getString("cat_estado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cate;
        
    }
    
    
    
    
    public ArrayList<Categoria> ListaCategoria (conexionDB con){
        ArrayList<Categoria> categorias = new ArrayList<>();
        try {
            psentencia = con.getConexion().prepareStatement("SELECT * " 
                          + " FROM aba_categorias");
            resultado = psentencia.executeQuery();

            //Se presenta el resultado
            while (resultado.next()) {
                Categoria cat = new Categoria();
                cat.setId(resultado.getInt("cat_id"));
                cat.setNombre(resultado.getString("cat_nombre"));
                cat.setEstado(resultado.getString("cat_estado"));
                categorias.add(cat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorias;    
    }

    /*
    public void agregarProductoNuevo(conexionDB con, int codd, String nom, String cat, double pree, String iva) {
        try {
            psentencia= con.getConexion().prepareStatement("INSERT INTO "
                    + "aba_productos VALUES (?,?,?)");
            psentencia.setInt(1, codd);
            psentencia.setString(2, nombre);
            psentencia.setString(3, estado);
            
            ///Se debe ejecutar la sentencia de Insert
            psentencia.executeUpdate();
            
            /*
            System.out.println("1. Commit "
                    + " 2. RollBack");
            Scanner sc = new Scanner(System.in);
            int opcion= sc.nextInt();
            
            if(opcion == 1){
                con.getConexion().commit();
            }
            else{
                con.getConexion().rollback();
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
*/
    
    
    
    public Categoria buscaCategoriaNombre(conexionDB con, String nombre) {
        Categoria cate = new Categoria();
        try {
            psentencia = con.getConexion().prepareStatement("select * " 
                          + " FROM aba_categorias"
                    + " WHERE cat_nombre = ?" );
            psentencia.setString(1, nombre);
            resultado = psentencia.executeQuery();

            //Se presenta el resultado
            while (resultado.next()) {
                String cod = resultado.getString("cat_id");
                int codigo = Integer.parseInt(cod);
                cate.setId(codigo);
                cate.setNombre(resultado.getString("cat_nombre"));
                cate.setEstado(resultado.getString("cat_estado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cate;
        
    }

    public void agregarProductoNuevo(conexionDB con, int codd, String nom, int des, double pree, int stock, String iva, int nombreCat, String estado, String tipo, String descrip) {
     try {
            psentencia= con.getConexion().prepareStatement("INSERT INTO "
                    + "aba_productos VALUES (?,?,?,?,?,?,?,?,?,?)");
            psentencia.setInt(1, codd);
            psentencia.setString(2, nom);
            psentencia.setInt(3, des);
            psentencia.setDouble(4, pree);
            psentencia.setInt(5, stock);
            
            psentencia.setString(6, iva);
            psentencia.setInt(7, nombreCat);
            psentencia.setString(8, estado);
            psentencia.setString(9, tipo);
            psentencia.setString(10, descrip);
            
            ///Se debe ejecutar la sentencia de Insert
            psentencia.executeUpdate();
            
            /*
            System.out.println("1. Commit "
                    + " 2. RollBack");
            Scanner sc = new Scanner(System.in);
            int opcion= sc.nextInt();
            
            if(opcion == 1){
                con.getConexion().commit();
            }
            else{
                con.getConexion().rollback();
            }
*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarProducto(conexionDB con, int codd, String nom, int catnom, int stoo, double pree, String ivaa) {
        
         try {
            String sentenciaInsercion = "update aba_productos set "
                    + "pro_nombre =?,"
                    + "ABA_CATEGORIAS_CAT_ID=?,"
                    + "pro_stock=?,"
                    + "pro_precio=?,"
                    + "PRO_IDENTIFICADOR_IVA=?"
                    + " where pro_id=?";
            psentencia = con.getConexion().prepareStatement(sentenciaInsercion);
            psentencia.setString(1, nom);
             psentencia.setInt(2, catnom);
             psentencia.setInt(3, stoo);
             psentencia.setDouble(4, pree);
             psentencia.setString(5, ivaa);
             psentencia.setInt(6, codd);
            //Se ejecuta la sentencia de INSERT
            psentencia.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
    
    
     public Producto buscaProductoNombre(conexionDB con, String nombre) {
        Producto pro = new Producto();
        try {
            psentencia = con.getConexion().prepareStatement("select * " 
                          + " FROM aba_productos"
                    + " WHERE pro_nombre = ?" );
            psentencia.setString(1, nombre);
            resultado = psentencia.executeQuery();

            //Se presenta el resultado
            while (resultado.next()) {
                pro.setId(resultado.getInt("pro_id"));
                pro.setNombre(resultado.getString("pro_nombre"));
                pro.setDescipcion(resultado.getString("pro_descripcion"));
                System.out.println(pro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pro;
        
    }

    public void eliminarProducto(conexionDB con, String estado, int codPP, String desP) {
         try {
            String sentenciaInsercion = "update aba_productos set "
                    + "pro_descripcion =?,"
                    + "pro_estado =?"
                    + " where pro_id=?";
            psentencia = con.getConexion().prepareStatement(sentenciaInsercion);
            psentencia.setString(1, desP);
             psentencia.setString(2, estado);
             psentencia.setInt(3, codPP);
            //Se ejecuta la sentencia de INSERT
            psentencia.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void aplicarDescuento(conexionDB con, int codPP, String desP) {
        try {
            String sentenciaInsercion = "update aba_productos set "
                    + "pro_descuento =?"
                    + " where pro_id=?";
            psentencia = con.getConexion().prepareStatement(sentenciaInsercion);
            psentencia.setString(1, desP);
             psentencia.setInt(2, codPP);
            //Se ejecuta la sentencia de INSERT
            psentencia.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

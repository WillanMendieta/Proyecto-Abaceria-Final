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
                          + " FROM aba_productos");
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

    private Categoria buscarCategoria(conexionDB con, int codigo) {
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
    
    
    
}

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
    
    
    
    public Producto buscarProducto (conexionDB con, int codigo){
        Producto pro = new Producto();
       // GestionPersona gp = new GestionPersona();
        try {
            psentencia = con.getConexion().prepareStatement("SELECT *"
                     + " FROM aba_productos"
                    + " WHERE pro_id = ?");
            psentencia.setInt(1, codigo);
            resultado = psentencia.executeQuery();

            //Se presenta el resultado
            while (resultado.next()) {
                pro.setId(resultado.getInt("pro_id"));
                //pro.setCodigo(resultado.getString("prod_codigo"));
                pro.setNombre(resultado.getString("pro_nombre"));
                pro.setDescuento(resultado.getInt("pro_descuento"));
                pro.setEstado(resultado.getString("prod_estado"));
                pro.setPrecio(resultado.getDouble("pro_precio"));
                pro.setStock(resultado.getInt("pro_stock"));
                pro.setIdentificarIVA(resultado.getString("pro_identificador_iva"));
                pro.setEstado(resultado.getString("pro_estado"));
                pro.setTipo(resultado.getString("pro_tipo"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }        
           // pro.setMarca(buscarMarca(con, pro.getMarca().getId()));            
           // pro.setProveedor(gp.buscarProveedor(con, pro.getProveedor().getId()));
        return pro;  
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import modelo.*;
/**
 *
 * @author Macao
 */
public class ListadoProductos extends AbstractTableModel {
    
    public String[] columnas = {"Codigo" , "Nombre" , "Stock" , "Precio" , "Descuento" , "IVA" , "Estado" , "Descripcion" , "Categoria" };
    public Class[] columnasTipos = {Integer.class, String.class, Integer.class, String.class, Integer.class, String.class, String.class, String.class, String.class };
    private ArrayList<Producto> listaProductos = new ArrayList<>();
    
    
    public ListadoProductos(ArrayList<Producto> datos){
        super();
        listaProductos = new ArrayList<Producto>();
        for (Producto dato : datos ){
            listaProductos.add(dato);
        }
        
    }
    
    /**
     * Constructor vacio
     */
    public ListadoProductos(){
        
    }
    
    
    
    @Override
    public int getRowCount() {
        return listaProductos.size();
    }

    public int getColumnCount() {
        return columnas.length;
    }
    
    
    /**
     * devuelve el nombre de la columna
     */
    public String getColumnName(int col) {
        return columnas[col];
    }

    /**
     * devuelve el tipo de colunma
     */
    public Class getColumnClass(int col) {
        return columnasTipos[col];
    }
    
    
    // obtien al informacion del producto
    public Object getValueAt(int row, int col) {
        Producto producto = (Producto) (listaProductos.get(row));
        switch (col){
            case 0:
                return producto.getId();
            case 1:
                return producto.getNombre();
            case 2:
                return producto.getStock();
            case 3:
                return producto.getPrecio();
            case 4:
                return producto.getDescuento();
            case 5:
                return producto.getIdentificarIVA();
            case 6:
                //return  producto.getTipo();
                if(producto.getTipo().equalsIgnoreCase("N")) {
                    return "Nacional";
                }else 
                    return "Extranjero";
            case 7:
                return producto.getDescipcion();
            case 8:
                return producto.getCategoria().getNombre();
            //case 9:
              //  return "Nombre provee";
        }
        return new String();
    }
    
    //establece la informacion del producto
     public void setValueAt(Object value, int row, int col) {
        Producto producto = (Producto) (listaProductos.get(row));

        switch (col) {
            
            case 0:
                producto.setId((int) value);
                
                break;
            case 1:
                producto.setNombre((String) value);
                break;
            case 2:
                producto.setStock((int) value);
                break;
            case 3:
                producto.setPrecio((double) value);
                break;
            case 4:
                producto.setDescuento((int) value);
                break;
            case 5:
                producto.setIdentificarIVA((String) value);
                break;
            case 6:
                producto.setTipo((String) value);
            case 7:
                producto.setDescipcion((String) value);
            case 8:
                producto.getCategoria().setNombre((String) value);
        }
    }
     
     
}

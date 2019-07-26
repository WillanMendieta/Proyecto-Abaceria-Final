/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author ASUS
 */
public class RegistrarCompra {
    private int id;
    private String fechaIngreso;
    private int numeroFactura;
    private int cantidadProd;
    private int idProveedores;
    private int idProductos;
    private Producto producto;
    private Proveedor proveedor;

    public RegistrarCompra() {
        this.id = 0;
        this.numeroFactura = 0;
        this.cantidadProd = 0;
        this.idProveedores = 0;
        this.idProductos = 0;
        this.producto = producto;
        this.proveedor = proveedor;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getCantidadProd() {
        return cantidadProd;
    }

    public void setCantidadProd(int cantidadProd) {
        this.cantidadProd = cantidadProd;
    }

    public int getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(int idProveedores) {
        this.idProveedores = idProveedores;
    }

    public int getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "RegistrarCompra{" + "id=" + id + ", fechaIngreso=" + fechaIngreso + ", numeroFactura=" + numeroFactura + ", cantidadProd=" + cantidadProd + ", idProveedores=" + idProveedores + ", idProductos=" + idProductos + ", producto=" + producto + ", proveedor=" + proveedor + '}';
    }
    
    
    
    
}

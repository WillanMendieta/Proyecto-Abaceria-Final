/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Macao
 */
public class FacturaDetalle {
    
    private int id;
    private int cantidad;
    private double precioUnitario;
    private double subTotal;
    private Producto producto;
    private int idPro; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = Math.round(precioUnitario * 100) / 100d;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    
    
    public void calcularTotal(){
        subTotal= Math.round( (precioUnitario*cantidad) * 100) / 100d;
    }
    
    /*
    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
*/

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }
    
    
    /*
    @Override
    public String toString() {
        return "FacturaDetalle{" + "id=" + id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", subTotal=" + subTotal + ", producto=" + producto + '}';
    }
*/

    @Override
    public String toString() {
        return "FacturaDetalle{" + "id=" + id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", subTotal=" + subTotal + ", producto=" + producto + ", idPro=" + idPro + '}';
    }

}

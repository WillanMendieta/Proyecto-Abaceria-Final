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
public class Producto {
    
    private int id;
    private String nombre;
    private int descuento;
    private double precio;
    private int stock;
    private String identificarIVA;
    private String estado;
    private String tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getIdentificarIVA() {
        return identificarIVA;
    }

    public void setIdentificarIVA(String identificarIVA) {
        this.identificarIVA = identificarIVA;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", descuento=" + descuento + ", precio=" + precio + ", stock=" + stock + ", identificarIVA=" + identificarIVA + ", estado=" + estado + ", tipo=" + tipo + '}';
    }
    
    
}

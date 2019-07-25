/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Macao
 */
public class FacturaCabecera {
    private int id;
    private int codigo;
    private Usuario vendedor;
    private Cliente comprador;
    String estado;
    private Date fecha;
    private double iva;
    private int porcentajeDescuento;
    private int porcentajeIva;
    private double descuento;
    private double subTotal;
    private double total;
    private ArrayList<FacturaDetalle> listaFacturasDetalle;

    public FacturaCabecera() {
        listaFacturasDetalle = new ArrayList<FacturaDetalle>();
        vendedor = new Usuario();
        comprador = new Cliente();
        porcentajeDescuento = 0;
        descuento = 0;
        subTotal = 0;
        iva = 0;
    }
    
     public void addFacturaDetalle(FacturaDetalle detalle) {
        listaFacturasDetalle.add(detalle);
        System.out.println(detalle.toString());
    }

    public void calcularSubTotal() {
        listaFacturasDetalle.forEach((n) -> subTotal = subTotal + (n.getPrecioUnitario()*n.getCantidad()));
        subTotal=Math.round(subTotal * 100) / 100d;
    }

    public void calcularIva() {
        iva =  Math.round((subTotal * ((double)12 / 100)) * 100) / 100d;
    }

    public void calcularDescuento() {
        descuento = Math.round(subTotal * (porcentajeDescuento / 100) * 100) / 100d;
    }

    public void calcularTotal() {    
        total = Math.round((iva + subTotal - descuento)* 100) / 100d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setFecha(int anio, int mes, int dia) {
        this.fecha = new Date(anio - 1900, mes - 1, dia);
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<FacturaDetalle> getListaFacturasDetalle() {
        return listaFacturasDetalle;
    }

    public void setListaFacturasDetalle(ArrayList<FacturaDetalle> listaFacturasDetalle) {
        this.listaFacturasDetalle = listaFacturasDetalle;
    }

    public Usuario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Usuario vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(int porcentajeDescuento) {
        
            this.porcentajeDescuento = 0;
        
    }

    public int getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(int porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "FacturaCabeceraVenta{" + "id=" + id + ", vendedor=" + vendedor + ", comprador=" + comprador + ", fecha=" + fecha + ", iva=" + iva + ", porcentajeDescuento=" + porcentajeDescuento + ", porcentajeIva=" + porcentajeIva + ", descuento=" + descuento + ", subTotal=" + subTotal + ", total=" + total + ", listaFacturasDetalle=" + listaFacturasDetalle + '}';
    }

}

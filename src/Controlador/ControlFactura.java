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
import Conexion.*;
import Controlador.*;
import java.sql.SQLException;


/**
 *
 * @author Macao
 */
public class ControlFactura {
    
     private ArrayList<FacturaCabecera> listaFacturasCabecera;
    private ControlPersona gestionPersona;
    
    private ArrayList<FacturaDetalle> listaFacturasDetalle;
    
    
    private ResultSet resultado = null;
    private PreparedStatement psentencia = null;

    public ControlFactura() {
        gestionPersona= new ControlPersona();
        listaFacturasCabecera = new ArrayList<FacturaCabecera>();
        listaFacturasDetalle = new ArrayList<FacturaDetalle>();
    }

    public void addFactura(FacturaCabecera factura) {
        listaFacturasCabecera.add(factura);
    }

    
     public ArrayList<FacturaCabecera> getListaFacturasCabezera() {
        return listaFacturasCabecera;
    }

    public void setListaFacturasVentas(ArrayList<FacturaCabecera> listaFacturasCabecera) {
        this.listaFacturasCabecera = listaFacturasCabecera;
    }
    
    
    
     public void addFacturaDetalle(FacturaDetalle detalle) {
        listaFacturasDetalle.add(detalle);
    }

    
     public ArrayList<FacturaDetalle> getListaFacturasDetalle() {
        return listaFacturasDetalle;
    }

    public void setListaFacturasDetalles(ArrayList<FacturaDetalle> listaFacturasDetalle) {
        this.listaFacturasDetalle = listaFacturasDetalle;
    }
    
    
    public int codigoFacturaCabecera(conexionDB con){
        int codigoFac=0;
        try {
            psentencia = con.getConexion().prepareStatement("select count(cab_fac_id) "
                    + " from aba_cab_facturas "
                    );
            resultado = psentencia.executeQuery();

            //Se presenta el resultado
            while (resultado.next()) {
                codigoFac = resultado.getInt("count(cab_fac_id)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        return codigoFac;
    }

    
    
    public void InsertaFacturaCabecera(conexionDB con, String codigo, String fechaEmision, double subtotalCab, double ivaCab, double totalCab, String estadoCab, String descripcionCab, int facturador, int cliente) {
        
        try {
            psentencia= con.getConexion().prepareStatement("INSERT INTO "
                    + "aba_cab_facturas VALUES (cab_fac_id_seq.nextval,?,?,?,?,?,?,?,?,?)");
            psentencia.setString(1, codigo);
            psentencia.setString(2, fechaEmision);
            psentencia.setDouble(3, subtotalCab);
            psentencia.setDouble(4, ivaCab);
            psentencia.setDouble(5, totalCab);
            psentencia.setString(6, estadoCab);
            psentencia.setString(7, descripcionCab);
            psentencia.setInt(8, facturador);
            psentencia.setInt(9, cliente);
            ///Se debe ejecutar la sentencia de Insert
            psentencia.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public FacturaCabecera buscarCodigoFacCab(conexionDB con, String codigo) {
        FacturaCabecera fac = new FacturaCabecera();
        try {
            psentencia = con.getConexion().prepareStatement("select * "
                    + " from aba_cab_facturas "
                    + " where cab_fac_id=?"
                    );
             psentencia.setString(1, codigo);
            resultado = psentencia.executeQuery();

            //Se presenta el resultado
            while (resultado.next()) {
                fac.setId(resultado.getInt("cab_fac_id"));
                fac.setEstado(resultado.getString("cab_fac_estado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        return fac;
    }

    public void agregarDetalleFac(conexionDB con,  int cantidad, double precioUnitario, double subTotal, int idCab, int idPro) throws SQLException {
         try {
            psentencia= con.getConexion().prepareStatement("INSERT INTO "
                    + "aba_fac_detalles VALUES (det_fac_id_seq.nextval,?,?,?,?,?)");
            //psentencia.setInt(1, id);
            psentencia.setInt(1, cantidad);
            psentencia.setDouble(2, precioUnitario);
            psentencia.setDouble(3, subTotal);
            psentencia.setInt(4, idCab);
            psentencia.setInt(5, idPro);
            ///Se debe ejecutar la sentencia de Insert
            psentencia.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            con.getConexion().rollback();
             javax.swing.JOptionPane.showMessageDialog(null, "Un producto supero el Stock", "Facturacion Cancelada", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            
        }
    
    }

    public int conteoIdDetalle(conexionDB con) {
        int codigoDet=0;
        try {
            psentencia = con.getConexion().prepareStatement("select count(det_fac_id) "
                    + " from aba_fac_detalles"
                    );
            
            resultado = psentencia.executeQuery();

            //Se presenta el resultado
            while (resultado.next()) {
                codigoDet = resultado.getInt("count(det_fac_id)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }        
        return codigoDet;
    }

    public ArrayList<FacturaDetalle> buscarCantidad(conexionDB con, int id) {
        ArrayList<FacturaDetalle> aa = new ArrayList<>();
        try {
            psentencia = con.getConexion().prepareStatement("select det_fac_cantidad, ABA_PRODUCTOS_PRO_ID "
                    + " from aba_fac_detalles "
                    + " where aba_cab_facturas_cab_fac_id =?"
                    );
            psentencia.setInt(1, id);
            resultado = psentencia.executeQuery();

            //Se presenta el resultado
            while (resultado.next()) {
                FacturaDetalle fac = new FacturaDetalle();
                fac.setCantidad(resultado.getInt("det_fac_cantidad"));
                fac.setIdPro(resultado.getInt("ABA_PRODUCTOS_PRO_ID"));
                aa.add(fac);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return aa;
    }

    public int mandaConteo(conexionDB con, int id) {
        int a=0; 
        try {
            psentencia = con.getConexion().prepareStatement("select count(det_fac_cantidad) "
                    + " from aba_fac_detalles "
                    + " where aba_cab_facturas_cab_fac_id =?"
                    );
            psentencia.setInt(1, id);
            resultado = psentencia.executeQuery();

            //Se presenta el resultado
            while (resultado.next()) {
                a=resultado.getInt("count(det_fac_cantidad)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return a;
    
    }

    public void Anular(conexionDB con, int id, String estado, String detalles) {
         try {
            String sentenciaInsercion = "update aba_cab_facturas set "
                    + " cab_fac_estado=?,"
                    + " cab_fac_descripcion=?"
                    + " where cab_fac_id=?";
            psentencia = con.getConexion().prepareStatement(sentenciaInsercion);
            psentencia.setString(1, estado);
            psentencia.setString(2, detalles);
            psentencia.setInt(3, id);
            //Se ejecuta la sentencia de INSERT
            psentencia.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }

    public void AumentarStock(conexionDB con, int cantidad, int idPro) {
        try {
            String sentenciaInsercion = "update aba_productos set "
                    + " pro_stock= pro_stock+?"
                    + " where pro_id=?";
            psentencia = con.getConexion().prepareStatement(sentenciaInsercion);
            psentencia.setInt(1, cantidad);
             psentencia.setInt(2, idPro);
            //Se ejecuta la sentencia de INSERT
            psentencia.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    
    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

//import Modelo.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Macao
 */
public class SentenciasCRUD {

    private ResultSet resultado = null;
    private PreparedStatement psentencia = null;
//    private ArrayList<Proveedor> listaProveedores;
//    private ArrayList<Persona> listaPersonas;

    
    public SentenciasCRUD(){
//    listaProveedores=new ArrayList();
//    listaPersonas=new ArrayList();
}


/*    
    public ArrayList<Persona>getListadoPersonas()
    {
        return listaPersonas;
    }
    
    public ArrayList<Proveedor>getListadoProvee()
    {
        return listaProveedores;
    }
   
  */  
 
    
    
    
    /*
   public void InsertarPersona(Conexion con,Proveedor persona,int codigo){
        try{
            String sentenciaInsercion = "INSERT INTO ab_persons VALUES "
                    + "(?,?,?,?,?,?,?)";
            psentencia = con.getConexion().prepareStatement(sentenciaInsercion);
            psentencia.setInt(1,codigo);
            psentencia.setString(2,persona.getNumeroIdentificacion());
            psentencia.setString(3,persona.getNombre());
            psentencia.setString(4,persona.getApellido());
            psentencia.setString(5,persona.getDireccion());
            psentencia.setString(6,persona.getTelefono());
            psentencia.setString(7,persona.getEstado());
            //Se ejecuta la sentencia de INSERT
            psentencia.executeUpdate();
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    
        try{
            String sentenciaInsercion = "INSERT INTO ab_provs VALUES "
                    + "(?,?,?,?,?)";
            psentencia = con.getConexion().prepareStatement(sentenciaInsercion);
            psentencia.setInt(1,persona.getId());
            psentencia.setString(2,persona.getNombreEmpresa());
            psentencia.setString(3,persona.getLineaDeProducto());
            psentencia.setString(4,persona.getRucEmpresa());
            psentencia.setInt(5,codigo);
            
            
            //Se ejecuta la sentencia de INSERT
            psentencia.executeUpdate();
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        
   } 
    
    
    */
    
 

/*  
     public ArrayList<Proveedor>listaPersona(Conexion con){
        
        try{
        String sentenciaInsercion=("SELECT pro_id,pro_nombre_empresa" 
                + "pro_linea_prod"
                + "pro_ruc_empresa"
                + "per_id"
                + "order by 1 asc");
            psentencia = con.getConexion().prepareStatement(sentenciaInsercion);
            resultado = psentencia.executeQuery();
            
            //Se presenta el resultado
            while (resultado.next()){
                System.out.println("pro_id: "+resultado.getString("pro_id"));
                System.out.println("pro_nombre: "+resultado.getString("prod_nombre_empresa"));
                System.out.println("prod_linea_prod: "+resultado.getString("prod_linea_prod"));
                System.out.println("prod_ruc_empresa: "+resultado.getString("prod_ruc_empresa"));
                System.out.println("per_id: "+resultado.getString("per_id"));
                System.out.println(listaProveedores.size());
           
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listaProveedores;
    }
    
     */
   
     
    
     /*
    public void InsertarPais(Conexion con, String countryID, String countryName, int regionID) {
        try {
            String sentenciaInsercion = "INSERT INTO Countries VALUES "
                    + "(?,?,?)";
            psentencia = con.getConexion().prepareStatement(sentenciaInsercion);
            psentencia.setString(1, countryID);
            psentencia.setString(2, countryName);
            psentencia.setInt(3, regionID);

            //Se ejecuta la sentencia de INSERT
            psentencia.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    */

    /**
     * Metodo para eliminar un pais acorde a su identificador
     *
     * @param con Conexion a la base de datos
     * @param countryID Identificador del pais
     */
    
  
    /*
    public void EliminarPais(Conexion con, String countryID) {
        try {
            String sentenciaEliminacion = "DELETE FROM Countries WHERE "
                    + "country_id = ? ";
            psentencia = con.getConexion().prepareStatement(sentenciaEliminacion);
            psentencia.setString(1, countryID);

            //Se ejecuta la sentencia de INSERT
            psentencia.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/
    
    
    public ResultSet getResultado() {
        return resultado;
    }

    public void setResultado(ResultSet resultado) {
        this.resultado = resultado;
    }

    public PreparedStatement getPsentencia() {
        return psentencia;
    }

    public void setPsentencia(PreparedStatement psentencia) {
        this.psentencia = psentencia;
    }

}

   
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.*;


/**
 *
 * @author Macao
 */
public class ControlPersona {
    
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Proveedor> listaProveedores;
    private ArrayList<Persona>listaPersonas;
    private ResultSet resultado = null;
    private PreparedStatement psentencia = null;
    
    
     public ControlPersona() {
        listaClientes = new ArrayList<Cliente>();
        listaProveedores = new ArrayList<Proveedor>();
        listaUsuarios = new ArrayList<Usuario>();
        listaPersonas=new ArrayList<Persona>();
        
    }
     
     
    
    
     public Usuario buscarEmpleado(conexionDB con, String usuario, String pass ){
         Usuario user = new Usuario();
         Persona per = new Persona();
        try {
            
            System.out.println("usuario llega metodo :" + usuario + " " + pass);
            
            /*
            psentencia = con.getConexion().prepareStatement("Select  per_id, per_cedula, per_nombre, per_apellido, "
                    + "per_direccion, per_usuario, per_password, per_cargo,   "
                    + "per_tel_convencional, per_tel_celular"
                    + "from aba_personas"
                    + "where per_usuario = ?"
                    + "and per_password = ?");
*/            

            psentencia=con.getConexion().prepareStatement("SELECT *"+ 
                "FROM aba_personas " +
               "WHERE per_usuario=?" +
               "and per_password =? "
            );
            psentencia.setString(1, usuario);
            psentencia.setString(2, pass);
            resultado = psentencia.executeQuery();
            //Se presenta el resultado
            while (resultado.next()) {
                
                System.out.println("id : " + resultado.getInt("per_id"));
                System.out.println("cargo es : " + resultado.getString("per_cargo") );
                System.out.println("usuario es: " + resultado.getString("per_usuario") );
                System.out.println("password es : " + resultado.getString("per_password") );
                System.out.println("nombre: " + resultado.getString("per_nombre") );
                System.out.println("apellido: " + resultado.getString("per_apellido") );
                
                
                user = new Usuario();
                user.setId(resultado.getInt("per_id"));
                user.setCedula(resultado.getString("per_cedula"));
                user.setNombre(resultado.getString("per_nombre"));
                user.setApellido(resultado.getString("per_apellido"));
                user.setDireccion(resultado.getString("per_direccion"));
                user.setUsuario(resultado.getString("per_usuario"));
                user.setContraseña(resultado.getString("per_password"));
                user.setCargo(resultado.getString("per_cargo"));
                user.setTelefonoConvencional(resultado.getString("per_tel_convencional"));
                user.setTelefonoCelular(resultado.getString("per_tel_celular"));
                user.setEstado(resultado.getString("per_estado"));       
                
                //System.out.println("consultando datos del la clase usuario : " + user );
               // System.out.println("\nconsultando datos de la classe persona : " + per);
}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
        
    }

    public void agregarEmpleado(conexionDB con, String cedula, String nombre, String apellido, String direccion , String convencional, String celular, String usuario, String contra, String cargo, String estado) {
         try {
            psentencia= con.getConexion().prepareStatement("INSERT INTO "
                    + "aba_personas VALUES (per_id_seq.nextval,?,?,?,?,?,?,?,?,?,?)");
            psentencia.setString(1, cedula);
            psentencia.setString(2, nombre);
            psentencia.setString(3, apellido);
            psentencia.setString(4, direccion);
            psentencia.setString(5, usuario);
            psentencia.setString(6, contra);
            psentencia.setString(7, cargo);
            psentencia.setString(8, convencional);
            psentencia.setString(9, celular);
            psentencia.setString(10, estado);
            
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

    public void agregarCliente(conexionDB con, String cedula, String nombre, String apellido, String direccion, String convencional, String celular,  String estado) {
        String usuario = "";
        String contra = "";
        String cargo = "C";
        try {
            psentencia= con.getConexion().prepareStatement("INSERT INTO "
                    + "aba_personas VALUES (per_id_seq.nextval,?,?,?,?,?,?,?,?,?,?)");
            psentencia.setString(1, cedula);
            psentencia.setString(2, nombre);
            psentencia.setString(3, apellido);
            psentencia.setString(4, direccion);
            psentencia.setString(5, usuario);
            psentencia.setString(6, contra);
            psentencia.setString(7, cargo);
            psentencia.setString(8, convencional);
            psentencia.setString(9, celular);
            psentencia.setString(10, estado);
            
            ///Se debe ejecutar la sentencia de Insert
            psentencia.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    }
    
    
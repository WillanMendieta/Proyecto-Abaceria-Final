/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Persona;
import modelo.Proveedor;
import modelo.Usuario;
import Conexion.conexionDB;

/**
 *
 * @author Macao
 */
public class GestionPersona {
    
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Proveedor> listaProveedores;
    private ArrayList<Persona>listaPersonas;
    private ResultSet resultado = null;
    private PreparedStatement psentencia = null;
    
    
    public GestionPersona() {
        listaClientes = new ArrayList<Cliente>();
        listaProveedores = new ArrayList<Proveedor>();
        listaUsuarios = new ArrayList<Usuario>();
        listaPersonas=new ArrayList<Persona>();
    }
    
    
    
    
    public Usuario buscarEmpleado(conexionDB con, String usuario, String pass ){
         Usuario user = new Usuario();
        try {
            psentencia = con.getConexion().prepareStatement("Select per_id, per_nombre, per_apellido," 
                     +   "per_cargo, per_usuario, per_password"  
                     +   "from aba_personas"
                     +   "where per_usuario = ?"
                     +   "and per_password = ?");
            psentencia.setString(1, usuario);
            psentencia.setString(2, pass);
            resultado = psentencia.executeQuery();
            //Se presenta el resultado
            while (resultado.next()) {
                user = new Usuario();
                user.setId(resultado.getInt("per_id"));
                user.setCargo(resultado.getString("per_cargo"));
                user.setUsuario(resultado.getString("per_usuario"));
                user.setContraseña(resultado.getString("per_password"));
                user.setNombre(resultado.getString("per_nombre"));
                user.setApellido(resultado.getString("per_apellido"));
               // user.setDireccion(resultado.getString("per_direccion"));
               // user.setNumeroIdentificacion(resultado.getString("per_num_ident"));
               // user.setTelefono(resultado.getString("per_telefono"));
              //  user.setEstado(resultado.getString("per_estado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
        
    }
    
    
    public void aqui(){
        System.out.println("siiii");
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Vista.VntLogin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import modelo.Usuario;

/**
 *
 * @author Macao
 */
public class conexionDB {
     
    private String username;
    private String password;
    private String url;
    private Connection conexion=null;
     Usuario user = new Usuario(); 

  
     
     
      public void Conectar(){
      
          
  System.out.println("datos: " + user);        
          
          
      
           url="jdbc:oracle:thin:@localhost:1521:orcl";
             username="wmendietam";
      password="wmendietam";
              
     
      
    try {

           this.setConexion(DriverManager.getConnection(this.getUrl(),this.getUsername(),this.getPassword()));
       } catch (SQLException e) {
           e.printStackTrace();
       }
    
 
   } 
      
    
    
    
    public void CerrarConexion(){
        try{
                if (this.getConexion() != null && !this.getConexion().isClosed()){
                    this.getConexion().close();
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    
   
}

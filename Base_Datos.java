package Controlador;


import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
package controlador;

/**
 *
 * @author RICHARD
 */
public class Base_Datos {
    
       public static  Connection getConnection()
            {
                try
                    {
                        Class.forName("oracle.jdbc.OracleDriver");
               
                        String myDB="jdbc:oracle:thin:@localhost:1521:XE";
                        Connection cnx = DriverManager.getConnection(myDB,"ProyectoAB","proyectoab");
                        
                        System.out.println("SI hay Conexion");
                         
                        return cnx;
                        
                       
                    }
                catch(SQLException e)
                        {
                            System.out.println(e.getMessage());
                            System.out.println("no hubo conexion");
                             
                        }
                catch (ClassNotFoundException ex) {
                     Logger.getLogger(Base_Datos.class.getName()).log(Level.SEVERE, null, ex);
                      System.out.println("tenemos erros");
                     }

                    return null;    
                
            }
    
}

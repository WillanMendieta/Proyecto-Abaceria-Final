/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.conexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JTextField;
import modelo.Categoria;

/**
 *
 * @author Macao
 */
public class ControlCategoria {

    
    private ResultSet resultado = null;
    private PreparedStatement psentencia = null;
    
    
    public void agregarCategoria(conexionDB con, int codd, String nombre , String estado) {
       
        try {
            psentencia= con.getConexion().prepareStatement("INSERT INTO "
                    + "aba_categorias VALUES (?,?,?)");
            psentencia.setInt(1, codd);
            psentencia.setString(2, nombre);
            psentencia.setString(3, estado);
            
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
}

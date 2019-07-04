/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;



/**
 *
 * @author steve
 */
public class GestionUsuario {
          private  boolean verificacionUsuario;
          private  boolean re;
           
    public  boolean VerificarUsuario(String Usuario){
        System.out.println("antes que entre al if");System.out.println(re);
       if( Usuario == null){
          System.out.println(Usuario); 
           System.out.println("esta en la verificacion de null");
           System.out.println("eliminar");
           System.out.println(re);
           
          return re ;
          
           
       }
        
        if(Usuario.equals("1") ){
              verificacionUsuario = true;
            } else{
            verificacionUsuario= false;
        } re = verificacionUsuario;
        
        System.out.println("esta verificando usuario");
        System.out.println(Usuario);
        System.out.println("verifia re que mismo es  ");
        System.out.println(re);
        return verificacionUsuario;
              
        
    }
    
}

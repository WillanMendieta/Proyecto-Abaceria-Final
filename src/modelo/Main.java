/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Vista.VntLogin;
import javax.swing.UIManager;

/**
 *
 * @author steve
 */
public class Main {
    public static void main(String[] args) {

             try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            
            /**
             * "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
                "javax.swing.plaf.metal.MetalLookAndFeel"
                "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"
                "com.sun.java.swing.plaf.motif.MotifLookAndFeel"
             */

        }catch(Exception ex){
        }
        
             VntLogin  login=new VntLogin();
             login.setVisible(true);
    }
          
        
        
    
    
}




package modelo;

import Vista.VntLogin;
import javax.swing.UIManager;


/**
 *
 * @author steve
 */
public class Main {
    public static void main(String[] args) {
        
        
        System.out.println("Tonto quien es el papa  ");
        System.out.println("ok ok ok ok");

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

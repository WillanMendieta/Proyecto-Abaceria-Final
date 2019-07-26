/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.sun.imageio.plugins.jpeg.JPEG;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Controlador.*;
import modelo.*;
import Conexion.*;

/**
 *
 * @author steve
 */
public class VntLogin extends JFrame implements ActionListener{
 
      private javax.swing.JPasswordField jPassword;
   
        
    private JTextField usuarioIn;
    private JPasswordField Password;
    
    public static JDesktopPane escritorio;
    conexionDB con = new conexionDB();
    Usuario user = new Usuario(); 
    ControlPersona perControl;
    
    Persona per = new Persona();
    
    public VntLogin() {
        perControl = new ControlPersona();
        
        setTitle("Iniciar sesion");
        
	setSize(320,481);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container cp= getContentPane();
        setLocationRelativeTo(null);
        
        
        ImageIcon ICONO = new ImageIcon("src/ima/in2.gif"); 
        JLabel imagenFondo = new JLabel(ICONO);
        imagenFondo.setLayout(new java.awt.GridBagLayout());
        
        GridBagConstraints gb = new GridBagConstraints();
        
        //Etiquetas para el la ventana login
        
        JLabel usurio = new JLabel("Usuario");
	gb.gridx=0;
	gb.gridy=0;
        usurio.setForeground(Color.WHITE);
	imagenFondo.add(usurio, gb);
        // Espacio en blanco para el reibimiento del usuario
        usuarioIn= new JTextField(20);
	gb.gridx=0;
	gb.gridy=1;
	imagenFondo.add(usuarioIn, gb);
        
        //Etiqueta con el anunciasdo de contraseña
        JLabel Contraseña = new JLabel("Contraseña");
	gb.gridx=0;
	gb.gridy=2;
        Contraseña.setForeground(Color.WHITE);
	imagenFondo.add(Contraseña, gb);
        
        //Esaco en blanco para ingresar la contraseña
        Password = new JPasswordField(20); 

	gb.gridx=0;
	gb.gridy=3;
	imagenFondo.add(Password, gb);
        
       
//Si imprimes ahora valorPass, te devolvera el valor real que se ha
// ingresado dentro del txtPasswordField
        
        //boton de iniciar sesion 
        JButton iniciar= new JButton("Iniciar Sesión");
	gb.gridx=0;
	gb.gridy=4;
	gb.gridwidth=1;
        iniciar.addActionListener(this);
        iniciar.setActionCommand("Iniciar Sesión");
	imagenFondo.add(iniciar, gb);
        
        cp.add(imagenFondo);
    }
//Metodo para recibir acciones del boton
    @Override
    public void actionPerformed(ActionEvent e) {
         String comando = e.getActionCommand();
          switch(comando){
           case"Iniciar Sesión":
               
               String valorUser =  usuarioIn.getText();
               String valorPass = new String(Password.getPassword());
               System.out.println(" inicia coneccion");
               
              con.Conectar();
              System.out.println("entra a buscar empleado");
               System.out.println("datos del empleado ingresado: " + valorUser + " " + valorPass );
              user = perControl.buscarEmpleado(con, valorUser , valorPass);
              
              con.CerrarConexion();
              System.out.println("sesion cerrada");
               System.out.println("datos de usuario: " + user);
               //System.out.println("Datos de Persona: "+ per);
               
               if(user.getId() > 0 ){
                  if(user.getCargo().equalsIgnoreCase("A")){
                      System.out.println("administrador Encontrado !!!!!!!");
                      javax.swing.JOptionPane.showMessageDialog(null, "Bienvenido: " + user.getNombre(), "Administrador", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                      
                      //JOptionPane.showMessageDialog(frame1,"Producto Agregado a Lista");
                      
                      VntMenuPrincipalAdministrador VenanaP= new VntMenuPrincipalAdministrador(user);
                      VenanaP.setVisible(true);
                      setVisible(false);
                      
                  }else if (user.getCargo().equalsIgnoreCase("E")){
                      System.out.println("empleado detectado !!!!!!!!!!! ");
                      javax.swing.JOptionPane.showMessageDialog(null, "Bienvenido: " + user.getNombre(), "Empleado", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                      VntMenuPrincipalAdministrador VenanaP= new VntMenuPrincipalAdministrador(user);
                      VenanaP.setVisible(true);
                      setVisible(false);
                      
                  }
              } else 
                   javax.swing.JOptionPane.showMessageDialog(null, "Error al ingreso de datos", "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
                
                break;
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

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
import javax.swing.JTextField;

/**
 *
 * @author steve
 */
public class VntLogin extends JFrame implements ActionListener{

    private JTextField usuarioIn;
    private JTextField pasword;
    public static JDesktopPane escritorio;
    
    
    public VntLogin() {
        
        setTitle("Iniciar sesion");
        
	setSize(250,350);
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
        pasword = new JTextField(20);
	gb.gridx=0;
	gb.gridy=3;
	imagenFondo.add(pasword, gb);
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
            llamarVentanaPrincipal();
           
             
                
            default:
                
                break;
        }
    }

    private void llamarVentanaPrincipal() {
        String u = usuarioIn.getText();
     
        if(u.equals("1") ){
                VntMenuPrincipalAdministrador  menu1=new VntMenuPrincipalAdministrador();
                menu1.setVisible(true);
                setVisible(false);
            }
        else if(u.equals("2") ){
                VntMenuPrincipalEmpleado  menu=new VntMenuPrincipalEmpleado();
                menu.setVisible(true);
                setVisible(false);
        }
        else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Usuario Incorrecto");
           }
        
             
            
            
    }
        
        
    
    
    
}

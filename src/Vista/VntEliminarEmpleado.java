/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.Usuario;

/**
 *
 * @author steve
 */
public class VntEliminarEmpleado extends JFrame implements ActionListener {
    private JTextField cedula;
    private JTextField nombre;
    private JTextField detalles;
    Usuario user;
    public VntEliminarEmpleado( Usuario usuario){
        componentes();
        user = usuario;
    }

    private void componentes() {
            
             
        setTitle("Eliminar Empleado");
        
	setSize(550,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container cp= getContentPane();
        setLocationRelativeTo(null);
        
        
        ImageIcon ICONO = new ImageIcon("src/ima/if"); 
        JLabel imagenFondo = new JLabel(ICONO);
        imagenFondo.setLayout(new java.awt.GridBagLayout());
        
        GridBagConstraints gb = new GridBagConstraints();
        
        //Etiquetas para el la ventana login
        
        JLabel buscar = new JLabel("Buscar Empleado: ");
	gb.gridx=0;
	gb.gridy=0;
        buscar.setForeground(Color.red);
	imagenFondo.add(buscar, gb);
        
        // Espacio en blanco para el reibimiento del usuario
        cedula= new JTextField(20);
	gb.gridx=1;
	gb.gridy=0;
	imagenFondo.add(cedula, gb);
        
        JButton buscarBoton= new JButton("Buscar");
	gb.gridx=2;
	gb.gridy=0;
	gb.gridwidth=1;
        buscarBoton.addActionListener(this);
        buscarBoton.setActionCommand("buscar");
	imagenFondo.add(buscarBoton, gb);
        
        //Etiqueta con el anunciasdo de contraseña
        JLabel nombreJ = new JLabel("Nombre:");
	gb.gridx=0;
	gb.gridy=1;
        nombreJ.setForeground(Color.red);
	imagenFondo.add(nombreJ, gb);
        //Esaco en blanco para ingresar la contraseña
        nombre = new JTextField(20);
	gb.gridx=1;
	gb.gridy=1;
	imagenFondo.add(nombre, gb);
        
        //Etiqueta con el anunciasdo de contraseña
        JLabel detallesJ = new JLabel("Detalles de Eliminacion:");
	gb.gridx=0;
	gb.gridy=2;
        detallesJ.setForeground(Color.red);
	imagenFondo.add(detallesJ, gb);
        //Esaco en blanco para ingresar la contraseña
        detalles = new JTextField(20);
	gb.gridx=1;
	gb.gridy=2;
	imagenFondo.add(detalles, gb);
        
        JPanel panelBotones = new JPanel();
        
        //boton de Anular 
        JButton eliminar= new JButton("Eliminar");
	gb.gridx=0;
	gb.gridy=0;
	gb.gridwidth=1;
        eliminar.addActionListener(this);
        eliminar.setActionCommand("eliminar");
	panelBotones.add(eliminar, gb);
        
        //boton de Cancelar
        JButton cancelar= new JButton("Cancelar");
	gb.gridx=1;
	gb.gridy=0;
	gb.gridwidth=1;
        cancelar.addActionListener(this);
        cancelar.setActionCommand("cancelar");
	panelBotones.add(cancelar, gb);
        
        panelBotones.setBackground(Color.red);
        gb.gridx=1;
	gb.gridy=3;
       imagenFondo.add(panelBotones,gb);
        
        cp.add(imagenFondo);


//Metodo para recibir acciones del boton
  
}

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
          switch(comando){
           case"eliminar":
           llamarMetodoEliminar();
           break;
           case "buscar":
                verificarEmpleado();
                break;
           
          case "cancelar":
                Regresar();
                break;
        
            default:
                break;
    }
    
    }

    private void Regresar() {
        String u = null;
        VntMenuPrincipalAdministrador  menu=new VntMenuPrincipalAdministrador(user);
               menu.setVisible(true);
               setVisible(false);
    
    } 
    


    private void llamarMetodoEliminar() {
          String u = cedula.getText();
            if(u.equals("1") ){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Empleado Eliminado");
            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Empleado no Eliminado");
            }
   
    }

    private void verificarEmpleado() {
          String u = cedula.getText();
            if(u.equals("1") ){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Empleado Encontrado");
            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Empleado no Encotrado");
            }
        
    }

    
}
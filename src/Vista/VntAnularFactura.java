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
public class VntAnularFactura extends JFrame implements ActionListener {
    private JTextField codigo;
    private JTextField detalles;
    Usuario user;
    
    public VntAnularFactura( Usuario usuario){
        componentes();
        user = usuario;
    }

    private void componentes() {
            
             
        setTitle("Anular Factura");
        
	setSize(550,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container cp= getContentPane();
        setLocationRelativeTo(null);
        
        
        ImageIcon ICONO = new ImageIcon("src/ima/igif"); 
        JLabel imagenFondo = new JLabel(ICONO);
        imagenFondo.setLayout(new java.awt.GridBagLayout());
        
        GridBagConstraints gb = new GridBagConstraints();
        
        //Etiquetas para el la ventana login
        
        JLabel buscar = new JLabel("Buscar Factura: ");
	gb.gridx=0;
	gb.gridy=0;
        buscar.setForeground(Color.red);
	imagenFondo.add(buscar, gb);
        
        // Espacio en blanco para el reibimiento del usuario
        codigo= new JTextField(20);
	gb.gridx=1;
	gb.gridy=0;
	imagenFondo.add(codigo, gb);
        
        JButton buscarBoton= new JButton("Buscar");
	gb.gridx=2;
	gb.gridy=0;
	gb.gridwidth=1;
        buscarBoton.addActionListener(this);
        buscarBoton.setActionCommand("buscar");
	imagenFondo.add(buscarBoton, gb);
        
        //Etiqueta con el anunciasdo de contraseña
        JLabel detallesJ = new JLabel("Detalles de Aulacion:");
	gb.gridx=0;
	gb.gridy=1;
        detallesJ.setForeground(Color.red);
	imagenFondo.add(detallesJ, gb);
        //Esaco en blanco para ingresar la contraseña
        detalles = new JTextField(20);
	gb.gridx=1;
	gb.gridy=1;
	imagenFondo.add(detalles, gb);
        
        JPanel panelBotones = new JPanel();
        
        //boton de Anular 
        JButton anular= new JButton("Anular");
	gb.gridx=0;
	gb.gridy=0;
	gb.gridwidth=1;
        anular.addActionListener(this);
        anular.setActionCommand("anular");
	panelBotones.add(anular, gb);
        
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
	gb.gridy=2;
        imagenFondo.add(panelBotones,gb);
        
        cp.add(imagenFondo);


//Metodo para recibir acciones del boton
  
}

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
          switch(comando){
           case"anular":
           llamarMetodoAnular();
           break;
            case"buscar":
           verificarFactura();
           break;
          case "cancelar":
                Regresar();
                break;
        
            default:
                break;
    }
    
    }

    private void Regresar() {
         VntMenuPrincipalAdministrador  menu =new VntMenuPrincipalAdministrador(user);
               menu.setVisible(true);
               setVisible(false);
    
    }

    private void llamarMetodoAnular() {
          String u = codigo.getText();
            if(u.equals("1") ){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Factura Anulada");
            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Factura no Anulada");
            }
    
    
    }

    
    private void verificarFactura() {
     String u = codigo.getText();
            if(u.equals("1") ){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Factura Encontrada");
            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Factura no Encontrada");
            }
    }
}
    


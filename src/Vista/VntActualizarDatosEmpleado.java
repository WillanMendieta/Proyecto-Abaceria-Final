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
import javax.swing.SwingConstants;

/**
 *
 * @author steve
 */
public class VntActualizarDatosEmpleado extends JFrame implements ActionListener {
    
    private JTextField cedula;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField usuario;
    private JTextField contra;
    
    public VntActualizarDatosEmpleado(){
        componentes();
    }

    private void componentes() {
      setTitle("Registrar Cliente");
        
	setSize(450,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
	Container cp= getContentPane();
        
        
         ImageIcon ICONO = new ImageIcon("src/ima/in1f"); 
        JLabel imagenFondo = new JLabel(ICONO);
        imagenFondo.setLayout(new java.awt.GridBagLayout());
        
        GridBagConstraints gb = new GridBagConstraints();
        
        //Etiquetas para el la ventana de Registrar Cliente
        
        JLabel cedulaJ = new JLabel("Cedula:");
	gb.gridx=0;
	gb.gridy=0;
        cedulaJ.setForeground(Color.red);
	imagenFondo.add(cedulaJ, gb);
        // Espacio en blanco para ingresar la cedula
        cedula= new JTextField(20);
	gb.gridx=1;
	gb.gridy=0;
	imagenFondo.add(cedula, gb);
        
            JButton AgregarProveedor= new JButton("Buscar Cliente");
       //Se agrega el icono al boton
     //  AgregarProveedor.setIcon(iconoProducto);
       //Se da La ubicacion del texto en el boton
        AgregarProveedor.setHorizontalTextPosition( SwingConstants.CENTER );
        AgregarProveedor.setVerticalTextPosition( SwingConstants.BOTTOM );
	gb.gridx=2;
	gb.gridy=0;
        gb.fill=GridBagConstraints.BOTH;
        //se da la accion
        AgregarProveedor.addActionListener(this);
        AgregarProveedor.setActionCommand("buscar");
	imagenFondo.add(AgregarProveedor, gb);
        
        //Etiqueta con el anunciado los nombres
        JLabel nombreJ = new JLabel("Nombres:");
	gb.gridx=0;
	gb.gridy=1;
        nombreJ.setForeground(Color.red);
	imagenFondo.add(nombreJ, gb);
        //Espacio en blanco para ingresar los nombres
        nombre = new JTextField(20);
	gb.gridx=1;
	gb.gridy=1;
	imagenFondo.add(nombre, gb);
        
        //Etiqueta con el anunciado de los apellidos
        JLabel apellidoJ = new JLabel("Apellidos:");
	gb.gridx=0;
	gb.gridy=2;
        apellidoJ.setForeground(Color.red);
	imagenFondo.add(apellidoJ, gb);
        //Espacio en blanco para ingresar los apellidos
        apellido = new JTextField(20);
	gb.gridx=1;
	gb.gridy=2;
	imagenFondo.add(apellido, gb);
        
        //Etiqueta con el anunciado del telefono convencional
        JLabel usuarioJ = new JLabel("Usuario:");
	gb.gridx=0;
	gb.gridy=3;
        usuarioJ.setForeground(Color.red);
	imagenFondo.add(usuarioJ, gb);
        //Espacio en blanco para ingresar el telefono convencional
        usuario = new JTextField(20);
	gb.gridx=1;
	gb.gridy=3;
	imagenFondo.add(usuario, gb);
        
        
           //Etiqueta con el anunciado de telefono celular
        JLabel contraseñaJ = new JLabel("Contraseña:");
	gb.gridx=0;
	gb.gridy=4;
        contraseñaJ.setForeground(Color.red);
	imagenFondo.add(contraseñaJ, gb);
        //Espacio en blanco para ingresar el telefono celular
        contra= new JTextField(20);
	gb.gridx=1;
	gb.gridy=4;
	imagenFondo.add(contra, gb);
        
    
        
        
        
        JPanel panelBotones = new JPanel();
        //boton de Registar
        JButton agregarEmpleado= new JButton("Agregar Empleado");
	gb.gridx=0;
	gb.gridy=0;
        agregarEmpleado.addActionListener(this);
        agregarEmpleado.setActionCommand("agregarEmpleado");
	panelBotones.add(agregarEmpleado, gb);
        
          //boton de Cancelar 
        JButton Cancelar= new JButton("Cancelar");
	gb.gridx=1;
	gb.gridy=0;
        Cancelar.addActionListener(this);
        Cancelar.setActionCommand("Cancelar");
	panelBotones.add(Cancelar, gb);
        panelBotones.setBackground(Color.red);
        gb.gridx=1;
	gb.gridy=5;
       imagenFondo.add(panelBotones,gb);
        cp.add(imagenFondo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        switch(comando){
            case "agregarEmpleado":
                llamarMetodoAgregarEmpleado();
                break;
             case "Cancelar":
                Regresar();
                break;
        
            default:
                break;
        
    }
    
}

    private void Regresar() {
        String u = null;
         VntMenuPrincipalAdministrador  menu=new VntMenuPrincipalAdministrador(u);
               menu.setVisible(true);
               setVisible(false);
    }

    private void llamarMetodoAgregarEmpleado() {
        
          String u = cedula.getText();
            if(u.equals("1") ){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Empleado Agregado");
            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Empleado no agregado");
            }
  
    }
    
}

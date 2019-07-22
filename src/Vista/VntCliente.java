/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Conexion.conexionDB;
import Controlador.ControlPersona;
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
public class VntCliente extends JFrame implements ActionListener {
    
    private JTextField cedula;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField convencional;
    private JTextField celular;
    private JTextField direccion;
    Usuario user;
    ControlPersona controlPer ;
    conexionDB con = new conexionDB();
    public VntCliente(Usuario usuario){
        componentes();
        user = usuario;
        controlPer = new ControlPersona();
        user = usuario;
    }

    private void componentes() {
      setTitle("Agregar Nuevo Cliente");
        
	setSize(450,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
	Container cp= getContentPane();
        
        
         ImageIcon ICONO = new ImageIcon("src/ima/igif"); 
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
        JLabel convencionalJ = new JLabel("Tel.Convencional:");
	gb.gridx=0;
	gb.gridy=3;
        convencionalJ.setForeground(Color.red);
	imagenFondo.add(convencionalJ, gb);
        //Espacio en blanco para ingresar el telefono convencional
        convencional = new JTextField(20);
	gb.gridx=1;
	gb.gridy=3;
	imagenFondo.add(convencional, gb);
        
        
           //Etiqueta con el anunciado de telefono celular
        JLabel celularJ = new JLabel("Tel.Celular:");
	gb.gridx=0;
	gb.gridy=4;
        celularJ.setForeground(Color.red);
	imagenFondo.add(celularJ, gb);
        //Espacio en blanco para ingresar el telefono celular
        celular = new JTextField(20);
	gb.gridx=1;
	gb.gridy=4;
	imagenFondo.add(celular, gb);
        
           //Etiqueta con el anunciado de direccion
        JLabel direccionJ = new JLabel("Direccion:");
	gb.gridx=0;
	gb.gridy=5;
        direccionJ.setForeground(Color.red);
	imagenFondo.add(direccionJ, gb);
        //Espacio en blanco para ingresar la direccion
        direccion = new JTextField(20);
	gb.gridx=1;
	gb.gridy=5;
	imagenFondo.add(direccion, gb);
        
        
        
        JPanel panelBotones = new JPanel();
        //boton de Registar
        JButton RegistarCliente= new JButton("Registar Cliente");
	gb.gridx=0;
	gb.gridy=0;
        RegistarCliente.addActionListener(this);
        RegistarCliente.setActionCommand("RegistarCliente");
	panelBotones.add(RegistarCliente, gb);
        
          //boton de Cancelar 
        JButton Cancelar= new JButton("Cancelar");
	gb.gridx=1;
	gb.gridy=0;
        Cancelar.addActionListener(this);
        Cancelar.setActionCommand("Cancelar");
	panelBotones.add(Cancelar, gb);
        panelBotones.setBackground(Color.red);
        gb.gridx=1;
	gb.gridy=6;
       imagenFondo.add(panelBotones,gb);
        cp.add(imagenFondo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        switch(comando){
            case "RegistarCliente":
                llamarMetodoAgregarCliente();
                break;
             case "Cancelar":
                Regresar();
                break;
        
            default:
                break;
        
    }
    
}

    private void Regresar() {
        VntMenuCliente ver = new VntMenuCliente(user);
        ver.setVisible(true);
        setVisible(false);
    }

    private void llamarMetodoAgregarCliente() {
         if(nombre.getText().isEmpty() || cedula.getText().isEmpty() || apellido.getText().isEmpty()) {
             javax.swing.JOptionPane.showMessageDialog(null, "Nombre, Apellido, Cedula no pueden ser nulos", "Error de Campos", javax.swing.JOptionPane.WARNING_MESSAGE);
    
            
        }else{
            String estado = "A";
            con.Conectar();
            controlPer.agregarCliente(con, cedula.getText(), nombre.getText(), apellido.getText(),
                                    direccion.getText(), convencional.getText(), celular.getText(),estado);
            con.CerrarConexion();
            javax.swing.JOptionPane.showMessageDialog(null, "Cliente Agregado", "Exito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            cedula.setText("");
            nombre.setText("");
            apellido.setText("");
            direccion.setText("");
            convencional.setText("");
            celular.setText("");
        }
        }
        
}

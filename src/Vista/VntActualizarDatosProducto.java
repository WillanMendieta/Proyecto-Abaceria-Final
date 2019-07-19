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
public class VntActualizarDatosProducto extends JFrame implements ActionListener  {
    
    private JTextField codigo;
    private JTextField nombre;
    private JTextField categoria;
    private JTextField stock;
    private JTextField precio;
    Usuario user;
    
    public VntActualizarDatosProducto(Usuario usuario){
        componentes();
        user = usuario;
    }

    private void componentes() {
      setTitle("Actualizar Datos Producto");
        
	setSize(450,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
	Container cp= getContentPane();
        
        
         ImageIcon ICONO = new ImageIcon("src/ima/igif"); 
        JLabel imagenFondo = new JLabel(ICONO);
        imagenFondo.setLayout(new java.awt.GridBagLayout());
        
        GridBagConstraints gb = new GridBagConstraints();
        
        //Etiquetas para el la ventana de Registrar Cliente
        
        JLabel codigoJ = new JLabel("Codigo:");
	gb.gridx=0;
	gb.gridy=0;
        codigoJ.setForeground(Color.red);
	imagenFondo.add(codigoJ, gb);
        // Espacio en blanco para ingresar la cedula
        codigo= new JTextField(20);
	gb.gridx=1;
	gb.gridy=0;
	imagenFondo.add(codigo, gb);
        
        //Etiqueta con el anunciado los nombres
        JLabel nombreJ = new JLabel("Nombre:");
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
        JLabel categoriaJ = new JLabel("Categoria:");
	gb.gridx=0;
	gb.gridy=2;
        categoriaJ.setForeground(Color.red);
	imagenFondo.add(categoriaJ, gb);
        //Espacio en blanco para ingresar los apellidos
        categoria= new JTextField(20);
	gb.gridx=1;
	gb.gridy=2;
	imagenFondo.add(categoria, gb);
        
        //Etiqueta con el anunciado del telefono convencional
        JLabel stockJ = new JLabel("Stock");
	gb.gridx=0;
	gb.gridy=3;
        stockJ.setForeground(Color.red);
	imagenFondo.add(stockJ, gb);
        //Espacio en blanco para ingresar el telefono convencional
        stock = new JTextField(20);
	gb.gridx=1;
	gb.gridy=3;
	imagenFondo.add(stock, gb);
        
        
           //Etiqueta con el anunciado de telefono celular
        JLabel precioJ = new JLabel("Precio:");
	gb.gridx=0;
	gb.gridy=4;
        precioJ.setForeground(Color.red);
	imagenFondo.add(precioJ, gb);
        //Espacio en blanco para ingresar el telefono celular
        precio = new JTextField(20);
	gb.gridx=1;
	gb.gridy=4;
	imagenFondo.add(precio, gb);
     
        
        JPanel panelBotones = new JPanel();
        //boton de Registar
        JButton actualizarProducto = new JButton("Actualizar Producto");
	gb.gridx=0;
	gb.gridy=0;
        actualizarProducto.addActionListener(this);
        actualizarProducto.setActionCommand("actualizarProducto");
	panelBotones.add(actualizarProducto, gb);
        
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
            case "actualizarProducto":
                llamarMetodoActualizarProducto();
                break;
             case "Cancelar":
                Regresar();
                break;
        
            default:
                break;
        
    }
    
}

    private void Regresar() {
            VntGestionPro  menuP=new VntGestionPro(user);
               menuP.setVisible(true);
               setVisible(false);
    }

    private void llamarMetodoActualizarProducto() {
          String u = codigo.getText();
            if(u.equals("1") ){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Datos Actualizados");
            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Error de Datos");
            }
    }
    
}

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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import modelo.Usuario;

/**
 *
 * @author steve
 */
public class VntAgregarProducto extends JFrame implements ActionListener  {
    
    private JTextField codigo;
    private JTextField nombre;
    private JComboBox categoria;
    private JTextField precioTex;
    private JRadioButton ivaTex;
    Usuario user;
    
    public VntAgregarProducto(Usuario usuario){
        componentes();
        user = usuario;
    }

    private void componentes() {
      setTitle("Agregar Producto");
        
	setSize(450,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
	Container cp= getContentPane();
        
        
         ImageIcon ICONO = new ImageIcon("src/ima/inf"); 
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
        codigo.setEditable(false);
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
        categoria= new JComboBox();
        categoria.addItem("Ejemplo");
	gb.gridx=1;
	gb.gridy=2;
	imagenFondo.add(categoria, gb);
        
        //Etiqueta con el anunciado del telefono convencional
        JLabel precioJ = new JLabel("Precio");
	gb.gridx=0;
	gb.gridy=3;
        precioJ.setForeground(Color.red);
	imagenFondo.add(precioJ, gb);
        //Espacio en blanco para ingresar el telefono convencional
        precioTex = new JTextField(20);
	gb.gridx=1;
	gb.gridy=3;
	imagenFondo.add(precioTex, gb);
        
        
           //Etiqueta con el anunciado de telefono celular
        JLabel iva = new JLabel("I.V.A:");
	gb.gridx=0;
	gb.gridy=4;
        iva.setForeground(Color.red);
	imagenFondo.add(iva, gb);
        //Espacio en blanco para ingresar el telefono celular
        ivaTex = new JRadioButton();
	gb.gridx=1;
	gb.gridy=4;
        ivaTex.addActionListener(this);
        ivaTex.setActionCommand("iva Activado");
	imagenFondo.add(ivaTex, gb);
        
     
        
        JPanel panelBotones = new JPanel();
        //boton de Registar
        JButton agregarProducto = new JButton("Agregar Producto");
	gb.gridx=0;
	gb.gridy=0;
        agregarProducto.addActionListener(this);
        agregarProducto.setActionCommand("agregarProducto");
	panelBotones.add(agregarProducto, gb);
        
          //boton de Cancelar 
        JButton Cancelar= new JButton("Cancelar");
	gb.gridx=1;
	gb.gridy=0;
        Cancelar.addActionListener(this);
        Cancelar.setActionCommand("Cancelar");
	panelBotones.add(Cancelar, gb);
        
        gb.gridx=1;
	gb.gridy=5;
       imagenFondo.add(panelBotones,gb);
        cp.add(imagenFondo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        switch(comando){
            case "agregarProducto":
                llamarMetodoAgregarProducto();
                break;
             case "Cancelar":
                Regresar();
                break;
              case "iva Activado":
                  System.out.println("accion del iva");
                  
                  if(ivaTex.isSelected()==true) {
                      System.out.println("esta activadoo el iva");
                      
                  } else if (ivaTex.isSelected()==true){
                      System.out.println("se desactivo el iva");
                  
              }
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

    private void llamarMetodoAgregarProducto() {
          String u = codigo.getText();
            if(u.equals("1") ){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Producto Agregado");
            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Producto no Agregado");
            }
    }
    
}

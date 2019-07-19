/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.TextArea;
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
import modelo.Usuario;

/**
 *
 * @author steve
 */
public class VntIngresarProducto extends JFrame implements ActionListener  {
    
    private JTextField codigoFactura;
    private JTextField Ruc;
    private JTextField proveedor;
    private JTextField codigoPro;
    private JTextField nombreProducto;
    private JTextField cantidad;
    Usuario user;
    
    public VntIngresarProducto(Usuario usuario){
        componentes();
        user = usuario;
    }

    private void componentes() {
      setTitle("Ingresar Compras");
        
	setSize(550,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
	Container cp= getContentPane();
        
        
         ImageIcon ICONO = new ImageIcon("src/ima/inf"); 
        JLabel imagenFondo = new JLabel(ICONO);
        imagenFondo.setLayout(new java.awt.GridBagLayout());
        
        GridBagConstraints gb = new GridBagConstraints();
        
        //Etiquetas para el la ventana de Registrar Cliente
        
        JLabel codigoFacturaJ = new JLabel("Codigo Factura:");
	gb.gridx=0;
	gb.gridy=0;
        codigoFacturaJ.setForeground(Color.red);
	imagenFondo.add(codigoFacturaJ, gb);
        // Espacio en blanco para ingresar la cedula
        codigoFactura= new JTextField(20);
	gb.gridx=1;
	gb.gridy=0;
	imagenFondo.add(codigoFactura, gb);
        
        //jlabel de ruc
        JLabel rucJ = new JLabel("Ruc:");
	gb.gridx=0;
	gb.gridy=1;
        rucJ.setForeground(Color.red);
	imagenFondo.add(rucJ, gb);
        // Espacio en blanco para ingresar el ruc
        Ruc= new JTextField(20);
	gb.gridx=1;
	gb.gridy=1;
	imagenFondo.add(Ruc, gb);
        
            //jlabel de Proveedor
        JLabel proveedorJ = new JLabel("Proveedor:");
	gb.gridx=0;
	gb.gridy=2;
        proveedorJ.setForeground(Color.red);
	imagenFondo.add(proveedorJ, gb);
        // Espacio en blanco para ingresar el ruc
        proveedor= new JTextField(20);
	gb.gridx=1;
	gb.gridy=2;
	imagenFondo.add(proveedor, gb);
        
      //    // se ingresa el iono que va en el boton
      // ImageIcon iconoPro = new ImageIcon("src/ima/icono/buscar.png");
       // Se da las dimenciones del icono que va en el boton
       //ImageIcon iconoProducto = new ImageIcon(iconoPro.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
       //se insatancia el boton
       JButton AgregarProveedor= new JButton("Buscar Proveedor");
       //Se agrega el icono al boton
     //  AgregarProveedor.setIcon(iconoProducto);
       //Se da La ubicacion del texto en el boton
        AgregarProveedor.setHorizontalTextPosition( SwingConstants.CENTER );
        AgregarProveedor.setVerticalTextPosition( SwingConstants.BOTTOM );
	gb.gridx=2;
	gb.gridy=1;
        gb.fill=GridBagConstraints.BOTH;
        //se da la accion
        AgregarProveedor.addActionListener(this);
        AgregarProveedor.setActionCommand("buscar");
	imagenFondo.add(AgregarProveedor, gb);
        
        //Etiqueta con el anunciado de los apellidos
        JLabel codigoproJ = new JLabel("Codigo Producto:");
	gb.gridx=0;
	gb.gridy=3;
        codigoproJ.setForeground(Color.red);
	imagenFondo.add(codigoproJ, gb);
        //Espacio en blanco para ingresar los apellidos
        codigoPro= new JTextField(20);
	gb.gridx=1;
	gb.gridy=3;
	imagenFondo.add(codigoPro, gb);
        
         // se ingresa el iono que va en el boton
       //ImageIcon iconoPro = new ImageIcon("src/ima/icono/buscar.png");
       // Se da las dimenciones del icono que va en el boton
      // ImageIcon iconoProducto = new ImageIcon(iconoPro.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
       //se insatancia el boton
       JButton AgregarProducto= new JButton("Buscar");
       //Se agrega el icono al boton
     //  AgregarProducto.setIcon(iconoProducto);
       //Se da La ubicacion del texto en el boton
        AgregarProducto.setHorizontalTextPosition( SwingConstants.CENTER );
        AgregarProducto.setVerticalTextPosition( SwingConstants.BOTTOM );
	gb.gridx=2;
	gb.gridy=2;
        gb.fill=GridBagConstraints.BOTH;
        //se da la accion
        AgregarProducto.addActionListener(this);
        AgregarProducto.setActionCommand("buscar");
	imagenFondo.add(AgregarProducto, gb);
        
        
         //Etiqueta con el anunciado los nombres
        JLabel nombreJ = new JLabel("Nombre:");
	gb.gridx=0;
	gb.gridy=4;
        nombreJ.setForeground(Color.red);
	imagenFondo.add(nombreJ, gb);
        //Espacio en blanco para ingresar los nombres
        nombreProducto = new JTextField(20);
	gb.gridx=1;
	gb.gridy=4;
	imagenFondo.add(nombreProducto, gb);
        
        //Etiqueta con el anunciado del telefono convencional
        JLabel cantidadJ = new JLabel("Cantidad:");
	gb.gridx=0;
	gb.gridy=5;
        cantidadJ.setForeground(Color.red);
	imagenFondo.add(cantidadJ, gb);
        //Espacio en blanco para ingresar el telefono convencional
        cantidad = new JTextField(20);
	gb.gridx=1;
	gb.gridy=5;
	imagenFondo.add(cantidad, gb);
        
        TextArea area1= new TextArea(5,40);
        gb.gridx=1;
	gb.gridy=6;
        imagenFondo.add(area1, gb);
        
        JButton agregarProducto1 = new JButton("Agregar producto");
	gb.gridx=0;
	gb.gridy=6;
        agregarProducto1.addActionListener(this);
        agregarProducto1.setActionCommand("agregar1");
	imagenFondo.add(agregarProducto1, gb);
        
        
        JPanel panelBotones = new JPanel();
        //boton de Registar
        JButton agregarProducto = new JButton("Guardar Cambios");
	gb.gridx=0;
	gb.gridy=0;
        agregarProducto.addActionListener(this);
        agregarProducto.setActionCommand("agregar");
	panelBotones.add(agregarProducto, gb);
        
          //boton de Cancelar 
        JButton Cancelar= new JButton("Cancelar");
	gb.gridx=1;
	gb.gridy=0;
        Cancelar.addActionListener(this);
        Cancelar.setActionCommand("Cancelar");
	panelBotones.add(Cancelar, gb);
        //panelBotones.setBackground(Color.red);
        gb.gridx=1;
	gb.gridy=7;
       imagenFondo.add(panelBotones,gb);
        cp.add(imagenFondo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        String u = codigoPro.getText();
        switch(comando){
            case "agregar":
                llamarMetodoSumarCantidad();
                break;
             case "Cancelar":
                Regresar();
                break;
             case "agregar1":
                codigoPro.setText("");
                cantidad.setText("");
                nombreProducto.setText("");
                JFrame frame1 = new JFrame();
                JOptionPane.showMessageDialog(frame1,"Producto Agregado a Lista");
                
                break;

                 case "buscar":
                 if(u.equals("1") ){
                nombreProducto.setText("Papas");
                
            }else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Producto no Existe");
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

    private void llamarMetodoSumarCantidad() {
      String u = codigoFactura.getText();
            if(u.equals("1") ){
               JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Producto Aceptado");
            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Producto Incorrecto");
            }
 
    }

    
    
}

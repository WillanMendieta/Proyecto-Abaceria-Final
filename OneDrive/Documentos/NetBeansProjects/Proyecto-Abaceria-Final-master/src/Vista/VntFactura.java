/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author steve
 */
public class VntFactura extends JFrame implements ActionListener {
    
    private JTextField cedula;
    private JTextField nombre;
    private JTextField apellido;
    private JTextField convencional;
    private JTextField celular;
    private JTextField direccion;
    private JTextField codigoFc;
    private JTextField usuario;
    
    public  VntFactura(){
        componenetes();
       
    }

    private void componenetes() {
        setTitle("Factura");
	setSize(1050,770);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       
        Container cp= getContentPane();
        GridBagConstraints gb = new GridBagConstraints();
        
         // AQUI INGRESO LA IMAGEN DE FONDO
       ImageIcon ICONO = new ImageIcon("src/ima/2.gif"); 
       //   ImageIcon icon1 = new ImageIcon(ICONO.getImage().getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_DEFAULT));
       ICONO.getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
       JLabel imagenFondo = new JLabel(ICONO);
       imagenFondo.setLayout(new GridBagLayout());
       
       
         
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
        
        
         //boton de Buscar
        JButton buscar= new JButton("Buscar");
	gb.gridx=2;
	gb.gridy=0;
        buscar.addActionListener(this);
        buscar.setActionCommand("buscar");
	imagenFondo.add(buscar, gb);
        
        
        
           //Etiqueta con el anunciado de telefono celular
        JLabel celularJ = new JLabel("Tel.Celular:");
	gb.gridx=3;
	gb.gridy=0;
        celularJ.setForeground(Color.red);
	imagenFondo.add(celularJ, gb);
        //Espacio en blanco para ingresar el telefono celular
        celular = new JTextField(20);
	gb.gridx=4;
	gb.gridy=0;
	imagenFondo.add(celular, gb);
        
           //Etiqueta con el anunciado de direccion
        JLabel direccionJ = new JLabel("Direccion:");
	gb.gridx=3;
	gb.gridy=1;
        direccionJ.setForeground(Color.red);
	imagenFondo.add(direccionJ, gb);
        //Espacio en blanco para ingresar la direccion
        direccion = new JTextField(20);
	gb.gridx=4;
	gb.gridy=1;
	imagenFondo.add(direccion, gb);
        
         JLabel codigoFacJ = new JLabel("Codigo Factura:");
	gb.gridx=3;
	gb.gridy=2;
        codigoFacJ.setForeground(Color.red);
	imagenFondo.add(codigoFacJ, gb);
        //Espacio en blanco para ingresar la direccion
         codigoFc = new JTextField(20);
	gb.gridx=4;
	gb.gridy=2;
	imagenFondo.add(codigoFc , gb);
        
        JLabel facturadorJ = new JLabel("Facturador:");
	gb.gridx=3;
	gb.gridy=3;
        facturadorJ.setForeground(Color.red);
	imagenFondo.add(facturadorJ, gb);
        //Espacio en blanco para ingresar la direccion
         usuario= new JTextField(20);
	gb.gridx=4;
	gb.gridy=3;
	imagenFondo.add(usuario , gb);
        
           JPanel panelBotonesAgregar = new JPanel();
        //boton de Registar
        JButton agregarProducto= new JButton("Agregar Producto");
	gb.gridx=0;
	gb.gridy=0;
        agregarProducto.addActionListener(this);
        agregarProducto.setActionCommand("agregar");
	panelBotonesAgregar.add(agregarProducto, gb);
        
        //boton de Cancelar 
        JButton eliminarProducto= new JButton("Eliminar Producto");
	gb.gridx=1;
	gb.gridy=0;
        eliminarProducto.addActionListener(this);
        eliminarProducto.setActionCommand("eliminar");
	panelBotonesAgregar.add(eliminarProducto, gb);
       
        //panelBotonesAgregar.setBackground(Color.red);
        gb.gridx=2;
	gb.gridy=4;
        imagenFondo.add(panelBotonesAgregar,gb);
        cp.add(imagenFondo);
        
        TextArea area1= new TextArea(30,100);
        gb.gridx=0;
	gb.gridy=5;
        gb.gridwidth = 5;
        imagenFondo.add(area1, gb);
        
        
        JPanel panelBotones = new JPanel();
        //boton de Registar
        JButton cobrar= new JButton("Cobrar");
	gb.gridx=0;
	gb.gridy=0;
        cobrar.addActionListener(this);
        cobrar.setActionCommand("cobrar");
	panelBotones.add(cobrar, gb);
        
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
              case "Cancelar":
                Regresar();
              
                break;
                case "buscar":
                buscarCliente();
                break;
                case "cobrar":
                generarFactura();
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

    private void buscarCliente() {
    
     String u = cedula.getText();
            if(u.equals("1") ){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Usuario Correcto");
            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Usuario Incorrecto");
            }
    }

    private void generarFactura() {
    String u = codigoFc.getText();
            if(u.equals("1") ){
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Factura Generada");
            } else {
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame,"Factura no generada");
            }
    }
    
}

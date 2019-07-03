/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


/**
 *
 * @author steve
 */
public class VntMenuPrincipalAdministrador extends JFrame implements ActionListener {
public static JDesktopPane escritorio;
    
   public VntMenuPrincipalAdministrador(){
    Componentes();
}
 
    private void Componentes() {
        setTitle("Menu");
	setSize(1050,670);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Container cp= getContentPane();
        GridBagConstraints gb = new GridBagConstraints();
        
         // AQUI INGRESO LA IMAGEN DE FONDO
         ImageIcon ICONO = new ImageIcon("src/ima/2.gif"); 
       //   ImageIcon icon1 = new ImageIcon(ICONO.getImage().getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_DEFAULT));
         JLabel imagenTablero = new JLabel(ICONO);
     imagenTablero.setLayout(new GridBagLayout());
     
       //Se ingresa los botones
       // se ingresa el iono que va en el boton
       ImageIcon iconoPro = new ImageIcon("src/ima/icono/p.png");
       // Se da las dimenciones del icono que va en el boton
       ImageIcon iconoProducto = new ImageIcon(iconoPro.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
       //se insatancia el boton
       JButton GestorProducto= new JButton("Productos");
       //Se agrega el icono al boton
       GestorProducto.setIcon(iconoProducto);
       //Se da La ubicacion del texto en el boton
        GestorProducto.setHorizontalTextPosition( SwingConstants.CENTER );
        GestorProducto.setVerticalTextPosition( SwingConstants.BOTTOM );
	gb.gridx=0;
	gb.gridy=0;
        gb.weightx=1;
        gb.fill=GridBagConstraints.BOTH;
        //se da la accion
        GestorProducto.addActionListener(this);
        GestorProducto.setActionCommand("Productos");
	imagenTablero.add(GestorProducto, gb);
        
        
        // se ingresa el iono que va en el boton
       ImageIcon iconoEm = new ImageIcon("src/ima/icono/e.png");
       // Se da las dimenciones del icono que va en el boton
       ImageIcon iconoEmple = new ImageIcon(iconoEm.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        JButton AgregarEmpleado= new JButton("Agregar Empleado");
        //Se agrega el icono al boton
        AgregarEmpleado.setIcon(iconoEmple);
        //Se da La ubicacion del texto en el boton
        AgregarEmpleado.setHorizontalTextPosition( SwingConstants.CENTER );
        AgregarEmpleado.setVerticalTextPosition( SwingConstants.BOTTOM );
	gb.gridx=1;
	gb.gridy=0;
        gb.weightx=1;
        AgregarEmpleado.addActionListener(this);
        AgregarEmpleado.setActionCommand("Agregar Empleado");
	imagenTablero.add(AgregarEmpleado, gb);
        
        // se ingresa el iono que va en el boton
       ImageIcon iconoSto = new ImageIcon("src/ima/icono/s.png");
       // Se da las dimenciones del icono que va en el boton
       ImageIcon iconoStock = new ImageIcon(iconoSto.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        JButton Stock= new JButton("Stock");
        //Se agrega el icono al boton
        Stock.setIcon(iconoStock);
        //Se da La ubicacion del texto en el boton
        Stock.setHorizontalTextPosition( SwingConstants.CENTER );
        Stock.setVerticalTextPosition( SwingConstants.BOTTOM );
       	gb.gridx=2;
	gb.gridy=0;
        gb.weightx=1;
        gb.fill=GridBagConstraints.BOTH;
        Stock.addActionListener(this);
        Stock.setActionCommand("Stock");
	imagenTablero.add(Stock, gb);
        
         // se ingresa el iono que va en el boton
       ImageIcon iconoEli = new ImageIcon("src/ima/icono/Eli.png");
       // Se da las dimenciones del icono que va en el boton
       ImageIcon iconoEliminarEmpleado = new ImageIcon(iconoEli.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        JButton EliminarEmpleado= new JButton("Eliminar Empleado");
        //Se agrega el icono al boton
        EliminarEmpleado.setIcon(iconoEliminarEmpleado);
        //Se da La ubicacion del texto en el boton
        EliminarEmpleado.setHorizontalTextPosition( SwingConstants.CENTER );
        EliminarEmpleado.setVerticalTextPosition( SwingConstants.BOTTOM );
	gb.gridx=1;
	gb.gridy=1;
        gb.weightx=1;
        EliminarEmpleado.addActionListener(this);
        EliminarEmpleado.setActionCommand("Eliminar Empleado");
	imagenTablero.add(EliminarEmpleado, gb);
        
        
        
        // se ingresa el iono que va en el boton
       ImageIcon iconoAcCli = new ImageIcon("src/ima/icono/cli.png");
       // Se da las dimenciones del icono que va en el boton
       ImageIcon iconoACCliente = new ImageIcon(iconoAcCli.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        JButton ActualizarDatosCliente= new JButton("Actualizar Datos Cliente");
         //Se agrega el icono al boton
        ActualizarDatosCliente.setIcon(iconoACCliente);
        //Se da La ubicacion del texto en el boton
        ActualizarDatosCliente.setHorizontalTextPosition( SwingConstants.CENTER );
        ActualizarDatosCliente.setVerticalTextPosition( SwingConstants.BOTTOM );
	gb.gridx=0;
	gb.gridy=1;
        gb.weightx=1;
        ActualizarDatosCliente.addActionListener(this);
        ActualizarDatosCliente.setActionCommand("ActualizarDatosCliente");
	imagenTablero.add(ActualizarDatosCliente, gb);
        
        // se ingresa el iono que va en el boton
       ImageIcon iconoCli = new ImageIcon("src/ima/icono/cli.png");
       // Se da las dimenciones del icono que va en el boton
       ImageIcon iconoCliente = new ImageIcon(iconoCli.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        JButton AgregarCliente= new JButton("Agregar Cliente");
         //Se agrega el icono al boton
        AgregarCliente.setIcon(iconoCliente);
        //Se da La ubicacion del texto en el boton
        AgregarCliente.setHorizontalTextPosition( SwingConstants.CENTER );
        AgregarCliente.setVerticalTextPosition( SwingConstants.BOTTOM );
	gb.gridx=0;
	gb.gridy=2;
        gb.weightx=1;
        AgregarCliente.addActionListener(this);
        AgregarCliente.setActionCommand("Agregar Cliente");
	imagenTablero.add(AgregarCliente, gb);
        
       // se ingresa el iono que va en el boton
       ImageIcon iconoFa = new ImageIcon("src/ima/icono/fa.png");
       // Se da las dimenciones del icono que va en el boton
       ImageIcon iconoFactura = new ImageIcon(iconoFa.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        JButton RealizarFactura= new JButton("Realizar Factura");
         //Se agrega el icono al boton
        RealizarFactura.setIcon(iconoFactura);
        //Se da La ubicacion del texto en el boton
        RealizarFactura.setHorizontalTextPosition( SwingConstants.CENTER );
        RealizarFactura.setVerticalTextPosition( SwingConstants.BOTTOM );
	gb.gridx=1;
	gb.gridy=2;
        gb.weightx=1;
        RealizarFactura.addActionListener(this);
        RealizarFactura.setActionCommand("RealizarFactura");
	imagenTablero.add(RealizarFactura, gb);
        
        // se ingresa el iono que va en el boton
       ImageIcon iconoAnu = new ImageIcon("src/ima/icono/anuF.png");
       // Se da las dimenciones del icono que va en el boton
       ImageIcon iconoAnula = new ImageIcon(iconoAnu.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        JButton AnularFactura= new JButton("Anular Factura");
          //Se agrega el icono al boton
        AnularFactura.setIcon(iconoAnula);
        //Se da La ubicacion del texto en el boton
        AnularFactura.setHorizontalTextPosition( SwingConstants.CENTER );
        AnularFactura.setVerticalTextPosition( SwingConstants.BOTTOM );
	gb.gridx=2;
	gb.gridy=2;
        gb.weightx=1;
        AnularFactura.addActionListener(this);
        AnularFactura.setActionCommand("Anular Factura");
        imagenTablero.add(AnularFactura,gb);
        
          // se ingresa el iono que va en el boton
       ImageIcon iconoSal = new ImageIcon("src/ima/icono/sa.png");
       // Se da las dimenciones del icono que va en el boton
       ImageIcon iconoSalir = new ImageIcon(iconoSal.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        JButton Salir= new JButton("Salir");
        
          //Se agrega el icono al boton
        Salir.setIcon(iconoSalir);
        //Se da La ubicacion del texto en el boton
        Salir.setHorizontalTextPosition( SwingConstants.CENTER );
        Salir.setVerticalTextPosition( SwingConstants.BOTTOM );
	gb.gridx=2;
	gb.gridy=3;
        gb.weightx=1;
        Salir.addActionListener(this);
        //Salir.setBackground(Color.red);
        Salir.setActionCommand("Salir");
        imagenTablero.add(Salir,gb);
  
 
cp.add(imagenTablero);
 
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String comando = e.getActionCommand();
        
        switch(comando){
            case "Productos":
                llamarGestionProductos();
                break;
            case "Agregar Empleado":
                llamarAgregarEmpleado();
                break;
            case "Stock":
                listarStock();
                break;
            case "Eliminar Empleado":
                llamarEliminarEmpleado();
                break;
            case "Agregar Cliente":
                llamarAgregarCliente();
                break;
            case "RealizarFactura":
                llamarRealizarFactura();
                break;
            case "Anular Factura":
                AnularFactura();
                break;
             case "ActualizarDatosCliente":
                llamarActualizarDatosCliente();
                break;
            case "Salir":
                llamarSalir();
                break;
            default:
                break;      
        }
        
    }

    private void llamarGestionProductos() {
    VntGestionPro  producto=new VntGestionPro();
               producto.setVisible(true);
               setVisible(false);
    }

    private void llamarAgregarEmpleado() {
         VntEmpleado empleado = new VntEmpleado();
               empleado.setVisible(true);
               setVisible(false);
    }

    private void listarStock() {
   
        VntStock mostar = new VntStock();
               mostar.setVisible(true);
               setVisible(false);
        
    }
    
      private void llamarActualizarDatosCliente() {
        VntActualizarDatosCliente actualizaCli = new VntActualizarDatosCliente();
        actualizaCli.setVisible(true);
        setVisible(false);
   }

    private void llamarEliminarEmpleado() {
        
        VntEliminarEmpleado empleadoElimina = new VntEliminarEmpleado();
               empleadoElimina.setVisible(true);
               setVisible(false);
  
    }

    private void llamarAgregarCliente() {
 VntCliente  cliente=new VntCliente();
               cliente.setVisible(true);
               setVisible(false);
    }

    private void llamarRealizarFactura() {
        VntFactura factura = new VntFactura();
              factura.setVisible(true);
               setVisible(false);
   
    }

    private void AnularFactura() {
      VntAnularFactura  anular=new VntAnularFactura();
               anular.setVisible(true);
               setVisible(false); 
        
        
    }

    private void llamarSalir() {
    VntLogin  login=new VntLogin();
               login.setVisible(true);
               setVisible(false);
    }
    
    
}
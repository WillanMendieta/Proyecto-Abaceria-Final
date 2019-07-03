/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author steve
 */
public class VntGestionPro extends JFrame implements ActionListener {
    
    
     public VntGestionPro(){
    Componentes();
}
      private void Componentes() {
        setTitle("Gestion Producto");
	setSize(1050,670);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       
        Container cp= getContentPane();
        GridBagConstraints gb = new GridBagConstraints();
        
         // AQUI INGRESO LA IMAGEN DE FONDO
       ImageIcon ICONO = new ImageIcon("src/ima/2.gif"); 
       //   ImageIcon icon1 = new ImageIcon(ICONO.getImage().getScaledInstance(WIDTH, HEIGHT, java.awt.Image.SCALE_DEFAULT));
       ICONO.getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_DEFAULT);
       JLabel imagenTablero = new JLabel(ICONO);
       imagenTablero.setLayout(new GridBagLayout());
     
       //Se ingresa los botones
       // se ingresa el iono que va en el boton
       ImageIcon iconoPro = new ImageIcon("src/ima/icono/p.png");
       // Se da las dimenciones del icono que va en el boton
       ImageIcon iconoProducto = new ImageIcon(iconoPro.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
       //se insatancia el boton
       JButton AgregarProducto= new JButton("Agregar Producto");
       //Se agrega el icono al boton
       AgregarProducto.setIcon(iconoProducto);
       //Se da La ubicacion del texto en el boton
        AgregarProducto.setHorizontalTextPosition( SwingConstants.CENTER );
        AgregarProducto.setVerticalTextPosition( SwingConstants.BOTTOM );
	gb.gridx=0;
	gb.gridy=0;
        gb.weightx=1;
        gb.fill=GridBagConstraints.BOTH;
        //se da la accion
        AgregarProducto.addActionListener(this);
        AgregarProducto.setActionCommand("Agregar Producto");
	imagenTablero.add(AgregarProducto, gb);
        
        
        // se ingresa el iono que va en el boton
       ImageIcon iconoEm = new ImageIcon("src/ima/icono/eliPro.png");
       // Se da las dimenciones del icono que va en el boton
       ImageIcon iconoEmple = new ImageIcon(iconoEm.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        JButton EliminarProducto= new JButton("Eliminar Producto");
        //Se agrega el icono al boton
        EliminarProducto.setIcon(iconoEmple);
        //Se da La ubicacion del texto en el boton
        EliminarProducto.setHorizontalTextPosition( SwingConstants.CENTER );
        EliminarProducto.setVerticalTextPosition( SwingConstants.BOTTOM );
	gb.gridx=1;
	gb.gridy=0;
        gb.weightx=1;
        EliminarProducto.addActionListener(this);
        EliminarProducto.setActionCommand("Eliminar Producto");
	imagenTablero.add(EliminarProducto, gb);
        
        // se ingresa el iono que va en el boton
       ImageIcon iconoSto = new ImageIcon("src/ima/icono/s.png");
       // Se da las dimenciones del icono que va en el boton
       ImageIcon iconoStock = new ImageIcon(iconoSto.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        JButton IngresarCompras= new JButton("Ingresar Compras");
        //Se agrega el icono al boton
        IngresarCompras.setIcon(iconoStock);
        //Se da La ubicacion del texto en el boton
        IngresarCompras.setHorizontalTextPosition( SwingConstants.CENTER );
        IngresarCompras.setVerticalTextPosition( SwingConstants.BOTTOM );
       	gb.gridx=2;
	gb.gridy=0;
        gb.weightx=1;
        gb.fill=GridBagConstraints.BOTH;
        IngresarCompras.addActionListener(this);
        IngresarCompras.setActionCommand("IngresarCompras");
	imagenTablero.add(IngresarCompras, gb);
        
         // se ingresa el iono que va en el boton
       ImageIcon iconoEli = new ImageIcon("src/ima/icono/de.png");
       // Se da las dimenciones del icono que va en el boton
       ImageIcon iconoEliminarEmpleado = new ImageIcon(iconoEli.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        JButton Descuentos= new JButton("Descuentos");
        //Se agrega el icono al boton
        Descuentos.setIcon(iconoEliminarEmpleado);
        //Se da La ubicacion del texto en el boton
        Descuentos.setHorizontalTextPosition( SwingConstants.CENTER );
        Descuentos.setVerticalTextPosition( SwingConstants.BOTTOM );
	gb.gridx=1;
	gb.gridy=2;
        gb.weightx=1;
        Descuentos.addActionListener(this);
        Descuentos.setActionCommand("Descuentos");
	imagenTablero.add(Descuentos, gb);
        
        
       // se ingresa el iono que va en el boton
       ImageIcon iconoFa = new ImageIcon("src/ima/icono/pro.png");
       // Se da las dimenciones del icono que va en el boton
       ImageIcon iconoFactura = new ImageIcon(iconoFa.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        JButton ActualizarDatosProducto= new JButton("Actualizar Datos Producto");
         //Se agrega el icono al boton
        ActualizarDatosProducto.setIcon(iconoFactura);
        //Se da La ubicacion del texto en el boton
        ActualizarDatosProducto.setHorizontalTextPosition( SwingConstants.CENTER );
        ActualizarDatosProducto.setVerticalTextPosition( SwingConstants.BOTTOM );
	gb.gridx=0;
	gb.gridy=2;
        gb.weightx=1;
        ActualizarDatosProducto.addActionListener(this);
        ActualizarDatosProducto.setActionCommand("ActualizarDatosProducto");
	imagenTablero.add(ActualizarDatosProducto, gb);
        
        // se ingresa el iono que va en el boton
       ImageIcon iconoAnu = new ImageIcon("src/ima/icono/regr.png");
       // Se da las dimenciones del icono que va en el boton
       ImageIcon iconoAnula = new ImageIcon(iconoAnu.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        JButton Regresar= new JButton("Regresar");
          //Se agrega el icono al boton
        Regresar.setIcon(iconoAnula);
        //Se da La ubicacion del texto en el boton
        Regresar.setHorizontalTextPosition( SwingConstants.CENTER );
        Regresar.setVerticalTextPosition( SwingConstants.BOTTOM );
	gb.gridx=2;
	gb.gridy=2;
        gb.weightx=1;
        Regresar.addActionListener(this);
        Regresar.setActionCommand("Anular Factura");
        imagenTablero.add(Regresar,gb);
  
 
cp.add(imagenTablero);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        
         String comando = e.getActionCommand();
        
        switch(comando){
            case "Agregar Producto":
                llamarAgregarProducto();
                break;
            case "Eliminar Producto":
                llamarEliminarProducto();
                break;
            case "IngresarCompras":
                llamarIngresarCompras();
                break;
            case "Descuentos":
                llamarDescuentos();
                break;
           
            case "ActualizarDatosProducto":
                llamarActualizarDatosProducto();
                break;
            case "Anular Factura":
                Regresar();
                break;
        
            default:
                break;
    
                
        }
        
    }

    private void llamarAgregarProducto() {
        VntAgregarProducto pro = new VntAgregarProducto();
        pro.setVisible(true);
        setVisible(false);
    }

    private void llamarEliminarProducto() {
        VntEliminarProducto pr = new VntEliminarProducto();
        pr.setVisible(true);
        setVisible(false);
    }

    private void llamarIngresarCompras() {
         VntIngresarProducto produ = new VntIngresarProducto();
        produ.setVisible(true);
        setVisible(false);
    }

    private void llamarDescuentos() {
        VntDescuento des = new VntDescuento();
        des.setVisible(true);
        setVisible(false);
   }

  

    private void llamarActualizarDatosProducto() {
        VntActualizarDatosProducto actualizaPro = new VntActualizarDatosProducto();
        actualizaPro.setVisible(true);
        setVisible(false);
    }

    private void Regresar() {
        
        VntMenuPrincipalAdministrador  menu=new VntMenuPrincipalAdministrador();
               menu.setVisible(true);
               setVisible(false);
    }
}

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
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import modelo.Usuario;

/**
 *
 * @author steve
 */
public class VntMenuCliente extends JFrame implements ActionListener {
    Usuario user;
    
      public VntMenuCliente (Usuario usuario){
    Componentes();
    user = usuario;
    
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
	gb.gridy=0;
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
	gb.gridx=1;
	gb.gridy=0;
        gb.weightx=1;
        AgregarCliente.addActionListener(this);
        AgregarCliente.setActionCommand("Agregar Cliente");
	imagenTablero.add(AgregarCliente, gb);
        
        
        
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
	gb.gridy=0;
        gb.weightx=1;
        Regresar.addActionListener(this);
        Regresar.setActionCommand("regresar");
        imagenTablero.add(Regresar,gb);
  
 
 
cp.add(imagenTablero);  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
        switch(comando){
         case "ActualizarDatosCliente":
                llamarActualizarDatosCliente();
                break;
                 case "Agregar Cliente":
                llamarAgregarCliente();
                break;
                
                case "regresar":
                Regresar();
                break;
        }
    }
    
          private void llamarActualizarDatosCliente() {
          actualizarDatosCliente cliV = new actualizarDatosCliente(user);
          cliV.setVisible(true);
              setVisible(false);
          }
          
            private void llamarAgregarCliente() {
                int a = 1;
               VntCliente  cliente=new VntCliente(user,a);
               cliente.setVisible(true);
               setVisible(false);
    }
            
              private void Regresar() {
        VntMenuPrincipalAdministrador  menu=new VntMenuPrincipalAdministrador(user);
               menu.setVisible(true);
               setVisible(false);
    }
    
}

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
public class VntMenuEmpleado extends JFrame implements ActionListener{
    
    Usuario user;
    
      public VntMenuEmpleado(Usuario usuario){
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
       ImageIcon iconoEm = new ImageIcon("src/ima/icono/e.png");
       // Se da las dimenciones del icono que va en el boton
       ImageIcon iconoEmple = new ImageIcon(iconoEm.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        JButton AgregarEmpleado= new JButton("Agregar Empleado");
        //Se agrega el icono al boton
        AgregarEmpleado.setIcon(iconoEmple);
        //Se da La ubicacion del texto en el boton
        AgregarEmpleado.setHorizontalTextPosition( SwingConstants.CENTER );
        AgregarEmpleado.setVerticalTextPosition( SwingConstants.BOTTOM );
	gb.gridx=0;
	gb.gridy=0;
        gb.weightx=1;
        AgregarEmpleado.addActionListener(this);
        AgregarEmpleado.setActionCommand("Agregar Empleado");
	imagenTablero.add(AgregarEmpleado, gb);
        
        // se ingresa el iono que va en el boton
       ImageIcon iconoAc = new ImageIcon("src/ima/icono/e.png");
       // Se da las dimenciones del icono que va en el boton
       ImageIcon iconoAct = new ImageIcon(iconoAc.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_DEFAULT));
        JButton ActualizarEmpleado= new JButton("Actualizar Datos Empleados");
        //Se agrega el icono al boton
        ActualizarEmpleado.setIcon(iconoEmple);
        //Se da La ubicacion del texto en el boton
        ActualizarEmpleado.setHorizontalTextPosition( SwingConstants.CENTER );
        ActualizarEmpleado.setVerticalTextPosition( SwingConstants.BOTTOM );
	gb.gridx=1;
	gb.gridy=0;
        gb.weightx=1;
        ActualizarEmpleado.addActionListener(this);
        ActualizarEmpleado.setActionCommand("ActualizarEmpleado");
	imagenTablero.add( ActualizarEmpleado, gb);
        
        
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
	gb.gridx=2;
	gb.gridy=0;
        gb.weightx=1;
        EliminarEmpleado.addActionListener(this);
        EliminarEmpleado.setActionCommand("Eliminar Empleado");
	imagenTablero.add(EliminarEmpleado, gb);
        
        
        
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
	gb.gridx=3;
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
           
            case "Agregar Empleado":
                llamarAgregarEmpleado();
                break;
        
         case "Eliminar Empleado":
                llamarEliminarEmpleado();
                break;
          case "ActualizarEmpleado":
                llamarActualizarEmpleado();
                break;
        case "regresar":
                Regresar();
                break;
               
    }
    }
     private void llamarAgregarEmpleado() {
         VntEmpleado empleado = new VntEmpleado(user);
               empleado.setVisible(true);
               setVisible(false);
    }
     
    private void llamarEliminarEmpleado() {
        
        VntEliminarEmpleado empleadoElimina = new VntEliminarEmpleado(user);
               empleadoElimina.setVisible(true);
               setVisible(false);
  
    }
    
      private void Regresar() {
        String u = null;
        VntMenuPrincipalAdministrador  menu=new VntMenuPrincipalAdministrador(user);
               menu.setVisible(true);
               setVisible(false);
    }

    private void llamarActualizarEmpleado() {
   VntActualizarDatosEmpleado empleadoActualiza = new VntActualizarDatosEmpleado(user);
               empleadoActualiza.setVisible(true);
               setVisible(false);
    
    }
    
}

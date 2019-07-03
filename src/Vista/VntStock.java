/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author steve
 */
public class VntStock extends JFrame implements ActionListener{
    
    public VntStock(){
        componentes();
    }

    private void componentes() {
    
    setTitle("Eliminar Empleado");
        
	setSize(550,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container cp= getContentPane();
        setLocationRelativeTo(null);
        
        
        ImageIcon ICONO = new ImageIcon("src/ima/ingif"); 
        JLabel imagenFondo = new JLabel(ICONO);
        imagenFondo.setLayout(new java.awt.GridBagLayout());
        
        GridBagConstraints gb = new GridBagConstraints();
        
        TextArea area1= new TextArea(30,40);
        gb.gridx=0;
	gb.gridy=0;
        imagenFondo.add(area1, gb);
        
        JButton buscarBoton= new JButton("Regresar");
	gb.gridx=0;
	gb.gridy=1;
	gb.gridwidth=1;
        buscarBoton.addActionListener(this);
        buscarBoton.setActionCommand("regresar");
	imagenFondo.add(buscarBoton, gb);
        cp.add(imagenFondo);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
          switch(comando){
              case "regresar":
                Regresar();
                break;
        
            default:
                break;
    }}
    
        private void Regresar() {
        VntMenuPrincipalAdministrador  menu=new VntMenuPrincipalAdministrador();
               menu.setVisible(true);
               setVisible(false);
    
    } 
    
}

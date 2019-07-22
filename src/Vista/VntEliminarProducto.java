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
import modelo.*;
import Conexion.*;
import Controlador.*;
/**
 *
 * @author steve
 */
public class VntEliminarProducto extends JFrame implements ActionListener {
    private JTextField codigo;
    private JTextField nombre;
    private JTextField detalles;
    Usuario user;
    ControlProducto controlPro ;
    conexionDB con = new conexionDB();
    
    public VntEliminarProducto(Usuario usuario){
        componentes();
        user = usuario;
        controlPro = new ControlProducto();
        
    }

    private void componentes() {
            
             
        setTitle("Deshabilitar un Producto");
        
	setSize(720,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container cp= getContentPane();
        setLocationRelativeTo(null);
        
        
        ImageIcon ICONO = new ImageIcon("src/ima/iif"); 
        JLabel imagenFondo = new JLabel(ICONO);
        imagenFondo.setLayout(new java.awt.GridBagLayout());
        
        GridBagConstraints gb = new GridBagConstraints();
        
        //Etiquetas para el la ventana login
        
        JLabel nombreJ = new JLabel("Nombre:");
	gb.gridx=0;
	gb.gridy=0;
        nombreJ.setForeground(Color.red);
	imagenFondo.add(nombreJ, gb);
        
        // Espacio en blanco para el reibimiento del usuario
        nombre= new JTextField(20);
	gb.gridx=1;
	gb.gridy=0;
	imagenFondo.add(nombre, gb);
        
        JButton buscarBoton= new JButton("Buscar por Nombre");
	gb.gridx=2;
	gb.gridy=0;
	gb.gridwidth=1;
        buscarBoton.addActionListener(this);
        buscarBoton.setActionCommand("buscar");
	imagenFondo.add(buscarBoton, gb);
        
        
        JButton consultarPro= new JButton("Consultar Productos");
	gb.gridx=3;
	gb.gridy=0;
	gb.gridwidth=1;
        consultarPro.addActionListener(this);
        consultarPro.setActionCommand("consultar");
	imagenFondo.add(consultarPro, gb);
        
        
        //Etiqueta con el anunciasdo de contraseña
        JLabel codigoJ = new JLabel("Codigo:");
	gb.gridx=0;
	gb.gridy=1;
        codigoJ.setForeground(Color.red);
	imagenFondo.add(codigoJ, gb);
        //Esaco en blanco para ingresar la contraseña
        codigo = new JTextField(20);
	gb.gridx=1;
	gb.gridy=1;
	imagenFondo.add(codigo, gb);
        
        JButton buscarCodigo= new JButton("Buscar por Codigo");
	gb.gridx=2;
	gb.gridy=1;
	gb.gridwidth=1;
        buscarCodigo.addActionListener(this);
        buscarCodigo.setActionCommand("buscaCodigo");
	imagenFondo.add(buscarCodigo, gb);
        
        
        
        //Etiqueta con el anunciasdo de contraseña
        JLabel detallesJ = new JLabel("Detalles de la Deshabilitacion:");
	gb.gridx=0;
	gb.gridy=2;
        detallesJ.setForeground(Color.red);
	imagenFondo.add(detallesJ, gb);
        //Esaco en blanco para ingresar la contraseña
        detalles = new JTextField(20);
	gb.gridx=1;
	gb.gridy=2;
	imagenFondo.add(detalles, gb);
        
        JPanel panelBotones = new JPanel();
        
        //boton de Anular 
        JButton eliminar= new JButton("Deshabilitar");
	gb.gridx=0;
	gb.gridy=0;
	gb.gridwidth=1;
        eliminar.addActionListener(this);
        eliminar.setActionCommand("eliminar");
	panelBotones.add(eliminar, gb);
        
        //boton de Cancelar
        JButton cancelar= new JButton("Cancelar");
	gb.gridx=1;
	gb.gridy=0;
	gb.gridwidth=1;
        cancelar.addActionListener(this);
        cancelar.setActionCommand("cancelar");
	panelBotones.add(cancelar, gb);
        
        panelBotones.setBackground(Color.red);
        gb.gridx=1;
	gb.gridy=3;
       imagenFondo.add(panelBotones,gb);
        
        cp.add(imagenFondo);


//Metodo para recibir acciones del boton
  
}

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
          switch(comando){
           case"eliminar":
           llamarMetodoEliminar();
           break;
           case "buscar":
                verificarProducto();
                break;
           
          case "cancelar":
                Regresar();
                break;
          case "consultar":
                consultar();
              break;
          case "buscaCodigo":
              buscarCodigo();
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
    


    private void llamarMetodoEliminar() {
        try {
         String estado = "I";
        String codP = codigo.getText();
        String desP = detalles.getText();
        int codPP = Integer.parseInt(codP);
        con.Conectar();
        controlPro.eliminarProducto(con, estado, codPP, desP);
        con.CerrarConexion();
        javax.swing.JOptionPane.showMessageDialog(null, "Producto Deshabilitado", "Exito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    
            
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error de Eliminacion", "Error de Campos", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    
        }
        
   
    }

    private void verificarProducto() {
        Producto pro = new Producto();
        String nombreP = nombre.getText();
        con.Conectar();
        pro = controlPro.buscaProductoNombre(con, nombreP);
        con.CerrarConexion();
        int cod = pro.getId();
        System.out.println(cod);
        if(cod != 0){
            String codS = Integer.toString(cod);
            codigo.setText(codS);
        }else{
            javax.swing.JOptionPane.showMessageDialog(null, "Producto no encontrado", "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
    
        }        
    }

    private void consultar() {
        int a = 4;
        VntStockConsultar stock = new VntStockConsultar(user, a);
        stock.setVisible(true);
        setVisible(false);
    }

    private void buscarCodigo() {
        Producto pro = new Producto();
        String codigoP = codigo.getText();
        int cod = Integer.parseInt(codigoP);
        con.Conectar();
        pro = controlPro.buscarProducto(con, cod);
        con.CerrarConexion();
        nombre.setText(pro.getNombre());
    }
}
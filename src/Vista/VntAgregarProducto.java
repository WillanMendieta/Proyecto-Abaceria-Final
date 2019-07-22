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
import modelo.*;
import Conexion.*;
import Controlador.*;


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
    private JLabel verMensaje;
    
    Usuario user;
    conexionDB con = new conexionDB();
    ControlProducto controlPro ;
    ListadoProductos ver ;
   static boolean verIVA;
    
    
    
    
    public VntAgregarProducto(Usuario usuario){
        componentes();
        user = usuario;
        controlPro = new ControlProducto();
        
         con.Conectar();
        for (Categoria cate : controlPro.ListaCategoria(con) ){
            System.out.println("Nombre la categoria: " + cate);
            categoria.addItem(cate.getNombre());
        }
        con.CerrarConexion();
        
    }

    private void componentes() {
      setTitle("Agregar Producto");
        
	setSize(650,500);
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
        
        
        JLabel ver = new JLabel("¿No encuentra la Categoria? Agregelo");
	gb.gridx=2;
	gb.gridy=1;
        ver.setForeground(Color.red);
	imagenFondo.add(ver, gb);
        
        
        
        //Etiqueta con el anunciado de los apellidos
        JLabel categoriaJ = new JLabel("Categoria:");
	gb.gridx=0;
	gb.gridy=2;
        categoriaJ.setForeground(Color.red);
	imagenFondo.add(categoriaJ, gb);
        //Espacio en blanco para ingresar los apellidos
        categoria= new JComboBox();
	gb.gridx=1;
	gb.gridy=2;
	imagenFondo.add(categoria, gb);
        
        
        JButton catA = new JButton("Agregar Categoria");
	gb.gridx=2;
	gb.gridy=2;
        catA.addActionListener(this);
        catA.setActionCommand("catA");
        imagenFondo.add(catA, gb);
        
        
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
        
       
        JPanel panelConfirmar = new JPanel();
        
        JButton consultar= new JButton("Consultar Productos Actuales");
	gb.gridx=0;
	gb.gridy=0;
        consultar.addActionListener(this);
        consultar.setActionCommand("consulta");
	panelConfirmar.add(consultar, gb);
        
        verMensaje = new JLabel("");
        gb.gridx=1 ;
        gb.gridy=1;
        panelConfirmar.add(verMensaje);
        
        gb.gridx=1;
        gb.gridy=6;
        imagenFondo.add(panelConfirmar, gb);
        
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
                      verIVA = true;
                      
                  } else if (ivaTex.isSelected()==false){
                      verIVA = false;
              }
                  break;
                  
              case "catA":
                  agregarCategoria();
                  break;
                  
              case "consulta":
                  consultarPro();
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
        verMensaje.setText("");
        
        Categoria mandaCat = new Categoria();
        String cat = categoria.getSelectedItem().toString();
        con.Conectar();
        mandaCat = controlPro.buscaCategoriaNombre(con, cat);
        con.CerrarConexion();
        
        
        if (verIVA == true){
            try {
                String cod = codigo.getText();
            String pre = precioTex.getText();
            
            int codd = Integer.parseInt(cod);
            String nom = nombre.getText();
            int des = 0;
            double pree = Double.parseDouble(pre);
            int stock =0;
            String iva = "I";
            int catnom = mandaCat.getId();
            String estado = "A";
            String tipo = "N";
            String descrip = "";
            
            
            con.Conectar();
            controlPro.agregarProductoNuevo(con, codd, nom, des, pree, stock, iva, catnom, estado, tipo, descrip);
            
            con.CerrarConexion();
            verMensaje.setText("Producto Agregado Exitosamente (I)");
                
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Campo codigo no puede ser nulo", "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
    
            }
            
            
        }else if(verIVA == false){
            try {
                String cod = codigo.getText();
            String pre = precioTex.getText();
            
            int codd = Integer.parseInt(cod);
            String nom = nombre.getText();
            int des = 0;
            double pree = Double.parseDouble(pre);
            int stock =0;
            String iva = "I";
            int catnom = mandaCat.getId();
            String estado = "A";
            String tipo = "N";
            String descrip = "";
            
            
            con.Conectar();
            controlPro.agregarProductoNuevo(con, codd, nom, des, pree, stock, iva, catnom, estado, tipo, descrip);
            
            con.CerrarConexion();
            verMensaje.setText("Producto Agregado Exitosamente (S)");
            
            codigo.setText("");
            nombre.setText("");
            precioTex.setText("");
            
                
            } catch (Exception e) {
                 javax.swing.JOptionPane.showMessageDialog(null, "Campo codigo no puede ser nulo", "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
    
            }
            
        }else{
            System.out.println("mandar mensaje de que debe esatblecer un valor a iva ");
        }
        
    }

    private void agregarCategoria() {
        
        VntCategoria verCat = new VntCategoria(user);
        verCat.setVisible(true);
        setVisible(false);
        
    }

    private void consultarPro() {
         int a = 3;
        VntStockConsultar consultar = new VntStockConsultar(user, a);
        consultar.setVisible(true);
        setVisible(false);
         
    
    
    
    }
    
}

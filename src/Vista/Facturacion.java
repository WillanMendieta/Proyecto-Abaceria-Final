package Vista;

import Conexion.*;
import Controlador.*;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.*;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Facturacion extends javax.swing.JFrame {

    DefaultTableModel dtm;
    Object[] o = new Object[7];
    int filaSeleccionada = -1;
    
     Usuario user;
    ControlPersona controlPer ;
    ControlProducto controlPro;
    ControlFactura controlFac;
    conexionDB con = new conexionDB();
    int idClienteGeneral;
    int idProductoGeneral;
  //  private static DecimalFormat df2 = new DecimalFormat("#.00");
    
    DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
    DecimalFormat df = new DecimalFormat();
    
    
    
     SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
    
    
    public Facturacion(Usuario usuario) {
        initComponents();
        user = usuario;
        controlPer = new ControlPersona();
        controlPro = new ControlProducto();
        controlFac = new ControlFactura();
        setTitle("Manipular JTable");
        setLocationRelativeTo(null);
        dtm = (DefaultTableModel) tUsuario.getModel();
        simbolos.setDecimalSeparator('.');
        df = new DecimalFormat("#.00", simbolos);
        
        
        con.Conectar();
        int codigoSeteo = controlFac.codigoFacturaCabecera(con);
        int codActual = codigoSeteo +1;
        con.CerrarConexion();
        String codSeteo = Integer.toString(codActual);
        
        jTextFacturadorNombre.setText(user.getNombre() +"  " + user.getApellido());
        jTextCodigoFact.setText(codSeteo);
        
        jTextFacturadorNombre.setBackground(new Color(230,230,250));
        jTextCodigoFact.setBackground(new Color(230,230,250));
        jTextFechaEmision.setBackground(new Color(230,230,250));
        jTextIVAFac.setBackground(new Color(230,230,250));
        jTextSubtotalFac.setBackground(new Color(230,230,250));
        jTextTotalFac.setBackground(new Color(230,230,250));
        
        //cambio de color a los campos de cliente
        jTextCedula.setBackground(new Color(230,230,250));
        jTextNombre.setBackground(new Color(230,230,250));
        jTextApellido.setBackground(new Color(230,230,250));
        jTextConvencional.setBackground(new Color(230,230,250));
        jTextCelular.setBackground(new Color(230,230,250));
        
        jTextIVAFac.setText("12");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tUsuario = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        botonBuscarporCedula = new javax.swing.JButton();
        botonCobrar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        BuscarProducto = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jTextCodigoFact = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextFechaEmision = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextFacturadorNombre = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextCedula = new javax.swing.JTextField();
        jTextNombre = new javax.swing.JTextField();
        jTextApellido = new javax.swing.JTextField();
        jTextConvencional = new javax.swing.JTextField();
        jTextCelular = new javax.swing.JTextField();
        jTextCodigoPro = new javax.swing.JTextField();
        jTextNombrePro = new javax.swing.JTextField();
        jTextCantidadPro = new javax.swing.JTextField();
        jTextSubtotalFac = new javax.swing.JTextField();
        jTextIVAFac = new javax.swing.JTextField();
        jTextTotalFac = new javax.swing.JTextField();
        botonBuscarporNombre = new javax.swing.JButton();
        agregarCliente = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        CalcularTotal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Cantidad", "Valor Unitario", "Descuento", "I.V.A", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tUsuario.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(tUsuario);
        if (tUsuario.getColumnModel().getColumnCount() > 0) {
            tUsuario.getColumnModel().getColumn(0).setPreferredWidth(50);
            tUsuario.getColumnModel().getColumn(1).setPreferredWidth(150);
            tUsuario.getColumnModel().getColumn(2).setPreferredWidth(50);
            tUsuario.getColumnModel().getColumn(3).setPreferredWidth(100);
            tUsuario.getColumnModel().getColumn(4).setPreferredWidth(75);
            tUsuario.getColumnModel().getColumn(5).setPreferredWidth(25);
            tUsuario.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setText("Agregar Producto");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Codigo:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Cantidad:");

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDelete.setText("Eliminar Producto");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSearch.setText("Modificar Cantidad");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Cedula:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Nombre");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Apellido");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Tel.Convencional");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setText("Tel. Celular");

        botonBuscarporCedula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonBuscarporCedula.setText("Buscar por Cedula");
        botonBuscarporCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarporCedulaActionPerformed(evt);
            }
        });

        botonCobrar.setText("Cobrar");
        botonCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCobrarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));
        jLabel16.setText("Facturación");
        jLabel16.setToolTipText("");
        jLabel16.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("Datos Cliente:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));
        jLabel18.setText("Datos del Producto:");

        BuscarProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BuscarProducto.setText("Buscar por Codigo");
        BuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarProductoActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 255));
        jLabel19.setText("Codigo de Factura:");

        jTextCodigoFact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("I.V.A:");

        jTextFechaEmision.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 255));
        jLabel22.setText("Fecha de Emisión:");

        jTextFacturadorNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 255));
        jLabel23.setText("Facturador:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Subtotal:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Total:");

        jTextCedula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextApellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextConvencional.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextCelular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextCodigoPro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextNombrePro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextCantidadPro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextSubtotalFac.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextIVAFac.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextTotalFac.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        botonBuscarporNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonBuscarporNombre.setText("Buscar por Nombre");
        botonBuscarporNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarporNombreActionPerformed(evt);
            }
        });

        agregarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        agregarCliente.setText("Agregar Nuevo Cliente");
        agregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarClienteActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Buscar por Nombre");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Si el cliente es nuevo -->");

        CalcularTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CalcularTotal.setText("Calcular");
        CalcularTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcularTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(847, 847, 847)
                        .addComponent(jLabel14))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jTextCodigoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addComponent(jLabel2))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(jTextNombrePro, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextCantidadPro, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(BuscarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(10, 10, 10)
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel17)
                                                .addGap(280, 280, 280)
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel8))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jTextApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))
                                                .addGap(51, 51, 51)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(botonBuscarporCedula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(botonBuscarporNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jTextCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(jLabel7)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jTextConvencional, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(47, 47, 47)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23)
                                            .addComponent(jLabel19)
                                            .addComponent(jLabel22))))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel9)
                                .addGap(24, 24, 24)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFacturadorNombre)
                            .addComponent(jTextCodigoFact)
                            .addComponent(jTextFechaEmision)
                            .addComponent(agregarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(18, 18, 18)
                                .addComponent(jTextSubtotalFac, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel25))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextIVAFac)
                                    .addComponent(jTextTotalFac, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)))
                            .addComponent(CalcularTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19)
                    .addComponent(jTextCodigoFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(botonBuscarporCedula)
                                    .addComponent(jTextCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonBuscarporNombre)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(jTextFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jTextFacturadorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(agregarCliente)
                                    .addComponent(jLabel9))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextConvencional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(jButton1))
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BuscarProducto)
                    .addComponent(btnAdd)
                    .addComponent(btnSearch)
                    .addComponent(jTextCodigoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNombrePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextCantidadPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(jTextSubtotalFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jTextIVAFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jTextTotalFac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel14)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CalcularTotal))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
        if(jTextCodigoPro.getText().isEmpty() || jTextNombrePro.getText().isEmpty() || jTextCantidadPro.getText().isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(null, "Complete los Campos de Producto", "Sin Completar", javax.swing.JOptionPane.INFORMATION_MESSAGE);
     
        }else{
            int verificar = Integer.parseInt(jTextCantidadPro.getText());
            if(verificar <= 0){
                javax.swing.JOptionPane.showMessageDialog(null, "Error en la Cantidad", "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
     
                
            }else{
            
            Producto pro = new Producto();
            con.Conectar();
            pro = controlPro.buscarProducto(con, idProductoGeneral);
            con.CerrarConexion();
            if(pro.getEstado().equalsIgnoreCase("I")){
                javax.swing.JOptionPane.showMessageDialog(null, "Producto No disponible", "Error", javax.swing.JOptionPane.WARNING_MESSAGE);

            }else{
                
            
            
            int stoo = pro.getStock();
            int verCant = Integer.parseInt(jTextCantidadPro.getText());
            double unitario = pro.getPrecio();
            
            String unitaMostrar = String.valueOf(unitario);
            String des = Integer.toString(pro.getDescuento());
            
            if(stoo >= verCant){
                
                
                String montoDes="";
                String MostotalConIvaDes="";
                String MostotalSinIvaNiDes ="";
                
                double totalDesc =0;
                
                double acum = (verCant *  unitario);
                System.out.println("Cantidad con precio Uni: " + acum);
                String MosAcu = String.valueOf(df.format(acum));
                
                
                
                if(pro.getDescuento() != 0){
                    double acumDes = (pro.getDescuento() / 100d);
                    double acumTotal = (acum * acumDes);
                    totalDesc = (acum - acumTotal);
                    
                     montoDes = String.valueOf(df.format(totalDesc));
                }
                if(pro.getIdentificarIVA().equalsIgnoreCase("I")){
                    System.out.println("valor unico con cantidad: " + acum);
                    System.out.println("valor con descuento: "+ totalDesc);
                    double totalConIva = (totalDesc * 12)/100d;
                    System.out.println("iva con des : " + totalConIva);
                    double valorTotalConIva =(totalDesc + totalConIva);
                    System.out.println("sumando el iva con el total desc: " + valorTotalConIva);
                    
                    double totalSinIva = (acum*12)/100d;
                    double totalTotal =(acum + totalSinIva);
                    
                   // MostotalConIvaDes = String.valueOf(valorTotalConIva);
                    MostotalConIvaDes = String.valueOf(df.format(valorTotalConIva));
                    
                    MostotalSinIvaNiDes = String.valueOf(df.format(totalTotal));
                }
                
                
                o[0] = jTextCodigoPro.getText();
                o[1] = jTextNombrePro.getText();
                o[2] = jTextCantidadPro.getText();
                o[3] = unitaMostrar;
                o[4] = des;
                o[5] = pro.getIdentificarIVA();
                if(pro.getDescuento() != 0 && pro.getIdentificarIVA().equalsIgnoreCase("I")){
                    o[6] = MostotalConIvaDes;
                    
                }else if(pro.getDescuento() != 0 && pro.getIdentificarIVA().equalsIgnoreCase("S")){
                    o[6] = montoDes;
                
                }else if(pro.getDescuento() == 0 && pro.getIdentificarIVA().equalsIgnoreCase("I")){
                    o[6] = MostotalSinIvaNiDes;
                    
                }else if(pro.getDescuento() == 0 && pro.getIdentificarIVA().equalsIgnoreCase("S")){
                    o[6] = MosAcu;
                    
                }
                dtm.addRow(o);
                for (int i = 0; i < o.length; i++) {
                    o[i] = "";
                }
                System.out.println("1  " +MostotalConIvaDes);
                System.out.println("2  " +montoDes);
                System.out.println("3  " + MostotalSinIvaNiDes);
                System.out.println("4  "+ MosAcu);
                limpiar();
                
            }else{
                javax.swing.JOptionPane.showMessageDialog(null, "Stock Insuficiente para " + pro.getNombre(), "Stock Maximo: " + pro.getStock(), javax.swing.JOptionPane.INFORMATION_MESSAGE);
     
            }
            
            }
            }
           
            
        }
        
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (tUsuario.getSelectedRow() != -1) {
            dtm.removeRow(tUsuario.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(null, "No has seleccionado un registro");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        filaSeleccionada = tUsuario.getSelectedRow();
        if (filaSeleccionada != -1) {
            limpiar();
            jTextCodigoPro.setText(tUsuario.getValueAt(filaSeleccionada, 0).toString());
            jTextNombrePro.setText(tUsuario.getValueAt(filaSeleccionada, 1).toString());
            jTextCantidadPro.setText(tUsuario.getValueAt(filaSeleccionada, 2).toString());
        } else {
            JOptionPane.showMessageDialog(null, "No has seleccinado una fila");
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void botonBuscarporCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarporCedulaActionPerformed
       Cliente per = new Cliente();
        jTextNombre.setText("");
         con.Conectar();
        per = controlPer.buscarCliente(con, jTextCedula.getText(), jTextNombre.getText());
        con.CerrarConexion();
        
        System.out.println("entra");
        if(jTextCedula.getText().isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(null, "Campo Cedula Vacio", "Error de Campos", javax.swing.JOptionPane.WARNING_MESSAGE);
    
        }else{
            
            try {
                if(per.getCargo().equalsIgnoreCase("C")){
                    idClienteGeneral = per.getId();
                    
                    jTextCedula.setText(per.getCedula());
                    jTextNombre.setText(per.getNombre());
                    jTextApellido.setText(per.getApellido());
                    jTextConvencional.setText(per.getTelefonoConvencional());
                    jTextCelular.setText(per.getTelefonoCelular());
                
            
        }else if(per.getCargo().equalsIgnoreCase("A")){
            javax.swing.JOptionPane.showMessageDialog(null, "Cliente no Encontrado", "Error de Busqueda", javax.swing.JOptionPane.WARNING_MESSAGE);
     
        }else if(per.getCargo().equalsIgnoreCase("E")){
            javax.swing.JOptionPane.showMessageDialog(null, "Cliente no Encontrado", "Error de Busqueda", javax.swing.JOptionPane.WARNING_MESSAGE);
     
        }
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Cliente no Encontrado", "Error de Busqueda", javax.swing.JOptionPane.WARNING_MESSAGE);
    
            }
        }


    }//GEN-LAST:event_botonBuscarporCedulaActionPerformed

    
    
    private void botonCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCobrarActionPerformed
        
        if( jTextTotalFac.getText().isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(null, "Sin Datos a Facturar", "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
                  
        }else if(jTextCedula.getText().isEmpty() || jTextNombre.getText().isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(null, "Datos del Cliente Nulos", "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
            
        }else if(jTextFechaEmision.getText().isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(null, "Sin Fecha de Emision", "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
            
        }else{
            double verificar = Double.parseDouble(jTextTotalFac.getText());
            if(verificar == 0){
                javax.swing.JOptionPane.showMessageDialog(null, "Sin Datos a Facturar", "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
            }else {
                
                double subtotalCab = Double.parseDouble(jTextSubtotalFac.getText());
                double ivaCab = Double.parseDouble(jTextIVAFac.getText());
                double totalCab = Double.parseDouble(jTextTotalFac.getText());
                String estadoCab = "D";
                String descripcionCab ="";
                
                Cliente cli = new Cliente();
                con.Conectar();
                cli = controlPer.buscarCliente(con, jTextCedula.getText(), jTextNombre.getText());
                con.CerrarConexion();
                
                con.Conectar();
                controlFac.InsertaFacturaCabecera(con, jTextCodigoFact.getText() , jTextFechaEmision.getText(), subtotalCab, ivaCab, totalCab, estadoCab, descripcionCab, user.getId(), cli.getId());
                con.CerrarConexion();
                
                FacturaCabecera facCab = new FacturaCabecera();
                con.Conectar();
                facCab = controlFac.buscarCodigoFacCab(con, jTextCodigoFact.getText());
                con.CerrarConexion();
                
               // int idCab = facCab.getId();
                int idCab = Integer.parseInt(jTextCodigoFact.getText());
                
                /*
                con.Conectar();
                int idDetalle = controlFac.conteoIdDetalle(con);
                con.CerrarConexion();
                */
                
        FacturaDetalle detFac;
         for (int i = 0; i < tUsuario.getRowCount(); i++) {
              detFac = new FacturaDetalle();
           // detFac.setId(idDetalle);
            detFac.setCantidad( Integer.parseInt( String.valueOf (tUsuario.getValueAt(i, 2))));
            detFac.setPrecioUnitario(Double.parseDouble( String.valueOf (tUsuario.getValueAt(i, 3))));
            detFac.setSubTotal(Double.parseDouble( String.valueOf (tUsuario.getValueAt(i, 6))));
            detFac.setIdPro( Integer.parseInt( String.valueOf (tUsuario.getValueAt(i, 0))));
            controlFac.addFacturaDetalle(detFac);
             System.out.println("datos mirarr< <.<. " + detFac);
            con.Conectar();
                    try {
                        controlFac.agregarDetalleFac(con ,detFac.getCantidad(), detFac.getPrecioUnitario(), detFac.getSubTotal(), idCab, detFac.getIdPro());
                    } catch (SQLException ex) {
                        Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
                    }
            con.CerrarConexion();
        } 
                
             javax.swing.JOptionPane.showMessageDialog(null, "Facturacion Realizada", "Completado", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                Facturacion fac = new Facturacion(user);
                fac.setVisible(true);   
                
        }
        }
        
        
        // METODO DE RESPALDO
                /*
        System.out.println(" entra 1");
      //  filaSeleccionada = tUsuario.getSelectedRow();
        System.out.println("2");
         for (int i = 0; i < tUsuario.getRowCount(); i++) {
            System.out.println("Registro número: "+i);
            System.out.println("ID: "+tUsuario.getValueAt(i, 0));
            System.out.println("NOMBRE: "+tUsuario.getValueAt(i, 1));
            System.out.println("CANTIDAD: "+tUsuario.getValueAt(i, 2));
                }
            
*/

    }//GEN-LAST:event_botonCobrarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
       
       VntMenuPrincipalAdministrador menu = new VntMenuPrincipalAdministrador(user);
       menu.setVisible(true);
        setVisible(false);
       
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonBuscarporNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarporNombreActionPerformed
        Cliente per = new Cliente();
        jTextCedula.setText("");
         con.Conectar();
        per = controlPer.buscarCliente(con, jTextCedula.getText(), jTextNombre.getText());
        con.CerrarConexion();
        
        if(jTextNombre.getText().isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(null, "Campo Nombre Vacio", "Error de Campos", javax.swing.JOptionPane.WARNING_MESSAGE);
    
        }else{
            
            try {
                if(per.getCargo().equalsIgnoreCase("C")){
                    idClienteGeneral = per.getId();
                    jTextCedula.setText(per.getCedula());
                    jTextNombre.setText(per.getNombre());
                    jTextApellido.setText(per.getApellido());
                    jTextConvencional.setText(per.getTelefonoConvencional());
                    jTextCelular.setText(per.getTelefonoCelular());
            
        }else if(per.getCargo().equalsIgnoreCase("A")){
            javax.swing.JOptionPane.showMessageDialog(null, "Cliente no Encontrado", "Error de Busqueda", javax.swing.JOptionPane.WARNING_MESSAGE);
     
        }else if(per.getCargo().equalsIgnoreCase("E")){
            javax.swing.JOptionPane.showMessageDialog(null, "Cliente no Encontrado", "Error de Busqueda", javax.swing.JOptionPane.WARNING_MESSAGE);
     
        }
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Cliente no Encontrado", "Error de Busqueda", javax.swing.JOptionPane.WARNING_MESSAGE);
    
            }
        }
    }//GEN-LAST:event_botonBuscarporNombreActionPerformed

    private void agregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarClienteActionPerformed
        int a = 2;
        VntCliente cli = new VntCliente(user, a);
        cli.setVisible(true);
        setVisible(false);
        
        
    }//GEN-LAST:event_agregarClienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jTextNombrePro.getText().isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(null, "Campo vacio", "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
            
        }else{
        
        jTextCodigoPro.setText("");
        Producto pro = new Producto();
        String nombreP = jTextNombrePro.getText();
        con.Conectar();
        pro = controlPro.buscaProductoNombre(con, nombreP);
        con.CerrarConexion();
        
        idProductoGeneral = pro.getId();
        
        int cod = pro.getId();
        if(cod != 0){
            String codS = Integer.toString(cod);
            jTextCodigoPro.setText(codS);
        }else{
            javax.swing.JOptionPane.showMessageDialog(null, "Producto no encontrado", "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
    
        }      
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarProductoActionPerformed
        
        if(jTextCodigoPro.getText().isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(null, "Campo vacio", "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
    
            
        }else{
            try {
                 jTextNombrePro.setText("");
        Producto pro = new Producto();
          String codigoP = jTextCodigoPro.getText();
        int cod = Integer.parseInt(codigoP);
        con.Conectar();
        pro = controlPro.buscarProducto(con, cod);
        con.CerrarConexion();
        
        idProductoGeneral = pro.getId();
        
        if(pro.getId() == cod){
            jTextNombrePro.setText(pro.getNombre());
        }else{
            javax.swing.JOptionPane.showMessageDialog(null, "Producto no encontrado", "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
    
        }      
                
            } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Producto no encontrado", "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
    
            }
       
        }
        
        
    }//GEN-LAST:event_BuscarProductoActionPerformed

    private void CalcularTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularTotalActionPerformed
        double subtotalCab=0;
        double totalcab=0;
        FacturaDetalle detFac;
         for (int i = 0; i < tUsuario.getRowCount(); i++) {
              detFac = new FacturaDetalle();
            detFac.setId(i+1);
            detFac.setCantidad( Integer.parseInt( String.valueOf (tUsuario.getValueAt(i, 2))));
            detFac.setPrecioUnitario(Double.parseDouble( String.valueOf (tUsuario.getValueAt(i, 3))));
            detFac.setSubTotal(Double.parseDouble( String.valueOf (tUsuario.getValueAt(i, 6))));
            detFac.setIdPro( Integer.parseInt( String.valueOf (tUsuario.getValueAt(i, 0))));
            
            controlFac.addFacturaDetalle(detFac);
            subtotalCab =(subtotalCab + detFac.getSubTotal());
        }
         System.out.println("total esss: " + subtotalCab);
         
         double acumcab = (subtotalCab * 12)/100d;
         totalcab = (acumcab +subtotalCab);
         System.out.println("total cab es: " + totalcab);
         
         jTextSubtotalFac.setText(df.format(subtotalCab));
         jTextIVAFac.setText("12");
         jTextTotalFac.setText(df.format(totalcab));
         
         ArrayList<FacturaDetalle> verdetalle = new ArrayList<FacturaDetalle>();
         verdetalle = controlFac.getListaFacturasDetalle();
         for(int i=0; i<verdetalle.size(); i++){
             System.out.println("Datos son : " + verdetalle.get(i));
         }
         
    }//GEN-LAST:event_CalcularTotalActionPerformed

    public void limpiar() {
        jTextCodigoPro.setText("");
        jTextNombrePro.setText("");
        jTextCantidadPro.setText("");
        jTextCodigoPro.grabFocus();
    }

    public void metodo_para_eliminar_una_fila(){
         if (tUsuario.getSelectedRow() != -1) {
            dtm.removeRow(tUsuario.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(null, "No has seleccionado un registro");
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarProducto;
    private javax.swing.JButton CalcularTotal;
    private javax.swing.JButton agregarCliente;
    private javax.swing.JButton botonBuscarporCedula;
    private javax.swing.JButton botonBuscarporNombre;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonCobrar;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextApellido;
    private javax.swing.JTextField jTextCantidadPro;
    private javax.swing.JTextField jTextCedula;
    private javax.swing.JTextField jTextCelular;
    private javax.swing.JTextField jTextCodigoFact;
    private javax.swing.JTextField jTextCodigoPro;
    private javax.swing.JTextField jTextConvencional;
    private javax.swing.JTextField jTextFacturadorNombre;
    private javax.swing.JTextField jTextFechaEmision;
    private javax.swing.JTextField jTextIVAFac;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextNombrePro;
    private javax.swing.JTextField jTextSubtotalFac;
    private javax.swing.JTextField jTextTotalFac;
    private javax.swing.JTable tUsuario;
    // End of variables declaration//GEN-END:variables
}

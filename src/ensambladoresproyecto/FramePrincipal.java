package ensambladoresproyecto;

import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Luis Angel Rocha
 */
public class FramePrincipal extends javax.swing.JFrame {
    
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    DefaultTableModel modeloDeTabla;
    private String titulo;
    private Directory Directorio;
    public ArrayList<Token> tokensAsm = new ArrayList<>();
    //public ArrayList<Tokensfasedos> tokensfasedos = new ArrayList<Tokensfasedos>();
    public ArrayList<ErrorLSSL> errors = new ArrayList<>();
    private ArrayList<TextColor> textoConColor = new ArrayList<>();
    private Timer Temporalizador;
    private ArrayList<Production> identProd = new ArrayList<>();
    private HashMap<String, String> identificadores = new HashMap<>();
    private boolean codeHasBeenCompiled = false;    
    /**
     * Creates new form M
     */
    public FramePrincipal() {
        initComponents();
        init();
        propTable();
        propTableFaseDos();
        propTableSimbolos();
        //setIconImage(getIconImage())
        //Consola.setEditable(false);
       //cambiar logo de java
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("code.png")));

                         
    }
    
    private void propTable()
    {
        String datos[] = {"SEPARACION DE ELEMENTOS","ANALISIS LEXICO","L/C"};
        
        DefaultTableModel modelo = new DefaultTableModel(null, datos){
           
         public boolean isCellEditable(int filas, int columnas) {
              if(columnas==3){
                  return true;
              }else{
                  return false;
              }}
        };
        tablaDeFaseUno.setModel(modelo);
        
        TableColumn columna0, columna2;
        columna0 = tablaDeFaseUno.getColumnModel().getColumn(0);
        columna2 = tablaDeFaseUno.getColumnModel().getColumn(2);
        columna0.setPreferredWidth(250);
        columna0.setMaxWidth(250);
        columna0.setMinWidth(200);
        columna2.setPreferredWidth(100);
        columna2.setMaxWidth(100);
        columna2.setMinWidth(100);

    }
    
    public void propTableFaseDos(){
        String datos2[] = {"DIRECCION","LINEA","ANALISIS"};
        
        DefaultTableModel modelo = new DefaultTableModel(null, datos2){
           
         public boolean isCellEditable(int filas, int columnas) {
              if(columnas==3){
                  return true;
              }else{
                  return false;
              }}
        };
        tabFasedos.setModel(modelo);
    }
    
        public void propTableSimbolos(){
        String datos3[] = {"SIMBOLO","TIPO","TAMAÑO","VALOR","DIRECCION"};
        
        DefaultTableModel modelo = new DefaultTableModel(null, datos3){
           
         public boolean isCellEditable(int filas, int columnas) {
              if(columnas==5){
                  return true;
              }else{
                  return false;
              }}
        };
        tabSimbolos.setModel(modelo);
    }
    
   /* public void consola(){                 
          //variable que guardara todos los tokens
          String tkns = "";
          //recorrera con un for cada uno de los tokens
          for(Token token: tokensAsm){    
             if(token.getLexicalComp().equals("Elemento_no_identificado")){ 
            //obtendra la cadena del token
            String tkn = String.valueOf(token);
            //concatenar el valor con la cadena vacia
            tkns += tkn;           
          }       
        }
              if(tkns.length() <= 0){
                 Consola.setText("RESULTADO DEL ANALISIS LEXICO\n"+ "-----------------------------\n"
                              + "Status: Correcto...\n"+
                                "\n");
                   
             }else{
                 Consola.setText("RESULTADO DEL ANALISIS LEXICO\n"+ "-----------------------------\n"
                              + "Status: Hay elementos no identificados...\n"+
                                "\n"+tkns);
             
            }
              
      }*/    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSelectFile = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnCompilar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnGuardarComo = new javax.swing.JButton();
        btnAcercaDe = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PanelParaCodigoFuente = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaDeFaseUno = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblRuta = new javax.swing.JTextPane();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabSimbolos = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabFasedos = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ANALIZADOR LEXICOGRAFICO");
        setBackground(new java.awt.Color(32, 33, 36));
        setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(32, 33, 36));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(32, 33, 36));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(93, 123, 184), 2, true));

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(93, 123, 184));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CODIGO FUENTE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 420, 30));

        jPanel4.setBackground(new java.awt.Color(60, 64, 67));

        jPanel9.setBackground(new java.awt.Color(32, 33, 36));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(93, 123, 184), 2, true));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(93, 123, 184));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SELECCIONAR ARCHIVO");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnSelectFile.setBackground(new java.awt.Color(60, 64, 67));
        btnSelectFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto/openFile.png"))); // NOI18N
        btnSelectFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectFileActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(32, 33, 36));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(93, 123, 184), 2, true));

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(93, 123, 184));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("COMPILAR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(32, 33, 36));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(93, 123, 184), 2, true));

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(93, 123, 184));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LIMPIAR");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnCompilar.setBackground(new java.awt.Color(60, 64, 67));
        btnCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto/compile (1).png"))); // NOI18N
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(60, 64, 67));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto/clear2.png"))); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(32, 33, 36));
        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(93, 123, 184), 2, true));

        jLabel7.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(93, 123, 184));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("GUARDAR");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnGuardar.setBackground(new java.awt.Color(60, 64, 67));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto/Save.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(32, 33, 36));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(93, 123, 184), 2, true));

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(93, 123, 184));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("GUARDAR COMO");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnGuardarComo.setBackground(new java.awt.Color(60, 64, 67));
        btnGuardarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto/SaveAs.png"))); // NOI18N
        btnGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarComoActionPerformed(evt);
            }
        });

        btnAcercaDe.setBackground(new java.awt.Color(60, 64, 67));
        btnAcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto/group.png"))); // NOI18N
        btnAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcercaDeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSelectFile)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCompilar)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarComo)
                .addGap(18, 18, 18)
                .addComponent(btnAcercaDe)
                .addGap(339, 339, 339)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSelectFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCompilar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarComo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAcercaDe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, -1, 80));

        jPanel5.setBackground(new java.awt.Color(93, 123, 184));
        jPanel5.setPreferredSize(new java.awt.Dimension(3, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 10, 300));

        jPanel8.setBackground(new java.awt.Color(32, 33, 36));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(93, 123, 184), 2, true));

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(93, 123, 184));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SEPARACION DE ELEMENTOS Y ANALISIS LEXICOGRAFICO");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 33, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 840, 30));

        PanelParaCodigoFuente.setBackground(new java.awt.Color(60, 64, 67));
        PanelParaCodigoFuente.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        PanelParaCodigoFuente.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(PanelParaCodigoFuente);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 420, 230));

        tablaDeFaseUno.setBackground(new java.awt.Color(60, 64, 67));
        tablaDeFaseUno.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tablaDeFaseUno.setForeground(new java.awt.Color(255, 255, 255));
        tablaDeFaseUno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tablaDeFaseUno);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 840, 230));

        lblRuta.setBackground(new java.awt.Color(60, 64, 67));
        lblRuta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(93, 123, 184), 2, true));
        lblRuta.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        lblRuta.setForeground(new java.awt.Color(255, 255, 255));
        lblRuta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(lblRuta);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 1320, 30));

        jPanel12.setBackground(new java.awt.Color(93, 123, 184));
        jPanel12.setPreferredSize(new java.awt.Dimension(3, 0));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1320, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 1320, 10));

        jPanel13.setBackground(new java.awt.Color(32, 33, 36));
        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(93, 123, 184), 2, true));

        jLabel6.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(93, 123, 184));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ANALISIS SINTACTICO Y SEMANTICO");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, 730, -1));

        tabSimbolos.setBackground(new java.awt.Color(60, 64, 67));
        tabSimbolos.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tabSimbolos.setForeground(new java.awt.Color(255, 255, 255));
        tabSimbolos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tabSimbolos);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 530, 180));

        tabFasedos.setBackground(new java.awt.Color(60, 64, 67));
        tabFasedos.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tabFasedos.setForeground(new java.awt.Color(255, 255, 255));
        tabFasedos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tabFasedos);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 730, 180));

        jPanel14.setBackground(new java.awt.Color(32, 33, 36));
        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(93, 123, 184), 2, true));

        jLabel9.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(93, 123, 184));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("TABLA DE SIMBOLOS");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 530, -1));

        jPanel15.setBackground(new java.awt.Color(93, 123, 184));
        jPanel15.setPreferredSize(new java.awt.Dimension(3, 0));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 10, 260));

        jPanel16.setBackground(new java.awt.Color(93, 123, 184));
        jPanel16.setPreferredSize(new java.awt.Dimension(3, 0));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1330, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 540, 1330, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void init(){
 
      
        //definir titulo que se mostrara la ventana
        this.setResizable(false);
       // TextPaneCodigoFuente.setEditable(false);
        titulo = "ANALIZADOR LEXICOGRAFICO [PRINCIPAL]";
        //mostrar ventana en centro de la pantalla
        setLocationRelativeTo(null);
        //concatenar titulo a la ventana
        setTitle(titulo);
        //definir el panel que concatenaremos, el componente, el titulo de ventana, la extension del archivo
        Directorio = new Directory(this, PanelParaCodigoFuente, titulo, ".asm");
        addWindowListener(new WindowAdapter(){
           @Override
           //metodo que permitira guardar cambios si se realzaran desde el panel editor
           public void windowClosing(WindowEvent e){
               Directorio.Exit();
               System.exit(0);
           }
        });
        

        
        //enumera las filas del editor
        Functions.setLineNumberOnJTextComponent(PanelParaCodigoFuente);

        // inicializar timer para colorear lineas del codigo
        Temporalizador = new Timer((int)(1000 * 0.1), (ActionEvent e) -> {
            Temporalizador.stop();
            AnalisisDeColores();
        });
        //pone un * en la ventana cuando modifiquemos codigo en señal de que se realizo la modificacion
        Functions.insertAsteriskInName(this, PanelParaCodigoFuente, () ->{
        //lamara metodo restart    
            Temporalizador.restart();
        });
        
        //metodo para incluir un autocompletador de codigo parecido al de NetBeans
        //se activa tecleando Ctrl + Space
        Functions.setAutocompleterJTextComponent(new String[]{".stack","stack segment",".data",
        "data segment",".code","code segment","ends"},PanelParaCodigoFuente, ()->{
            Temporalizador.restart();
        });
        
    }
    
    public void arrayL(ArrayList<Token> tokensAsm){
    
        this.tokensAsm = tokensAsm;
       
    }
    
    private void limpiarCampos(){
      //llamar al metodo para limpiar todos los campos de la tabla de tokens
      PanelParaCodigoFuente.setText("");
      Functions.clearDataInTable(tablaDeFaseUno);      
      //limpiar los arrayList
      tokensAsm.clear();
      errors.clear();
      identProd.clear();
      identificadores.clear();
      lblRuta.setText("");
      //Consola.setText("");
      codeHasBeenCompiled = false;
    } 
    
    private void AnalisisDeColores(){
        /* Limpiar el arreglo de colores */
        textoConColor.clear();
        /* Extraer rangos de colores */
        LexerColoresPalabras lexerColor;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = PanelParaCodigoFuente.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexerColor = new LexerColoresPalabras(entrada);
            while (true) {
                TextColor textColor = lexerColor.yylex();
                if (textColor == null) {
                    break;
                }
                textoConColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
        //lamar metodo 
        Functions.colorTextPane(textoConColor, PanelParaCodigoFuente, new Color(255, 255, 255));
    }
    
    private void compilar(){
        Functions.clearDataInTable(tablaDeFaseUno);
        //Consola.setText("");
        
        //limpiar los arrayList
        tokensAsm.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
        AnalisisLexico();
        fillPaneTokens();
        AnalisisSintatico();
        semanticAnalysis();
        codeHasBeenCompiled = true;
    }
    private void AnalisisLexico(){
     // Extraer tokens
        Lexer lexer;
        try {
            if(PanelParaCodigoFuente.getText().length()==0){
                 UIManager UI=new UIManager();
                 //cambiar el tamaño de la fuente y la fuente
                 UI.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
                 //Cambiar color fondo y secundario
                 UI.put("OptionPane.background", Color.decode("#202124"));
                 UI.put("OptionPane.messageForeground", Color.decode("#5d7bb8"));
                 UI.put("Button.background", Color.decode("#5d7bb8"));
                 UI.put("Button.foreground", Color.decode("#202124"));
                 JOptionPane.showMessageDialog(null, "NO HAY CODIGO EN EL EDITOR, NO HAY NADA QUE COMPILAR...", "ANALIZADOR LEXICOGRAFICO", JOptionPane.INFORMATION_MESSAGE);
            }else{
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = PanelParaCodigoFuente.getText().getBytes();
            output.write(bytesText);
            //crearemos un buffer de lectura, recibira un input de escritura, se especifica que la codificacion es UTF8
            // para que reconozca caracteres extraños
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            // se manda la entrada a la variable lexer
            lexer = new Lexer(entrada);
            while (true) {
                // se creara un token que retornara todos los tokens 
                Token token = lexer.yylex();
                // si token es null se romple el ciclo
                if (token == null) {
                    break;
                }
                // se añade el token
                if(tokensAsm == null){
                
                 
                }else{
                    tokensAsm.add(token);
                    //consola(); 
                    //imprimirConsola();
                }
            }}
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }

        
    }
    
    
    private void fillPaneTokens(){
     //forEach para recorrer todos los tokens
     tokensAsm.forEach(token ->{
        Object[] data = new Object[]{token.getLexeme(),token.getLexicalComp(),"[ "+token.getLine()+" , "+token.getColumn()+" ]"};
     Functions.addRowDataInTable(tablaDeFaseUno, data);
     });
          
    }
    
    private void BuildingFunction(){
    UIManager UI=new UIManager();
    //cambiar el tamaño de la fuente y la fuente
    UI.put("OptionPane.messageFont", new Font("Poppins", Font.BOLD, 14));
    //Cambiar color fondo y secundario
    UI.put("OptionPane.background", Color.decode("#202124"));
    UI.put("OptionPane.messageForeground", Color.decode("#5d7bb8"));
    UI.put("Button.background", Color.decode("#5d7bb8"));
    UI.put("Button.foreground", Color.decode("#202124"));
    JOptionPane.showMessageDialog(null, "FUNCION EN DESARROLLO, AUN NO DISPONIBLE...", "ANALIZADOR LEXICOGRAFICO", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void AnalisisSintatico(){
        
      //crear objeto Grammar de la lib compilerTools 
      Grammar gramatica = new Grammar(tokensAsm,errors);
      
      //Eliminar los errores
      gramatica.delete(new String[]{"Elemento_no_identificado"}, 1);
      
      /*Declaracion de variables*/
      gramatica.group("VARIABLE","Simbolo Pseudoinstruccion Numero_Decimal",true);
      gramatica.group("VARIABLE","Simbolo Numero_Decimal",true,2,"Falta asignar el tipo de dato para la variable. (db o dw) [#,%]");
      gramatica.group("VARIABLE","Pseudoinstruccion Numero_Decimal",true,2,"Falta asignar el nombre a la variable. [#,%]");
      gramatica.group("VARIABLE","Simbolo Pseudoinstruccion Numero_Hexadecimal",true);
      gramatica.group("VARIABLE","Simbolo Numero_Hexadecimal",true,2,"Falta asignar el tipo de dato para la variable. (db o dw) [#,%]");
      gramatica.group("VARIABLE","Pseudoinstruccion Numero_Hexadecimal",true,2,"Falta asignar el nombre a la variable. [#,%]");
      
      
      gramatica.show();
      System.out.println(tokensAsm);
      System.out.println(errors);
      
    }
    
    private void semanticAnalysis(){
        
    }
    
   /* private void imprimirConsola(){
      //variable que guardara todos los errores
      int sizeErrors = errors.size();
      // if que verifica si los errores son mayores a 0
      if(sizeErrors > 0){
          //metodo que ordenara los errores por numero de comulna y linea
          Functions.sortErrorsByLineAndColumn(errors);
          //variable que guardara todos los errores
          String strErrors = "\n";
          //recorrera con un for cada uno de los errores
          for(ErrorLSSL error: errors){
            //obtendra la cadena del error
            String strError = String.valueOf(error);
            //concatenar el valor con la cadena vacia
            strErrors += strError + "\n";
          }
          //en caso de haber errores la compilacion no habra terminado
          //jtaOutputConsole es el nombre del panel
          Consola.setText("La compilacion termino con errores...\n"+strErrors);
          
      }else{
          //en caso de no haber errores la compilacion habra terminado
          //jtaOutputConsole es el nombre del panel
          Consola.setText("Compilacion terminada...");
      }
    }*/
   
    
    private void btnSelectFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectFileActionPerformed
    limpiarCampos();
   //Bloquea la edicion del JTextArea
   // TextPaneCodigoFuente.setEditable(false);  
    lblRuta.setEditable(false);
    //Creamos el objeto JFileChooser
    JFileChooser Sfile = new JFileChooser(); 
    
    Sfile.setAcceptAllFileFilterUsed(false);
    
    FileNameExtensionFilter filtro = new FileNameExtensionFilter(".asm","asm");
    
    Sfile.setFileFilter(filtro);
    //abre la ventana, guarda la opcion seleccionada por el usuario
    int SeleccionFile = Sfile.showOpenDialog(this);
    
    //Si el usuario teclea aceptar
  
    if (SeleccionFile == JFileChooser.APPROVE_OPTION){
      
       

        //Seleccionar el archivo
        File archivo = Sfile.getSelectedFile();
 
        this.lblRuta.setText(archivo.getAbsolutePath());
        //Escribe el contenido del archivo seleccionado en el JTextArea
        PanelParaCodigoFuente.setText(archivo.getAbsolutePath());
        
        try (FileReader fileread = new FileReader(archivo)){
           String cadena = "";
           int valor = fileread.read();
           while (valor != -1){
              cadena = cadena + (char) valor;
               valor = fileread.read();
               
           }
           PanelParaCodigoFuente.setText(cadena);
           
        }  catch (IOException e){
            e.printStackTrace();
        }
                  
    }       
     AnalisisDeColores();
    }//GEN-LAST:event_btnSelectFileActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
      compilar();
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
     limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
     BuildingFunction();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarComoActionPerformed
     BuildingFunction();
    }//GEN-LAST:event_btnGuardarComoActionPerformed

    private void btnAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcercaDeActionPerformed
        AcercaDe acd = new AcercaDe();
        acd.setVisible(true);
    }//GEN-LAST:event_btnAcercaDeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
           try {
             
                   UIManager.setLookAndFeel(new FlatIntelliJLaf());
               
               new FramePrincipal().setVisible(true);
               
           } catch(UnsupportedLookAndFeelException ex){
               Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
              
           }
           

        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane PanelParaCodigoFuente;
    private javax.swing.JButton btnAcercaDe;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarComo;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSelectFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextPane lblRuta;
    private javax.swing.JTable tabFasedos;
    private javax.swing.JTable tabSimbolos;
    private javax.swing.JTable tablaDeFaseUno;
    // End of variables declaration//GEN-END:variables
}

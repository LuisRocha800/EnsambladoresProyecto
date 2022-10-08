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

/**
 *
 * @author Luis Angel Rocha
 */
public class ClasePrincipal extends javax.swing.JFrame {
    DefaultTableModel modelo;
    private String title;
    private Directory Directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;
    
    
    
    /**
     * Creates new form M
     */
    public ClasePrincipal() {
        initComponents();
        init();
        modelo=new DefaultTableModel();
        modelo.addColumn("COLUMNA / FILA");
        modelo.addColumn("SEPARACION DE ELEMENTOS");
        modelo.addColumn("ANALISIS LEXICO");
        this.tabFaseuno.setModel(modelo);
         TextPaneCodigoFuente.setEditable(false); 
    }

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
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextPaneCodigoFuente = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabFaseuno = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ANALIZADOR LEXICOGRAFICO");
        setBackground(new java.awt.Color(32, 33, 36));
        setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(32, 33, 36));

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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addContainerGap())
        );

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
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnCompilar.setBackground(new java.awt.Color(60, 64, 67));
        btnCompilar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto/compile (1).png"))); // NOI18N
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(60, 64, 67));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ensambladoresproyecto/Clean.png"))); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar)
                .addGap(215, 215, 215)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSelectFile)
                .addGap(160, 160, 160)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCompilar)
                .addGap(205, 205, 205)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSelectFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCompilar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );

        jPanel5.setBackground(new java.awt.Color(93, 123, 184));
        jPanel5.setPreferredSize(new java.awt.Dimension(3, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

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
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        TextPaneCodigoFuente.setBackground(new java.awt.Color(60, 64, 67));
        TextPaneCodigoFuente.setFont(new java.awt.Font("Poppins", 1, 12)); // NOI18N
        TextPaneCodigoFuente.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(TextPaneCodigoFuente);

        tabFaseuno.setBackground(new java.awt.Color(60, 64, 67));
        tabFaseuno.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        tabFaseuno.setForeground(new java.awt.Color(255, 255, 255));
        tabFaseuno.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tabFaseuno);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(517, 517, 517))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))))
                .addGap(29, 29, 29)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1268, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void init(){
        //definir titulo que se mostrara la ventana
        title = "ANALIZADOR LEXICOGRAFICO";
        //mostrar ventana en centro de la pantalla
        setLocationRelativeTo(null);
        //concatenar titulo a la ventana
        setTitle(title);
        //definir el panel que concatenaremos, el componente, el titulo de ventana, la extension del archivo
        Directorio = new Directory(this,TextPaneCodigoFuente,title,".asm");
        
       /* addWindowListener(new WindowAdapter(){
           @Override
           //metodo que permitira guardar cambios si se realzaran desde el panel editor
           public void windowClosing(WindowEvent e){
               Directorio.Exit();
               System.exit(0);
           }
        });*/
        
        //enumera las filas del editor
        Functions.setLineNumberOnJTextComponent(TextPaneCodigoFuente);

        // inicializar timer para colorear lineas del codigo
        timerKeyReleased = new Timer(300, ((e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        }));
        //pone un * en la ventana cuando modifiquemos codigo en señal de que se realizo la modificacion
        Functions.insertAsteriskInName(this, TextPaneCodigoFuente, () ->{
        //lamara metodo restart    
            timerKeyReleased.restart();
        });
        
        //inicializar ArrayList's a un ArrayList vacio
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
        
        //metodo para incluir un autocompletador de codigo parecido al de NetBeans
        //se activa tecleando Ctrl + Space
        Functions.setAutocompleterJTextComponent(new String[]{".stack","stack segment",".data",
        "data segment",".code","code segment","ends"},TextPaneCodigoFuente, ()->{
            timerKeyReleased.restart();
        });                
    }
     
    private void clearFields(){
      //llamar al metodo para limpiar todos los campos de la tabla de tokens
      TextPaneCodigoFuente.setText("");
      Functions.clearDataInTable(tabFaseuno);      
      //limpiar los arrayList
      tokens.clear();
      errors.clear();
      identProd.clear();
      identificadores.clear();
      codeHasBeenCompiled = false;
    } 
    
    private void colorAnalysis(){
        /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColors lexerColor;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = TextPaneCodigoFuente.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexerColor = new LexerColors(entrada);
            while (true) {
                TextColor textColor = lexerColor.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
        //lamar metodo 
        Functions.colorTextPane(textsColor, TextPaneCodigoFuente, new Color(255, 255, 255));
    }
    
    private void compile(){
        lexicalAnalysis();
        fillPaneTokens();
        syntaticAnalysis();
        semanticAnalysis();
        printConsole();
        codeHasBeenCompiled = true;
    }
    private void lexicalAnalysis(){
     // Extraer tokens
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = TextPaneCodigoFuente.getText().getBytes();
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
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        } 
    }
    
    private void fillPaneTokens(){
     //forEach para recorrer todos los tokens
     tokens.forEach(token ->{
        Object[] data = new Object[]{"[ "+token.getLine()+" , "+token.getColumn()+" ]",token.getLexeme(),token.getLexicalComp()};
     Functions.addRowDataInTable(tabFaseuno, data);
     });  
    }
    
    private void syntaticAnalysis(){
      //crear objeto Grammar de la lib compilerTools 
      Grammar gramatica = new Grammar(tokens,errors);
      
      gramatica.show();
    }
    
    private void semanticAnalysis(){
        
    }
    
    private void printConsole(){
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
          //jtaOutputConsole.setText("La compilacion termino con errores...\n"+strErrors);
          
      }else{
          //en caso de no haber errores la compilacion habra terminado
          //jtaOutputConsole es el nombre del panel
          //jtaOutputConsole.setText("Compilacion terminada...");
      }
    }
    private void btnSelectFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectFileActionPerformed
    Scanner entrada = null;
    boolean commillas=false,primercomilla=false;
    boolean decimal,noinicianumero,entero,corchete;
    
    
    //Bloquea la edicion del JTextArea
    TextPaneCodigoFuente.setEditable(false);    
    //Creamos el objeto JFileChooser
    JFileChooser Sfile = new JFileChooser(); 
    
    FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.asm","asm");
    
    Sfile.setFileFilter(filtro);
    //abre la ventana, guarda la opcion seleccionada por el usuario
    int SeleccionFile = Sfile.showOpenDialog(this);
    
    //Si el usuario teclea aceptar
    if (SeleccionFile == JFileChooser.APPROVE_OPTION){
        
        //Seleccionar el archivo
        File archivo = Sfile.getSelectedFile();
        
        //Escribe el contenido del archivo seleccionado en el JTextArea
        TextPaneCodigoFuente.setText(archivo.getAbsolutePath());
        
        try (FileReader fileread = new FileReader(archivo)){
           String cadena = "";
           int valor = fileread.read();
           while (valor != -1){
              cadena = cadena + (char) valor;
               valor = fileread.read();
               
           }
           TextPaneCodigoFuente.setText(cadena);
           
        }  catch (IOException e){
            e.printStackTrace();
        }
              
    }
    
    }//GEN-LAST:event_btnSelectFileActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
      compile();
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
     clearFields();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClasePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClasePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClasePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClasePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
       // java.awt.EventQueue.invokeLater(new Runnable() {
        /*    public void run() {
                new ClasePrincipal().setVisible(true);
            }*/
        //});
        
        java.awt.EventQueue.invokeLater(() -> {
           try {
               UIManager.setLookAndFeel(new FlatIntelliJLaf());
               
               new ClasePrincipal().setVisible(true);
           } catch(UnsupportedLookAndFeelException ex){
               Logger.getLogger(ClasePrincipal.class.getName()).log(Level.SEVERE, null, ex);
           }
           

        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane TextPaneCodigoFuente;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSelectFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tabFaseuno;
    // End of variables declaration//GEN-END:variables
}

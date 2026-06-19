package interfaz;
import dominio.Sistema;
import javax.swing.JLabel;

/**
 *
 * @author lautaromoreno
 */
public class ReportesPaquetesPorEstado extends javax.swing.JFrame {
    

    private Sistema modelo;
    
    public ReportesPaquetesPorEstado(Sistema unModelo) {
        this.modelo = unModelo;
        initComponents();
        
        if(this.modelo != null){
        cargarGrilla();
        configurarMapaUruguay();
        }
        
        this.setSize (800,850);
        this.setPreferredSize(new java.awt.Dimension(800,850));
        this.setLocationRelativeTo(null);
        
        this.addWindowFocusListener(new java.awt.event.WindowAdapter (){
            @Override
            public void windowActivated (java.awt.event.WindowEvent e){
                actualizarDatosReporte();
            }
            
        });
    }
    
    private void cargarGrilla(){
        String[] columnas = {"","Pendiente","Enviado","Recibido","Total"};
        
        javax.swing.table.DefaultTableModel TablaReporte = new javax.swing.table.DefaultTableModel(columnas,0){

                @Override
                public boolean isCellEditable (int row, int column){
                boolean no = false;
                    return no;
                }
            };
                
                String[] zonas = {"Norte", "Oeste", "Sur", "Este"};
                 
                for(int i = 0; i<zonas.length;i++){
                    String zonaActual = zonas[i];
                
                int pendientes = this.modelo.contarPaquetesPorZonaYEstado(zonaActual,"Pendiente");
                int enviados = this.modelo.contarPaquetesPorZonaYEstado(zonaActual,"Enviado");
                int recibidos = this.modelo.contarPaquetesPorZonaYEstado(zonaActual,"Recibido");
                int totalZona = pendientes + enviados + recibidos;
                
                String nombreZonaOk = zonaActual.substring(0,1) + zonaActual.substring(1).toLowerCase();
                
                Object[] fila = {
                nombreZonaOk,
                pendientes,
                enviados,
                recibidos,
                totalZona
                };
                
                TablaReporte.addRow(fila);
                }
             
                this.tblReporte.setModel(TablaReporte);
                
                this.tblReporte.setBackground(java.awt.Color.BLACK);
                this.tblReporte.setForeground(java.awt.Color.WHITE);
                
                this.tblReporte.setGridColor(new java.awt.Color(60,60,60));
                this.tblReporte.setShowGrid(true);
                this.tblReporte.setRowHeight(25);
                
        
    }
    
    private void configurarMapaUruguay(){
        String [] zonas = {"Norte","Oeste","Sur","Este",};
        JLabel[] etiquetas = {lblNorte,lblOeste,lblSur,lblEste};
        
        for(int i =0; i<zonas.length;i++){
           String zonaActual = zonas[i];
           JLabel etiquetaActual = etiquetas[i];
           
           int pendientes = this.modelo.contarPaquetesPorZonaYEstado(zonaActual,"Pendiente");
           int enviados = this.modelo.contarPaquetesPorZonaYEstado(zonaActual,"Enviado");
           int recibidos = this.modelo.contarPaquetesPorZonaYEstado(zonaActual,"Recibido");
           int totalZona = pendientes + enviados + recibidos;
                
           String mensajePopup = "Cantidad de paquetes en cada estado:\n\n"
                   + " Pendientes:" + pendientes 
                   + "\n" +" Enviados: " + enviados + "\n" 
                   + " Recibidos: " +recibidos+ "\n\n" 
                   + " Total Zona: " + totalZona;

                System.out.println("Cargando zona" + zonaActual + "con un total de" + totalZona);
           
     
                etiquetaActual.setToolTipText(mensajePopup);
                
                etiquetaActual.setOpaque(true);
                etiquetaActual.setBackground(java.awt.Color.YELLOW);
                etiquetaActual.setForeground(java.awt.Color.BLACK);
                etiquetaActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                
                etiquetaActual.addMouseListener (new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseEntered(java.awt.event.MouseEvent evt){
                        etiquetaActual.setBackground(new java.awt.Color(0,255,255));
                        etiquetaActual.setForeground(java.awt.Color.BLACK);
                        
                        javax.swing.JOptionPane.showMessageDialog(ReportesPaquetesPorEstado.this,mensajePopup,"Datos de la zona" + zonaActual, javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    }
                    @Override
                    public void mouseExited(java.awt.event.MouseEvent evt){
                        etiquetaActual.setBackground(java.awt.Color.YELLOW);
                        etiquetaActual.setForeground(java.awt.Color.BLACK);

                        
                        
                    }
                });
                
           
           
        }
        
        
    }
    
    public void actualizarDatosReporte(){
        if (this.modelo != null){
            cargarGrilla();
            configurarMapaUruguay();
            this.repaint();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporte = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        panelMapa = new javax.swing.JPanel();
        lblSur = new javax.swing.JLabel();
        lblNorte = new javax.swing.JLabel();
        lblOeste = new javax.swing.JLabel();
        lblEste = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        tblReporte.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblReporte);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(42, 45, 452, 168);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setText("Paquetes por Estado");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(100, 16, 179, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 650, 230);

        panelMapa.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSur.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        lblSur.setText("Sur");
        panelMapa.add(lblSur, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, -1, -1));

        lblNorte.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblNorte.setText("Norte");
        panelMapa.add(lblNorte, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 140, 50));

        lblOeste.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblOeste.setText("Oeste");
        panelMapa.add(lblOeste, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        lblEste.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblEste.setText("Este");
        panelMapa.add(lblEste, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 80, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atl_ruteroUY_nuevoG.jpg"))); // NOI18N
        panelMapa.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 520, 480));

        getContentPane().add(panelMapa);
        panelMapa.setBounds(0, 220, 550, 530);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(610, 450, 50, 10);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(this::btnSalirActionPerformed);
        getContentPane().add(btnSalir);
        btnSalir.setBounds(590, 700, 100, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
this.dispose();       
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEste;
    private javax.swing.JLabel lblNorte;
    private javax.swing.JLabel lblOeste;
    private javax.swing.JLabel lblSur;
    private javax.swing.JPanel panelMapa;
    private javax.swing.JTable tblReporte;
    // End of variables declaration//GEN-END:variables
}

package interfaz;
import dominio.Sistema;
import javax.swing.ImageIcon;
import java.awt.Image;

/**
* Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno
 */
public class MenuPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuPrincipal.class.getName());
    
    private Sistema modelo;

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal(Sistema modelo) {
        this.modelo = modelo;
        javax.swing.JFrame.setDefaultLookAndFeelDecorated(false);
        javax.swing.JDialog.setDefaultLookAndFeelDecorated(false);
        
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem6 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuDatos = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        MenuPaquete = new javax.swing.JMenu();
        MenuPaqueteIngreso = new javax.swing.JMenuItem();
        MenuPaqueteEnvio = new javax.swing.JMenuItem();
        MenuPaqueteRecepcion = new javax.swing.JMenuItem();
        MenuReportes = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        MenuSalir = new javax.swing.JMenu();
        MenuSalirSistema = new javax.swing.JMenuItem();

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de envíos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(null);

        MenuDatos.setText("Datos");

        jMenuItem1.setText("Clientes");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        MenuDatos.add(jMenuItem1);

        jMenuItem2.setText("Funcionarios");
        jMenuItem2.addActionListener(this::jMenuItem2ActionPerformed);
        MenuDatos.add(jMenuItem2);

        jMenuItem3.setText("Tarifas");
        jMenuItem3.addActionListener(this::jMenuItem3ActionPerformed);
        MenuDatos.add(jMenuItem3);

        jMenuBar1.add(MenuDatos);

        MenuPaquete.setText("Paquete");

        MenuPaqueteIngreso.setText("Ingreso");
        MenuPaqueteIngreso.addActionListener(this::MenuPaqueteIngresoActionPerformed);
        MenuPaquete.add(MenuPaqueteIngreso);

        MenuPaqueteEnvio.setText("Envío");
        MenuPaqueteEnvio.addActionListener(this::MenuPaqueteEnvioActionPerformed);
        MenuPaquete.add(MenuPaqueteEnvio);

        MenuPaqueteRecepcion.setText("Recepción");
        MenuPaqueteRecepcion.addActionListener(this::MenuPaqueteRecepcionActionPerformed);
        MenuPaquete.add(MenuPaqueteRecepcion);

        jMenuBar1.add(MenuPaquete);

        MenuReportes.setText("Reportes");

        jMenuItem8.setText("Paquetes por estado");
        jMenuItem8.addActionListener(this::jMenuItem8ActionPerformed);
        MenuReportes.add(jMenuItem8);

        jMenuItem9.setText("Consulta por cliente");
        jMenuItem9.addActionListener(this::jMenuItem9ActionPerformed);
        MenuReportes.add(jMenuItem9);

        jMenuItem10.setText("Log de transacciones");
        MenuReportes.add(jMenuItem10);

        jMenuBar1.add(MenuReportes);

        MenuSalir.setText("Salir");

        MenuSalirSistema.setText("Salir del Sistema");
        MenuSalirSistema.addActionListener(this::MenuSalirSistemaActionPerformed);
        MenuSalir.add(MenuSalirSistema);

        jMenuBar1.add(MenuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
        );

        setBounds(0, 0, 512, 390);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        DatosClientes lc = new DatosClientes(modelo);
        lc.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void MenuPaqueteIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPaqueteIngresoActionPerformed
        PaqueteIngreso pi = new PaqueteIngreso(modelo);
        pi.setVisible(true);
    }//GEN-LAST:event_MenuPaqueteIngresoActionPerformed

    private void MenuPaqueteRecepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPaqueteRecepcionActionPerformed
        // TODO add your handling code here:
        PaqueteRecepcion pr = new PaqueteRecepcion(modelo);
        pr.setVisible(true);
    }//GEN-LAST:event_MenuPaqueteRecepcionActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        DatosFuncionarios ventanaFuncionarios = new DatosFuncionarios(this.modelo);
        ventanaFuncionarios.setVisible(true);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    DatosTarifas ventanaTarifas = new DatosTarifas(this.modelo);
        ventanaTarifas.setVisible(true);    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void MenuPaqueteEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPaqueteEnvioActionPerformed
        PaqueteEnvio pe = new PaqueteEnvio(modelo);
        pe.setVisible(true);
    }//GEN-LAST:event_MenuPaqueteEnvioActionPerformed

    private void MenuSalirSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSalirSistemaActionPerformed
        this.guardarCambiosYSalir();
    }//GEN-LAST:event_MenuSalirSistemaActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
    ReportesConsultaPorCliente ventana = new ReportesConsultaPorCliente(this.modelo);
    ventana.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
    ReportesPaquetesPorEstado ventanaReporte = new ReportesPaquetesPorEstado(this.modelo);
    ventanaReporte.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        this.guardarCambiosYSalir();
    }//GEN-LAST:event_formWindowClosing

    private void guardarCambiosYSalir(){
        modelo.serializar();
        this.dispose();
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuDatos;
    private javax.swing.JMenu MenuPaquete;
    private javax.swing.JMenuItem MenuPaqueteEnvio;
    private javax.swing.JMenuItem MenuPaqueteIngreso;
    private javax.swing.JMenuItem MenuPaqueteRecepcion;
    private javax.swing.JMenu MenuReportes;
    private javax.swing.JMenu MenuSalir;
    private javax.swing.JMenuItem MenuSalirSistema;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

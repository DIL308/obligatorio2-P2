package interfaz;
import dominio.Sistema;
import dominio.Envio;
import dominio.Paquete;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
* Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno
 */
public class PaqueteRecepcion extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PaqueteRecepcion.class.getName());
    
    Sistema modelo;

    /**
     * Creates new form PaqueteRecepcion
     */
    public PaqueteRecepcion(Sistema modelo) {
        this.modelo = modelo;
        initComponents();
        btnConfirmar.setEnabled(false);
        objetoAPantalla();
        
        //Método creado utilizando IA, para crear el color de de fondo según el estado del envío.
        lstEnvios.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(
                    JList<?> list,
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus) {

                Component c = super.getListCellRendererComponent(
                        list,
                        value,
                        index,
                        isSelected,
                        cellHasFocus);

                Envio envio = (Envio) value;

                if (!isSelected) {

                    if (envio.getRecepcionRegistrada()) {
                        c.setBackground(Color.GREEN);
                    } else {
                        c.setBackground(Color.YELLOW);
                    }
                }

                return c;
            }
        });
        
    }
    
    
    
    public void objetoAPantalla(){
        lstEnvios.setListData(modelo.getEnviosOrdenadosDescendente().toArray());
    }

    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblEnvios = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstEnvios = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstPaquetes = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Recepción");
        jPanel1.add(lblTitulo);
        lblTitulo.setBounds(130, 10, 160, 40);

        lblEnvios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnvios.setText("Envíos");
        jPanel1.add(lblEnvios);
        lblEnvios.setBounds(170, 70, 70, 16);

        lstEnvios.addListSelectionListener(this::lstEnviosValueChanged);
        jScrollPane2.setViewportView(lstEnvios);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(30, 90, 350, 110);

        lstPaquetes.addListSelectionListener(this::lstPaquetesValueChanged);
        jScrollPane3.setViewportView(lstPaquetes);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(30, 270, 350, 110);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Paquetes del envío seleccionado");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(80, 250, 240, 16);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(269, 400, 110, 27);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(this::btnConfirmarActionPerformed);
        jPanel1.add(btnConfirmar);
        btnConfirmar.setBounds(150, 400, 100, 27);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 450);

        setBounds(0, 0, 416, 510);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void lstEnviosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEnviosValueChanged
        // TODO add your handling code here:
        Envio envio = (Envio) lstEnvios.getSelectedValue();
        
        if (envio != null) {
            
            lstPaquetes.setListData(envio.getPaquetes().toArray());
            if (envio.getRecepcionRegistrada()) {
                btnConfirmar.setEnabled(false);
                //deshabilito botón, para q no pueda confirmar envíos verdes
            } else {
                btnConfirmar.setEnabled(true);

            }
        }
    }//GEN-LAST:event_lstEnviosValueChanged

    private void lstPaquetesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPaquetesValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lstPaquetesValueChanged

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
  
        Envio envio = (Envio) lstEnvios.getSelectedValue();
        ArrayList<Paquete> paquetes = envio.getPaquetes();
        ArrayList<Object> seleccionados = new ArrayList<>(lstPaquetes.getSelectedValuesList());
        
        
        if (lstPaquetes.getSelectedValuesList().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Debe seleccionar al menos un paquete","Error",JOptionPane.ERROR_MESSAGE);
        }

        for (int i = paquetes.size() - 1; i >= 0; i--) {

            Paquete paquete = paquetes.get(i);

            if (seleccionados.contains(paquete)) {

                paquete.setEstado("Recibido");

            } else {
                paquete.setEstado("Pendiente");
                paquetes.remove(i);
            }
        }     
        envio.setRecepcionRegistrada(true);
        JOptionPane.showMessageDialog(null,"Recepción confirmada con éxito.","Recepción confirmada",JOptionPane.INFORMATION_MESSAGE); 
        objetoAPantalla();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblEnvios;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<Object> lstEnvios;
    private javax.swing.JList<Object> lstPaquetes;
    // End of variables declaration//GEN-END:variables
}

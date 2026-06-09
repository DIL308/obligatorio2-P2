package interfaz;
import dominio.Sistema;
import dominio.Paquete;
import javax.swing.JOptionPane;

/*
 * Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno
 */
public class PaqueteIngresoConfirmacion extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PaqueteIngresoConfirmacion.class.getName());
    
    private Sistema modelo;
    private Paquete paquete;

    
    public PaqueteIngresoConfirmacion(Sistema modelo, Paquete paquete) {
        this.modelo = modelo;
        initComponents();
        this.paquete = paquete;
        lblConfirmacion.setText("El costo del paquete es de $" + this.paquete.getPrecio() + ". ¿Desea continuar?");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblConfirmacion = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirmación crear paquete");
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        lblConfirmacion.setText("El costo del paquete es de $0. ¿Desea continuar?");
        jPanel1.add(lblConfirmacion);
        lblConfirmacion.setBounds(40, 50, 350, 30);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(310, 100, 110, 27);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(this::btnConfirmarActionPerformed);
        jPanel1.add(btnConfirmar);
        btnConfirmar.setBounds(190, 100, 110, 27);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 450, 150);

        setBounds(0, 0, 463, 192);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        this.modelo.agregarPaquete(this.paquete);
        
        JOptionPane.showMessageDialog(this, "Paquete añadido correctamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
        
    }//GEN-LAST:event_btnConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblConfirmacion;
    // End of variables declaration//GEN-END:variables
}

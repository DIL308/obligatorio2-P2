
package interfaz;
import dominio.Sistema;
import javax.swing.JOptionPane;

/*
 * Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno
 */
public class ComenzarCon extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ComenzarCon.class.getName());

    /**
     * Creates new form ComenzarCon
     */
    public ComenzarCon() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbGrupo = new javax.swing.ButtonGroup();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        rbUltimaEjecucion = new javax.swing.JRadioButton();
        rbSistemaNuevo = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Comenzar con...");
        getContentPane().setLayout(null);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(380, 120, 90, 27);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(this::btnAceptarActionPerformed);
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(290, 120, 79, 27);

        rbGrupo.add(rbUltimaEjecucion);
        rbUltimaEjecucion.setText("Los datos de la última ejecución");
        getContentPane().add(rbUltimaEjecucion);
        rbUltimaEjecucion.setBounds(50, 50, 320, 21);

        rbGrupo.add(rbSistemaNuevo);
        rbSistemaNuevo.setText("Un Sistema nuevo");
        rbSistemaNuevo.addActionListener(this::rbSistemaNuevoActionPerformed);
        getContentPane().add(rbSistemaNuevo);
        rbSistemaNuevo.setBounds(50, 80, 340, 21);

        jPanel1.setLayout(null);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 510, 210);

        setBounds(0, 0, 531, 221);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
 
        Sistema modelo = null;
            
        if (rbUltimaEjecucion.isSelected()) {
            modelo = Sistema.deserializar();
        } else if (rbSistemaNuevo.isSelected()) {
            modelo = new Sistema();
        }
        else{
            JOptionPane.showMessageDialog(this, "Seleccione una de las 2 opcioens", "Error", JOptionPane.ERROR_MESSAGE);
        }     
           
        if (modelo != null) {
            MenuPrincipal mp = new MenuPrincipal(modelo);
            mp.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void rbSistemaNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSistemaNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbSistemaNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.ButtonGroup rbGrupo;
    private javax.swing.JRadioButton rbSistemaNuevo;
    private javax.swing.JRadioButton rbUltimaEjecucion;
    // End of variables declaration//GEN-END:variables
}

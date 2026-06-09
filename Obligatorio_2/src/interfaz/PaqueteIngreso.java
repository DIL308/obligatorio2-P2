package interfaz;
import dominio.Sistema;
import dominio.Cliente;
import dominio.Paquete;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno
 */
public class PaqueteIngreso extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PaqueteIngreso.class.getName());
    
    Sistema modelo;
    
    public PaqueteIngreso(Sistema modelo) {
        this.modelo = modelo;
        initComponents();
        this.objetoAPantalla();
    }

    @SuppressWarnings("unchecked")
    
    private void objetoAPantalla(){
        lstClientes.setListData(modelo.getClientes().toArray());
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstClientes = new javax.swing.JList<>();
        txtId = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        lblDestinatario = new javax.swing.JLabel();
        lblDepartamento = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        btnCargar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtFecha = new javax.swing.JTextField();
        txtDestinatario = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmbDepartamento = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtDireccionDestino = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso de Paquetes");

        jPanel1.setLayout(null);

        lblId.setText("Id:");
        jPanel1.add(lblId);
        lblId.setBounds(40, 40, 90, 16);

        lstClientes.setModel(new javax.swing.AbstractListModel<Object>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstClientes);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(100, 90, 290, 110);

        txtId.addActionListener(this::txtIdActionPerformed);
        jPanel1.add(txtId);
        txtId.setBounds(100, 40, 290, 26);

        lblFecha.setText("Fecha (dd/mm/yyyy):");
        jPanel1.add(lblFecha);
        lblFecha.setBounds(40, 210, 130, 16);

        lblDestinatario.setText("Nombre destinatario:");
        jPanel1.add(lblDestinatario);
        lblDestinatario.setBounds(40, 240, 140, 16);

        lblDepartamento.setText("Departamento:");
        jPanel1.add(lblDepartamento);
        lblDepartamento.setBounds(40, 310, 100, 16);

        lblPeso.setText("Peso (en gramos):");
        jPanel1.add(lblPeso);
        lblPeso.setBounds(40, 340, 130, 16);

        btnCargar.setText("Cargar Paquete");
        btnCargar.addActionListener(this::btnCargarActionPerformed);
        jPanel1.add(btnCargar);
        btnCargar.setBounds(120, 390, 140, 27);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(270, 390, 140, 27);

        txtFecha.addActionListener(this::txtFechaActionPerformed);
        jPanel1.add(txtFecha);
        txtFecha.setBounds(180, 210, 210, 26);
        jPanel1.add(txtDestinatario);
        txtDestinatario.setBounds(180, 240, 210, 26);
        jPanel1.add(txtPeso);
        txtPeso.setBounds(180, 340, 210, 26);

        jLabel1.setText("Cliente:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 90, 80, 16);

        cmbDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Artigas", "Canelones", "Cerro Largo", "Colonia", "Durazno", "Flores", "Florida", "Lavalleja", "Maldonado", "Montevideo", "Paysandú", "Río Negro", "Rivera", "Rocha", "Salto", "San José", "Soriano", "Tacuarembó", "Treinta y Tres" }));
        cmbDepartamento.addActionListener(this::cmbDepartamentoActionPerformed);
        jPanel1.add(cmbDepartamento);
        cmbDepartamento.setBounds(180, 310, 210, 26);

        jLabel2.setText("Dirección destinatario:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 270, 140, 20);
        jPanel1.add(txtDireccionDestino);
        txtDireccionDestino.setBounds(180, 270, 210, 26);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setBounds(0, 0, 472, 496);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        sdf.setLenient(false);
        
        boolean todoOk = true;
        String msjError = "";
        
        try{    
            String id = txtId.getText();
            Cliente cliente = (Cliente) lstClientes.getSelectedValue();
            Date fecha = sdf.parse(txtFecha.getText());
            String destinatario = txtDestinatario.getText();
            String direccionDestino = txtDireccionDestino.getText();
            String departamento = (String) cmbDepartamento.getSelectedItem();
            String peso = txtPeso.getText();
            int pesoInt = 0;

            //validacion Textos vacíos (No estoy validadno cliente)
            if(  (this.modelo.textoVacio(id)) ||
                 (this.modelo.textoVacio(destinatario)) ||
                 (this.modelo.textoVacio(direccionDestino)) ||
                 (this.modelo.textoVacio(peso)) 
            ){
                todoOk = false;
                msjError = "Debe completar todos los campos.";
            }
            else{
                pesoInt = Integer.parseInt(peso);
            }

            if(todoOk && !(this.modelo.esAlfanumerico(id))){
                todoOk = false;
                msjError = "El Id debe contener únicamente letras y/o números";
            }
            
            if (todoOk && (cliente == null)) {
                todoOk = false;
                msjError = "Debe seleccionar un cliente";
            }

            if(todoOk){ 
                String zona = this.modelo.zonaDepartamento(departamento);
                int precio = this.modelo.calcularPrecio(zona, pesoInt);

                Paquete nuevoPaquete = new Paquete(id, cliente, fecha, destinatario, direccionDestino, departamento, pesoInt, precio, zona);

                PaqueteIngresoConfirmacion confirm = new PaqueteIngresoConfirmacion(modelo, nuevoPaquete);
                confirm.setVisible(true);

            }
            else{
                JOptionPane.showMessageDialog(this, msjError, "Error", JOptionPane.ERROR_MESSAGE);
            }      
        } catch(ParseException e){
            msjError = "Introduzca una fecha en formato DD/MM/YYYY";
            JOptionPane.showMessageDialog(this, msjError, "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            msjError = "El peso debe ser un número.";
            JOptionPane.showMessageDialog(this, msjError, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCargarActionPerformed

    private void cmbDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDepartamentoActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCargar;
    private javax.swing.JComboBox<String> cmbDepartamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblDestinatario;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JList<Object> lstClientes;
    private javax.swing.JTextField txtDestinatario;
    private javax.swing.JTextField txtDireccionDestino;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables

}

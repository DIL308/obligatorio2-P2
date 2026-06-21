package interfaz;
import dominio.Sistema;
import dominio.Cliente;
import dominio.Paquete;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.DefaultTableModel;

/*
 * Trabajo realizado por 
 * (333503) Daniel López
 * (372277) Lautaro Moreno
 */
public class PaqueteIngreso extends javax.swing.JFrame implements Observer{

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PaqueteIngreso.class.getName());
    
    Sistema modelo;
    
    public PaqueteIngreso(Sistema modelo) {
        this.modelo = modelo;
        this.modelo.addObserver(this);
        initComponents();
        this.objetoAPantalla();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    
    private void objetoAPantalla(){
        lstClientes.setListData(modelo.getClientes().toArray());
        this.cargarTabla();
    }

    @Override
    public void update(Observable o, Object arg) {
        objetoAPantalla();
    }
    
    private void cargarTabla() {

        DefaultTableModel modeloTabla = (DefaultTableModel) tblPaquetes.getModel();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        modeloTabla.setRowCount(0);

        for (Paquete paquete : this.modelo.getPaquetes()) {

            modeloTabla.addRow(new Object[]{
                paquete.getId(), 
                paquete.getCliente(),
                sdf.format(paquete.getFecha()),
                paquete.getDestinatario(),
                paquete.getDireccionEnvio(),
                paquete.getDepartamentoEnvio(),
                paquete.getPeso(),
                paquete.getZona(),
                paquete.getPrecio(),
                paquete.getEstado()
            });
        }
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
        lblTitulo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPaquetes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso de Paquetes");
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        lblId.setText("Id:");
        jPanel1.add(lblId);
        lblId.setBounds(170, 40, 90, 16);

        jScrollPane1.setViewportView(lstClientes);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(230, 90, 290, 110);

        txtId.addActionListener(this::txtIdActionPerformed);
        jPanel1.add(txtId);
        txtId.setBounds(230, 40, 290, 26);

        lblFecha.setText("Fecha (dd/mm/yyyy):");
        jPanel1.add(lblFecha);
        lblFecha.setBounds(170, 210, 130, 16);

        lblDestinatario.setText("Nombre destinatario:");
        jPanel1.add(lblDestinatario);
        lblDestinatario.setBounds(170, 240, 140, 16);

        lblDepartamento.setText("Departamento:");
        jPanel1.add(lblDepartamento);
        lblDepartamento.setBounds(170, 310, 100, 16);

        lblPeso.setText("Peso (en gramos):");
        jPanel1.add(lblPeso);
        lblPeso.setBounds(170, 340, 130, 16);

        btnCargar.setText("Cargar Paquete");
        btnCargar.addActionListener(this::btnCargarActionPerformed);
        jPanel1.add(btnCargar);
        btnCargar.setBounds(250, 390, 140, 27);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(400, 390, 140, 27);

        txtFecha.addActionListener(this::txtFechaActionPerformed);
        jPanel1.add(txtFecha);
        txtFecha.setBounds(310, 210, 210, 26);
        jPanel1.add(txtDestinatario);
        txtDestinatario.setBounds(310, 240, 210, 26);
        jPanel1.add(txtPeso);
        txtPeso.setBounds(310, 340, 210, 26);

        jLabel1.setText("Cliente:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(170, 90, 80, 16);

        cmbDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Artigas", "Canelones", "Cerro Largo", "Colonia", "Durazno", "Flores", "Florida", "Lavalleja", "Maldonado", "Montevideo", "Paysandú", "Río Negro", "Rivera", "Rocha", "Salto", "San José", "Soriano", "Tacuarembó", "Treinta y Tres" }));
        cmbDepartamento.addActionListener(this::cmbDepartamentoActionPerformed);
        jPanel1.add(cmbDepartamento);
        cmbDepartamento.setBounds(310, 310, 210, 26);

        jLabel2.setText("Dirección destinatario:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(170, 270, 140, 20);
        jPanel1.add(txtDireccionDestino);
        txtDireccionDestino.setBounds(310, 270, 210, 26);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblTitulo.setText("Crear Paquete");
        jPanel1.add(lblTitulo);
        lblTitulo.setBounds(270, 0, 240, 30);

        tblPaquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Cliente", "Fecha", "Destinatario", "Dirección", "Dpto", "Peso", "Zona", "Precio", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblPaquetes);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 440, 720, 150);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(6, 6, 760, 610);

        setBounds(0, 0, 775, 646);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        
        boolean todoOk = true;
        String mensaje = "";
        
        try{    
            String id = txtId.getText().trim();
            Cliente cliente = (Cliente) lstClientes.getSelectedValue();
            Date fecha = sdf.parse(txtFecha.getText().trim());
            String destinatario = txtDestinatario.getText().trim();
            String direccionDestino = txtDireccionDestino.getText().trim();
            String departamento = (String) cmbDepartamento.getSelectedItem();
            String peso = txtPeso.getText().trim();
            int pesoInt = 0;

            //validacion Textos vacíos (No estoy validadno cliente)
            if(  (this.modelo.textoVacio(id)) ||
                 (this.modelo.textoVacio(destinatario)) ||
                 (this.modelo.textoVacio(direccionDestino)) ||
                 (this.modelo.textoVacio(peso)) ||
                 (this.modelo.textoVacio(departamento)) 
            ){
                todoOk = false;
                mensaje = "Debe completar todos los campos.";
            }
            else{
                pesoInt = Integer.parseInt(peso);
            }
            
            if (fecha.before(sdf.parse("01/01/2020")) || fecha.after(sdf.parse("31/12/2026"))) {
                todoOk = false;
                mensaje = "Rango de fecha permitido entre 01/01/2020 y 31/12/2026";
            }

            if(todoOk && !(this.modelo.esAlfanumerico(id))){
                todoOk = false;
                mensaje = "El Id debe contener únicamente letras y/o números";
            }
            
            if (todoOk && (cliente == null)) {
                todoOk = false;
                mensaje = "Debe seleccionar un cliente";
            }
            
            if (todoOk & (!this.modelo.esSoloLetrasYEspacios(destinatario))){
                todoOk = false;
                mensaje = "El destinatario no puede contener números ni caracteres especiales";
            }
            
            if (todoOk){
                for(int i=0; (i<this.modelo.getPaquetes().size()) && todoOk; i++){
                    if(modelo.getPaquetes().get(i).getId().equalsIgnoreCase(id)){
                        mensaje = "Ya existe un paquete creado con este Id";
                        todoOk = false;
                    }
                }
            }

            if(todoOk){ 
                String zona = this.modelo.zonaDepartamento(departamento);
                int precio = this.modelo.calcularPrecio(zona, pesoInt);

                Paquete nuevoPaquete = new Paquete(id, cliente, fecha, destinatario, direccionDestino, departamento, pesoInt, precio, zona);
                
                int opcion = JOptionPane.showConfirmDialog(this, "El costo del paquete es de " + nuevoPaquete.getPrecio() + ". ¿Desea crear el paquete?", "Confirmación",JOptionPane.YES_NO_OPTION);
                
                if(opcion == JOptionPane.YES_OPTION){
                    this.modelo.agregarPaquete(nuevoPaquete);
                    txtId.setText("");
                    lstClientes.clearSelection();
                    txtFecha.setText("");
                    txtDestinatario.setText("");
                    txtDireccionDestino.setText("");
                    cmbDepartamento.setSelectedIndex(0);
                    txtPeso.setText("");
                    mensaje = "El paquete fue creado con éxito.";
                }else{
                    mensaje = "Se canceló la creación del paquete.";
     
                }
                JOptionPane.showMessageDialog(this, mensaje, "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
            }      
        } catch(ParseException e){
            mensaje = "Fecha inválida.";
            JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            mensaje = "El peso debe ser un número.";
            JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDepartamento;
    private javax.swing.JLabel lblDestinatario;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPeso;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JList<Object> lstClientes;
    private javax.swing.JTable tblPaquetes;
    private javax.swing.JTextField txtDestinatario;
    private javax.swing.JTextField txtDireccionDestino;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables

}

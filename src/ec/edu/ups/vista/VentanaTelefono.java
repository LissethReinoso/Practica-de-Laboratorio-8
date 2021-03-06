/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorTelefono;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GAMER PC
 */
public class VentanaTelefono extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaTelefono
     */
    
    int codigo;
    private Telefono telefono;
    private TelefonoDAO telefonoDAO;
    
    private ControladorTelefono controladorTelefono;
    
    private VentanaIniciarSecion ventanaIniciarSecion;
    
    public VentanaTelefono(VentanaIniciarSecion ventanaIniciarSecion) {
        initComponents();
        
        this.ventanaIniciarSecion = ventanaIniciarSecion;
        
        codigo = 0;
        
        telefonoDAO = new TelefonoDAO();
        
        controladorTelefono = new ControladorTelefono(telefonoDAO);
        telefono=new Telefono();
    }

    public void tablaTelefonos(){
         DefaultTableModel modelo = (DefaultTableModel) tblTelefonos.getModel();

        modelo.setRowCount(0);

        for (Telefono telefono : controladorTelefono.verTelefonos()) {
            Object[] rowData = {telefono.getCodigo(), telefono.getNumero().trim(),
                telefono.getOperadora().trim(), telefono.getTipo().trim()};
            modelo.addRow(rowData);
        }
        tblTelefonos.setModel(modelo);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbxOperadora = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTelefonos = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtNumeroF = new javax.swing.JFormattedTextField();

        setClosable(true);

        jLabel5.setText("Codigo:");

        txtCodigo.setText("0");
        txtCodigo.setEnabled(false);

        jLabel6.setText("Numero:");

        jLabel7.setText("Tipo:");

        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción", "Casa", "Trabajo", "Móvil", "Fax casa", "Fax trabajo", "Localizador" }));
        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });

        jLabel9.setText("Operadora:");

        cbxOperadora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opción", "Movistar", "Claro", "CNT", "Tuenti", "Tigo" }));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tblTelefonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Número", "Tipo", "Operadora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTelefonos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTelefonosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTelefonos);

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtNumeroF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(37, 37, 37)
                        .addComponent(txtCodigo))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbxOperadora, javax.swing.GroupLayout.Alignment.LEADING, 0, 165, Short.MAX_VALUE)
                                    .addComponent(cbxTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgregar)
                                    .addComponent(txtNumeroF, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(btnActualizar)
                        .addGap(42, 42, 42)
                        .addComponent(btnEliminar)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNumeroF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(cbxOperadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if(txtNumeroF.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "Ingrese un numero de telefono", "Error", 0);
        } else {
            String numero = txtNumeroF.getText();
            int i = cbxTipo.getSelectedIndex();
            String tipo = cbxTipo.getItemAt(i);
            int index = cbxOperadora.getSelectedIndex();
            String operadora = cbxOperadora.getItemAt(index);
            Telefono telefono = new Telefono(codigo, numero, tipo, operadora);
            Usuario u = ventanaIniciarSecion.usuario();
            telefono.setCodigo(codigo);
            controladorTelefono.registrar(telefono);
            System.out.println(controladorTelefono.verTelefonos().toString());
            
            codigo++;
        }
        txtCodigo.setText(codigo + "");
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
            // TODO add your handling code here:
         String numero = txtNumeroF.getText();
        String operadora = cbxOperadora.getSelectedItem().toString();
        String tipo = cbxTipo.getSelectedItem().toString();
        int codigo = Integer.parseInt(txtCodigo.getText());

        if(numero.isEmpty() && tipo.equals(cbxTipo.getItemAt(0)) && operadora.equals(cbxOperadora.getItemAt(0))){
            JOptionPane.showMessageDialog(this, "Llene todas las casillas");
        }else
        if (numero.isEmpty() || tipo.equals(cbxTipo.getItemAt(0)) || operadora.equals(cbxOperadora.getItemAt(0))) {
            JOptionPane.showMessageDialog(this, "Llene todas las casillas");
        } else {
            controladorTelefono.actualizar(codigo,numero,tipo,operadora);
            JOptionPane.showMessageDialog(this, "Actualización completada");
            tablaTelefonos();
            

        }
        
        
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        
         int codigo = Integer.parseInt(txtCodigo.getText());
            controladorTelefono.eliminar(codigo, telefono);
            JOptionPane.showMessageDialog(this, "Telefono eliminado");
           
            tablaTelefonos();
            
        
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed
        // TODO add your handling code here:
        try{
        String opcion=(String) cbxTipo.getSelectedItem();
        if(opcion.equals("Casa")){
         txtNumeroF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(+593)#-####-###")));
        }else if(opcion.equals("Trabajo")){
             txtNumeroF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(+593)#-####-###")));
        }else if(opcion.equals("Móvil")){
             txtNumeroF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(+593)#-####-####")));
        }else if(opcion.equals("Fax casa")){
             txtNumeroF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-####")));
        }else if(opcion.equals("Fax trabajo")){
             txtNumeroF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-####")));
        }else if(opcion.equals("Localizador")){
              txtNumeroF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-####")));
            }
        }catch(java.text.ParseException ex){
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_cbxTipoActionPerformed

    private void txtNumeroFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroFActionPerformed
        // TODO add your handling code here:
        
        if(cbxTipo.getSelectedIndex()==0){
            cbxTipo.requestFocus();
        }
        JOptionPane.showMessageDialog(this,"Ingrese el tipo de telefono");
    }//GEN-LAST:event_txtNumeroFActionPerformed

    private void tblTelefonosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTelefonosMouseClicked
        // TODO add your handling code here:
        
         int f = tblTelefonos.getSelectedRow();
        int codigo = (int) tblTelefonos.getValueAt(f, 0);
        String numero = (String) tblTelefonos.getValueAt(f, 1);
        String tipo = (String) tblTelefonos.getValueAt(f, 2);
        String operadora = (String) tblTelefonos.getValueAt(f, 3);

        txtCodigo.setText(String.valueOf(codigo));
        txtNumeroF.setValue(numero);
        cbxTipo.setSelectedItem(tipo);
        cbxOperadora.setSelectedItem(operadora);

        
        
    }//GEN-LAST:event_tblTelefonosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cbxOperadora;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTelefonos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtNumeroF;
    // End of variables declaration//GEN-END:variables
}

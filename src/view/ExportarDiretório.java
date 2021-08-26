package view;

import java.awt.Cursor;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

/**
 *
 * @author leonardo.fabris
 */
public class ExportarDiretório extends javax.swing.JInternalFrame {

    private DefaultListModel<String> model;
    private File arquivosIcones[];
    private String ultimoDiretorio = "";

    public ExportarDiretório() {
        initComponents();
        labelStatus.setText("");
        btnExportar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDirIcones = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDirDestino = new javax.swing.JTextField();
        btnSelDirIcones = new javax.swing.JButton();
        btnSelDirDestino = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        jSeparator2 = new javax.swing.JSeparator();
        labelStatus = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Exportação de Vários Arquivos");

        jLabel1.setText("Diretorio dos ícones:");

        jLabel2.setText("Diretório Destino:");

        btnSelDirIcones.setText("...");
        btnSelDirIcones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelDirIconesActionPerformed(evt);
            }
        });

        btnSelDirDestino.setText("...");
        btnSelDirDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelDirDestinoActionPerformed(evt);
            }
        });

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        labelStatus.setText("X Arquivos Encontrados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDirDestino)
                            .addComponent(txtDirIcones))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSelDirIcones, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSelDirDestino, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDirIcones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelDirIcones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDirDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelDirDestino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExportar)
                    .addComponent(labelStatus))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelDirIconesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelDirIconesActionPerformed
        JFileChooser seleciona = new JFileChooser(ultimoDiretorio);
        seleciona.setDialogType(JFileChooser.OPEN_DIALOG);
        seleciona.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        seleciona.showOpenDialog(null);

        try {
            txtDirIcones.setText(seleciona.getSelectedFile().getAbsolutePath());
            ultimoDiretorio = seleciona.getSelectedFile().getAbsolutePath();
        } catch (NullPointerException ex) {
        }

        processarArquivosDiretorio();
    }//GEN-LAST:event_btnSelDirIconesActionPerformed

    private void btnSelDirDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelDirDestinoActionPerformed
        JFileChooser seleciona = new JFileChooser(ultimoDiretorio);
        seleciona.setDialogType(JFileChooser.OPEN_DIALOG);
        seleciona.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        seleciona.showOpenDialog(null);

        try {
            txtDirDestino.setText(seleciona.getSelectedFile().getAbsolutePath());
            ultimoDiretorio = seleciona.getSelectedFile().getAbsolutePath();
        } catch (NullPointerException ex) {
        }
    }//GEN-LAST:event_btnSelDirDestinoActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        arquivosIcones = new File[model.getSize()];
        for (int i = 0; i < model.getSize(); i++) {
            arquivosIcones[i] = new File(txtDirIcones.getText() + File.separator + model.get(i));
        }
        new Exportacao(null, true, txtDirDestino.getText(), arquivosIcones).setVisible(true);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnExportarActionPerformed

    private void listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMouseClicked
        if(evt.getClickCount() == 2) {
            System.out.println("chamou a tela");
            Principal.adicionaPainel(new ExportarIcone(new File(txtDirIcones.getText() + File.separator + model.get(lista.getSelectedIndex()))));
        }
    }//GEN-LAST:event_listaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnSelDirDestino;
    private javax.swing.JButton btnSelDirIcones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JList<String> lista;
    private javax.swing.JTextField txtDirDestino;
    private javax.swing.JTextField txtDirIcones;
    // End of variables declaration//GEN-END:variables

    private void processarArquivosDiretorio() {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        model = new DefaultListModel<>();

        File diretorio = new File(txtDirIcones.getText());

        File arquivos[] = diretorio.listFiles();

        for (File arq : arquivos) {
            if (arq.getName().endsWith(".ico")) {
                model.addElement(arq.getName());
            }
        }

        lista.setModel(model);
        labelStatus.setText(String.valueOf(model.size()) + " arquivos encontrados.");
        if (model.size() > 0) {
            btnExportar.setEnabled(true);
        } else {
            btnExportar.setEnabled(false);
        }

        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }

}

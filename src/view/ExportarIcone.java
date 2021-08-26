package view;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.sf.image4j.codec.ico.ICODecoder;

/**
 *
 * @author leonardo.fabris
 */
public class ExportarIcone extends javax.swing.JInternalFrame {

    private List<BufferedImage> images;
    private int posicao = 0;
    private File arquivoICO;
    private String ultimaPasta;
    private String dirDestino;

    public ExportarIcone() {
        initComponents();
        ultimaPasta = System.getProperty("user.home");
        btnProximo.setEnabled(false);
        btnVoltar.setEnabled(false);
    }
    
    public ExportarIcone(File arquivo) {
        initComponents();
        
        ultimaPasta = System.getProperty("user.home");
        btnProximo.setEnabled(false);
        btnVoltar.setEnabled(false);
        btnProcurar.setEnabled(false);
        
        this.arquivoICO = arquivo;
        txtDirIcone.setText(arquivo.getAbsolutePath());
        txtDirIcone.setEnabled(false);
        criarIcones();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDirIcone = new javax.swing.JTextField();
        btnProcurar = new javax.swing.JButton();
        icone = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        labelNomeIcone = new javax.swing.JLabel();
        btnProximo = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Exportação de Arquivo Único");

        jLabel1.setText("Ícone:");

        btnProcurar.setText("Procurar");
        btnProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcurarActionPerformed(evt);
            }
        });

        icone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icone.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnVoltar.setText("<<<<<");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        labelNomeIcone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNomeIcone.setText("Nome do icone");

        btnProximo.setText(">>>>>");
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNomeIcone, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProximo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDirIcone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProcurar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExportar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDirIcone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcurar)
                    .addComponent(btnExportar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icone, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProximo)
                    .addComponent(btnVoltar)
                    .addComponent(labelNomeIcone))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcurarActionPerformed
        JFileChooser seleciona = new JFileChooser(ultimaPasta);
        seleciona.setDialogTitle("Selecione o arquivo do ícone");
        seleciona.setDialogType(JFileChooser.OPEN_DIALOG);
        seleciona.setFileSelectionMode(JFileChooser.FILES_ONLY);
        seleciona.setMultiSelectionEnabled(false);
        seleciona.showOpenDialog(this);

        if (seleciona.getSelectedFile() != null) {
            if (seleciona.getSelectedFile().getName().endsWith(".ico")) {
                posicao = 0;
                txtDirIcone.setText(seleciona.getSelectedFile().getAbsolutePath());
                ultimaPasta = seleciona.getSelectedFile().getPath();
                arquivoICO = seleciona.getSelectedFile();
                criarIcones();
            } else {
                JOptionPane.showMessageDialog(null, "Arquivo não suportado.");
            }
        }
    }//GEN-LAST:event_btnProcurarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        if (posicao > 0) {
            posicao--;
            mostrarIcone();
        }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        if (posicao < images.size()) {
            posicao++;
            mostrarIcone();
        }

        verificaBotoes();
    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        JFileChooser seleciona = new JFileChooser();
        seleciona.setDialogType(JFileChooser.OPEN_DIALOG);
        seleciona.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        seleciona.setDialogTitle("Selecione o local para exportação...");
        seleciona.showOpenDialog(null);

        try {
            dirDestino = seleciona.getSelectedFile().getAbsolutePath();

            gerarPNG(images.get(posicao), arquivoICO.getName());
            
            JOptionPane.showMessageDialog(null, "Arquivo exportado com sucesso!");
        } catch (HeadlessException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao exportar o icone:\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um local para exportação.", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnProcurar;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel icone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelNomeIcone;
    private javax.swing.JTextField txtDirIcone;
    // End of variables declaration//GEN-END:variables

    private void criarIcones() {
        try {
            images = ICODecoder.read(arquivoICO);
            mostrarIcone();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo:\n" + ex.getMessage());
            Logger.getLogger(ExportarIcone.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void mostrarIcone() {
        icone.setIcon(new ImageIcon(images.get(posicao)));
        labelNomeIcone.setText(arquivoICO.getName() + " (" + (posicao + 1) + "/" + images.size() + " - " + images.get(posicao).getWidth() + " x " + images.get(posicao).getHeight() + ")");
        verificaBotoes();
    }

    private void verificaBotoes() {
        if (posicao == (images.size() - 1)) {
            btnProximo.setEnabled(false);
        } else if (posicao < images.size()) {
            btnProximo.setEnabled(true);
        }

        if (posicao == 0) {
            btnVoltar.setEnabled(false);
        } else if (posicao > 0) {
            btnVoltar.setEnabled(true);
        }
    }

    private void gerarPNG(BufferedImage img, String nome) throws IOException {

        int new_w = img.getWidth(), new_h = img.getHeight();

        Image imagem = img.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH);

        BufferedImage new_img = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = new_img.createGraphics();
        g.setComposite(AlphaComposite.Clear);
        g.fillRect(0, 0, new_w, new_h);

        g.setComposite(AlphaComposite.Src);
        g.drawImage(imagem, 0, 0, new_w, new_h, null);

        ImageIO.write(new_img, "PNG", new File(dirDestino + File.separator + nome.replaceAll(".ico", "") + ".png"));

    }

}

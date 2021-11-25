package br.com.leofabris.icoViewer;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Cursor;
import javax.swing.JInternalFrame;

/**
 * @author Leonardo F. Fabris
 */
public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        menuArquivoUnico = new javax.swing.JMenuItem();
        menuDiretorio = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conversão de ICO para PNG");

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 999, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
        );

        menuArquivo.setText("Arquivo");

        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        menuArquivo.add(menuSair);

        jMenuBar1.add(menuArquivo);

        jMenu2.setText("Conversão");

        jMenu3.setText("ICO -> PNG");

        menuArquivoUnico.setText("Arquivo Único");
        menuArquivoUnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArquivoUnicoActionPerformed(evt);
            }
        });
        jMenu3.add(menuArquivoUnico);

        menuDiretorio.setText("Diretório");
        menuDiretorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDiretorioActionPerformed(evt);
            }
        });
        jMenu3.add(menuDiretorio);

        jMenu2.add(jMenu3);

        jMenu4.setText("PNG -> ICO");

        jMenuItem1.setText("Arquivo Único");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem1);

        jMenu2.add(jMenu4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuSairActionPerformed

    private void menuDiretorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDiretorioActionPerformed
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        adicionaPainel(new ExportarDiretório());
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuDiretorioActionPerformed

    private void menuArquivoUnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuArquivoUnicoActionPerformed
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        adicionaPainel(new ExportarIcone());
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuArquivoUnicoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        adicionaPainel(new PNGtoICOUnico());
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String args[]) {
        FlatLightLaf.setup();

        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuItem menuArquivoUnico;
    private javax.swing.JMenuItem menuDiretorio;
    private javax.swing.JMenuItem menuSair;
    // End of variables declaration//GEN-END:variables

    public static void adicionaPainel(JInternalFrame painel) {
        int qtd = desktop.getComponentCount();
        boolean existe = false;
        int idPainel = 0;
        int largura_internalFrame = painel.getWidth();
        int altura_internalFrame = painel.getHeight();
        int largura_desktop = desktop.getWidth();
        int altura_desktop = desktop.getHeight();
        int pos_x = largura_desktop - largura_internalFrame;
        int pos_y = altura_desktop - altura_internalFrame;

        try {
            for (int x = 0; x < qtd; x++) {
                if (desktop.getComponent(x).getName().equals(painel.getName())) {
                    existe = true;
                    idPainel = x;
                }
            }
        } catch (NullPointerException ex) {
            existe = false;
        }

        if (existe) {
            desktop.getComponent(idPainel).setVisible(true);
            desktop.getComponent(idPainel).requestFocus();
        } else {
            desktop.add(painel);
            painel.setVisible(true);
            painel.setLocation(pos_x / 2, pos_y / 2);
        }
    }

}

package view;

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
        menuConverter = new javax.swing.JMenu();
        menuArquivoUnico = new javax.swing.JMenuItem();
        menuDiretorio = new javax.swing.JMenuItem();

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

        menuConverter.setText("Converter");

        menuArquivoUnico.setText("Arquivo Único");
        menuArquivoUnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuArquivoUnicoActionPerformed(evt);
            }
        });
        menuConverter.add(menuArquivoUnico);

        menuDiretorio.setText("Diretório");
        menuDiretorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDiretorioActionPerformed(evt);
            }
        });
        menuConverter.add(menuDiretorio);

        jMenuBar1.add(menuConverter);

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

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenuItem menuArquivoUnico;
    private javax.swing.JMenu menuConverter;
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

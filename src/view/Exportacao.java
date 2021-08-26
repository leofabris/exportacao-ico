package view;

import java.awt.AlphaComposite;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import net.sf.image4j.codec.ico.ICODecoder;

/**
 *
 * @author leonardo.fabris
 */
public class Exportacao extends javax.swing.JDialog {

    //private ArrayList<BufferedImage> arquivosAProcessar;
    private File arquivosIcones[];
    private String destino;
    private Map<String, BufferedImage> arquivosAProcessar = new HashMap<>();
    private StringBuilder str = new StringBuilder();
    boolean terminou = false;
    private Thread t = new Thread(new Runnable() {
        @Override
        public void run() {

            Runnable atualBarraProgresso = new Runnable() {
                @Override
                public void run() {
                    barraProgresso.setValue(barraProgresso.getValue() + 1);
                }
            };

            setCursor(new Cursor(Cursor.WAIT_CURSOR));

            jLabel1.setText("Lendo arquivos e separando suas dimensões...");
            
            List<BufferedImage> images;

            for (File a : arquivosIcones) {
                
                labelAcao.setText("Lendo arquivo " + a.getName() + "...");
                System.out.print("Lendo arquivo " + a.getName() + "... ");

                try {
                    images = ICODecoder.read(a);
                    for (BufferedImage i : images) {
                        arquivosAProcessar.put(a.getName().replaceAll(".ico", "") + i.getWidth() + "x" + i.getHeight() + ".ico", i);
                        System.out.println("[OK]");
                    }
                } catch (IOException ex) {
                    System.out.println("[ERROR]");
                }
            }

            barraProgresso.setIndeterminate(false);
            barraProgresso.setMaximum(arquivosAProcessar.size());
            barraProgresso.setValue(0);

            jLabel1.setText("Exportando arquivos...");
            
            arquivosAProcessar.forEach((nome, arquivo) -> {

                labelAcao.setText("Exportando arquivo " + nome + "...");
                System.out.print("Exportando arquivo " + nome + "... ");

                try {
                    gerarPNG(arquivo, nome);
                    SwingUtilities.invokeLater(atualBarraProgresso);
                    System.out.println("[OK]");
                } catch (IOException ex) {
                    System.out.println("[ERROR]");
                    str.append("Erro ao processar arquivo: ").append(nome).append("\n");
                }

            });

            if (str.toString().length() > 0) {
                JOptionPane.showMessageDialog(null, str.toString());
            }

            barraProgresso.setValue(arquivosAProcessar.size());
            System.out.println("Término da thread");
            JOptionPane.showMessageDialog(null, "Término de processo!");

            fecharJanela();

            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        }
    });

    public Exportacao(java.awt.Frame parent, boolean modal, String destino, File[] arquivosIcones) {
        super(parent, modal);
        initComponents();
        setCursor(new Cursor(Cursor.WAIT_CURSOR));

        this.arquivosIcones = arquivosIcones;
        this.destino = destino;

        iniciar();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        barraProgresso = new javax.swing.JProgressBar();
        labelAcao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel1.setText("Exportando aquivos, aguarde...");

        barraProgresso.setIndeterminate(true);

        labelAcao.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        labelAcao.setText("Lendo arquivos e suas dimensões...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barraProgresso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 399, Short.MAX_VALUE))
                    .addComponent(labelAcao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraProgresso, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAcao)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void gerarPNG(BufferedImage img, String nome) throws IOException {

        int new_w = img.getWidth(), new_h = img.getHeight();

        Image imagem = img.getScaledInstance(new_w, new_h, Image.SCALE_SMOOTH);

        BufferedImage new_img = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = new_img.createGraphics();
        g.setComposite(AlphaComposite.Clear);
        g.fillRect(0, 0, new_w, new_h);

        g.setComposite(AlphaComposite.Src);
        g.drawImage(imagem, 0, 0, new_w, new_h, null);

        ImageIO.write(new_img, "PNG", new File(destino + File.separator + nome.replaceAll(".ico", "") + ".png"));

    }

    private void fecharJanela() {
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgresso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelAcao;
    // End of variables declaration//GEN-END:variables

    public void iniciar() {

        t.start();

    }

}

package practica6;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageViewer extends javax.swing.JFrame {

    public ImageViewer() {
        nu.pattern.OpenCV.loadShared();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagePanel = new practica6.ImagePanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        optionsMenu = new javax.swing.JMenu();
        openOption = new javax.swing.JMenuItem();
        saveOption = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        thresholdingOption = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        quitOption = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        infoOption = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Umbralización de imagen");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 357, Short.MAX_VALUE)
        );

        optionsMenu.setMnemonic('O');
        optionsMenu.setText("Opciones");

        openOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openOption.setText("abrir");
        openOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openOptionActionPerformed(evt);
            }
        });
        optionsMenu.add(openOption);

        saveOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveOption.setText("guardar");
        saveOption.setEnabled(false);
        saveOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveOptionActionPerformed(evt);
            }
        });
        optionsMenu.add(saveOption);
        optionsMenu.add(jSeparator1);

        thresholdingOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        thresholdingOption.setText("umbralizar");
        thresholdingOption.setEnabled(false);
        thresholdingOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thresholdingOptionActionPerformed(evt);
            }
        });
        optionsMenu.add(thresholdingOption);
        optionsMenu.add(jSeparator2);

        quitOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        quitOption.setText("salir");
        quitOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitOptionActionPerformed(evt);
            }
        });
        optionsMenu.add(quitOption);

        jMenuBar1.add(optionsMenu);

        helpMenu.setMnemonic('A');
        helpMenu.setText("Ayuda");

        infoOption.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        infoOption.setText("Acerca de");
        infoOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoOptionActionPerformed(evt);
            }
        });
        helpMenu.add(infoOption);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void openOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openOptionActionPerformed
        saveOption.setEnabled(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png"));
        int res = fileChooser.showOpenDialog(null);
        if(res == JFileChooser.APPROVE_OPTION){
            try {
                File imageFile = fileChooser.getSelectedFile();
                imagePath = imageFile.getAbsolutePath();
                imagePanel.setImage(ImageIO.read(imageFile));
                imagePanel.repaint();
                thresholdingOption.setEnabled(true);
            } catch (IOException ex) {
                Logger.getLogger(ImageViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_openOptionActionPerformed

    private void saveOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveOptionActionPerformed
        int res = fileChooser.showSaveDialog(null);
        if(res == JFileChooser.APPROVE_OPTION){
            try {
                ImageIO.write(imagePanel.getImage(), "png",fileChooser.getSelectedFile());
            } catch (IOException ex) {
                Logger.getLogger(ImageViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_saveOptionActionPerformed

    private void thresholdingOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thresholdingOptionActionPerformed
        String input = JOptionPane.showInputDialog(rootPane, "Introduzca un umbral");
        if(input != null){
            try{
                int threshold = Integer.parseInt(input);
                if(threshold >= 0 && threshold <= 255){
                    Mat thresholdImage = thresholding(Imgcodecs.imread(imagePath), threshold);
                    imagePanel.setImage((BufferedImage) HighGui.toBufferedImage(thresholdImage));
                    imagePanel.repaint();
                    saveOption.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(rootPane, "El umbral debe estar en el rango 0..255.",
                            "Error en umbral", JOptionPane.ERROR_MESSAGE);
                }
            } catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(rootPane, "El umbral debe ser un entero.", "Error en umbral", JOptionPane.ERROR_MESSAGE);
            }
        }       
    }//GEN-LAST:event_thresholdingOptionActionPerformed

    private void quitOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitOptionActionPerformed
        int confirm = JOptionPane.showConfirmDialog(rootPane, "¿Desea salir de la aplicación?", "Salir aplicación", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            this.dispose();
        }
        
    }//GEN-LAST:event_quitOptionActionPerformed

    private void infoOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoOptionActionPerformed
        JOptionPane.showMessageDialog(rootPane, "La aplicación permite umbralizar imágenes.", "Acerca de", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_infoOptionActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int confirm = JOptionPane.showConfirmDialog(rootPane, "¿Desea salir de la aplicación?", "Salir aplicación", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    
    private Mat thresholding(Mat originalImage, Integer threshold){
        Mat greyImage = new Mat(originalImage.rows(), originalImage.cols(), CvType.CV_8U);
        Mat thresholdImage = new Mat(originalImage.rows(), originalImage.cols(), CvType.CV_8U);
        Imgproc.cvtColor(originalImage, greyImage, Imgproc.COLOR_BGR2GRAY);
        Imgproc.threshold(greyImage, thresholdImage, threshold, 255, Imgproc.THRESH_BINARY);
        return thresholdImage;
    }
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImageViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImageViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImageViewer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu helpMenu;
    private practica6.ImagePanel imagePanel;
    private javax.swing.JMenuItem infoOption;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem openOption;
    private javax.swing.JMenu optionsMenu;
    private javax.swing.JMenuItem quitOption;
    private javax.swing.JMenuItem saveOption;
    private javax.swing.JMenuItem thresholdingOption;
    // End of variables declaration//GEN-END:variables
    private final JFileChooser fileChooser = new JFileChooser();
    private String imagePath;
}

package librarymanagementsystem.GUI.HienThiGUI;

import javax.swing.JPanel;

public class ChoiceElement extends javax.swing.JFrame {

    public ChoiceElement(String image, String text) {
        initComponents(image, text);
    }
    
    public JPanel getPanel(){
        return jPanel1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents(String image, String text) {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        text_Label = new javax.swing.JLabel();
        form = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
        });
        
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource(image))); // NOI18N
        icon.setBounds(75, 30, 70, 70);
        jPanel1.add(icon);

        text_Label.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        text_Label.setForeground(new java.awt.Color(102, 102, 102));
        text_Label.setText(text);
        text_Label.setFocusable(false);
        text_Label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        text_Label.setBounds(61 + 5*(11 - text.length()), 113, 220, 30);
        jPanel1.add(text_Label);

        form.setIcon(new javax.swing.ImageIcon(getClass().getResource("../../images/output-onlinepngtools - 2020-06-17T135631.045.png"))); // NOI18N
        form.setBounds(0, 0, 220, 177);
        jPanel1.add(form);
        jPanel1.setBounds(0, 0, 220, 177);
        
        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>                        

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {                                     
        form.setIcon(new javax.swing.ImageIcon(getClass().getResource("../../images/output-onlinepngtools - 2020-06-17T135718.242.png"))); // NOI18N
    }                                    

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {                                    
        form.setIcon(new javax.swing.ImageIcon(getClass().getResource("../../images/output-onlinepngtools - 2020-06-17T135631.045.png"))); // NOI18N
    }                                   

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(ChoiceElement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChoiceElement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChoiceElement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChoiceElement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChoiceElement("../../images/output-onlinepngtools - 2020-06-17T140622.607.png", "QUẢN LÝ ADMIN").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel form;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel text_Label;
    // End of variables declaration                   
}

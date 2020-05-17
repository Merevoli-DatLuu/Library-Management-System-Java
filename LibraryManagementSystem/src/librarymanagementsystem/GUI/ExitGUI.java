package librarymanagementsystem.GUI;

import java.awt.Color;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class ExitGUI extends javax.swing.JFrame{
    
    int x_Mouse, y_Mouse; // For Moving Window
    
    public ExitGUI() {
        initComponents();
        setSize(400, 260);
        setLocationRelativeTo(null);
        setBackground(new Color(0, 0, 0, 0));
    }

                             
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        exit_btn = new javax.swing.JLabel();
        title_Label = new javax.swing.JLabel();
        movingWindow_Label = new javax.swing.JLabel();
        icon_main = new javax.swing.JLabel();
        question_main = new javax.swing.JLabel();
        dongy_btn = new javax.swing.JLabel();
        quaylai_btn = new javax.swing.JLabel();
        exitForm_Label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        exit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/exit_20_20.png"))); // NOI18N
        exit_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_btnMouseClicked(evt);
            }
        });
        exit_btn.setBounds(348, 24, 20, 20);
        jPanel1.add(exit_btn);

        title_Label.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        title_Label.setForeground(new java.awt.Color(89, 89, 89));
        title_Label.setText("Thoát chương trình");
        title_Label.setBounds(30, 25, 154, 21);
        jPanel1.add(title_Label);

        movingWindow_Label.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                movingWindow_LabelMouseDragged(evt);
            }
        });
        movingWindow_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                movingWindow_LabelMousePressed(evt);
            }
        });
        movingWindow_Label.setBounds(10, 10, 370, 40);
        jPanel1.add(movingWindow_Label);

        icon_main.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/question_main_80_80.png"))); // NOI18N
        icon_main.setToolTipText("");
        icon_main.setBounds(32, 75, 80, 80);
        jPanel1.add(icon_main);

        question_main.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        question_main.setText("Bạn muốn thoát chương trình ? ");
        question_main.setBounds(123, 105, 231, 23);
        jPanel1.add(question_main);

        dongy_btn.setBackground(new java.awt.Color(91, 231, 196));
        dongy_btn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        dongy_btn.setForeground(new java.awt.Color(255, 255, 255));
        dongy_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dongy_btn.setText("Đồng ý ");
        dongy_btn.setOpaque(true);
        dongy_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dongy_btnMouseClicked(evt);
            }
        });
        dongy_btn.setBounds(56, 175, 120, 40);
        jPanel1.add(dongy_btn);

        quaylai_btn.setBackground(new java.awt.Color(200, 206, 210));
        quaylai_btn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        quaylai_btn.setForeground(new java.awt.Color(255, 255, 255));
        quaylai_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quaylai_btn.setText("Quay Lại");
        quaylai_btn.setOpaque(true);
        quaylai_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quaylai_btnMouseClicked(evt);
            }
        });
        quaylai_btn.setBounds(227, 175, 120, 40);
        jPanel1.add(quaylai_btn);

        exitForm_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/exitGUI.png"))); // NOI18N
        exitForm_Label.setBounds(0, 0, 400, 260); // NOI18N
        jPanel1.add(exitForm_Label);
        jPanel1.setBounds(0, 0, 400, 260);

        getContentPane().add(jPanel1);

        pack();
    }                  

    private void exit_btnMouseClicked(java.awt.event.MouseEvent evt) {                                      
        this.dispose();
    }                                     

    private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
        System.out.println("Đồng ý");
        System.exit(0);
    }                                      

    private void quaylai_btnMouseClicked(java.awt.event.MouseEvent evt) {                                         
        System.out.println("Quay Lại");
        this.dispose();
    }                                        

    private void movingWindow_LabelMouseDragged(java.awt.event.MouseEvent evt) {                                                
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        setLocation(x - x_Mouse, y - y_Mouse);
    }                                               

    private void movingWindow_LabelMousePressed(java.awt.event.MouseEvent evt) {                                                
        x_Mouse = evt.getX();
        y_Mouse = evt.getY();
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
            java.util.logging.Logger.getLogger(ExitGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExitGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExitGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExitGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExitGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel dongy_btn;
    private javax.swing.JLabel exitForm_Label;
    private javax.swing.JLabel exit_btn;
    private javax.swing.JLabel icon_main;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel movingWindow_Label;
    private javax.swing.JLabel quaylai_btn;
    private javax.swing.JLabel question_main;
    private javax.swing.JLabel title_Label;
    // End of variables declaration                
}

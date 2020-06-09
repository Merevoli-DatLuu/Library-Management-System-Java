package librarymanagementsystem.GUI.ChonGUI;

public class Filter extends javax.swing.JFrame {

    public Filter(String choice) {
        initComponents(choice);
        setSize(480, 280);
        setLocationRelativeTo(null);
    }
                        
    private void initComponents(String choice) {

        jPanel1 = new javax.swing.JPanel();
        tittle = new javax.swing.JLabel();
        choice_1 = new javax.swing.JComboBox<>();
        choice_2 = new javax.swing.JComboBox<>();
        textfield_1 = new javax.swing.JTextField();
        textfield_2 = new javax.swing.JTextField();
        andBtn = new javax.swing.JRadioButton();
        orBtn = new javax.swing.JRadioButton();
        line_1 = new javax.swing.JSeparator();
        line_2 = new javax.swing.JSeparator();
        quayluibtn = new javax.swing.JButton();
        dongybtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        tittle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tittle.setText("TÌM KIẾM NÂNG CAO");
        tittle.setBounds(49, 36, 152, 17);
        jPanel1.add(tittle);

        choice_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Equals", "Not Equals", "Greater Than", "Greater Than Or Equals To", "Less Than", "Less Than Or Equals To" }));
        choice_1.setBounds(50, 77, 155, 28);
        choice_1.setSelectedItem(choice);
        jPanel1.add(choice_1);

        choice_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Equals", "Not Equals", "Greater Than", "Greater Than Or Equals To", "Less Than", "Less Than Or Equals To" }));
        choice_2.setBounds(50, 146, 155, 28);
        jPanel1.add(choice_2);
        
        textfield_1.setBounds(268, 77, 183, 28);
        jPanel1.add(textfield_1);
        textfield_1.getAccessibleContext().setAccessibleName("");
        
        textfield_2.setBounds(268, 146, 183, 28);
        jPanel1.add(textfield_2);

        andBtn.setText("AND");
        andBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                andBtnMouseClicked(evt);
            }
        });
        andBtn.setBounds(62, 116, 60, 23);
        jPanel1.add(andBtn);

        orBtn.setText("OR");
        orBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orBtnMouseClicked(evt);
            }
        });
        orBtn.setBounds(127, 116, 60, 23);
        jPanel1.add(orBtn);
        line_1.setBounds(0, 45, 40, 4);
        line_2.setBounds(210, 45, 270, 4);
        jPanel1.add(line_1);
        jPanel1.add(line_2);

        quayluibtn.setText("Quay Lại");
        quayluibtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quayluibtnActionPerformed(evt);
            }
        });
        quayluibtn.setBounds(360, 195, 90, 30);
        jPanel1.add(quayluibtn);

        dongybtn.setText("Đồng Ý");
        dongybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dongybtnActionPerformed(evt);
            }
        });
        dongybtn.setBounds(270, 195, 80, 30);
        jPanel1.add(dongybtn);
        jPanel1.setBounds(0, 0, 480, 240);

        getContentPane().add(jPanel1);

        pack();
    }                      

    private void dongybtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.out.println(choice_1.getItemAt(choice_1.getSelectedIndex()) + " " + textfield_1.getText());
        System.out.println(choice_2.getItemAt(choice_2.getSelectedIndex()) + " " + textfield_2.getText());
        if (andBtn.isSelected()){
            System.out.println("And");
        }
        if (orBtn.isSelected()){
            System.out.println("OR");
        }
    }                                        

    private void quayluibtnActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.dispose();
    }                                          

    private void andBtnMouseClicked(java.awt.event.MouseEvent evt) {                                    
        orBtn.setSelected(false);
    }                                   

    private void orBtnMouseClicked(java.awt.event.MouseEvent evt) {                                   
        andBtn.setSelected(false);
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
            java.util.logging.Logger.getLogger(Filter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Filter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Filter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Filter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Filter("Greater Than").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JRadioButton andBtn;
    private javax.swing.JComboBox<String> choice_1;
    private javax.swing.JComboBox<String> choice_2;
    private javax.swing.JButton dongybtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator line_1;
    private javax.swing.JSeparator line_2;
    private javax.swing.JRadioButton orBtn;
    private javax.swing.JButton quayluibtn;
    private javax.swing.JTextField textfield_1;
    private javax.swing.JTextField textfield_2;
    private javax.swing.JLabel tittle;
    // End of variables declaration                   
}


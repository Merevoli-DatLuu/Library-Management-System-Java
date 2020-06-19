package librarymanagementsystem.GUI;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
import librarymanagementsystem.BUS.*;

public class LoginGUI extends JFrame{
    static String current_session = "";
    private JPanel exit_btn;        
    private JLabel jLabel_password;
    private JLabel jLabel_username;
    private JLabel login_form; // GUI Image
    private JLabel RFIDLogin;
    private JPanel pLogin;
    private JPasswordField password_field;
    private JTextField username_field;
    loginRFID RFIDlogin;
    
    public LoginGUI() {
        initComponents();
        setSize(530, 340);
        setLocationRelativeTo(null);
        setBackground(new Color(0, 0, 0, 0));
        jLabel_username.setBackground(new Color(0, 0, 0, 0));
        jLabel_password.setBackground(new Color(0, 0, 0, 0));
        username_field.setBackground(new Color(0, 0, 0, 0));
        password_field.setBackground(new Color(0, 0, 0, 0));
        username_field.setVisible(false);
        password_field.setVisible(false);
    }
                      
    private void initComponents() {

        pLogin = new javax.swing.JPanel();
        jLabel_username = new javax.swing.JLabel();
        jLabel_password = new javax.swing.JLabel();
        username_field = new javax.swing.JTextField();
        password_field = new javax.swing.JPasswordField();
        RFIDLogin = new javax.swing.JLabel();
        exit_btn = new javax.swing.JPanel();
        login_form = new javax.swing.JLabel();

        // *** Jframe *** //
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        // *** pLogin *** //
        pLogin.setOpaque(false);
        pLogin.setLayout(null);

        // *** jLabel_username *** //
        jLabel_username.setBackground(new java.awt.Color(91, 231, 196));
        jLabel_username.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel_username.setForeground(new java.awt.Color(245, 247, 250));
        jLabel_username.setText("Username");
        jLabel_username.setMaximumSize(new java.awt.Dimension(83, 21));
        jLabel_username.setMinimumSize(new java.awt.Dimension(83, 21));
        jLabel_username.setPreferredSize(new java.awt.Dimension(83, 21));
        jLabel_username.setBounds(138, 197, 83, 21);
        
        jLabel_username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_usernameMouseClicked(evt);
            }
        });
        pLogin.add(jLabel_username);
        
        // *** jLabel_password *** //
        jLabel_password.setBackground(new java.awt.Color(91, 231, 196));
        jLabel_password.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel_password.setForeground(new java.awt.Color(245, 247, 250));
        jLabel_password.setText("Password");
        jLabel_password.setMaximumSize(new java.awt.Dimension(83, 21));
        jLabel_password.setMinimumSize(new java.awt.Dimension(83, 21));
        jLabel_password.setPreferredSize(new java.awt.Dimension(83, 21));
        jLabel_password.setBounds(138, 250, 83, 21);
        jLabel_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_passwordMouseClicked(evt);
            }
        });
        pLogin.add(jLabel_password);

        // *** username_field *** //
        username_field.setBackground(new java.awt.Color(91, 231, 196));
        username_field.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        username_field.setForeground(new java.awt.Color(245, 247, 250));
        username_field.setBorder(null);
        username_field.setOpaque(false);
        username_field.setPreferredSize(new java.awt.Dimension(83, 21));
        username_field.setBounds(138, 197, 280, 21);
        username_field.setFocusTraversalKeysEnabled(false);
        
        username_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                username_fieldKeyPressed(evt);
            }
        });
        pLogin.add(username_field);

        // *** password_field *** //
        password_field.setBackground(new java.awt.Color(91, 231, 196));
        password_field.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        password_field.setForeground(new java.awt.Color(245, 247, 250));
        password_field.setBorder(null);
        password_field.setOpaque(false);
        password_field.setPreferredSize(new java.awt.Dimension(80, 21));
        password_field.setBounds(138, 250, 280, 21);
        password_field.setFocusTraversalKeysEnabled(false);
        password_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                password_fieldKeyPressed(evt);
            }
        });
        pLogin.add(password_field);

        // *** exit_btn *** //
        exit_btn.setOpaque(false);
        exit_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_btnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout exit_btnLayout = new javax.swing.GroupLayout(exit_btn);
        exit_btn.setLayout(exit_btnLayout);
        exit_btn.setBounds(470, 20, 30, 30);
        exit_btnLayout.setHorizontalGroup(
            exit_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        exit_btnLayout.setVerticalGroup(
            exit_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        pLogin.add(exit_btn);
        
        /** RFID login **/
        RFIDLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/icon_RFIDLogin_30_30.png"))); // NOI18N
        RFIDLogin.setBounds(417, 195, 30, 30);
        RFIDLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RFIDLoginMouseClicked(evt);
            }
        });
        pLogin.add(RFIDLogin);
        
        pLogin.setBounds(0, 0, 530, 340);
        login_form.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/login.png"))); // NOI18N
        login_form.setBounds(10, 10, 500, 312);
        pLogin.add(login_form);
        
        
        
        getContentPane().add(pLogin);

        pack();
    }                                                          

    private void exit_btnMouseClicked(java.awt.event.MouseEvent evt) {                                      
        System.exit(0);
    }                                                                             

    private void jLabel_usernameMouseClicked(java.awt.event.MouseEvent evt) {                                             
        jLabel_username.setVisible(false);
        username_field.setVisible(true);
        username_field.requestFocus();
    }                                            

    private void jLabel_passwordMouseClicked(java.awt.event.MouseEvent evt) {                                             
        jLabel_password.setVisible(false);
        password_field.setVisible(true);
        password_field.requestFocus();
    }                  
    
    /** for RFID **/
    private void RFIDLoginMouseClicked(java.awt.event.MouseEvent evt){
        //new loginRFID().setVisible(true);
        
        // System.out.println(t);
        if (RFIDlogin == null || !RFIDlogin.isDisplayable()){ // Hiển thị 1 windows tại 1 thời điểm 
            RFIDlogin = new loginRFID();
            RFIDlogin.setVisible(true);
            String tk = RFIDlogin.login_by_RFID();
            if (!tk.equals("")){
                RFIDlogin.dispose();
                current_session = tk;
                System.out.println("Đăng Nhập Thành Công");
                System.out.println("Current Session: " + current_session);
                //new MainGUI(current_session).setVisible(true);
                new Main_2(current_session).setVisible(true);
                new WelcomeGUI(current_session).setVisible(true);
                this.dispose();
            }
            else{
                RFIDlogin.dispose(); // Xóa sau
                System.out.println("Đăng Nhập thất bại");
            }
        }
    }
    
    public Boolean kiemTraDangNhap(){
        QLAdminBUS tkadmin = new QLAdminBUS();
        String admin = tkadmin.kiemTraTaiKhoan(username_field.getText(), password_field.getText());
        if (!admin.equals("")){
            current_session = admin;
            return true;
        }
        
        QLNhanVienBUS tknhanvien = new QLNhanVienBUS();
        String nhanvien = tknhanvien.kiemTraTaiKhoan(username_field.getText(), password_field.getText());
        if (!nhanvien.equals("")){
            current_session = nhanvien;
            return true;
        }
        
        return false;
    }
    
    public void DangNhap(){
        if (kiemTraDangNhap()){
            System.out.println("Đăng Nhập Thành Công");
            System.out.println("Current Session: " + current_session);
            //new MainGUI(current_session).setVisible(true);
            new Main_2(current_session).setVisible(true);
            new WelcomeGUI(current_session).setVisible(true);
            this.dispose();
        }
        else{
            new AlertGUI(1, "Login", "Đăng Nhập Thất Bại", "Quay Lại").setVisible(true);
            System.out.println("Đăng Nhập Thất Bại");
        }
    }

    private void formKeyPressed(java.awt.event.KeyEvent evt) {                                
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            System.out.println("Đăng Nhập" + "\t username: " + username_field.getText() + "\t password: " + password_field.getText());
            DangNhap();
        }
        else if (evt.getKeyCode() == KeyEvent.VK_TAB){
            jLabel_username.setVisible(false);
            username_field.setVisible(true);
            username_field.requestFocus();
        }
    }                               

    private void username_fieldKeyPressed(java.awt.event.KeyEvent evt) {
        //System.out.println(evt.getKeyCode());
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            System.out.println("Đăng Nhập" + "\t username: " + username_field.getText() + "\t password: " + password_field.getText());
            DangNhap();
        }
        else if (evt.getKeyCode() == KeyEvent.VK_TAB){
            jLabel_password.setVisible(false);
            password_field.setVisible(true);
            password_field.requestFocus();
        }
    }                                         

    private void password_fieldKeyPressed(java.awt.event.KeyEvent evt) {                                          
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            System.out.println("Đăng Nhập" + "\t username: " + username_field.getText() + "\t password: " + password_field.getText());
            DangNhap();
        }
        else if (evt.getKeyCode() == KeyEvent.VK_TAB){
            jLabel_username.setVisible(false);
            username_field.setVisible(true);
            username_field.requestFocus();
        }
    }                                         

    public static String getCurrent_session() {
        return current_session;
    }

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
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }
    
}

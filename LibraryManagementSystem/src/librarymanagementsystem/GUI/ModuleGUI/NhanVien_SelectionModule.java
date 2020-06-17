package librarymanagementsystem.GUI.ModuleGUI;

import librarymanagementsystem.GUI.*;
import librarymanagementsystem.GUI.HienThiGUI.*;
import javax.swing.JPanel;

public class NhanVien_SelectionModule{

    private Main_2 main_2 = new Main_2(0);
    public JPanel getNhanVien_SelectionModule() {
        initComponents();
        return jPanel1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);
        
        nhanvien_Choice = new ChoiceElement("../../images/output-onlinepngtools - 2020-06-17T140634.287.png", "QUẢN LÝ NHÂN VIÊN").getPanel();
        nhanvien_Choice.setBounds(180, 100, 220, 177);
        nhanvien_Choice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nhanvien_ChoiceMouseClicked(evt);
            }
        });
        quyen_Choice = new ChoiceElement("../../images/output-onlinepngtools - 2020-06-17T140640.532.png", "QUẢN LÝ QUYỀN").getPanel();
        quyen_Choice.setBounds(530, 100, 220, 177);
        quyen_Choice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quyen_ChoiceMouseClicked(evt);
            }
        });
        
        admin_Choice = new ChoiceElement("../../images/output-onlinepngtools - 2020-06-17T140649.682.png", "QUẢN LÝ ADMIN").getPanel();
        admin_Choice.setBounds(355, 350, 220, 177);
        admin_Choice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_ChoiceMouseClicked(evt);
            }
        });
        
        jPanel1.add(nhanvien_Choice);
        jPanel1.add(quyen_Choice);
        jPanel1.add(admin_Choice);
       
        jPanel1.setBounds(0, 0, 940, 600);
    }// </editor-fold>                        

    private void nhanvien_ChoiceMouseClicked(java.awt.event.MouseEvent evt) {                                           
        System.out.println("Go to NhanVienModule");
        
        main_2.Module_Panel.removeAll();
        main_2.Module_Panel.repaint();
        main_2.Module_Panel.revalidate();
        
        JPanel sp = new NhanVienModule().getNhanVienModule();
        sp.setBounds(0, 0, 940, 600);
        
        
        main_2.Module_Panel.add(sp);
    }    
    
    private void quyen_ChoiceMouseClicked(java.awt.event.MouseEvent evt) {                                           
        System.out.println("Go to QuyenModule");
        
        main_2.Module_Panel.removeAll();
        main_2.Module_Panel.repaint();
        main_2.Module_Panel.revalidate();
        
        JPanel sp = new QuyenModule().getQuyenModule();
        sp.setBounds(0, 0, 940, 600);
        
        
        main_2.Module_Panel.add(sp);
    }                                     
    
    private void admin_ChoiceMouseClicked(java.awt.event.MouseEvent evt) {                                           
        System.out.println("Go to AdminModule");
        
        main_2.Module_Panel.removeAll();
        main_2.Module_Panel.repaint();
        main_2.Module_Panel.revalidate();
        
        JPanel sp = new AdminModule().getAdminModule();
        sp.setBounds(0, 0, 940, 600);
        
        
        main_2.Module_Panel.add(sp);
    }                                     

    // Variables declaration - do not modify             
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel nhanvien_Choice;
    private javax.swing.JPanel quyen_Choice;
    private javax.swing.JPanel admin_Choice;
    // End of variables declaration                   
}

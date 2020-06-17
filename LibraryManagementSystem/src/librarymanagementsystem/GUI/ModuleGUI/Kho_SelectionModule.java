package librarymanagementsystem.GUI.ModuleGUI;

import librarymanagementsystem.GUI.*;
import librarymanagementsystem.GUI.HienThiGUI.*;
import javax.swing.JPanel;

public class Kho_SelectionModule{

    private Main_2 main_2 = new Main_2(0);
    public JPanel getKho_SelectionModule() {
        initComponents();
        return jPanel1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);
        
        kho_Choice = new ChoiceElement("../../images/output-onlinepngtools - 2020-06-17T140656.957.png", "QUẢN LÝ KHO SÁCH").getPanel();
        kho_Choice.setBounds(180, 100, 220, 177);
        kho_Choice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kho_ChoiceMouseClicked(evt);
            }
        });
        phieuNhap_Choice = new ChoiceElement("../../images/output-onlinepngtools - 2020-06-17T140706.141.png", "QUẢN LÝ PHIẾU NHẬP").getPanel();
        phieuNhap_Choice.setBounds(530, 100, 220, 177);
        phieuNhap_Choice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phieuNhap_ChoiceMouseClicked(evt);
            }
        });
        
        phieuXuat_Choice = new ChoiceElement("../../images/output-onlinepngtools - 2020-06-17T140710.671.png", "QUẢN LÝ PHIẾU XUẤT").getPanel();
        phieuXuat_Choice.setBounds(180, 350, 220, 177);
        phieuXuat_Choice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phieuXuat_ChoiceMouseClicked(evt);
            }
        });
        
        nhaCungCap_Choice = new ChoiceElement("../../images/output-onlinepngtools - 2020-06-17T140701.566.png", "QUẢN LÝ NCC").getPanel();
        nhaCungCap_Choice.setBounds(530, 350, 220, 177);
        nhaCungCap_Choice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nhaCungCap_ChoiceMouseClicked(evt);
            }
        });
        jPanel1.add(kho_Choice);
        jPanel1.add(phieuNhap_Choice);
        jPanel1.add(phieuXuat_Choice);
        jPanel1.add(nhaCungCap_Choice);
       
        jPanel1.setBounds(0, 0, 940, 600);
    }// </editor-fold>                        

    private void kho_ChoiceMouseClicked(java.awt.event.MouseEvent evt) {                                           
        System.out.println("Go to NhanVienModule");
        
        main_2.Module_Panel.removeAll();
        main_2.Module_Panel.repaint();
        main_2.Module_Panel.revalidate();
        
        JPanel sp = new KhoSachModule().getKhoSachModule();
        sp.setBounds(0, 0, 940, 600);
        
        
        main_2.Module_Panel.add(sp);
    }    
    
    private void phieuNhap_ChoiceMouseClicked(java.awt.event.MouseEvent evt) {                                           
        System.out.println("Go to QuyenModule");
        
        main_2.Module_Panel.removeAll();
        main_2.Module_Panel.repaint();
        main_2.Module_Panel.revalidate();
        
        JPanel sp = new PhieuNhapModule().getPhieuNhapModule();
        sp.setBounds(0, 0, 940, 600);
        
        
        main_2.Module_Panel.add(sp);
    }                                     
    
    private void phieuXuat_ChoiceMouseClicked(java.awt.event.MouseEvent evt) {                                           
        System.out.println("Go to AdminModule");
        
        main_2.Module_Panel.removeAll();
        main_2.Module_Panel.repaint();
        main_2.Module_Panel.revalidate();
        
        JPanel sp = new PhieuXuatModule().getPhieuXuatModule();
        sp.setBounds(0, 0, 940, 600);
        
        
        main_2.Module_Panel.add(sp);
    }          
    
    private void nhaCungCap_ChoiceMouseClicked(java.awt.event.MouseEvent evt) {                                           
        System.out.println("Go to AdminModule");
        
        main_2.Module_Panel.removeAll();
        main_2.Module_Panel.repaint();
        main_2.Module_Panel.revalidate();
        
        JPanel sp = new NhaCungCapModule().getNhaCungCapModule();
        sp.setBounds(0, 0, 940, 600);
        
        
        main_2.Module_Panel.add(sp);
    }         

    // Variables declaration - do not modify             
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel kho_Choice;
    private javax.swing.JPanel phieuNhap_Choice;
    private javax.swing.JPanel phieuXuat_Choice;
    private javax.swing.JPanel nhaCungCap_Choice;
    // End of variables declaration                   
}

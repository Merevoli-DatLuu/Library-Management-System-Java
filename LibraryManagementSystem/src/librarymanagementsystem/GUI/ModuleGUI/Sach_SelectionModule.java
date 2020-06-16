package librarymanagementsystem.GUI.ModuleGUI;

import librarymanagementsystem.GUI.*;
import javax.swing.JPanel;

public class Sach_SelectionModule{

    private Main_2 main_2 = new Main_2(0);
    public JPanel getSach_SelectionModule() {
        initComponents();
        return jPanel1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tittle_LoaiSach = new javax.swing.JLabel();
        tittle_SachThuVien = new javax.swing.JLabel();
        tittle_SachMuon = new javax.swing.JLabel();
        choice_SachMuon = new javax.swing.JLabel();
        choice_SachThuVien = new javax.swing.JLabel();
        choice_LoaiSach = new javax.swing.JLabel();
        
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);
        
        tittle_LoaiSach.setBackground(new java.awt.Color(255, 255, 255));
        tittle_LoaiSach.setFont(new java.awt.Font("Segoe UI", 1, 41)); // NOI18N
        tittle_LoaiSach.setForeground(new java.awt.Color(255, 255, 255));
        tittle_LoaiSach.setText("LOẠI SÁCH");
        tittle_LoaiSach.setBounds(55, 250, 214, 56);
        jPanel1.add(tittle_LoaiSach);

        tittle_SachThuVien.setBackground(new java.awt.Color(255, 255, 255));
        tittle_SachThuVien.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        tittle_SachThuVien.setForeground(new java.awt.Color(255, 255, 255));
        tittle_SachThuVien.setText("SÁCH THƯ VIỆN");
        tittle_SachThuVien.setBounds(340, 260, 260, 46);
        jPanel1.add(tittle_SachThuVien);

        tittle_SachMuon.setBackground(new java.awt.Color(255, 255, 255));
        tittle_SachMuon.setFont(new java.awt.Font("Segoe UI", 1, 41)); // NOI18N
        tittle_SachMuon.setForeground(new java.awt.Color(255, 255, 255));
        tittle_SachMuon.setText("SÁCH MƯỢN");
        tittle_SachMuon.setBounds(655, 250, 255, 56);
        jPanel1.add(tittle_SachMuon);

        choice_SachMuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("../../images/output-onlinepngtools - 2020-05-28T172343.540.png"))); // NOI18N
        choice_SachMuon.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                choice_SachMuonMouseMoved(evt);
            }
        });
        choice_SachMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choice_SachMuonMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                choice_SachMuonMouseExited(evt);
            }
        });
        choice_SachMuon.setBounds(640, 60, 280, 478);
        jPanel1.add(choice_SachMuon);

        choice_SachThuVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("../../images/output-onlinepngtools (98).png"))); // NOI18N
        choice_SachThuVien.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                choice_SachThuVienMouseMoved(evt);
            }
        });
        choice_SachThuVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choice_SachThuVienMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                choice_SachThuVienMouseExited(evt);
            }
        });
        choice_SachThuVien.setBounds(330, 60, 280, 478);
        jPanel1.add(choice_SachThuVien);

        choice_LoaiSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("../../images/output-onlinepngtools (97).png"))); // NOI18N
        choice_LoaiSach.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                choice_LoaiSachMouseMoved(evt);
            }
        });
        choice_LoaiSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                choice_LoaiSachMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                choice_LoaiSachMouseExited(evt);
            }
        });
        choice_LoaiSach.setBounds(20, 60, 280, 478);
        jPanel1.add(choice_LoaiSach);
        jPanel1.setBounds(0, 0, 940, 600);
    }// </editor-fold>                        

    private void choice_LoaiSachMouseMoved(java.awt.event.MouseEvent evt) {                                           
        choice_LoaiSach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102,255,255), 2));
    }                                          

    private void choice_LoaiSachMouseExited(java.awt.event.MouseEvent evt) {                                            
        choice_LoaiSach.setBorder(null);
    }                                           

    private void choice_SachThuVienMouseMoved(java.awt.event.MouseEvent evt) {                                              
        choice_SachThuVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102,255,255), 2));
    }                                             

    private void choice_SachThuVienMouseExited(java.awt.event.MouseEvent evt) {                                               
        choice_SachThuVien.setBorder(null);
    }                                              

    private void choice_SachMuonMouseMoved(java.awt.event.MouseEvent evt) {                                           
        choice_SachMuon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102,255,255), 2));
    }                                          

    private void choice_SachMuonMouseExited(java.awt.event.MouseEvent evt) {                                            
        choice_SachMuon.setBorder(null);
    }                                           

    private void choice_LoaiSachMouseClicked(java.awt.event.MouseEvent evt) {                                             
        System.out.println("Go to LoaiSachModule");
        
        main_2.Module_Panel.removeAll();
        main_2.Module_Panel.repaint();
        main_2.Module_Panel.revalidate();
        
        JPanel sp = new LoaiSachModule().getLoaiSachModule();
        sp.setBounds(0, 0, 940, 600);
        
        
        main_2.Module_Panel.add(sp);
    }                                            

    private void choice_SachThuVienMouseClicked(java.awt.event.MouseEvent evt) {                                                
        System.out.println("Go to SachThuVienModule");
        
        main_2.Module_Panel.removeAll();
        main_2.Module_Panel.repaint();
        main_2.Module_Panel.revalidate();
        
        JPanel sp = new SachThuVienModule().getSachThuVienModule();
        sp.setBounds(0, 0, 940, 600);
        
        
        main_2.Module_Panel.add(sp);
    }                                               

    private void choice_SachMuonMouseClicked(java.awt.event.MouseEvent evt) {                                             
        System.out.println("Go to SachMuonModule");
        
        main_2.Module_Panel.removeAll();
        main_2.Module_Panel.repaint();
        main_2.Module_Panel.revalidate();
        
        JPanel sp = new PhieuMuonModule().getPhieuMuonModule();
        sp.setBounds(0, 0, 940, 600);
        
        
        main_2.Module_Panel.add(sp);
    }                                            

    // Variables declaration - do not modify                     
    private javax.swing.JLabel choice_LoaiSach;
    private javax.swing.JLabel choice_SachMuon;
    private javax.swing.JLabel choice_SachThuVien;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel tittle_LoaiSach;
    private javax.swing.JLabel tittle_SachMuon;
    private javax.swing.JLabel tittle_SachThuVien;
    // End of variables declaration                   
}

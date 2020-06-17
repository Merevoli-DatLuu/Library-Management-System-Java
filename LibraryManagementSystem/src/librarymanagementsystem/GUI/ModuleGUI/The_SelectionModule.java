package librarymanagementsystem.GUI.ModuleGUI;

import librarymanagementsystem.GUI.*;
import librarymanagementsystem.GUI.HienThiGUI.*;
import javax.swing.JPanel;

public class The_SelectionModule{

    private Main_2 main_2 = new Main_2(0);
    public JPanel getThe_SelectionModule() {
        initComponents();
        return jPanel1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);
        
        the_Choice = new ChoiceElement("../../images/output-onlinepngtools - 2020-06-17T140622.607.png", "QUẢN LÝ THẺ").getPanel();
        the_Choice.setBounds(180, 200, 220, 177);
        the_Choice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                the_ChoiceMouseClicked(evt);
            }
        });
        khachhang_Choice = new ChoiceElement("../../images/output-onlinepngtools - 2020-06-17T140629.841.png", "QUẢN LÝ KHÁCH HÀNG").getPanel();
        khachhang_Choice.setBounds(530, 200, 220, 177);
        khachhang_Choice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                khachhang_ChoiceMouseClicked(evt);
            }
        });
        
        jPanel1.add(the_Choice);
        jPanel1.add(khachhang_Choice);
       
        jPanel1.setBounds(0, 0, 940, 600);
    }// </editor-fold>                        

    private void the_ChoiceMouseClicked(java.awt.event.MouseEvent evt) {                                           
        System.out.println("Go to TheModule");
        
        main_2.Module_Panel.removeAll();
        main_2.Module_Panel.repaint();
        main_2.Module_Panel.revalidate();
        
        JPanel sp = new TheModule().getTheModule();
        sp.setBounds(0, 0, 940, 600);
        
        
        main_2.Module_Panel.add(sp);
    }    
    
    private void khachhang_ChoiceMouseClicked(java.awt.event.MouseEvent evt) {                                           
        System.out.println("Go to KhachHangModule");
        
        main_2.Module_Panel.removeAll();
        main_2.Module_Panel.repaint();
        main_2.Module_Panel.revalidate();
        
        JPanel sp = new KhachHangModule().getKhachHangModule();
        sp.setBounds(0, 0, 940, 600);
        
        
        main_2.Module_Panel.add(sp);
    }                                                                                                                             

    // Variables declaration - do not modify             
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel the_Choice;
    private javax.swing.JPanel khachhang_Choice;
    // End of variables declaration                   
}

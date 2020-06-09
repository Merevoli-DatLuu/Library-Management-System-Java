package librarymanagementsystem.GUI.ModuleGUI;

import java.awt.Color;
import java.util.ArrayList;
import librarymanagementsystem.Toolkit.DataProcessing;
import librarymanagementsystem.GUI.HienThiGUI.*;
import librarymanagementsystem.BUS.*;
import librarymanagementsystem.GUI.*;

import javax.swing.JPanel;

public class TrangChuGUI extends javax.swing.JFrame {

    private static DataProcessing dp = new DataProcessing();
    private static QLChiTietSachBUS chiTietSachBUS = new QLChiTietSachBUS();
    private static QLTheBUS theBUS = new QLTheBUS();
    private static QLPhieuMuonBUS phieuMuonBUS = new QLPhieuMuonBUS();
    private static QLNhanVienBUS nhanVienBUS = new QLNhanVienBUS();
    private static QLKhachHangBUS khachHangBUS = new QLKhachHangBUS();
    
    public static JPanel getTrangChuGUI() {
        initComponents();
        
        /** Cards **/
        int value_1 = chiTietSachBUS.getSoLuongSach();
        int value_2 = theBUS.getSoLuongThe();
        int value_3 = phieuMuonBUS.getSoLuongSachMuon();
        int value_4 = nhanVienBUS.getSoLuongNhanVien();
        
        JPanel card_1 = new dashboardCard("SÁCH", Integer.toString(value_1), "../../images/output-onlinepngtools (85).png").getdashboardCard();
        JPanel card_2 = new dashboardCard("THẺ", Integer.toString(value_2), "../../images/output-onlinepngtools (86).png").getdashboardCard();
        JPanel card_3 = new dashboardCard("MƯỢN SÁCH", Integer.toString(value_3), "../../images/output-onlinepngtools (87).png").getdashboardCard();
        JPanel card_4 = new dashboardCard("NHÂN VIÊN", Integer.toString(value_4), "../../images/output-onlinepngtools (88).png").getdashboardCard();
        card_1.setBounds(20, 50, 220, 134);
        card_2.setBounds(250, 50, 220, 134);
        card_3.setBounds(480, 50, 220, 134);
        card_4.setBounds(710, 50, 220, 134);
        
        jPanel1.setBackground(new Color(0, 0, 0, 0));
        jPanel1.add(card_1);
        jPanel1.add(card_2);
        jPanel1.add(card_3);
        jPanel1.add(card_4);
        /** End Cards **/
        
        /** Charts **/
        ChartDrawing chart = new ChartDrawing();
        ArrayList <Integer> name_value = new ArrayList<>();
        ArrayList <Integer> value = phieuMuonBUS.getArrSoLuongSachMuon_Current();
        
        for (int i=1; i<=dp.getCurrentMonth(); i++){
            name_value.add(i);
        }
        
        System.out.println(dp.getCurrentMonth());
        
        JPanel chart_1 = chart.lineChart("Biểu Đồ về Sách Mượn (2020)", "số sách mượn/tháng", "tháng", "số sách mượn", value, name_value);
        chart_1.setBounds(35, 200, 550, 380);
        
        ArrayList <String> name_value2 = new ArrayList<>();
        ArrayList <Integer> value2 = khachHangBUS.getArrStageofAge();
        
        name_value2.add("Nhóm Trẻ em và Thanh thiếu niên");
        name_value2.add("Nhóm người trưởng thành");
        name_value2.add("Nhóm người lớn tuổi");
        
        JPanel chart_2 = chart.pieChart("Biểu Đồ về phân bố độ tuổi độc giả", name_value2, value2);
        chart_2.setBounds(600, 200, 315, 380);
        
        jPanel1.add(chart_1);
        jPanel1.add(chart_2);
        /** End Charts **/
        return jPanel1;
    }

                          
    private static void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        jPanel1.setLayout(null);
        jPanel1.setBounds(0, 0, 940, 600);
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        
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
            java.util.logging.Logger.getLogger(TrangChuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChuGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private static javax.swing.JPanel jPanel1;
    // End of variables declaration                   
}

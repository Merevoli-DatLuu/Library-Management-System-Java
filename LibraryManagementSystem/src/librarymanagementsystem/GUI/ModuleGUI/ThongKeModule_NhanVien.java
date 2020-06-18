package librarymanagementsystem.GUI.ModuleGUI;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import librarymanagementsystem.BUS.QLChiTietSachBUS;
import librarymanagementsystem.BUS.QLKhachHangBUS;
import librarymanagementsystem.BUS.QLNhanVienBUS;
import librarymanagementsystem.BUS.QLPhieuMuonBUS;
import librarymanagementsystem.BUS.QLTheBUS;
import librarymanagementsystem.BUS.QLLoaiSachBUS;
import librarymanagementsystem.GUI.ChartDrawing;
import librarymanagementsystem.GUI.HienThiGUI.dashboardCard_2;
import librarymanagementsystem.Toolkit.DataProcessing;
import librarymanagementsystem.Toolkit.ThongKe;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;

public class ThongKeModule_NhanVien {
    private static DataProcessing dp = new DataProcessing();
    private static ThongKe tk = new ThongKe();
    
    public static JPanel getThongKeNhanVienGUI() {
        initComponents();
        new QLLoaiSachBUS();
        new QLChiTietSachBUS();
        /** Cards **/
        /*int value_1 = chiTietSachBUS.getSoLuongSach();
        int value_2 = theBUS.getSoLuongThe();
        int value_3 = phieuMuonBUS.getSoLuongSachMuon();
        int value_4 = nhanVienBUS.getSoLuongNhanVien();*/
        
        /*JPanel card_1 = new dashboardCard("SÁCH", Integer.toString(value_1), "../../images/output-onlinepngtools (85).png").getdashboardCard();
        JPanel card_2 = new dashboardCard("THẺ", Integer.toString(value_2), "../../images/output-onlinepngtools (86).png").getdashboardCard();
        JPanel card_3 = new dashboardCard("MƯỢN SÁCH", Integer.toString(value_3), "../../images/output-onlinepngtools (87).png").getdashboardCard();
        JPanel card_4 = new dashboardCard("NHÂN VIÊN", Integer.toString(value_4), "../../images/output-onlinepngtools (88).png").getdashboardCard();*/
        JPanel card_1 = new dashboardCard_2("Số Lượng Nhân Viên", Integer.toString(tk.getSoLuongNhanVien()), "../../images/output-onlinepngtools - 2020-06-05T084538.007.png").getdashboardCard();
        JPanel card_2 = new dashboardCard_2("Số Chức Vụ", Integer.toString(tk.getSoLuongNhanVien_ChucVu()), "../../images/output-onlinepngtools - 2020-06-05T084549.737.png").getdashboardCard();
        JPanel card_3 = new dashboardCard_2("Thủ Thư", Integer.toString(tk.getSoLuongNhanVien_ChucVu("Thủ Thư")), "../../images/output-onlinepngtools - 2020-06-05T084557.140.png").getdashboardCard();
        JPanel card_4 = new dashboardCard_2("Quản Lý Kho", Integer.toString(tk.getSoLuongNhanVien_ChucVu("Quản Lý Kho")), "../../images/output-onlinepngtools - 2020-06-05T084602.595.png").getdashboardCard();
        card_1.setBounds(20, 40 - 10, 220, 184);
        card_2.setBounds(250, 40 - 10, 220, 184);
        card_3.setBounds(480, 40 - 10, 220, 184);
        card_4.setBounds(710, 40 - 10, 220, 184);
        
        jPanel1.setBackground(new Color(0, 0, 0, 0));
        jPanel1.add(card_1);
        jPanel1.add(card_2);
        jPanel1.add(card_3);
        jPanel1.add(card_4);
        /** End Cards **/
        
        /** Charts **/
        ChartDrawing chart = new ChartDrawing();

        ArrayList <String> value_name = new ArrayList<>();
        ArrayList <Integer> value = new ArrayList<>();
        
        
        value_name.add("Tổng");
        value_name.add("Thủ Thư");
        value_name.add("Quản Lý Kho");
        
        value.add(tk.getSoLuongNhanVien());
        value.add(tk.getSoLuongNhanVien_ChucVu("Thủ Thư"));
        value.add(tk.getSoLuongNhanVien_ChucVu("Quản Lý Kho"));
        JPanel chartsachthuvien = chart.barChart("Biểu Đồ về Chức Vụ Nhân Viên", "Số Lượng Nhân Viên", value_name, value);
        chartsachthuvien.setBounds(35, 240 - 10, 880, 340);
        jPanel1.add(chartsachthuvien);
        
        /** End Charts **/
        final JScrollBar verticalScroller = new JScrollBar();
        verticalScroller.setOrientation(JScrollBar.VERTICAL);
        verticalScroller .setMaximum (100);
        verticalScroller .setMinimum (1);
        jPanel1.add(verticalScroller );
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

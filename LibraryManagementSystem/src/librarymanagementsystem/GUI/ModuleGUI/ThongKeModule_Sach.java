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

public class ThongKeModule_Sach {
    private static DataProcessing dp = new DataProcessing();
    private static ThongKe tk = new ThongKe();
    
    public static JPanel getTrangChuGUI() {
        initComponents();
        new QLLoaiSachBUS();
        /** Cards **/
        /*int value_1 = chiTietSachBUS.getSoLuongSach();
        int value_2 = theBUS.getSoLuongThe();
        int value_3 = phieuMuonBUS.getSoLuongSachMuon();
        int value_4 = nhanVienBUS.getSoLuongNhanVien();*/
        
        /*JPanel card_1 = new dashboardCard("SÁCH", Integer.toString(value_1), "../../images/output-onlinepngtools (85).png").getdashboardCard();
        JPanel card_2 = new dashboardCard("THẺ", Integer.toString(value_2), "../../images/output-onlinepngtools (86).png").getdashboardCard();
        JPanel card_3 = new dashboardCard("MƯỢN SÁCH", Integer.toString(value_3), "../../images/output-onlinepngtools (87).png").getdashboardCard();
        JPanel card_4 = new dashboardCard("NHÂN VIÊN", Integer.toString(value_4), "../../images/output-onlinepngtools (88).png").getdashboardCard();*/
        JPanel card_1 = new dashboardCard_2("Số Lượng Sách", Integer.toString(tk.soLuong_Sach()), "../../images/output-onlinepngtools - 2020-06-05T084538.007.png").getdashboardCard();
        JPanel card_2 = new dashboardCard_2("Thể Loại", Integer.toString(tk.soLuong_Sach_TheLoai()), "../../images/output-onlinepngtools - 2020-06-05T084549.737.png").getdashboardCard();
        JPanel card_3 = new dashboardCard_2("Sách Việt Nam", Integer.toString(tk.soLuong_Sach_NgonNgu("Tiếng Việt")), "../../images/output-onlinepngtools - 2020-06-05T084557.140.png").getdashboardCard();
        JPanel card_4 = new dashboardCard_2("Sách Nước Ngoài", Integer.toString(tk.soLuong_Sach_NgonNgu("Tiếng Anh")), "../../images/output-onlinepngtools - 2020-06-05T084602.595.png").getdashboardCard();
        card_1.setBounds(20, 40, 220, 184);
        card_2.setBounds(250, 40, 220, 184);
        card_3.setBounds(480, 40, 220, 184);
        card_4.setBounds(710, 40, 220, 184);
        
        jPanel1.setBackground(new Color(0, 0, 0, 0));
        jPanel1.add(card_1);
        jPanel1.add(card_2);
        jPanel1.add(card_3);
        jPanel1.add(card_4);
        /** End Cards **/
        
        /** Charts **/
        ChartDrawing chart = new ChartDrawing();
        ArrayList <String> nxb_key = tk.arr_Sach_NhaXuatBan_top5();
        ArrayList <Integer> nxb_value = tk.arrSoLuong_Sach_NhaXuatBan_top5();
        
        int sum_nxb_value = 0;
        for (int e : nxb_value){
            sum_nxb_value += e;
        }
        
        nxb_key.add("Còn Lại");
        nxb_value.add(tk.soLuong_Sach() - sum_nxb_value);
        
        for (String e : nxb_key){
            System.out.println(e);
        }
        
        for (int e : nxb_value){
            System.out.println(e);
        }
        
        JPanel chart_1 = chart.pieChart_withoutLabel("Biểu Đồ về số sách của Nhà Xuất Bản", nxb_key, nxb_value);
        chart_1.setBounds(35, 240, 425, 340);
        
        ArrayList <String> mucgia_key = new ArrayList<>();
        ArrayList <Integer> mucgia_value = tk.arrSoLuong_Sach_MucGia();
        
        mucgia_key.add("< 100,000 VNĐ");
        mucgia_key.add("100,000 - 300,000 VNĐ");
        mucgia_key.add("> 300,000VNĐ");
        
        // Custom chart
        JFreeChart chart_t_2 = chart.createChart_PieChart("Biểu Đồ về Mức Giá của Sách", mucgia_key, mucgia_value);
        PiePlot pieplot = (PiePlot) chart_t_2.getPlot();
        pieplot.setLabelBackgroundPaint(new Color(200, 229, 252));
		pieplot.setLabelFont(new Font("verdana", Font.PLAIN, 10));
                
        pieplot.setSectionPaint(mucgia_key.get(0), new Color(33, 150, 243));
        pieplot.setSectionPaint(mucgia_key.get(1), new Color(89, 176, 246));
        pieplot.setSectionPaint(mucgia_key.get(2), new Color(144, 203, 249));
        
        JPanel chart_2 = new ChartPanel(chart_t_2);
        chart_2.setBounds(500, 240, 425, 340);
        
        jPanel1.add(chart_1);
        jPanel1.add(chart_2);
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

package librarymanagementsystem.GUI.ModuleGUI;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import librarymanagementsystem.BUS.QLChiTietSachBUS;
import librarymanagementsystem.BUS.QLKhachHangBUS;
import librarymanagementsystem.BUS.QLNhanVienBUS;
import librarymanagementsystem.BUS.QLPhieuMuonBUS;
import librarymanagementsystem.BUS.QLTheBUS;
import librarymanagementsystem.BUS.QLLoaiSachBUS;
import librarymanagementsystem.GUI.ChartDrawing;
import librarymanagementsystem.GUI.HienThiGUI.dashboardCard_3;
import librarymanagementsystem.Toolkit.DataProcessing;
import librarymanagementsystem.Toolkit.ThongKe;
import librarymanagementsystem.Toolkit.Report;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;

public class ThongKeModule_PhieuMuon {
    private static DataProcessing dp = new DataProcessing();
    private static ThongKe tk = new ThongKe();
    private static QLPhieuMuonBUS phieuMuonBUS = new QLPhieuMuonBUS(0);
    
    public JPanel getTrangChuGUI() {
        initComponents();
        new QLLoaiSachBUS();
        
        JLabel report = new JLabel();
        report.setToolTipText("Xuất Report");
        report.setIcon(new javax.swing.ImageIcon(getClass().getResource("../../images/output-onlinepngtools - 2020-06-12T133359.638.png"))); // NOI18N
        report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportMouseClicked(evt);
            }
        });
        report.setBounds(905, 7, 30, 30);
        jPanel1.add(report);
        
        /** Cards **/
        /*int value_1 = chiTietSachBUS.getSoLuongSach();
        int value_2 = theBUS.getSoLuongThe();
        int value_3 = phieuMuonBUS.getSoLuongSachMuon();
        int value_4 = nhanVienBUS.getSoLuongNhanVien();*/
        
        /*JPanel card_1 = new dashboardCard("SÁCH", Integer.toString(value_1), "../../images/output-onlinepngtools (85).png").getdashboardCard();
        JPanel card_2 = new dashboardCard("THẺ", Integer.toString(value_2), "../../images/output-onlinepngtools (86).png").getdashboardCard();
        JPanel card_3 = new dashboardCard("MƯỢN SÁCH", Integer.toString(value_3), "../../images/output-onlinepngtools (87).png").getdashboardCard();
        JPanel card_4 = new dashboardCard("NHÂN VIÊN", Integer.toString(value_4), "../../images/output-onlinepngtools (88).png").getdashboardCard();*/
        JPanel card_1 = new dashboardCard_3("Số Lượng Phiếu", Integer.toString(tk.soLuong_SachMuon()), "../../images/output-onlinepngtools - 2020-06-12T104902.328.png").getdashboardCard();
        JPanel card_2 = new dashboardCard_3("Số Lượng Sách", Integer.toString(tk.soLuong_SachMuon_Sach()), "../../images/output-onlinepngtools - 2020-06-12T104929.571.png").getdashboardCard();
        JPanel card_3 = new dashboardCard_3("Tháng Nhiều Nhất", Integer.toString(tk.thang_SachMuon_Max()), "../../images/output-onlinepngtools - 2020-06-12T104925.205.png").getdashboardCard();
        JPanel card_4 = new dashboardCard_3("Tháng Ít Nhất", Integer.toString(tk.thang_SachMuon_Min()), "../../images/output-onlinepngtools - 2020-06-12T104910.265.png").getdashboardCard();
        card_1.setBounds(20, 40 - 10, 240, 143);
        card_2.setBounds(250, 40 - 10, 240, 143);
        card_3.setBounds(480, 40 - 10, 240, 143);
        card_4.setBounds(710, 40 - 10, 240, 143);
        
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
        
        JPanel chart_1 = chart.lineChart("Biểu Đồ về Sách Mượn (" + dp.getCurrentYear() + ")", "số sách mượn/tháng", "tháng", "số sách mượn", value, name_value);
        chart_1.setBounds(35, 180, 435, 380);
        
        ArrayList <Integer> name_value_2 = new ArrayList<>();
        ArrayList <Integer> value_2 = phieuMuonBUS.getArrSoLuongSachMuon_Phieu_Current();
        
        for (int i=1; i<=dp.getCurrentMonth(); i++){
            name_value_2.add(i);
        }
        
        // Custom chart
        JFreeChart chart_t_2 = chart.createChart_LineChart("Biểu Đồ về Phiếu Mượn (" + dp.getCurrentYear() + ")", "tháng", "số phiếu mượn", chart.createDataSet_LineChart("số phiếu mượn/tháng", value_2, name_value_2));
        chart_t_2.getPlot().setBackgroundPaint( new Color(241, 245, 248) );
        chart_t_2.getPlot().setOutlinePaint(new Color(255, 87, 51));
        chart_t_2.getTitle().setFont(new java.awt.Font("Arial", 1, 16));
        
        CategoryPlot plot = (CategoryPlot) chart_t_2.getPlot();
        
        LineAndShapeRenderer render = new LineAndShapeRenderer();
 
        // sets paint color for each series
        render.setSeriesPaint(0, new Color(240, 77, 41 ));
        
        plot.setRenderer(render);
        
        JPanel chart_2 = new ChartPanel(chart_t_2);
        chart_2.setBounds(495, 180, 435, 380);
        
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
    
    void reportMouseClicked(java.awt.event.MouseEvent evt){
        new Report().exportReport();
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

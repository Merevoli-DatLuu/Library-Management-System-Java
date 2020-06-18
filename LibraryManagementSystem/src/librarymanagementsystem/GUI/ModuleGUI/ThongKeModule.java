package librarymanagementsystem.GUI.ModuleGUI;

import java.awt.Color;
import java.awt.GridLayout;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;
import javax.swing.text.View;
 

public class ThongKeModule extends JFrame{
    public ThongKeModule() {
        createGUI();
        setDisplay();
    }
    
    public ThongKeModule(int i){
        
    }
 
    /**
     * set display for JFrame
     */
    private void setDisplay() {
        setSize(940, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
 
    /**
     * add JTabbedPane into JFrame
     */
    private void createGUI() {
        JPanel thongkePanel = new JPanel();
        thongkePanel.setLayout(null);
        thongkePanel.add(createTabbedPane());
        thongkePanel.setBounds(0, 0, 940, 600);
        add(thongkePanel);
    }
 
    /**
     * create a JTabbedPane contain three tab
     */
    public JTabbedPane createTabbedPane() {
        UIManager.put("TabbedPane.borderHightlightColor", new Color(0, 0, 0, 0)); 
        UIManager.put("TabbedPane.darkShadow", new Color(0, 0, 0, 0)); 
        UIManager.put("TabbedPane.light", new Color(0, 0, 0, 0));
        UIManager.put("TabbedPane.selectHighlight", new Color(0, 0, 0, 0));
        UIManager.put("TabbedPane.darkShadow", new Color(0, 0, 0, 0));
        UIManager.put("TabbedPane.focus", java.awt.Color.CYAN);
        UIManager.put("TabbedPane.contentOpaque", false);
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setOpaque(false);
        tabbedPane.setBorder(null);
        tabbedPane.setBackground(new Color(82, 210, 202));
        tabbedPane.setForeground(Color.white);
        
        /* create three JPanel, which is content of tabs */
        JPanel panel1 = new ThongKeModule_Sach().getTrangChuGUI();
        JPanel panel12 = new ThongKeModule_SachThuVien().getTrangChuGUI();
        JPanel panel13 = new ThongKeModule_PhieuMuon().getTrangChuGUI();
        JPanel panel2 = new ThongKeModule_The().getThongKeModule_The();
        JPanel panel3 = new ThongKeModule_NhanVien().getThongKeNhanVienGUI();
        JPanel panel4 = new ThongKeModule_KhoSach().getThongKeKhoSachGUI();
        
        panel1.setLocation(0, 0);
        panel1.setSize(940, 600);
        /* add three tab with three JPanel */
//        tabbedPane.add("<html><body><table width='120'><tr><td>Options</td></tr></table></body></html>", panel1);
//        tabbedPane.add("<html><body><table width='120'><tr><td>User Data Information</td></tr></table></body></html>", panel2);
//        tabbedPane.add("<html><body><table width='120'><tr><td>Event Details</td></tr></table></body></html>", panel3);
        tabbedPane.addTab("Loại Sách", null, panel1, "Thống Kê Loại Sách");
        tabbedPane.addTab("Sách Thư Viện", null, panel12, "Thống Kê Sách Thư Viện");
        tabbedPane.addTab("Phiếu Mượn", null, panel13, "Thống Kê Phiếu Mượn");
        tabbedPane.addTab("Thẻ và Khách Hàng", null, panel2, "Thống Kê Thẻ và Khách Hàng");
        tabbedPane.addTab("Nhân Viên", null, panel3, "Thống Kê Nhân Viên");
        tabbedPane.addTab("Kho Sách", null, panel4, "Thống Kê Kho Sách");
        
        //Font font = new Font("Verdana", Font.CENTER_BASELINE, 18);
        //tabbedPane.setFont(font);
        
        tabbedPane.setBounds(0, 0, 940, 600);
        return tabbedPane;
    }
 
    /**
     * create a JPanel contain a JLabel
     */
    private JPanel createJPanel(String text) {
        JPanel panel = new JPanel(new GridLayout(1, 1));
        JLabel lb = new JLabel(text);
        lb.setHorizontalAlignment(JLabel.CENTER);
        panel.add(lb);
        return panel;
    }
 
    /**
     * create a JTextArea with rows and columns, two method setWrapStyleWord and
     * setLineWrap make text can down line when text too long
     */
    private JTextArea createTextArea(int row, int col) {
        JTextArea ta = new JTextArea(row, col);
        ta.setWrapStyleWord(true);
        ta.setLineWrap(true);
        ta.setForeground(Color.BLUE);
        return ta;
    }
 
    public static void main(String[] args) {
        new ThongKeModule();
    }
}
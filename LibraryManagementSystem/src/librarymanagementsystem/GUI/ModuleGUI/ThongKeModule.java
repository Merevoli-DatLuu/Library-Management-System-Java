package librarymanagementsystem.GUI.ModuleGUI;

import java.awt.Color;
import java.awt.GridLayout;
 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
 

public class ThongKeModule extends JFrame{
    public ThongKeModule() {
        createGUI();
        setDisplay();
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
    private JTabbedPane createTabbedPane() {
        JTabbedPane tabbedPane = new JTabbedPane();
 
        /* create three JPanel, which is content of tabs */
        JPanel panel1 = createJPanel("Thống Kê Sách");
        JPanel panel2 = createJPanel("Thống Kê Thẻ và Khách Hàng");
        JPanel panel3 = createJPanel("Thống Kê Nhân Viên");
        JPanel panel4 = createJPanel("Thống Kê Kho Sách");
        
        panel1.setSize(600, 500);
        
        /* add three tab with three JPanel */
        tabbedPane.addTab("Sách", null, panel1, "Thống Kê Sách");
        tabbedPane.addTab("Thẻ và Khách Hàng", null, panel2, "Thống Kê Thẻ và Khách Hàng");
        tabbedPane.addTab("Nhân Viên", null, panel3, "Thống Kê Nhân Viên");
        tabbedPane.addTab("Kho Sách", null, panel4, "Thống Kê Kho Sách");
 
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

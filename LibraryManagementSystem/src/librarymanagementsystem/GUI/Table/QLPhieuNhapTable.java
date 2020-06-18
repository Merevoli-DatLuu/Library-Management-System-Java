package librarymanagementsystem.GUI.Table;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import librarymanagementsystem.BUS.QLPhieuNhapBUS;
import librarymanagementsystem.DTO.QLPhieuNhapDTO;

public class QLPhieuNhapTable {

    // for testing
    private static JFrame createFrame() {
        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(700, 500));
        return frame;
    }
        
    private static ObjectTableModel<QLPhieuNhapDTO> createObjectDataModel(){
        return new ObjectTableModel<QLPhieuNhapDTO>() {
            @Override
            public Object getValueAt(QLPhieuNhapDTO phieuNhap, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return phieuNhap.getMaNhap();
                    case 1:
                        return phieuNhap.getNgayNhap();
                    case 2:
                        return phieuNhap.getMaNhanVien();
                    case 3:
                        return phieuNhap.getMaNCC();
                    case 4:
                        return phieuNhap.getMaSach();
                    case 5:
                        return phieuNhap.getTongSoLuong();
                    case 6:
                        return phieuNhap.getTongTien();
                }
                return null;
            }

            @Override
            public int getColumnCount() {
                return 7;
            }

            @Override
            public String getColumnName(int column) {
                switch (column) {
                    case 0:
                        return "Mã Nhập Kho";
                    case 1:
                        return "Ngày Nhập";
                    case 2:
                        return "Mã Nhân Viên";
                    case 3:
                        return "Mã Nhà Cung Cấp";
                    case 4:
                        return "Mã Sách";
                    case 5:
                        return "Tổng Số Lượng";
                    case 6:
                        return "Tổng Tiền";
                }
                return null;
            }
        };
    }
    
    private static PaginationDataProvider<QLPhieuNhapDTO> createDataProvider(
            ObjectTableModel<QLPhieuNhapDTO> objectDataModel) {
        final List<QLPhieuNhapDTO> list = new QLPhieuNhapBUS().getArrNhapKho();
        return new InMemoryPaginationDataProvider<>(list, objectDataModel);
    }
    
    private static PaginationDataProvider<QLPhieuNhapDTO> createDataProvider(
            ObjectTableModel<QLPhieuNhapDTO> objectDataModel, ArrayList <QLPhieuNhapDTO> phieuNhap) {
        final List<QLPhieuNhapDTO> list = phieuNhap;
        return new InMemoryPaginationDataProvider<>(list, objectDataModel);
    }
    public JPanel getTable(){
        ObjectTableModel<QLPhieuNhapDTO> objectDataModel = createObjectDataModel();
        JTable table = new JTable(objectDataModel);
        
        //** Adjust Table**//
        table.setRowHeight(35);
        //table.setIntercellSpacing(new Dimension(20, 0)); // Spacing 
        //table.getColumnModel().getColumn(0).setPreferredWidth(70);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        /* Align
        table.setDefaultRenderer(String.class, centerRenderer);
        table.setDefaultRenderer(Object.class, centerRenderer);
        table.setDefaultRenderer(Integer.class, centerRenderer);
        table.setDefaultRenderer(Long.class, centerRenderer);
        table.setDefaultRenderer(Double.class, centerRenderer);
        */
        
        table.setFont(new Font("verdana", Font.PLAIN, 13));
        
        table.getTableHeader().setBackground(new Color(91, 243, 207));
        table.getTableHeader().setPreferredSize(new Dimension(0,35)); // Header Height
        table.getTableHeader().setFont(new Font("verdana", Font.BOLD, 14));
        table.getTableHeader().setForeground(Color.WHITE);
        //table.getTableHeader().;
        //** End Adjust **//
        
        /** Table Column Width **/
        ArrayList <Integer> width = new ArrayList<>();
        width.add(135);
        width.add(170);
        width.add(160);
        width.add(180);
        width.add(370);
        width.add(140);
        width.add(150);
        
        table.setAutoCreateRowSorter(true);
        PaginationDataProvider<QLPhieuNhapDTO> dataProvider = createDataProvider(objectDataModel);
        PaginatedTableDecorator<QLPhieuNhapDTO> paginatedDecorator = PaginatedTableDecorator.decorate(table,
                dataProvider, new int[]{5, 10, 20, 50, 75, 100}, 10, width);
        paginatedDecorator.getClickEvent_PhieuNhap();
        JPanel p = paginatedDecorator.getContentPanel();
        return p;
    }
    
    public JPanel getTable(ArrayList <QLPhieuNhapDTO> phieuNhap){
        ObjectTableModel<QLPhieuNhapDTO> objectDataModel = createObjectDataModel();
        JTable table = new JTable(objectDataModel);
        
        //** Adjust Table**//
        table.setRowHeight(35);
        //table.setIntercellSpacing(new Dimension(20, 0)); // Spacing 
        //table.getColumnModel().getColumn(0).setPreferredWidth(70);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        /* Align
        table.setDefaultRenderer(String.class, centerRenderer);
        table.setDefaultRenderer(Object.class, centerRenderer);
        table.setDefaultRenderer(Integer.class, centerRenderer);
        table.setDefaultRenderer(Long.class, centerRenderer);
        table.setDefaultRenderer(Double.class, centerRenderer);
        */
        
        table.setFont(new Font("verdana", Font.PLAIN, 13));
        
        table.getTableHeader().setBackground(new Color(91, 243, 207));
        table.getTableHeader().setPreferredSize(new Dimension(0,35)); // Header Height
        table.getTableHeader().setFont(new Font("verdana", Font.BOLD, 14));
        table.getTableHeader().setForeground(Color.WHITE);
        //table.getTableHeader().;
        //** End Adjust **//
        
        /** Table Column Width **/
        ArrayList <Integer> width = new ArrayList<>();
        width.add(135);
        width.add(170);
        width.add(160);
        width.add(180);
        width.add(370);
        width.add(140);
        width.add(150);
        
        table.setAutoCreateRowSorter(true);
        PaginationDataProvider<QLPhieuNhapDTO> dataProvider = createDataProvider(objectDataModel, phieuNhap);
        PaginatedTableDecorator<QLPhieuNhapDTO> paginatedDecorator = PaginatedTableDecorator.decorate(table,
                dataProvider, new int[]{5, 10, 20, 50, 75, 100}, 10, width);
        paginatedDecorator.getClickEvent_PhieuNhap();
        JPanel p = paginatedDecorator.getContentPanel();
        return p;
    }
    
    public void expandMode(){
        JFrame frame = createFrame();
        JPanel p = new QLPhieuNhapTable().getTable();
        //frame.add(paginatedDecorator.getContentPanel());
        p.setSize(1200, 780);
        p.setBackground(new java.awt.Color(255, 255, 255));
        frame.add(p);
        frame.setBackground(new java.awt.Color(255, 255, 255));
         
        /**/
        frame.setSize(1200, 740);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("asdjhgsakdjhaskjdhsajik");
                frame.dispose();
            }
        });
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        JFrame frame = createFrame();
        JPanel p = new QLPhieuNhapTable().getTable();
        //frame.add(paginatedDecorator.getContentPanel());
        p.setSize(700, 500);
        p.setBackground(new java.awt.Color(255, 255, 255));
        frame.add(p);
        frame.setBackground(new java.awt.Color(255, 255, 255));
         
        /**/
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

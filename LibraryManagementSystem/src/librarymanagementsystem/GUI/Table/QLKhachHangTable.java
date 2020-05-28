package librarymanagementsystem.GUI.Table;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import librarymanagementsystem.BUS.QLKhachHangBUS;
import librarymanagementsystem.DTO.QLKhachHangDTO;

public class QLKhachHangTable {

    // for testing
    private static JFrame createFrame() {
        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(700, 500));
        return frame;
    }
        
    private static ObjectTableModel<QLKhachHangDTO> createObjectDataModel(){
        return new ObjectTableModel<QLKhachHangDTO>() {
            @Override
            public Object getValueAt(QLKhachHangDTO khachHang, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return khachHang.getMaKhachHang();
                    case 1:
                        return khachHang.getHoTen();
                    case 2:
                        return khachHang.getNgaySinh();
                    case 3:
                        return khachHang.getDiaChi();
                    case 4:
                        return khachHang.getSdt();
                    case 5:
                        return khachHang.getEmail();
                    case 6:
                        return khachHang.getMaThe();
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
                        return "Mã Khách Hàng";
                    case 1:
                        return "Họ Tên";
                    case 2:
                        return "Ngày Sinh";
                    case 3:
                        return "Địa Chỉ";
                    case 4:
                        return "Số Điện Thoại";
                    case 5:
                        return "Email";
                    case 6:
                        return "Mã Thẻ";
                }
                return null;
            }
        };
    }
    
    private static PaginationDataProvider<QLKhachHangDTO> createDataProvider(
            ObjectTableModel<QLKhachHangDTO> objectDataModel) {
        final List<QLKhachHangDTO> list = new QLKhachHangBUS().getArrKhachHang();
        return new InMemoryPaginationDataProvider<>(list, objectDataModel);
    }
    
    public JPanel getTable(){
        ObjectTableModel<QLKhachHangDTO> objectDataModel = createObjectDataModel();
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
        
        table.setAutoCreateRowSorter(true);
        PaginationDataProvider<QLKhachHangDTO> dataProvider = createDataProvider(objectDataModel);
        PaginatedTableDecorator<QLKhachHangDTO> paginatedDecorator = PaginatedTableDecorator.decorate(table,
                dataProvider, new int[]{5, 10, 20, 50, 75, 100}, 10);
        JPanel p = paginatedDecorator.getContentPanel();
        return p;
    }
    
    public static void main(String[] args) {
        JFrame frame = createFrame();
        JPanel p = new QLKhachHangTable().getTable();
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

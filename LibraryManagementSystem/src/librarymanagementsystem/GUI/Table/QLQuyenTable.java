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
import librarymanagementsystem.BUS.QLQuyenBUS;
import librarymanagementsystem.DTO.QLQuyenDTO;

public class QLQuyenTable{
    /*
    // for testing
    private static JFrame createFrame() {
        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(700, 500));
        return frame;
    }
    
    
    private static ObjectTableModel<QLQuyenDTO> createObjectDataModel(){
        return new ObjectTableModel<QLQuyenDTO>() {
            @Override
            public Object getValueAt(QLQuyenDTO quyen, int columnIndex) {
                switch (columnIndex) {
                //Sau khi code QLQuyenBUS thì thêm vào                   
                    case 0:
                        return quyen.getMaSach();
                    case 1:
                        return quyen.getTenSach();
                    case 2:
                        return quyen.getTenTacGia();
                    case 3:
                        return quyen.getTenNXB();
                    case 4:
                        return quyen.getTheLoai();
                    case 5:
                        return quyen.getNgonNgu();
                    case 6:
                        return quyen.getTomTatNoiDung();
                    case 7:
                        return quyen.getNamXB();
                    case 8:
                        return quyen.getGiaTien();
                    case 9:
                        return quyen.getSoTrang();
                }
                return null;
            }

            @Override
            public int getColumnCount() {
                return 10;
            }

            @Override
            public String getColumnName(int column) {
                switch (column) {
                    case 0:
                        return "Mã Sách";
                    case 1:
                        return "Tên Sách";
                    case 2:
                        return "Tên Tác Giả";
                    case 3:
                        return "Tên NXB";
                    case 4:
                        return "Thể Loại";
                    case 5:
                        return "Ngôn Ngữ";
                    case 6:
                        return "Tóm Tắt Nội Dung";
                    case 7:
                        return "Năm Xuất Bản";
                    case 8:
                        return "Giá Tiền";
                    case 9:
                        return "Số Trang";
                }
                return null;
            }
        };
    }
    
    private static PaginationDataProvider<QLQuyenDTO> createDataProvider(
            ObjectTableModel<QLQuyenDTO> objectDataModel) {
        final List<QLQuyenDTO> list = new QLQuyenBUS().getArr(); // QLQuyenBUS chưa có
        return new InMemoryPaginationDataProvider<>(list, objectDataModel);
    }
    */
    //public JPanel getTable(){
    ///    ObjectTableModel<QLQuyenDTO> objectDataModel = createObjectDataModel();
    ///    JTable table = new JTable(objectDataModel);
        
        //** Adjust Table**//
    ///    table.setRowHeight(35);
        //table.setIntercellSpacing(new Dimension(20, 0)); // Spacing 
        //table.getColumnModel().getColumn(0).setPreferredWidth(70);
        
        //DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        //centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        /* Align
        table.setDefaultRenderer(String.class, centerRenderer);
        table.setDefaultRenderer(Object.class, centerRenderer);
        table.setDefaultRenderer(Integer.class, centerRenderer);
        table.setDefaultRenderer(Long.class, centerRenderer);
        table.setDefaultRenderer(Double.class, centerRenderer);
        */
        
    ///    table.setFont(new Font("verdana", Font.PLAIN, 13));
        
    ///    table.getTableHeader().setBackground(new Color(91, 243, 207));
    ///    table.getTableHeader().setPreferredSize(new Dimension(0,35)); // Header Height
    ///    table.getTableHeader().setFont(new Font("verdana", Font.BOLD, 14));
    ///    table.getTableHeader().setForeground(Color.WHITE);
        //table.getTableHeader().;
        //** End Adjust **//
        
    ///    table.setAutoCreateRowSorter(true);
    ///    PaginationDataProvider<QLQuyenDTO> dataProvider = createDataProvider(objectDataModel);
    ///    PaginatedTableDecorator<QLQuyenDTO> paginatedDecorator = PaginatedTableDecorator.decorate(table,
    ///            dataProvider, new int[]{5, 10, 20, 50, 75, 100}, 10);
    ///    JPanel p = paginatedDecorator.getContentPanel();
    ///    return p;
    //}
    
    /*public static void main(String[] args) {
        JFrame frame = createFrame();
        JPanel p = new QLQuyenTable().getTable();
        //frame.add(paginatedDecorator.getContentPanel());
        p.setSize(700, 500);
        p.setBackground(new java.awt.Color(255, 255, 255));
        frame.add(p);
        frame.setBackground(new java.awt.Color(255, 255, 255));
         
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }*/
}

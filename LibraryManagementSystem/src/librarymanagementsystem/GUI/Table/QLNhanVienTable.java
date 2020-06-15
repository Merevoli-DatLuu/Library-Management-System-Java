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
import librarymanagementsystem.BUS.QLNhanVienBUS;
import librarymanagementsystem.DTO.QLNhanVienDTO;

public class QLNhanVienTable {

    // for testing
    private static JFrame createFrame() {
        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(700, 500));
        return frame;
    }
        
    private static ObjectTableModel<QLNhanVienDTO> createObjectDataModel(){
        return new ObjectTableModel<QLNhanVienDTO>() {
            @Override
            public Object getValueAt(QLNhanVienDTO nhanVien, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return nhanVien.getMaNhanVien();
                    case 1:
                        return nhanVien.getPassword();
                    case 2:
                        return nhanVien.getHoTen();
                    case 3:
                        return nhanVien.getNgaySinh();
                    case 4:
                        return nhanVien.getDiaChi();
                    case 5:
                        return nhanVien.getSdt();
                    case 6:
                        return nhanVien.getEmail();
                    case 7:
                        return nhanVien.getChucVu();
                }
                return null;
            }

            @Override
            public int getColumnCount() {
                return 8;
            }

            @Override
            public String getColumnName(int column) {
                switch (column) {
                    case 0:
                        return "Mã Quản Lý";
                    case 1:
                        return "Password";
                    case 2:
                        return "Họ Tên";
                    case 3:
                        return "Ngày Sinh";
                    case 4:
                        return "Địa Chỉ";
                    case 5:
                        return "Số Điện Thoại";
                    case 6:
                        return "Email";
                    case 7:
                        return "Chức Vụ";
                }
                return null;
            }
        };
    }
    
    private static PaginationDataProvider<QLNhanVienDTO> createDataProvider(
            ObjectTableModel<QLNhanVienDTO> objectDataModel) {
        final List<QLNhanVienDTO> list = new QLNhanVienBUS().getArrNhanVien();
        return new InMemoryPaginationDataProvider<>(list, objectDataModel);
    }
    
    private static PaginationDataProvider<QLNhanVienDTO> createDataProvider(
            ObjectTableModel<QLNhanVienDTO> objectDataModel, ArrayList <QLNhanVienDTO> nhanVien) {
        final List<QLNhanVienDTO> list = nhanVien;
        return new InMemoryPaginationDataProvider<>(list, objectDataModel);
    }
    
    public JPanel getTable(){
        ObjectTableModel<QLNhanVienDTO> objectDataModel = createObjectDataModel();
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
        width.add(120);
        width.add(300);
        width.add(190);
        width.add(120);
        width.add(340);
        width.add(110);
        width.add(225);
        width.add(120);
        
        table.setAutoCreateRowSorter(true);
        PaginationDataProvider<QLNhanVienDTO> dataProvider = createDataProvider(objectDataModel);
        PaginatedTableDecorator<QLNhanVienDTO> paginatedDecorator = PaginatedTableDecorator.decorate(table,
                dataProvider, new int[]{5, 10, 20, 50, 75, 100}, 10, width);
        paginatedDecorator.getClickEvent_NhanVien();
        JPanel p = paginatedDecorator.getContentPanel();
        return p;
    }
    
    public JPanel getTable(ArrayList <QLNhanVienDTO> nhanVien){
        ObjectTableModel<QLNhanVienDTO> objectDataModel = createObjectDataModel();
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
        width.add(120);
        width.add(300);
        width.add(190);
        width.add(120);
        width.add(340);
        width.add(110);
        width.add(225);
        width.add(120);
        
        table.setAutoCreateRowSorter(true);
        PaginationDataProvider<QLNhanVienDTO> dataProvider = createDataProvider(objectDataModel, nhanVien);
        PaginatedTableDecorator<QLNhanVienDTO> paginatedDecorator = PaginatedTableDecorator.decorate(table,
                dataProvider, new int[]{5, 10, 20, 50, 75, 100}, 10, width);
        paginatedDecorator.getClickEvent_NhanVien();
        JPanel p = paginatedDecorator.getContentPanel();
        return p;
    }
    
    public void expandMode(){
        JFrame frame = createFrame();
        JPanel p = new QLNhanVienTable().getTable();
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
        JPanel p = new QLNhanVienTable().getTable();
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

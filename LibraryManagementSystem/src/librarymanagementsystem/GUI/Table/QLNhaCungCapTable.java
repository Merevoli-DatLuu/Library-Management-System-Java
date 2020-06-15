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
import librarymanagementsystem.BUS.QLNhaCungCapBUS;
import librarymanagementsystem.DTO.QLNhaCungCapDTO;

public class QLNhaCungCapTable {

    // for testing
    private static JFrame createFrame() {
        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(700, 500));
        return frame;
    }
        
    private static ObjectTableModel<QLNhaCungCapDTO> createObjectDataModel(){
        return new ObjectTableModel<QLNhaCungCapDTO>() {
            @Override
            public Object getValueAt(QLNhaCungCapDTO nhacc, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return nhacc.getMaNCC();
                    case 1:
                        return nhacc.getTenNCC();
                    case 2:
                        return nhacc.getSdt();
                    case 3:
                        return nhacc.getEmail();
                    case 4:
                        return nhacc.getDiaChi();
                }
                return null;
            }

            @Override
            public int getColumnCount() {
                return 5;
            }

            @Override
            public String getColumnName(int column) {
                switch (column) {
                    case 0:
                        return "Mã Nhà Cung Cấp";
                    case 1:
                        return "Tên Nhà Cung Cấp";
                    case 2:
                        return "Số Điện Thoại";
                    case 3:
                        return "Email";
                    case 4:
                        return "Địa Chỉ";
                }
                return null;
            }
        };
    }
    
    private static PaginationDataProvider<QLNhaCungCapDTO> createDataProvider(
            ObjectTableModel<QLNhaCungCapDTO> objectDataModel) {
        final List<QLNhaCungCapDTO> list = new QLNhaCungCapBUS().getArrNhaCungCap();
        return new InMemoryPaginationDataProvider<>(list, objectDataModel);
    }
    
    private static PaginationDataProvider<QLNhaCungCapDTO> createDataProvider(
            ObjectTableModel<QLNhaCungCapDTO> objectDataModel, ArrayList <QLNhaCungCapDTO> nhaCungCap) {
        final List<QLNhaCungCapDTO> list = nhaCungCap;
        return new InMemoryPaginationDataProvider<>(list, objectDataModel);
    }
    
    public JPanel getTable(){
        ObjectTableModel<QLNhaCungCapDTO> objectDataModel = createObjectDataModel();
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
        
        width.add(160);
        width.add(190);
        width.add(130);
        width.add(220);
        width.add(335);
        
        table.setAutoCreateRowSorter(true);
        PaginationDataProvider<QLNhaCungCapDTO> dataProvider = createDataProvider(objectDataModel);
        PaginatedTableDecorator<QLNhaCungCapDTO> paginatedDecorator = PaginatedTableDecorator.decorate(table,
                dataProvider, new int[]{5, 10, 20, 50, 75, 100}, 10, width);
        paginatedDecorator.getClickEvent_NhaCungCap();
        JPanel p = paginatedDecorator.getContentPanel();
        return p;
    }
    
    public JPanel getTable(ArrayList <QLNhaCungCapDTO> nhaCungCap){
        ObjectTableModel<QLNhaCungCapDTO> objectDataModel = createObjectDataModel();
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
        
        width.add(160);
        width.add(190);
        width.add(130);
        width.add(220);
        width.add(335);
        
        table.setAutoCreateRowSorter(true);
        PaginationDataProvider<QLNhaCungCapDTO> dataProvider = createDataProvider(objectDataModel, nhaCungCap);
        PaginatedTableDecorator<QLNhaCungCapDTO> paginatedDecorator = PaginatedTableDecorator.decorate(table,
                dataProvider, new int[]{5, 10, 20, 50, 75, 100}, 10, width);
        paginatedDecorator.getClickEvent_NhaCungCap();
        JPanel p = paginatedDecorator.getContentPanel();
        return p;
    }
    
    public void expandMode(){
        JFrame frame = createFrame();
        JPanel p = new QLNhaCungCapTable().getTable();
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
        JPanel p = new QLNhaCungCapTable().getTable();
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

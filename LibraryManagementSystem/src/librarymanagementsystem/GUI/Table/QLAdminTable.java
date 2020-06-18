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
import librarymanagementsystem.BUS.QLAdminBUS;
import librarymanagementsystem.DTO.QLAdminDTO;

public class QLAdminTable {

    // for testing
    private static JFrame createFrame() {
        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(700, 500));
        return frame;
    }
        
    private static ObjectTableModel<QLAdminDTO> createObjectDataModel(){
        return new ObjectTableModel<QLAdminDTO>() {
            @Override
            public Object getValueAt(QLAdminDTO Admin, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return Admin.getTkAdmin();
                    case 1:
                        return Admin.getPassword();
                    case 2:
                        return Admin.getRFID_code();
                }
                return null;
            }

            @Override
            public int getColumnCount() {
                return 3;
            }

            @Override
            public String getColumnName(int column) {
                switch (column) {
                    case 0:
                        return "Tài Khoản Admin";
                    case 1:
                        return "password";
                    case 2:
                        return "RFID code";
                }
                return null;
            }
        };
    }
    
    private static PaginationDataProvider<QLAdminDTO> createDataProvider(
            ObjectTableModel<QLAdminDTO> objectDataModel) {
        final List<QLAdminDTO> list = new QLAdminBUS().getArrAdmin();
        return new InMemoryPaginationDataProvider<>(list, objectDataModel);
    }
    
    private static PaginationDataProvider<QLAdminDTO> createDataProvider(
            ObjectTableModel<QLAdminDTO> objectDataModel, ArrayList <QLAdminDTO> admin) {
        final List<QLAdminDTO> list = admin;
        return new InMemoryPaginationDataProvider<>(list, objectDataModel);
    }
    public JPanel getTable(){
        ObjectTableModel<QLAdminDTO> objectDataModel = createObjectDataModel();
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
        width.add(260);
        width.add(260);
        width.add(355);
        
        table.setAutoCreateRowSorter(true);
        PaginationDataProvider<QLAdminDTO> dataProvider = createDataProvider(objectDataModel);
        PaginatedTableDecorator<QLAdminDTO> paginatedDecorator = PaginatedTableDecorator.decorate(table,
                dataProvider, new int[]{5, 10, 20, 50, 75, 100}, 10, width);
        paginatedDecorator.getClickEvent_Admin();
        JPanel p = paginatedDecorator.getContentPanel();
        return p;
    }
    
    public JPanel getTable(ArrayList <QLAdminDTO> admin){
        ObjectTableModel<QLAdminDTO> objectDataModel = createObjectDataModel();
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
        width.add(260);
        width.add(260);
        width.add(355);
        
        table.setAutoCreateRowSorter(true);
        PaginationDataProvider<QLAdminDTO> dataProvider = createDataProvider(objectDataModel, admin);
        PaginatedTableDecorator<QLAdminDTO> paginatedDecorator = PaginatedTableDecorator.decorate(table,
                dataProvider, new int[]{5, 10, 20, 50, 75, 100}, 10, width);
        paginatedDecorator.getClickEvent_Admin();
        JPanel p = paginatedDecorator.getContentPanel();
        return p;
    }
    
    public void expandMode(){
        JFrame frame = createFrame();
        JPanel p = new QLAdminTable().getTable();
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
        JPanel p = new QLAdminTable().getTable();
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

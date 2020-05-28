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
import librarymanagementsystem.BUS.QLPhieuPhatBUS;
import librarymanagementsystem.DTO.QLPhieuPhatDTO;

public class QLPhieuPhatTable{
    
    // for testing
    private static JFrame createFrame() {
        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(700, 500));
        return frame;
    }
        
    private static ObjectTableModel<QLPhieuPhatDTO> createObjectDataModel(){
        return new ObjectTableModel<QLPhieuPhatDTO>() {
            @Override
            public Object getValueAt(QLPhieuPhatDTO phieuPhat, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return phieuPhat.getMaPhieuPhat();
                    case 1:
                        return phieuPhat.getMaPhieuMuon();
                    case 2:
                        return phieuPhat.getMaLDPhat();
//                    case 3:
//                        return phieuPhat.getTienPhat(); chưa có phần này BUS
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
                        return "Mã Phiếu Phạt";
                    case 1:
                        return "Mã Phiếu Mượn";
                    case 2:
                        return "Mã Lý Do Phạt";
//                    case 3:
//                        return "Tiền Phạt"; chưa có phần này bên BUS
                }
                return null;
            }
        };
    }
    
    private static PaginationDataProvider<QLPhieuPhatDTO> createDataProvider(
            ObjectTableModel<QLPhieuPhatDTO> objectDataModel) {
        final List<QLPhieuPhatDTO> list = new QLPhieuPhatBUS().getArrPhieuPhat();
        return new InMemoryPaginationDataProvider<>(list, objectDataModel);
    }
    
    public JPanel getTable(){
        ObjectTableModel<QLPhieuPhatDTO> objectDataModel = createObjectDataModel();
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
        PaginationDataProvider<QLPhieuPhatDTO> dataProvider = createDataProvider(objectDataModel);
        PaginatedTableDecorator<QLPhieuPhatDTO> paginatedDecorator = PaginatedTableDecorator.decorate(table,
                dataProvider, new int[]{5, 10, 20, 50, 75, 100}, 10);
        JPanel p = paginatedDecorator.getContentPanel();
        return p;
    }
    
    public static void main(String[] args) {
        JFrame frame = createFrame();
        JPanel p = new QLPhieuPhatTable().getTable();
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

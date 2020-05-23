package librarymanagementsystem.GUI.Table;


import librarymanagementsystem.BUS.*;
import librarymanagementsystem.DTO.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PaginationExampleMain {
    ArrayList <String> headers;
    ArrayList <Object> data;
    
    public static void main(String[] args) {
        JFrame frame = createFrame();
        ObjectTableModel<QLNhaCungCapDTO> objectDataModel = createObjectDataModel();
        JTable table = new JTable(objectDataModel);
        //** Adjust **//
        table.setRowHeight(30);
        //table.setIntercellSpacing(new Dimension(20, 0)); // Spacing 
        //table.getColumnModel().getColumn(0).setPreferredWidth(70);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(String.class, centerRenderer);
        table.setDefaultRenderer(Object.class, centerRenderer);
        table.setDefaultRenderer(Integer.class, centerRenderer);
        table.setDefaultRenderer(Long.class, centerRenderer);
        table.setDefaultRenderer(Double.class, centerRenderer);
        //** End Adjust **//
        
        table.setAutoCreateRowSorter(true);
        PaginationDataProvider<QLNhaCungCapDTO> dataProvider = createDataProvider(objectDataModel);
        PaginatedTableDecorator<QLNhaCungCapDTO> paginatedDecorator = PaginatedTableDecorator.decorate(table,
                dataProvider, new int[]{5, 10, 20, 50, 75, 100}, 10);
        frame.add(paginatedDecorator.getContentPanel());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public PaginationExampleMain(ArrayList <String> headers, ArrayList <Object> data) {
        this.headers = headers;
        this.data = data;
    }
    
    
    
    public JPanel get_table() {
        JFrame frame = createFrame();
        ObjectTableModel<QLNhaCungCapDTO> objectDataModel = createObjectDataModel();
        JTable table = new JTable(objectDataModel);
        //** Adjust **//
        table.setRowHeight(30);
        //table.setIntercellSpacing(new Dimension(20, 0)); // Spacing 
        //table.getColumnModel().getColumn(0).setPreferredWidth(70);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(String.class, centerRenderer);
        table.setDefaultRenderer(Object.class, centerRenderer);
        table.setDefaultRenderer(Integer.class, centerRenderer);
        table.setDefaultRenderer(Long.class, centerRenderer);
        table.setDefaultRenderer(Double.class, centerRenderer);
        //** End Adjust **//
        
        table.setAutoCreateRowSorter(true);
        PaginationDataProvider<QLNhaCungCapDTO> dataProvider = createDataProvider(objectDataModel);
        PaginatedTableDecorator<QLNhaCungCapDTO> paginatedDecorator = PaginatedTableDecorator.decorate(table,
                dataProvider, new int[]{5, 10, 20, 50, 75, 100}, 10);
        return paginatedDecorator.getContentPanel();
    }

    private static ObjectTableModel<QLNhaCungCapDTO> createObjectDataModel() {
        return new ObjectTableModel<QLNhaCungCapDTO>() {
            @Override
            public Object getValueAt(QLNhaCungCapDTO nhaCungCap, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return nhaCungCap.getMaNCC();
                    case 1:
                        return nhaCungCap.getTenNCC();
                    case 2:
                        return nhaCungCap.getSdt();
                    case 3:
                        return nhaCungCap.getEmail();
                    case 4:
                        return nhaCungCap.getDiaChi();
                }
                return null;
            }

            @Override
            public int getColumnCount() {
                return 4;
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
        final List<QLNhaCungCapDTO> list = new ArrayList<>();
        /*for (int i = 1; i <= 500; i++) {
            QLNhaCungCapDTO e = new QLNhaCungCapDTO();
            e.setId(i);
            e.setName(RandomUtil.createRandomWord(6));
            e.setDateOfBirth(RandomUtil.createRandomDate(1950, 2000));
            e.setAddress("address " + i);
            list.add(e);
        }*/
        List <QLNhaCungCapDTO> nhaCungCap = new QLNhaCungCapBUS().getArrNhaCungCap();
        return new InMemoryPaginationDataProvider<>(nhaCungCap, objectDataModel);
    }

    private static JFrame createFrame() {
        JFrame frame = new JFrame("JTable Pagination example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 300));
        return frame;
    }
}
package librarymanagementsystem.GUI.Table;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PaginationExampleMain {
    public static void main(String[] args) {
        JFrame frame = createFrame();
        ObjectTableModel<Employee> objectDataModel = createObjectDataModel();
        JTable table = new JTable(objectDataModel);
        //** Adjust **//
        table.setRowHeight(35);
        //table.setIntercellSpacing(new Dimension(20, 0)); // Spacing 
        //table.getColumnModel().getColumn(0).setPreferredWidth(70);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(String.class, centerRenderer);
        table.setDefaultRenderer(Object.class, centerRenderer);
        table.setDefaultRenderer(Integer.class, centerRenderer);
        table.setDefaultRenderer(Long.class, centerRenderer);
        table.setDefaultRenderer(Double.class, centerRenderer);
        
        table.setFont(new Font("Ubuntu", Font.PLAIN, 13));
        
        table.getTableHeader().setBackground(new Color(91, 243, 207));
        table.getTableHeader().setPreferredSize(new Dimension(0,35)); // HEader Height
        table.getTableHeader().setFont(new Font("Ubuntu", Font.BOLD, 14));
        table.getTableHeader().setForeground(Color.WHITE);
        //table.getTableHeader().;
        //** End Adjust **//
        
        table.setAutoCreateRowSorter(true);
        PaginationDataProvider<Employee> dataProvider = createDataProvider(objectDataModel);
        PaginatedTableDecorator<Employee> paginatedDecorator = PaginatedTableDecorator.decorate(table,
                dataProvider, new int[]{5, 10, 20, 50, 75, 100}, 10);
        /**/
        JPanel p = paginatedDecorator.getContentPanel();
        //frame.add(paginatedDecorator.getContentPanel());
        p.setSize(700, 500);
        p.setBackground(new java.awt.Color(255, 255, 255));
        frame.add(p);
        frame.setBackground(new java.awt.Color(255, 255, 255));
         
        /**/
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static ObjectTableModel<Employee> createObjectDataModel() {
        return new ObjectTableModel<Employee>() {
            @Override
            public Object getValueAt(Employee employee, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return employee.getId();
                    case 1:
                        return employee.getName();
                    case 2:
                        return employee.getDateOfBirth();
                    case 3:
                        return employee.getAddress();
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
                        return "Id";
                    case 1:
                        return "Name";
                    case 2:
                        return "Date Of Birth";
                    case 3:
                        return "Address";
                }
                return null;
            }
        };
    }

    private static PaginationDataProvider<Employee> createDataProvider(
            ObjectTableModel<Employee> objectDataModel) {
        final List<Employee> list = new ArrayList<>();
        for (int i = 1; i <= 500; i++) {
            Employee e = new Employee();
            e.setId(i);
            e.setName(RandomUtil.createRandomWord(6));
            e.setDateOfBirth(RandomUtil.createRandomDate(1950, 2000));
            e.setAddress("address " + i);
            list.add(e);
        }
        return new InMemoryPaginationDataProvider<>(list, objectDataModel);
    }

    private static JFrame createFrame() {
        JFrame frame = new JFrame("JTable Pagination example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(700, 500));
        return frame;
    }
}
package librarymanagementsystem.GUI.Table;

import javax.swing.*;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.Point;

import librarymanagementsystem.BUS.*;
import librarymanagementsystem.GUI.AlertGUI;
import librarymanagementsystem.GUI.ThemSuaGUI.*;

public class PaginatedTableDecorator<T> {
    private JTable table;
    private PaginationDataProvider<T> dataProvider;
    private int[] pageSizes;
    private JPanel contentPanel;
    private int currentPageSize;
    private int currentPage = 1;
    private JPanel pageLinkPanel;
    private ObjectTableModel objectTableModel;
    private static final int MaxPagingCompToShow = 9;
    private static final String Ellipses = "...";

    private PaginatedTableDecorator(JTable table, PaginationDataProvider<T> dataProvider,
                                    int[] pageSizes, int defaultPageSize) {
        this.table = table;
        this.dataProvider = dataProvider;
        this.pageSizes = pageSizes;
        this.currentPageSize = defaultPageSize;
    }
    
    private PaginatedTableDecorator(JTable table, PaginationDataProvider<T> dataProvider,
                                    int[] pageSizes, int defaultPageSize, ArrayList <Integer> widthColumns) {
        this.table = table;
        this.dataProvider = dataProvider;
        this.pageSizes = pageSizes;
        this.currentPageSize = defaultPageSize;
        
        // add set Width Column
        int index = 0;
        for (int wid : widthColumns){
            table.getColumnModel().getColumn(index++).setPreferredWidth(wid);
        }
        
        /*// Click event
        JTableHeader header = table.getTableHeader();
        //header.addMouseListener(new TableHeaderMouseListener(table));
        
        header.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent event){
                if (SwingUtilities.isRightMouseButton(event)){ // Right Click
                    Point point = event.getPoint();
                    int column = table.columnAtPoint(point);

                    //JOptionPane.showMessageDialog(table, "Column header #" + column + " is clicked.");
                    System.out.println("Column header #" + column + " is clicked.");
                    //for Loai Sach == testing
                    
                    ArrayList <String> header;
                    header = new ArrayList<String>(Arrays.asList(new QLLoaiSachBUS().getHeaders()));
                    RowPopup rp = new RowPopup();
                    rp.RowPopup_forHeader_NUMBER(header.get(column));
                    rp.show(contentPanel, event.getX(), event.getY() + 40);
                }
            }
        });
        
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event){
                if(event.getClickCount()== 1 && SwingUtilities.isRightMouseButton(event)){ // Chuột Phải
                    JTable target = (JTable)event.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    //JOptionPane.showMessageDialog(null, table.getValueAt(row, column));
                    //System.out.println(table.getValueAt(row, column));
                    System.out.println(table.getValueAt(row, 0));           // Get Columns 0 (Mã Chính) nhưng bug khi đổi chỗ cột
                    //new PopupInRows(event, (String)table.getValueAt(row, 0), contentPanel);
                    
                    RowPopup rp = new RowPopup();
                    rp.RowPopup_forRow((String)table.getValueAt(row, 0));
                    rp.show(contentPanel, event.getX(), event.getY() + 70);
                }
            }
        });*/
    }
    
    public void getClickEvent_LoaiSach(){
        // Click event
        JTableHeader header = table.getTableHeader();
        //header.addMouseListener(new TableHeaderMouseListener(table));
        
        header.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent event){
                if (SwingUtilities.isRightMouseButton(event)){ // Right Click
                    Point point = event.getPoint();
                    int column = table.columnAtPoint(point);

                    //JOptionPane.showMessageDialog(table, "Column header #" + column + " is clicked.");
                    System.out.println("Column header #" + column + " is clicked.");
                    //for Loai Sach == testing
                    
                    ArrayList <String> header;
                    header = new ArrayList<String>(Arrays.asList(new QLLoaiSachBUS(0).getHeaders()));
                    RowPopup rp = new RowPopup();
                    int headerType = new QLLoaiSachBUS(0).findHeaderType(header.get(column));
                    if (headerType == 0){
                        rp.RowPopup_forHeader_STRING(header.get(column), "LoaiSach");
                    }
                    else if (headerType == 1){
                        rp.RowPopup_forHeader_NUMBER(header.get(column), "LoaiSach");
                    }
                    rp.show(contentPanel, event.getX(), event.getY() + 40);
                }
            }
        });
        
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event){
                if(event.getClickCount()== 1 && SwingUtilities.isRightMouseButton(event)){ // Chuột Phải
                    JTable target = (JTable)event.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    //JOptionPane.showMessageDialog(null, table.getValueAt(row, column));
                    //System.out.println(table.getValueAt(row, column));
                    System.out.println(table.getValueAt(row, 0));           // Get Columns 0 (Mã Chính) nhưng bug khi đổi chỗ cột
                    //new PopupInRows(event, (String)table.getValueAt(row, 0), contentPanel);
                    
                    RowPopup rp = new RowPopup(){
                        @Override
                        public void viewActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xem Chi Tiết");
                            new XemLoaiSachForm(pKey).setVisible(true);
                        }
                        @Override
                        public void editActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Sửa");
                            new SuaLoaiSachForm(pKey).setVisible(true);
                        }
                        @Override
                        public void deleteActionPerformed(String pKey, ActionEvent e){
                            //JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xóa");
//                            AlertGUI xacnhan = new AlertGUI(0, "Xóa Loại Sách", "Bạn có muốn xóa loại sách " + pKey + "không?", "Đồng Ý", "Quay Lại"){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
                            //xacnhan.setVisible(true);
                            //new AlertGUI(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại").setVisible(true);
                            
//                            AlertGUI xacnhan = new AlertGUI(){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
//                            xacnhan.setProperties(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại");
//                            xacnhan.setVisible(true);
                            int option = JOptionPane.showConfirmDialog(
                                        null, 
                                        "Bạn có muốn xóa " + pKey + " ?", 
                                        "Xóa Loại Sách", 
                                        JOptionPane.YES_NO_OPTION);
                            if(option == JOptionPane.YES_OPTION){
                                if (new QLLoaiSachBUS(0).del(pKey)){
                                    System.out.println("Xóa " + pKey + " thành công");
                                    new AlertGUI(3, "Xóa Loai Sách", "Xóa loại sách " + pKey + " Thành Công", "Quay Lại").setVisible(true);
                                }
                                else{
                                    System.out.println("Xóa " + pKey + " thất bại");
                                    new AlertGUI(1, "Xóa Loai Sách", "Xóa loại sách " + pKey + "Thất Bại", "Quay Lại").setVisible(true);
                                }
                            }
                        }
                    };
                    rp.RowPopup_forRow((String)table.getValueAt(row, 0));
                    rp.show(contentPanel, event.getX(), event.getY() + 70);
                }
            }
        });
    }

    public void getClickEvent_NhaCungCap(){
        // Click event
        JTableHeader header = table.getTableHeader();
        //header.addMouseListener(new TableHeaderMouseListener(table));
        
        header.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent event){
                if (SwingUtilities.isRightMouseButton(event)){ // Right Click
                    Point point = event.getPoint();
                    int column = table.columnAtPoint(point);

                    //JOptionPane.showMessageDialog(table, "Column header #" + column + " is clicked.");
                    System.out.println("Column header #" + column + " is clicked.");
                    //for Loai Sach == testing
                    
                    ArrayList <String> header;
                    header = new ArrayList<String>(Arrays.asList(new QLNhaCungCapBUS(0).getHeaders()));
                    RowPopup rp = new RowPopup();
                    int headerType = new QLNhaCungCapBUS(0).findHeaderType(header.get(column));
                    if (headerType == 0){
                        rp.RowPopup_forHeader_STRING(header.get(column), "NhaCungCap");
                    }
                    else if (headerType == 1){
                        rp.RowPopup_forHeader_NUMBER(header.get(column), "NhaCungCap");
                    }
                    rp.show(contentPanel, event.getX(), event.getY() + 40);
                }
            }
        });
        
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event){
                if(event.getClickCount()== 1 && SwingUtilities.isRightMouseButton(event)){ // Chuột Phải
                    JTable target = (JTable)event.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    //JOptionPane.showMessageDialog(null, table.getValueAt(row, column));
                    //System.out.println(table.getValueAt(row, column));
                    System.out.println(table.getValueAt(row, 0));           // Get Columns 0 (Mã Chính) nhưng bug khi đổi chỗ cột
                    //new PopupInRows(event, (String)table.getValueAt(row, 0), contentPanel);
                    
                    RowPopup rp = new RowPopup(){
                        @Override
                        public void viewActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Nha Cung Cap" + pKey + " Xem Chi Tiết");
                        }
                        @Override
                        public void editActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Nha Cung Cap" + pKey + " Sửa");
                            new SuaNhaCungCapForm(pKey).setVisible(true);
                        }
                        @Override
                        public void deleteActionPerformed(String pKey, ActionEvent e){
                            //JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xóa");
//                            AlertGUI xacnhan = new AlertGUI(0, "Xóa Loại Sách", "Bạn có muốn xóa loại sách " + pKey + "không?", "Đồng Ý", "Quay Lại"){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
                            //xacnhan.setVisible(true);
                            //new AlertGUI(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại").setVisible(true);
                            
//                            AlertGUI xacnhan = new AlertGUI(){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
//                            xacnhan.setProperties(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại");
//                            xacnhan.setVisible(true);
                            int option = JOptionPane.showConfirmDialog(
                                        null, 
                                        "Bạn có muốn xóa " + pKey + " ?", 
                                        "Xóa Nhà Cung Cấp", 
                                        JOptionPane.YES_NO_OPTION);
                            if(option == JOptionPane.YES_OPTION){
                                if (new QLNhaCungCapBUS(0).del(pKey)){
                                    System.out.println("Xóa " + pKey + " thành công");
                                    new AlertGUI(3, "Xóa Nhà Cung Cấp", "Xóa Nhà Cung Cấp " + pKey + " Thành Công", "Quay Lại").setVisible(true);
                                }
                                else{
                                    System.out.println("Xóa " + pKey + " thất bại");
                                    new AlertGUI(1, "Xóa Nhà Cung Cấp", "Xóa Nhà Cung Cấp " + pKey + "Thất Bại", "Quay Lại").setVisible(true);
                                }
                            }
                        }
                    };
                    rp.RowPopup_forRow((String)table.getValueAt(row, 0));
                    rp.show(contentPanel, event.getX(), event.getY() + 70);
                }
            }
        });
    }

    public void getClickEvent_The(){
        // Click event
        JTableHeader header = table.getTableHeader();
        //header.addMouseListener(new TableHeaderMouseListener(table));
        
        header.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent event){
                if (SwingUtilities.isRightMouseButton(event)){ // Right Click
                    Point point = event.getPoint();
                    int column = table.columnAtPoint(point);

                    //JOptionPane.showMessageDialog(table, "Column header #" + column + " is clicked.");
                    System.out.println("Column header #" + column + " is clicked.");
                    //for Loai Sach == testing
                    
                    ArrayList <String> header;
                    header = new ArrayList<String>(Arrays.asList(new QLTheBUS(0).getHeaders()));
                    RowPopup rp = new RowPopup();
                    int headerType = new QLTheBUS(0).findHeaderType(header.get(column));
                    if (headerType == 0){
                        rp.RowPopup_forHeader_STRING(header.get(column), "The");
                    }
                    else if (headerType == 1){
                        rp.RowPopup_forHeader_NUMBER(header.get(column), "The");
                    }
                    rp.show(contentPanel, event.getX(), event.getY() + 40);
                }
            }
        });
        
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event){
                if(event.getClickCount()== 1 && SwingUtilities.isRightMouseButton(event)){ // Chuột Phải
                    JTable target = (JTable)event.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    //JOptionPane.showMessageDialog(null, table.getValueAt(row, column));
                    //System.out.println(table.getValueAt(row, column));
                    System.out.println(table.getValueAt(row, 0));           // Get Columns 0 (Mã Chính) nhưng bug khi đổi chỗ cột
                    //new PopupInRows(event, (String)table.getValueAt(row, 0), contentPanel);
                    
                    RowPopup rp = new RowPopup(){
                        @Override
                        public void viewActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "The " + pKey + " Xem Chi Tiết");
                        }
                        @Override
                        public void editActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "The " + pKey + " Sửa");
                            new SuaTheForm(pKey).setVisible(true);
                        }
                        @Override
                        public void deleteActionPerformed(String pKey, ActionEvent e){
                            //JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xóa");
//                            AlertGUI xacnhan = new AlertGUI(0, "Xóa Loại Sách", "Bạn có muốn xóa loại sách " + pKey + "không?", "Đồng Ý", "Quay Lại"){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
                            //xacnhan.setVisible(true);
                            //new AlertGUI(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại").setVisible(true);
                            
//                            AlertGUI xacnhan = new AlertGUI(){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
//                            xacnhan.setProperties(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại");
//                            xacnhan.setVisible(true);
                            int option = JOptionPane.showConfirmDialog(
                                        null, 
                                        "Bạn có muốn xóa " + pKey + " ?", 
                                        "Xóa Thẻ", 
                                        JOptionPane.YES_NO_OPTION);
                            if(option == JOptionPane.YES_OPTION){
                                if (new QLTheBUS(0).del(pKey)){
                                    System.out.println("Xóa " + pKey + " thành công");
                                    new AlertGUI(3, "Xóa Thẻ", "Xóa Thẻ " + pKey + " Thành Công", "Quay Lại").setVisible(true);
                                }
                                else{
                                    System.out.println("Xóa " + pKey + " thất bại");
                                    new AlertGUI(1, "Xóa Thẻ", "Xóa Thẻ " + pKey + "Thất Bại", "Quay Lại").setVisible(true);
                                }
                            }
                        }
                    };
                    rp.RowPopup_forRow((String)table.getValueAt(row, 0));
                    rp.show(contentPanel, event.getX(), event.getY() + 70);
                }
            }
        });
    }

    public void getClickEvent_NhanVien(){
        // Click event
        JTableHeader header = table.getTableHeader();
        //header.addMouseListener(new TableHeaderMouseListener(table));
        
        header.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent event){
                if (SwingUtilities.isRightMouseButton(event)){ // Right Click
                    Point point = event.getPoint();
                    int column = table.columnAtPoint(point);

                    //JOptionPane.showMessageDialog(table, "Column header #" + column + " is clicked.");
                    System.out.println("Column header #" + column + " is clicked.");
                    //for Loai Sach == testing
                    
                    ArrayList <String> header;
                    header = new ArrayList<String>(Arrays.asList(new QLNhanVienBUS(0).getHeaders()));
                    RowPopup rp = new RowPopup();
                    int headerType = new QLNhanVienBUS(0).findHeaderType(header.get(column));
                    if (headerType == 0){
                        rp.RowPopup_forHeader_STRING(header.get(column), "NhanVien");
                    }
                    else if (headerType == 1){
                        rp.RowPopup_forHeader_NUMBER(header.get(column), "NhanVien");
                    }
                    rp.show(contentPanel, event.getX(), event.getY() + 40);
                }
            }
        });
        
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event){
                if(event.getClickCount()== 1 && SwingUtilities.isRightMouseButton(event)){ // Chuột Phải
                    JTable target = (JTable)event.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    //JOptionPane.showMessageDialog(null, table.getValueAt(row, column));
                    //System.out.println(table.getValueAt(row, column));
                    System.out.println(table.getValueAt(row, 0));           // Get Columns 0 (Mã Chính) nhưng bug khi đổi chỗ cột
                    //new PopupInRows(event, (String)table.getValueAt(row, 0), contentPanel);
                    
                    RowPopup rp = new RowPopup(){
                        @Override
                        public void viewActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Nhân Viên" + pKey + " Xem Chi Tiết");
                        }
                        @Override
                        public void editActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Nhân Viên" + pKey + " Sửa");
                            new SuaNhanVienForm(pKey).setVisible(true);
                        }
                        @Override
                        public void deleteActionPerformed(String pKey, ActionEvent e){
                            //JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xóa");
//                            AlertGUI xacnhan = new AlertGUI(0, "Xóa Loại Sách", "Bạn có muốn xóa loại sách " + pKey + "không?", "Đồng Ý", "Quay Lại"){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
                            //xacnhan.setVisible(true);
                            //new AlertGUI(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại").setVisible(true);
                            
//                            AlertGUI xacnhan = new AlertGUI(){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
//                            xacnhan.setProperties(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại");
//                            xacnhan.setVisible(true);
                            int option = JOptionPane.showConfirmDialog(
                                        null, 
                                        "Bạn có muốn xóa " + pKey + " ?", 
                                        "Xóa Nhân Viên", 
                                        JOptionPane.YES_NO_OPTION);
                            if(option == JOptionPane.YES_OPTION){
                                if (new QLNhanVienBUS(0).del(pKey)){
                                    System.out.println("Xóa " + pKey + " thành công");
                                    new AlertGUI(3, "Xóa Nhân Viên", "Xóa Nhân Viên " + pKey + " Thành Công", "Quay Lại").setVisible(true);
                                }
                                else{
                                    System.out.println("Xóa " + pKey + " thất bại");
                                    new AlertGUI(1, "Xóa Nhân Viên", "Xóa Nhân Viên " + pKey + "Thất Bại", "Quay Lại").setVisible(true);
                                }
                            }
                        }
                    };
                    rp.RowPopup_forRow((String)table.getValueAt(row, 0));
                    rp.show(contentPanel, event.getX(), event.getY() + 70);
                }
            }
        });
    }
    
    public void getClickEvent_SachThuVien(){
        // Click event
        JTableHeader header = table.getTableHeader();
        //header.addMouseListener(new TableHeaderMouseListener(table));
        
        header.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent event){
                if (SwingUtilities.isRightMouseButton(event)){ // Right Click
                    Point point = event.getPoint();
                    int column = table.columnAtPoint(point);

                    //JOptionPane.showMessageDialog(table, "Column header #" + column + " is clicked.");
                    System.out.println("Column header #" + column + " is clicked.");
                    //for Loai Sach == testing
                    
                    ArrayList <String> header;
                    header = new ArrayList<String>(Arrays.asList(new QLChiTietSachBUS(0).getHeaders()));
                    RowPopup rp = new RowPopup();
                    int headerType = new QLChiTietSachBUS(0).findHeaderType(header.get(column));
                    if (headerType == 0){
                        rp.RowPopup_forHeader_STRING(header.get(column), "SachThuVien");
                    }
                    else if (headerType == 1){
                        rp.RowPopup_forHeader_NUMBER(header.get(column), "SachThuVien");
                    }
                    rp.show(contentPanel, event.getX(), event.getY() + 40);
                }
            }
        });
        
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event){
                if(event.getClickCount()== 1 && SwingUtilities.isRightMouseButton(event)){ // Chuột Phải
                    JTable target = (JTable)event.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    //JOptionPane.showMessageDialog(null, table.getValueAt(row, column));
                    //System.out.println(table.getValueAt(row, column));
                    System.out.println(table.getValueAt(row, 0));           // Get Columns 0 (Mã Chính) nhưng bug khi đổi chỗ cột
                    //new PopupInRows(event, (String)table.getValueAt(row, 0), contentPanel);
                    
                    RowPopup rp = new RowPopup(){
                        @Override
                        public void viewActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xem Chi Tiết");
                        }
                        @Override
                        public void editActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Sửa");
                            new SuaCTSachForm(pKey).setVisible(true);
                        }
                        @Override
                        public void deleteActionPerformed(String pKey, ActionEvent e){
                            //JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xóa");
//                            AlertGUI xacnhan = new AlertGUI(0, "Xóa Loại Sách", "Bạn có muốn xóa loại sách " + pKey + "không?", "Đồng Ý", "Quay Lại"){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
                            //xacnhan.setVisible(true);
                            //new AlertGUI(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại").setVisible(true);
                            
//                            AlertGUI xacnhan = new AlertGUI(){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
//                            xacnhan.setProperties(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại");
//                            xacnhan.setVisible(true);
                            int option = JOptionPane.showConfirmDialog(
                                        null, 
                                        "Bạn có muốn xóa " + pKey + " ?", 
                                        "Xóa Sách Thư Viện", 
                                        JOptionPane.YES_NO_OPTION);
                            if(option == JOptionPane.YES_OPTION){
                                if (new QLChiTietSachBUS(0).del(pKey)){
                                    System.out.println("Xóa " + pKey + " thành công");
                                    new AlertGUI(3, "Xóa Sách Thư Viện", "Xóa Sách Thư Viện " + pKey + " Thành Công", "Quay Lại").setVisible(true);
                                }
                                else{
                                    System.out.println("Xóa " + pKey + " thất bại");
                                    new AlertGUI(1, "Xóa Sách Thư Viện", "Xóa Sách Thư Viện " + pKey + "Thất Bại", "Quay Lại").setVisible(true);
                                }
                            }
                        }
                    };
                    rp.RowPopup_forRow((String)table.getValueAt(row, 0));
                    rp.show(contentPanel, event.getX(), event.getY() + 70);
                }
            }
        });
    }
    
    public void getClickEvent_PhieuMuon(){
        // Click event
        JTableHeader header = table.getTableHeader();
        //header.addMouseListener(new TableHeaderMouseListener(table));
        
        header.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent event){
                if (SwingUtilities.isRightMouseButton(event)){ // Right Click
                    Point point = event.getPoint();
                    int column = table.columnAtPoint(point);

                    //JOptionPane.showMessageDialog(table, "Column header #" + column + " is clicked.");
                    System.out.println("Column header #" + column + " is clicked.");
                    //for Loai Sach == testing
                    
                    ArrayList <String> header;
                    header = new ArrayList<String>(Arrays.asList(new QLPhieuMuonBUS(0).getHeaders()));
                    RowPopup rp = new RowPopup();
                    int headerType = new QLPhieuMuonBUS(0).findHeaderType(header.get(column));
                    if (headerType == 0){
                        rp.RowPopup_forHeader_STRING(header.get(column), "PhieuMuon");
                    }
                    else if (headerType == 1){
                        rp.RowPopup_forHeader_NUMBER(header.get(column), "PhieuMuon");
                    }
                    rp.show(contentPanel, event.getX(), event.getY() + 40);
                }
            }
        });
        
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event){
                if(event.getClickCount()== 1 && SwingUtilities.isRightMouseButton(event)){ // Chuột Phải
                    JTable target = (JTable)event.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    //JOptionPane.showMessageDialog(null, table.getValueAt(row, column));
                    //System.out.println(table.getValueAt(row, column));
                    System.out.println(table.getValueAt(row, 0));           // Get Columns 0 (Mã Chính) nhưng bug khi đổi chỗ cột
                    //new PopupInRows(event, (String)table.getValueAt(row, 0), contentPanel);
                    
                    RowPopup rp = new RowPopup(){
                        @Override
                        public void viewActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xem Chi Tiết");
                        }
                        @Override
                        public void editActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Sửa");
                            new SuaLoaiSachForm(pKey).setVisible(true);
                        }
                        @Override
                        public void deleteActionPerformed(String pKey, ActionEvent e){
                            //JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xóa");
//                            AlertGUI xacnhan = new AlertGUI(0, "Xóa Loại Sách", "Bạn có muốn xóa loại sách " + pKey + "không?", "Đồng Ý", "Quay Lại"){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
                            //xacnhan.setVisible(true);
                            //new AlertGUI(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại").setVisible(true);
                            
//                            AlertGUI xacnhan = new AlertGUI(){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
//                            xacnhan.setProperties(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại");
//                            xacnhan.setVisible(true);
                            int option = JOptionPane.showConfirmDialog(
                                        null, 
                                        "Bạn có muốn xóa " + pKey + " ?", 
                                        "Xóa Phiếu Mượn", 
                                        JOptionPane.YES_NO_OPTION);
                            if(option == JOptionPane.YES_OPTION){
                                if (new QLPhieuMuonBUS(0).del(pKey)){
                                    System.out.println("Xóa " + pKey + " thành công");
                                    new AlertGUI(3, "Xóa Phiếu Mượn", "Xóa Phiếu Mượn " + pKey + " Thành Công", "Quay Lại").setVisible(true);
                                }
                                else{
                                    System.out.println("Xóa " + pKey + " thất bại");
                                    new AlertGUI(1, "Xóa Phiếu Mượn", "Xóa Phiếu Mượn " + pKey + "Thất Bại", "Quay Lại").setVisible(true);
                                }
                            }
                        }
                    };
                    rp.RowPopup_forRow((String)table.getValueAt(row, 0));
                    rp.show(contentPanel, event.getX(), event.getY() + 70);
                }
            }
        });
    }

    public void getClickEvent_KhoSach(){
        // Click event
        JTableHeader header = table.getTableHeader();
        //header.addMouseListener(new TableHeaderMouseListener(table));
        
        header.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent event){
                if (SwingUtilities.isRightMouseButton(event)){ // Right Click
                    Point point = event.getPoint();
                    int column = table.columnAtPoint(point);

                    //JOptionPane.showMessageDialog(table, "Column header #" + column + " is clicked.");
                    System.out.println("Column header #" + column + " is clicked.");
                    //for Loai Sach == testing
                    
                    ArrayList <String> header;
                    header = new ArrayList<String>(Arrays.asList(new QLKhoSachBUS(0).getHeaders()));
                    RowPopup rp = new RowPopup();
                    int headerType = new QLKhoSachBUS(0).findHeaderType(header.get(column));
                    if (headerType == 0){
                        rp.RowPopup_forHeader_STRING(header.get(column), "KhoSach");
                    }
                    else if (headerType == 1){
                        rp.RowPopup_forHeader_NUMBER(header.get(column), "KhoSach");
                    }
                    rp.show(contentPanel, event.getX(), event.getY() + 40);
                }
            }
        });
        
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event){
                if(event.getClickCount()== 1 && SwingUtilities.isRightMouseButton(event)){ // Chuột Phải
                    JTable target = (JTable)event.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    //JOptionPane.showMessageDialog(null, table.getValueAt(row, column));
                    //System.out.println(table.getValueAt(row, column));
                    System.out.println(table.getValueAt(row, 0));           // Get Columns 0 (Mã Chính) nhưng bug khi đổi chỗ cột
                    //new PopupInRows(event, (String)table.getValueAt(row, 0), contentPanel);
                    
                    RowPopup rp = new RowPopup(){
                        @Override
                        public void viewActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xem Chi Tiết");
                        }
                        @Override
                        public void editActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Sửa");
                            new SuaLoaiSachForm(pKey).setVisible(true);
                        }
                        @Override
                        public void deleteActionPerformed(String pKey, ActionEvent e){
                            //JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xóa");
//                            AlertGUI xacnhan = new AlertGUI(0, "Xóa Loại Sách", "Bạn có muốn xóa loại sách " + pKey + "không?", "Đồng Ý", "Quay Lại"){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
                            //xacnhan.setVisible(true);
                            //new AlertGUI(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại").setVisible(true);
                            
//                            AlertGUI xacnhan = new AlertGUI(){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
//                            xacnhan.setProperties(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại");
//                            xacnhan.setVisible(true);
                            int option = JOptionPane.showConfirmDialog(
                                        null, 
                                        "Bạn có muốn xóa " + pKey + " ?", 
                                        "Xóa Loại Sách", 
                                        JOptionPane.YES_NO_OPTION);
                            if(option == JOptionPane.YES_OPTION){
                                if (new QLLoaiSachBUS(0).del(pKey)){
                                    System.out.println("Xóa " + pKey + " thành công");
                                    new AlertGUI(3, "Xóa Loai Sách", "Xóa loại sách " + pKey + " Thành Công", "Quay Lại").setVisible(true);
                                }
                                else{
                                    System.out.println("Xóa " + pKey + " thất bại");
                                    new AlertGUI(1, "Xóa Loai Sách", "Xóa loại sách " + pKey + "Thất Bại", "Quay Lại").setVisible(true);
                                }
                            }
                        }
                    };
//                    rp.RowPopup_forRow((String)table.getValueAt(row, 0));
//                    rp.show(contentPanel, event.getX(), event.getY() + 70);
                }
            }
        });
    }

    public void getClickEvent_KhachHang(){
        // Click event
        JTableHeader header = table.getTableHeader();
        //header.addMouseListener(new TableHeaderMouseListener(table));
        
        header.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent event){
                if (SwingUtilities.isRightMouseButton(event)){ // Right Click
                    Point point = event.getPoint();
                    int column = table.columnAtPoint(point);

                    //JOptionPane.showMessageDialog(table, "Column header #" + column + " is clicked.");
                    System.out.println("Column header #" + column + " is clicked.");
                    //for Loai Sach == testing
                    
                    ArrayList <String> header;
                    header = new ArrayList<String>(Arrays.asList(new QLKhachHangBUS(0).getHeaders()));
                    RowPopup rp = new RowPopup();
                    int headerType = new QLKhachHangBUS(0).findHeaderType(header.get(column));
                    if (headerType == 0){
                        rp.RowPopup_forHeader_STRING(header.get(column), "KhachHang");
                    }
                    else if (headerType == 1){
                        rp.RowPopup_forHeader_NUMBER(header.get(column), "KhachHang");
                    }
                    rp.show(contentPanel, event.getX(), event.getY() + 40);
                }
            }
        });
        
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event){
                if(event.getClickCount()== 1 && SwingUtilities.isRightMouseButton(event)){ // Chuột Phải
                    JTable target = (JTable)event.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    //JOptionPane.showMessageDialog(null, table.getValueAt(row, column));
                    //System.out.println(table.getValueAt(row, column));
                    System.out.println(table.getValueAt(row, 0));           // Get Columns 0 (Mã Chính) nhưng bug khi đổi chỗ cột
                    //new PopupInRows(event, (String)table.getValueAt(row, 0), contentPanel);
                    
                    RowPopup rp = new RowPopup(){
                        @Override
                        public void viewActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xem Chi Tiết");
                        }
                        @Override
                        public void editActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Sửa");
                            new SuaKhachHangForm(pKey).setVisible(true);
                        }
                        @Override
                        public void deleteActionPerformed(String pKey, ActionEvent e){
                            //JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xóa");
//                            AlertGUI xacnhan = new AlertGUI(0, "Xóa Loại Sách", "Bạn có muốn xóa loại sách " + pKey + "không?", "Đồng Ý", "Quay Lại"){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
                            //xacnhan.setVisible(true);
                            //new AlertGUI(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại").setVisible(true);
                            
//                            AlertGUI xacnhan = new AlertGUI(){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
//                            xacnhan.setProperties(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại");
//                            xacnhan.setVisible(true);
                            int option = JOptionPane.showConfirmDialog(
                                        null, 
                                        "Bạn có muốn xóa " + pKey + " ?", 
                                        "Xóa Khách Hàng", 
                                        JOptionPane.YES_NO_OPTION);
                            if(option == JOptionPane.YES_OPTION){
                                if (new QLKhachHangBUS(0).del(pKey)){
                                    System.out.println("Xóa " + pKey + " thành công");
                                    new AlertGUI(3, "Xóa Khách Hàng", "Xóa Khách Hàng " + pKey + " Thành Công", "Quay Lại").setVisible(true);
                                }
                                else{
                                    System.out.println("Xóa " + pKey + " thất bại");
                                    new AlertGUI(1, "Xóa Khách Hàng", "Xóa Khách Hàng " + pKey + "Thất Bại", "Quay Lại").setVisible(true);
                                }
                            }
                        }
                    };
                    rp.RowPopup_forRow((String)table.getValueAt(row, 0));
                    rp.show(contentPanel, event.getX(), event.getY() + 70);
                }
            }
        });
    }

    public void getClickEvent_Quyen(){
        // Click event
        JTableHeader header = table.getTableHeader();
        //header.addMouseListener(new TableHeaderMouseListener(table));
        
        header.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent event){
                if (SwingUtilities.isRightMouseButton(event)){ // Right Click
                    Point point = event.getPoint();
                    int column = table.columnAtPoint(point);

                    //JOptionPane.showMessageDialog(table, "Column header #" + column + " is clicked.");
                    System.out.println("Column header #" + column + " is clicked.");
                    //for Loai Sach == testing
                    
                    ArrayList <String> header;
                    header = new ArrayList<String>(Arrays.asList(new QLQuyenBUS(0).getHeaders()));
                    RowPopup rp = new RowPopup();
                    int headerType = new QLQuyenBUS(0).findHeaderType(header.get(column));
                    if (headerType == 0){
                        rp.RowPopup_forHeader_STRING(header.get(column), "Quyen");
                    }
                    else if (headerType == 1){
                        rp.RowPopup_forHeader_NUMBER(header.get(column), "Quyen");
                    }
                    rp.show(contentPanel, event.getX(), event.getY() + 40);
                }
            }
        });
        
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event){
                if(event.getClickCount()== 1 && SwingUtilities.isRightMouseButton(event)){ // Chuột Phải
                    JTable target = (JTable)event.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    //JOptionPane.showMessageDialog(null, table.getValueAt(row, column));
                    //System.out.println(table.getValueAt(row, column));
                    System.out.println(table.getValueAt(row, 0));           // Get Columns 0 (Mã Chính) nhưng bug khi đổi chỗ cột
                    //new PopupInRows(event, (String)table.getValueAt(row, 0), contentPanel);
                    
                    RowPopup rp = new RowPopup(){
                        @Override
                        public void viewActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xem Chi Tiết");
                        }
                        @Override
                        public void editActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Sửa");
//                            new SuaLoaiSachForm(pKey).setVisible(true);
                        }
                        @Override
                        public void deleteActionPerformed(String pKey, ActionEvent e){
                            //JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xóa");
//                            AlertGUI xacnhan = new AlertGUI(0, "Xóa Loại Sách", "Bạn có muốn xóa loại sách " + pKey + "không?", "Đồng Ý", "Quay Lại"){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
                            //xacnhan.setVisible(true);
                            //new AlertGUI(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại").setVisible(true);
                            
//                            AlertGUI xacnhan = new AlertGUI(){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
//                            xacnhan.setProperties(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại");
//                            xacnhan.setVisible(true);
                            int option = JOptionPane.showConfirmDialog(
                                        null, 
                                        "Bạn có muốn xóa " + pKey + " ?", 
                                        "Xóa Quyền", 
                                        JOptionPane.YES_NO_OPTION);
                            if(option == JOptionPane.YES_OPTION){
                                if (new QLQuyenBUS(0).del(pKey)){
                                    System.out.println("Xóa " + pKey + " thành công");
                                    new AlertGUI(3, "Xóa Quyền", "Xóa Quyền " + pKey + " Thành Công", "Quay Lại").setVisible(true);
                                }
                                else{
                                    System.out.println("Xóa " + pKey + " thất bại");
                                    new AlertGUI(1, "Xóa Quyền", "Xóa Quyền " + pKey + "Thất Bại", "Quay Lại").setVisible(true);
                                }
                            }
                        }
                    };
                    rp.RowPopup_forRow((String)table.getValueAt(row, 0));
                    rp.show(contentPanel, event.getX(), event.getY() + 70);
                }
            }
        });
    }

    public void getClickEvent_Admin(){
        // Click event
        JTableHeader header = table.getTableHeader();
        //header.addMouseListener(new TableHeaderMouseListener(table));
        
        header.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent event){
                if (SwingUtilities.isRightMouseButton(event)){ // Right Click
                    Point point = event.getPoint();
                    int column = table.columnAtPoint(point);

                    //JOptionPane.showMessageDialog(table, "Column header #" + column + " is clicked.");
                    System.out.println("Column header #" + column + " is clicked.");
                    //for Loai Sach == testing
                    
                    ArrayList <String> header;
                    header = new ArrayList<String>(Arrays.asList(new QLAdminBUS(0).getHeaders()));
                    RowPopup rp = new RowPopup();
                    int headerType = new QLAdminBUS(0).findHeaderType(header.get(column));
                    if (headerType == 0){
                        rp.RowPopup_forHeader_STRING(header.get(column), "Admin");
                    }
                    else if (headerType == 1){
                        rp.RowPopup_forHeader_NUMBER(header.get(column), "Admin");
                    }
                    rp.show(contentPanel, event.getX(), event.getY() + 40);
                }
            }
        });
        
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event){
                if(event.getClickCount()== 1 && SwingUtilities.isRightMouseButton(event)){ // Chuột Phải
                    JTable target = (JTable)event.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    //JOptionPane.showMessageDialog(null, table.getValueAt(row, column));
                    //System.out.println(table.getValueAt(row, column));
                    System.out.println(table.getValueAt(row, 0));           // Get Columns 0 (Mã Chính) nhưng bug khi đổi chỗ cột
                    //new PopupInRows(event, (String)table.getValueAt(row, 0), contentPanel);
                    
                    RowPopup rp = new RowPopup(){
                        @Override
                        public void viewActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xem Chi Tiết");
                        }
                        @Override
                        public void editActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Sửa");
                            new SuaAdminForm(pKey).setVisible(true);
                        }
                        @Override
                        public void deleteActionPerformed(String pKey, ActionEvent e){
                            //JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xóa");
//                            AlertGUI xacnhan = new AlertGUI(0, "Xóa Loại Sách", "Bạn có muốn xóa loại sách " + pKey + "không?", "Đồng Ý", "Quay Lại"){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
                            //xacnhan.setVisible(true);
                            //new AlertGUI(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại").setVisible(true);
                            
//                            AlertGUI xacnhan = new AlertGUI(){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
//                            xacnhan.setProperties(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại");
//                            xacnhan.setVisible(true);
                            if (new QLAdminBUS(0).getArrAdmin().size() == 1){
                                new AlertGUI(3, "Xóa Admin", "Không Được Xóa Admin", "Quay Lại").setVisible(true);
                            }
                            else{
                                int option = JOptionPane.showConfirmDialog(
                                            null, 
                                            "Bạn có muốn xóa " + pKey + " ?", 
                                            "Xóa Admin", 
                                            JOptionPane.YES_NO_OPTION);
                                if(option == JOptionPane.YES_OPTION){
                                    if (new QLAdminBUS(0).del(pKey)){
                                        System.out.println("Xóa " + pKey + " thành công");
                                        new AlertGUI(3, "Xóa Admin", "Xóa loại sách " + pKey + " Thành Công", "Quay Lại").setVisible(true);
                                    }
                                    else{
                                        System.out.println("Xóa " + pKey + " thất bại");
                                        new AlertGUI(1, "Xóa Admin", "Xóa loại sách " + pKey + "Thất Bại", "Quay Lại").setVisible(true);
                                    }
                                }
                            }
                        }
                    };
                    rp.RowPopup_forRow((String)table.getValueAt(row, 0));
                    rp.show(contentPanel, event.getX(), event.getY() + 70);
                }
            }
        });
    }
    
    public void getClickEvent_PhieuXuat(){
        // Click event
        JTableHeader header = table.getTableHeader();
        //header.addMouseListener(new TableHeaderMouseListener(table));
        
        header.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent event){
                if (SwingUtilities.isRightMouseButton(event)){ // Right Click
                    Point point = event.getPoint();
                    int column = table.columnAtPoint(point);

                    //JOptionPane.showMessageDialog(table, "Column header #" + column + " is clicked.");
                    System.out.println("Column header #" + column + " is clicked.");
                    //for Loai Sach == testing
                    
                    ArrayList <String> header;
                    header = new ArrayList<String>(Arrays.asList(new QLPhieuXuatBUS(0).getHeaders()));
                    RowPopup rp = new RowPopup();
                    int headerType = new QLPhieuXuatBUS(0).findHeaderType(header.get(column));
                    if (headerType == 0){
                        rp.RowPopup_forHeader_STRING(header.get(column), "PhieuXuat");
                    }
                    else if (headerType == 1){
                        rp.RowPopup_forHeader_NUMBER(header.get(column), "PhieuXuat");
                    }
                    rp.show(contentPanel, event.getX(), event.getY() + 40);
                }
            }
        });
        
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event){
                if(event.getClickCount()== 1 && SwingUtilities.isRightMouseButton(event)){ // Chuột Phải
                    JTable target = (JTable)event.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    //JOptionPane.showMessageDialog(null, table.getValueAt(row, column));
                    //System.out.println(table.getValueAt(row, column));
                    System.out.println(table.getValueAt(row, 0));           // Get Columns 0 (Mã Chính) nhưng bug khi đổi chỗ cột
                    //new PopupInRows(event, (String)table.getValueAt(row, 0), contentPanel);
                    
                    RowPopup rp = new RowPopup(){
                        @Override
                        public void viewActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xem Chi Tiết");
                        }
                        @Override
                        public void editActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Sửa");
//                            new SuaPhieuXuatForm(pKey).setVisible(true);
                        }
                        @Override
                        public void deleteActionPerformed(String pKey, ActionEvent e){
                            //JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xóa");
//                            AlertGUI xacnhan = new AlertGUI(0, "Xóa Loại Sách", "Bạn có muốn xóa loại sách " + pKey + "không?", "Đồng Ý", "Quay Lại"){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
                            //xacnhan.setVisible(true);
                            //new AlertGUI(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại").setVisible(true);
                            
//                            AlertGUI xacnhan = new AlertGUI(){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
//                            xacnhan.setProperties(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại");
//                            xacnhan.setVisible(true);
                            int option = JOptionPane.showConfirmDialog(
                                        null, 
                                        "Bạn có muốn xóa " + pKey + " ?", 
                                        "Xóa Phiếu Xuất", 
                                        JOptionPane.YES_NO_OPTION);
                            if(option == JOptionPane.YES_OPTION){
                                if (new QLPhieuXuatBUS(0).del(pKey)){
                                    System.out.println("Xóa " + pKey + " thành công");
                                    new AlertGUI(3, "Xóa Phiếu Xuất", "Xóa Phiếu Xuất " + pKey + " Thành Công", "Quay Lại").setVisible(true);
                                }
                                else{
                                    System.out.println("Xóa " + pKey + " thất bại");
                                    new AlertGUI(1, "Xóa Phiếu Xuất", "Xóa Phiếu Xuất " + pKey + "Thất Bại", "Quay Lại").setVisible(true);
                                }
                            }
                        }
                    };
                    rp.RowPopup_forRow((String)table.getValueAt(row, 0));
                    rp.show(contentPanel, event.getX(), event.getY() + 70);
                }
            }
        });
    }
    
    public void getClickEvent_PhieuNhap(){
        // Click event
        JTableHeader header = table.getTableHeader();
        //header.addMouseListener(new TableHeaderMouseListener(table));
        
        header.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent event){
                if (SwingUtilities.isRightMouseButton(event)){ // Right Click
                    Point point = event.getPoint();
                    int column = table.columnAtPoint(point);

                    //JOptionPane.showMessageDialog(table, "Column header #" + column + " is clicked.");
                    System.out.println("Column header #" + column + " is clicked.");
                    //for Loai Sach == testing
                    
                    ArrayList <String> header;
                    header = new ArrayList<String>(Arrays.asList(new QLPhieuNhapBUS(0).getHeaders()));
                    RowPopup rp = new RowPopup();
                    int headerType = new QLPhieuNhapBUS(0).findHeaderType(header.get(column));
                    if (headerType == 0){
                        rp.RowPopup_forHeader_STRING(header.get(column), "PhieuNhap");
                    }
                    else if (headerType == 1){
                        rp.RowPopup_forHeader_NUMBER(header.get(column), "PhieuNhap");
                    }
                    rp.show(contentPanel, event.getX(), event.getY() + 40);
                }
            }
        });
        
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event){
                if(event.getClickCount()== 1 && SwingUtilities.isRightMouseButton(event)){ // Chuột Phải
                    JTable target = (JTable)event.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    //JOptionPane.showMessageDialog(null, table.getValueAt(row, column));
                    //System.out.println(table.getValueAt(row, column));
                    System.out.println(table.getValueAt(row, 0));           // Get Columns 0 (Mã Chính) nhưng bug khi đổi chỗ cột
                    //new PopupInRows(event, (String)table.getValueAt(row, 0), contentPanel);
                    
                    RowPopup rp = new RowPopup(){
                        @Override
                        public void viewActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xem Chi Tiết");
                        }
                        @Override
                        public void editActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Sửa");
//                            new SuaLoaiSachForm(pKey).setVisible(true);
                        }
                        @Override
                        public void deleteActionPerformed(String pKey, ActionEvent e){
                            //JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xóa");
//                            AlertGUI xacnhan = new AlertGUI(0, "Xóa Loại Sách", "Bạn có muốn xóa loại sách " + pKey + "không?", "Đồng Ý", "Quay Lại"){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
                            //xacnhan.setVisible(true);
                            //new AlertGUI(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại").setVisible(true);
                            
//                            AlertGUI xacnhan = new AlertGUI(){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
//                            xacnhan.setProperties(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại");
//                            xacnhan.setVisible(true);
                            int option = JOptionPane.showConfirmDialog(
                                        null, 
                                        "Bạn có muốn xóa " + pKey + " ?", 
                                        "Xóa Phiếu Nhập", 
                                        JOptionPane.YES_NO_OPTION);
                            if(option == JOptionPane.YES_OPTION){
                                if (new QLPhieuNhapBUS(0).del(pKey)){
                                    System.out.println("Xóa " + pKey + " thành công");
                                    new AlertGUI(3, "Xóa Phiếu Nhập", "Xóa Phiếu Nhập " + pKey + " Thành Công", "Quay Lại").setVisible(true);
                                }
                                else{
                                    System.out.println("Xóa " + pKey + " thất bại");
                                    new AlertGUI(1, "Xóa Phiếu Nhập", "Xóa Phiếu Nhập " + pKey + "Thất Bại", "Quay Lại").setVisible(true);
                                }
                            }
                        }
                    };
                    rp.RowPopup_forRow((String)table.getValueAt(row, 0));
                    rp.show(contentPanel, event.getX(), event.getY() + 70);
                }
            }
        });
    }
    
    public void getClickEvent_PhieuPhat(){
        // Click event
        JTableHeader header = table.getTableHeader();
        //header.addMouseListener(new TableHeaderMouseListener(table));
        
        header.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent event){
                if (SwingUtilities.isRightMouseButton(event)){ // Right Click
                    Point point = event.getPoint();
                    int column = table.columnAtPoint(point);

                    //JOptionPane.showMessageDialog(table, "Column header #" + column + " is clicked.");
                    System.out.println("Column header #" + column + " is clicked.");
                    //for Loai Sach == testing
                    
                    ArrayList <String> header;
                    header = new ArrayList<String>(Arrays.asList(new QLPhieuPhatBUS(0).getHeaders()));
                    RowPopup rp = new RowPopup();
                    int headerType = new QLPhieuPhatBUS(0).findHeaderType(header.get(column));
                    if (headerType == 0){
                        rp.RowPopup_forHeader_STRING(header.get(column), "PhieuPhat");
                    }
                    else if (headerType == 1){
                        rp.RowPopup_forHeader_NUMBER(header.get(column), "PhieuPhat");
                    }
                    rp.show(contentPanel, event.getX(), event.getY() + 40);
                }
            }
        });
        
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event){
                if(event.getClickCount()== 1 && SwingUtilities.isRightMouseButton(event)){ // Chuột Phải
                    JTable target = (JTable)event.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    //JOptionPane.showMessageDialog(null, table.getValueAt(row, column));
                    //System.out.println(table.getValueAt(row, column));
                    System.out.println(table.getValueAt(row, 0));           // Get Columns 0 (Mã Chính) nhưng bug khi đổi chỗ cột
                    //new PopupInRows(event, (String)table.getValueAt(row, 0), contentPanel);
                    
                    RowPopup rp = new RowPopup(){
                        @Override
                        public void viewActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xem Chi Tiết");
                        }
                        @Override
                        public void editActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Sửa");
                            new SuaPhieuPhatForm(pKey).setVisible(true);
                        }
                        @Override
                        public void deleteActionPerformed(String pKey, ActionEvent e){
                            //JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xóa");
//                            AlertGUI xacnhan = new AlertGUI(0, "Xóa Loại Sách", "Bạn có muốn xóa loại sách " + pKey + "không?", "Đồng Ý", "Quay Lại"){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
                            //xacnhan.setVisible(true);
                            //new AlertGUI(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại").setVisible(true);
                            
//                            AlertGUI xacnhan = new AlertGUI(){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
//                            xacnhan.setProperties(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại");
//                            xacnhan.setVisible(true);
                            int option = JOptionPane.showConfirmDialog(
                                        null, 
                                        "Bạn có muốn xóa " + pKey + " ?", 
                                        "Xóa Phiếu Phạt", 
                                        JOptionPane.YES_NO_OPTION);
                            if(option == JOptionPane.YES_OPTION){
                                if (new QLLoaiSachBUS(0).del(pKey)){
                                    System.out.println("Xóa " + pKey + " thành công");
                                    new AlertGUI(3, "Xóa Phiếu Phạt", "Xóa Phiếu Phạt " + pKey + " Thành Công", "Quay Lại").setVisible(true);
                                }
                                else{
                                    System.out.println("Xóa " + pKey + " thất bại");
                                    new AlertGUI(1, "Xóa Phiếu Phạt", "Xóa Phiếu Phạt " + pKey + "Thất Bại", "Quay Lại").setVisible(true);
                                }
                            }
                        }
                    };
                    rp.RowPopup_forRow((String)table.getValueAt(row, 0));
                    rp.show(contentPanel, event.getX(), event.getY() + 70);
                }
            }
        });
    }
    
    public void getClickEvent_LDPhat(){
        // Click event
        JTableHeader header = table.getTableHeader();
        //header.addMouseListener(new TableHeaderMouseListener(table));
        
        header.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent event){
                if (SwingUtilities.isRightMouseButton(event)){ // Right Click
                    Point point = event.getPoint();
                    int column = table.columnAtPoint(point);

                    //JOptionPane.showMessageDialog(table, "Column header #" + column + " is clicked.");
                    System.out.println("Column header #" + column + " is clicked.");
                    //for Loai Sach == testing
                    
                    ArrayList <String> header;
                    header = new ArrayList<String>(Arrays.asList(new QLLDPhatBUS(0).getHeaders()));
                    RowPopup rp = new RowPopup();
                    int headerType = new QLLDPhatBUS(0).findHeaderType(header.get(column));
                    if (headerType == 0){
                        rp.RowPopup_forHeader_STRING(header.get(column), "LDPhat");
                    }
                    else if (headerType == 1){
                        rp.RowPopup_forHeader_NUMBER(header.get(column), "LDPhat");
                    }
                    rp.show(contentPanel, event.getX(), event.getY() + 40);
                }
            }
        });
        
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event){
                if(event.getClickCount()== 1 && SwingUtilities.isRightMouseButton(event)){ // Chuột Phải
                    JTable target = (JTable)event.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    //JOptionPane.showMessageDialog(null, table.getValueAt(row, column));
                    //System.out.println(table.getValueAt(row, column));
                    System.out.println(table.getValueAt(row, 0));           // Get Columns 0 (Mã Chính) nhưng bug khi đổi chỗ cột
                    //new PopupInRows(event, (String)table.getValueAt(row, 0), contentPanel);
                    
                    RowPopup rp = new RowPopup(){
                        @Override
                        public void viewActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xem Chi Tiết");
                        }
                        @Override
                        public void editActionPerformed(String pKey, ActionEvent e){
                            JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Sửa");
                            new SuaLDPForm(pKey).setVisible(true);
                        }
                        @Override
                        public void deleteActionPerformed(String pKey, ActionEvent e){
                            //JOptionPane.showMessageDialog(null, "Loai Sach" + pKey + " Xóa");
//                            AlertGUI xacnhan = new AlertGUI(0, "Xóa Loại Sách", "Bạn có muốn xóa loại sách " + pKey + "không?", "Đồng Ý", "Quay Lại"){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
                            //xacnhan.setVisible(true);
                            //new AlertGUI(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại").setVisible(true);
                            
//                            AlertGUI xacnhan = new AlertGUI(){
//                                private void dongy_btnMouseClicked(java.awt.event.MouseEvent evt) {                                       
//                                    System.out.println("Đồng ý");
//                                    System.exit(0);
//                                }     
//                            };
//                            xacnhan.setProperties(0, "Xóa Loai Sách", "Xóa loại sách " + pKey + "?", "Đồng Ý", "Quay Lại");
//                            xacnhan.setVisible(true);
                            int option = JOptionPane.showConfirmDialog(
                                        null, 
                                        "Bạn có muốn xóa " + pKey + " ?", 
                                        "Xóa Lý Do Phạt", 
                                        JOptionPane.YES_NO_OPTION);
                            if(option == JOptionPane.YES_OPTION){
                                if (new QLLDPhatBUS(0).del(pKey)){
                                    System.out.println("Xóa " + pKey + " thành công");
                                    new AlertGUI(3, "Xóa Lý Do Phạt", "Xóa Lý Do Phạt " + pKey + " Thành Công", "Quay Lại").setVisible(true);
                                }
                                else{
                                    System.out.println("Xóa " + pKey + " thất bại");
                                    new AlertGUI(1, "Xóa Lý Do Phạt", "Xóa Lý Do Phạt " + pKey + "Thất Bại", "Quay Lại").setVisible(true);
                                }
                            }
                        }
                    };
                    rp.RowPopup_forRow((String)table.getValueAt(row, 0));
                    rp.show(contentPanel, event.getX(), event.getY() + 70);
                }
            }
        });
    }
    
    public static <T> PaginatedTableDecorator<T> decorate(JTable table,
                                                          PaginationDataProvider<T> dataProvider,
                                                          int[] pageSizes, int defaultPageSize) {
        PaginatedTableDecorator<T> decorator = new PaginatedTableDecorator<>(table, dataProvider,
                pageSizes, defaultPageSize);
        decorator.init();
        return decorator;
    }
    
    public static <T> PaginatedTableDecorator<T> decorate(JTable table,
                                                          PaginationDataProvider<T> dataProvider,
                                                          int[] pageSizes, int defaultPageSize, ArrayList <Integer> widthColumns) {
        PaginatedTableDecorator<T> decorator = new PaginatedTableDecorator<>(table, dataProvider,
                pageSizes, defaultPageSize, widthColumns);
        decorator.init();
        return decorator;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    private void init() {
        initDataModel();
        initPaginationComponents();
        initListeners();
        paginate();
    }

    private void initListeners() {
        objectTableModel.addTableModelListener(this::refreshPageButtonPanel);
        if (table.getRowSorter() != null) {
            table.getRowSorter().addRowSorterListener(new RowSorterListener() {
                @Override
                public void sorterChanged(RowSorterEvent e) {
                    if(e.getType()== RowSorterEvent.Type.SORT_ORDER_CHANGED) {
                        currentPage = 1;
                        paginate();
                    }
                }
            });
        }
    }

    private void initDataModel() {
        TableModel model = table.getModel();
        if (!(model instanceof ObjectTableModel)) {
            throw new IllegalArgumentException("TableModel must be a subclass of ObjectTableModel");
        }
        objectTableModel = (ObjectTableModel) model;
    }

    private void initPaginationComponents() {
        contentPanel = new JPanel(new BorderLayout());
        JPanel paginationPanel = createPaginationPanel();
        
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        contentPanel.add(paginationPanel, BorderLayout.NORTH);
        contentPanel.add(new JScrollPane(table));
        
        contentPanel.add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private JPanel createPaginationPanel() {
        JPanel paginationPanel = new JPanel();
        pageLinkPanel = new JPanel(new GridLayout(1, MaxPagingCompToShow, 3, 3));
        paginationPanel.add(pageLinkPanel);

        if (pageSizes != null) {
            JComboBox<Integer> pageComboBox = new JComboBox<>(
                    Arrays.stream(pageSizes).boxed()
                          .toArray(Integer[]::new));
            pageComboBox.addActionListener((ActionEvent e) -> {
                //to preserve current rows position
                int currentPageStartRow = ((currentPage - 1) * currentPageSize) + 1;
                currentPageSize = (Integer) pageComboBox.getSelectedItem();
                currentPage = ((currentPageStartRow - 1) / currentPageSize) + 1;
                paginate();
            });
            
            /**/
            pageComboBox.setBackground(new Color(249, 249, 249)); // Màu của Page Size
            //pageComboBox.setSize(100, 100);
            pageLinkPanel.setBackground(new Color(249, 249, 249));
            paginationPanel.setBackground(new Color(249, 249, 249));
            /**/
            paginationPanel.add(Box.createHorizontalStrut(15));
            paginationPanel.add(new JLabel("Page Size: "));
            paginationPanel.add(pageComboBox);
            pageComboBox.setSelectedItem(currentPageSize);
        }
        return paginationPanel;
    }

    private void refreshPageButtonPanel(TableModelEvent tme) {
        pageLinkPanel.removeAll();
        int totalRows = dataProvider.getTotalRowCount();
        int pages = (int) Math.ceil((double) totalRows / currentPageSize);
        ButtonGroup buttonGroup = new ButtonGroup();
        if (pages > MaxPagingCompToShow) {
            addPageButton(pageLinkPanel, buttonGroup, 1);
            if (currentPage > (pages - ((MaxPagingCompToShow + 1) / 2))) {
                //case: 1 ... n->lastPage
                pageLinkPanel.add(createEllipsesComponent());
                addPageButtonRange(pageLinkPanel, buttonGroup, pages - MaxPagingCompToShow + 3, pages);
            } else if (currentPage <= (MaxPagingCompToShow + 1) / 2) {
                //case: 1->n ...lastPage
                addPageButtonRange(pageLinkPanel, buttonGroup, 2, MaxPagingCompToShow - 2);
                pageLinkPanel.add(createEllipsesComponent());
                addPageButton(pageLinkPanel, buttonGroup, pages);
            } else {//case: 1 .. x->n .. lastPage
                pageLinkPanel.add(createEllipsesComponent());//first ellipses
                //currentPage is approx mid point among total max-4 center links
                int start = currentPage - (MaxPagingCompToShow - 4) / 2;
                int end = start + MaxPagingCompToShow - 5;
                addPageButtonRange(pageLinkPanel, buttonGroup, start, end);
                pageLinkPanel.add(createEllipsesComponent());//last ellipsis
                addPageButton(pageLinkPanel, buttonGroup, pages);//last page link
            }
        } else {
            addPageButtonRange(pageLinkPanel, buttonGroup, 1, pages);
        }
        pageLinkPanel.getParent().validate();
        pageLinkPanel.getParent().repaint();
    }

    private Component createEllipsesComponent() {
        return new JLabel(Ellipses, SwingConstants.CENTER);
    }

    private void addPageButtonRange(JPanel parentPanel, ButtonGroup buttonGroup, int start, int end) {
        for (; start <= end; start++) {
            addPageButton(parentPanel, buttonGroup, start);
        }
    }

    private void addPageButton(JPanel parentPanel, ButtonGroup buttonGroup, int pageNumber) {
        JToggleButton toggleButton = new JToggleButton(Integer.toString(pageNumber));
        toggleButton.setMargin(new Insets(1, 3, 1, 3));
        /**/
        toggleButton.setFont(new Font("consolas", Font.BOLD, 13));
        toggleButton.setForeground(new Color(91, 197, 187));
        toggleButton.setBackground(Color.white);
        /**/
        buttonGroup.add(toggleButton);
        parentPanel.add(toggleButton);
        if (pageNumber == currentPage) {
            toggleButton.setSelected(true);
        }
        toggleButton.addActionListener(ae -> {
            currentPage = Integer.parseInt(ae.getActionCommand());
            paginate();
        });
    }

    private void paginate() {
        int startIndex = (currentPage - 1) * currentPageSize;
        int endIndex = startIndex + currentPageSize;
        if (endIndex > dataProvider.getTotalRowCount()) {
            endIndex = dataProvider.getTotalRowCount();
        }

        int sortColumn = -1;
        boolean sortDescending = false;
        RowSorter<? extends TableModel> rowSorter = table.getRowSorter();
        if (rowSorter != null) {
            for (RowSorter.SortKey sortKey : rowSorter.getSortKeys()) {
                if (sortKey.getSortOrder() != SortOrder.UNSORTED) {
                    sortColumn = sortKey.getColumn();
                    sortDescending = sortKey.getSortOrder() == SortOrder.DESCENDING;
                    break;

                }
            }
        }
        List<T> rows = dataProvider.getRows(startIndex, endIndex, sortColumn, sortDescending);
        objectTableModel.setObjectRows(rows);
        objectTableModel.fireTableDataChanged();
    }
}
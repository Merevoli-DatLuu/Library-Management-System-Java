package librarymanagementsystem.GUI.Table;

import java.awt.event.*;
import javax.swing.*;

public class PopupInRows{
    //private JTable table;
            
    public PopupInRows(MouseEvent event, String pKey, JPanel p){
        RowPopup rp = new RowPopup();
        rp.RowPopup_forRow(pKey);
        rp.show(p, event.getX(), event.getY());
    }
    
    class RowPopup extends JPopupMenu {
        public RowPopup(){
            
        }
        public RowPopup(String pKey){
            JMenuItem view = new JMenuItem("Xem Chi Tiết");
            JMenuItem edit = new JMenuItem("Sửa");
            JMenuItem delete = new JMenuItem("Xóa");
            
            view.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    JOptionPane.showMessageDialog(view, pKey + " Xem Chi Tiết");
                }
            });
            
            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    JOptionPane.showMessageDialog(edit, pKey + " Sửa");
                }
            });
            
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    JOptionPane.showMessageDialog(delete, pKey + " Xóa");
                }
            });
            
            add(view);
            add(new JSeparator());
            add(edit);
            add(new JSeparator());
            add(delete);
        }
        
        public void RowPopup_forHeader_NUMBER(String pKey){
            JMenuItem equals = new JMenuItem("Equals");
            JMenuItem notEquals = new JMenuItem("Not Equals");
            JMenuItem greaterThan = new JMenuItem("Greater Than");
            JMenuItem greaterThanOrEqualsTo = new JMenuItem("Greater Than Or Equals To");
            JMenuItem lessThan = new JMenuItem("Less Than");
            JMenuItem lessThanOrEqualsTo = new JMenuItem("Less Than Or Equals To");
            
            equals.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    equalsActionPerformed(pKey, e);
                }
            });
            
            notEquals.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    notEqualsActionPerformed(pKey, e);
                }
            });
            
            greaterThan.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    greaterThanActionPerformed(pKey, e);
                }
            });
            
            greaterThanOrEqualsTo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    greaterThanOrEqualsToActionPerformed(pKey, e);
                }
            });
            
            lessThan.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lessThanActionPerformed(pKey, e);
                }
            });
            
            lessThanOrEqualsTo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lessThanOrEqualsToActionPerformed(pKey, e);
                }
            });
            
            add(equals);
            add(new JSeparator());
            add(notEquals);
            add(new JSeparator());
            add(greaterThan);
            add(new JSeparator());
            add(greaterThanOrEqualsTo);
            add(new JSeparator());
            add(lessThan);
            add(new JSeparator());
            add(lessThanOrEqualsTo);
        }
        
        public void RowPopup_forRow(String pKey){
            JMenuItem view = new JMenuItem("Xem Chi Tiết");
            JMenuItem edit = new JMenuItem("Sửa");
            JMenuItem delete = new JMenuItem("Xóa");
            
            view.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    viewActionPerformed(pKey, e);
                }
            });
            
            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    editActionPerformed(pKey, e);
                }
            });
            
            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    deleteActionPerformed(pKey, e);
                }
            });
            
            add(view);
            add(new JSeparator());
            add(edit);
            add(new JSeparator());
            add(delete);
        }
        
        public void viewActionPerformed(String pKey, ActionEvent e){
            JOptionPane.showMessageDialog(null, pKey + " Xem Chi Tiết");
        }
        
        public void editActionPerformed(String pKey, ActionEvent e){
            JOptionPane.showMessageDialog(null, pKey + " Sửa");
        }
        
        public void deleteActionPerformed(String pKey, ActionEvent e){
            JOptionPane.showMessageDialog(null, pKey + " Xóa");
        }
        
        public void equalsActionPerformed(String pKey, ActionEvent e){
            JOptionPane.showMessageDialog(null, pKey + " So Sánh Bằng");
        }
        
        public void notEqualsActionPerformed(String pKey, ActionEvent e){
            JOptionPane.showMessageDialog(null, pKey + " So Sánh Khác");
        }
        
        public void greaterThanActionPerformed(String pKey, ActionEvent e){
            JOptionPane.showMessageDialog(null, pKey + " So Sánh Lớn");
        }
        
        public void greaterThanOrEqualsToActionPerformed(String pKey, ActionEvent e){
            JOptionPane.showMessageDialog(null, pKey + " So Sánh Lớn Bằng");
        }
        
        public void lessThanActionPerformed(String pKey, ActionEvent e){
            JOptionPane.showMessageDialog(null, pKey + " So Sánh Bé");
        }
        
        public void lessThanOrEqualsToActionPerformed(String pKey, ActionEvent e){
            JOptionPane.showMessageDialog(null, pKey + " So Sánh Bé Bằng");
        }
    }
}

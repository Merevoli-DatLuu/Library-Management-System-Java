package librarymanagementsystem.GUI.Table;


import java.awt.event.*;
import javax.swing.*;
import librarymanagementsystem.GUI.ChonGUI.*;

public class RowPopup extends JPopupMenu {
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

    public void RowPopup_forHeader(String pKey){
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
    
    public void RowPopup_forHeader_NUMBER(String header, String tableName){
        JMenuItem equals = new JMenuItem("Equals");
        JMenuItem notEquals = new JMenuItem("Not Equals");
        JMenuItem greaterThan = new JMenuItem("Greater Than");
        JMenuItem greaterThanOrEqualsTo = new JMenuItem("Greater Than Or Equals To");
        JMenuItem lessThan = new JMenuItem("Less Than");
        JMenuItem lessThanOrEqualsTo = new JMenuItem("Less Than Or Equals To");

        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equalsActionPerformed_NUMBER(header, tableName, e);
            }
        });

        notEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notEqualsActionPerformed_NUMBER(header, tableName,  e);
            }
        });

        greaterThan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                greaterThanActionPerformed_NUMBER(header, tableName,  e);
            }
        });

        greaterThanOrEqualsTo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                greaterThanOrEqualsToActionPerformed_NUMBER(header, tableName,  e);
            }
        });

        lessThan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lessThanActionPerformed_NUMBER(header, tableName,  e);
            }
        });

        lessThanOrEqualsTo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lessThanOrEqualsToActionPerformed_NUMBER(header, tableName,  e);
            }
        });

        add(equals);
        add(new JSeparator());
        add(notEquals);
        add(new JSeparator());
        add(new JSeparator());
        add(greaterThan);
        add(new JSeparator());
        add(greaterThanOrEqualsTo);
        add(new JSeparator());
        add(lessThan);
        add(new JSeparator());
        add(lessThanOrEqualsTo);
    }
    
    public void RowPopup_forHeader_STRING(String header, String tableName){
        JMenuItem equals = new JMenuItem("Equals");
        JMenuItem notEquals = new JMenuItem("Not Equals");
        JMenuItem contains = new JMenuItem("Contains");
        JMenuItem doesNotContain = new JMenuItem("Does not Contain");
        JMenuItem beginsWith = new JMenuItem("Begins With");
        JMenuItem endsWith = new JMenuItem("Ends With");

        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equalsActionPerformed_STRING(header, tableName, e);
            }
        });

        notEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notEqualsActionPerformed_STRING(header, tableName, e);
            }
        });

        contains.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                containsActionPerformed_STRING(header, tableName, e);
            }
        });

        doesNotContain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doesNotContainActionPerformed_STRING(header, tableName, e);
            }
        });

        beginsWith.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                beginsWithActionPerformed_STRING(header, tableName, e);
            }
        });

        endsWith.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endsWithActionPerformed_STRING(header, tableName, e);
            }
        });

        add(equals);
        add(new JSeparator());
        add(notEquals);
        add(new JSeparator());
        add(new JSeparator());
        add(beginsWith);
        add(new JSeparator());
        add(endsWith);
        add(new JSeparator());
        add(new JSeparator());
        add(contains);
        add(new JSeparator());
        add(doesNotContain);
    }
    
    
    public void RowPopup_forHeader_DATE(String header, String tableName){
        JMenuItem equals = new JMenuItem("Equals");
        JMenuItem notEquals = new JMenuItem("Not Equals");
        JMenuItem contains = new JMenuItem("After");
        JMenuItem doesNotContain = new JMenuItem("Before");
        JMenuItem beginsWith = new JMenuItem("Not After");
        JMenuItem endsWith = new JMenuItem("Not Before");

        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equalsActionPerformed_STRING(header, tableName, e);
            }
        });

        notEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notEqualsActionPerformed_STRING(header, tableName, e);
            }
        });

        contains.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                containsActionPerformed_STRING(header, tableName, e);
            }
        });

        doesNotContain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doesNotContainActionPerformed_STRING(header, tableName, e);
            }
        });

        beginsWith.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                beginsWithActionPerformed_STRING(header, tableName, e);
            }
        });

        endsWith.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endsWithActionPerformed_STRING(header, tableName, e);
            }
        });

        add(equals);
        add(new JSeparator());
        add(notEquals);
        add(new JSeparator());
        add(new JSeparator());
        add(beginsWith);
        add(new JSeparator());
        add(endsWith);
        add(new JSeparator());
        add(new JSeparator());
        add(contains);
        add(new JSeparator());
        add(doesNotContain);
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
    
    public void equalsActionPerformed_NUMBER(String header, String tableName, ActionEvent e){
        //JOptionPane.showMessageDialog(null, pKey + " So Sánh Bằng");
        Filter flt = new Filter("Equals");
        flt.setMode("NUMBER");
        flt.setHeader(header);
        flt.setTableName(tableName);
        flt.setVisible(true);
//        flt.addWindowListener(new WindowAdapter(){
//            public void windowClosed(WindowEvent windowEvent){
//	        System.out.println("tesing");
//                
//                System.out.println(flt.get_choice_1());
//                System.out.println(flt.get_choice_2());
//                System.out.println(flt.get_value_1());
//                System.out.println(flt.get_value_2());
//                System.out.println(flt.get_andor());
//                
//            }  
//        });
    }

    public void notEqualsActionPerformed_NUMBER(String header, String tableName, ActionEvent e){
        //JOptionPane.showMessageDialog(null, pKey + " So Sánh Khác");
//        new Filter("Not Equals").setVisible(true);
        Filter flt = new Filter("Not Equals");
        flt.setMode("NUMBER");
        flt.setHeader(header);
        flt.setTableName(tableName);
        flt.setVisible(true);
    }

    public void greaterThanActionPerformed_NUMBER(String header, String tableName, ActionEvent e){
        //JOptionPane.showMessageDialog(null, pKey + " So Sánh Lớn");
//        new Filter("Greater Than").setVisible(true);
        Filter flt = new Filter("Greater Than");
        flt.setMode("NUMBER");
        flt.setHeader(header);
        flt.setTableName(tableName);
        flt.setVisible(true);
    }

    public void greaterThanOrEqualsToActionPerformed_NUMBER(String header, String tableName, ActionEvent e){
        //JOptionPane.showMessageDialog(null, pKey + " So Sánh Lớn Bằng");
//        new Filter("Greater Than Or Equals To").setVisible(true);
        Filter flt = new Filter("Greater Than Or Equals To");
        flt.setMode("NUMBER");
        flt.setHeader(header);
        flt.setTableName(tableName);
        flt.setVisible(true);
    }

    public void lessThanActionPerformed_NUMBER(String header, String tableName, ActionEvent e){
        //JOptionPane.showMessageDialog(null, pKey + " So Sánh Bé");
//        new Filter("Less Than").setVisible(true);
        Filter flt = new Filter("Less Than");
        flt.setMode("NUMBER");
        flt.setHeader(header);
        flt.setTableName(tableName);
        flt.setVisible(true);
    }

    public void lessThanOrEqualsToActionPerformed_NUMBER(String header, String tableName, ActionEvent e){
        //JOptionPane.showMessageDialog(null, pKey + " So Sánh Bé Bằng");
//        new Filter("Less Than Or Equals To").setVisible(true);
        Filter flt = new Filter("Less Than Or Equals To");
        flt.setMode("NUMBER");
        flt.setHeader(header);
        flt.setTableName(tableName);
        flt.setVisible(true);
    }
    
    public void equalsActionPerformed_STRING(String header, String tableName, ActionEvent e){
        Filter flt = new Filter("Equails");
        flt.setMode("STRING");
        flt.setHeader(header);
        flt.setTableName(tableName);
        flt.setVisible(true);
    }
    
    public void notEqualsActionPerformed_STRING(String header, String tableName, ActionEvent e){
        Filter flt = new Filter("Not Equals");
        System.out.println("choice Not Equals");
        flt.setMode("STRING");
        flt.setHeader(header);
        flt.setTableName(tableName);
        flt.setVisible(true);
    }
    
    public void containsActionPerformed_STRING(String header, String tableName, ActionEvent e){
        Filter flt = new Filter("Contains");
        flt.setMode("STRING");
        flt.setHeader(header);
        flt.setTableName(tableName);
        flt.setVisible(true);
    }
    
    public void doesNotContainActionPerformed_STRING(String header, String tableName, ActionEvent e){
        Filter flt = new Filter("Does not Contain");
        flt.setMode("STRING");
        flt.setHeader(header);
        flt.setTableName(tableName);
        flt.setVisible(true);
    }
    
    public void beginsWithActionPerformed_STRING(String header, String tableName, ActionEvent e){
        Filter flt = new Filter("Begins With");
        flt.setMode("STRING");
        flt.setHeader(header);
        flt.setTableName(tableName);
        flt.setVisible(true);
    }
    
    public void endsWithActionPerformed_STRING(String header, String tableName, ActionEvent e){
        Filter flt = new Filter("Ends With");
        flt.setMode("STRING");
        flt.setHeader(header);
        flt.setTableName(tableName);
        flt.setVisible(true);
    }
}

package librarymanagementsystem.GUI.ThanhPhanGUI;

import librarymanagementsystem.BUS.QLLoaiSachBUS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.*;
import java.util.*;
import org.jfree.ui.about.AboutPanel;

public class ComboCheckBox extends JFrame{
    public static Vector <JCheckBox> headers;
    public static ArrayList<String> headers_checked;
    public static CustomComboCheck combobox;
    
    // Constructor without refresh
    public ComboCheckBox(){
        
    }
    
    public ComboCheckBox(ArrayList <String> header_name){
        setTitle("");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new FlowLayout());
        
        /** init Headers **/
        headers = new Vector<>();
        
        for (String e : header_name){
            headers.add(new JCheckBox(e, true));
        }

        /** init ComboBox **/
        combobox = new CustomComboCheck(headers);
        //combobox.getModel().setSelectedItem("");
        getContentPane().add(combobox);
       
        /** init Checked Header **/
        headers_checked = new ArrayList<String>();
        
        for (int i=0; i<headers.size(); i++){
            JCheckBox jcb = (JCheckBox)combobox.getModel().getElementAt(i);
            if (jcb.isSelected()){
                headers_checked.add(headers.get(i).getText());
            }
        }
    }

    public JPanel getCombobox() {
        JPanel p = new JPanel();
        p.add(combobox);
//        p.setSize(combobox.size().width, combobox.size().height);
        return p;
    }
    
    public void printChecked(){
        headers_checked = new ArrayList<>();
        
        for (int i=0; i<headers.size(); i++){
            JCheckBox jcb = (JCheckBox)combobox.getModel().getElementAt(i);
            if (jcb.isSelected()){
                headers_checked.add(headers.get(i).getText());
            }
        }
        
        for (String e : headers_checked){
            System.out.println(e);
        }
        System.out.println();
    }
    
    public ArrayList <String> getChecked(){
        headers_checked = new ArrayList<>();
        
        for (int i=0; i<headers.size(); i++){
            JCheckBox jcb = (JCheckBox)combobox.getModel().getElementAt(i);
            if (jcb.isSelected()){
                headers_checked.add(headers.get(i).getText());
            }
        }
        
        return headers_checked;
    }
    
    
//    public void hidePop(){
//        combobox.hidePop();
//    }
        
    public static void main(String[] args){
        ArrayList <String> header_name = new ArrayList<String>(Arrays.asList(new QLLoaiSachBUS().getHeaders()));
        ComboCheckBox cb = new ComboCheckBox(header_name);
        cb.setSize(350, 500);
        cb.setVisible(true);
    }
}

class CustomComboCheck extends JComboBox{ 
    
//    public void setPopupVisible(boolean v) {
//        getUI().setPopupVisible(this, true);
//    }
    
//    public void hidePop(){
//        getUI().setPopupVisible(this, false);
//    }
    
    public CustomComboCheck(Vector v){
        super(v);
        
        setRenderer(new Comborenderer());
        
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.   
                ourItemSelected();
                setPopupVisible(true);
                getModel().setSelectedItem("");
                new ComboCheckBox().printChecked();
            }
        });
        
    }

    
    private void ourItemSelected(){
        Object selected = getSelectedItem();
        
        if(selected instanceof JCheckBox){
            JCheckBox chk = (JCheckBox) selected;
            chk.setSelected(!chk.isSelected());
            repaint();
            
            Object[] selections = chk.getSelectedObjects();
            
            if(selections != null){
                for(Object lastItem : selections){
                    //JOptionPane.showMessageDialog(null, lastItem.toString());
                    //System.out.println(" Is checked: " + selections);
                }
            }
        }
    }
}

class Comborenderer extends JCheckBox implements ListCellRenderer{
    private JLabel label;
    
    public Component getListCellRendererComponent(JList list, Object val, int index, boolean  selected, boolean focused){
        if(val instanceof Component){
            Component c = (Component) val;
            
            if(selected){
                c.setBackground(list.getSelectionBackground());
                c.setForeground(list.getSelectionForeground());
            }
            else{
                c.setBackground(list.getBackground());
                c.setBackground(list.getBackground());
            }
            return c;
        }
        else{
            if(label == null){
                label = new JLabel(val.toString());
            }
            else{
                label.setText(val.toString());
            }
            return label;
        }
        //return null;
    }
}

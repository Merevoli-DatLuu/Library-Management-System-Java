package librarymanagementsystem.GUI.HienThiGUI;


import java.awt.Color;
import javax.swing.JPanel;

public class dashboardCard_2 {
    String title, value, image;
    public dashboardCard_2() {
        title = "SÁCH";
        value = "120";
        image = "../../images/output-onlinepngtools (85).png";
    }
    
    public dashboardCard_2(String title, String value, String image) {
        this.title = title;
        this.value = value;
        this.image = image;
    }
    
    public void setProperties(String title, String value, String image){
        this.title = title;
        this.value = value;
        this.image = image;
    }

    public void setLocat(int x, int y){
        jPanel1.setBounds(x, y, 220, 134);
    }
                            
    public JPanel getdashboardCard() {

        jPanel1 = new javax.swing.JPanel();
        title_Label = new javax.swing.JLabel();
        icon_Label = new javax.swing.JLabel();
        value_Label = new javax.swing.JLabel();
        statCard_Label = new javax.swing.JLabel();

        jPanel1.setLayout(null);

        title_Label.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        title_Label.setForeground(new java.awt.Color(127, 127, 127));
        title_Label.setText(title);
        title_Label.setLocation(60 + (13 - title.length())*4, 135);
        title_Label.setSize(200, 17);
        jPanel1.add(title_Label);

        icon_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource(image))); // NOI18N
        icon_Label.setBounds(75, 15, 75, 75);
        jPanel1.add(icon_Label);

        value_Label.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        value_Label.setText(value);
        value_Label.setBounds(96 + (2 - value.length())*10, 103, 200, 29);
        jPanel1.add(value_Label);

        statCard_Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("../../images/output-onlinepngtools - 2020-06-05T081424.684.png"))); // NOI18N
        statCard_Label.setBounds(0, 0, 220, 184);
        jPanel1.add(statCard_Label);
        jPanel1.setBounds(0, 0, 220, 184);
        jPanel1.setBackground(new Color(0, 0, 0, 0));
        
        return jPanel1;
    }                    

    // Variables declaration - do not modify                     
    private javax.swing.JLabel icon_Label;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel statCard_Label;
    private javax.swing.JLabel title_Label;
    private javax.swing.JLabel value_Label;
    // End of variables declaration         
}

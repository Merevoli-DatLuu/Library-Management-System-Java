package librarymanagementsystem.GUI.ChonGUI;

import librarymanagementsystem.BUS.*;
import librarymanagementsystem.DTO.*;
import librarymanagementsystem.GUI.ModuleGUI.*;
import librarymanagementsystem.Toolkit.DataProcessing;

import java.util.ArrayList;

public class Filter extends javax.swing.JFrame {
    String header; // Filter theo header
    String tableName; // table name
    String choice;
    String choiceType;
    
    public Filter(String choice) {
        this.choice = choice;
        initComponents(choice);
        setSize(480, 280);
        setLocationRelativeTo(null);
    }
    
    public Filter(String choice, String tableName, String header) {
        this.choice = choice;
        this.header = header;
        this.tableName = tableName;
        initComponents(choice);
        setSize(480, 280);
        setLocationRelativeTo(null);
    }
    
    public void setHeader(String header){
        this.header = header;
    }
    
    public void setTableName(String tableName){
        this.tableName = tableName;
    }
    
    // STRING NUMBER DATE
    public void setMode(String mode){
        if (mode.equals("NUMBER")){
            choice_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Equals", "Not Equals", "Greater Than", "Greater Than Or Equals To", "Less Than", "Less Than Or Equals To" }));
            choice_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Equals", "Not Equals", "Greater Than", "Greater Than Or Equals To", "Less Than", "Less Than Or Equals To" }));
            choiceType = "NUMBER";
        }
        else if (mode.equals("STRING")){
            choice_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Equals", "Not Equals", "Contains", "Does not Contain", "Begins With", "Ends With" }));
            choice_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Equals", "Not Equals", "Contains", "Does not Contain", "Begins With", "Ends With" }));
            choiceType = "STRING";
        }
        else if (mode.equals("DATE")){
            choice_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Equals", "Not Equals", "Greater Than", "Greater Than Or Equals To", "Less Than", "Less Than Or Equals To" }));
            choice_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Equals", "Not Equals", "Greater Than", "Greater Than Or Equals To", "Less Than", "Less Than Or Equals To" }));
            choiceType = "DATE";
        }
        choice_1.setSelectedItem(choice);
    }
                        
    private void initComponents(String choice) {

        jPanel1 = new javax.swing.JPanel();
        tittle = new javax.swing.JLabel();
        choice_1 = new javax.swing.JComboBox<>();
        choice_2 = new javax.swing.JComboBox<>();
        textfield_1 = new javax.swing.JTextField();
        textfield_2 = new javax.swing.JTextField();
        andBtn = new javax.swing.JRadioButton();
        orBtn = new javax.swing.JRadioButton();
        line_1 = new javax.swing.JSeparator();
        line_2 = new javax.swing.JSeparator();
        quayluibtn = new javax.swing.JButton();
        dongybtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        tittle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tittle.setText("TÌM KIẾM NÂNG CAO");
        tittle.setBounds(49, 36, 152, 17);
        jPanel1.add(tittle);

        choice_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Equals", "Not Equals", "Greater Than", "Greater Than Or Equals To", "Less Than", "Less Than Or Equals To" }));
        choice_1.setBounds(50, 77, 155, 28);
        choice_1.setSelectedItem(choice);
        jPanel1.add(choice_1);

        choice_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Equals", "Not Equals", "Greater Than", "Greater Than Or Equals To", "Less Than", "Less Than Or Equals To" }));
        choice_2.setBounds(50, 146, 155, 28);
        jPanel1.add(choice_2);
        
        textfield_1.setBounds(268, 77, 183, 28);
        jPanel1.add(textfield_1);
        textfield_1.getAccessibleContext().setAccessibleName("");
        
        textfield_2.setBounds(268, 146, 183, 28);
        jPanel1.add(textfield_2);

        andBtn.setText("AND");
        andBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                andBtnMouseClicked(evt);
            }
        });
        andBtn.setBounds(62, 116, 60, 23);
        jPanel1.add(andBtn);

        orBtn.setText("OR");
        orBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orBtnMouseClicked(evt);
            }
        });
        orBtn.setBounds(127, 116, 60, 23);
        jPanel1.add(orBtn);
        line_1.setBounds(0, 45, 40, 4);
        line_2.setBounds(210, 45, 270, 4);
        jPanel1.add(line_1);
        jPanel1.add(line_2);

        quayluibtn.setText("Quay Lại");
        quayluibtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quayluibtnActionPerformed(evt);
            }
        });
        quayluibtn.setBounds(360, 195, 90, 30);
        jPanel1.add(quayluibtn);

        dongybtn.setText("Đồng Ý");
        dongybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dongybtnActionPerformed(evt);
            }
        });
        dongybtn.setBounds(270, 195, 80, 30);
        jPanel1.add(dongybtn);
        jPanel1.setBounds(0, 0, 480, 240);

        getContentPane().add(jPanel1);

        pack();
    }                      
    
    public void doFilter(String header, String tableName, FilterData fd){
        DataProcessing ps = new DataProcessing();
        if (fd.getandOr() == 0 && fd.hasChoice_1()){ // 1 choice
            switch (tableName){
                case "LoaiSach":
                    ArrayList <QLLoaiSachDTO> arr = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_1.equals("Equals")){
                            arr = new FilterFunction().filterBy_Equails_STRING_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Not Equals")){
                            arr = new FilterFunction().filterBy_NotEquails_STRING_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Contains")){
                            arr = new FilterFunction().filterBy_Contains_STRING_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Does not Contain")){
                            arr = new FilterFunction().filterBy_DoesNotContain_STRING_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Begins With")){
                            arr = new FilterFunction().filterBy_BeginsWith_STRING_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Ends With")){
                            arr = new FilterFunction().filterBy_EndsWith_STRING_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, fd.value_1);
                        }
                    }
                    else if (choiceType.equals("NUMBER")){
                        if (fd.choice_1.equals("Equals")){
                            arr = new FilterFunction().filterBy_Equails_NUMBER_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Not Equals")){
                            arr = new FilterFunction().filterBy_NotEquails_NUMBER_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Greater Than")){
                            arr = new FilterFunction().filterBy_GreaterThan_NUMBER_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Greater Than Or Equals To")){
                            arr = new FilterFunction().filterBy_GreaterThanOrEqualsTo_NUMBER_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Less Than")){
                            arr = new FilterFunction().filterBy_LessThan_NUMBER_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Less Than Or Equals To")){
                            arr = new FilterFunction().filterBy_LessThanOrEqualsTo_NUMBER_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, Integer.parseInt(fd.value_1));
                        }
                    }
                    new LoaiSachModule().paintTable(arr);
                    break;
                
                case "NhaCungCap":
                    ArrayList <QLNhaCungCapDTO> arr_nhacungcap = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_1.equals("Equals")){
                            arr_nhacungcap = new FilterFunction().filterBy_Equails_STRING_NhaCungCap(new QLNhaCungCapBUS(0).getArrNhaCungCap(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Not Equals")){
                            arr_nhacungcap = new FilterFunction().filterBy_NotEquails_STRING_NhaCungCap(new QLNhaCungCapBUS(0).getArrNhaCungCap(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Contains")){
                            arr_nhacungcap = new FilterFunction().filterBy_Contains_STRING_NhaCungCap(new QLNhaCungCapBUS(0).getArrNhaCungCap(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Does not Contain")){
                            arr_nhacungcap = new FilterFunction().filterBy_DoesNotContain_STRING_NhaCungCap(new QLNhaCungCapBUS(0).getArrNhaCungCap(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Begins With")){
                            arr_nhacungcap = new FilterFunction().filterBy_BeginsWith_STRING_NhaCungCap(new QLNhaCungCapBUS(0).getArrNhaCungCap(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Ends With")){
                            arr_nhacungcap = new FilterFunction().filterBy_EndsWith_STRING_NhaCungCap(new QLNhaCungCapBUS(0).getArrNhaCungCap(), header, fd.value_1);
                        }
                    }
                    
                    new NhaCungCapModule().paintTable(arr_nhacungcap);
                    break;
                
                case "The":
                    ArrayList <QLTheDTO> arr_the = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_1.equals("Equals")){
                            arr_the = new FilterFunction().filterBy_Equails_STRING_The(new QLTheBUS(0).getArrThe(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Not Equals")){
                            arr_the = new FilterFunction().filterBy_NotEquails_STRING_The(new QLTheBUS(0).getArrThe(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Contains")){
                            arr_the = new FilterFunction().filterBy_Contains_STRING_The(new QLTheBUS(0).getArrThe(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Does not Contain")){
                            arr_the = new FilterFunction().filterBy_DoesNotContain_STRING_The(new QLTheBUS(0).getArrThe(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Begins With")){
                            arr_the = new FilterFunction().filterBy_BeginsWith_STRING_The(new QLTheBUS(0).getArrThe(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Ends With")){
                            arr_the = new FilterFunction().filterBy_EndsWith_STRING_The(new QLTheBUS(0).getArrThe(), header, fd.value_1);
                        }
                    }
                    
                    new TheModule().paintTable(arr_the);
                    break;
                    
                case "NhanVien":
                    ArrayList <QLNhanVienDTO> arr_nhanvien = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_1.equals("Equals")){
                            arr_nhanvien = new FilterFunction().filterBy_Equails_STRING_NhanVien(new QLNhanVienBUS(0).getArrNhanVien(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Not Equals")){
                            arr_nhanvien = new FilterFunction().filterBy_NotEquails_STRING_NhanVien(new QLNhanVienBUS(0).getArrNhanVien(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Contains")){
                            arr_nhanvien = new FilterFunction().filterBy_Contains_STRING_NhanVien(new QLNhanVienBUS(0).getArrNhanVien(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Does not Contain")){
                            arr_nhanvien = new FilterFunction().filterBy_DoesNotContain_STRING_NhanVien(new QLNhanVienBUS(0).getArrNhanVien(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Begins With")){
                            arr_nhanvien = new FilterFunction().filterBy_BeginsWith_STRING_NhanVien(new QLNhanVienBUS(0).getArrNhanVien(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Ends With")){
                            arr_nhanvien = new FilterFunction().filterBy_EndsWith_STRING_NhanVien(new QLNhanVienBUS(0).getArrNhanVien(), header, fd.value_1);
                        }
                    }
                    
                    new NhanVienModule().paintTable(arr_nhanvien);
                    break;
                    
                case "SachThuVien":
                    ArrayList <QLChiTietSachDTO> arr_sachthuvien = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_1.equals("Equals")){
                            arr_sachthuvien = new FilterFunction().filterBy_Equails_STRING_SachThuVien(new QLChiTietSachBUS(0).getArrChiTietSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Not Equals")){
                            arr_sachthuvien = new FilterFunction().filterBy_NotEquails_STRING_SachThuVien(new QLChiTietSachBUS(0).getArrChiTietSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Contains")){
                            arr_sachthuvien = new FilterFunction().filterBy_Contains_STRING_SachThuVien(new QLChiTietSachBUS(0).getArrChiTietSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Does not Contain")){
                            arr_sachthuvien = new FilterFunction().filterBy_DoesNotContain_STRING_SachThuVien(new QLChiTietSachBUS(0).getArrChiTietSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Begins With")){
                            arr_sachthuvien = new FilterFunction().filterBy_BeginsWith_STRING_SachThuVien(new QLChiTietSachBUS(0).getArrChiTietSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Ends With")){
                            arr_sachthuvien = new FilterFunction().filterBy_EndsWith_STRING_SachThuVien(new QLChiTietSachBUS(0).getArrChiTietSach(), header, fd.value_1);
                        }
                    }
                    
                    new SachThuVienModule().paintTable(arr_sachthuvien);
                    break;
                    
                case "PhieuMuon":
                    ArrayList <QLPhieuMuonDTO> arr_phieumuon = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_1.equals("Equals")){
                            arr_phieumuon = new FilterFunction().filterBy_Equails_STRING_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Not Equals")){
                            arr_phieumuon = new FilterFunction().filterBy_NotEquails_STRING_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Contains")){
                            arr_phieumuon = new FilterFunction().filterBy_Contains_STRING_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Does not Contain")){
                            arr_phieumuon = new FilterFunction().filterBy_DoesNotContain_STRING_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Begins With")){
                            arr_phieumuon = new FilterFunction().filterBy_BeginsWith_STRING_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Ends With")){
                            arr_phieumuon = new FilterFunction().filterBy_EndsWith_STRING_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, fd.value_1);
                        }
                    }
                    else if (choiceType.equals("NUMBER")){
                        if (fd.choice_1.equals("Equals")){
                            arr_phieumuon = new FilterFunction().filterBy_Equails_NUMBER_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Not Equals")){
                            arr_phieumuon = new FilterFunction().filterBy_NotEquails_NUMBER_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Greater Than")){
                            arr_phieumuon = new FilterFunction().filterBy_GreaterThan_NUMBER_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Greater Than Or Equals To")){
                            arr_phieumuon = new FilterFunction().filterBy_GreaterThanOrEqualsTo_NUMBER_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Less Than")){
                            arr_phieumuon = new FilterFunction().filterBy_LessThan_NUMBER_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Less Than Or Equals To")){
                            arr_phieumuon = new FilterFunction().filterBy_LessThanOrEqualsTo_NUMBER_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, Integer.parseInt(fd.value_1));
                        }
                    }
                    new PhieuMuonModule().paintTable(arr_phieumuon);
                    break;
                    
                case "KhoSach":
                    ArrayList <QLKhoSachDTO> arr_khosach = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_1.equals("Equals")){
                            arr_khosach = new FilterFunction().filterBy_Equails_STRING_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Not Equals")){
                            arr_khosach = new FilterFunction().filterBy_NotEquails_STRING_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Contains")){
                            arr_khosach = new FilterFunction().filterBy_Contains_STRING_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Does not Contain")){
                            arr_khosach = new FilterFunction().filterBy_DoesNotContain_STRING_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Begins With")){
                            arr_khosach = new FilterFunction().filterBy_BeginsWith_STRING_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Ends With")){
                            arr_khosach = new FilterFunction().filterBy_EndsWith_STRING_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, fd.value_1);
                        }
                    }
                    else if (choiceType.equals("NUMBER")){
                        if (fd.choice_1.equals("Equals")){
                            arr_khosach = new FilterFunction().filterBy_Equails_NUMBER_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Not Equals")){
                            arr_khosach = new FilterFunction().filterBy_NotEquails_NUMBER_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Greater Than")){
                            arr_khosach = new FilterFunction().filterBy_GreaterThan_NUMBER_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Greater Than Or Equals To")){
                            arr_khosach = new FilterFunction().filterBy_GreaterThanOrEqualsTo_NUMBER_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Less Than")){
                            arr_khosach = new FilterFunction().filterBy_LessThan_NUMBER_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Less Than Or Equals To")){
                            arr_khosach = new FilterFunction().filterBy_LessThanOrEqualsTo_NUMBER_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, Integer.parseInt(fd.value_1));
                        }
                    }
                    new KhoSachModule().paintTable(arr_khosach);
                    break;
            }
        }
        else if (fd.getandOr() != 0 && fd.hasChoice_1() && fd.hasChoice_2()){
            switch (tableName){
                case "LoaiSach":
                    ArrayList <QLLoaiSachDTO> arr = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_1.equals("Equals")){
                            arr = new FilterFunction().filterBy_Equails_STRING_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Not Equals")){
                            arr = new FilterFunction().filterBy_NotEquails_STRING_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Contains")){
                            arr = new FilterFunction().filterBy_Contains_STRING_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Does not Contain")){
                            arr = new FilterFunction().filterBy_DoesNotContain_STRING_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Begins With")){
                            arr = new FilterFunction().filterBy_BeginsWith_STRING_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Ends With")){
                            arr = new FilterFunction().filterBy_EndsWith_STRING_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, fd.value_1);
                        }
                    }
                    else if (choiceType.equals("NUMBER")){
                        if (fd.choice_1.equals("Equals")){
                            arr = new FilterFunction().filterBy_Equails_NUMBER_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Not Equals")){
                            arr = new FilterFunction().filterBy_NotEquails_NUMBER_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Greater Than")){
                            arr = new FilterFunction().filterBy_GreaterThan_NUMBER_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Greater Than Or Equals To")){
                            arr = new FilterFunction().filterBy_GreaterThanOrEqualsTo_NUMBER_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Less Than")){
                            arr = new FilterFunction().filterBy_LessThan_NUMBER_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Less Than Or Equals To")){
                            arr = new FilterFunction().filterBy_LessThanOrEqualsTo_NUMBER_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, Integer.parseInt(fd.value_1));
                        }
                    }
                    
                    ArrayList <QLLoaiSachDTO> arr_2 = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_2.equals("Equals")){
                            arr_2 = new FilterFunction().filterBy_Equails_STRING_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Not Equals")){
                            arr_2 = new FilterFunction().filterBy_NotEquails_STRING_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Contains")){
                            arr_2 = new FilterFunction().filterBy_Contains_STRING_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Does not Contain")){
                            arr_2 = new FilterFunction().filterBy_DoesNotContain_STRING_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Begins With")){
                            arr_2 = new FilterFunction().filterBy_BeginsWith_STRING_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Ends With")){
                            arr_2 = new FilterFunction().filterBy_EndsWith_STRING_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, fd.value_2);
                        }
                    }
                    else if (choiceType.equals("NUMBER")){
                        if (fd.choice_2.equals("Equals")){
                            arr_2 = new FilterFunction().filterBy_Equails_NUMBER_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, Integer.parseInt(fd.value_2));
                        }
                        else if (fd.choice_2.equals("Not Equals")){
                            arr_2 = new FilterFunction().filterBy_NotEquails_NUMBER_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, Integer.parseInt(fd.value_2));
                        }
                        else if (fd.choice_2.equals("Greater Than")){
                            arr_2 = new FilterFunction().filterBy_GreaterThan_NUMBER_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, Integer.parseInt(fd.value_2));
                        }
                        else if (fd.choice_2.equals("Greater Than Or Equals To")){
                            arr_2 = new FilterFunction().filterBy_GreaterThanOrEqualsTo_NUMBER_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, Integer.parseInt(fd.value_2));
                        }
                        else if (fd.choice_2.equals("Less Than")){
                            arr_2 = new FilterFunction().filterBy_LessThan_NUMBER_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, Integer.parseInt(fd.value_2));
                        }
                        else if (fd.choice_2.equals("Less Than Or Equals To")){
                            arr_2 = new FilterFunction().filterBy_LessThanOrEqualsTo_NUMBER_LoaiSach(new QLLoaiSachBUS(0).getArrSach(), header, Integer.parseInt(fd.value_2));
                        }
                    }
                    
                    ArrayList <String> pKey = new ArrayList<>();
                    ArrayList <String> pKey_2 = new ArrayList<>();
                    
                    for (QLLoaiSachDTO e : arr){
                        pKey.add(e.getMaSach());
                    }
                    
                    for (QLLoaiSachDTO e : arr_2){
                        pKey_2.add(e.getMaSach());
                    }
                    
                    ArrayList <QLLoaiSachDTO> arr_res = new ArrayList<>();
                    
                    if (fd.getandOr() == 1){
                        arr_res = new QLLoaiSachBUS(0).getLoaiSach_full(ps.intersection_arr(pKey, pKey_2));
                    }
                    else if (fd.getandOr() == 2){
                        arr_res = new QLLoaiSachBUS(0).getLoaiSach_full(ps.union_arr(pKey, pKey_2));
                    }
                    new LoaiSachModule().paintTable(arr_res);
                    break;
                    
                case "NhaCungCap":
                    ArrayList <QLNhaCungCapDTO> arr_nhacungcap_1 = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_1.equals("Equals")){
                            arr_nhacungcap_1 = new FilterFunction().filterBy_Equails_STRING_NhaCungCap(new QLNhaCungCapBUS(0).getArrNhaCungCap(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Not Equals")){
                            arr_nhacungcap_1 = new FilterFunction().filterBy_NotEquails_STRING_NhaCungCap(new QLNhaCungCapBUS(0).getArrNhaCungCap(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Contains")){
                            arr_nhacungcap_1 = new FilterFunction().filterBy_Contains_STRING_NhaCungCap(new QLNhaCungCapBUS(0).getArrNhaCungCap(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Does not Contain")){
                            arr_nhacungcap_1 = new FilterFunction().filterBy_DoesNotContain_STRING_NhaCungCap(new QLNhaCungCapBUS(0).getArrNhaCungCap(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Begins With")){
                            arr_nhacungcap_1 = new FilterFunction().filterBy_BeginsWith_STRING_NhaCungCap(new QLNhaCungCapBUS(0).getArrNhaCungCap(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Ends With")){
                            arr_nhacungcap_1 = new FilterFunction().filterBy_EndsWith_STRING_NhaCungCap(new QLNhaCungCapBUS(0).getArrNhaCungCap(), header, fd.value_1);
                        }
                    }
                    
                    ArrayList <QLNhaCungCapDTO> arr_nhacungcap_2 = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_2.equals("Equals")){
                            arr_nhacungcap_2 = new FilterFunction().filterBy_Equails_STRING_NhaCungCap(new QLNhaCungCapBUS(0).getArrNhaCungCap(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Not Equals")){
                            arr_nhacungcap_2 = new FilterFunction().filterBy_NotEquails_STRING_NhaCungCap(new QLNhaCungCapBUS(0).getArrNhaCungCap(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Contains")){
                            arr_nhacungcap_2 = new FilterFunction().filterBy_Contains_STRING_NhaCungCap(new QLNhaCungCapBUS(0).getArrNhaCungCap(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Does not Contain")){
                            arr_nhacungcap_2 = new FilterFunction().filterBy_DoesNotContain_STRING_NhaCungCap(new QLNhaCungCapBUS(0).getArrNhaCungCap(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Begins With")){
                            arr_nhacungcap_2 = new FilterFunction().filterBy_BeginsWith_STRING_NhaCungCap(new QLNhaCungCapBUS(0).getArrNhaCungCap(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Ends With")){
                            arr_nhacungcap_2 = new FilterFunction().filterBy_EndsWith_STRING_NhaCungCap(new QLNhaCungCapBUS(0).getArrNhaCungCap(), header, fd.value_2);
                        }
                    }
                    
                    ArrayList <String> pKey_nhacungcap = new ArrayList<>();
                    ArrayList <String> pKey_2_nhacuncap = new ArrayList<>();
                    
                    for (QLNhaCungCapDTO e : arr_nhacungcap_1){
                        pKey_nhacungcap.add(e.getMaNCC());
                    }
                    
                    for (QLNhaCungCapDTO e : arr_nhacungcap_2){
                        pKey_2_nhacuncap.add(e.getMaNCC());
                    }
                    
                    ArrayList <QLNhaCungCapDTO> arr_res_nhacungcap = new ArrayList<>();
                    
                    if (fd.getandOr() == 1){
                        arr_res_nhacungcap = new QLNhaCungCapBUS(0).getNhaCungCap_full(ps.intersection_arr(pKey_nhacungcap, pKey_2_nhacuncap));
                    }
                    else if (fd.getandOr() == 2){
                        arr_res_nhacungcap = new QLNhaCungCapBUS(0).getNhaCungCap_full(ps.union_arr(pKey_nhacungcap, pKey_2_nhacuncap));
                    }
                    new NhaCungCapModule().paintTable(arr_res_nhacungcap);
                    break;
                    
                case "The":
                    ArrayList <QLTheDTO> arr_the_1 = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_1.equals("Equals")){
                            arr_the_1 = new FilterFunction().filterBy_Equails_STRING_The(new QLTheBUS(0).getArrThe(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Not Equals")){
                            arr_the_1 = new FilterFunction().filterBy_NotEquails_STRING_The(new QLTheBUS(0).getArrThe(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Contains")){
                            arr_the_1 = new FilterFunction().filterBy_Contains_STRING_The(new QLTheBUS(0).getArrThe(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Does not Contain")){
                            arr_the_1 = new FilterFunction().filterBy_DoesNotContain_STRING_The(new QLTheBUS(0).getArrThe(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Begins With")){
                            arr_the_1 = new FilterFunction().filterBy_BeginsWith_STRING_The(new QLTheBUS(0).getArrThe(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Ends With")){
                            arr_the_1 = new FilterFunction().filterBy_EndsWith_STRING_The(new QLTheBUS(0).getArrThe(), header, fd.value_1);
                        }
                    }
                    
                    ArrayList <QLTheDTO> arr_the_2 = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_2.equals("Equals")){
                            arr_the_2 = new FilterFunction().filterBy_Equails_STRING_The(new QLTheBUS(0).getArrThe(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Not Equals")){
                            arr_the_2 = new FilterFunction().filterBy_NotEquails_STRING_The(new QLTheBUS(0).getArrThe(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Contains")){
                            arr_the_2 = new FilterFunction().filterBy_Contains_STRING_The(new QLTheBUS(0).getArrThe(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Does not Contain")){
                            arr_the_2 = new FilterFunction().filterBy_DoesNotContain_STRING_The(new QLTheBUS(0).getArrThe(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Begins With")){
                            arr_the_2 = new FilterFunction().filterBy_BeginsWith_STRING_The(new QLTheBUS(0).getArrThe(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Ends With")){
                            arr_the_2 = new FilterFunction().filterBy_EndsWith_STRING_The(new QLTheBUS(0).getArrThe(), header, fd.value_2);
                        }
                    }
                    
                    ArrayList <String> pKey_the = new ArrayList<>();
                    ArrayList <String> pKey_2_the = new ArrayList<>();
                    
                    for (QLTheDTO e : arr_the_1){
                        pKey_the.add(e.getMaThe());
                    }
                    
                    for (QLTheDTO e : arr_the_2){
                        pKey_2_the.add(e.getMaThe());
                    }
                    
                    ArrayList <QLTheDTO> arr_res_the = new ArrayList<>();
                    
                    if (fd.getandOr() == 1){
                        arr_res_the = new QLTheBUS(0).getThe_full(ps.intersection_arr(pKey_the, pKey_2_the));
                    }
                    else if (fd.getandOr() == 2){
                        arr_res_the = new QLTheBUS(0).getThe_full(ps.union_arr(pKey_the, pKey_2_the));
                    }
                    new TheModule().paintTable(arr_res_the);
                    break;
                    
                case "NhanVien":
                    ArrayList <QLNhanVienDTO> arr_nhanvien_1 = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_1.equals("Equals")){
                            arr_nhanvien_1 = new FilterFunction().filterBy_Equails_STRING_NhanVien(new QLNhanVienBUS(0).getArrNhanVien(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Not Equals")){
                            arr_nhanvien_1 = new FilterFunction().filterBy_NotEquails_STRING_NhanVien(new QLNhanVienBUS(0).getArrNhanVien(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Contains")){
                            arr_nhanvien_1 = new FilterFunction().filterBy_Contains_STRING_NhanVien(new QLNhanVienBUS(0).getArrNhanVien(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Does not Contain")){
                            arr_nhanvien_1 = new FilterFunction().filterBy_DoesNotContain_STRING_NhanVien(new QLNhanVienBUS(0).getArrNhanVien(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Begins With")){
                            arr_nhanvien_1 = new FilterFunction().filterBy_BeginsWith_STRING_NhanVien(new QLNhanVienBUS(0).getArrNhanVien(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Ends With")){
                            arr_nhanvien_1 = new FilterFunction().filterBy_EndsWith_STRING_NhanVien(new QLNhanVienBUS(0).getArrNhanVien(), header, fd.value_1);
                        }
                    }
                    
                    ArrayList <QLNhanVienDTO> arr_nhanvien_2 = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_2.equals("Equals")){
                            arr_nhanvien_2 = new FilterFunction().filterBy_Equails_STRING_NhanVien(new QLNhanVienBUS(0).getArrNhanVien(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Not Equals")){
                            arr_nhanvien_2 = new FilterFunction().filterBy_NotEquails_STRING_NhanVien(new QLNhanVienBUS(0).getArrNhanVien(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Contains")){
                            arr_nhanvien_2 = new FilterFunction().filterBy_Contains_STRING_NhanVien(new QLNhanVienBUS(0).getArrNhanVien(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Does not Contain")){
                            arr_nhanvien_2 = new FilterFunction().filterBy_DoesNotContain_STRING_NhanVien(new QLNhanVienBUS(0).getArrNhanVien(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Begins With")){
                            arr_nhanvien_2 = new FilterFunction().filterBy_BeginsWith_STRING_NhanVien(new QLNhanVienBUS(0).getArrNhanVien(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Ends With")){
                            arr_nhanvien_2 = new FilterFunction().filterBy_EndsWith_STRING_NhanVien(new QLNhanVienBUS(0).getArrNhanVien(), header, fd.value_2);
                        }
                    }
                    
                    ArrayList <String> pKey_nhanvien = new ArrayList<>();
                    ArrayList <String> pKey_2_nhanvien = new ArrayList<>();
                    
                    for (QLNhanVienDTO e : arr_nhanvien_1){
                        pKey_nhanvien.add(e.getMaNhanVien());
                    }
                    
                    for (QLNhanVienDTO e : arr_nhanvien_2){
                        pKey_2_nhanvien.add(e.getMaNhanVien());
                    }
                    
                    ArrayList <QLNhanVienDTO> arr_res_nhanvien = new ArrayList<>();
                    
                    if (fd.getandOr() == 1){
                        arr_res_nhanvien = new QLNhanVienBUS(0).getNhanVien_full(ps.intersection_arr(pKey_nhanvien, pKey_2_nhanvien));
                    }
                    else if (fd.getandOr() == 2){
                        arr_res_nhanvien = new QLNhanVienBUS(0).getNhanVien_full(ps.union_arr(pKey_nhanvien, pKey_2_nhanvien));
                    }
                    new NhanVienModule().paintTable(arr_res_nhanvien);
                    break;
                    
                case "SachThuVien":
                    ArrayList <QLChiTietSachDTO> arr_sachthuvien_1 = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_1.equals("Equals")){
                            arr_sachthuvien_1 = new FilterFunction().filterBy_Equails_STRING_SachThuVien(new QLChiTietSachBUS(0).getArrChiTietSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Not Equals")){
                            arr_sachthuvien_1 = new FilterFunction().filterBy_NotEquails_STRING_SachThuVien(new QLChiTietSachBUS(0).getArrChiTietSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Contains")){
                            arr_sachthuvien_1 = new FilterFunction().filterBy_Contains_STRING_SachThuVien(new QLChiTietSachBUS(0).getArrChiTietSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Does not Contain")){
                            arr_sachthuvien_1 = new FilterFunction().filterBy_DoesNotContain_STRING_SachThuVien(new QLChiTietSachBUS(0).getArrChiTietSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Begins With")){
                            arr_sachthuvien_1 = new FilterFunction().filterBy_BeginsWith_STRING_SachThuVien(new QLChiTietSachBUS(0).getArrChiTietSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Ends With")){
                            arr_sachthuvien_1 = new FilterFunction().filterBy_EndsWith_STRING_SachThuVien(new QLChiTietSachBUS(0).getArrChiTietSach(), header, fd.value_1);
                        }
                    }
                    
                    ArrayList <QLChiTietSachDTO> arr_sachthuvien_2 = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_2.equals("Equals")){
                            arr_sachthuvien_2 = new FilterFunction().filterBy_Equails_STRING_SachThuVien(new QLChiTietSachBUS(0).getArrChiTietSach(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Not Equals")){
                            arr_sachthuvien_2 = new FilterFunction().filterBy_NotEquails_STRING_SachThuVien(new QLChiTietSachBUS(0).getArrChiTietSach(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Contains")){
                            arr_sachthuvien_2 = new FilterFunction().filterBy_Contains_STRING_SachThuVien(new QLChiTietSachBUS(0).getArrChiTietSach(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Does not Contain")){
                            arr_sachthuvien_2 = new FilterFunction().filterBy_DoesNotContain_STRING_SachThuVien(new QLChiTietSachBUS(0).getArrChiTietSach(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Begins With")){
                            arr_sachthuvien_2 = new FilterFunction().filterBy_BeginsWith_STRING_SachThuVien(new QLChiTietSachBUS(0).getArrChiTietSach(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Ends With")){
                            arr_sachthuvien_2 = new FilterFunction().filterBy_EndsWith_STRING_SachThuVien(new QLChiTietSachBUS(0).getArrChiTietSach(), header, fd.value_2);
                        }
                    }
                    
                    ArrayList <String> pKey_sachthuvien = new ArrayList<>();
                    ArrayList <String> pKey_2_sachthuvien = new ArrayList<>();
                    
                    for (QLChiTietSachDTO e : arr_sachthuvien_1){
                        pKey_sachthuvien.add(e.getIDSach());
                    }
                    
                    for (QLChiTietSachDTO e : arr_sachthuvien_2){
                        pKey_2_sachthuvien.add(e.getIDSach());
                    }
                    
                    ArrayList <QLChiTietSachDTO> arr_res_sachthuvien = new ArrayList<>();
                    
                    if (fd.getandOr() == 1){
                        arr_res_sachthuvien = new QLChiTietSachBUS(0).getChiTietSach_full(ps.intersection_arr(pKey_sachthuvien, pKey_2_sachthuvien));
                    }
                    else if (fd.getandOr() == 2){
                        arr_res_sachthuvien = new QLChiTietSachBUS(0).getChiTietSach_full(ps.union_arr(pKey_sachthuvien, pKey_2_sachthuvien));
                    }
                    new SachThuVienModule().paintTable(arr_res_sachthuvien);
                    break;
                    
                case "PhieuMuon":
                    ArrayList <QLPhieuMuonDTO> arr_phieumuon_1 = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_1.equals("Equals")){
                            arr_phieumuon_1 = new FilterFunction().filterBy_Equails_STRING_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Not Equals")){
                            arr_phieumuon_1 = new FilterFunction().filterBy_NotEquails_STRING_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Contains")){
                            arr_phieumuon_1 = new FilterFunction().filterBy_Contains_STRING_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Does not Contain")){
                            arr_phieumuon_1 = new FilterFunction().filterBy_DoesNotContain_STRING_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Begins With")){
                            arr_phieumuon_1 = new FilterFunction().filterBy_BeginsWith_STRING_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Ends With")){
                            arr_phieumuon_1 = new FilterFunction().filterBy_EndsWith_STRING_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, fd.value_1);
                        }
                    }
                    else if (choiceType.equals("NUMBER")){
                        if (fd.choice_1.equals("Equals")){
                            arr_phieumuon_1 = new FilterFunction().filterBy_Equails_NUMBER_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Not Equals")){
                            arr_phieumuon_1 = new FilterFunction().filterBy_NotEquails_NUMBER_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Greater Than")){
                            arr_phieumuon_1 = new FilterFunction().filterBy_GreaterThan_NUMBER_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Greater Than Or Equals To")){
                            arr_phieumuon_1 = new FilterFunction().filterBy_GreaterThanOrEqualsTo_NUMBER_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Less Than")){
                            arr_phieumuon_1 = new FilterFunction().filterBy_LessThan_NUMBER_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Less Than Or Equals To")){
                            arr_phieumuon_1 = new FilterFunction().filterBy_LessThanOrEqualsTo_NUMBER_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, Integer.parseInt(fd.value_1));
                        }
                    }
                    ArrayList <QLPhieuMuonDTO> arr_phieumuon_2 = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_2.equals("Equals")){
                            arr_phieumuon_2 = new FilterFunction().filterBy_Equails_STRING_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Not Equals")){
                            arr_phieumuon_2 = new FilterFunction().filterBy_NotEquails_STRING_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Contains")){
                            arr_phieumuon_2 = new FilterFunction().filterBy_Contains_STRING_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Does not Contain")){
                            arr_phieumuon_2 = new FilterFunction().filterBy_DoesNotContain_STRING_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Begins With")){
                            arr_phieumuon_2 = new FilterFunction().filterBy_BeginsWith_STRING_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Ends With")){
                            arr_phieumuon_2 = new FilterFunction().filterBy_EndsWith_STRING_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, fd.value_2);
                        }
                    }
                    else if (choiceType.equals("NUMBER")){
                        if (fd.choice_2.equals("Equals")){
                            arr_phieumuon_2 = new FilterFunction().filterBy_Equails_NUMBER_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, Integer.parseInt(fd.value_2));
                        }
                        else if (fd.choice_2.equals("Not Equals")){
                            arr_phieumuon_2 = new FilterFunction().filterBy_NotEquails_NUMBER_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, Integer.parseInt(fd.value_2));
                        }
                        else if (fd.choice_2.equals("Greater Than")){
                            arr_phieumuon_2 = new FilterFunction().filterBy_GreaterThan_NUMBER_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, Integer.parseInt(fd.value_2));
                        }
                        else if (fd.choice_2.equals("Greater Than Or Equals To")){
                            arr_phieumuon_2 = new FilterFunction().filterBy_GreaterThanOrEqualsTo_NUMBER_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, Integer.parseInt(fd.value_2));
                        }
                        else if (fd.choice_2.equals("Less Than")){
                            arr_phieumuon_2 = new FilterFunction().filterBy_LessThan_NUMBER_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, Integer.parseInt(fd.value_2));
                        }
                        else if (fd.choice_2.equals("Less Than Or Equals To")){
                            arr_phieumuon_2 = new FilterFunction().filterBy_LessThanOrEqualsTo_NUMBER_PhieuMuon(new QLPhieuMuonBUS(0).getArrMuonTra(), header, Integer.parseInt(fd.value_2));
                        }
                    }
                    ArrayList <String> pKey_phieumuon = new ArrayList<>();
                    ArrayList <String> pKey_2_phieumuon = new ArrayList<>();
                    
                    for (QLPhieuMuonDTO e : arr_phieumuon_1){
                        pKey_phieumuon.add(e.getMaPhieuMuon());
                    }
                    
                    for (QLPhieuMuonDTO e : arr_phieumuon_2){
                        pKey_2_phieumuon.add(e.getMaPhieuMuon());
                    }
                    
                    ArrayList <QLPhieuMuonDTO> arr_res_phieumuon = new ArrayList<>();
                    
                    if (fd.getandOr() == 1){
                        arr_res_phieumuon = new QLPhieuMuonBUS(0).getPhieuMuon_full(ps.intersection_arr(pKey_phieumuon, pKey_2_phieumuon));
                    }
                    else if (fd.getandOr() == 2){
                        arr_res_phieumuon = new QLPhieuMuonBUS(0).getPhieuMuon_full(ps.union_arr(pKey_phieumuon, pKey_2_phieumuon));
                    }
                    new PhieuMuonModule().paintTable(arr_res_phieumuon);
                    break;
                    
                case "KhoSach":
                    ArrayList <QLKhoSachDTO> arr_khosach_1 = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_1.equals("Equals")){
                            arr_khosach_1 = new FilterFunction().filterBy_Equails_STRING_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Not Equals")){
                            arr_khosach_1 = new FilterFunction().filterBy_NotEquails_STRING_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Contains")){
                            arr_khosach_1 = new FilterFunction().filterBy_Contains_STRING_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Does not Contain")){
                            arr_khosach_1 = new FilterFunction().filterBy_DoesNotContain_STRING_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Begins With")){
                            arr_khosach_1 = new FilterFunction().filterBy_BeginsWith_STRING_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, fd.value_1);
                        }
                        else if (fd.choice_1.equals("Ends With")){
                            arr_khosach_1 = new FilterFunction().filterBy_EndsWith_STRING_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, fd.value_1);
                        }
                    }
                    else if (choiceType.equals("NUMBER")){
                        if (fd.choice_1.equals("Equals")){
                            arr_khosach_1 = new FilterFunction().filterBy_Equails_NUMBER_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Not Equals")){
                            arr_khosach_1 = new FilterFunction().filterBy_NotEquails_NUMBER_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Greater Than")){
                            arr_khosach_1 = new FilterFunction().filterBy_GreaterThan_NUMBER_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Greater Than Or Equals To")){
                            arr_khosach_1 = new FilterFunction().filterBy_GreaterThanOrEqualsTo_NUMBER_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Less Than")){
                            arr_khosach_1 = new FilterFunction().filterBy_LessThan_NUMBER_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, Integer.parseInt(fd.value_1));
                        }
                        else if (fd.choice_1.equals("Less Than Or Equals To")){
                            arr_khosach_1 = new FilterFunction().filterBy_LessThanOrEqualsTo_NUMBER_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, Integer.parseInt(fd.value_1));
                        }
                    }
                    ArrayList <QLKhoSachDTO> arr_khosach_2 = new ArrayList<>();
                    if (choiceType.equals("STRING")){
                        if (fd.choice_2.equals("Equals")){
                            arr_khosach_2 = new FilterFunction().filterBy_Equails_STRING_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Not Equals")){
                            arr_khosach_2 = new FilterFunction().filterBy_NotEquails_STRING_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Contains")){
                            arr_khosach_2 = new FilterFunction().filterBy_Contains_STRING_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Does not Contain")){
                            arr_khosach_2 = new FilterFunction().filterBy_DoesNotContain_STRING_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Begins With")){
                            arr_khosach_2 = new FilterFunction().filterBy_BeginsWith_STRING_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, fd.value_2);
                        }
                        else if (fd.choice_2.equals("Ends With")){
                            arr_khosach_2 = new FilterFunction().filterBy_EndsWith_STRING_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, fd.value_2);
                        }
                    }
                    else if (choiceType.equals("NUMBER")){
                        if (fd.choice_2.equals("Equals")){
                            arr_khosach_2 = new FilterFunction().filterBy_Equails_NUMBER_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, Integer.parseInt(fd.value_2));
                        }
                        else if (fd.choice_2.equals("Not Equals")){
                            arr_khosach_2 = new FilterFunction().filterBy_NotEquails_NUMBER_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, Integer.parseInt(fd.value_2));
                        }
                        else if (fd.choice_2.equals("Greater Than")){
                            arr_khosach_2 = new FilterFunction().filterBy_GreaterThan_NUMBER_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, Integer.parseInt(fd.value_2));
                        }
                        else if (fd.choice_2.equals("Greater Than Or Equals To")){
                            arr_khosach_2 = new FilterFunction().filterBy_GreaterThanOrEqualsTo_NUMBER_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, Integer.parseInt(fd.value_2));
                        }
                        else if (fd.choice_2.equals("Less Than")){
                            arr_khosach_2 = new FilterFunction().filterBy_LessThan_NUMBER_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, Integer.parseInt(fd.value_2));
                        }
                        else if (fd.choice_2.equals("Less Than Or Equals To")){
                            arr_khosach_2 = new FilterFunction().filterBy_LessThanOrEqualsTo_NUMBER_KhoSach(new QLKhoSachBUS(0).getArrKhoSach(), header, Integer.parseInt(fd.value_2));
                        }
                    }
                    ArrayList <String> pKey_khosach = new ArrayList<>();
                    ArrayList <String> pKey_2_khosach = new ArrayList<>();
                    
                    for (QLKhoSachDTO e : arr_khosach_1){
                        pKey_khosach.add(e.getMaSach());
                    }
                    
                    for (QLKhoSachDTO e : arr_khosach_2){
                        pKey_2_khosach.add(e.getMaSach());
                    }
                    
                    ArrayList <QLKhoSachDTO> arr_res_khosach = new ArrayList<>();
                    
                    if (fd.getandOr() == 1){
                        arr_res_khosach = new QLKhoSachBUS(0).getKhoSach_full(ps.intersection_arr(pKey_khosach, pKey_2_khosach));
                    }
                    else if (fd.getandOr() == 2){
                        arr_res_khosach = new QLKhoSachBUS(0).getKhoSach_full(ps.union_arr(pKey_khosach, pKey_2_khosach));
                    }
                    new KhoSachModule().paintTable(arr_res_khosach);
                    break;
            }
        }
    }

    private void dongybtnActionPerformed(java.awt.event.ActionEvent evt) {                                         
        System.out.println(choice_1.getItemAt(choice_1.getSelectedIndex()) + " " + textfield_1.getText());
        System.out.println(choice_2.getItemAt(choice_2.getSelectedIndex()) + " " + textfield_2.getText());
        if (andBtn.isSelected()){
            System.out.println("And");
        }
        if (orBtn.isSelected()){
            System.out.println("OR");
        }
        int andor = 0;
        if (andBtn.isSelected()){
            andor = 1;
        }
        else if (orBtn.isSelected()){
            andor = 2;
        }
        else {
            andor = 0;
        }
        FilterData fd = new FilterData();
        fd.setData(choice_1.getItemAt(choice_1.getSelectedIndex()), choice_2.getItemAt(choice_2.getSelectedIndex()), textfield_1.getText(), textfield_2.getText(), andor);
        doFilter(header, tableName, fd);
        this.dispose();
    }                                        

    private void quayluibtnActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.dispose();
    }                                          

    private void andBtnMouseClicked(java.awt.event.MouseEvent evt) {                                    
        orBtn.setSelected(false);
    }                                   

    private void orBtnMouseClicked(java.awt.event.MouseEvent evt) {                                   
        andBtn.setSelected(false);
    }         
    
    public String get_choice_1(){
        return choice_1.getItemAt(choice_1.getSelectedIndex());
    }
    
    public String get_choice_2(){
        return choice_2.getItemAt(choice_2.getSelectedIndex());
    }
    
    public String get_value_1(){
        return textfield_1.getText();
    }
    
    public String get_value_2(){
        return textfield_2.getText();
    }
    
    // 0: -and, -or; 1: and, -or, 2: -and, or
    public int get_andor(){
        if (andBtn.isSelected()){
            return 1;
        }
        else if (orBtn.isSelected()){
            return 2;
        }
        else{
            return 0;
        }
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Filter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Filter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Filter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Filter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Filter("Greater Than").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private static javax.swing.JRadioButton andBtn;
    private static javax.swing.JComboBox<String> choice_1;
    private static javax.swing.JComboBox<String> choice_2;
    private javax.swing.JButton dongybtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator line_1;
    private javax.swing.JSeparator line_2;
    private static javax.swing.JRadioButton orBtn;
    private javax.swing.JButton quayluibtn;
    private static javax.swing.JTextField textfield_1;
    private static javax.swing.JTextField textfield_2;
    private javax.swing.JLabel tittle;
    // End of variables declaration                   
}


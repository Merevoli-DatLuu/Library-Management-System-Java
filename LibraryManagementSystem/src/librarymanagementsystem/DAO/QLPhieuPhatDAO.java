package librarymanagementsystem.DAO;

import librarymanagementsystem.Toolkit.*;
import librarymanagementsystem.DTO.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class QLPhieuPhatDAO {
    DBConnection DBPhieuPhat;
    
    public ArrayList<QLPhieuPhatDTO> readDB(){
        DBPhieuPhat = new DBConnection();
        ArrayList<QLPhieuPhatDTO> arrPhieuPhat = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM phieuPhat";
            ResultSet rs = DBPhieuPhat.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    String maPhieuPhat = rs.getString("maPhieuPhat");
                    String maPhieuMuon = rs.getString("maPhieuMuon");
                    String maLDPhat = rs.getString("maLDPhat");
                    int tienPhat = rs.getInt("tienPhat");
                    arrPhieuPhat.add(new QLPhieuPhatDTO(maPhieuPhat, maPhieuMuon, maLDPhat, tienPhat));
                }
            }

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Phiếu Phạt");
        } 
        finally{
            DBPhieuPhat.closeConnection();
        }
        return arrPhieuPhat;
    }
    
    public Boolean add(QLPhieuPhatDTO phieuPhat){
        DBPhieuPhat = new DBConnection();
        Boolean check = DBPhieuPhat.SQLUpdate("INSERT INTO phieuPhat(maPhieuPhat, maPhieuMuon, maLDPhat, tienPhat) "
                + "VALUES ('"
                + phieuPhat.getMaPhieuPhat()+ "','"  
                + phieuPhat.getMaPhieuMuon()+ "','"  
                + phieuPhat.getMaLDPhat()+ "',"
                + phieuPhat.getTienPhat()+ ");");
        DBPhieuPhat.closeConnection();
        return check;
    }
    
     public Boolean del(String maPhieuPhat){
        Boolean check = DBPhieuPhat.SQLUpdate("DELETE FROM phieuPhat WHERE phieuPhat.maPhieuPhat = '" + maPhieuPhat + "';");
        DBPhieuPhat.closeConnection();
        return check;
    }
    
    public Boolean mod(QLPhieuPhatDTO phieuPhat){
        DBPhieuPhat = new DBConnection();
        Boolean check = DBPhieuPhat.SQLUpdate("Update phieuPhat Set "
                + " maPhieuMuon='" + phieuPhat.getMaPhieuMuon()
                + "', maLDPhat='" + phieuPhat.getMaLDPhat()
                + "', tienPhat=" + phieuPhat.getTienPhat()
                + " where maPhieuPhat='" + phieuPhat.getMaPhieuPhat()+ "';");
        DBPhieuPhat.closeConnection();
        return check;
    }
}

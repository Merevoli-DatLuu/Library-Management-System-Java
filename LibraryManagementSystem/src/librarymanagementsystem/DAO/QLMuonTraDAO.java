package librarymanagementsystem.DAO;

import librarymanagementsystem.Toolkit.*;
import librarymanagementsystem.DTO.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class QLMuonTraDAO {
    DBConnection DBMuonTra;
    
    public ArrayList<QLMuonTraDTO> readDB(){
        DBMuonTra = new DBConnection();
        ArrayList<QLMuonTraDTO> arrMuonTra = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM MuonSach,TraSach WHERE MuonSach.maMuonSach = TraSach.maMuonSach";
            ResultSet rs = DBMuonTra.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    String maMuonSach = rs.getString("maMuonSach");
                    String maThe = rs.getString("maThe");
                    String IDSach = rs.getString("IDSach");
                    String thoiDiemMuon = rs.getString("thoiDiemMuon");
                    int thoiGianMuon = rs.getInt("thoiGianMuon");
                    String thoiDiemTra = rs.getString("thoiDiemTra");
                    arrMuonTra.add(new QLMuonTraDTO(maMuonSach, maThe, IDSach, thoiDiemMuon, thoiGianMuon, thoiDiemTra));
                }
            }

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Mượn Sách, Trả Sách");
        } 
        finally{
            DBMuonTra.closeConnection();
        }
        return arrMuonTra;
    }
    
    public Boolean add(QLMuonTraDTO muonTra){
        DBMuonTra = new DBConnection();
        Boolean check = DBMuonTra.SQLUpdate("INSERT INTO MuonSach(maMuonSach, maThe, IDSach, thoiDiemMuon, thoiGianMuon) "
                + "VALUES ('"
                + muonTra.getMaMuonSach()+ "','"     
                + muonTra.getMaThe()+ "','"   
                + muonTra.getIDSach()+ "','"   
                + muonTra.getThoiDiemMuon()+ "',"     
                + muonTra.getThoiGianMuon()+ ");"
                + "INSERT INTO TraSach(maMuonSach,thoiDiemTra)"
                    +"VALUES ('"
                        + muonTra.getMaMuonSach()+"','"
                        + muonTra.getThoiDiemTra()+"');");
        DBMuonTra.closeConnection();
        return check;
    }
    // add table `muonsach`
    public Boolean add(String maMuonSach, String maThe, String IDSach, String thoiDiemMuon, int thoiGianMuon){
        DBMuonTra = new DBConnection();
        Boolean check = DBMuonTra.SQLUpdate("INSERT INTO MuonSach(maMuonSach, maThe, IDSach, thoiDiemMuon, thoiGianMuon) "
                + "VALUES ('"
                + maMuonSach+ "','"     
                + maThe+ "','"   
                + IDSach+ "','"   
                + thoiDiemMuon+ "',"     
                + thoiGianMuon+ ");");
        DBMuonTra.closeConnection();
        return check;
    }
    // add table `trasach`
    public Boolean add(String maMuonSach, String thoiDiemTra){
        DBMuonTra = new DBConnection();
        Boolean check = DBMuonTra.SQLUpdate("INSERT INTO TraSach(maMuonSach,thoiDiemTra)"
                    +"VALUES ('"
                        + maMuonSach+"','"
                        + thoiDiemTra+"');");
        DBMuonTra.closeConnection();
        return check;
    }
    
     public Boolean del(String maMuonSach){
        DBMuonTra = new DBConnection();
        Boolean check = DBMuonTra.SQLUpdate("DELETE FROM MuonSach WHERE MuonSach.maMuonSach = '" + maMuonSach + "';"
                                            + "DELETE FROM TraSach WHERE TraSach.maMuonSach = '" + maMuonSach + "';");
        DBMuonTra.closeConnection();
        return check;
    }
    
    public Boolean mod(QLMuonTraDTO muonTra){
        DBMuonTra = new DBConnection();
        Boolean check = DBMuonTra.SQLUpdate("Update MuonSach Set "
                + " maThe='" + muonTra.getMaThe()
                + "', IDSach='" + muonTra.getIDSach()
                + "', thoiDiemMuon='" + muonTra.getThoiDiemMuon()
                + "', thoiGianMuon=" + muonTra.getThoiGianMuon()
                + " where maMuonSach='" + muonTra.getMaMuonSach()+ "';"
                + "Update TraSach Set "
                    + "thoiDiemTra='" + muonTra.getThoiDiemTra()
                    + "' where maMuonSach='"+ muonTra.getMaMuonSach()+ "';");
        DBMuonTra.closeConnection();
        return check;
    }
    // mod table `muonsach`   
    public Boolean mod(String maMuonSach, String maThe, String IDSach, String thoiDiemMuon, int thoiGianMuon){
        DBMuonTra = new DBConnection();
        Boolean check = DBMuonTra.SQLUpdate("Update MuonSach Set "
                + " maThe='" + maThe
                + "', IDSach='" + IDSach
                + "', thoiDiemMuon='" + thoiDiemMuon
                + "', thoiGianMuon=" + thoiGianMuon
                + " where maMuonSach='" + maMuonSach+ "';");
        DBMuonTra.closeConnection();
        return check;
    }
    // mod table `trasach`
    public Boolean mod(String maMuonSach, String thoiDiemTra){
        DBMuonTra = new DBConnection();
        Boolean check = DBMuonTra.SQLUpdate("Update TraSach Set "
                    + "thoiDiemTra='" + thoiDiemTra
                    + "' where maMuonSach='"+ maMuonSach+ "';");
        DBMuonTra.closeConnection();
        return check;
    }
}

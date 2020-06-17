package librarymanagementsystem.DAO;

import librarymanagementsystem.Toolkit.*;
import librarymanagementsystem.DTO.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class QLPhieuMuonDAO {
    DBConnection DBMuonTra;
    
    public ArrayList<QLPhieuMuonDTO> readDB(){
        DBMuonTra = new DBConnection();
        ArrayList<QLPhieuMuonDTO> arrMuonTra = new ArrayList<>();
        
        try{
            HashMap<String, ArrayList <String> > hashmap = new HashMap<String, ArrayList <String> >();
            String query_IDSach = "SELECT * FROM ChiTietPhieuMuon";
            ResultSet rs_IDSach = DBMuonTra.SQLQuery(query_IDSach);
            if (rs_IDSach != null){
                while (rs_IDSach.next()){
                    String maPhieuMuon = rs_IDSach.getString("maPhieuMuon");
                    String IDSach = rs_IDSach.getString("IDSach");
                    if (!hashmap.containsKey(maPhieuMuon)){
                        ArrayList <String> temp = new ArrayList<>();
                        temp.add(IDSach);
                        hashmap.put(maPhieuMuon, temp);
                    }
                    else{
                        ArrayList <String> temp = hashmap.get(maPhieuMuon);
                        temp.add(IDSach);
                        hashmap.put(maPhieuMuon, temp);
                    }
                }
            }
            
            String query = "SELECT * FROM PhieuMuon";
            ResultSet rs = DBMuonTra.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    String maPhieuMuon = rs.getString("maPhieuMuon");
                    String maThe = rs.getString("maThe");
                    String NgayMuon = rs.getString("ngayMuon");
                    int thoiGianMuon = rs.getInt("thoiGianMuon");
                    String NgayTra = rs.getString("ngayTra");
                    ArrayList <String> IDSach = hashmap.get(maPhieuMuon);
                    
                    arrMuonTra.add(new QLPhieuMuonDTO(maPhieuMuon, maThe, IDSach, NgayMuon, thoiGianMuon, NgayTra));
                }
            }

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Phiếu Mượn");
        } 
        finally{
            DBMuonTra.closeConnection();
        }
        return arrMuonTra;
    }
    
    public ArrayList<QLPhieuMuonDTO> readDB_temp(){
        DBMuonTra = new DBConnection();
        ArrayList<QLPhieuMuonDTO> arrMuonTra = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM PhieuMuon";
            ResultSet rs = DBMuonTra.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    String maPhieuMuon = rs.getString("maPhieuMuon");
                    String maThe = rs.getString("maThe");
                    String NgayMuon = rs.getString("ngayMuon");
                    int thoiGianMuon = rs.getInt("thoiGianMuon");
                    String NgayTra = rs.getString("ngayTra");
                    ArrayList <String> IDSach = new ArrayList <String> ();
                    String query_IDSach = "SELECT * FROM ChiTietPhieuMuon WHERE ChiTietPhieuMuon.maPhieuMuon = '"  + maPhieuMuon + "'";
                    ResultSet rs_IDSach = new DBConnection().SQLQuery(query_IDSach);
                    if (rs_IDSach != null){
                        while (rs_IDSach.next()){
                            IDSach.add(rs_IDSach.getString("IDSach"));
                        }
                    }
                    
                    arrMuonTra.add(new QLPhieuMuonDTO(maPhieuMuon, maThe, IDSach, NgayMuon, thoiGianMuon, NgayTra));
                }
            }

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Phiếu Mượn");
        } 
        finally{
            DBMuonTra.closeConnection();
        }
        return arrMuonTra;
    }
    
    public Boolean add(QLPhieuMuonDTO muonTra){
        DBMuonTra = new DBConnection();
        Boolean check = DBMuonTra.SQLUpdate("INSERT INTO PhieuMuon(maPhieuMuon, maThe, NgayMuon, thoiGianMuon, NgayTra) "
                + "VALUES ('"
                + muonTra.getMaPhieuMuon()+ "','"     
                + muonTra.getMaThe()+ "','"     
                + muonTra.getNgayMuon()+ "',"     
                + muonTra.getThoiGianMuon()+ ",'"     
                + muonTra.getNgayTra()+ "');");
        Boolean check_2 = true;
        for (String idsach : muonTra.getIDSach()){
            Boolean check_3 = DBMuonTra.SQLUpdate("INSERT INTO ChiTietPhieuMuon(maPhieuMuon, IDSach) "
                + "VALUES ('"
                + muonTra.getMaPhieuMuon()+ "','"       
                + idsach+ "');");
            if (!check_3){
                check_2 = false;
            }
        }
        DBMuonTra.closeConnection();
        return check & check_2;
    }
    
    public Boolean add(String maPhieuMuon, String maThe, ArrayList <String> IDSach, String NgayMuon, int thoiGianMuon, String NgayTra){
        DBMuonTra = new DBConnection();
        Boolean check = DBMuonTra.SQLUpdate("INSERT INTO PhieuMuon(maPhieuMuon, maThe, NgayMuon, thoiGianMuon, NgayTra) "
                + "VALUES ('"
                + maPhieuMuon+ "','"     
                + maThe+ "','"   
                + NgayMuon+ "',"     
                + thoiGianMuon+ ",'"
                + NgayTra+ "');");
        Boolean check_2 = true;
        for (String idsach : IDSach){
            Boolean check_3 = DBMuonTra.SQLUpdate("INSERT INTO ChiTietPhieuMuon(maPhieuMuon, IDSach) "
                + "VALUES ('"
                + maPhieuMuon+ "','"       
                + idsach+ "');");
            if (!check_3){
                check_2 = false;
            }
        }
        DBMuonTra.closeConnection();
        return check & check_2;
    }
    
    public Boolean del(String maPhieuMuon){
        DBMuonTra = new DBConnection();
        Boolean check = DBMuonTra.SQLUpdate("DELETE FROM PhieuMuon WHERE PhieuMuon.maPhieuMuon = '" + maPhieuMuon + "';");
        Boolean check_2 = DBMuonTra.SQLUpdate("DELETE FROM ChiTietPhieuMuon WHERE ChiTietPhieuMuon.maPhieuMuon = '" + maPhieuMuon + "';");
        DBMuonTra.closeConnection();
        return check & check_2;
    }
    
    public Boolean mod(QLPhieuMuonDTO muonTra){
        DBMuonTra = new DBConnection();
        Boolean check = DBMuonTra.SQLUpdate("Update PhieuMuon Set "
                + " maThe='" + muonTra.getMaThe()
                + "', NgayMuon='" + muonTra.getNgayMuon()
                + "', thoiGianMuon=" + muonTra.getThoiGianMuon()
                + ", NgayTra='" + muonTra.getNgayTra()
                + "' where maPhieuMuon='" + muonTra.getMaPhieuMuon()+ "';");
        Boolean check_2 = DBMuonTra.SQLUpdate("DELETE FROM ChiTietPhieuMuon WHERE ChiTietPhieuNhap.maPhieuMuon = '" + muonTra.getMaPhieuMuon() + "';");
        for (int i=0; i<muonTra.getIDSach().size(); i++){
            Boolean check_3 = DBMuonTra.SQLUpdate("INSERT INTO ChiTietPhieuMuon(maPhieuMuon, IDSach) "
                    + "VALUES ('"
                    + muonTra.getMaPhieuMuon()+ "','"     
                    + muonTra.getIDSach().get(i)+ "');");
            if (!check_3){
                check_2 = false;
            }
        }
        DBMuonTra.closeConnection();
        return check & check_2;
    }
    
    public Boolean mod(String maPhieuMuon, String maThe, ArrayList <String> IDSach, String NgayMuon, int thoiGianMuon, String NgayTra){
        DBMuonTra = new DBConnection();
        Boolean check = DBMuonTra.SQLUpdate("Update PhieuMuon Set "
                + " maThe='" + maThe
                + "', NgayMuon='" + NgayMuon
                + "', thoiGianMuon=" + thoiGianMuon
                + ", NgayTra='" + NgayTra
                + "' where maPhieuMuon='" + maPhieuMuon+ "';");
        Boolean check_2 = DBMuonTra.SQLUpdate("DELETE FROM ChiTietPhieuMuon WHERE ChiTietPhieuNhap.maPhieuMuon = '" + maPhieuMuon + "';");
        for (int i=0; i<IDSach.size(); i++){
            Boolean check_3 = DBMuonTra.SQLUpdate("INSERT INTO ChiTietPhieuMuon(maPhieuMuon, IDSach) "
                    + "VALUES ('"
                    + maPhieuMuon+ "','"     
                    + IDSach.get(i)+ "');");
            if (!check_3){
                check_2 = false;
            }
        }
        DBMuonTra.closeConnection();
        return check;
    }
    
    // for Report
    public int soLuong_Sach_MaSach(String maSach, int month, int year){
        int res = 0;
        DBMuonTra = new DBConnection();
        try{
            String query = ""
                    + "SELECT COUNT(maSach) "
                    + "FROM `chitietphieumuon`, `phieumuon`, `chitietsach` "
                    + "WHERE `chitietphieumuon`.`maPhieuMuon` = `phieumuon`.`maPhieuMuon` AND"
                    + " `chitietphieumuon`.`IDSach` = `chitietsach`.`IDSach` AND "
                    + "MONTH(ngaytra) = " + month + " AND YEAR(ngaytra) = " + year + " AND maSach = '" + maSach + "'";
            ResultSet rs = DBMuonTra.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    res = rs.getInt("COUNT(maSach)");
                }
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Phiếu Mượn");
            res = -1;
        }
        finally{
            DBMuonTra.closeConnection();
        }
        return res;
    }
    
    //testing
//    public static void main(String[] args){
//        System.out.println(new QLPhieuMuonDAO().soLuong_Sach_MaSach("S000003", 2, 2020));
//    }
}

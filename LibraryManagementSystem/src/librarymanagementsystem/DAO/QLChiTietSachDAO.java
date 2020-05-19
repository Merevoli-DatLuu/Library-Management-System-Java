package librarymanagementsystem.DAO;

import librarymanagementsystem.Toolkit.*;
import librarymanagementsystem.DTO.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class QLChiTietSachDAO {
    DBConnection DBChiTietSach;
    
    public ArrayList<QLChiTietSachDTO> readDB(){
        DBChiTietSach = new DBConnection();
        ArrayList<QLChiTietSachDTO> arrChiTietSach = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM ChiTietSach";
            ResultSet rs = DBChiTietSach.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    String IDSach = rs.getString("IDSach");
                    String maSach = rs.getString("maSach");
                    String tinhTrang = rs.getString("tinhTrang");
                    arrChiTietSach.add(new QLChiTietSachDTO(IDSach, maSach, tinhTrang));
                }
            }

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Chi Tiết Sách");
        } 
        finally{
            DBChiTietSach.closeConnection();
        }
        return arrChiTietSach;
    }
    
    public ArrayList<QLChiTietSachDTO> readDB_full(){
        DBChiTietSach = new DBConnection();
        ArrayList<QLChiTietSachDTO> arrChiTietSach = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM ChiTietSach, LoaiSach WHERE ChiTietSach.maSach = LoaiSach.maSach";
            ResultSet rs = DBChiTietSach.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    String IDSach = rs.getString("IDSach");
                    String maSach = rs.getString("maSach");
                    String tinhTrang = rs.getString("tinhTrang");
                    String tenSach = rs.getString("tenSach");
                    String tenTacGia = rs.getString("tenTacGia");
                    String tenNXB = rs.getString("tenNXB");
                    String theLoai = rs.getString("theLoai");
                    String ngonNgu = rs.getString("ngonNgu");
                    String tomTatNoiDung = rs.getString("tomTatNoiDung");
                    int namXB = rs.getInt("namXB");
                    int giaTien = rs.getInt("giaTien");
                    int soTrang = rs.getInt("soTrang");
                    String hinh = rs.getString("hinhSach");
                    QLLoaiSachDTO sach = new QLLoaiSachDTO(maSach, tenSach, tenTacGia, tenNXB, theLoai, ngonNgu, tomTatNoiDung, namXB, giaTien, soTrang, hinh);
                    arrChiTietSach.add(new QLChiTietSachDTO(IDSach, maSach, tinhTrang, sach));
                }
            }

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Chi Tiết Sách");
        } 
        finally{
            DBChiTietSach.closeConnection();
        }
        return arrChiTietSach;
    }
    
    public Boolean add(QLChiTietSachDTO chiTietSach){
        DBChiTietSach = new DBConnection();
        Boolean check = DBChiTietSach.SQLUpdate("INSERT INTO chiTietSach(IDSach, maSach, tinhTrang) "
                + "VALUES ('"
                + chiTietSach.getIDSach()+ "','"  
                + chiTietSach.getMaSach()+ "','"  
                + chiTietSach.getTinhTrang()+ "');");
        DBChiTietSach.closeConnection();
        return check;
    }
    
     public Boolean del(String IDSach){
        Boolean check = DBChiTietSach.SQLUpdate("DELETE FROM chiTietSach WHERE chiTietSach.IDSach = '" + IDSach + "';");
        DBChiTietSach.closeConnection();
        return check;
    }
    
    public Boolean mod(QLChiTietSachDTO chiTietSach){
        DBChiTietSach = new DBConnection();
        Boolean check = DBChiTietSach.SQLUpdate("Update chiTietSach Set "
                + " maSach='" + chiTietSach.getMaSach()
                + "', tinhTrang='" + chiTietSach.getTinhTrang()
                + "' where IDSach='" + chiTietSach.getIDSach()+ "';");
        DBChiTietSach.closeConnection();
        return check;
    }
}

package librarymanagementsystem.DAO;

import librarymanagementsystem.Toolkit.*;
import librarymanagementsystem.DTO.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class QLKhoSachDAO {
    DBConnection DBKhoSach;
    
    public ArrayList<QLKhoSachDTO> readDB(){
        DBKhoSach = new DBConnection();
        ArrayList<QLKhoSachDTO> arrKhoSach = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM KhoSach";
            ResultSet rs = DBKhoSach.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    String maSach = rs.getString("maSach");
                    int soLuong = rs.getInt("soLuong");
                    arrKhoSach.add(new QLKhoSachDTO(maSach, soLuong));
                }
            }

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Kho Sách");
        } 
        finally{
            DBKhoSach.closeConnection();
        }
        return arrKhoSach;
    }
    
    // full view 'sach' X 'khosach'
    public ArrayList<QLKhoSachDTO> readDB_full(){
        DBKhoSach = new DBConnection();
        ArrayList<QLKhoSachDTO> arrKhoSach = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM KhoSach, LoaiSach Where KhoSach.maSach = LoaiSach.maSach";
            ResultSet rs = DBKhoSach.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    String maSach = rs.getString("maSach");
                    int soLuong = rs.getInt("soLuong");
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
                    arrKhoSach.add(new QLKhoSachDTO(maSach, soLuong, sach));
                }
            }

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Kho Sách");
        } 
        finally{
            DBKhoSach.closeConnection();
        }
        return arrKhoSach;
    }
    
    public Boolean add(QLKhoSachDTO khoSach){
        DBKhoSach = new DBConnection();
        Boolean check = DBKhoSach.SQLUpdate("INSERT INTO KhoSach(maSach, soLuong) "
                + "VALUES ('"
                + khoSach.getMaSach()+ "',"       
                + khoSach.getSoLuong()+ ");");
        DBKhoSach.closeConnection();
        return check;
    }
    
     public Boolean del(String maSach){
        DBKhoSach = new DBConnection();
        Boolean check = DBKhoSach.SQLUpdate("DELETE FROM KhoSach WHERE KhoSach.maSach = '" + maSach + "';");
        DBKhoSach.closeConnection();
        return check;
    }
    
    public Boolean mod(QLKhoSachDTO khoSach){
        DBKhoSach = new DBConnection();
        Boolean check = DBKhoSach.SQLUpdate("Update KhoSach Set "
                + " soLuong=" + khoSach.getSoLuong()
                + " where maSach='" + khoSach.getMaSach()+ "';");
        DBKhoSach.closeConnection();
        return check;
    }
}

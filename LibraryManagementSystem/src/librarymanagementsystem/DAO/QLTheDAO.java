package librarymanagementsystem.DAO;

import librarymanagementsystem.Toolkit.*;
import librarymanagementsystem.DTO.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class QLTheDAO {
    DBConnection DBThe;
    
    public ArrayList<QLTheDTO> readDB(){
        DBThe = new DBConnection();
        ArrayList<QLTheDTO> arrThe = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM The";
            ResultSet rs = DBThe.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    String maThe = rs.getString("maThe");
                    String maKhachHang = rs.getString("maKhachHang");
                    String ngayCap = rs.getString("ngayCap");
                    String ngayHetHan = rs.getString("ngayHetHan");
                    arrThe.add(new QLTheDTO(maThe, maKhachHang, ngayCap, ngayHetHan));
                }
            }

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Thẻ");
        } 
        finally{
            DBThe.closeConnection();
        }
        return arrThe;
    }
    
    // `the` X `khachhang`
    public ArrayList<QLTheDTO> readDB_full(){
        DBThe = new DBConnection();
        ArrayList<QLTheDTO> arrThe = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM The, khachHang WHERE The.makhachhang = khachHang.makhachhang";
            ResultSet rs = DBThe.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    String maThe = rs.getString("maThe");
                    String maKhachHang = rs.getString("maKhachHang");
                    String ngayCap = rs.getString("ngayCap");
                    String ngayHetHan = rs.getString("ngayHetHan");
                    String hoTen = rs.getString("hoTen");
                    String ngaySinh = rs.getString("ngaySinh");
                    String diaChi = rs.getString("diaChi");
                    String email = rs.getString("email");
                    String sdt = rs.getString("sdt");
                    QLKhachHangDTO khachHang = new QLKhachHangDTO(maKhachHang, hoTen, ngaySinh, diaChi, email, sdt);
                    arrThe.add(new QLTheDTO(maThe, maKhachHang, ngayCap, ngayHetHan, khachHang));
                }
            }

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Thẻ");
        } 
        finally{
            DBThe.closeConnection();
        }
        return arrThe;
    }
    
    public Boolean add(QLTheDTO the){
        DBThe = new DBConnection();
        Boolean check = DBThe.SQLUpdate("INSERT INTO The(maThe, maKhachHang, ngayCap, ngayHetHan) "
                + "VALUES ('"
                + the.getMaThe() + "','"     
                + the.getMaKhachHang() + "','"   
                + the.getNgayCap()+ "','"   
                + the.getNgayHetHan()+ "');");
        DBThe.closeConnection();
        return check;
    }
    
     public Boolean del(String maThe){
        DBThe = new DBConnection();
        Boolean check = DBThe.SQLUpdate("DELETE FROM The WHERE The.maThe = '" + maThe + "'");
        DBThe.closeConnection();
        return check;
    }
    
    public Boolean mod(QLTheDTO the){
        DBThe = new DBConnection();
        Boolean check = DBThe.SQLUpdate("Update The Set "
                + " maKhachHang='" + the.getMaKhachHang()
                + "', ngayCap='" + the.getNgayCap()
                + "', ngayHetHan='" + the.getNgayHetHan()
                + "' where maThe='" + the.getMaThe()+ "'");
        DBThe.closeConnection();
        return check;
    }
}

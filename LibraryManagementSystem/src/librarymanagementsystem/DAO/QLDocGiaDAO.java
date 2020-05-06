package librarymanagementsystem.DAO;

import librarymanagementsystem.Toolkit.*;
import librarymanagementsystem.DTO.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class QLDocGiaDAO {
    DBConnection DBDocGia;
    
    public ArrayList<QLDocGiaDTO> readDB(){
        DBDocGia = new DBConnection();
        ArrayList<QLDocGiaDTO> arrDocGia = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM KhachHang";
            ResultSet rs = DBDocGia.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    String maKhachHang = rs.getString("maKhachHang");
                    String hoTen = rs.getString("hoTen");
                    String ngaySinh = rs.getString("ngaySinh");
                    String diaChi = rs.getString("diaChi");
                    String email = rs.getString("email");
                    String maThe = rs.getString("maThe");
                    String sdt = rs.getString("sdt");
                    arrDocGia.add(new QLDocGiaDTO(maKhachHang, hoTen, ngaySinh, diaChi, email, maThe, sdt));
                }
            }

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Khách Hàng");
        } 
        finally{
            DBDocGia.closeConnection();
        }
        return arrDocGia;
    }
    
    public Boolean add(QLDocGiaDTO docGia){
        DBDocGia = new DBConnection();
        Boolean check = DBDocGia.SQLUpdate("INSERT INTO KhachHang(maKhachHang, hoTen, ngaySinh, diaChi, sdt, email, maThe) "
                + "VALUES ('"
                + docGia.getMaKhachHang()+ "','"  
                + docGia.getHoTen()+ "','"  
                + docGia.getNgaySinh()+ "','"  
                + docGia.getDiaChi()+ "',"  
                + docGia.getSdt()+ ",'"  
                + docGia.getEmail()+ "','"  
                + docGia.getMaThe()+ "');");
        DBDocGia.closeConnection();
        return check;
    }
    
     public Boolean del(String maKhachHang){
        Boolean check = DBDocGia.SQLUpdate("DELETE FROM KhachHang WHERE KhachHang.maKhachHang = '" + maKhachHang + "';");
        DBDocGia.closeConnection();
        return check;
    }
    
    public Boolean mod(QLDocGiaDTO docGia){
        DBDocGia = new DBConnection();
        Boolean check = DBDocGia.SQLUpdate("Update KhachHang Set "
                + " hoTen='" + docGia.getHoTen()
                + "', ngaySinh='" + docGia.getNgaySinh()
                + "', diaChi='" + docGia.getDiaChi()
                + "', sdt=" + docGia.getSdt()
                + ", email='" + docGia.getEmail()
                + "' maThe='" + docGia.getMaThe()
                + "' where maKhachHang='" + docGia.getMaKhachHang()+ "';");
        DBDocGia.closeConnection();
        return check;
    }
}

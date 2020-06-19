package librarymanagementsystem.DAO;

import librarymanagementsystem.Toolkit.*;
import librarymanagementsystem.DTO.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class QLNhanVienDAO {
    DBConnection DBNhanVien;
    
    public ArrayList<QLNhanVienDTO> readDB(){
        DBNhanVien = new DBConnection();
        ArrayList<QLNhanVienDTO> arrNhanVien = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM NhanVien";
            ResultSet rs = DBNhanVien.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    String maNhanVien = rs.getString("maNhanVien");
                    String password = rs.getString("password_hashed");
                    String hoTen = rs.getString("hoTen");
                    String ngaySinh = rs.getString("ngaySinh");
                    String diaChi = rs.getString("diaChi");
                    String email = rs.getString("email");
                    String chucVu = rs.getString("chucVu");
                    String sdt = rs.getString("sdt");
                    String RFID_code = rs.getString("RFID_code");
                    String salt = rs.getString("salt");
                    arrNhanVien.add(new QLNhanVienDTO(maNhanVien, password, hoTen, ngaySinh, diaChi, email, chucVu, sdt, RFID_code, salt));
                }
            }

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Nhân Viên");
        } 
        finally{
            DBNhanVien.closeConnection();
        }
        return arrNhanVien;
    }
    
    public Boolean add(QLNhanVienDTO nhanVien){
        DBNhanVien = new DBConnection();
        System.out.println("INSERT INTO NhanVien(maNhanVien, password_hashed, hoTen, ngaySinh, diaChi, sdt, email, chucVu, salt) "
                + "VALUES ('"
                + nhanVien.getMaNhanVien()+ "','"     
                + nhanVien.getPassword()+ "','"   
                + nhanVien.getHoTen()+ "','"   
                + nhanVien.getNgaySinh()+ "','"   
                + nhanVien.getDiaChi()+ "','"   
                + nhanVien.getSdt()+ "','"   
                + nhanVien.getEmail()+ "','"   
                + nhanVien.getChucVu()+ "','"
//                + new PasswordHashing().getSalt()+ "');");
                + nhanVien.getSalt()+ "');");
        Boolean check = DBNhanVien.SQLUpdate("INSERT INTO NhanVien(maNhanVien, password_hashed, hoTen, ngaySinh, diaChi, sdt, email, chucVu, salt) "
                + "VALUES ('"
                + nhanVien.getMaNhanVien()+ "','"     
                + nhanVien.getPassword()+ "','"   
                + nhanVien.getHoTen()+ "','"   
                + nhanVien.getNgaySinh()+ "','"   
                + nhanVien.getDiaChi()+ "','"   
                + nhanVien.getSdt()+ "','"   
                + nhanVien.getEmail()+ "','"   
                + nhanVien.getChucVu()+ "','"
                + nhanVien.getSalt()+ "');");
        DBNhanVien.closeConnection();
        return check;
    }
    
     public Boolean del(String maNhanVien){
        DBNhanVien = new DBConnection();
        Boolean check = DBNhanVien.SQLUpdate("DELETE FROM NhanVien WHERE NhanVien.maNhanVien = '" + maNhanVien + "'");
        DBNhanVien.closeConnection();
        return check;
    }
    
    public Boolean mod(QLNhanVienDTO nhanVien){
        DBNhanVien = new DBConnection();
        Boolean check = DBNhanVien.SQLUpdate("Update NhanVien Set "
                + " password_hashed='" + nhanVien.getPassword()
                + "', hoTen='" + nhanVien.getHoTen()
                + "', ngaySinh='" + nhanVien.getNgaySinh()
                + "', diaChi='" + nhanVien.getDiaChi()
                + "', sdt=" + nhanVien.getSdt()
                + ", email='" + nhanVien.getEmail()
                + "', chucVu='" + nhanVien.getChucVu()
                + "' where maNhanVien='" + nhanVien.getMaNhanVien()+ "'");
        DBNhanVien.closeConnection();
        return check;
    }
    
    public Boolean mod_RFID_code(String maNhanVien, String RFID_code){
        DBNhanVien = new DBConnection();
        Boolean check = DBNhanVien.SQLUpdate("Update NhanVien Set "
                + " RFID_code='" + RFID_code
                + "' where maNhanVien='" + maNhanVien+ "'");
        DBNhanVien.closeConnection();
        return check;
    }
    
    public static void main(String[] args) {
        new QLNhanVienDAO().add(new QLNhanVienDTO("QL000011", "", "", "2020-10-12", "", "", "", ""));
    }
}

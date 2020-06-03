package librarymanagementsystem.DAO;

import librarymanagementsystem.Toolkit.*;
import librarymanagementsystem.DTO.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class QLLoaiSachDAO {
    DBConnection DBSach;
    
    public ArrayList<QLLoaiSachDTO> readDB(){
        DBSach = new DBConnection();
        ArrayList<QLLoaiSachDTO> arrSach = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM LoaiSach";
            ResultSet rs = DBSach.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    String maSach = rs.getString("maSach");
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
                    arrSach.add(new QLLoaiSachDTO(maSach, tenSach, tenTacGia, tenNXB, theLoai, ngonNgu, tomTatNoiDung, namXB, giaTien, soTrang, hinh));
                }
            }

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Sách");
        } 
        finally{
            DBSach.closeConnection();
        }
        return arrSach;
    }
    
    public Boolean add(QLLoaiSachDTO sach){
        DBSach = new DBConnection();
        Boolean check = DBSach.SQLUpdate("INSERT INTO LoaiSach(maSach, tenSach, tenTacGia, tenNXB, namXB, theLoai, ngonNgu, tomTatNoiDung, giaTien, soTrang, hinhSach) "
                + "VALUES ('"
                + sach.getMaSach() + "', '"
                + sach.getTenSach() + "', '"
                + sach.getTenTacGia() + "','"
                + sach.getTenNXB() + "',"
                + sach.getNamXB() + ",'"
                + sach.getTheLoai() + "','"      
                + sach.getNgonNgu() + "','"      
                + sach.getTomTatNoiDung() + "',"   
                + sach.getGiaTien() + ","   
                + sach.getSoTrang() + ",'"
                + sach.getHinh() + "');");
        DBSach.closeConnection();
        return check;
    }
    
    public Boolean del(String maSach){
        DBSach = new DBConnection();
        Boolean check = DBSach.SQLUpdate("DELETE FROM LoaiSach WHERE LoaiSach.maSach = '" + maSach + "'");
        DBSach.closeConnection();
        return check;
    }
    
    public Boolean mod(QLLoaiSachDTO sach){
        DBSach = new DBConnection();
        Boolean check = DBSach.SQLUpdate("Update LoaiSach Set "
                + " tenSach='" + sach.getTenSach()
                + "', tenTacGia='" + sach.getTenTacGia()
                + "', tenNXB='" + sach.getTenNXB()
                + "', namXB=" + sach.getNamXB()
                + ", theLoai='" + sach.getTheLoai()
                + "', ngonNgu='" + sach.getNgonNgu()
                + "', tomTatNoiDung='" + sach.getTomTatNoiDung()
                + "', giaTien=" + sach.getGiaTien()
                + ", soTrang=" + sach.getSoTrang()
                + ", hinhSach='" + sach.getHinh()
                + "' where maSach='" + sach.getMaSach() + "'");
        DBSach.closeConnection();
        return check;
    }
    
    // Testing
    public static void main(String[] args){
        QLLoaiSachDTO loaisach = new QLLoaiSachDTO("S000028", "1231234", "213213", "213213", "123213213", "234234", "3241", 2123, 32423432, 123213213, "C:\\Users\\NTH\\Pictures\\aaasdd.png");
        new QLLoaiSachDAO().add(loaisach);
    }
}

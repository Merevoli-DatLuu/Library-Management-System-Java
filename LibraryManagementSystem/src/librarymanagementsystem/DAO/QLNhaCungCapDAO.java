package librarymanagementsystem.DAO;

import librarymanagementsystem.Toolkit.*;
import librarymanagementsystem.DTO.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class QLNhaCungCapDAO {
    DBConnection DBNhaCungCap;
    
    public ArrayList<QLNhaCungCapDTO> readDB(){
        DBNhaCungCap = new DBConnection();
        ArrayList<QLNhaCungCapDTO> arrNhaCungCap = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM nhaCungCap";
            ResultSet rs = DBNhaCungCap.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    String maNCC = rs.getString("maNCC");
                    String tenNCC = rs.getString("tenNCC");
                    String sdt = rs.getString("sdt");
                    String email = rs.getString("email");
                    String diaChi = rs.getString("diaChi");
                    arrNhaCungCap.add(new QLNhaCungCapDTO(maNCC, tenNCC, sdt, email, diaChi));
                }
            }

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Nhà Cung Cấp");
        } 
        finally{
            DBNhaCungCap.closeConnection();
        }
        return arrNhaCungCap;
    }
    
    public Boolean add(QLNhaCungCapDTO nhaCungCap){
        DBNhaCungCap = new DBConnection();
        Boolean check = DBNhaCungCap.SQLUpdate("INSERT INTO nhaCungCap(maNCC, tenNCC, sdt, email, diaChi) "
                + "VALUES ('"
                + nhaCungCap.getMaNCC()+ "','"  
                + nhaCungCap.getTenNCC()+ "','"  
                + nhaCungCap.getSdt()+ "','"  
                + nhaCungCap.getEmail()+ "','"  
                + nhaCungCap.getDiaChi()+ "');");
        DBNhaCungCap.closeConnection();
        return check;
    }
    
     public Boolean del(String maNCC){
        Boolean check = DBNhaCungCap.SQLUpdate("DELETE FROM nhaCungCap WHERE nhaCungCap.maNCC = '" + maNCC + "';");
        DBNhaCungCap.closeConnection();
        return check;
    }
    
    public Boolean mod(QLNhaCungCapDTO nhaCungCap){
        DBNhaCungCap = new DBConnection();
        Boolean check = DBNhaCungCap.SQLUpdate("Update nhaCungCap Set "
                + " tenNCC='" + nhaCungCap.getTenNCC()
                + "', sdt='" + nhaCungCap.getSdt()
                + "', email='" + nhaCungCap.getEmail()
                + "', diaChi='" + nhaCungCap.getDiaChi()
                + "' where maNCC='" + nhaCungCap.getMaNCC()+ "';");
        DBNhaCungCap.closeConnection();
        return check;
    }
}

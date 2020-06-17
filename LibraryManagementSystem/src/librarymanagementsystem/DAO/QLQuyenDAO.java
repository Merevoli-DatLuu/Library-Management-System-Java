package librarymanagementsystem.DAO;
import librarymanagementsystem.Toolkit.*;
import librarymanagementsystem.DTO.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class QLQuyenDAO {
    DBConnection DBQuyen;
    
    public ArrayList<QLQuyenDTO> readDB(){
        DBQuyen = new DBConnection();
        ArrayList<QLQuyenDTO> arrQuyen = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM quyen";
            ResultSet rs = DBQuyen.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    String maQuyen = rs.getString("maQuyen");
                    String tenQuyen = rs.getString("tenQuyen");
                    String chitietQuyen = rs.getString("chitietQuyen");
                    arrQuyen.add(new QLQuyenDTO(maQuyen, tenQuyen, chitietQuyen));
                }
            }

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Sách");
        } 
        finally{
            DBQuyen.closeConnection();
        }
        return arrQuyen;
    }
    
    public Boolean add(QLQuyenDTO quyen){
        DBQuyen = new DBConnection();
        Boolean check = DBQuyen.SQLUpdate("INSERT INTO Quyen(maQuyen, tenQuyen, chitietQuyen) "
                + "VALUES ('"
                + quyen.getMaQuyen() + "', '"
                + quyen.getTenQuyen() + "', '"
                + quyen.getChitietQuyen() + "');");
        DBQuyen.closeConnection();
        return check;
    }
    
    public Boolean del(String maQuyen){
        DBQuyen = new DBConnection();
        Boolean check = DBQuyen.SQLUpdate("DELETE FROM Quyen WHERE Quyen.maQuyen = '" + maQuyen + "'");
        DBQuyen.closeConnection();
        return check;
    }
    
    public Boolean mod(QLQuyenDTO quyen){
        DBQuyen = new DBConnection();
        Boolean check = DBQuyen.SQLUpdate("Update Quyen Set "
                + " tenQuyen='" + quyen.getTenQuyen()
                + "', chitietQuyen='" + quyen.getChitietQuyen()
                + "' where maQuyen='" + quyen.getMaQuyen() + "'");
        DBQuyen.closeConnection();
        return check;
    }
    
    // Testing
    public static void main(String[] args){
        QLQuyenDTO quyen = new QLQuyenDTO("Q000003", "1231234", "213213");
        new QLQuyenDAO().add(quyen);
    }
}

    


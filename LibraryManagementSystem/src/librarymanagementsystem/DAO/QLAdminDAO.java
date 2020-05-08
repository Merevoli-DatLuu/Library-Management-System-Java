package librarymanagementsystem.DAO;

import librarymanagementsystem.Toolkit.*;
import librarymanagementsystem.DTO.*;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class QLAdminDAO {
    DBConnection DBAdmin;
    
    public ArrayList<QLAdminDTO> readDB(){
        DBAdmin = new DBConnection();
        ArrayList<QLAdminDTO> arrAdmin = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM Admin";
            ResultSet rs = DBAdmin.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    String tkAdmin = rs.getString("tkAdmin");
                    String password = rs.getString("password");
                    arrAdmin.add(new QLAdminDTO(tkAdmin, password));
                }
            }

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Admin");
        } 
        finally{
            DBAdmin.closeConnection();
        }
        return arrAdmin;
    }
    
    public Boolean add(QLAdminDTO admin){
        DBAdmin = new DBConnection();
        Boolean check = DBAdmin.SQLUpdate("INSERT INTO Admin(tkAdmin, password) "
                + "VALUES ('"
                + admin.getTkAdmin() + "', '"
                + admin.getPassword() + ");");
        DBAdmin.closeConnection();
        return check;
    }
    
    public Boolean del(String tkAdmin){
        DBAdmin = new DBConnection();
        Boolean check = DBAdmin.SQLUpdate("DELETE FROM Admin WHERE Admin.tkAdmin = '" + tkAdmin + "'");
        DBAdmin.closeConnection();
        return check;
    }
    
    public Boolean mod(QLAdminDTO admin){
        DBAdmin = new DBConnection();
        Boolean check = DBAdmin.SQLUpdate("Update Admin Set "
                + "', password='" + admin.getTkAdmin()
                + " where maSach='" + admin.getPassword() + "'");
        DBAdmin.closeConnection();
        return check;
    }
}

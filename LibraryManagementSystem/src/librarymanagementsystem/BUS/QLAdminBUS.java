package librarymanagementsystem.BUS;

import librarymanagementsystem.DTO.*;
import librarymanagementsystem.DAO.*;
import java.util.ArrayList;

public class QLAdminBUS {
    private ArrayList<QLAdminDTO> arrAdmin = new ArrayList<>();
    private QLAdminDAO adminDAO = new QLAdminDAO();
    
    public QLAdminBUS(){
        arrAdmin = adminDAO.readDB();
    }
    
    public String[] getHeaders(){
        return new String[]{"Tài Khoản Admin", "password"};
    }
    
    // Trả về mã Admin, ko có trả về ""
    public String kiemTraTaiKhoan(String tk, String pass){
        for (QLAdminDTO e : arrAdmin){
            if (e.getTkAdmin().equals(tk) && e.getPassword().equals(pass)){
                return e.getTkAdmin();
            }
        }
        return "";
    }
    
    public Boolean add(QLAdminDTO admin){
        Boolean check = adminDAO.add(admin);
        
        if (check){
            arrAdmin.add(admin);
        }
        return check;
    }
    
    public Boolean add(String tkAdmin, String password){
        QLAdminDTO admin = new QLAdminDTO(tkAdmin, password);
        
        return this.add(admin);
    }
    
    public Boolean del(String tkAdmin){
        Boolean check = adminDAO.del(tkAdmin);
        
        if (check){
            for (QLAdminDTO admin : arrAdmin){
                if (admin.getTkAdmin().equals(tkAdmin)){
                    arrAdmin.remove(admin);
                    break;
                }
            }
        }
        
        return check;
    }
    
    public Boolean mod(QLAdminDTO admin){
        Boolean check = adminDAO.mod(admin);
        
        if (check){
            for (QLAdminDTO s : arrAdmin){
                if (s.getTkAdmin().equals(admin.getTkAdmin())){
                    arrAdmin.set(arrAdmin.indexOf(s), admin);
                    break;
                }
            }
        }
        
        return check;
    }
    
    public Boolean mod(String tkAdmin, String password){
        QLAdminDTO admin = new QLAdminDTO(tkAdmin, password);
        
        return this.mod(admin);
    }
}

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
    
    public void readDB(){
        arrAdmin = adminDAO.readDB();
    }
    
    public String[] getHeaders(){
        return new String[]{"Tài Khoản Admin", "password",  "RFID code"};
    }
    
    public QLAdminDTO getAdmin(String tkAdmin){
        for (QLAdminDTO e : arrAdmin){
            if (e.equals(tkAdmin)){
                return e;
            }
        }
        return null;
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
    
    public String kiemTraTaiKhoan_RFID_code(String RFID_code){
        for (QLAdminDTO e : arrAdmin){
            if (e.getRFID_code().equals(RFID_code)){
                return e.getTkAdmin();
            }
        }
        return "";
    }
    
    public ArrayList <QLAdminDTO> search (String column, String value){
        ArrayList <QLAdminDTO> result_search = new ArrayList <QLAdminDTO> ();
        for (QLAdminDTO e : arrAdmin){
            switch (column) {
                case "Tài Khoản Admin":
                    if (e.getTkAdmin().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                    break;
                case "password": // Bỏ cái này sau
                    if (e.getPassword().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                    break;
                case "RFID code":
                    if (e.getRFID_code().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                    break;
            }
        }
        return result_search;
    }
    
    public ArrayList <QLAdminDTO> search_all (String column, String value){
        ArrayList <QLAdminDTO> result_search = new ArrayList <QLAdminDTO> ();
        for (QLAdminDTO e : arrAdmin){
            if (e.getTkAdmin().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getPassword().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getRFID_code().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
        }
        return result_search;
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
    
    public Boolean add(String tkAdmin, String password, String RFID_code){
        QLAdminDTO admin = new QLAdminDTO(tkAdmin, password, RFID_code);
        
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
    
    public Boolean mod(String tkAdmin, String password, String RFID_code){
        QLAdminDTO admin = new QLAdminDTO(tkAdmin, password, RFID_code);
        
        return this.mod(admin);
    }
    
    public Boolean mod_RFID_code(String tkAdmin, String RFID_code){
        Boolean check = adminDAO.mod_RFID_code(tkAdmin, RFID_code);
        
        if (check){
            for (QLAdminDTO s : arrAdmin){
                if (s.getTkAdmin().equals(tkAdmin)){
                    arrAdmin.get(arrAdmin.indexOf(s)).setRFID_code(RFID_code);
                    break;
                }
            }
        }
        
        return check;
    }
}

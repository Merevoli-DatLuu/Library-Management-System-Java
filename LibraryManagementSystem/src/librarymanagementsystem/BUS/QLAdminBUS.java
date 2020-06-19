package librarymanagementsystem.BUS;

import librarymanagementsystem.DTO.*;
import librarymanagementsystem.DAO.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import librarymanagementsystem.Toolkit.PasswordHashing;

public class QLAdminBUS {
    private static ArrayList<QLAdminDTO> arrAdmin = new ArrayList<>();
    private QLAdminDAO adminDAO = new QLAdminDAO();
    
    public QLAdminBUS(){
        arrAdmin = adminDAO.readDB();
    }
    
    public QLAdminBUS(int i){
        if (arrAdmin.size() == 0){
            arrAdmin = adminDAO.readDB();
        }
    }
    
    public void readDB(){
        arrAdmin = adminDAO.readDB();
    }
    
    public String[] getHeaders(){
        return new String[]{"Tài Khoản Admin", "password",  "RFID code"};
    }
    
    // 0:string, 1:int, 2:date
    public int[] getHeadersType(){
        return new int[]{0, 0, 0};
    }
    
    public int findHeaderType(String header){
        for (int i=0; i<3; i++){
            if (getHeaders()[i].equals(header)){
                return getHeadersType()[i];
            }
        }
        System.err.println("header type not found");
        return -1;
    }
    
    public QLAdminDTO getAdmin(String tkAdmin){
        for (QLAdminDTO e : arrAdmin){
            if (e.getTkAdmin().equals(tkAdmin)){
                return e;
            }
        }
        return null;
    }
    
    public ArrayList <QLAdminDTO> getAdmin_full(ArrayList <String> tkAdmin){
        Set<String> set = new HashSet<String>();
        ArrayList <QLAdminDTO> res = new ArrayList<>();
        for (String e : tkAdmin){
            set.add(e);
        }
        
        for (QLAdminDTO e : arrAdmin){
            if (set.contains(e.getTkAdmin())){
                res.add(e);
            }
        }
        return res;
    }
    
    public ArrayList <String> getPKey(){
        ArrayList <String> Pkey = new ArrayList<>();
        for (QLAdminDTO e : arrAdmin){
            Pkey.add(e.getTkAdmin());
        }
        return Pkey;
    }
    
    // Trả về mã Admin, ko có trả về ""
//    public String kiemTraTaiKhoan(String tk, String pass){        // Cũ chưa hashed password
//        for (QLAdminDTO e : arrAdmin){
//            if (e.getTkAdmin().equals(tk) && e.getPassword().equals(pass)){
//                return e.getTkAdmin();
//            }
//        }
//        return "";
//    }
    
    public String kiemTraTaiKhoan(String tk, String pass){
        for (QLAdminDTO e : arrAdmin){
            if (e.getTkAdmin().equals(tk)){
                PasswordHashing t = new PasswordHashing();
                t.setSalt(e.getSalt());
                String passhashing = t.getHashedPassword(pass);
                if (passhashing.equals(e.getPassword())){
                    return e.getTkAdmin();
                }
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
    
    /*public ArrayList <QLAdminDTO> search (String column, String value){
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
    */
    
    public ArrayList <QLAdminDTO> search (String column, String value){
        ArrayList <QLAdminDTO> result_search = new ArrayList <QLAdminDTO> ();
        value = value.toLowerCase();
        switch (column) { // Dựa vào Headers
            case "Tài Khoản Admin":
                for (QLAdminDTO e : arrAdmin){
                    if (e.getTkAdmin().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "password": // Bỏ cái này sau
                for (QLAdminDTO e : arrAdmin){
                    if (e.getPassword().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "RFID code":
                for (QLAdminDTO e : arrAdmin){
                    if (e.getRFID_code().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
        }
        return result_search;
    }
    
    public ArrayList <QLAdminDTO> search_all (String value){
        ArrayList <QLAdminDTO> result_search = new ArrayList <QLAdminDTO> ();
        value = value.toLowerCase();
        for (QLAdminDTO e : arrAdmin){
            if (e.getTkAdmin().toLowerCase().contains(value)) {
                result_search.add(e);
            }
            else if (e.getPassword().toLowerCase().contains(value)) {
                result_search.add(e);
            }
            else if (e.getRFID_code().toLowerCase().contains(value)) {
                result_search.add(e);
            }
        }
        return result_search;
    }
    
    public ArrayList <QLAdminDTO> filter (ArrayList <String> PKey){
        ArrayList <QLAdminDTO> res_filter = new ArrayList <QLAdminDTO>(); 
        for (QLAdminDTO e : arrAdmin){
            if (PKey.contains(e.getTkAdmin())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public ArrayList <QLAdminDTO> filter (ArrayList <String> PKey, ArrayList <QLAdminDTO> arr){
        ArrayList <QLAdminDTO> res_filter = new ArrayList <QLAdminDTO>(); 
        for (QLAdminDTO e : arr){
            if (PKey.contains(e.getTkAdmin())){
                res_filter.add(e);
            }
        }
        return res_filter;
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

    public ArrayList<QLAdminDTO> getArrAdmin() {
        return arrAdmin;
    }
    
    
}

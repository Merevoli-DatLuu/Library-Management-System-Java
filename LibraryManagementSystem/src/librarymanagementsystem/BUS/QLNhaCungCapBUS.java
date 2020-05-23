package librarymanagementsystem.BUS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLNhaCungCapBUS {
    private ArrayList<QLNhaCungCapDTO> arrNhaCungCap = new ArrayList<>();
    private QLNhaCungCapDAO nhaCungCapDAO = new QLNhaCungCapDAO();

    public QLNhaCungCapBUS() {
        arrNhaCungCap= nhaCungCapDAO.readDB();
    }
    
    public String [] getHeader(){
        return new String[]{"Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Số Điện Thoại", "Email", "Địa Chỉ"};
    }
    
    public QLNhaCungCapDTO getNhaCungCap(String maNCC){
        for (QLNhaCungCapDTO e : arrNhaCungCap){
            if (e.equals(maNCC)){
                return e;
            }
        }
        return null;
    }
    
    public ArrayList <QLNhaCungCapDTO> getNhaCungCap_full(ArrayList <String> maNCC){
        Set<String> set = new HashSet<String>();
        ArrayList <QLNhaCungCapDTO> res = new ArrayList<>();
        for (String e : maNCC){
            set.add(e);
        }
        
        for (QLNhaCungCapDTO e : arrNhaCungCap){
            if (set.contains(e)){
                res.add(e);
            }
        }
        return res;
    }
    
    public ArrayList <String> getPKey(){
        ArrayList <String> Pkey = new ArrayList<>();
        for (QLNhaCungCapDTO e : arrNhaCungCap){
            Pkey.add(e.getMaNCC());
        }
        return Pkey;
    }
    
    public ArrayList <QLNhaCungCapDTO> search (String column, String value){
        ArrayList <QLNhaCungCapDTO> result_search = new ArrayList <QLNhaCungCapDTO> ();
        switch (column) { // Dựa vào Headers
            case "Mã Nhà Cung Cấp":
                for (QLNhaCungCapDTO e : arrNhaCungCap){
                    if (e.getMaNCC().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Tên Nhà Cung Cấp": 
                for (QLNhaCungCapDTO e : arrNhaCungCap){
                    if (e.getTenNCC().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Số Điện Thoại":
                for (QLNhaCungCapDTO e : arrNhaCungCap){
                    if (e.getSdt().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Email":
                for (QLNhaCungCapDTO e : arrNhaCungCap){
                    if (e.getEmail().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Địa Chỉ":
                for (QLNhaCungCapDTO e : arrNhaCungCap){
                    if (e.getDiaChi().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
        }
        return result_search;
    }
    
    public ArrayList <QLNhaCungCapDTO> search_all (String column, String value){
        ArrayList <QLNhaCungCapDTO> result_search = new ArrayList <QLNhaCungCapDTO> ();
        for (QLNhaCungCapDTO e : arrNhaCungCap){
            if (e.getMaNCC().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getTenNCC().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getSdt().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getEmail().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getDiaChi().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
        }
        return result_search;
    }
    
    public ArrayList <QLNhaCungCapDTO> filter (ArrayList <String> PKey){
        ArrayList <QLNhaCungCapDTO> res_filter = new ArrayList <QLNhaCungCapDTO>(); 
        for (QLNhaCungCapDTO e : arrNhaCungCap){
            if (PKey.contains(e.getMaNCC())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public ArrayList <QLNhaCungCapDTO> filter (ArrayList <String> PKey, ArrayList <QLNhaCungCapDTO> arr){
        ArrayList <QLNhaCungCapDTO> res_filter = new ArrayList <QLNhaCungCapDTO>(); 
        for (QLNhaCungCapDTO e : arr){
            if (PKey.contains(e.getMaNCC())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public Boolean add(QLNhaCungCapDTO nhaCungCap){
        Boolean check = nhaCungCapDAO.add(nhaCungCap);
        if (check){
            arrNhaCungCap.add(nhaCungCap);
        }
        return check;
    }
    
    public Boolean add(String maNCC, String tenNCC, String sdt, String email, String diaChi){
        QLNhaCungCapDTO nhaCungCap=new QLNhaCungCapDTO(maNCC, tenNCC, sdt, email, diaChi);
        return this.add(nhaCungCap);
    }
    
    public Boolean del(String maNCC){
        Boolean check = nhaCungCapDAO.del(maNCC);
        if (check){
            for (QLNhaCungCapDTO nhaCungCap : arrNhaCungCap){
                if (nhaCungCap.getMaNCC().equals(maNCC)){
                    arrNhaCungCap.remove(nhaCungCap);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean mod(QLNhaCungCapDTO nhaCungCap){
        Boolean check = nhaCungCapDAO.mod(nhaCungCap);  
        if (check){
            for (QLNhaCungCapDTO s : arrNhaCungCap){
                if (s.getMaNCC().equals(nhaCungCap.getMaNCC())){
                    arrNhaCungCap.set(arrNhaCungCap.indexOf(s), nhaCungCap);
                    break;
                }
            }
        } 
        return check;
    }
     
    public Boolean mod(String maNCC, String tenNCC, String sdt, String email, String diaChi){
        QLNhaCungCapDTO nhaCungCap=new QLNhaCungCapDTO(maNCC, tenNCC, sdt, email, diaChi);
        return this.mod(nhaCungCap);
    } 
}

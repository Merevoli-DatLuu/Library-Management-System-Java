package librarymanagementsystem.BUS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLNhaCungCapBUS {
    private static ArrayList<QLNhaCungCapDTO> arrNhaCungCap = new ArrayList<>();
    private QLNhaCungCapDAO nhaCungCapDAO = new QLNhaCungCapDAO();

    public QLNhaCungCapBUS() {
        arrNhaCungCap= nhaCungCapDAO.readDB();
    }
    
    public QLNhaCungCapBUS(int i){
        if (arrNhaCungCap.size() == 0){
            arrNhaCungCap= nhaCungCapDAO.readDB();
        }
    }
    
    public String [] getHeaders(){
        return new String[]{"Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Số Điện Thoại", "Email", "Địa Chỉ"};
    }
    
    // 0:string, 1:int, 2:date
    public int[] getHeadersType(){
        return new int[]{0, 0, 0, 0, 0};
    }
    
    public int findHeaderType(String header){
        for (int i=0; i<5; i++){
            if (getHeaders()[i].equals(header)){
                return getHeadersType()[i];
            }
        }
        System.err.println("header type not found");
        return -1;
    }
    
    public QLNhaCungCapDTO getNhaCungCap(String maNCC){
        for (QLNhaCungCapDTO e : arrNhaCungCap){
            if (e.getMaNCC().equals(maNCC)){
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
            if (set.contains(e.getMaNCC())){
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
        value = value.toLowerCase();
        switch (column) { // Dựa vào Headers
            case "Mã Nhà Cung Cấp":
                for (QLNhaCungCapDTO e : arrNhaCungCap){
                    if (e.getMaNCC().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Tên Nhà Cung Cấp": 
                for (QLNhaCungCapDTO e : arrNhaCungCap){
                    if (e.getTenNCC().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Số Điện Thoại":
                for (QLNhaCungCapDTO e : arrNhaCungCap){
                    if (e.getSdt().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Email":
                for (QLNhaCungCapDTO e : arrNhaCungCap){
                    if (e.getEmail().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Địa Chỉ":
                for (QLNhaCungCapDTO e : arrNhaCungCap){
                    if (e.getDiaChi().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
        }
        return result_search;
    }
    
    public ArrayList <QLNhaCungCapDTO> search_all (String column, String value){
        ArrayList <QLNhaCungCapDTO> result_search = new ArrayList <QLNhaCungCapDTO> ();
        value = value.toLowerCase();
        for (QLNhaCungCapDTO e : arrNhaCungCap){
            if (e.getMaNCC().toLowerCase().contains(value)) {
                result_search.add(e);
            }
            else if (e.getTenNCC().toLowerCase().contains(value)) {
                result_search.add(e);
            }
            else if (e.getSdt().toLowerCase().contains(value)) {
                result_search.add(e);
            }
            else if (e.getEmail().toLowerCase().contains(value)) {
                result_search.add(e);
            }
            else if (e.getDiaChi().toLowerCase().contains(value)) {
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

    public ArrayList<QLNhaCungCapDTO> getArrNhaCungCap() {
        return arrNhaCungCap;
    }
    
    
}

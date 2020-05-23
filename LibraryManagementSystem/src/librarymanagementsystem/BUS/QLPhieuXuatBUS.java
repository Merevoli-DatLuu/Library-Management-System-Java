package librarymanagementsystem.BUS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLPhieuXuatBUS {
    private ArrayList<QLPhieuXuatDTO> arrXuatKho = new ArrayList<>();
    private QLPhieuXuatDAO xuatKhoDAO = new QLPhieuXuatDAO();

    public QLPhieuXuatBUS() {
        arrXuatKho= xuatKhoDAO.readDB();
    }
    
    public String [] getHeader(){
        return new String[]{"Mã Xuất Kho", "Ngày Xuất", "Mã Sách", "Số Lượng"};
    }
    
    public QLPhieuXuatDTO getPhieuXuat(String maXuat){
        for (QLPhieuXuatDTO e : arrXuatKho){
            if (e.equals(maXuat)){
                return e;
            }
        }
        return null;
    }
    
    public ArrayList <QLPhieuXuatDTO> getPhieuXuat_full(ArrayList <String> maXuat){
        Set<String> set = new HashSet<String>();
        ArrayList <QLPhieuXuatDTO> res = new ArrayList<>();
        for (String e : maXuat){
            set.add(e);
        }
        
        for (QLPhieuXuatDTO e : arrXuatKho){
            if (set.contains(e)){
                res.add(e);
            }
        }
        return res;
    }
    
    public ArrayList <String> getPKey(){
        ArrayList <String> Pkey = new ArrayList<>();
        for (QLPhieuXuatDTO e : arrXuatKho){
            Pkey.add(e.getMaXuat());
        }
        return Pkey;
    }
    
    public ArrayList <QLPhieuXuatDTO> search (String column, String value){
        ArrayList <QLPhieuXuatDTO> result_search = new ArrayList <QLPhieuXuatDTO> ();
        switch (column) { // Dựa vào Headers
            case "Mã Xuất Kho":
                for (QLPhieuXuatDTO e : arrXuatKho){
                    if (e.getMaXuat().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Ngày Xuất": 
                for (QLPhieuXuatDTO e : arrXuatKho){
                    if (e.getNgayXuat().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Mã Sách":
                for (QLPhieuXuatDTO e : arrXuatKho){
                    if (e.getMaSach().toString().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Số Lượng":
                for (QLPhieuXuatDTO e : arrXuatKho){
                    if (e.getSoLuong().toString().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
        }
        return result_search;
    }
    
    public ArrayList <QLPhieuXuatDTO> search_all (String column, String value){
        ArrayList <QLPhieuXuatDTO> result_search = new ArrayList <QLPhieuXuatDTO> ();
        for (QLPhieuXuatDTO e : arrXuatKho){
            if (e.getMaXuat().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getNgayXuat().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getMaSach().toArray().equals(value)) {
                result_search.add(e);
            }
            else if (e.getSoLuong().toString().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
        }
        return result_search;
    }
    
    public ArrayList <QLPhieuXuatDTO> filter (ArrayList <String> PKey){
        ArrayList <QLPhieuXuatDTO> res_filter = new ArrayList <QLPhieuXuatDTO>(); 
        for (QLPhieuXuatDTO e : arrXuatKho){
            if (PKey.contains(e.getMaXuat())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public ArrayList <QLPhieuXuatDTO> filter (ArrayList <String> PKey, ArrayList <QLPhieuXuatDTO> arr){
        ArrayList <QLPhieuXuatDTO> res_filter = new ArrayList <QLPhieuXuatDTO>(); 
        for (QLPhieuXuatDTO e : arr){
            if (PKey.contains(e.getMaXuat())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public Boolean add(QLPhieuXuatDTO xuatKho){
        Boolean check = xuatKhoDAO.add(xuatKho);
        if (check){
            arrXuatKho.add(xuatKho);
        }
        return check;
    }
    
    public Boolean add(String maXuat, String ngayXuat, ArrayList <String> maSach, ArrayList <Integer> soLuong, String maNhanVien){
        QLPhieuXuatDTO xuatKho=new QLPhieuXuatDTO(maXuat, ngayXuat, maSach, soLuong, maNhanVien);
        return this.add(xuatKho);
    }
    
    public Boolean del(String maXuat){
        Boolean check = xuatKhoDAO.del(maXuat);
        if (check){
            for (QLPhieuXuatDTO xuatKho : arrXuatKho){
                if (xuatKho.getMaXuat().equals(maXuat)){
                    arrXuatKho.remove(xuatKho);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean mod(QLPhieuXuatDTO xuatKho){
        Boolean check = xuatKhoDAO.mod(xuatKho);  
        if (check){
            for (QLPhieuXuatDTO s : arrXuatKho){
                if (s.getMaXuat().equals(xuatKho.getMaXuat())){
                    arrXuatKho.set(arrXuatKho.indexOf(s), xuatKho);
                    break;
                }
            }
        } 
        return check;
    }
     
    public Boolean mod(String maXuat, String ngayXuat, ArrayList <String> maSach, ArrayList <Integer> soLuong, String maNhanVien){
        QLPhieuXuatDTO xuatKho=new QLPhieuXuatDTO(maXuat, ngayXuat, maSach, soLuong, maNhanVien);
        return this.mod(xuatKho);
    } 

    public ArrayList<QLPhieuXuatDTO> getArrXuatKho() {
        return arrXuatKho;
    }
    
    
}

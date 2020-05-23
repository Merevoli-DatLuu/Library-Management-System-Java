package librarymanagementsystem.BUS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLPhieuNhapBUS {
    private ArrayList<QLPhieuNhapDTO> arrNhapKho = new ArrayList<>();
    private QLPhieuNhapDAO nhapKhoDAO = new QLPhieuNhapDAO();

    public QLPhieuNhapBUS() {
        arrNhapKho= nhapKhoDAO.readDB();
    }
    
    public String [] getHeader(){
        return new String[]{"Mã Nhập Kho", "Ngày Nhập", "Mã Sách", "Số Lượng"};
    }
    
    public QLPhieuNhapDTO getPhieuNhap(String maNhap){
        for (QLPhieuNhapDTO e : arrNhapKho){
            if (e.equals(maNhap)){
                return e;
            }
        }
        return null;
    }
    
    public ArrayList <QLPhieuNhapDTO> getPhieuNhap_full(ArrayList <String> maPhieuNhap){
        Set<String> set = new HashSet<String>();
        ArrayList <QLPhieuNhapDTO> res = new ArrayList<>();
        for (String e : maPhieuNhap){
            set.add(e);
        }
        
        for (QLPhieuNhapDTO e : arrNhapKho){
            if (set.contains(e)){
                res.add(e);
            }
        }
        return res;
    }
    
    public ArrayList <String> getPKey(){
        ArrayList <String> Pkey = new ArrayList<>();
        for (QLPhieuNhapDTO e : arrNhapKho){
            Pkey.add(e.getMaNhap());
        }
        return Pkey;
    }
    
    public ArrayList <QLPhieuNhapDTO> search (String column, String value){
        ArrayList <QLPhieuNhapDTO> result_search = new ArrayList <QLPhieuNhapDTO> ();
        switch (column) { // Dựa vào Headers
            case "Mã Nhập Kho":
                for (QLPhieuNhapDTO e : arrNhapKho){
                    if (e.getMaNhap().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Ngày Nhập": 
                for (QLPhieuNhapDTO e : arrNhapKho){
                    if (e.getNgayNhap().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Mã Sách":
                for (QLPhieuNhapDTO e : arrNhapKho){
                    String masach=String.valueOf(e.getMaSach());
                    if (masach.toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Số Lượng":
                for (QLPhieuNhapDTO e : arrNhapKho){
                    String soluong=String.valueOf(e.getSoLuong());
                    if (soluong.toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
        }
        return result_search;
    }
    
    public ArrayList <QLPhieuNhapDTO> search_all (String column, String value){
        ArrayList <QLPhieuNhapDTO> result_search = new ArrayList <QLPhieuNhapDTO> ();
        for (QLPhieuNhapDTO e : arrNhapKho){
            String masach=String.valueOf(e.getMaSach());
            String soluong=String.valueOf(e.getSoLuong());
            if (e.getMaNhap().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getNgayNhap().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (masach.toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (soluong.toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
        }
        return result_search;
    }
    
    public ArrayList <QLPhieuNhapDTO> filter (ArrayList <String> PKey){
        ArrayList <QLPhieuNhapDTO> res_filter = new ArrayList <QLPhieuNhapDTO>(); 
        for (QLPhieuNhapDTO e : arrNhapKho){
            if (PKey.contains(e.getMaNhap())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public ArrayList <QLPhieuNhapDTO> filter (ArrayList <String> PKey, ArrayList <QLPhieuNhapDTO> arr){
        ArrayList <QLPhieuNhapDTO> res_filter = new ArrayList <QLPhieuNhapDTO>(); 
        for (QLPhieuNhapDTO e : arr){
            if (PKey.contains(e.getMaNhap())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public Boolean add(QLPhieuNhapDTO nhapKho){
        Boolean check = nhapKhoDAO.add(nhapKho);
        if (check){
            arrNhapKho.add(nhapKho);
        }
        return check;
    }
    
    public Boolean add(String maNhap, String ngayNhap, ArrayList <String> maSach, ArrayList <Integer> soLuong, String maNhanVien, String maNCC){
        QLPhieuNhapDTO nhapKho=new QLPhieuNhapDTO(maNhap, ngayNhap, maSach, soLuong, maNhanVien, maNCC);
        return this.add(nhapKho);
    }
    
    public Boolean del(String maNhap){
        Boolean check = nhapKhoDAO.del(maNhap);
        if (check){
            for (QLPhieuNhapDTO nhapKho : arrNhapKho){
                if (nhapKho.getMaNhap().equals(maNhap)){
                    arrNhapKho.remove(nhapKho);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean mod(QLPhieuNhapDTO nhapKho){
        Boolean check = nhapKhoDAO.mod(nhapKho);  
        if (check){
            for (QLPhieuNhapDTO s : arrNhapKho){
                if (s.getMaNhap().equals(nhapKho.getMaNhap())){
                    arrNhapKho.set(arrNhapKho.indexOf(s), nhapKho);
                    break;
                }
            }
        } 
        return check;
    }
     
    public Boolean mod(String maNhap, String ngayNhap, ArrayList <String> maSach, ArrayList <Integer> soLuong, String maNhanVien, String maNCC){
        QLPhieuNhapDTO nhapKho=new QLPhieuNhapDTO(maNhap, ngayNhap, maSach, soLuong, maNhanVien, maNCC);
        return this.mod(nhapKho);
    } 

    public ArrayList<QLPhieuNhapDTO> getArrNhapKho() {
        return arrNhapKho;
    }
    
    
}

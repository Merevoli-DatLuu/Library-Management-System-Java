package librarymanagementsystem.BUS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLPhieuNhapBUS {
    private static ArrayList<QLPhieuNhapDTO> arrNhapKho = new ArrayList<>();
    private QLPhieuNhapDAO nhapKhoDAO = new QLPhieuNhapDAO();

    public QLPhieuNhapBUS() {
        arrNhapKho= nhapKhoDAO.readDB();
    }
    
    public QLPhieuNhapBUS(int i){
        if (arrNhapKho.size() == 0){
            arrNhapKho = nhapKhoDAO.readDB();
        }
    }
    
    public String [] getHeaders(){
        return new String[]{"Mã Nhập Kho", "Ngày Nhập", "Mã Nhân Viên", "Mã Nhà Cung Cấp", "Mã Sách", "Tổng Số Lượng", "Tổng Tiền"};
    }
    
    // 0:string, 1:int, 2:date
    public int[] getHeadersType(){
        return new int[]{0, 0, 0, 0, 0, 1, 1};
    }
    
    public int findHeaderType(String header){
        for (int i=0; i<7; i++){
            if (getHeaders()[i].equals(header)){
                return getHeadersType()[i];
            }
        }
        System.err.println("header type not found");
        return -1;
    }
    
    public QLPhieuNhapDTO getPhieuNhap(String maNhap){
        for (QLPhieuNhapDTO e : arrNhapKho){
            if (e.getMaNhap().equals(maNhap)){
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
            if (set.contains(e.getMaNhap())){
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
        value = value.toLowerCase();
        switch (column) { // Dựa vào Headers
            case "Mã Nhập Kho":
                for (QLPhieuNhapDTO e : arrNhapKho){
                    if (e.getMaNhap().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Ngày Nhập": 
                for (QLPhieuNhapDTO e : arrNhapKho){
                    if (e.getNgayNhap().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Mã Nhân Viên": 
                for (QLPhieuNhapDTO e : arrNhapKho){
                    if (e.getNgayNhap().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Mã Nhà Cung Cấp": 
                for (QLPhieuNhapDTO e : arrNhapKho){
                    if (e.getNgayNhap().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Mã Sách":
                for (QLPhieuNhapDTO e : arrNhapKho){
                    if (e.getMaSach().toString().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Tổng Số Lượng":
                for (QLPhieuNhapDTO e : arrNhapKho){
                    if (Integer.toString(e.getTongSoLuong()).toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Tổng Tiền":
                for (QLPhieuNhapDTO e : arrNhapKho){
                    if (Integer.toString(e.getTongTien()).toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
        }
        return result_search;
    }
    
    public ArrayList <QLPhieuNhapDTO> search_all (String value){
        ArrayList <QLPhieuNhapDTO> result_search = new ArrayList <QLPhieuNhapDTO> ();
        value = value.toLowerCase();
        for (QLPhieuNhapDTO e : arrNhapKho){
            if (e.getMaNhap().toLowerCase().contains(value)) {
                result_search.add(e);
            }
            else if (e.getNgayNhap().toLowerCase().contains(value)) {
                result_search.add(e);
            }
            else if (e.getMaNhanVien().toLowerCase().contains(value)) {
                result_search.add(e);
            }
            else if (e.getMaNCC().toLowerCase().contains(value)) {
                result_search.add(e);
            }
            else if (Integer.toString(e.getTongSoLuong()).toLowerCase().contains(value)) {
                result_search.add(e);
            }
            else if (Integer.toString(e.getTongTien()).toLowerCase().contains(value)) {
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
    
    public Boolean add(String maNhap, String ngayNhap, ArrayList <String> maSach, ArrayList <Integer> soLuong, String maNhanVien, String maNCC, int tongSoLuong, int tongTien){
        QLPhieuNhapDTO nhapKho=new QLPhieuNhapDTO(maNhap, ngayNhap, maSach, soLuong, maNhanVien, maNCC, tongSoLuong, tongTien);
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
     
    public Boolean mod(String maNhap, String ngayNhap, ArrayList <String> maSach, ArrayList <Integer> soLuong, String maNhanVien, String maNCC, int tongSoLuong, int tongTien){
        QLPhieuNhapDTO nhapKho=new QLPhieuNhapDTO(maNhap, ngayNhap, maSach, soLuong, maNhanVien, maNCC, tongSoLuong, tongTien);
        return this.mod(nhapKho);
    } 

    public ArrayList<QLPhieuNhapDTO> getArrNhapKho() {
        return arrNhapKho;
    }
    
    
}

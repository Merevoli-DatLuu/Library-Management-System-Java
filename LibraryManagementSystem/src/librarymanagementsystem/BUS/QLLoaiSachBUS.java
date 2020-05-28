package librarymanagementsystem.BUS;

import librarymanagementsystem.DTO.*;
import librarymanagementsystem.DAO.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class QLLoaiSachBUS {
    private static ArrayList<QLLoaiSachDTO> arrSach = new ArrayList<>();
    private QLLoaiSachDAO sachDAO = new QLLoaiSachDAO();
    
    public QLLoaiSachBUS(){
        arrSach = sachDAO.readDB();
    }
    
    public String[] getHeaders(){
        return new String[]{"Mã Sách", "Bìa Sách", "Tên Sách", "Tên Tác Giả", "Tên NXB", "Thể Loại", "Ngôn Ngữ", "Tóm Tắt Nội Dung", "Năm Xuất Bản", "Giá Tiền", "Số Trang"};
    }
    
    public QLLoaiSachDTO getLoaiSach(String maSach){
        for (QLLoaiSachDTO e : arrSach){
            if (e.equals(maSach)){
                return e;
            }
        }
        return null;
    }
    
    public ArrayList <QLLoaiSachDTO> getLoaiSach_full(ArrayList <String> maSach){
        Set<String> set = new HashSet<String>();
        ArrayList <QLLoaiSachDTO> res = new ArrayList<>();
        for (String e : maSach){
            set.add(e);
        }
        
        for (QLLoaiSachDTO e : arrSach){
            if (set.contains(e)){
                res.add(e);
            }
        }
        return res;
    }
    
    public ArrayList <String> getPKey(){
        ArrayList <String> Pkey = new ArrayList<>();
        for (QLLoaiSachDTO e : arrSach){
            Pkey.add(e.getMaSach());
        }
        return Pkey;
    }
    
    public ArrayList <QLLoaiSachDTO> search (String column, String value){
        ArrayList <QLLoaiSachDTO> result_search = new ArrayList <QLLoaiSachDTO> ();
        switch (column) { // Dựa vào Headers
            case "Mã Sách ":
                for (QLLoaiSachDTO e : arrSach){
                    if (e.getMaSach().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Bìa Sách": 
                for (QLLoaiSachDTO e : arrSach){
                    if (e.getHinh().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Tên Sách":
                for (QLLoaiSachDTO e : arrSach){
                    if (e.getTenSach().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Tên Tác Giả":
                for (QLLoaiSachDTO e : arrSach){
                    if (e.getTenTacGia().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Tên NXB":
                for (QLLoaiSachDTO e : arrSach){
                    if (e.getTenNXB().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Thể Loại":
                for (QLLoaiSachDTO e : arrSach){
                    if (e.getTheLoai().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Ngôn Ngữ":
                for (QLLoaiSachDTO e : arrSach){
                    if (e.getNgonNgu().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Tóm Tắt Nội Dung":
                for (QLLoaiSachDTO e : arrSach){
                    if (e.getTomTatNoiDung().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Năm Xuất Bản":
                for (QLLoaiSachDTO e : arrSach){
                    String namXB=String.valueOf(e.getNamXB());
                    if (namXB.toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Giá Tiền":
                for (QLLoaiSachDTO e : arrSach){
                    String giaTien=String.valueOf(e.getGiaTien());
                    if (giaTien.toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Số Trang":
                for (QLLoaiSachDTO e : arrSach){
                    String soTrang=String.valueOf(e.getSoTrang());
                    if (soTrang.toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
        }
        return result_search;
    }
    
    public ArrayList <QLLoaiSachDTO> search_all (String column, String value){
        ArrayList <QLLoaiSachDTO> result_search = new ArrayList <QLLoaiSachDTO> ();
        for (QLLoaiSachDTO e : arrSach){
            String namXB=String.valueOf(e.getNamXB());
            String giaTien=String.valueOf(e.getGiaTien());
            String soTrang=String.valueOf(e.getSoTrang());
            if (e.getMaSach().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getHinh().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getTenSach().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getTenTacGia().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getTenNXB().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getTheLoai().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getNgonNgu().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getTomTatNoiDung().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (namXB.toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (giaTien.toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (soTrang.toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
        }
        return result_search;
    }
    
    public ArrayList <QLLoaiSachDTO> filter (ArrayList <String> PKey){
        ArrayList <QLLoaiSachDTO> res_filter = new ArrayList <QLLoaiSachDTO>(); 
        for (QLLoaiSachDTO e : arrSach){
            if (PKey.contains(e.getMaSach())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public ArrayList <QLLoaiSachDTO> filter (ArrayList <String> PKey, ArrayList <QLLoaiSachDTO> arr){
        ArrayList <QLLoaiSachDTO> res_filter = new ArrayList <QLLoaiSachDTO>(); 
        for (QLLoaiSachDTO e : arr){
            if (PKey.contains(e.getMaSach())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public void show(){
        for (QLLoaiSachDTO sach : arrSach){
            System.out.println(sach.getMaSach() + '\t' + sach.getTenSach());
        }
    }
            
    public Boolean add(QLLoaiSachDTO sach){
        Boolean check = sachDAO.add(sach);
        
        if (check){
            arrSach.add(sach);
        }
        return check;
    }
    
    public Boolean add(String maSach, String tenSach, String tenTacGia, String tenNXB, String theLoai, String ngonNgu, String tomTatNoiDung, int namXB, int giaTien, int soTrang, String hinh){
        QLLoaiSachDTO sach = new QLLoaiSachDTO(maSach, tenSach, tenTacGia, tenNXB, theLoai, ngonNgu, tomTatNoiDung, namXB, giaTien, soTrang, hinh);
        
        return this.add(sach);
    }
    
    public Boolean del(String maSach){
        Boolean check = sachDAO.del(maSach);
        
        if (check){
            for (QLLoaiSachDTO sach : arrSach){
                if (sach.getMaSach().equals(maSach)){
                    arrSach.remove(sach);
                    break;
                }
            }
        }
        
        return check;
    }
    
    public Boolean mod(QLLoaiSachDTO sach){
        Boolean check = sachDAO.mod(sach);
        
        if (check){
            for (QLLoaiSachDTO s : arrSach){
                if (s.getMaSach().equals(sach.getMaSach())){
                    arrSach.set(arrSach.indexOf(s), sach);
                    break;
                }
            }
        }
        
        return check;
    }
    
    public Boolean mod(String maSach, String tenSach, String tenTacGia, String tenNXB, String theLoai, String ngonNgu, String tomTatNoiDung, int namXB, int giaTien, int soTrang, String hinh){
        QLLoaiSachDTO sach = new QLLoaiSachDTO(maSach, tenSach, tenTacGia, tenNXB, theLoai, ngonNgu, tomTatNoiDung, namXB, giaTien, soTrang, hinh);
        
        return this.mod(sach);
    }

    public ArrayList<QLLoaiSachDTO> getArrSach() {
        return arrSach;
    }
    
    
}

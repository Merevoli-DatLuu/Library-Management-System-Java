package librarymanagementsystem.BUS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLChiTietSachBUS {
    private static ArrayList<QLChiTietSachDTO> arrChiTietSach = new ArrayList<>();
    private QLChiTietSachDAO chiTietSachDAO = new QLChiTietSachDAO();

    public QLChiTietSachBUS() {
        arrChiTietSach= chiTietSachDAO.readDB();
    }
    
    public QLChiTietSachBUS(int i){
        if (arrChiTietSach.size() == 0){
            arrChiTietSach = chiTietSachDAO.readDB();
        }
    }
    
    public void readDB(){
        arrChiTietSach= chiTietSachDAO.readDB();
    }
    
    // for full view 
    public void readDB_full(){
        arrChiTietSach = chiTietSachDAO.readDB_full();
    }
    
    public String [] getHeaders(){
        return new String[]{"ID Sách", "Mã Sách", "Tình Trạng"};
    }
    
    public String [] getHeader_full(){
        return new String[]{"ID Sách", "Bìa Sách", "Mã Sách", "Tình Trạng", "Tên Sách", "Tên Tác Giả", "Tên NXB", "Thể Loại", "Ngôn Ngữ", "Tóm Tắt Nội Dung", "Năm Xuất Bản", "Giá Tiền", "Số Trang"};
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
    
    public QLChiTietSachDTO getChiTietSach(String IDSach){
        for (QLChiTietSachDTO e : arrChiTietSach){
            if (e.getIDSach().equals(IDSach)){
                return e;
            }
        }
        return null;
    }
    
    public ArrayList <QLChiTietSachDTO> getChiTietSach_full(ArrayList <String> IDSach){
        Set<String> set = new HashSet<String>();
        ArrayList <QLChiTietSachDTO> res = new ArrayList<>();
        for (String e : IDSach){
            set.add(e);
        }
        
        for (QLChiTietSachDTO e : arrChiTietSach){
            if (set.contains(e.getIDSach())){
                res.add(e);
            }
        }
        return res;
    }
    
    public ArrayList <String> getPKey(){
        ArrayList <String> Pkey = new ArrayList<>();
        for (QLChiTietSachDTO e : arrChiTietSach){
            Pkey.add(e.getIDSach());
        }
        return Pkey;
    }
    
    public ArrayList <QLChiTietSachDTO> search (String column, String value){
        ArrayList <QLChiTietSachDTO> result_search = new ArrayList <QLChiTietSachDTO> ();
        value = value.toLowerCase();
        switch (column) { // Dựa vào Headers
            case "ID Sách":
                for (QLChiTietSachDTO e : arrChiTietSach){
                    if (e.getIDSach().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Mã Sách": 
                for (QLChiTietSachDTO e : arrChiTietSach){
                    if (e.getMaSach().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Tình Trạng":
                for (QLChiTietSachDTO e : arrChiTietSach){
                    if (e.getTinhTrang().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
        }
        return result_search;
    }
    
    /*public ArrayList <QLChiTietSachDTO> search_full (String column, String value){
        ArrayList <QLChiTietSachDTO> result_search = new ArrayList <QLChiTietSachDTO> ();
        switch (column) { // Dựa vào Headers
            case "ID Sách":
                for (QLChiTietSachDTO e : arrChiTietSach){
                    if (e.getIDSach().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Mã Sách": // Bỏ cái này sau
                for (QLChiTietSachDTO e : arrChiTietSach){
                    if (e.getMaSach().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Tình Trạng":
                for (QLChiTietSachDTO e : arrChiTietSach){
                    if (e.getTinhTrang().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Sách":
                for (QLChiTietSachDTO e : arrChiTietSach){
                    if (e.getSach().toLowerCase(Locale.getDefault()).compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
        }
        return result_search;
    }*/
    
    public ArrayList <QLChiTietSachDTO> search_all (String column, String value){
        ArrayList <QLChiTietSachDTO> result_search = new ArrayList <QLChiTietSachDTO> ();
        value = value.toLowerCase();
        for (QLChiTietSachDTO e : arrChiTietSach){
            if (e.getIDSach().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getMaSach().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getTinhTrang().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
        }
        return result_search;
    }
    
    public ArrayList <QLChiTietSachDTO> filter (ArrayList <String> PKey){
        ArrayList <QLChiTietSachDTO> res_filter = new ArrayList <QLChiTietSachDTO>(); 
        for (QLChiTietSachDTO e : arrChiTietSach){
            if (PKey.contains(e.getIDSach())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public ArrayList <QLChiTietSachDTO> filter (ArrayList <String> PKey, ArrayList <QLChiTietSachDTO> arr){
        ArrayList <QLChiTietSachDTO> res_filter = new ArrayList <QLChiTietSachDTO>(); 
        for (QLChiTietSachDTO e : arr){
            if (PKey.contains(e.getIDSach())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public Boolean add(QLChiTietSachDTO chiTietSach){
        Boolean check = chiTietSachDAO.add(chiTietSach);
        if (check){
            arrChiTietSach.add(chiTietSach);
        }
        return check;
    }
    
    public Boolean add(String IDSach, String maSach, String tinhTrang){
        QLChiTietSachDTO chiTietSach=new QLChiTietSachDTO(IDSach, maSach, tinhTrang);
        return this.add(chiTietSach);
    }
    
    public Boolean del(String IDSach){
        Boolean check = chiTietSachDAO.del(IDSach);
        if (check){
            for (QLChiTietSachDTO chiTietSach : arrChiTietSach){
                if (chiTietSach.getIDSach().equals(IDSach)){
                    arrChiTietSach.remove(chiTietSach);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean mod(QLChiTietSachDTO chiTietSach){
        Boolean check = chiTietSachDAO.mod(chiTietSach);  
        if (check){
            for (QLChiTietSachDTO s : arrChiTietSach){
                if (s.getIDSach().equals(chiTietSach.getIDSach())){
                    arrChiTietSach.set(arrChiTietSach.indexOf(s), chiTietSach);
                    break;
                }
            }
        } 
        return check;
    }
     
    public Boolean mod(String IDSach, String maSach, String tinhTrang){
        QLChiTietSachDTO chiTietSach=new QLChiTietSachDTO(IDSach, maSach, tinhTrang);
        return this.mod(chiTietSach);
    } 

    public ArrayList<QLChiTietSachDTO> getArrChiTietSach() {
        return arrChiTietSach;
    }
    
    public int getSoLuongSach(){
        return arrChiTietSach.size();
    }
}

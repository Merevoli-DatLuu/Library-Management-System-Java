package librarymanagementsystem.BUS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLKhoSachBUS {
    private static ArrayList<QLKhoSachDTO> arrKhoSach = new ArrayList<>();
    private QLKhoSachDAO khoSachDAO = new QLKhoSachDAO();

    public QLKhoSachBUS() {
        arrKhoSach= khoSachDAO.readDB();
    }
    
    public QLKhoSachBUS(int i) {
        if (arrKhoSach.size() == 0){
            arrKhoSach= khoSachDAO.readDB();
        }
    }
    
    
    public void readDB(){
        arrKhoSach= khoSachDAO.readDB();
    }
    
    // for full view 
    public void readDB_full(){
        arrKhoSach = khoSachDAO.readDB_full();
    }
    
    public String [] getHeaders(){
        return new String[]{"Mã Sách", "Số Lượng"};
    }
    
    public String [] getHeader_full(){
        return new String[]{"Mã Sách", "Bìa Sách", "Số Lượng", "Tên Sách", "Tên Tác Giả", "Tên NXB", "Thể Loại", "Ngôn Ngữ", "Tóm Tắt Nội Dung", "Năm Xuất Bản", "Giá Tiền", "Số Trang"};
    }
   
    // 0:string, 1:int, 2:date
    public int[] getHeadersType(){
        return new int[]{0, 1};
    }
    
    public int findHeaderType(String header){
        for (int i=0; i<2; i++){
            if (getHeaders()[i].equals(header)){
                return getHeadersType()[i];
            }
        }
        System.err.println("header type not found");
        return -1;
    }
    
    public QLKhoSachDTO getKhoSach(String maSach){
        for (QLKhoSachDTO e : arrKhoSach){
            if (e.getMaSach().equals(maSach)){
                return e;
            }
        }
        return null;
    }
    
    public ArrayList <QLKhoSachDTO> getKhoSach_full(ArrayList <String> maSach){
        Set<String> set = new HashSet<String>();
        ArrayList <QLKhoSachDTO> res = new ArrayList<>();
        for (String e : maSach){
            set.add(e);
        }
        
        for (QLKhoSachDTO e : arrKhoSach){
            if (set.contains(e.getMaSach())){
                res.add(e);
            }
        }
        return res;
    }
    
    public ArrayList <String> getPKey(){
        ArrayList <String> Pkey = new ArrayList<>();
        for (QLKhoSachDTO e : arrKhoSach){
            Pkey.add(e.getMaSach());
        }
        return Pkey;
    }
    
    public ArrayList <QLKhoSachDTO> search (String column, String value){
        ArrayList <QLKhoSachDTO> result_search = new ArrayList <QLKhoSachDTO> ();
        value = value.toLowerCase();
        switch (column) { // Dựa vào Headers
            case "Mã Sách ":
                for (QLKhoSachDTO e : arrKhoSach){
                    if (e.getMaSach().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Số Lượng": 
                for (QLKhoSachDTO e : arrKhoSach){
                    String soLuong= String.valueOf(e.getSoLuong());
                    if (soLuong.toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
        }
        return result_search;
    }
    
    /*public ArrayList <QLKhoSachDTO> search_full (String column, String value){
        ArrayList <QLKhoSachDTO> result_search = new ArrayList <QLKhoSachDTO> ();
        switch (column) { // Dựa vào Headers
            case "Mã Sách ":
                for (QLKhoSachDTO e : arrKhoSach){
                    if (e.getMaSach().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Số Lượng": 
                for (QLKhoSachDTO e : arrKhoSach){
                    String soLuong= String.valueOf(e.getSoLuong());
                    if (soLuong.toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Sách":
                for (QLKhoSachDTO e : arrKhoSach){
                    if (e.getSach().toLowerCase(Locale.getDefault()).compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
        }
        return result_search;
    }*/
    
    public ArrayList <QLKhoSachDTO> search_all (String column, String value){
        ArrayList <QLKhoSachDTO> result_search = new ArrayList <QLKhoSachDTO> ();
        value = value.toLowerCase();
        for (QLKhoSachDTO e : arrKhoSach){
            String soLuong=String.valueOf(e.getSoLuong());
            if (e.getMaSach().toLowerCase().contains(value)) {
                result_search.add(e);
            }
            else if (soLuong.toLowerCase().contains(value)) {
                result_search.add(e);
            }
        }
        return result_search;
    }
    
    public ArrayList <QLKhoSachDTO> filter (ArrayList <String> PKey){
        ArrayList <QLKhoSachDTO> res_filter = new ArrayList <QLKhoSachDTO>(); 
        for (QLKhoSachDTO e : arrKhoSach){
            if (PKey.contains(e.getMaSach())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public ArrayList <QLKhoSachDTO> filter (ArrayList <String> PKey, ArrayList <QLKhoSachDTO> arr){
        ArrayList <QLKhoSachDTO> res_filter = new ArrayList <QLKhoSachDTO>(); 
        for (QLKhoSachDTO e : arr){
            if (PKey.contains(e.getMaSach())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public Boolean add(QLKhoSachDTO khoSach){
        Boolean check = khoSachDAO.add(khoSach);
        if (check){
            arrKhoSach.add(khoSach);
        }
        return check;
    }
    
    public Boolean add(String maSach, int soLuong){
        QLKhoSachDTO khoSach=new QLKhoSachDTO(maSach, soLuong);
        return this.add(khoSach);
    }
    
    public Boolean del(String maSach){
        Boolean check = khoSachDAO.del(maSach);
        if (check){
            for (QLKhoSachDTO khoSach : arrKhoSach){
                if (khoSach.getMaSach().equals(maSach)){
                    arrKhoSach.remove(khoSach);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean mod(QLKhoSachDTO khoSach){
        Boolean check = khoSachDAO.mod(khoSach);  
        if (check){
            for (QLKhoSachDTO s : arrKhoSach){
                if (s.getMaSach().equals(khoSach.getMaSach())){
                    arrKhoSach.set(arrKhoSach.indexOf(s), khoSach);
                    break;
                }
            }
        } 
        return check;
    }
     
    public Boolean mod(String maSach, int soLuong){
        QLKhoSachDTO khoSach=new QLKhoSachDTO(maSach, soLuong);
        return this.mod(khoSach);
    } 

    public ArrayList<QLKhoSachDTO> getArrKhoSach() {
        return arrKhoSach;
    }
    
    
}

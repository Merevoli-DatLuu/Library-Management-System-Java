package librarymanagementsystem.BUS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import librarymanagementsystem.Toolkit.DataProcessing;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLKhachHangBUS {
    private ArrayList<QLKhachHangDTO> arrKhachHang = new ArrayList<>();
    private QLKhachHangDAO khachHangDAO = new QLKhachHangDAO();

    public QLKhachHangBUS() {
        arrKhachHang = khachHangDAO.readDB();
    }
    
    public void readDB(){
        arrKhachHang = khachHangDAO.readDB();
    }
    
    public String [] getHeader(){
        return new String[]{"Mã Khách Hàng", "Họ Tên", "Ngày Sinh", "Địa Chỉ", "Số Điện Thoại", "Email", "Mã Thẻ"};
    }
    
    public QLKhachHangDTO getKhachHang(String maKhachHang){
        for (QLKhachHangDTO e : arrKhachHang){
            if (e.equals(maKhachHang)){
                return e;
            }
        }
        return null;
    }
    
    public ArrayList <QLKhachHangDTO> getKhachHang_full(ArrayList <String> maKhachHang){
        Set<String> set = new HashSet<String>();
        ArrayList <QLKhachHangDTO> res = new ArrayList<>();
        for (String e : maKhachHang){
            set.add(e);
        }
        
        for (QLKhachHangDTO e : arrKhachHang){
            if (set.contains(e)){
                res.add(e);
            }
        }
        return res;
    }
    
    public ArrayList <String> getPKey(){
        ArrayList <String> Pkey = new ArrayList<>();
        for (QLKhachHangDTO e : arrKhachHang){
            Pkey.add(e.getMaKhachHang());
        }
        return Pkey;
    }
    
    public ArrayList <QLKhachHangDTO> search (String column, String value){
        ArrayList <QLKhachHangDTO> result_search = new ArrayList <QLKhachHangDTO> ();
        switch (column) { // Dựa vào Headers
            case "Mã Khách Hàng":
                for (QLKhachHangDTO e : arrKhachHang){
                    if (e.getMaKhachHang().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Họ Tên": 
                for (QLKhachHangDTO e : arrKhachHang){
                    if (e.getHoTen().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Ngày Sinh":
                for (QLKhachHangDTO e : arrKhachHang){
                    if (e.getNgaySinh().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Địa Chỉ":
                for (QLKhachHangDTO e : arrKhachHang){
                    if (e.getDiaChi().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Số Điện Thoại":
                for (QLKhachHangDTO e : arrKhachHang){
                    if (e.getSdt().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Email":
                for (QLKhachHangDTO e : arrKhachHang){
                    if (e.getEmail().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Mã Thẻ":
                for (QLKhachHangDTO e : arrKhachHang){
                    if (e.getMaThe().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
        }
        return result_search;
    }
    
    public ArrayList <QLKhachHangDTO> search_all (String column, String value){
        ArrayList <QLKhachHangDTO> result_search = new ArrayList <QLKhachHangDTO> ();
        for (QLKhachHangDTO e : arrKhachHang){
            if (e.getMaKhachHang().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getHoTen().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getNgaySinh().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getDiaChi().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getSdt().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getEmail().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getMaThe().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
        }
        return result_search;
    }
    
    public ArrayList <QLKhachHangDTO> filter (ArrayList <String> PKey){
        ArrayList <QLKhachHangDTO> res_filter = new ArrayList <QLKhachHangDTO>(); 
        for (QLKhachHangDTO e : arrKhachHang){
            if (PKey.contains(e.getMaKhachHang())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public ArrayList <QLKhachHangDTO> filter (ArrayList <String> PKey, ArrayList <QLKhachHangDTO> arr){
        ArrayList <QLKhachHangDTO> res_filter = new ArrayList <QLKhachHangDTO>(); 
        for (QLKhachHangDTO e : arr){
            if (PKey.contains(e.getMaKhachHang())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public Boolean add(QLKhachHangDTO khachHang){
        Boolean check = khachHangDAO.add(khachHang);
        if (check){
            arrKhachHang.add(khachHang);
        }
        return check;
    }
    
    public Boolean add(String maKhachHang, String hoTen, String ngaySinh, String diaChi, String email, String maThe, String sdt){
        QLKhachHangDTO khachHang=new QLKhachHangDTO(maKhachHang, hoTen, ngaySinh, diaChi, email, maThe, sdt);
        return this.add(khachHang);
    }
    
    public Boolean del(String maKhachHang){
        Boolean check = khachHangDAO.del(maKhachHang);
        if (check){
            for (QLKhachHangDTO khachHang : arrKhachHang){
                if (khachHang.getMaKhachHang().equals(maKhachHang)){
                    arrKhachHang.remove(khachHang);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean mod(QLKhachHangDTO khachHang){
        Boolean check = khachHangDAO.mod(khachHang);  
        if (check){
            for (QLKhachHangDTO s : arrKhachHang){
                if (s.getMaKhachHang().equals(khachHang.getMaKhachHang())){
                    arrKhachHang.set(arrKhachHang.indexOf(s), khachHang);
                    break;
                }
            }
        } 
        return check;
    }
     
    public Boolean mod(String maKhachHang, String hoTen, String ngaySinh, String diaChi, String email, String maThe, String sdt){
        QLKhachHangDTO khachHang=new QLKhachHangDTO(maKhachHang, hoTen, ngaySinh, diaChi, email, maThe, sdt);
        return this.mod(khachHang);
    } 

    public ArrayList<QLKhachHangDTO> getArrKhachHang() {
        return arrKhachHang;
    }
    
    // Thống Kê (về sau chuyển sang class riêng)
    /**
    * Nhóm trẻ em và thanh thiếu niên 0 -> 19
    * Nhóm người trưởng thành 20 -> 49
    * Nhóm người lớn tuổi: 49->...
    **/
    public ArrayList <Integer> getArrStageofAge(){
        DataProcessing t = new DataProcessing();
        ArrayList <Integer> stage = new ArrayList<>();
        int stage_1 = 0; // Nhóm trẻ em và thanh thiếu niên
        int stage_2 = 0; // Nhóm người trưởng thành
        int stage_3 = 0; // Nhóm người lớn tuổi
        for (QLKhachHangDTO e : arrKhachHang){
            if (t.getAge(e.getNgaySinh()) <= 19){       // Nhóm trẻ em và thanh thiếu niên
                stage_1++;
            }
            else if (t.getAge(e.getNgaySinh()) <= 49){  // Nhóm người trưởng thành
                stage_2++;
            }
            else{                                       // Nhóm người lớn tuổi
                stage_3++;
            }
        }
        stage.add(stage_1);
        stage.add(stage_2);
        stage.add(stage_3);
        return stage;
    }
    
    public int getSoLuongKhachHang(){
        return arrKhachHang.size();
    }
}

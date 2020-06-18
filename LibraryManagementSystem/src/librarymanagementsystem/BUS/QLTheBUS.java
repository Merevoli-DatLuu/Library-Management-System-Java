package librarymanagementsystem.BUS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLTheBUS {
    private static ArrayList<QLTheDTO> arrThe = new ArrayList<>();
    private QLTheDAO theDAO = new QLTheDAO();

    public QLTheBUS() {
        arrThe= theDAO.readDB();
    }
    
    public QLTheBUS(int i) {
        if (arrThe.size() == 0){
            arrThe = theDAO.readDB();
        }
    }
    
    public void readDB(){
        arrThe= theDAO.readDB();
    }
    
    public void readDB_full(){
        arrThe = theDAO.readDB_full();
    }
    
    public String [] getHeaders(){
        return new String[]{"Mã Thẻ", "Mã Khách Hàng", "Ngày Cấp", "Ngày Hết Hạn"};
    }
    
    public String [] getHeaders_full(){
        return new String[]{"Mã Thẻ", "Ngày Cấp", "Ngày Hết Hạn", "Mã Khách Hàng", "Họ Tên", "Ngày Sinh", "Địa Chỉ", "Số Điện Thoại", "Email"};
    }
    
    // 0:string, 1:int, 2:date
    public int[] getHeadersType(){
        return new int[]{0, 0, 0, 0};
    }
    
    public int findHeaderType(String header){
        for (int i=0; i<4; i++){
            if (getHeaders()[i].equals(header)){
                return getHeadersType()[i];
            }
        }
        System.err.println("header type not found");
        return -1;
    }
    
    public QLTheDTO getThe(String maThe){
        for (QLTheDTO e : arrThe){
            if (e.getMaThe().equals(maThe)){
                return e;
            }
        }
        return null;
    }
    
    public ArrayList <QLTheDTO> getThe_full(ArrayList <String> maThe){
        Set<String> set = new HashSet<String>();
        ArrayList <QLTheDTO> res = new ArrayList<>();
        for (String e : maThe){
            set.add(e);
        }
        
        for (QLTheDTO e : arrThe){
            if (set.contains(e.getMaThe())){
                res.add(e);
            }
        }
        return res;
    }
    
    public ArrayList <String> getPKey(){
        ArrayList <String> Pkey = new ArrayList<>();
        for (QLTheDTO e : arrThe){
            Pkey.add(e.getMaThe());
        }
        return Pkey;
    }
    
    public ArrayList <QLTheDTO> search (String column, String value){
        ArrayList <QLTheDTO> result_search = new ArrayList <QLTheDTO> ();
        value = value.toLowerCase();
        switch (column) { // Dựa vào Headers
            case "Mã Thẻ":
                for (QLTheDTO e : arrThe){
                    if (e.getMaThe().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Ngày Cấp":
                for (QLTheDTO e : arrThe){
                    if (e.getNgayCap().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Ngày Hết Hạn":
                for (QLTheDTO e : arrThe){
                    if (e.getNgayHetHan().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Mã Khách Hàng":
                for (QLTheDTO e : arrThe){
                    if (e.getMaThe().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
        }
        return result_search;
    }
    
    public ArrayList <QLTheDTO> search_all (String column, String value){
        ArrayList <QLTheDTO> result_search = new ArrayList <QLTheDTO> ();
        value = value.toLowerCase();
        for (QLTheDTO e : arrThe){
            if (e.getMaThe().toLowerCase().contains(value)) {
                result_search.add(e);
            }
            else if (e.getNgayCap().toLowerCase().contains(value)) {
                result_search.add(e);
            }
            else if (e.getNgayHetHan().toLowerCase().contains(value)) {
                result_search.add(e);
            }
            else if (e.getMaKhachHang().toLowerCase().contains(value)){
                result_search.add(e);
            }
        }
        return result_search;
    }
    
    public ArrayList <QLTheDTO> filter (ArrayList <String> PKey){
        ArrayList <QLTheDTO> res_filter = new ArrayList <QLTheDTO>(); 
        for (QLTheDTO e : arrThe){
            if (PKey.contains(e.getMaThe())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public ArrayList <QLTheDTO> filter (ArrayList <String> PKey, ArrayList <QLTheDTO> arr){
        ArrayList <QLTheDTO> res_filter = new ArrayList <QLTheDTO>(); 
        for (QLTheDTO e : arr){
            if (PKey.contains(e.getMaThe())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public Boolean add(QLTheDTO the){
        Boolean check = theDAO.add(the);
        if (check){
            arrThe.add(the);
        }
        return check;
    }
    
    public Boolean add(String maThe, String maKhachHang, String ngayCap, String ngayHetHan){
        QLTheDTO the=new QLTheDTO(maThe, maKhachHang, ngayCap, ngayHetHan);
        return this.add(the);
    }
    
    public Boolean del(String maThe){
        Boolean check = theDAO.del(maThe);
        if (check){
            for (QLTheDTO sach : arrThe){
                if (sach.getMaThe().equals(maThe)){
                    arrThe.remove(sach);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean mod(QLTheDTO the){
        Boolean check = theDAO.mod(the);  
        if (check){
            for (QLTheDTO s : arrThe){
                if (s.getMaThe().equals(the.getMaThe())){
                    arrThe.set(arrThe.indexOf(s), the);
                    break;
                }
            }
        } 
        return check;
    }
     
    public Boolean mod(String maThe, String maKhachHang, String ngayCap, String ngayHetHan){
        QLTheDTO the=new QLTheDTO(maThe, maKhachHang, ngayCap, ngayHetHan);
        return this.mod(the);
    } 

    public ArrayList<QLTheDTO> getArrThe() {
        return arrThe;
    }
    
    public int getSoLuongThe(){
        return arrThe.size();
    }
}

package librarymanagementsystem.BUS;

import java.util.ArrayList;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLTheBUS {
    private ArrayList<QLTheDTO> arrThe = new ArrayList<>();
    private QLTheDAO theDAO = new QLTheDAO();

    public QLTheBUS() {
        arrThe= theDAO.readDB();
    }
    
    public void readDB(){
        arrThe= theDAO.readDB();
    }
    
    public void readDB_full(){
        arrThe = theDAO.readDB_full();
    }
    
    public String [] getHeader(){
        return new String[]{"Mã Thẻ", "Mã Khách Hàng", "Ngày Cấp", "Ngày Hết Hạn"};
    }
    
    public String [] getHeader_full(){
        return new String[]{"Mã Thẻ", "Ngày Cấp", "Ngày Hết Hạn", "Mã Khách Hàng", "Họ Tên", "Ngày Sinh", "Địa Chỉ", "Số Điện Thoại", "Email"};
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
}

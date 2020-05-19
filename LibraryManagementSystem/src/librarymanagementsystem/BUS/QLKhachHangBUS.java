package librarymanagementsystem.BUS;

import java.util.ArrayList;
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
}

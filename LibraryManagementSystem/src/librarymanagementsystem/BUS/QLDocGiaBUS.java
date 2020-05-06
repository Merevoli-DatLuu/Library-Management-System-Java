package librarymanagementsystem.BUS;

import java.util.ArrayList;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLDocGiaBUS {
    private ArrayList<QLDocGiaDTO> arrDocGia = new ArrayList<>();
    private QLDocGiaDAO docGiaDAO = new QLDocGiaDAO();

    public QLDocGiaBUS() {
        arrDocGia= docGiaDAO.readDB();
    }
    
    public String [] getHeader(){
        return new String[]{"Mã Khách Hàng", "Họ Tên", "Ngày Sinh", "Địa Chỉ", "Số Điện Thoại", "Email", "Mã Thẻ"};
    }
    
    public Boolean add(QLDocGiaDTO docGia){
        Boolean check = docGiaDAO.add(docGia);
        if (check){
            arrDocGia.add(docGia);
        }
        return check;
    }
    
    public Boolean add(String maKhachHang, String hoTen, String ngaySinh, String diaChi, String email, String maThe, String sdt){
        QLDocGiaDTO docGia=new QLDocGiaDTO(maKhachHang, hoTen, ngaySinh, diaChi, email, maThe, sdt);
        return this.add(docGia);
    }
    
    public Boolean del(String maKhachHang){
        Boolean check = docGiaDAO.del(maKhachHang);
        if (check){
            for (QLDocGiaDTO docGia : arrDocGia){
                if (docGia.getMaKhachHang().equals(maKhachHang)){
                    arrDocGia.remove(docGia);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean mod(QLDocGiaDTO docGia){
        Boolean check = docGiaDAO.mod(docGia);  
        if (check){
            for (QLDocGiaDTO s : arrDocGia){
                if (s.getMaKhachHang().equals(docGia.getMaKhachHang())){
                    arrDocGia.set(arrDocGia.indexOf(s), docGia);
                    break;
                }
            }
        } 
        return check;
    }
     
    public Boolean mod(String maKhachHang, String hoTen, String ngaySinh, String diaChi, String email, String maThe, String sdt){
        QLDocGiaDTO docGia=new QLDocGiaDTO(maKhachHang, hoTen, ngaySinh, diaChi, email, maThe, sdt);
        return this.mod(docGia);
    } 
}

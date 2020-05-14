package librarymanagementsystem.BUS;

import java.util.ArrayList;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLNhanVienBUS {
    private ArrayList<QLNhanVienDTO> arrNhanVien = new ArrayList<>();
    private QLNhanVienDAO nhanVienDAO = new QLNhanVienDAO();

    public QLNhanVienBUS() {
        arrNhanVien= nhanVienDAO.readDB();
    }
    
    public String [] getHeader(){
        return new String[]{"Mã Quản Lý", "Password", "Họ Tên", "Ngày Sinh", "Địa Chỉ", "Số Điện Thoại", "Email", "Chức Vụ"};
    }
    
    public Boolean kiemTraTaiKhoan(String tk, String pass){
        for (QLNhanVienDTO e : arrNhanVien){
            if (e.getMaQuanLy().equals(tk) && e.getPassword().equals(pass)){
                return true;
            }
        }
        return false;
    }
    
    public Boolean add(QLNhanVienDTO nhanVien){
        Boolean check = nhanVienDAO.add(nhanVien);
        if (check){
            arrNhanVien.add(nhanVien);
        }
        return check;
    }
    
    public Boolean add(String maQuanLy, String password, String hoTen, String ngaySinh, String diaChi, String email, String chucVu, String sdt){
        QLNhanVienDTO nhanVien=new QLNhanVienDTO(maQuanLy, password, hoTen, ngaySinh, diaChi, email, chucVu, sdt);
        return this.add(nhanVien);
    }
    
    public Boolean del(String maQuanLy){
        Boolean check = nhanVienDAO.del(maQuanLy);
        if (check){
            for (QLNhanVienDTO nhanVien : arrNhanVien){
                if (nhanVien.getMaQuanLy().equals(maQuanLy)){
                    arrNhanVien.remove(nhanVien);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean mod(QLNhanVienDTO nhanVien){
        Boolean check = nhanVienDAO.mod(nhanVien);  
        if (check){
            for (QLNhanVienDTO s : arrNhanVien){
                if (s.getMaQuanLy().equals(nhanVien.getMaQuanLy())){
                    arrNhanVien.set(arrNhanVien.indexOf(s), nhanVien);
                    break;
                }
            }
        } 
        return check;
    }
     
    public Boolean mod(String maQuanLy, String password, String hoTen, String ngaySinh, String diaChi, String email, String chucVu, String sdt){
        QLNhanVienDTO nhanVien=new QLNhanVienDTO(maQuanLy, password, hoTen, ngaySinh, diaChi, email, chucVu, sdt);
        return this.mod(nhanVien);
    } 
}

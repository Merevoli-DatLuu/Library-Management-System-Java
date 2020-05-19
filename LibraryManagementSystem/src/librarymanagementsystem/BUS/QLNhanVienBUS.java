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
    
    public String kiemTraTaiKhoan(String tk, String pass){
        for (QLNhanVienDTO e : arrNhanVien){
            if (e.getMaNhanVien().equals(tk) && e.getPassword().equals(pass)){
                return e.getMaNhanVien();
            }
        }
        return "";
    }
    
    public String kiemTraTaiKhoan_RFID_code(String RFID_code){
        for (QLNhanVienDTO e : arrNhanVien){
            if (e.getRFID_code().equals(RFID_code)){
                return e.getMaNhanVien();
            }
        }
        return "";
    }
    
    public Boolean add(QLNhanVienDTO nhanVien){
        Boolean check = nhanVienDAO.add(nhanVien);
        if (check){
            arrNhanVien.add(nhanVien);
        }
        return check;
    }
    
    public Boolean add(String maNhanVien, String password, String hoTen, String ngaySinh, String diaChi, String email, String chucVu, String sdt){
        QLNhanVienDTO nhanVien=new QLNhanVienDTO(maNhanVien, password, hoTen, ngaySinh, diaChi, email, chucVu, sdt);
        return this.add(nhanVien);
    }
    
    public Boolean add(String maNhanVien, String password, String hoTen, String ngaySinh, String diaChi, String email, String chucVu, String sdt, String RFID_code){
        QLNhanVienDTO nhanVien=new QLNhanVienDTO(maNhanVien, password, hoTen, ngaySinh, diaChi, email, chucVu, sdt, RFID_code);
        return this.add(nhanVien);
    }
    
    public Boolean del(String maNhanVien){
        Boolean check = nhanVienDAO.del(maNhanVien);
        if (check){
            for (QLNhanVienDTO nhanVien : arrNhanVien){
                if (nhanVien.getMaNhanVien().equals(maNhanVien)){
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
                if (s.getMaNhanVien().equals(nhanVien.getMaNhanVien())){
                    arrNhanVien.set(arrNhanVien.indexOf(s), nhanVien);
                    break;
                }
            }
        } 
        return check;
    }
     
    public Boolean mod(String maNhanVien, String password, String hoTen, String ngaySinh, String diaChi, String email, String chucVu, String sdt){
        QLNhanVienDTO nhanVien=new QLNhanVienDTO(maNhanVien, password, hoTen, ngaySinh, diaChi, email, chucVu, sdt);
        return this.mod(nhanVien);
    } 
    
    public Boolean mod_RFID_code(String maNhanVien, String RFID_code){
        Boolean check = nhanVienDAO.mod_RFID_code(maNhanVien, RFID_code);  
        if (check){
            for (QLNhanVienDTO s : arrNhanVien){
                if (s.getMaNhanVien().equals(maNhanVien)){
                    arrNhanVien.get(arrNhanVien.indexOf(s)).setRFID_code(RFID_code);
                    break;
                }
            }
        } 
        return check;
    }
}

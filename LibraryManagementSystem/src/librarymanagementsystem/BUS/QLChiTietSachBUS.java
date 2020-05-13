package librarymanagementsystem.BUS;

import java.util.ArrayList;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLChiTietSachBUS {
    private ArrayList<QLChiTietSachDTO> arrChiTietSach = new ArrayList<>();
    private QLChiTietSachDAO chiTietSachDAO = new QLChiTietSachDAO();

    public QLChiTietSachBUS() {
        arrChiTietSach= chiTietSachDAO.readDB();
    }
    
    public void readDB(){
        arrChiTietSach= chiTietSachDAO.readDB();
    }
    
    // for full view 
    public void readDB_full(){
        arrChiTietSach = chiTietSachDAO.readDB_full();
    }
    
    public String [] getHeader(){
        return new String[]{"ID Sách", "Mã Sách", "Tình Trạng"};
    }
    
    public String [] getHeader_full(){
        return new String[]{"ID Sách", "Bìa Sách", "Mã Sách", "Tình Trạng", "Tên Sách", "Tên Tác Giả", "Tên NXB", "Thể Loại", "Ngôn Ngữ", "Tóm Tắt Nội Dung", "Năm Xuất Bản", "Giá Tiền", "Số Trang"};
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
}

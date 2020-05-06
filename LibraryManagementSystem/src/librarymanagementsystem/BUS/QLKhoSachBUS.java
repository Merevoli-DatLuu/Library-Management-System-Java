package librarymanagementsystem.BUS;

import java.util.ArrayList;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLKhoSachBUS {
    private ArrayList<QLKhoSachDTO> arrKhoSach = new ArrayList<>();
    private QLKhoSachDAO khoSachDAO = new QLKhoSachDAO();

    public QLKhoSachBUS() {
        arrKhoSach= khoSachDAO.readDB();
    }
    
    public void readDB(){
        arrKhoSach= khoSachDAO.readDB();
    }
    
    // for full view 
    public void readDB_full(){
        arrKhoSach = khoSachDAO.readDB_full();
    }
    
    public String [] getHeader(){
        return new String[]{"Mã Sách", "Số Lượng"};
    }
    
    public String [] getHeader_full(){
        return new String[]{"Mã Sách", "Số Lượng", "Tên Sách", "Tên Tác Giả", "Tên NXB", "Thể Loại", "Ngôn Ngữ", "Tóm Tắt Nội Dung", "Năm Xuất Bản", "Giá Tiền", "Số Trang"};
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
}

package librarymanagementsystem.BUS;

import librarymanagementsystem.DTO.*;
import librarymanagementsystem.DAO.*;
import java.util.ArrayList;

public class QLSachBUS {
    private ArrayList<QLSachDTO> arrSach = new ArrayList<>();
    private QLSachDAO sachDAO = new QLSachDAO();
    
    public QLSachBUS(){
        arrSach = sachDAO.readDB();
    }
    
    public String[] getHeaders(){
        return new String[]{"Mã Sách", "Bìa Sách", "Tên Sách", "Tên Tác Giả", "Tên NXB", "Thể Loại", "Ngôn Ngữ", "Tóm Tắt Nội Dung", "Năm Xuất Bản", "Giá Tiền", "Số Trang"};
    }
    
    public Boolean add(QLSachDTO sach){
        Boolean check = sachDAO.add(sach);
        
        if (check){
            arrSach.add(sach);
        }
        return check;
    }
    
    public Boolean add(String maSach, String tenSach, String tenTacGia, String tenNXB, String theLoai, String ngonNgu, String tomTatNoiDung, int namXB, int giaTien, int soTrang, String hinh){
        QLSachDTO sach = new QLSachDTO(maSach, tenSach, tenTacGia, tenNXB, theLoai, ngonNgu, tomTatNoiDung, namXB, giaTien, soTrang, hinh);
        
        return this.add(sach);
    }
    
    public Boolean del(String maSach){
        Boolean check = sachDAO.del(maSach);
        
        if (check){
            for (QLSachDTO sach : arrSach){
                if (sach.getMaSach().equals(maSach)){
                    arrSach.remove(sach);
                    break;
                }
            }
        }
        
        return check;
    }
    
    public Boolean mod(QLSachDTO sach){
        Boolean check = sachDAO.mod(sach);
        
        if (check){
            for (QLSachDTO s : arrSach){
                if (s.getMaSach().equals(sach.getMaSach())){
                    arrSach.set(arrSach.indexOf(s), sach);
                    break;
                }
            }
        }
        
        return check;
    }
    
    public Boolean mod(String maSach, String tenSach, String tenTacGia, String tenNXB, String theLoai, String ngonNgu, String tomTatNoiDung, int namXB, int giaTien, int soTrang, String hinh){
        QLSachDTO sach = new QLSachDTO(maSach, tenSach, tenTacGia, tenNXB, theLoai, ngonNgu, tomTatNoiDung, namXB, giaTien, soTrang, hinh);
        
        return this.mod(sach);
    }
}

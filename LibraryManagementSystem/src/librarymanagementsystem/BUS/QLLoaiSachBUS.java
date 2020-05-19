package librarymanagementsystem.BUS;

import librarymanagementsystem.DTO.*;
import librarymanagementsystem.DAO.*;
import java.util.ArrayList;

public class QLLoaiSachBUS {
    private ArrayList<QLLoaiSachDTO> arrSach = new ArrayList<>();
    private QLLoaiSachDAO sachDAO = new QLLoaiSachDAO();
    
    public QLLoaiSachBUS(){
        arrSach = sachDAO.readDB();
    }
    
    public String[] getHeaders(){
        return new String[]{"Mã Sách", "Bìa Sách", "Tên Sách", "Tên Tác Giả", "Tên NXB", "Thể Loại", "Ngôn Ngữ", "Tóm Tắt Nội Dung", "Năm Xuất Bản", "Giá Tiền", "Số Trang"};
    }
    
    public void show(){
        for (QLLoaiSachDTO sach : arrSach){
            System.out.println(sach.getMaSach() + '\t' + sach.getTenSach());
        }
    }
            
    public Boolean add(QLLoaiSachDTO sach){
        Boolean check = sachDAO.add(sach);
        
        if (check){
            arrSach.add(sach);
        }
        return check;
    }
    
    public Boolean add(String maSach, String tenSach, String tenTacGia, String tenNXB, String theLoai, String ngonNgu, String tomTatNoiDung, int namXB, int giaTien, int soTrang, String hinh){
        QLLoaiSachDTO sach = new QLLoaiSachDTO(maSach, tenSach, tenTacGia, tenNXB, theLoai, ngonNgu, tomTatNoiDung, namXB, giaTien, soTrang, hinh);
        
        return this.add(sach);
    }
    
    public Boolean del(String maSach){
        Boolean check = sachDAO.del(maSach);
        
        if (check){
            for (QLLoaiSachDTO sach : arrSach){
                if (sach.getMaSach().equals(maSach)){
                    arrSach.remove(sach);
                    break;
                }
            }
        }
        
        return check;
    }
    
    public Boolean mod(QLLoaiSachDTO sach){
        Boolean check = sachDAO.mod(sach);
        
        if (check){
            for (QLLoaiSachDTO s : arrSach){
                if (s.getMaSach().equals(sach.getMaSach())){
                    arrSach.set(arrSach.indexOf(s), sach);
                    break;
                }
            }
        }
        
        return check;
    }
    
    public Boolean mod(String maSach, String tenSach, String tenTacGia, String tenNXB, String theLoai, String ngonNgu, String tomTatNoiDung, int namXB, int giaTien, int soTrang, String hinh){
        QLLoaiSachDTO sach = new QLLoaiSachDTO(maSach, tenSach, tenTacGia, tenNXB, theLoai, ngonNgu, tomTatNoiDung, namXB, giaTien, soTrang, hinh);
        
        return this.mod(sach);
    }

    public ArrayList<QLLoaiSachDTO> getArrSach() {
        return arrSach;
    }
    
    
}

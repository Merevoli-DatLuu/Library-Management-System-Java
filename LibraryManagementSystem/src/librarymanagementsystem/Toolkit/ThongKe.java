package librarymanagementsystem.Toolkit;

import librarymanagementsystem.BUS.*;
import librarymanagementsystem.DTO.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ThongKe {
    
    /** Thống Kê Loại Sách **/
    
    // Tổng số loại sách
    public int soLuong_Sach(){
        return new QLLoaiSachBUS().getArrSach().size();
    }
    
    // Số lượng sách theo ngôn ngữ
    public int soLuong_Sach_NgonNgu(String ngonNgu){
        int count = 0;
        ArrayList <QLLoaiSachDTO> arr = new QLLoaiSachBUS().getArrSach();
        for (QLLoaiSachDTO e : arr){
            if (e.getNgonNgu().equals(ngonNgu)){
                count++;
            }
        }
        return count;
    }
    
    // Số lượng thể loại
    public int soLuong_Sach_TheLoai(){
        Set<String> set = new HashSet<String>();
        ArrayList <QLLoaiSachDTO> arr = new QLLoaiSachBUS().getArrSach();
        for (QLLoaiSachDTO e : arr){
            set.add(e.getNgonNgu());
        }
        return set.size();
    }
    
    // Số lượng sách theo thể loại
    public int soLuong_Sach_ByTheLoai(String theLoai){
        int count = 0;
        ArrayList <QLLoaiSachDTO> arr = new QLLoaiSachBUS().getArrSach();
        for (QLLoaiSachDTO e : arr){
            if (e.getTheLoai().equals(theLoai)){
                count++;
            }
        }
        return count;
    }
}

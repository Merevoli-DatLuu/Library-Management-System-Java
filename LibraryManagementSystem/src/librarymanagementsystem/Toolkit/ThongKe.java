package librarymanagementsystem.Toolkit;

import librarymanagementsystem.BUS.*;
import librarymanagementsystem.DTO.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.crypto.AEADBadTagException;

public class ThongKe {
    DataProcessing ps = new DataProcessing();
    /** Thống Kê Loại Sách **/
    
    // Tổng số loại sách
    public int soLuong_Sach(){
        return new QLLoaiSachBUS(0).getArrSach().size();
    }
    
    // Số lượng sách theo ngôn ngữ
    public int soLuong_Sach_NgonNgu(String ngonNgu){
        int count = 0;
        ArrayList <QLLoaiSachDTO> arr = new QLLoaiSachBUS(0).getArrSach();
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
        ArrayList <QLLoaiSachDTO> arr = new QLLoaiSachBUS(0).getArrSach();
        for (QLLoaiSachDTO e : arr){
            set.add(e.getNgonNgu());
        }
        return set.size();
    }
    
    // Số lượng sách theo thể loại
    public int soLuong_Sach_ByTheLoai(String theLoai){
        int count = 0;
        ArrayList <QLLoaiSachDTO> arr = new QLLoaiSachBUS(0).getArrSach();
        for (QLLoaiSachDTO e : arr){
            if (e.getTheLoai().equals(theLoai)){
                count++;
            }
        }
        return count;
    }
    
    /** Thống Kê Sách Thư Viện **/
    
    public int soLuong_SachThuVien(){
        return new QLChiTietSachBUS(0).getArrChiTietSach().size();
    }
    
    public int soLuong_SachThuVien_TinhTrang(String TinhTrang){
        return new QLChiTietSachBUS(0).search("Tình Trạng", TinhTrang).size();
    }
    
    /** Thống Kê Sách Mượn **/
    
    public int soLuong_SachMuon(){
        return new QLPhieuMuonBUS(0).getArrMuonTra().size();
    }
    
    public int soLuong_SachMuon_CurrentMonth(){
        return new QLPhieuMuonBUS(0).getArrSoLuongSachMuon_Current().size();
    }
    
    public double soLuong_SachMuon_TrungBinh(){
        ArrayList <Double> arr = new ArrayList<>();
        ArrayList <Integer> inarr = new QLPhieuMuonBUS(0).getArrSoLuongSachMuon_Current();
        for (int e : inarr){
            arr.add((double)e);
        }
        return ps.median(arr);
    }
    
    public int soLuong_SachMuon_LonNhat(){
        ArrayList <Double> arr = new ArrayList<>();
        ArrayList <Integer> inarr = new QLPhieuMuonBUS(0).getArrSoLuongSachMuon_Current();
        for (int e : inarr){
            arr.add((double)e);
        }
        return (int)ps.max(arr);
    }
    
    public int soLuong_SachMuon_NhoNhat(){
        ArrayList <Double> arr = new ArrayList<>();
        ArrayList <Integer> inarr = new QLPhieuMuonBUS(0).getArrSoLuongSachMuon_Current();
        for (int e : inarr){
            arr.add((double)e);
        }
        return (int)ps.min(arr);
    }
}

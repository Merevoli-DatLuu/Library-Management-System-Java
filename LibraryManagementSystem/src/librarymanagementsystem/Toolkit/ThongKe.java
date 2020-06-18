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
            set.add(e.getTheLoai());
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
    
    public ArrayList <String> arr_Sach_NhaXuatBan(){
        Set<String> set = new HashSet<String>();
        ArrayList <QLLoaiSachDTO> arr = new QLLoaiSachBUS(0).getArrSach();
        ArrayList <String> res = new ArrayList<>();
        for (QLLoaiSachDTO e : arr){
            set.add(e.getTenNXB());
        }
        
        for (String e : set){
            res.add(e);
        }
        return res;
    }
    
    public ArrayList <String> arr_Sach_NhaXuatBan_top5(){
        HashMap<String, Integer> cap = new HashMap<String, Integer>();
        ArrayList <QLLoaiSachDTO> arr = new QLLoaiSachBUS(0).getArrSach();
        ArrayList <String> res = new ArrayList<>();
        for (QLLoaiSachDTO e : arr){
            if (cap.get(e.getTenNXB()) == null){
                cap.put(e.getTenNXB(), 1);
            }
            else{
                cap.put(e.getTenNXB(), cap.get(e.getTenNXB()) + 1);
            }
        }
        
        String b = "";
        int a = 0;
        for (int i=0; i<=4; i++){
            a = 0;
            for (String e : cap.keySet()){
                if (cap.get(e) > a){
                    a = cap.get(e);
                    b = e;
                }
            }
            res.add(b);
            cap.remove(b);
        }
        return res;
    }
    
    public ArrayList <Integer> arrSoLuong_Sach_NhaXuatBan(){
        HashMap<String, Integer> cap = new HashMap<String, Integer>();
        ArrayList <QLLoaiSachDTO> arr = new QLLoaiSachBUS(0).getArrSach();
        ArrayList <Integer> res = new ArrayList<>();
        for (QLLoaiSachDTO e : arr){
            if (cap.get(e.getTenNXB()) == null){
                cap.put(e.getTenNXB(), 1);
            }
            else{
                cap.put(e.getTenNXB(), cap.get(e.getTenNXB()) + 1);
            }
        }
        
        for (int e : cap.values()){
            res.add(e);
        }
        
        return res;
    }
    
    public ArrayList <Integer> arrSoLuong_Sach_NhaXuatBan_top5(){
        HashMap<String, Integer> cap = new HashMap<String, Integer>();
        ArrayList <QLLoaiSachDTO> arr = new QLLoaiSachBUS(0).getArrSach();
        ArrayList <Integer> res = new ArrayList<>();
        for (QLLoaiSachDTO e : arr){
            if (cap.get(e.getTenNXB()) == null){
                cap.put(e.getTenNXB(), 1);
            }
            else{
                cap.put(e.getTenNXB(), cap.get(e.getTenNXB()) + 1);
            }
        }
        
        String b = "";
        int a = 0;
        for (int i=0; i<=4; i++){
            a = 0;
            for (String e : cap.keySet()){
                if (cap.get(e) > a){
                    a = cap.get(e);
                    b = e;
                }
            }
            res.add(a);
            cap.remove(b);
        }
        return res;
    }
    
    // 3 Mức Giá: 0 - 100000, 100000 - 300000, 300000 - ...
    public ArrayList <Integer> arrSoLuong_Sach_MucGia(){
        ArrayList <Integer> res = new ArrayList<>();
        ArrayList <QLLoaiSachDTO> arr = new QLLoaiSachBUS(0).getArrSach();
        int mg1 = 0;
        int mg2 = 0;
        int mg3 = 0;
        for (QLLoaiSachDTO e : arr){
            if (e.getGiaTien() < 100000){
                mg1++;
            }
            else if (e.getGiaTien() < 300000){
                mg2++;
            }
            else{
                mg3++;
            }
        }
        res.add(mg1);
        res.add(mg2);
        res.add(mg3);
        return res;
    }
    
    /** Thống Kê Sách Thư Viện **/
    
    /** Sách Thư Viện **/
    public QLChiTietSachBUS sachthuvien = new QLChiTietSachBUS();
    
    public int soLuong_SachThuVien(){
        return new QLChiTietSachBUS().getArrChiTietSach().size();
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
    
    public int soLuong_SachMuon_Sach(){
        ArrayList<QLPhieuMuonDTO> phieumuon = new QLPhieuMuonBUS(0).getArrMuonTra();
        int sum = 0;
        for (QLPhieuMuonDTO e : phieumuon){
            sum += e.getIDSach().size();
        }
        return sum;
    }
    
    // Current year
    public int thang_SachMuon_Max(){
        ArrayList<QLPhieuMuonDTO> phieumuon = new QLPhieuMuonBUS().getArrMuonTra();
        int[] sum = new int[13]; 
        for (QLPhieuMuonDTO e : phieumuon){
            if (ps.getYear(e.getNgayMuon()) == ps.getCurrentYear()){
                sum[ps.getMonth(e.getNgayMuon())] += e.getIDSach().size();
            }
        }
        int max = 0;
        int res = 1;
        for (int i=1; i<=12; i++){
            if (sum[i] > max){
                max = sum[i];
                res = i;
            }
        }
        return res;
    }
    
    // Current year
    public int thang_SachMuon_Min(){
        ArrayList<QLPhieuMuonDTO> phieumuon = new QLPhieuMuonBUS(0).getArrMuonTra();
        int[] sum = new int[13]; 
        for (QLPhieuMuonDTO e : phieumuon){
            if (ps.getYear(e.getNgayMuon()) == ps.getCurrentYear()){
                sum[ps.getMonth(e.getNgayMuon())] += e.getIDSach().size();
            }
        }
        int min = 0x3f3f3f3f;
        int res = 1;
        for (int i=1; i<=12; i++){
            if (sum[i] < min && sum[i] > 0){
                min = sum[i];
                res = i;
            }
        }
        return res;
    }
    
    /** Thống Kê Thẻ **/
    
    public int getSoLuongThe(){
        return new QLTheBUS(0).getArrThe().size();
    }
    
    public int getSoLuongThe_Moi(){
        ArrayList <QLTheDTO> the = new QLTheBUS(0).getArrThe();
        int res = 0;
        for (QLTheDTO e : the){
            if (ps.getMonth(e.getNgayCap()) == ps.getCurrentMonth() && ps.getYear(e.getNgayCap()) == ps.getCurrentYear()){
                res++;
            }
        }
        return res;
    }
    
    // Theo Tháng Năm Hiện Tại
    public ArrayList <Integer> getSoLuongThe_Current(){
        ArrayList <QLTheDTO> the = new QLTheBUS(0).getArrThe();
        ArrayList <Integer> rs = new ArrayList<>();
        int current_month = ps.getCurrentMonth();
        int current_year = ps.getCurrentYear();
        for (int month = 1; month <= current_month; month++){
            int t = 0;
            for (QLTheDTO e : the){
                if (ps.getYear(e.getNgayCap()) == current_year && ps.getMonth(e.getNgayCap()) == month){
                    t++;
                }
            }
            rs.add(t);
        }
        return rs;
    }
    
    /**  Nhân Viên  **/
    public int getSoLuongNhanVien(){
        return new QLNhanVienBUS(0).getArrNhanVien().size();
    }
    
    public int getSoLuongNhanVien_ChucVu(){
        ArrayList <QLNhanVienDTO> nhanVien = new QLNhanVienBUS(0).getArrNhanVien();
        Set<String> set = new HashSet<String>();
        for (QLNhanVienDTO e : nhanVien){
            set.add(e.getChucVu());
        }
        return set.size();
    }
    
    public int getSoLuongNhanVien_ChucVu(String chucVu){
        ArrayList <QLNhanVienDTO> nhanVien = new QLNhanVienBUS(0).getArrNhanVien();
        int count=0;
        for (QLNhanVienDTO e : nhanVien){
            if (e.getChucVu().equals(chucVu)){
                count++;
            }
        }
        return count;
    }
    
    /**  Kho Sách  **/
    public int getSoLuongKho_LoaiSach(){
        ArrayList <QLKhoSachDTO> khoSach = new QLKhoSachBUS().getArrKhoSach();
        Set<String> set = new HashSet<String>();
        for (QLKhoSachDTO e : khoSach){
            set.add(e.getMaSach());
        }
        return set.size();
    }
    
    public int getSoLuongKho_ChiTietSach(){
        ArrayList <QLKhoSachDTO> khoSach = new QLKhoSachBUS().getArrKhoSach();
        int sum = 0;
        for (QLKhoSachDTO e : khoSach){
            sum += e.getSoLuong();
        }
        return sum;
    }
    
    public int getSoLuongKho_ChiTietSachTrungBinh(){
        return (int)getSoLuongKho_ChiTietSach()/getSoLuongKho_LoaiSach();
    }
    
    public int getSoLuongKho_ChiTietSachLonNhat(){
        ArrayList <QLKhoSachDTO> khoSach = new QLKhoSachBUS().getArrKhoSach();
        int max = 0;
        for (QLKhoSachDTO e : khoSach){
            if (max < e.getSoLuong()){
                max = e.getSoLuong();
            }
        }
        return max;
    }
    
    public ArrayList <String> getSoLuongKho_LoaiSacharr(){
        ArrayList <QLKhoSachDTO> khoSach = new QLKhoSachBUS(0).getArrKhoSach();
        Set<String> set = new HashSet<String>();
        for (QLKhoSachDTO e : khoSach){
            set.add(e.getMaSach());
        }
        return new ArrayList<String>(set);
    }
    
    public ArrayList <Integer> getSoLuongKho_ChiTietSacharr(){
        ArrayList <String> khoSach = getSoLuongKho_LoaiSacharr();
        ArrayList <Integer> soluongarr = new ArrayList<>();
        for (String e : khoSach){
            soluongarr.add(new QLKhoSachBUS(0).getKhoSach(e).getSoLuong());
        }
        return new ArrayList<Integer>(soluongarr);
    }
    
    public static void main(String[] args) {
        System.out.println(new ThongKe().thang_SachMuon_Max());
        System.out.println(new ThongKe().thang_SachMuon_Min());
    }
}

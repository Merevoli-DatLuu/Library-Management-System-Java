package librarymanagementsystem.DTO;

import java.util.ArrayList;

public class QLPhieuXuatDTO {
    String maXuat, ngayXuat;
    ArrayList <String> maSach;
    ArrayList <Integer> soLuong;
    String maNhanVien;
    int tongSoLuong;
    
    public QLPhieuXuatDTO(String maXuat, String thoiDiemXuat, ArrayList<String> maSach, ArrayList<Integer> soLuong) {
        this.maXuat = maXuat;
        this.ngayXuat = thoiDiemXuat;
        this.maSach = maSach;
        this.soLuong = soLuong;
    }

    public QLPhieuXuatDTO(String maXuat, String thoiDiemXuat, ArrayList<String> maSach, ArrayList<Integer> soLuong, String maNhanVien, int tongSoLuong) {
        this.maXuat = maXuat;
        this.ngayXuat = thoiDiemXuat;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.maNhanVien = maNhanVien;
        this.tongSoLuong = tongSoLuong;
    }

    public String getMaXuat() {
        return maXuat;
    }

    public void setMaXuat(String maXuat) {
        this.maXuat = maXuat;
    }

    public String getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(String ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public ArrayList<String> getMaSach() {
        return maSach;
    }

    public void setMaSach(ArrayList<String> maSach) {
        this.maSach = maSach;
    }

    public ArrayList<Integer> getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(ArrayList<Integer> soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getTongSoLuong() {
        return tongSoLuong;
    }

    public void setTongSoLuong(int tongSoLuong) {
        this.tongSoLuong = tongSoLuong;
    }
    
    
    
}

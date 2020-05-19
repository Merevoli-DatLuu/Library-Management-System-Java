package librarymanagementsystem.DTO;

import java.util.ArrayList;

public class QLPhieuNhapDTO {
    String maNhap, ngayNhap;
    ArrayList <String> maSach;
    ArrayList <Integer> soLuong;
    String maNhanVien, maNCC;

    public QLPhieuNhapDTO(String maNhap, String thoiDiemNhap, ArrayList<String> maSach, ArrayList<Integer> soLuong) {
        this.maNhap = maNhap;
        this.ngayNhap = thoiDiemNhap;
        this.maSach = maSach;
        this.soLuong = soLuong;
    }

    public QLPhieuNhapDTO(String maNhap, String ngayNhap, ArrayList<String> maSach, ArrayList<Integer> soLuong, String maNhanVien, String maNCC) {
        this.maNhap = maNhap;
        this.ngayNhap = ngayNhap;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.maNhanVien = maNhanVien;
        this.maNCC = maNCC;
    }
    

    public String getMaNhap() {
        return maNhap;
    }

    public void setMaNhap(String maNhap) {
        this.maNhap = maNhap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
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

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }
    
    
}

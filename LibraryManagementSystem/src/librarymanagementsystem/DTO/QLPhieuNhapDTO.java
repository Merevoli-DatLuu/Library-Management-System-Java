package librarymanagementsystem.DTO;

import java.util.ArrayList;

public class QLPhieuNhapDTO {
    String maNhap, ngayNhap;
    ArrayList <String> maSach;
    ArrayList <Integer> soLuong;
    String maNhanVien, maNCC;
    int tongSoLuong, tongTien;

    public QLPhieuNhapDTO(String maNhap, String thoiDiemNhap, ArrayList<String> maSach, ArrayList<Integer> soLuong) {
        this.maNhap = maNhap;
        this.ngayNhap = thoiDiemNhap;
        this.maSach = maSach;
        this.soLuong = soLuong;
    }

    public QLPhieuNhapDTO(String maNhap, String ngayNhap, ArrayList<String> maSach, ArrayList<Integer> soLuong, String maNhanVien, String maNCC, int tongSoLuong, int tongTien) {
        this.maNhap = maNhap;
        this.ngayNhap = ngayNhap;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.maNhanVien = maNhanVien;
        this.maNCC = maNCC;
        this.tongSoLuong = tongSoLuong;
        this.tongTien = tongTien;
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

    public int getTongSoLuong() {
        return tongSoLuong;
    }

    public void setTongSoLuong(int tongSoLuong) {
        this.tongSoLuong = tongSoLuong;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
}

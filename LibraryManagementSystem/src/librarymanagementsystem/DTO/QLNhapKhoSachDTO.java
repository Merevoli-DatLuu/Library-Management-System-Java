package librarymanagementsystem.DTO;

import java.util.ArrayList;

public class QLNhapKhoSachDTO {
    String maNhap, thoiDiemNhap;
    ArrayList <String> maSach;
    ArrayList <Integer> soLuong;

    public QLNhapKhoSachDTO(String maNhap, String thoiDiemNhap, ArrayList<String> maSach, ArrayList<Integer> soLuong) {
        this.maNhap = maNhap;
        this.thoiDiemNhap = thoiDiemNhap;
        this.maSach = maSach;
        this.soLuong = soLuong;
    }

    public String getMaNhap() {
        return maNhap;
    }

    public void setMaNhap(String maNhap) {
        this.maNhap = maNhap;
    }

    public String getThoiDiemNhap() {
        return thoiDiemNhap;
    }

    public void setThoiDiemNhap(String thoiDiemNhap) {
        this.thoiDiemNhap = thoiDiemNhap;
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
    
}

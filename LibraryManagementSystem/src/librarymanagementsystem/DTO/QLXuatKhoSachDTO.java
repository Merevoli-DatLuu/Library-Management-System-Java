package librarymanagementsystem.DTO;

import java.util.ArrayList;

public class QLXuatKhoSachDTO {
    String maXuat, thoiDiemXuat;
    ArrayList <String> maSach;
    ArrayList <Integer> soLuong;

    public QLXuatKhoSachDTO(String maXuat, String thoiDiemXuat, ArrayList<String> maSach, ArrayList<Integer> soLuong) {
        this.maXuat = maXuat;
        this.thoiDiemXuat = thoiDiemXuat;
        this.maSach = maSach;
        this.soLuong = soLuong;
    }

    public String getMaXuat() {
        return maXuat;
    }

    public void setMaXuat(String maXuat) {
        this.maXuat = maXuat;
    }

    public String getThoiDiemXuat() {
        return thoiDiemXuat;
    }

    public void setThoiDiemXuat(String thoiDiemXuat) {
        this.thoiDiemXuat = thoiDiemXuat;
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

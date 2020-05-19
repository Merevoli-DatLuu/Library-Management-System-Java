package librarymanagementsystem.DTO;

import java.util.ArrayList;

public class QLPhieuMuonDTO {
    String maPhieuMuon,maThe,ngayMuon;
    int thoiGianMuon; // Đơn vị : ngày
    String ngayTra;
    ArrayList <String> IDSach;

    public QLPhieuMuonDTO(String maMuonSach, String maThe, ArrayList <String> IDSach, String thoiDiemMuon, int thoiGianMuon, String thoiDiemTra) {
        this.maPhieuMuon = maMuonSach;
        this.maThe = maThe;
        this.IDSach = IDSach;
        this.ngayMuon = thoiDiemMuon;
        this.thoiGianMuon = thoiGianMuon;
        this.ngayTra = thoiDiemTra;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public String getMaThe() {
        return maThe;
    }

    public void setMaThe(String maThe) {
        this.maThe = maThe;
    }

    public ArrayList <String> getIDSach() {
        return IDSach;
    }

    public void setIDSach(ArrayList <String> IDSach) {
        this.IDSach = IDSach;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String NgayMuon) {
        this.ngayMuon = NgayMuon;
    }

    public int getThoiGianMuon() {
        return thoiGianMuon;
    }

    public void setThoiGianMuon(int thoiGianMuon) {
        this.thoiGianMuon = thoiGianMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }
    
}

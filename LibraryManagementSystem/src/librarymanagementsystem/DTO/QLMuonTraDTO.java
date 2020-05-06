package librarymanagementsystem.DTO;

public class QLMuonTraDTO {
    String maMuonSach,maThe,IDSach,thoiDiemMuon;
    int thoiGianMuon; // Đơn vị : ngày
    String thoiDiemTra;

    public QLMuonTraDTO(String maMuonSach, String maThe, String IDSach, String thoiDiemMuon, int thoiGianMuon, String thoiDiemTra) {
        this.maMuonSach = maMuonSach;
        this.maThe = maThe;
        this.IDSach = IDSach;
        this.thoiDiemMuon = thoiDiemMuon;
        this.thoiGianMuon = thoiGianMuon;
        this.thoiDiemTra = thoiDiemTra;
    }

    public String getMaMuonSach() {
        return maMuonSach;
    }

    public void setMaMuonSach(String maMuonSach) {
        this.maMuonSach = maMuonSach;
    }

    public String getMaThe() {
        return maThe;
    }

    public void setMaThe(String maThe) {
        this.maThe = maThe;
    }

    public String getIDSach() {
        return IDSach;
    }

    public void setIDSach(String IDSach) {
        this.IDSach = IDSach;
    }

    public String getThoiDiemMuon() {
        return thoiDiemMuon;
    }

    public void setThoiDiemMuon(String thoiDiemMuon) {
        this.thoiDiemMuon = thoiDiemMuon;
    }

    public int getThoiGianMuon() {
        return thoiGianMuon;
    }

    public void setThoiGianMuon(int thoiGianMuon) {
        this.thoiGianMuon = thoiGianMuon;
    }

    public String getThoiDiemTra() {
        return thoiDiemTra;
    }

    public void setThoiDiemTra(String thoiDiemTra) {
        this.thoiDiemTra = thoiDiemTra;
    }
    
}

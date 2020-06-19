package librarymanagementsystem.DTO;

public class QLPhieuPhatDTO {
    String maPhieuPhat, maPhieuMuon, maLDPhat;
    int tienPhat;

    public QLPhieuPhatDTO(String maPhieuPhat, String maPhieuMuon, String maLDPhat, int tienPhat) {
        this.maPhieuPhat = maPhieuPhat;
        this.maPhieuMuon = maPhieuMuon;
        this.maLDPhat = maLDPhat;
        this.tienPhat = tienPhat;
    }
    
    public QLPhieuPhatDTO(QLPhieuPhatDTO phieuPhat){
        this.maPhieuPhat = phieuPhat.maPhieuPhat;
        this.maPhieuMuon = phieuPhat.maPhieuMuon;
        this.maLDPhat = phieuPhat.maLDPhat;
        this.tienPhat = phieuPhat.tienPhat;
    }

    public String getMaPhieuPhat() {
        return maPhieuPhat;
    }

    public void setMaPhieuPhat(String maPhieuPhat) {
        this.maPhieuPhat = maPhieuPhat;
    }

    public String getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(String maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public String getMaLDPhat() {
        return maLDPhat;
    }

    public void setMaLDPhat(String maLDPhat) {
        this.maLDPhat = maLDPhat;
    }

    public int getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(int tienPhat) {
        this.tienPhat = tienPhat;
    }
    
}

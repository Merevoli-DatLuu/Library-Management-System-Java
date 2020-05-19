package librarymanagementsystem.DTO;

public class QLPhieuPhatDTO {
    String maPhieuPhat, maPhieuMuon, maLDPhat;

    public QLPhieuPhatDTO(String maPhieuPhat, String maPhieuMuon, String maLDPhat) {
        this.maPhieuPhat = maPhieuPhat;
        this.maPhieuMuon = maPhieuMuon;
        this.maLDPhat = maLDPhat;
    }
    
    public QLPhieuPhatDTO(QLPhieuPhatDTO phieuPhat){
        this.maPhieuPhat = phieuPhat.maPhieuPhat;
        this.maPhieuMuon = phieuPhat.maPhieuMuon;
        this.maLDPhat = phieuPhat.maLDPhat;
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
    
    
}

package librarymanagementsystem.DTO;

public class QLLDPhatDTO {
    String maLDPhat, tenLDPhat;
    int mucDo;

    public QLLDPhatDTO(String maLDPhat, String tenLDPhat, int mucDo) {
        this.maLDPhat = maLDPhat;
        this.tenLDPhat = tenLDPhat;
        this.mucDo = mucDo;
    }
    
    public QLLDPhatDTO(QLLDPhatDTO lyDoPhat){
        this.maLDPhat = lyDoPhat.maLDPhat;
        this.tenLDPhat = lyDoPhat.tenLDPhat;
        this.mucDo = lyDoPhat.mucDo;
    }

    public String getMaLDPhat() {
        return maLDPhat;
    }

    public void setMaLDPhat(String maLDPhat) {
        this.maLDPhat = maLDPhat;
    }

    public String getTenLDPhat() {
        return tenLDPhat;
    }

    public void setTenLDPhat(String tenLDPhat) {
        this.tenLDPhat = tenLDPhat;
    }

    public int getMucDo() {
        return mucDo;
    }

    public void setMucDo(int mucDo) {
        this.mucDo = mucDo;
    }
    
    
}

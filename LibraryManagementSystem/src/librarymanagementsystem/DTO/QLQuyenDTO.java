package librarymanagementsystem.DTO;

public class QLQuyenDTO {
    public String maQuyen, tenQuyen, chitietQuyen;

    public QLQuyenDTO(String maQuyen, String tenQuyen, String chitietQuyen) {
        this.maQuyen = maQuyen;
        this.tenQuyen = tenQuyen;
        this.chitietQuyen = chitietQuyen;
    }

    public String getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(String maQuyen) {
        this.maQuyen = maQuyen;
    }

    public String getTenQuyen() {
        return tenQuyen;
    }

    public void setTenQuyen(String tenQuyen) {
        this.tenQuyen = tenQuyen;
    }

    public String getChitietQuyen() {
        return chitietQuyen;
    }

    public void setChitietQuyen(String chitietQuyen) {
        this.chitietQuyen = chitietQuyen;
    }
    
    
    
}

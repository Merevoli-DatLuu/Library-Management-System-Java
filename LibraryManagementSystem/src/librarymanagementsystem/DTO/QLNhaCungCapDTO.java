package librarymanagementsystem.DTO;

public class QLNhaCungCapDTO {
    String maNCC, tenNCC, sdt, email, diaChi;

    public QLNhaCungCapDTO(String maNCC, String tenNCC, String sdt, String email, String diaChi) {
        this.maNCC = maNCC;
        this.tenNCC = tenNCC;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
    }
    
    public QLNhaCungCapDTO(QLNhaCungCapDTO nhaCungCap){
        this.maNCC = nhaCungCap.maNCC;
        this.tenNCC = nhaCungCap.tenNCC;
        this.sdt = nhaCungCap.sdt;
        this.email = nhaCungCap.email;
        this.diaChi = nhaCungCap.diaChi;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    
}

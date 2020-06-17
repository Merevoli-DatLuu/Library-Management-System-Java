package librarymanagementsystem.DTO;

public class QLKhachHangDTO {
    String maKhachHang, hoTen, ngaySinh, diaChi, email, sdt;

    public QLKhachHangDTO(String maKhachHang, String hoTen, String ngaySinh, String diaChi, String email, String sdt) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.email = email;
        this.sdt = sdt;
    }
    
    public QLKhachHangDTO(QLKhachHangDTO khachHang) {
        this.maKhachHang = khachHang.maKhachHang;
        this.hoTen = khachHang.hoTen;
        this.ngaySinh = khachHang.ngaySinh;
        this.diaChi = khachHang.diaChi;
        this.email = khachHang.email;
        this.sdt = khachHang.sdt;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
}

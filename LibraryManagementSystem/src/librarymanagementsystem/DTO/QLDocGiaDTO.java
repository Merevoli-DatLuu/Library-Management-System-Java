package librarymanagementsystem.DTO;

public class QLDocGiaDTO {
    String maKhachHang, hoTen, ngaySinh, diaChi, email, maThe, sdt;

    public QLDocGiaDTO(String maKhachHang, String hoTen, String ngaySinh, String diaChi, String email, String maThe, String sdt) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.email = email;
        this.maThe = maThe;
        this.sdt = sdt;
    }
    
    public QLDocGiaDTO(QLDocGiaDTO docGia) {
        this.maKhachHang = docGia.maKhachHang;
        this.hoTen = docGia.hoTen;
        this.ngaySinh = docGia.ngaySinh;
        this.diaChi = docGia.diaChi;
        this.email = docGia.email;
        this.maThe = docGia.maThe;
        this.sdt = docGia.sdt;
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

    public String getMaThe() {
        return maThe;
    }

    public void setMaThe(String maThe) {
        this.maThe = maThe;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
}

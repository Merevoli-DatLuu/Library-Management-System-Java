package librarymanagementsystem.DTO;

public class QLTheDTO {
    String maThe,maKhachHang,ngayCap,ngayHetHan;
    QLKhachHangDTO khachHang; // for full view table (not use in normal view)
    
    public QLTheDTO(String maThe, String maKhachHang, String ngayCap, String ngayHetHan) {
        this.maThe = maThe;
        this.maKhachHang = maKhachHang;
        this.ngayCap = ngayCap;
        this.ngayHetHan = ngayHetHan;
    }
    
    // contructor (full)
    public QLTheDTO(String maThe, String maKhachHang, String ngayCap, String ngayHetHan, QLKhachHangDTO docGia) {
        this.maThe = maThe;
        this.maKhachHang = maKhachHang;
        this.ngayCap = ngayCap;
        this.ngayHetHan = ngayHetHan;
        this.khachHang = new QLKhachHangDTO(docGia);
    }

    public String getMaThe() {
        return maThe;
    }

    public void setMaThe(String maThe) {
        this.maThe = maThe;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getNgayCap() {
        return ngayCap;
    }

    public void setNgayCap(String ngayCap) {
        this.ngayCap = ngayCap;
    }

    public String getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }
    
    public QLKhachHangDTO getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(QLKhachHangDTO khachHang) {
        this.khachHang = khachHang;
    }
    
}

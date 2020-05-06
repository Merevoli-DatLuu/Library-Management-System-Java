package librarymanagementsystem.DTO;

public class QLTheDTO {
    String maThe,maKhachHang,ngayCap,ngayHetHan;
    QLDocGiaDTO docGia; // for full view table (not use in normal view)
    
    public QLTheDTO(String maThe, String maKhachHang, String ngayCap, String ngayHetHan) {
        this.maThe = maThe;
        this.maKhachHang = maKhachHang;
        this.ngayCap = ngayCap;
        this.ngayHetHan = ngayHetHan;
    }
    
    // contructor (full)
    public QLTheDTO(String maThe, String maKhachHang, String ngayCap, String ngayHetHan, QLDocGiaDTO docGia) {
        this.maThe = maThe;
        this.maKhachHang = maKhachHang;
        this.ngayCap = ngayCap;
        this.ngayHetHan = ngayHetHan;
        this.docGia = new QLDocGiaDTO(docGia);
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
    
    public QLDocGiaDTO getDocGia() {
        return docGia;
    }

    public void setDocGia(QLDocGiaDTO docGia) {
        this.docGia = docGia;
    }
    
}

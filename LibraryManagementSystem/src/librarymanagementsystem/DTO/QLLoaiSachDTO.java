package librarymanagementsystem.DTO;

public class QLLoaiSachDTO {
    String maSach, tenSach, tenTacGia, tenNXB, theLoai, ngonNgu, tomTatNoiDung, hinh;
    int namXB, giaTien, soTrang;
    
    public QLLoaiSachDTO(String maSach, String tenSach, String tenTacGia, String tenNXB, String theLoai, String ngonNgu, String tomTatNoiDung, int namXB, int giaTien, int soTrang, String hinh){
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tenTacGia = tenTacGia;
        this.tenNXB = tenNXB;
        this.theLoai = theLoai;
        this.ngonNgu = ngonNgu;
        this.tomTatNoiDung = tomTatNoiDung;
        this.namXB = namXB;
        this.giaTien = giaTien;
        this.soTrang = soTrang;
        this.hinh = hinh;
    }
    
    public QLLoaiSachDTO(QLLoaiSachDTO sach){
        this.maSach = sach.maSach;
        this.tenSach = sach.tenSach;
        this.tenTacGia = sach.tenTacGia;
        this.tenNXB = sach.tenNXB;
        this.theLoai = sach.theLoai;
        this.ngonNgu = sach.ngonNgu;
        this.tomTatNoiDung = sach.tomTatNoiDung;
        this.namXB = sach.namXB;
        this.giaTien = sach.giaTien;
        this.soTrang = sach.soTrang;
        this.hinh = sach.hinh;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public String getTomTatNoiDung() {
        return tomTatNoiDung;
    }

    public void setTomTatNoiDung(String tomTatNoiDung) {
        this.tomTatNoiDung = tomTatNoiDung;
    }

    public int getNamXB() {
        return namXB;
    }

    public void setNamXB(int namXB) {
        this.namXB = namXB;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
    
    public Object getIndex(String header){
        switch (header){
            case "Mã Sách":
                return this.getMaSach();
            
        }
        return null;
    }
 
}

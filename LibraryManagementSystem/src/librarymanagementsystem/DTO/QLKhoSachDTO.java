package librarymanagementsystem.DTO;

public class QLKhoSachDTO {
    String maSach;
    int soLuong;
    QLLoaiSachDTO sach; //for full view table (not use in normal view)
    
    public QLKhoSachDTO(String maSach, int soLuong) {
        this.maSach = maSach;
        this.soLuong = soLuong;
    }
    
    public QLKhoSachDTO(String maSach, int soLuong, QLLoaiSachDTO sach){
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.sach = new QLLoaiSachDTO(sach);
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public QLLoaiSachDTO getSach() {
        return sach;
    }

    public void setSach(QLLoaiSachDTO sach) {
        this.sach = sach;
    }
}

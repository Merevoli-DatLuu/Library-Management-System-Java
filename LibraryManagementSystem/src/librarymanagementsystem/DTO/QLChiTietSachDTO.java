package librarymanagementsystem.DTO;

public class QLChiTietSachDTO {
    String IDSach, maSach, tinhTrang;
    QLLoaiSachDTO sach;
    
    public QLChiTietSachDTO(String IDSach, String maSach, String tinhTrang){
        this.IDSach = IDSach;
        this.maSach = maSach;
        this.tinhTrang = tinhTrang;
    }
    
    public QLChiTietSachDTO(String IDSach, String maSach, String tinhTrang, QLLoaiSachDTO sach){
        this.IDSach = IDSach;
        this.maSach = maSach;
        this.tinhTrang = tinhTrang;
        this.sach = new QLLoaiSachDTO(sach);
    }

    public String getIDSach() {
        return IDSach;
    }

    public void setIDSach(String IDSach) {
        this.IDSach = IDSach;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public QLLoaiSachDTO getSach() {
        return sach;
    }

    public void setSach(QLLoaiSachDTO sach) {
        this.sach = sach;
    }
    
    
    
}

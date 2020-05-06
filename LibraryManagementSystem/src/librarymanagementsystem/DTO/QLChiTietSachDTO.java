package librarymanagementsystem.DTO;

public class QLChiTietSachDTO {
    String IDSach, maSach, tinhTrang;
    QLSachDTO sach;
    
    public QLChiTietSachDTO(String IDSach, String maSach, String tinhTrang){
        this.IDSach = IDSach;
        this.maSach = maSach;
        this.tinhTrang = tinhTrang;
    }
    
    public QLChiTietSachDTO(String IDSach, String maSach, String tinhTrang, QLSachDTO sach){
        this.IDSach = IDSach;
        this.maSach = maSach;
        this.tinhTrang = tinhTrang;
        this.sach = new QLSachDTO(sach);
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

    public QLSachDTO getSach() {
        return sach;
    }

    public void setSach(QLSachDTO sach) {
        this.sach = sach;
    }
    
    
    
}

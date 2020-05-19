package librarymanagementsystem.BUS;

import java.util.ArrayList;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLPhieuNhapBUS {
    private ArrayList<QLPhieuNhapDTO> arrNhapKho = new ArrayList<>();
    private QLPhieuNhapDAO nhapKhoDAO = new QLPhieuNhapDAO();

    public QLPhieuNhapBUS() {
        arrNhapKho= nhapKhoDAO.readDB();
    }
    
    public String [] getHeader(){
        return new String[]{"Mã Nhập Kho", "Ngày Nhập", "Mã Sách", "Số Lượng"};
    }
    
    public Boolean add(QLPhieuNhapDTO nhapKho){
        Boolean check = nhapKhoDAO.add(nhapKho);
        if (check){
            arrNhapKho.add(nhapKho);
        }
        return check;
    }
    
    public Boolean add(String maNhap, String ngayNhap, ArrayList <String> maSach, ArrayList <Integer> soLuong, String maNhanVien, String maNCC){
        QLPhieuNhapDTO nhapKho=new QLPhieuNhapDTO(maNhap, ngayNhap, maSach, soLuong, maNhanVien, maNCC);
        return this.add(nhapKho);
    }
    
    public Boolean del(String maNhap){
        Boolean check = nhapKhoDAO.del(maNhap);
        if (check){
            for (QLPhieuNhapDTO nhapKho : arrNhapKho){
                if (nhapKho.getMaNhap().equals(maNhap)){
                    arrNhapKho.remove(nhapKho);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean mod(QLPhieuNhapDTO nhapKho){
        Boolean check = nhapKhoDAO.mod(nhapKho);  
        if (check){
            for (QLPhieuNhapDTO s : arrNhapKho){
                if (s.getMaNhap().equals(nhapKho.getMaNhap())){
                    arrNhapKho.set(arrNhapKho.indexOf(s), nhapKho);
                    break;
                }
            }
        } 
        return check;
    }
     
    public Boolean mod(String maNhap, String ngayNhap, ArrayList <String> maSach, ArrayList <Integer> soLuong, String maNhanVien, String maNCC){
        QLPhieuNhapDTO nhapKho=new QLPhieuNhapDTO(maNhap, ngayNhap, maSach, soLuong, maNhanVien, maNCC);
        return this.mod(nhapKho);
    } 
}

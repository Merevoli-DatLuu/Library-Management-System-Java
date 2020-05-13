package librarymanagementsystem.BUS;

import java.util.ArrayList;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLNhapKhoSachBUS {
    private ArrayList<QLNhapKhoSachDTO> arrNhapKho = new ArrayList<>();
    private QLNhapKhoSachDAO nhapKhoDAO = new QLNhapKhoSachDAO();

    public QLNhapKhoSachBUS() {
        arrNhapKho= nhapKhoDAO.readDB();
    }
    
    public String [] getHeader(){
        return new String[]{"Mã Nhập Kho", "Thời Điểm Nhập", "Mã Sách", "Số Lượng"};
    }
    
    public Boolean add(QLNhapKhoSachDTO nhapKho){
        Boolean check = nhapKhoDAO.add(nhapKho);
        if (check){
            arrNhapKho.add(nhapKho);
        }
        return check;
    }
    
    public Boolean add(String maNhap, String thoiDiemNhap, ArrayList <String> maSach, ArrayList <Integer> soLuong){
        QLNhapKhoSachDTO nhapKho=new QLNhapKhoSachDTO(maNhap, thoiDiemNhap, maSach, soLuong);
        return this.add(nhapKho);
    }
    
    public Boolean del(String maNhap){
        Boolean check = nhapKhoDAO.del(maNhap);
        if (check){
            for (QLNhapKhoSachDTO nhapKho : arrNhapKho){
                if (nhapKho.getMaNhap().equals(maNhap)){
                    arrNhapKho.remove(nhapKho);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean mod(QLNhapKhoSachDTO nhapKho){
        Boolean check = nhapKhoDAO.mod(nhapKho);  
        if (check){
            for (QLNhapKhoSachDTO s : arrNhapKho){
                if (s.getMaNhap().equals(nhapKho.getMaNhap())){
                    arrNhapKho.set(arrNhapKho.indexOf(s), nhapKho);
                    break;
                }
            }
        } 
        return check;
    }
     
    public Boolean mod(String maNhap, String ThoiDiemNhap, ArrayList <String> maSach, ArrayList <Integer> soLuong){
        QLNhapKhoSachDTO nhapKho=new QLNhapKhoSachDTO(maNhap, ThoiDiemNhap, maSach, soLuong);
        return this.mod(nhapKho);
    } 
}

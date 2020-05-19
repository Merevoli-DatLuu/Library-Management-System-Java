package librarymanagementsystem.BUS;

import java.util.ArrayList;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLPhieuXuatBUS {
    private ArrayList<QLPhieuXuatDTO> arrXuatKho = new ArrayList<>();
    private QLPhieuXuatDAO xuatKhoDAO = new QLPhieuXuatDAO();

    public QLPhieuXuatBUS() {
        arrXuatKho= xuatKhoDAO.readDB();
    }
    
    public String [] getHeader(){
        return new String[]{"Mã Xuất Kho", "Ngày Xuất", "Mã Sách", "Số Lượng"};
    }
    
    public Boolean add(QLPhieuXuatDTO xuatKho){
        Boolean check = xuatKhoDAO.add(xuatKho);
        if (check){
            arrXuatKho.add(xuatKho);
        }
        return check;
    }
    
    public Boolean add(String maXuat, String ngayXuat, ArrayList <String> maSach, ArrayList <Integer> soLuong, String maNhanVien){
        QLPhieuXuatDTO xuatKho=new QLPhieuXuatDTO(maXuat, ngayXuat, maSach, soLuong, maNhanVien);
        return this.add(xuatKho);
    }
    
    public Boolean del(String maXuat){
        Boolean check = xuatKhoDAO.del(maXuat);
        if (check){
            for (QLPhieuXuatDTO xuatKho : arrXuatKho){
                if (xuatKho.getMaXuat().equals(maXuat)){
                    arrXuatKho.remove(xuatKho);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean mod(QLPhieuXuatDTO xuatKho){
        Boolean check = xuatKhoDAO.mod(xuatKho);  
        if (check){
            for (QLPhieuXuatDTO s : arrXuatKho){
                if (s.getMaXuat().equals(xuatKho.getMaXuat())){
                    arrXuatKho.set(arrXuatKho.indexOf(s), xuatKho);
                    break;
                }
            }
        } 
        return check;
    }
     
    public Boolean mod(String maXuat, String ngayXuat, ArrayList <String> maSach, ArrayList <Integer> soLuong, String maNhanVien){
        QLPhieuXuatDTO xuatKho=new QLPhieuXuatDTO(maXuat, ngayXuat, maSach, soLuong, maNhanVien);
        return this.mod(xuatKho);
    } 
}

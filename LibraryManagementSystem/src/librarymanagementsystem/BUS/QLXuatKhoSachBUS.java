package librarymanagementsystem.BUS;

import java.util.ArrayList;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLXuatKhoSachBUS {
    private ArrayList<QLXuatKhoSachDTO> arrXuatKho = new ArrayList<>();
    private QLXuatKhoSachDAO xuatKhoDAO = new QLXuatKhoSachDAO();

    public QLXuatKhoSachBUS() {
        arrXuatKho= xuatKhoDAO.readDB();
    }
    
    public String [] getHeader(){
        return new String[]{"Mã Xuất Kho", "Thời Điểm Xuất", "Mã Sách", "Số Lượng"};
    }
    
    public Boolean add(QLXuatKhoSachDTO xuatKho){
        Boolean check = xuatKhoDAO.add(xuatKho);
        if (check){
            arrXuatKho.add(xuatKho);
        }
        return check;
    }
    
    public Boolean add(String maXuat, String thoiDiemXuat, ArrayList <String> maSach, ArrayList <Integer> soLuong){
        QLXuatKhoSachDTO xuatKho=new QLXuatKhoSachDTO(maXuat, thoiDiemXuat, maSach, soLuong);
        return this.add(xuatKho);
    }
    
    public Boolean del(String maXuat){
        Boolean check = xuatKhoDAO.del(maXuat);
        if (check){
            for (QLXuatKhoSachDTO xuatKho : arrXuatKho){
                if (xuatKho.getMaXuat().equals(maXuat)){
                    arrXuatKho.remove(xuatKho);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean mod(QLXuatKhoSachDTO xuatKho){
        Boolean check = xuatKhoDAO.mod(xuatKho);  
        if (check){
            for (QLXuatKhoSachDTO s : arrXuatKho){
                if (s.getMaXuat().equals(xuatKho.getMaXuat())){
                    arrXuatKho.set(arrXuatKho.indexOf(s), xuatKho);
                    break;
                }
            }
        } 
        return check;
    }
     
    public Boolean mod(String maXuat, String ThoiDiemXuat, ArrayList <String> maSach, ArrayList <Integer> soLuong){
        QLXuatKhoSachDTO xuatKho=new QLXuatKhoSachDTO(maXuat, ThoiDiemXuat, maSach, soLuong);
        return this.mod(xuatKho);
    } 
}

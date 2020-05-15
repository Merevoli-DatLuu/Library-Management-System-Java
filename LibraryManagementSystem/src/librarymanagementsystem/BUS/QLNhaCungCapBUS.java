package librarymanagementsystem.BUS;

import java.util.ArrayList;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLNhaCungCapBUS {
    private ArrayList<QLNhaCungCapDTO> arrNhaCungCap = new ArrayList<>();
    private QLNhaCungCapDAO nhaCungCapDAO = new QLNhaCungCapDAO();

    public QLNhaCungCapBUS() {
        arrNhaCungCap= nhaCungCapDAO.readDB();
    }
    
    public String [] getHeader(){
        return new String[]{"Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Số Điện Thoại", "Email", "Địa Chỉ"};
    }
    
    public Boolean add(QLNhaCungCapDTO nhaCungCap){
        Boolean check = nhaCungCapDAO.add(nhaCungCap);
        if (check){
            arrNhaCungCap.add(nhaCungCap);
        }
        return check;
    }
    
    public Boolean add(String maNCC, String tenNCC, String sdt, String email, String diaChi){
        QLNhaCungCapDTO nhaCungCap=new QLNhaCungCapDTO(maNCC, tenNCC, sdt, email, diaChi);
        return this.add(nhaCungCap);
    }
    
    public Boolean del(String maNCC){
        Boolean check = nhaCungCapDAO.del(maNCC);
        if (check){
            for (QLNhaCungCapDTO nhaCungCap : arrNhaCungCap){
                if (nhaCungCap.getMaNCC().equals(maNCC)){
                    arrNhaCungCap.remove(nhaCungCap);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean mod(QLNhaCungCapDTO nhaCungCap){
        Boolean check = nhaCungCapDAO.mod(nhaCungCap);  
        if (check){
            for (QLNhaCungCapDTO s : arrNhaCungCap){
                if (s.getMaNCC().equals(nhaCungCap.getMaNCC())){
                    arrNhaCungCap.set(arrNhaCungCap.indexOf(s), nhaCungCap);
                    break;
                }
            }
        } 
        return check;
    }
     
    public Boolean mod(String maNCC, String tenNCC, String sdt, String email, String diaChi){
        QLNhaCungCapDTO nhaCungCap=new QLNhaCungCapDTO(maNCC, tenNCC, sdt, email, diaChi);
        return this.mod(nhaCungCap);
    } 
}

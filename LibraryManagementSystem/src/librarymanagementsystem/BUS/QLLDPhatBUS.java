package librarymanagementsystem.BUS;

import java.util.ArrayList;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLLDPhatBUS {
    private ArrayList<QLLDPhatDTO> arrLDPhat = new ArrayList<>();
    private QLLDPhatDAO LDPhatDAO = new QLLDPhatDAO();

    public QLLDPhatBUS() {
        arrLDPhat= LDPhatDAO.readDB();
    }
    
    public String [] getHeader(){
        return new String[]{"Mã Lý Do Phạt", "Tên Lý Do Phạt", "Mức Độ"};
    }
    
    public Boolean add(QLLDPhatDTO LDPhat){
        Boolean check = LDPhatDAO.add(LDPhat);
        if (check){
            arrLDPhat.add(LDPhat);
        }
        return check;
    }
    
    public Boolean add(String maLDPhat, String tenLDPhat, int mucDo){
        QLLDPhatDTO LDPhat=new QLLDPhatDTO(maLDPhat, tenLDPhat, mucDo);
        return this.add(LDPhat);
    }
    
    public Boolean del(String maLDPhat){
        Boolean check = LDPhatDAO.del(maLDPhat);
        if (check){
            for (QLLDPhatDTO LDPhat : arrLDPhat){
                if (LDPhat.getMaLDPhat().equals(maLDPhat)){
                    arrLDPhat.remove(LDPhat);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean mod(QLLDPhatDTO LDPhat){
        Boolean check = LDPhatDAO.mod(LDPhat);  
        if (check){
            for (QLLDPhatDTO s : arrLDPhat){
                if (s.getMaLDPhat().equals(LDPhat.getMaLDPhat())){
                    arrLDPhat.set(arrLDPhat.indexOf(s), LDPhat);
                    break;
                }
            }
        } 
        return check;
    }
     
    public Boolean mod(String maLDPhat, String tenLDPhat, int mucDo){
        QLLDPhatDTO LDPhat=new QLLDPhatDTO(maLDPhat, tenLDPhat, mucDo);
        return this.mod(LDPhat);
    } 
}

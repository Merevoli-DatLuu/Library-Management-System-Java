package librarymanagementsystem.BUS;

import java.util.ArrayList;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLPhieuPhatBUS {
    private ArrayList<QLPhieuPhatDTO> arrPhieuPhat = new ArrayList<>();
    private QLPhieuPhatDAO phieuPhatDAO = new QLPhieuPhatDAO();

    public QLPhieuPhatBUS() {
        arrPhieuPhat= phieuPhatDAO.readDB();
    }
    
    public String [] getHeader(){
        return new String[]{"Mã Phiếu Phạt", "Mã Phiếu Mượn", "Mã Lý Do Phạt", "Tiền Phạt"};
    }
    
    public Boolean add(QLPhieuPhatDTO phieuPhat){
        Boolean check = phieuPhatDAO.add(phieuPhat);
        if (check){
            arrPhieuPhat.add(phieuPhat);
        }
        return check;
    }
    
    public Boolean add(String maPhieuPhat, String maPhieuMuon, String maLDPhat){
        QLPhieuPhatDTO phieuPhat=new QLPhieuPhatDTO(maPhieuPhat, maPhieuMuon, maLDPhat);
        return this.add(phieuPhat);
    }
    
    public Boolean del(String maPhieuPhat){
        Boolean check = phieuPhatDAO.del(maPhieuPhat);
        if (check){
            for (QLPhieuPhatDTO phieuPhat : arrPhieuPhat){
                if (phieuPhat.getMaPhieuPhat().equals(maPhieuPhat)){
                    arrPhieuPhat.remove(phieuPhat);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean mod(QLPhieuPhatDTO phieuPhat){
        Boolean check = phieuPhatDAO.mod(phieuPhat);  
        if (check){
            for (QLPhieuPhatDTO s : arrPhieuPhat){
                if (s.getMaPhieuPhat().equals(phieuPhat.getMaPhieuPhat())){
                    arrPhieuPhat.set(arrPhieuPhat.indexOf(s), phieuPhat);
                    break;
                }
            }
        } 
        return check;
    }
     
    public Boolean mod(String maPhieuPhat, String maPhieuMuon, String maLDPhat){
        QLPhieuPhatDTO phieuPhat=new QLPhieuPhatDTO(maPhieuPhat, maPhieuMuon, maLDPhat);
        return this.mod(phieuPhat);
    } 
}

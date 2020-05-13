package librarymanagementsystem.BUS;

import java.util.ArrayList;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLMuonTraBUS {
    private ArrayList<QLMuonTraDTO> arrMuonTra = new ArrayList<>();
    private QLMuonTraDAO muonTraDAO = new QLMuonTraDAO();

    public QLMuonTraBUS() {
        arrMuonTra= muonTraDAO.readDB();
    }
    
    public String [] getHeader(){
        return new String[]{"Mã Mượn Sách", "Mã Thẻ", "ID Sách", "Thời Điểm Mượn", "Thời Gian Mượn", "Thời Gian Trả"};
    }
    
    public Boolean add(QLMuonTraDTO muonTra){
        Boolean check = muonTraDAO.add(muonTra);
        if (check){
            arrMuonTra.add(muonTra);
        }
        return check;
    }
    
    public Boolean add(String maMuonSach, String maThe, String IDSach, String thoiDiemMuon, int thoiGianMuon, String thoiDiemTra){
        QLMuonTraDTO muonTra=new QLMuonTraDTO(maMuonSach, maThe, IDSach, thoiDiemMuon, thoiGianMuon, thoiDiemTra);
        return this.add(muonTra);
    }
    
    public Boolean del(String maMuonSach){
        Boolean check = muonTraDAO.del(maMuonSach);
        if (check){
            for (QLMuonTraDTO muonTra : arrMuonTra){
                if (muonTra.getMaMuonSach().equals(maMuonSach)){
                    arrMuonTra.remove(muonTra);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean mod(QLMuonTraDTO muonTra){
        Boolean check = muonTraDAO.mod(muonTra);  
        if (check){
            for (QLMuonTraDTO s : arrMuonTra){
                if (s.getMaMuonSach().equals(muonTra.getMaMuonSach())){
                    arrMuonTra.set(arrMuonTra.indexOf(s), muonTra);
                    break;
                }
            }
        } 
        return check;
    }
     
    public Boolean mod(String maMuonSach, String maThe, String IDSach, String thoiDiemMuon, int thoiGianMuon, String thoiDiemTra){
        QLMuonTraDTO muonTra=new QLMuonTraDTO(maMuonSach, maThe, IDSach, thoiDiemMuon, thoiGianMuon, thoiDiemTra);
        return this.mod(muonTra);
    } 
}

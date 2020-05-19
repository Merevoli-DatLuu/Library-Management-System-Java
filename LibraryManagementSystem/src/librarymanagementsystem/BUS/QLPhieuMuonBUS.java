package librarymanagementsystem.BUS;

import java.util.ArrayList;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLPhieuMuonBUS {
    private ArrayList<QLPhieuMuonDTO> arrMuonTra = new ArrayList<>();
    private QLPhieuMuonDAO muonTraDAO = new QLPhieuMuonDAO();

    public QLPhieuMuonBUS() {
        arrMuonTra= muonTraDAO.readDB();
    }
    
    public String [] getHeader(){
        return new String[]{"Mã Mượn Sách", "Mã Thẻ", "ID Sách", "Ngày Mượn", "Thời Gian Mượn", "Ngày Trả"};
    }
    
    public Boolean add(QLPhieuMuonDTO muonTra){
        Boolean check = muonTraDAO.add(muonTra);
        if (check){
            arrMuonTra.add(muonTra);
        }
        return check;
    }
    
    public Boolean add(String maPhieuMuon, String maThe, ArrayList <String> IDSach, String ngayMuon, int thoiGianMuon, String ngayTra){
        QLPhieuMuonDTO muonTra=new QLPhieuMuonDTO(maPhieuMuon, maThe, IDSach, ngayMuon, thoiGianMuon, ngayTra);
        return this.add(muonTra);
    }
    
    public Boolean del(String maPhieuMuon){
        Boolean check = muonTraDAO.del(maPhieuMuon);
        if (check){
            for (QLPhieuMuonDTO muonTra : arrMuonTra){
                if (muonTra.getMaPhieuMuon().equals(maPhieuMuon)){
                    arrMuonTra.remove(muonTra);
                    break;
                }
            }
        } 
        return check;
    }
    
    public Boolean mod(QLPhieuMuonDTO muonTra){
        Boolean check = muonTraDAO.mod(muonTra);  
        if (check){
            for (QLPhieuMuonDTO s : arrMuonTra){
                if (s.getMaPhieuMuon().equals(muonTra.getMaPhieuMuon())){
                    arrMuonTra.set(arrMuonTra.indexOf(s), muonTra);
                    break;
                }
            }
        } 
        return check;
    }
     
    public Boolean mod(String maPhieuMuon, String maThe, ArrayList <String> IDSach, String ngayMuon, int thoiGianMuon, String ngayTra){
        QLPhieuMuonDTO muonTra=new QLPhieuMuonDTO(maPhieuMuon, maThe, IDSach, ngayMuon, thoiGianMuon, ngayTra);
        return this.mod(muonTra);
    } 
}

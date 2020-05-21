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
    
    public QLPhieuMuonDTO getPhieuMuon(String maPhieuMuon){
        for (QLPhieuMuonDTO e : arrMuonTra){
            if (e.equals(maPhieuMuon)){
                return e;
            }
        }
        return null;
    }
    
    public ArrayList <QLPhieuMuonDTO> search (String column, String value){
        ArrayList <QLPhieuMuonDTO> result_search = new ArrayList <QLPhieuMuonDTO> ();
        switch (column) { // Dựa vào Headers
            case "Mã Phiếu Mượn":
                for (QLPhieuMuonDTO e : arrMuonTra){
                    if (e.getMaPhieuMuon().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Mã Thẻ": 
                for (QLPhieuMuonDTO e : arrMuonTra){
                    if (e.getMaThe().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "ID Sách":
                for (QLPhieuMuonDTO e : arrMuonTra){
                    if (e.getIDSach().toString().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Ngày Mượn":
                for (QLPhieuMuonDTO e : arrMuonTra){
                    if (e.getNgayMuon().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Thời Gian Mượn":
                for (QLPhieuMuonDTO e : arrMuonTra) {
                    String thoiGianMuon=String.valueOf(e.getThoiGianMuon());
                    if (thoiGianMuon.toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Ngày Trả":
                for (QLPhieuMuonDTO e : arrMuonTra){
                    if (e.getNgayTra().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
        }
        return result_search;
    }
    
    public ArrayList <QLPhieuMuonDTO> search_all (String column, String value){
        ArrayList <QLPhieuMuonDTO> result_search = new ArrayList <QLPhieuMuonDTO> ();
        for (QLPhieuMuonDTO e : arrMuonTra){
            String thoiGianMuon=String.valueOf(e.getThoiGianMuon());
            if (e.getMaPhieuMuon().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getMaThe().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getIDSach().toArray().equals(value)) {
                result_search.add(e);
            }
            else if (e.getNgayMuon().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (thoiGianMuon.toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getNgayTra().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
        }
        return result_search;
    }
    
    public ArrayList <QLPhieuMuonDTO> filter (ArrayList <String> PKey){
        ArrayList <QLPhieuMuonDTO> res_filter = new ArrayList <QLPhieuMuonDTO>(); 
        for (QLPhieuMuonDTO e : arrMuonTra){
            if (PKey.contains(e.getMaPhieuMuon())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public ArrayList <QLPhieuMuonDTO> filter (ArrayList <String> PKey, ArrayList <QLPhieuMuonDTO> arr){
        ArrayList <QLPhieuMuonDTO> res_filter = new ArrayList <QLPhieuMuonDTO>(); 
        for (QLPhieuMuonDTO e : arr){
            if (PKey.contains(e.getMaPhieuMuon())){
                res_filter.add(e);
            }
        }
        return res_filter;
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

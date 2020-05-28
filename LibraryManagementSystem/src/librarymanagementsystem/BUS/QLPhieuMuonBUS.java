package librarymanagementsystem.BUS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;
import librarymanagementsystem.Toolkit.DataProcessing;

public class QLPhieuMuonBUS {
    private ArrayList<QLPhieuMuonDTO> arrMuonTra = new ArrayList<>();
    private QLPhieuMuonDAO muonTraDAO = new QLPhieuMuonDAO();

    public QLPhieuMuonBUS() {
        arrMuonTra= muonTraDAO.readDB();
    }
    
    public String [] getHeader(){
        return new String[]{"Mã Phiếu Mượn", "Mã Thẻ", "ID Sách", "Ngày Mượn", "Thời Gian Mượn", "Ngày Trả"};
    }
    
     public QLPhieuMuonDTO getPhieuMuon(String maPhieuMuon){
        for (QLPhieuMuonDTO e : arrMuonTra){
            if (e.equals(maPhieuMuon)){
                return e;
            }
        }
        return null;
    }
     
    public ArrayList <QLPhieuMuonDTO> getPhieuMuon_full(ArrayList <String> maPhieuMuon){
        Set<String> set = new HashSet<String>();
        ArrayList <QLPhieuMuonDTO> res = new ArrayList<>();
        for (String e : maPhieuMuon){
            set.add(e);
        }
        
        for (QLPhieuMuonDTO e : arrMuonTra){
            if (set.contains(e)){
                res.add(e);
            }
        }
        return res;
    }
    
    public ArrayList <String> getPKey(){
        ArrayList <String> Pkey = new ArrayList<>();
        for (QLPhieuMuonDTO e : arrMuonTra){
            Pkey.add(e.getMaPhieuMuon());
        }
        return Pkey;
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

    public ArrayList<QLPhieuMuonDTO> getArrMuonTra() {
        return arrMuonTra;
    }
    
    public int getSoLuongSachMuon(){
        int res = 0;
        for (QLPhieuMuonDTO e : arrMuonTra){
            res += e.getIDSach().size();
        }
        return res;
    }
    
    public int getSoLuongSachMuon(int year){
        int res = 0;
        DataProcessing ps = new DataProcessing();
        for (QLPhieuMuonDTO e : arrMuonTra){
            if (ps.getYear(e.getNgayMuon()) == year){
                res += e.getIDSach().size();
            }
        }
        return res;
    }
    
    
    public int getSoLuongSachMuon(int month, int year){
        int res = 0;
        DataProcessing ps = new DataProcessing();
        for (QLPhieuMuonDTO e : arrMuonTra){
            if (ps.getYear(e.getNgayMuon()) == year && ps.getMonth(e.getNgayMuon()) == month){
                res += e.getIDSach().size();
            }
        }
        return res;
    }
    
    
    public int getSoLuongSachMuon(int day, int month, int year){
        int res = 0;
        DataProcessing ps = new DataProcessing();
        for (QLPhieuMuonDTO e : arrMuonTra){
            if (ps.getYear(e.getNgayMuon()) == year && ps.getMonth(e.getNgayMuon()) == month && ps.getDay(e.getNgayMuon()) == day){
                res += e.getIDSach().size();
            }
        }
        return res;
    }
    
    public ArrayList <Integer> getArrSoLuongSachMuon(int year){
        ArrayList <Integer> rs = new ArrayList<>();
        DataProcessing ps = new DataProcessing();
        for (int month = 1; month <= 12; month++){
            int t = 0;
            for (QLPhieuMuonDTO e : arrMuonTra){
                if (ps.getYear(e.getNgayMuon()) == year && ps.getMonth(e.getNgayMuon()) == month){
                    t += e.getIDSach().size();
                }
            }
            rs.add(t);
        }
        return rs;
    }
    
}

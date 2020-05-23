package librarymanagementsystem.BUS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
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
    
    public QLPhieuPhatDTO getPhieuPhat(String maPhieuPhat){
        for (QLPhieuPhatDTO e : arrPhieuPhat){
            if (e.equals(maPhieuPhat)){
                return e;
            }
        }
        return null;
    }
    
    public ArrayList <QLPhieuPhatDTO> getPhieuPhat_full(ArrayList <String> maPhieuPhat){
        Set<String> set = new HashSet<String>();
        ArrayList <QLPhieuPhatDTO> res = new ArrayList<>();
        for (String e : maPhieuPhat){
            set.add(e);
        }
        
        for (QLPhieuPhatDTO e : arrPhieuPhat){
            if (set.contains(e)){
                res.add(e);
            }
        }
        return res;
    }
    
    public ArrayList <String> getPKey(){
        ArrayList <String> Pkey = new ArrayList<>();
        for (QLPhieuPhatDTO e : arrPhieuPhat){
            Pkey.add(e.getMaPhieuPhat());
        }
        return Pkey;
    }
    
    public ArrayList <QLPhieuPhatDTO> search (String column, String value){
        ArrayList <QLPhieuPhatDTO> result_search = new ArrayList <QLPhieuPhatDTO> ();
        switch (column) { // Dựa vào Headers
            case "Mã Phiếu Phạt":
                for (QLPhieuPhatDTO e : arrPhieuPhat){
                    if (e.getMaPhieuPhat().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Mã Phiếu Mượn": 
                for (QLPhieuPhatDTO e : arrPhieuPhat){
                    if (e.getMaPhieuMuon().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            case "Mã Lý Do Phạt":
                for (QLPhieuPhatDTO e : arrPhieuPhat){
                    if (e.getMaLDPhat().toString().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;
            /*case "Tiền Phạt":
                for (QLPhieuPhatDTO e : arrPhieuPhat){
                    if (e.get().toString().toLowerCase().compareTo(value) != -1) {
                        result_search.add(e);
                    }
                }
                break;*/
        }
        return result_search;
    }
    
    public ArrayList <QLPhieuPhatDTO> search_all (String column, String value){
        ArrayList <QLPhieuPhatDTO> result_search = new ArrayList <QLPhieuPhatDTO> ();
        for (QLPhieuPhatDTO e : arrPhieuPhat){
            if (e.getMaPhieuPhat().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getMaPhieuMuon().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            else if (e.getMaLDPhat().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }
            /*else if (e.get().toString().toLowerCase().compareTo(value) != -1) {
                result_search.add(e);
            }*/
        }
        return result_search;
    }
    
    public ArrayList <QLPhieuPhatDTO> filter (ArrayList <String> PKey){
        ArrayList <QLPhieuPhatDTO> res_filter = new ArrayList <QLPhieuPhatDTO>(); 
        for (QLPhieuPhatDTO e : arrPhieuPhat){
            if (PKey.contains(e.getMaPhieuPhat())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public ArrayList <QLPhieuPhatDTO> filter (ArrayList <String> PKey, ArrayList <QLPhieuPhatDTO> arr){
        ArrayList <QLPhieuPhatDTO> res_filter = new ArrayList <QLPhieuPhatDTO>(); 
        for (QLPhieuPhatDTO e : arr){
            if (PKey.contains(e.getMaPhieuPhat())){
                res_filter.add(e);
            }
        }
        return res_filter;
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

    public ArrayList<QLPhieuPhatDTO> getArrPhieuPhat() {
        return arrPhieuPhat;
    }
    
    
}

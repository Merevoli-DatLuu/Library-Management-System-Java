package librarymanagementsystem.BUS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import librarymanagementsystem.DAO.*;
import librarymanagementsystem.DTO.*;

public class QLLDPhatBUS {
    private static ArrayList<QLLDPhatDTO> arrLDPhat = new ArrayList<>();
    private QLLDPhatDAO LDPhatDAO = new QLLDPhatDAO();

    public QLLDPhatBUS() {
        arrLDPhat= LDPhatDAO.readDB();
    }
    
    public QLLDPhatBUS(int i){
        if (arrLDPhat.size() == 0){
            arrLDPhat = LDPhatDAO.readDB();
        }
    }
    
    public String [] getHeaders(){
        return new String[]{"Mã Lý Do Phạt", "Tên Lý Do Phạt", "Mức Độ"};
    }
    
    // 0:string, 1:int, 2:date
    public int[] getHeadersType(){
        return new int[]{0, 0, 1};
    }
    
    public int findHeaderType(String header){
        for (int i=0; i<3; i++){
            if (getHeaders()[i].equals(header)){
                return getHeadersType()[i];
            }
        }
        System.err.println("header type not found");
        return -1;
    }
    
    public QLLDPhatDTO getLDPhat(String maLDPhat){
        for (QLLDPhatDTO e : arrLDPhat){
            if (e.getMaLDPhat().equals(maLDPhat)){
                return e;
            }
        }
        return null;
    }
    
    public ArrayList <QLLDPhatDTO> getLDPhat_full(ArrayList <String> maLDPhat){
        Set<String> set = new HashSet<String>();
        ArrayList <QLLDPhatDTO> res = new ArrayList<>();
        for (String e : maLDPhat){
            set.add(e);
        }
        
        for (QLLDPhatDTO e : arrLDPhat){
            if (set.contains(e.getMaLDPhat())){
                res.add(e);
            }
        }
        return res;
    }
    
    public ArrayList <String> getPKey(){
        ArrayList <String> Pkey = new ArrayList<>();
        for (QLLDPhatDTO e : arrLDPhat){
            Pkey.add(e.getMaLDPhat());
        }
        return Pkey;
    }
    
    public ArrayList <QLLDPhatDTO> search (String column, String value){
        ArrayList <QLLDPhatDTO> result_search = new ArrayList <QLLDPhatDTO> ();
        value = value.toLowerCase();
        switch (column) { // Dựa vào Headers
            case "Mã Lý Do Phạt ":
                for (QLLDPhatDTO e : arrLDPhat){
                    if (e.getMaLDPhat().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Tên Lý Do Phạt": 
                for (QLLDPhatDTO e : arrLDPhat){
                    if (e.getTenLDPhat().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Mức Độ":
            for (QLLDPhatDTO e : arrLDPhat) {
                String mucDo=String.valueOf(e.getMucDo());
                if (mucDo.toLowerCase().contains(value)) {
                    result_search.add(e);
                }
            }
                break;


        }
        return result_search;
    }
    
    public ArrayList <QLLDPhatDTO> search_all (String column, String value){
        ArrayList <QLLDPhatDTO> result_search = new ArrayList <QLLDPhatDTO> ();
        value = value.toLowerCase();
        for (QLLDPhatDTO e : arrLDPhat){
            String mucDo=String.valueOf(e.getMucDo());
            if (e.getMaLDPhat().toLowerCase().contains(value)) {
                result_search.add(e);
            }
            else if (e.getTenLDPhat().toLowerCase().contains(value)) {
                result_search.add(e);
            }
            else if (mucDo.toLowerCase().contains(value)) {
                result_search.add(e);
            }
        }
        return result_search;
    }
    
    public ArrayList <QLLDPhatDTO> filter (ArrayList <String> PKey){
        ArrayList <QLLDPhatDTO> res_filter = new ArrayList <QLLDPhatDTO>(); 
        for (QLLDPhatDTO e : arrLDPhat){
            if (PKey.contains(e.getMaLDPhat())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public ArrayList <QLLDPhatDTO> filter (ArrayList <String> PKey, ArrayList <QLLDPhatDTO> arr){
        ArrayList <QLLDPhatDTO> res_filter = new ArrayList <QLLDPhatDTO>(); 
        for (QLLDPhatDTO e : arr){
            if (PKey.contains(e.getMaLDPhat())){
                res_filter.add(e);
            }
        }
        return res_filter;
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

    public ArrayList<QLLDPhatDTO> getArrLDPhat() {
        return arrLDPhat;
    }
    
    
}

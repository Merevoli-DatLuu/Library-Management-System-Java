package librarymanagementsystem.BUS;
import librarymanagementsystem.DTO.*;
import librarymanagementsystem.DAO.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
public class QLQuyenBUS {
    private static ArrayList<QLQuyenDTO> arrQuyen = new ArrayList<>();
    private QLQuyenDAO quyenDAO = new QLQuyenDAO();
    
    public QLQuyenBUS(){
        arrQuyen = quyenDAO.readDB();
    }
    
    public QLQuyenBUS(int i){
        if (arrQuyen.size() == 0){
            arrQuyen = quyenDAO.readDB();
        }
    }
    
    public String[] getHeaders(){
        return new String[]{"Mã Quyền", "Tên Quyền", "Chi Tiết Quyền"};
    }
    
    // 0:string, 1:int, 2:date
    public int[] getHeadersType(){
        return new int[]{0, 0, 0};
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
    
    public QLQuyenDTO getQuyen(String maQuyen){
        for (QLQuyenDTO e : arrQuyen){
            if (e.getMaQuyen().equals(maQuyen)){
                return e;
            }
        }
        return null;
    }
    
    public ArrayList <QLQuyenDTO> getQuyen_full(ArrayList <String> maQuyen){
        Set<String> set = new HashSet<String>();
        ArrayList <QLQuyenDTO> res = new ArrayList<>();
        for (String e : maQuyen){
            set.add(e);
        }
        
        for (QLQuyenDTO e : arrQuyen){
            if (set.contains(e.getMaQuyen())){
                res.add(e);
            }
        }
        return res;
    }
    
    public ArrayList <String> getPKey(){
        ArrayList <String> Pkey = new ArrayList<>();
        for (QLQuyenDTO e : arrQuyen){
            Pkey.add(e.getMaQuyen());
        }
        return Pkey;
    }
    
    public ArrayList <QLQuyenDTO> search (String column, String value){
        ArrayList <QLQuyenDTO> result_search = new ArrayList <QLQuyenDTO> ();
        value = value.toLowerCase();
        switch (column) { // Dựa vào Headers
            case "Mã Quyền":
                for (QLQuyenDTO e : arrQuyen){
                    if (e.getMaQuyen().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Tên Quyền": 
                for (QLQuyenDTO e : arrQuyen){
                    if (e.getTenQuyen().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Chi Tiết Quyền":
                for (QLQuyenDTO e : arrQuyen){
                    if (e.getChitietQuyen().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
        }
        return result_search;
    }
    
    public ArrayList <QLQuyenDTO> search (ArrayList <QLQuyenDTO> arrSearch, String column, String value){
        ArrayList <QLQuyenDTO> result_search = new ArrayList <QLQuyenDTO> ();
        value = value.toLowerCase();
        switch (column) { // Dựa vào Headers
            case "Mã Quyền":
                for (QLQuyenDTO e : arrSearch){
                    if (e.getMaQuyen().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Tên Quyền": 
                for (QLQuyenDTO e : arrSearch){
                    if (e.getTenQuyen().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            case "Chi Tiết Quyền":
                for (QLQuyenDTO e : arrSearch){
                    if (e.getChitietQuyen().toLowerCase().contains(value)) {
                        result_search.add(e);
                    }
                }
                break;
            
        }
        return result_search;
    }
    
    public ArrayList <QLQuyenDTO> search_all (String value){
        ArrayList <QLQuyenDTO> result_search = new ArrayList <QLQuyenDTO> ();
        value = value.toLowerCase();
        for (QLQuyenDTO e : arrQuyen){
            if (e.getMaQuyen().toLowerCase().contains(value)) {
                result_search.add(e);
            }
            else if (e.getTenQuyen().toLowerCase().contains(value)) {
                result_search.add(e);
            }
            else if (e.getChitietQuyen().toLowerCase().contains(value)) {
                result_search.add(e);
            }
        }
        return result_search;
    }
    
    public ArrayList <QLQuyenDTO> filter (ArrayList <String> PKey){
        ArrayList <QLQuyenDTO> res_filter = new ArrayList <QLQuyenDTO>(); 
        for (QLQuyenDTO e : arrQuyen){
            if (PKey.contains(e.getMaQuyen())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public ArrayList <QLQuyenDTO> filter (ArrayList <String> PKey, ArrayList <QLQuyenDTO> arr){
        ArrayList <QLQuyenDTO> res_filter = new ArrayList <QLQuyenDTO>(); 
        for (QLQuyenDTO e : arrQuyen){
            if (PKey.contains(e.getMaQuyen())){
                res_filter.add(e);
            }
        }
        return res_filter;
    }
    
    public void show(){
        for (QLQuyenDTO quyen : arrQuyen){
            System.out.println(quyen.getMaQuyen()+ '\t' + quyen.getTenQuyen());
        }
    }
            
    public Boolean add(QLQuyenDTO quyen){
        Boolean check = quyenDAO.add(quyen);
        
        if (check){
            arrQuyen.add(quyen);
        }
        return check;
    }
    
    public Boolean add(String maQuyen, String tenQuyen, String chitietQuyen){
        QLQuyenDTO quyen = new QLQuyenDTO(maQuyen, tenQuyen, chitietQuyen);
        
        return this.add(quyen);
    }
    
    public Boolean del(String maQuyen){
        Boolean check = quyenDAO.del(maQuyen);
        
        if (check){
//            for (QLQuyenDTO quyen : arrQuyen){
//                if (sach.getMaQuyen().equals(maQuyen)){
//                    arrQuyen.remove(quyen);
//                    break;
//                }
//            }
            // Tránh Lỗi ConcurrentModificationException :))
            Iterator<QLQuyenDTO> iterator = arrQuyen.iterator();
            while (iterator.hasNext()) {
                QLQuyenDTO quyen = iterator.next();
                if (quyen.getMaQuyen().equals(maQuyen)) {
                    arrQuyen.remove(quyen);
                    break;
                }
            }
        }
        
        return check;
    }
    
    public Boolean mod(QLQuyenDTO quyen){
        Boolean check = quyenDAO.mod(quyen);
        
        if (check){
            for (QLQuyenDTO s : arrQuyen){
                if (s.getMaQuyen().equals(quyen.getMaQuyen())){
                    arrQuyen.set(arrQuyen.indexOf(s), quyen);
                    break;
                }
            }
        }
        
        return check;
    }
    
    public Boolean mod(String maQuyen, String tenQuyen, String chitietQuyen){
        QLQuyenDTO quyen = new QLQuyenDTO(maQuyen, tenQuyen, chitietQuyen);
        
        return this.mod(quyen);
    }

    public ArrayList<QLQuyenDTO> getArrQuyen() {
        return arrQuyen;
    }
    
    public static void main(String[] args){
        if (new QLQuyenBUS(0).del("Q000003")){
            System.out.println(111);
        }
        else{
            System.out.println(000);
        }
    }
}



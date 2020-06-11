package librarymanagementsystem.GUI.ChonGUI;

import java.util.ArrayList;
import librarymanagementsystem.BUS.QLLoaiSachBUS;
import librarymanagementsystem.DTO.QLLoaiSachDTO;

public class FilterFunction {
    public ArrayList <QLLoaiSachDTO> filterBy_Equails_STRING_LoaiSach(ArrayList <QLLoaiSachDTO> table, String header, String value){
        ArrayList <QLLoaiSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLoaiSachBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLLoaiSachDTO e : table){
                if (e.getMaSach().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLLoaiSachDTO e : table){
                if (e.getTenSach().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLLoaiSachDTO e : table){
                if (e.getTenTacGia().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLLoaiSachDTO e : table){
                if (e.getTenNXB().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLLoaiSachDTO e : table){
                if (e.getTheLoai().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLLoaiSachDTO e : table){
                if (e.getNgonNgu().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[6])){
            for (QLLoaiSachDTO e : table){
                if (e.getTomTatNoiDung().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLLoaiSachDTO> filterBy_NotEquails_STRING_LoaiSach(ArrayList <QLLoaiSachDTO> table, String header, String value){
        ArrayList <QLLoaiSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLoaiSachBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLLoaiSachDTO e : table){
                if (!e.getMaSach().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLLoaiSachDTO e : table){
                if (!e.getTenSach().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLLoaiSachDTO e : table){
                if (!e.getTenTacGia().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLLoaiSachDTO e : table){
                if (!e.getTenNXB().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLLoaiSachDTO e : table){
                if (!e.getTheLoai().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLLoaiSachDTO e : table){
                if (!e.getNgonNgu().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[6])){
            for (QLLoaiSachDTO e : table){
                if (!e.getTomTatNoiDung().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLLoaiSachDTO> filterBy_Contains_STRING_LoaiSach(ArrayList <QLLoaiSachDTO> table, String header, String value){
        ArrayList <QLLoaiSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLoaiSachBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLLoaiSachDTO e : table){
                if (e.getMaSach().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLLoaiSachDTO e : table){
                if (e.getTenSach().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLLoaiSachDTO e : table){
                if (e.getTenTacGia().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLLoaiSachDTO e : table){
                if (e.getTenNXB().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLLoaiSachDTO e : table){
                if (e.getTheLoai().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLLoaiSachDTO e : table){
                if (e.getNgonNgu().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[6])){
            for (QLLoaiSachDTO e : table){
                if (e.getTomTatNoiDung().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLLoaiSachDTO> filterBy_DoesNotContain_STRING_LoaiSach(ArrayList <QLLoaiSachDTO> table, String header, String value){
        ArrayList <QLLoaiSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLoaiSachBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLLoaiSachDTO e : table){
                if (!e.getMaSach().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLLoaiSachDTO e : table){
                if (!e.getTenSach().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLLoaiSachDTO e : table){
                if (!e.getTenTacGia().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLLoaiSachDTO e : table){
                if (!e.getTenNXB().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLLoaiSachDTO e : table){
                if (!e.getTheLoai().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLLoaiSachDTO e : table){
                if (!e.getNgonNgu().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[6])){
            for (QLLoaiSachDTO e : table){
                if (!e.getTomTatNoiDung().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLLoaiSachDTO> filterBy_BeginsWith_STRING_LoaiSach(ArrayList <QLLoaiSachDTO> table, String header, String value){
        ArrayList <QLLoaiSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLoaiSachBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLLoaiSachDTO e : table){
                if (e.getMaSach().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLLoaiSachDTO e : table){
                if (e.getTenSach().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLLoaiSachDTO e : table){
                if (e.getTenTacGia().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLLoaiSachDTO e : table){
                if (e.getTenNXB().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLLoaiSachDTO e : table){
                if (e.getTheLoai().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLLoaiSachDTO e : table){
                if (e.getNgonNgu().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[6])){
            for (QLLoaiSachDTO e : table){
                if (e.getTomTatNoiDung().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLLoaiSachDTO> filterBy_EndsWith_STRING_LoaiSach(ArrayList <QLLoaiSachDTO> table, String header, String value){
        ArrayList <QLLoaiSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLoaiSachBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLLoaiSachDTO e : table){
                if (e.getMaSach().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLLoaiSachDTO e : table){
                if (e.getTenSach().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLLoaiSachDTO e : table){
                if (e.getTenTacGia().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLLoaiSachDTO e : table){
                if (e.getTenNXB().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLLoaiSachDTO e : table){
                if (e.getTheLoai().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLLoaiSachDTO e : table){
                if (e.getNgonNgu().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[6])){
            for (QLLoaiSachDTO e : table){
                if (e.getTomTatNoiDung().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLLoaiSachDTO> filterBy_Equails_NUMBER_LoaiSach(ArrayList <QLLoaiSachDTO> table, String header, int value){
        ArrayList <QLLoaiSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLoaiSachBUS(0).getHeaders();
        if (header.equals(headers[7])){
            for (QLLoaiSachDTO e : table){
                if (e.getNamXB() == value){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[8])){
            for (QLLoaiSachDTO e : table){
                if (e.getGiaTien() == value){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[9])){
            for (QLLoaiSachDTO e : table){
                if (e.getSoTrang() == value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLLoaiSachDTO> filterBy_NotEquails_NUMBER_LoaiSach(ArrayList <QLLoaiSachDTO> table, String header, int value){
        ArrayList <QLLoaiSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLoaiSachBUS(0).getHeaders();
        if (header.equals(headers[7])){
            for (QLLoaiSachDTO e : table){
                if (e.getNamXB() != value){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[8])){
            for (QLLoaiSachDTO e : table){
                if (e.getGiaTien() != value){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[9])){
            for (QLLoaiSachDTO e : table){
                if (e.getSoTrang() != value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLLoaiSachDTO> filterBy_GreaterThan_NUMBER_LoaiSach(ArrayList <QLLoaiSachDTO> table, String header, int value){
        ArrayList <QLLoaiSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLoaiSachBUS(0).getHeaders();
        if (header.equals(headers[7])){
            for (QLLoaiSachDTO e : table){
                if (e.getNamXB() > value){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[8])){
            for (QLLoaiSachDTO e : table){
                if (e.getGiaTien() > value){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[9])){
            for (QLLoaiSachDTO e : table){
                if (e.getSoTrang() > value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLLoaiSachDTO> filterBy_GreaterThanOrEqualsTo_NUMBER_LoaiSach(ArrayList <QLLoaiSachDTO> table, String header, int value){
        ArrayList <QLLoaiSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLoaiSachBUS(0).getHeaders();
        if (header.equals(headers[7])){
            for (QLLoaiSachDTO e : table){
                if (e.getNamXB() >= value){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[8])){
            for (QLLoaiSachDTO e : table){
                if (e.getGiaTien() >= value){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[9])){
            for (QLLoaiSachDTO e : table){
                if (e.getSoTrang() >= value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLLoaiSachDTO> filterBy_LessThan_NUMBER_LoaiSach(ArrayList <QLLoaiSachDTO> table, String header, int value){
        ArrayList <QLLoaiSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLoaiSachBUS(0).getHeaders();
        if (header.equals(headers[7])){
            for (QLLoaiSachDTO e : table){
                if (e.getNamXB() < value){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[8])){
            for (QLLoaiSachDTO e : table){
                if (e.getGiaTien() < value){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[9])){
            for (QLLoaiSachDTO e : table){
                if (e.getSoTrang() < value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLLoaiSachDTO> filterBy_LessThanOrEqualsTo_NUMBER_LoaiSach(ArrayList <QLLoaiSachDTO> table, String header, int value){
        ArrayList <QLLoaiSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLoaiSachBUS(0).getHeaders();
        if (header.equals(headers[7])){
            for (QLLoaiSachDTO e : table){
                if (e.getNamXB() <= value){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[8])){
            for (QLLoaiSachDTO e : table){
                if (e.getGiaTien() <= value){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[9])){
            for (QLLoaiSachDTO e : table){
                if (e.getSoTrang() <= value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    
}

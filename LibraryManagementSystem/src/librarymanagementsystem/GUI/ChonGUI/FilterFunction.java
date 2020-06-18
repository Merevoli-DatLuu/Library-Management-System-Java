package librarymanagementsystem.GUI.ChonGUI;

import java.util.ArrayList;
import librarymanagementsystem.BUS.*;
import librarymanagementsystem.DTO.*;

public class FilterFunction {
    /**     STRING - LoaiSach       **/
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
    
    /**     NUMBER - LoaiSach       **/
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
    
    /**     STRING - NhaCungCap       **/
    public ArrayList <QLNhaCungCapDTO> filterBy_Equails_STRING_NhaCungCap(ArrayList <QLNhaCungCapDTO> table, String header, String value){
        ArrayList <QLNhaCungCapDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLNhaCungCapBUS(0).getHeaders();
        System.err.println(table.size() + " " + header + " " + value);
        if (header.equals(headers[0])){
            for (QLNhaCungCapDTO e : table){
                if (e.getMaNCC().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLNhaCungCapDTO e : table){
                if (e.getTenNCC().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLNhaCungCapDTO e : table){
                if (e.getSdt().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLNhaCungCapDTO e : table){
                if (e.getEmail().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLNhaCungCapDTO e : table){
                if (e.getDiaChi().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLNhaCungCapDTO> filterBy_NotEquails_STRING_NhaCungCap(ArrayList <QLNhaCungCapDTO> table, String header, String value){
        ArrayList <QLNhaCungCapDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLNhaCungCapBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLNhaCungCapDTO e : table){
                if (!e.getMaNCC().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLNhaCungCapDTO e : table){
                if (!e.getTenNCC().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLNhaCungCapDTO e : table){
                if (!e.getSdt().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLNhaCungCapDTO e : table){
                if (!e.getEmail().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLNhaCungCapDTO e : table){
                if (!e.getDiaChi().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLNhaCungCapDTO> filterBy_Contains_STRING_NhaCungCap(ArrayList <QLNhaCungCapDTO> table, String header, String value){
        ArrayList <QLNhaCungCapDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLNhaCungCapBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLNhaCungCapDTO e : table){
                if (e.getMaNCC().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLNhaCungCapDTO e : table){
                if (e.getTenNCC().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLNhaCungCapDTO e : table){
                if (e.getSdt().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLNhaCungCapDTO e : table){
                if (e.getEmail().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLNhaCungCapDTO e : table){
                if (e.getDiaChi().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLNhaCungCapDTO> filterBy_DoesNotContain_STRING_NhaCungCap(ArrayList <QLNhaCungCapDTO> table, String header, String value){
        ArrayList <QLNhaCungCapDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLNhaCungCapBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLNhaCungCapDTO e : table){
                if (!e.getMaNCC().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLNhaCungCapDTO e : table){
                if (!e.getTenNCC().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLNhaCungCapDTO e : table){
                if (!e.getSdt().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLNhaCungCapDTO e : table){
                if (!e.getEmail().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLNhaCungCapDTO e : table){
                if (!e.getDiaChi().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLNhaCungCapDTO> filterBy_BeginsWith_STRING_NhaCungCap(ArrayList <QLNhaCungCapDTO> table, String header, String value){
        ArrayList <QLNhaCungCapDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLNhaCungCapBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLNhaCungCapDTO e : table){
                if (e.getMaNCC().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLNhaCungCapDTO e : table){
                if (e.getTenNCC().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLNhaCungCapDTO e : table){
                if (e.getSdt().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLNhaCungCapDTO e : table){
                if (e.getEmail().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLNhaCungCapDTO e : table){
                if (e.getDiaChi().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLNhaCungCapDTO> filterBy_EndsWith_STRING_NhaCungCap(ArrayList <QLNhaCungCapDTO> table, String header, String value){
        ArrayList <QLNhaCungCapDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLNhaCungCapBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLNhaCungCapDTO e : table){
                if (e.getMaNCC().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLNhaCungCapDTO e : table){
                if (e.getTenNCC().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLNhaCungCapDTO e : table){
                if (e.getSdt().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLNhaCungCapDTO e : table){
                if (e.getEmail().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLNhaCungCapDTO e : table){
                if (e.getDiaChi().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    /**     STRING - The       **/
    public ArrayList <QLTheDTO> filterBy_Equails_STRING_The(ArrayList <QLTheDTO> table, String header, String value){
        ArrayList <QLTheDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLTheBUS(0).getHeaders();
        System.err.println(table.size() + " " + header + " " + value);
        if (header.equals(headers[0])){
            for (QLTheDTO e : table){
                if (e.getMaThe().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLTheDTO e : table){
                if (e.getMaKhachHang().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLTheDTO e : table){
                if (e.getNgayCap().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLTheDTO e : table){
                if (e.getNgayHetHan().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLTheDTO> filterBy_NotEquails_STRING_The(ArrayList <QLTheDTO> table, String header, String value){
        ArrayList <QLTheDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLTheBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLTheDTO e : table){
                if (!e.getMaThe().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLTheDTO e : table){
                if (!e.getMaKhachHang().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLTheDTO e : table){
                if (!e.getNgayCap().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLTheDTO e : table){
                if (!e.getNgayHetHan().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLTheDTO> filterBy_Contains_STRING_The(ArrayList <QLTheDTO> table, String header, String value){
        ArrayList <QLTheDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLTheBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLTheDTO e : table){
                if (e.getMaThe().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLTheDTO e : table){
                if (e.getMaKhachHang().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLTheDTO e : table){
                if (e.getNgayCap().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLTheDTO e : table){
                if (e.getNgayHetHan().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLTheDTO> filterBy_DoesNotContain_STRING_The(ArrayList <QLTheDTO> table, String header, String value){
        ArrayList <QLTheDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLTheBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLTheDTO e : table){
                if (!e.getMaThe().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLTheDTO e : table){
                if (!e.getMaKhachHang().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLTheDTO e : table){
                if (!e.getNgayCap().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLTheDTO e : table){
                if (!e.getNgayHetHan().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLTheDTO> filterBy_BeginsWith_STRING_The(ArrayList <QLTheDTO> table, String header, String value){
        ArrayList <QLTheDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLTheBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLTheDTO e : table){
                if (e.getMaThe().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLTheDTO e : table){
                if (e.getMaKhachHang().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLTheDTO e : table){
                if (e.getNgayCap().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLTheDTO e : table){
                if (e.getNgayHetHan().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLTheDTO> filterBy_EndsWith_STRING_The(ArrayList <QLTheDTO> table, String header, String value){
        ArrayList <QLTheDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLTheBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLTheDTO e : table){
                if (e.getMaThe().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLTheDTO e : table){
                if (e.getMaKhachHang().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLTheDTO e : table){
                if (e.getNgayCap().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLTheDTO e : table){
                if (e.getNgayHetHan().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    /**     STRING - NhanVien       **/
    public ArrayList <QLNhanVienDTO> filterBy_Equails_STRING_NhanVien(ArrayList <QLNhanVienDTO> table, String header, String value){
        ArrayList <QLNhanVienDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLNhanVienBUS(0).getHeaders();
        System.err.println(table.size() + " " + header + " " + value);
        if (header.equals(headers[0])){
            for (QLNhanVienDTO e : table){
                if (e.getMaNhanVien().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLNhanVienDTO e : table){
                if (e.getPassword().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLNhanVienDTO e : table){
                if (e.getHoTen().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLNhanVienDTO e : table){
                if (e.getNgaySinh().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLNhanVienDTO e : table){
                if (e.getDiaChi().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLNhanVienDTO e : table){
                if (e.getSdt().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[6])){
            for (QLNhanVienDTO e : table){
                if (e.getEmail().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[7])){
            for (QLNhanVienDTO e : table){
                if (e.getChucVu().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLNhanVienDTO> filterBy_NotEquails_STRING_NhanVien(ArrayList <QLNhanVienDTO> table, String header, String value){
        ArrayList <QLNhanVienDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLNhanVienBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLNhanVienDTO e : table){
                if (!e.getMaNhanVien().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLNhanVienDTO e : table){
                if (!e.getPassword().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLNhanVienDTO e : table){
                if (!e.getHoTen().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLNhanVienDTO e : table){
                if (!e.getNgaySinh().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLNhanVienDTO e : table){
                if (!e.getDiaChi().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLNhanVienDTO e : table){
                if (!e.getSdt().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[6])){
            for (QLNhanVienDTO e : table){
                if (!e.getEmail().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[7])){
            for (QLNhanVienDTO e : table){
                if (!e.getChucVu().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLNhanVienDTO> filterBy_Contains_STRING_NhanVien(ArrayList <QLNhanVienDTO> table, String header, String value){
        ArrayList <QLNhanVienDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLNhanVienBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLNhanVienDTO e : table){
                if (e.getMaNhanVien().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLNhanVienDTO e : table){
                if (e.getPassword().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLNhanVienDTO e : table){
                if (e.getHoTen().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLNhanVienDTO e : table){
                if (e.getNgaySinh().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLNhanVienDTO e : table){
                if (e.getDiaChi().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLNhanVienDTO e : table){
                if (e.getSdt().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[6])){
            for (QLNhanVienDTO e : table){
                if (e.getEmail().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[7])){
            for (QLNhanVienDTO e : table){
                if (e.getChucVu().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLNhanVienDTO> filterBy_DoesNotContain_STRING_NhanVien(ArrayList <QLNhanVienDTO> table, String header, String value){
        ArrayList <QLNhanVienDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLNhanVienBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLNhanVienDTO e : table){
                if (!e.getMaNhanVien().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLNhanVienDTO e : table){
                if (!e.getPassword().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLNhanVienDTO e : table){
                if (!e.getHoTen().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLNhanVienDTO e : table){
                if (!e.getNgaySinh().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLNhanVienDTO e : table){
                if (!e.getDiaChi().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLNhanVienDTO e : table){
                if (!e.getSdt().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[6])){
            for (QLNhanVienDTO e : table){
                if (!e.getEmail().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[7])){
            for (QLNhanVienDTO e : table){
                if (!e.getChucVu().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLNhanVienDTO> filterBy_BeginsWith_STRING_NhanVien(ArrayList <QLNhanVienDTO> table, String header, String value){
        ArrayList <QLNhanVienDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLNhanVienBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLNhanVienDTO e : table){
                if (e.getMaNhanVien().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLNhanVienDTO e : table){
                if (e.getPassword().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLNhanVienDTO e : table){
                if (e.getHoTen().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLNhanVienDTO e : table){
                if (e.getNgaySinh().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLNhanVienDTO e : table){
                if (e.getDiaChi().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLNhanVienDTO e : table){
                if (e.getSdt().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[6])){
            for (QLNhanVienDTO e : table){
                if (e.getEmail().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[7])){
            for (QLNhanVienDTO e : table){
                if (e.getChucVu().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLNhanVienDTO> filterBy_EndsWith_STRING_NhanVien(ArrayList <QLNhanVienDTO> table, String header, String value){
        ArrayList <QLNhanVienDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLNhanVienBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLNhanVienDTO e : table){
                if (e.getMaNhanVien().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLNhanVienDTO e : table){
                if (e.getPassword().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLNhanVienDTO e : table){
                if (e.getHoTen().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLNhanVienDTO e : table){
                if (e.getNgaySinh().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLNhanVienDTO e : table){
                if (e.getDiaChi().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLNhanVienDTO e : table){
                if (e.getSdt().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[6])){
            for (QLNhanVienDTO e : table){
                if (e.getEmail().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[7])){
            for (QLNhanVienDTO e : table){
                if (e.getChucVu().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    /**         STRING - SachThuVien    **/
    public ArrayList <QLChiTietSachDTO> filterBy_Equails_STRING_SachThuVien(ArrayList <QLChiTietSachDTO> table, String header, String value){
        ArrayList <QLChiTietSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLChiTietSachBUS(0).getHeaders();
        System.err.println(table.size() + " " + header + " " + value);
        if (header.equals(headers[0])){
            for (QLChiTietSachDTO e : table){
                if (e.getIDSach().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLChiTietSachDTO e : table){
                if (e.getMaSach().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLChiTietSachDTO e : table){
                if (e.getTinhTrang().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLChiTietSachDTO> filterBy_NotEquails_STRING_SachThuVien(ArrayList <QLChiTietSachDTO> table, String header, String value){
        ArrayList <QLChiTietSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLChiTietSachBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLChiTietSachDTO e : table){
                if (!e.getIDSach().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLChiTietSachDTO e : table){
                if (!e.getMaSach().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLChiTietSachDTO e : table){
                if (!e.getTinhTrang().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLChiTietSachDTO> filterBy_Contains_STRING_SachThuVien(ArrayList <QLChiTietSachDTO> table, String header, String value){
        ArrayList <QLChiTietSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLChiTietSachBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLChiTietSachDTO e : table){
                if (e.getIDSach().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLChiTietSachDTO e : table){
                if (e.getMaSach().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLChiTietSachDTO e : table){
                if (e.getTinhTrang().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLChiTietSachDTO> filterBy_DoesNotContain_STRING_SachThuVien(ArrayList <QLChiTietSachDTO> table, String header, String value){
        ArrayList <QLChiTietSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLChiTietSachBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLChiTietSachDTO e : table){
                if (!e.getIDSach().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLChiTietSachDTO e : table){
                if (!e.getMaSach().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLChiTietSachDTO e : table){
                if (!e.getTinhTrang().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLChiTietSachDTO> filterBy_BeginsWith_STRING_SachThuVien(ArrayList <QLChiTietSachDTO> table, String header, String value){
        ArrayList <QLChiTietSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLChiTietSachBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLChiTietSachDTO e : table){
                if (e.getIDSach().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLChiTietSachDTO e : table){
                if (e.getMaSach().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLChiTietSachDTO e : table){
                if (e.getTinhTrang().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLChiTietSachDTO> filterBy_EndsWith_STRING_SachThuVien(ArrayList <QLChiTietSachDTO> table, String header, String value){
        ArrayList <QLChiTietSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLChiTietSachBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLChiTietSachDTO e : table){
                if (e.getIDSach().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLChiTietSachDTO e : table){
                if (e.getMaSach().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLChiTietSachDTO e : table){
                if (e.getTinhTrang().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    /**     STRING - PhieuMuon  **/
    public ArrayList <QLPhieuMuonDTO> filterBy_Equails_STRING_PhieuMuon(ArrayList <QLPhieuMuonDTO> table, String header, String value){
        ArrayList <QLPhieuMuonDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuMuonBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuMuonDTO e : table){
                if (e.getMaPhieuMuon().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuMuonDTO e : table){
                if (e.getMaThe().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuMuonDTO e : table){
//                if (e.getIDSach().equals(value)){
                    filter_res.add(e);
//                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLPhieuMuonDTO e : table){
                if (e.getNgayMuon().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLPhieuMuonDTO e : table){
                if (e.getNgayTra().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLPhieuMuonDTO> filterBy_NotEquails_STRING_PhieuMuon(ArrayList <QLPhieuMuonDTO> table, String header, String value){
        ArrayList <QLPhieuMuonDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuMuonBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuMuonDTO e : table){
                if (!e.getMaPhieuMuon().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuMuonDTO e : table){
                if (!e.getMaThe().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuMuonDTO e : table){
//                if (!e.getIDSach().equals(value)){
                    filter_res.add(e);
//                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLPhieuMuonDTO e : table){
                if (!e.getNgayMuon().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLPhieuMuonDTO e : table){
                if (!e.getNgayTra().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuMuonDTO> filterBy_Contains_STRING_PhieuMuon(ArrayList <QLPhieuMuonDTO> table, String header, String value){
        ArrayList <QLPhieuMuonDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuMuonBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuMuonDTO e : table){
                if (e.getMaPhieuMuon().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuMuonDTO e : table){
                if (e.getMaThe().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuMuonDTO e : table){
//                if (e.getIDSach().contains(value)){
                    filter_res.add(e);
//                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLPhieuMuonDTO e : table){
                if (e.getNgayMuon().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLPhieuMuonDTO e : table){
                if (e.getNgayTra().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuMuonDTO> filterBy_DoesNotContain_STRING_PhieuMuon(ArrayList <QLPhieuMuonDTO> table, String header, String value){
        ArrayList <QLPhieuMuonDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuMuonBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuMuonDTO e : table){
                if (!e.getMaPhieuMuon().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuMuonDTO e : table){
                if (!e.getMaThe().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuMuonDTO e : table){
//                if (!e.getIDSach().contains(value)){
                    filter_res.add(e);
//                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLPhieuMuonDTO e : table){
                if (!e.getNgayMuon().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLPhieuMuonDTO e : table){
                if (!e.getNgayTra().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuMuonDTO> filterBy_BeginsWith_STRING_PhieuMuon(ArrayList <QLPhieuMuonDTO> table, String header, String value){
        ArrayList <QLPhieuMuonDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuMuonBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuMuonDTO e : table){
                if (e.getMaPhieuMuon().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuMuonDTO e : table){
                if (e.getMaThe().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuMuonDTO e : table){
//                if (e.getIDSach().startsWith(value)){
                    filter_res.add(e);
//                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLPhieuMuonDTO e : table){
                if (e.getNgayMuon().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLPhieuMuonDTO e : table){
                if (e.getNgayTra().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuMuonDTO> filterBy_EndsWith_STRING_PhieuMuon(ArrayList <QLPhieuMuonDTO> table, String header, String value){
        ArrayList <QLPhieuMuonDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuMuonBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuMuonDTO e : table){
                if (e.getMaPhieuMuon().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuMuonDTO e : table){
                if (e.getMaThe().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuMuonDTO e : table){
//                if (e.getIDSach().endsWith(value)){
                    filter_res.add(e);
//                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLPhieuMuonDTO e : table){
                if (e.getNgayMuon().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLPhieuMuonDTO e : table){
                if (e.getNgayTra().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    /**     NUMBER - PhieuMuon  **/
    public ArrayList <QLPhieuMuonDTO> filterBy_Equails_NUMBER_PhieuMuon(ArrayList <QLPhieuMuonDTO> table, String header, int value){
        ArrayList <QLPhieuMuonDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuMuonBUS(0).getHeaders();
        if (header.equals(headers[4])){
            for (QLPhieuMuonDTO e : table){
                if (e.getThoiGianMuon()== value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuMuonDTO> filterBy_NotEquails_NUMBER_PhieuMuon(ArrayList <QLPhieuMuonDTO> table, String header, int value){
        ArrayList <QLPhieuMuonDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuMuonBUS(0).getHeaders();
        if (header.equals(headers[4])){
            for (QLPhieuMuonDTO e : table){
                if (e.getThoiGianMuon()!= value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuMuonDTO> filterBy_GreaterThan_NUMBER_PhieuMuon(ArrayList <QLPhieuMuonDTO> table, String header, int value){
        ArrayList <QLPhieuMuonDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuMuonBUS(0).getHeaders();
        if (header.equals(headers[4])){
            for (QLPhieuMuonDTO e : table){
                if (e.getThoiGianMuon()> value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuMuonDTO> filterBy_GreaterThanOrEqualsTo_NUMBER_PhieuMuon(ArrayList <QLPhieuMuonDTO> table, String header, int value){
        ArrayList <QLPhieuMuonDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuMuonBUS(0).getHeaders();
        if (header.equals(headers[4])){
            for (QLPhieuMuonDTO e : table){
                if (e.getThoiGianMuon()>= value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuMuonDTO> filterBy_LessThan_NUMBER_PhieuMuon(ArrayList <QLPhieuMuonDTO> table, String header, int value){
        ArrayList <QLPhieuMuonDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuMuonBUS(0).getHeaders();
        if (header.equals(headers[7])){
            for (QLPhieuMuonDTO e : table){
                if (e.getThoiGianMuon()< value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuMuonDTO> filterBy_LessThanOrEqualsTo_NUMBER_PhieuMuon(ArrayList <QLPhieuMuonDTO> table, String header, int value){
        ArrayList <QLPhieuMuonDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuMuonBUS(0).getHeaders();
        if (header.equals(headers[4])){
            for (QLPhieuMuonDTO e : table){
                if (e.getThoiGianMuon()<= value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    /**     STRING - KhoSach    **/
    public ArrayList <QLKhoSachDTO> filterBy_Equails_STRING_KhoSach(ArrayList <QLKhoSachDTO> table, String header, String value){
        ArrayList <QLKhoSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLKhoSachBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLKhoSachDTO e : table){
                if (e.getMaSach().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLKhoSachDTO> filterBy_NotEquails_STRING_KhoSach(ArrayList <QLKhoSachDTO> table, String header, String value){
        ArrayList <QLKhoSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLKhoSachBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLKhoSachDTO e : table){
                if (!e.getMaSach().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLKhoSachDTO> filterBy_Contains_STRING_KhoSach(ArrayList <QLKhoSachDTO> table, String header, String value){
        ArrayList <QLKhoSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLKhoSachBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLKhoSachDTO e : table){
                if (e.getMaSach().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLKhoSachDTO> filterBy_DoesNotContain_STRING_KhoSach(ArrayList <QLKhoSachDTO> table, String header, String value){
        ArrayList <QLKhoSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLKhoSachBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLKhoSachDTO e : table){
                if (!e.getMaSach().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLKhoSachDTO> filterBy_BeginsWith_STRING_KhoSach(ArrayList <QLKhoSachDTO> table, String header, String value){
        ArrayList <QLKhoSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLKhoSachBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLKhoSachDTO e : table){
                if (e.getMaSach().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLKhoSachDTO> filterBy_EndsWith_STRING_KhoSach(ArrayList <QLKhoSachDTO> table, String header, String value){
        ArrayList <QLKhoSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLKhoSachBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLKhoSachDTO e : table){
                if (e.getMaSach().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    /**     NUMBER - KhoSach        **/
    public ArrayList <QLKhoSachDTO> filterBy_Equails_NUMBER_KhoSach(ArrayList <QLKhoSachDTO> table, String header, int value){
        ArrayList <QLKhoSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLKhoSachBUS(0).getHeaders();
        if (header.equals(headers[1])){
            for (QLKhoSachDTO e : table){
                if (e.getSoLuong()== value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLKhoSachDTO> filterBy_NotEquails_NUMBER_KhoSach(ArrayList <QLKhoSachDTO> table, String header, int value){
        ArrayList <QLKhoSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLKhoSachBUS(0).getHeaders();
        if (header.equals(headers[1])){
            for (QLKhoSachDTO e : table){
                if (e.getSoLuong()!= value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLKhoSachDTO> filterBy_GreaterThan_NUMBER_KhoSach(ArrayList <QLKhoSachDTO> table, String header, int value){
        ArrayList <QLKhoSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLKhoSachBUS(0).getHeaders();
        if (header.equals(headers[1])){
            for (QLKhoSachDTO e : table){
                if (e.getSoLuong()> value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLKhoSachDTO> filterBy_GreaterThanOrEqualsTo_NUMBER_KhoSach(ArrayList <QLKhoSachDTO> table, String header, int value){
        ArrayList <QLKhoSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLKhoSachBUS(0).getHeaders();
        if (header.equals(headers[1])){
            for (QLKhoSachDTO e : table){
                if (e.getSoLuong()>= value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLKhoSachDTO> filterBy_LessThan_NUMBER_KhoSach(ArrayList <QLKhoSachDTO> table, String header, int value){
        ArrayList <QLKhoSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLKhoSachBUS(0).getHeaders();
        if (header.equals(headers[1])){
            for (QLKhoSachDTO e : table){
                if (e.getSoLuong()< value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLKhoSachDTO> filterBy_LessThanOrEqualsTo_NUMBER_KhoSach(ArrayList <QLKhoSachDTO> table, String header, int value){
        ArrayList <QLKhoSachDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLKhoSachBUS(0).getHeaders();
        if (header.equals(headers[1])){
            for (QLKhoSachDTO e : table){
                if (e.getSoLuong()<= value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    /**     STRING - KhachHang    **/
    public ArrayList <QLKhachHangDTO> filterBy_Equails_STRING_KhachHang(ArrayList <QLKhachHangDTO> table, String header, String value){
        ArrayList <QLKhachHangDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLKhachHangBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLKhachHangDTO e : table){
                if (e.getMaKhachHang().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLKhachHangDTO e : table){
                if (e.getHoTen().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLKhachHangDTO e : table){
                if (e.getNgaySinh().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLKhachHangDTO e : table){
                if (e.getDiaChi().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLKhachHangDTO e : table){
                if (e.getSdt().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLKhachHangDTO e : table){
                if (e.getEmail().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLKhachHangDTO> filterBy_NotEquails_STRING_KhachHang(ArrayList <QLKhachHangDTO> table, String header, String value){
        ArrayList <QLKhachHangDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLKhachHangBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLKhachHangDTO e : table){
                if (!e.getMaKhachHang().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLKhachHangDTO e : table){
                if (!e.getHoTen().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLKhachHangDTO e : table){
                if (!e.getNgaySinh().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLKhachHangDTO e : table){
                if (!e.getDiaChi().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLKhachHangDTO e : table){
                if (!e.getSdt().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLKhachHangDTO e : table){
                if (!e.getEmail().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLKhachHangDTO> filterBy_Contains_STRING_KhachHang(ArrayList <QLKhachHangDTO> table, String header, String value){
        ArrayList <QLKhachHangDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLKhachHangBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLKhachHangDTO e : table){
                if (e.getMaKhachHang().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLKhachHangDTO e : table){
                if (e.getHoTen().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLKhachHangDTO e : table){
                if (e.getNgaySinh().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLKhachHangDTO e : table){
                if (e.getDiaChi().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLKhachHangDTO e : table){
                if (e.getSdt().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLKhachHangDTO e : table){
                if (e.getEmail().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLKhachHangDTO> filterBy_DoesNotContain_STRING_KhachHang(ArrayList <QLKhachHangDTO> table, String header, String value){
        ArrayList <QLKhachHangDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLKhachHangBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLKhachHangDTO e : table){
                if (!e.getMaKhachHang().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLKhachHangDTO e : table){
                if (!e.getHoTen().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLKhachHangDTO e : table){
                if (!e.getNgaySinh().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLKhachHangDTO e : table){
                if (!e.getDiaChi().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLKhachHangDTO e : table){
                if (!e.getSdt().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLKhachHangDTO e : table){
                if (!e.getEmail().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLKhachHangDTO> filterBy_BeginsWith_STRING_KhachHang(ArrayList <QLKhachHangDTO> table, String header, String value){
        ArrayList <QLKhachHangDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLKhachHangBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLKhachHangDTO e : table){
                if (e.getMaKhachHang().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLKhachHangDTO e : table){
                if (e.getHoTen().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLKhachHangDTO e : table){
                if (e.getNgaySinh().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLKhachHangDTO e : table){
                if (e.getDiaChi().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLKhachHangDTO e : table){
                if (e.getSdt().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLKhachHangDTO e : table){
                if (e.getEmail().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLKhachHangDTO> filterBy_EndsWith_STRING_KhachHang(ArrayList <QLKhachHangDTO> table, String header, String value){
        ArrayList <QLKhachHangDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLKhachHangBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLKhachHangDTO e : table){
                if (e.getMaKhachHang().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLKhachHangDTO e : table){
                if (e.getHoTen().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLKhachHangDTO e : table){
                if (e.getNgaySinh().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLKhachHangDTO e : table){
                if (e.getDiaChi().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[4])){
            for (QLKhachHangDTO e : table){
                if (e.getSdt().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[5])){
            for (QLKhachHangDTO e : table){
                if (e.getEmail().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    /**     STRING - Quyen  **/
    public ArrayList <QLQuyenDTO> filterBy_Equails_STRING_Quyen(ArrayList <QLQuyenDTO> table, String header, String value){
        ArrayList <QLQuyenDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLQuyenBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLQuyenDTO e : table){
                if (e.getMaQuyen().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLQuyenDTO e : table){
                if (e.getTenQuyen().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLQuyenDTO e : table){
                if (e.getChitietQuyen().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLQuyenDTO> filterBy_NotEquails_STRING_Quyen(ArrayList <QLQuyenDTO> table, String header, String value){
        ArrayList <QLQuyenDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLQuyenBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLQuyenDTO e : table){
                if (!e.getMaQuyen().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLQuyenDTO e : table){
                if (!e.getTenQuyen().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLQuyenDTO e : table){
                if (!e.getChitietQuyen().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLQuyenDTO> filterBy_Contains_STRING_Quyen(ArrayList <QLQuyenDTO> table, String header, String value){
        ArrayList <QLQuyenDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLQuyenBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLQuyenDTO e : table){
                if (e.getMaQuyen().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLQuyenDTO e : table){
                if (e.getTenQuyen().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLQuyenDTO e : table){
                if (e.getChitietQuyen().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        
        return filter_res;
    }
    
    public ArrayList <QLQuyenDTO> filterBy_DoesNotContain_STRING_Quyen(ArrayList <QLQuyenDTO> table, String header, String value){
        ArrayList <QLQuyenDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLQuyenBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLQuyenDTO e : table){
                if (!e.getMaQuyen().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLQuyenDTO e : table){
                if (!e.getTenQuyen().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLQuyenDTO e : table){
                if (!e.getChitietQuyen().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        
        return filter_res;
    }
    
    public ArrayList <QLQuyenDTO> filterBy_BeginsWith_STRING_Quyen(ArrayList <QLQuyenDTO> table, String header, String value){
        ArrayList <QLQuyenDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLQuyenBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLQuyenDTO e : table){
                if (e.getMaQuyen().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLQuyenDTO e : table){
                if (e.getTenQuyen().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLQuyenDTO e : table){
                if (e.getChitietQuyen().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        
        return filter_res;
    }
    
    public ArrayList <QLQuyenDTO> filterBy_EndsWith_STRING_Quyen(ArrayList <QLQuyenDTO> table, String header, String value){
        ArrayList <QLQuyenDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLQuyenBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLQuyenDTO e : table){
                if (e.getMaQuyen().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLQuyenDTO e : table){
                if (e.getTenQuyen().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLQuyenDTO e : table){
                if (e.getChitietQuyen().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    /**     STRING - Admin  **/
    public ArrayList <QLAdminDTO> filterBy_Equails_STRING_Admin(ArrayList <QLAdminDTO> table, String header, String value){
        ArrayList <QLAdminDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLAdminBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLAdminDTO e : table){
                if (e.getTkAdmin().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLAdminDTO e : table){
                if (e.getPassword().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLAdminDTO e : table){
                if (e.getRFID_code().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLAdminDTO> filterBy_NotEquails_STRING_Admin(ArrayList <QLAdminDTO> table, String header, String value){
        ArrayList <QLAdminDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLAdminBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLAdminDTO e : table){
                if (!e.getTkAdmin().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLAdminDTO e : table){
                if (!e.getPassword().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLAdminDTO e : table){
                if (!e.getRFID_code().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLAdminDTO> filterBy_Contains_STRING_Admin(ArrayList <QLAdminDTO> table, String header, String value){
        ArrayList <QLAdminDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLAdminBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLAdminDTO e : table){
                if (e.getTkAdmin().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLAdminDTO e : table){
                if (e.getPassword().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLAdminDTO e : table){
                if (e.getRFID_code().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        
        return filter_res;
    }
    
    public ArrayList <QLAdminDTO> filterBy_DoesNotContain_STRING_Admin(ArrayList <QLAdminDTO> table, String header, String value){
        ArrayList <QLAdminDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLAdminBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLAdminDTO e : table){
                if (!e.getTkAdmin().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLAdminDTO e : table){
                if (!e.getPassword().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLAdminDTO e : table){
                if (!e.getRFID_code().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        
        return filter_res;
    }
    
    public ArrayList <QLAdminDTO> filterBy_BeginsWith_STRING_Admin(ArrayList <QLAdminDTO> table, String header, String value){
        ArrayList <QLAdminDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLAdminBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLAdminDTO e : table){
                if (e.getTkAdmin().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLAdminDTO e : table){
                if (e.getPassword().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLAdminDTO e : table){
                if (e.getRFID_code().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        
        return filter_res;
    }
    
    public ArrayList <QLAdminDTO> filterBy_EndsWith_STRING_Admin(ArrayList <QLAdminDTO> table, String header, String value){
        ArrayList <QLAdminDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLAdminBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLAdminDTO e : table){
                if (e.getTkAdmin().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLAdminDTO e : table){
                if (e.getPassword().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLAdminDTO e : table){
                if (e.getRFID_code().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    /**  STRING - PhieuXuat **/
    public ArrayList <QLPhieuXuatDTO> filterBy_Equails_STRING_PhieuXuat(ArrayList <QLPhieuXuatDTO> table, String header, String value){
        ArrayList <QLPhieuXuatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuXuatBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuXuatDTO e : table){
                if (e.getMaXuat().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuXuatDTO e : table){
                if (e.getNgayXuat().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuXuatDTO e : table){
                if (e.getMaNhanVien().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLPhieuXuatDTO> filterBy_NotEquails_STRING_PhieuXuat(ArrayList <QLPhieuXuatDTO> table, String header, String value){
        ArrayList <QLPhieuXuatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuXuatBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuXuatDTO e : table){
                if (!e.getMaXuat().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuXuatDTO e : table){
                if (!e.getNgayXuat().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuXuatDTO e : table){
                if (!e.getMaNhanVien().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLPhieuXuatDTO> filterBy_Contains_STRING_PhieuXuat(ArrayList <QLPhieuXuatDTO> table, String header, String value){
        ArrayList <QLPhieuXuatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuXuatBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuXuatDTO e : table){
                if (e.getMaXuat().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuXuatDTO e : table){
                if (e.getNgayXuat().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuXuatDTO e : table){
                if (e.getMaNhanVien().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        
        return filter_res;
    }
    
    public ArrayList <QLPhieuXuatDTO> filterBy_DoesNotContain_STRING_PhieuXuat(ArrayList <QLPhieuXuatDTO> table, String header, String value){
        ArrayList <QLPhieuXuatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuXuatBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuXuatDTO e : table){
                if (!e.getMaXuat().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuXuatDTO e : table){
                if (!e.getNgayXuat().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuXuatDTO e : table){
                if (!e.getMaNhanVien().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        
        return filter_res;
    }
    
    public ArrayList <QLPhieuXuatDTO> filterBy_BeginsWith_STRING_PhieuXuat(ArrayList <QLPhieuXuatDTO> table, String header, String value){
        ArrayList <QLPhieuXuatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuXuatBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuXuatDTO e : table){
                if (e.getMaXuat().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuXuatDTO e : table){
                if (e.getNgayXuat().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuXuatDTO e : table){
                if (e.getMaNhanVien().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        
        return filter_res;
    }
    
    public ArrayList <QLPhieuXuatDTO> filterBy_EndsWith_STRING_PhieuXuat(ArrayList <QLPhieuXuatDTO> table, String header, String value){
        ArrayList <QLPhieuXuatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuXuatBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuXuatDTO e : table){
                if (e.getMaXuat().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuXuatDTO e : table){
                if (e.getNgayXuat().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuXuatDTO e : table){
                if (e.getMaNhanVien().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    /**  NUMBER - PhieuXuat **/
    public ArrayList <QLPhieuXuatDTO> filterBy_Equails_NUMBER_PhieuXuat(ArrayList <QLPhieuXuatDTO> table, String header, int value){
        ArrayList <QLPhieuXuatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuXuatBUS(0).getHeaders();
        if (header.equals(headers[4])){
            for (QLPhieuXuatDTO e : table){
                if (e.getTongSoLuong()== value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuXuatDTO> filterBy_NotEquails_NUMBER_PhieuXuat(ArrayList <QLPhieuXuatDTO> table, String header, int value){
        ArrayList <QLPhieuXuatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuXuatBUS(0).getHeaders();
        if (header.equals(headers[4])){
            for (QLPhieuXuatDTO e : table){
                if (e.getTongSoLuong()!= value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuXuatDTO> filterBy_GreaterThan_NUMBER_PhieuXuat(ArrayList <QLPhieuXuatDTO> table, String header, int value){
        ArrayList <QLPhieuXuatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuXuatBUS(0).getHeaders();
        if (header.equals(headers[4])){
            for (QLPhieuXuatDTO e : table){
                if (e.getTongSoLuong()> value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuXuatDTO> filterBy_GreaterThanOrEqualsTo_NUMBER_PhieuXuat(ArrayList <QLPhieuXuatDTO> table, String header, int value){
        ArrayList <QLPhieuXuatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuXuatBUS(0).getHeaders();
        if (header.equals(headers[4])){
            for (QLPhieuXuatDTO e : table){
                if (e.getTongSoLuong()>= value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuXuatDTO> filterBy_LessThan_NUMBER_PhieuXuat(ArrayList <QLPhieuXuatDTO> table, String header, int value){
        ArrayList <QLPhieuXuatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuXuatBUS(0).getHeaders();
        if (header.equals(headers[4])){
            for (QLPhieuXuatDTO e : table){
                if (e.getTongSoLuong()< value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuXuatDTO> filterBy_LessThanOrEqualsTo_NUMBER_PhieuXuat(ArrayList <QLPhieuXuatDTO> table, String header, int value){
        ArrayList <QLPhieuXuatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuXuatBUS(0).getHeaders();
        if (header.equals(headers[4])){
            for (QLPhieuXuatDTO e : table){
                if (e.getTongSoLuong()<= value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    /**  STRING - PhieuNhap **/
    public ArrayList <QLPhieuNhapDTO> filterBy_Equails_STRING_PhieuNhap(ArrayList <QLPhieuNhapDTO> table, String header, String value){
        ArrayList <QLPhieuNhapDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuNhapBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuNhapDTO e : table){
                if (e.getMaNhap().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuNhapDTO e : table){
                if (e.getNgayNhap().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuNhapDTO e : table){
                if (e.getMaNhanVien().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLPhieuNhapDTO e : table){
                if (e.getMaNCC().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLPhieuNhapDTO> filterBy_NotEquails_STRING_PhieuNhap(ArrayList <QLPhieuNhapDTO> table, String header, String value){
        ArrayList <QLPhieuNhapDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuNhapBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuNhapDTO e : table){
                if (!e.getMaNhap().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuNhapDTO e : table){
                if (!e.getNgayNhap().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuNhapDTO e : table){
                if (!e.getMaNhanVien().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLPhieuNhapDTO e : table){
                if (!e.getMaNCC().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLPhieuNhapDTO> filterBy_Contains_STRING_PhieuNhap(ArrayList <QLPhieuNhapDTO> table, String header, String value){
        ArrayList <QLPhieuNhapDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuNhapBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuNhapDTO e : table){
                if (e.getMaNhap().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuNhapDTO e : table){
                if (e.getNgayNhap().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuNhapDTO e : table){
                if (e.getMaNhanVien().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLPhieuNhapDTO e : table){
                if (e.getMaNCC().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        
        return filter_res;
    }
    
    public ArrayList <QLPhieuNhapDTO> filterBy_DoesNotContain_STRING_PhieuNhap(ArrayList <QLPhieuNhapDTO> table, String header, String value){
        ArrayList <QLPhieuNhapDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuNhapBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuNhapDTO e : table){
                if (!e.getMaNhap().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuNhapDTO e : table){
                if (!e.getNgayNhap().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuNhapDTO e : table){
                if (!e.getMaNhanVien().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLPhieuNhapDTO e : table){
                if (!e.getMaNCC().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        
        return filter_res;
    }
    
    public ArrayList <QLPhieuNhapDTO> filterBy_BeginsWith_STRING_PhieuNhap(ArrayList <QLPhieuNhapDTO> table, String header, String value){
        ArrayList <QLPhieuNhapDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuNhapBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuNhapDTO e : table){
                if (e.getMaNhap().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuNhapDTO e : table){
                if (e.getNgayNhap().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuNhapDTO e : table){
                if (e.getMaNhanVien().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLPhieuNhapDTO e : table){
                if (e.getMaNCC().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        
        
        return filter_res;
    }
    
    public ArrayList <QLPhieuNhapDTO> filterBy_EndsWith_STRING_PhieuNhap(ArrayList <QLPhieuNhapDTO> table, String header, String value){
        ArrayList <QLPhieuNhapDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuNhapBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuNhapDTO e : table){
                if (e.getMaNhap().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuNhapDTO e : table){
                if (e.getNgayNhap().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuNhapDTO e : table){
                if (e.getMaNhanVien().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLPhieuNhapDTO e : table){
                if (e.getMaNCC().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    /**  NUMBER - PhieuNhap **/
    public ArrayList <QLPhieuNhapDTO> filterBy_Equails_NUMBER_PhieuNhap(ArrayList <QLPhieuNhapDTO> table, String header, int value){
        ArrayList <QLPhieuNhapDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuNhapBUS(0).getHeaders();
        if (header.equals(headers[5])){
            for (QLPhieuNhapDTO e : table){
                if (e.getTongSoLuong()== value){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[6])){
            for (QLPhieuNhapDTO e : table){
                if (e.getTongTien()== value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuNhapDTO> filterBy_NotEquails_NUMBER_PhieuNhap(ArrayList <QLPhieuNhapDTO> table, String header, int value){
        ArrayList <QLPhieuNhapDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuNhapBUS(0).getHeaders();
        if (header.equals(headers[5])){
            for (QLPhieuNhapDTO e : table){
                if (e.getTongSoLuong()!= value){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[6])){
            for (QLPhieuNhapDTO e : table){
                if (e.getTongTien()!= value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuNhapDTO> filterBy_GreaterThan_NUMBER_PhieuNhap(ArrayList <QLPhieuNhapDTO> table, String header, int value){
        ArrayList <QLPhieuNhapDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuNhapBUS(0).getHeaders();
        if (header.equals(headers[5])){
            for (QLPhieuNhapDTO e : table){
                if (e.getTongSoLuong()> value){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[6])){
            for (QLPhieuNhapDTO e : table){
                if (e.getTongTien()> value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuNhapDTO> filterBy_GreaterThanOrEqualsTo_NUMBER_PhieuNhap(ArrayList <QLPhieuNhapDTO> table, String header, int value){
        ArrayList <QLPhieuNhapDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuNhapBUS(0).getHeaders();
        if (header.equals(headers[5])){
            for (QLPhieuNhapDTO e : table){
                if (e.getTongSoLuong()>= value){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[6])){
            for (QLPhieuNhapDTO e : table){
                if (e.getTongTien()>= value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuNhapDTO> filterBy_LessThan_NUMBER_PhieuNhap(ArrayList <QLPhieuNhapDTO> table, String header, int value){
        ArrayList <QLPhieuNhapDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuNhapBUS(0).getHeaders();
        if (header.equals(headers[5])){
            for (QLPhieuNhapDTO e : table){
                if (e.getTongSoLuong()< value){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[6])){
            for (QLPhieuNhapDTO e : table){
                if (e.getTongTien()< value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuNhapDTO> filterBy_LessThanOrEqualsTo_NUMBER_PhieuNhap(ArrayList <QLPhieuNhapDTO> table, String header, int value){
        ArrayList <QLPhieuNhapDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuNhapBUS(0).getHeaders();
        if (header.equals(headers[5])){
            for (QLPhieuNhapDTO e : table){
                if (e.getTongSoLuong()<= value){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[6])){
            for (QLPhieuNhapDTO e : table){
                if (e.getTongTien()<= value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    /**  STRING - PhieuPhat **/
    public ArrayList <QLPhieuPhatDTO> filterBy_Equails_STRING_PhieuPhat(ArrayList <QLPhieuPhatDTO> table, String header, String value){
        ArrayList <QLPhieuPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuPhatBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuPhatDTO e : table){
                if (e.getMaPhieuPhat().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuPhatDTO e : table){
                if (e.getMaPhieuMuon().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuPhatDTO e : table){
                if (e.getMaLDPhat().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLPhieuPhatDTO> filterBy_NotEquails_STRING_PhieuPhat(ArrayList <QLPhieuPhatDTO> table, String header, String value){
        ArrayList <QLPhieuPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuPhatBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuPhatDTO e : table){
                if (!e.getMaPhieuPhat().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuPhatDTO e : table){
                if (!e.getMaPhieuMuon().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuPhatDTO e : table){
                if (!e.getMaLDPhat().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLPhieuPhatDTO> filterBy_Contains_STRING_PhieuPhat(ArrayList <QLPhieuPhatDTO> table, String header, String value){
        ArrayList <QLPhieuPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuPhatBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuPhatDTO e : table){
                if (e.getMaPhieuPhat().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuPhatDTO e : table){
                if (e.getMaPhieuMuon().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuPhatDTO e : table){
                if (e.getMaLDPhat().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        
        return filter_res;
    }
    
    public ArrayList <QLPhieuPhatDTO> filterBy_DoesNotContain_STRING_PhieuPhat(ArrayList <QLPhieuPhatDTO> table, String header, String value){
        ArrayList <QLPhieuPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuPhatBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuPhatDTO e : table){
                if (!e.getMaPhieuPhat().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuPhatDTO e : table){
                if (!e.getMaPhieuMuon().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuPhatDTO e : table){
                if (!e.getMaLDPhat().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        
        return filter_res;
    }
    
    public ArrayList <QLPhieuPhatDTO> filterBy_BeginsWith_STRING_PhieuPhat(ArrayList <QLPhieuPhatDTO> table, String header, String value){
        ArrayList <QLPhieuPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuPhatBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuPhatDTO e : table){
                if (e.getMaPhieuPhat().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuPhatDTO e : table){
                if (e.getMaPhieuMuon().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[3])){
            for (QLPhieuPhatDTO e : table){
                if (e.getMaLDPhat().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        
        
        return filter_res;
    }
    
    public ArrayList <QLPhieuPhatDTO> filterBy_EndsWith_STRING_PhieuPhat(ArrayList <QLPhieuPhatDTO> table, String header, String value){
        ArrayList <QLPhieuPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuPhatBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLPhieuPhatDTO e : table){
                if (e.getMaPhieuPhat().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLPhieuPhatDTO e : table){
                if (e.getMaPhieuMuon().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[2])){
            for (QLPhieuPhatDTO e : table){
                if (e.getMaLDPhat().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    /**  NUMBER - PhieuPhat **/
    public ArrayList <QLPhieuPhatDTO> filterBy_Equails_NUMBER_PhieuPhat(ArrayList <QLPhieuPhatDTO> table, String header, int value){
        ArrayList <QLPhieuPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuPhatBUS(0).getHeaders();
        if (header.equals(headers[3])){
            for (QLPhieuPhatDTO e : table){
                if (e.getTienPhat()== value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuPhatDTO> filterBy_NotEquails_NUMBER_PhieuPhat(ArrayList <QLPhieuPhatDTO> table, String header, int value){
        ArrayList <QLPhieuPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuPhatBUS(0).getHeaders();
        if (header.equals(headers[3])){
            for (QLPhieuPhatDTO e : table){
                if (e.getTienPhat()!= value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuPhatDTO> filterBy_GreaterThan_NUMBER_PhieuPhat(ArrayList <QLPhieuPhatDTO> table, String header, int value){
        ArrayList <QLPhieuPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuPhatBUS(0).getHeaders();
        if (header.equals(headers[3])){
            for (QLPhieuPhatDTO e : table){
                if (e.getTienPhat()> value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuPhatDTO> filterBy_GreaterThanOrEqualsTo_NUMBER_PhieuPhat(ArrayList <QLPhieuPhatDTO> table, String header, int value){
        ArrayList <QLPhieuPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuPhatBUS(0).getHeaders();
        if (header.equals(headers[3])){
            for (QLPhieuPhatDTO e : table){
                if (e.getTienPhat()>= value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuPhatDTO> filterBy_LessThan_NUMBER_PhieuPhat(ArrayList <QLPhieuPhatDTO> table, String header, int value){
        ArrayList <QLPhieuPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuPhatBUS(0).getHeaders();
        if (header.equals(headers[3])){
            for (QLPhieuPhatDTO e : table){
                if (e.getTienPhat()< value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLPhieuPhatDTO> filterBy_LessThanOrEqualsTo_NUMBER_PhieuPhat(ArrayList <QLPhieuPhatDTO> table, String header, int value){
        ArrayList <QLPhieuPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLPhieuPhatBUS(0).getHeaders();
        if (header.equals(headers[3])){
            for (QLPhieuPhatDTO e : table){
                if (e.getTienPhat()<= value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    /**  STRING - LDPhat **/
    public ArrayList <QLLDPhatDTO> filterBy_Equails_STRING_LDPhat(ArrayList <QLLDPhatDTO> table, String header, String value){
        ArrayList <QLLDPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLDPhatBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLLDPhatDTO e : table){
                if (e.getMaLDPhat().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLLDPhatDTO e : table){
                if (e.getTenLDPhat().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLLDPhatDTO> filterBy_NotEquails_STRING_LDPhat(ArrayList <QLLDPhatDTO> table, String header, String value){
        ArrayList <QLLDPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLDPhatBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLLDPhatDTO e : table){
                if (!e.getMaLDPhat().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLLDPhatDTO e : table){
                if (!e.getTenLDPhat().equals(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    public ArrayList <QLLDPhatDTO> filterBy_Contains_STRING_LDPhat(ArrayList <QLLDPhatDTO> table, String header, String value){
        ArrayList <QLLDPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLDPhatBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLLDPhatDTO e : table){
                if (e.getMaLDPhat().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLLDPhatDTO e : table){
                if (e.getTenLDPhat().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        
        return filter_res;
    }
    
    public ArrayList <QLLDPhatDTO> filterBy_DoesNotContain_STRING_LDPhat(ArrayList <QLLDPhatDTO> table, String header, String value){
        ArrayList <QLLDPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLDPhatBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLLDPhatDTO e : table){
                if (!e.getMaLDPhat().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLLDPhatDTO e : table){
                if (!e.getTenLDPhat().contains(value)){
                    filter_res.add(e);
                }
            }
        }
        
        
        return filter_res;
    }
    
    public ArrayList <QLLDPhatDTO> filterBy_BeginsWith_STRING_LDPhat(ArrayList <QLLDPhatDTO> table, String header, String value){
        ArrayList <QLLDPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLDPhatBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLLDPhatDTO e : table){
                if (e.getMaLDPhat().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLLDPhatDTO e : table){
                if (e.getTenLDPhat().startsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        
        
        return filter_res;
    }
    
    public ArrayList <QLLDPhatDTO> filterBy_EndsWith_STRING_LDPhat(ArrayList <QLLDPhatDTO> table, String header, String value){
        ArrayList <QLLDPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLDPhatBUS(0).getHeaders();
        if (header.equals(headers[0])){
            for (QLLDPhatDTO e : table){
                if (e.getMaLDPhat().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        else if (header.equals(headers[1])){
            for (QLLDPhatDTO e : table){
                if (e.getTenLDPhat().endsWith(value)){
                    filter_res.add(e);
                }
            }
        }
        
        return filter_res;
    }
    
    /**  NUMBER - LDPhat **/
    public ArrayList <QLLDPhatDTO> filterBy_Equails_NUMBER_LDPhat(ArrayList <QLLDPhatDTO> table, String header, int value){
        ArrayList <QLLDPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLDPhatBUS(0).getHeaders();
        if (header.equals(headers[2])){
            for (QLLDPhatDTO e : table){
                if (e.getMucDo()== value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLLDPhatDTO> filterBy_NotEquails_NUMBER_LDPhat(ArrayList <QLLDPhatDTO> table, String header, int value){
        ArrayList <QLLDPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLDPhatBUS(0).getHeaders();
        if (header.equals(headers[2])){
            for (QLLDPhatDTO e : table){
                if (e.getMucDo()!= value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLLDPhatDTO> filterBy_GreaterThan_NUMBER_LDPhat(ArrayList <QLLDPhatDTO> table, String header, int value){
        ArrayList <QLLDPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLDPhatBUS(0).getHeaders();
        if (header.equals(headers[2])){
            for (QLLDPhatDTO e : table){
                if (e.getMucDo()> value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLLDPhatDTO> filterBy_GreaterThanOrEqualsTo_NUMBER_LDPhat(ArrayList <QLLDPhatDTO> table, String header, int value){
        ArrayList <QLLDPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLDPhatBUS(0).getHeaders();
        if (header.equals(headers[2])){
            for (QLLDPhatDTO e : table){
                if (e.getMucDo()>= value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLLDPhatDTO> filterBy_LessThan_NUMBER_LDPhat(ArrayList <QLLDPhatDTO> table, String header, int value){
        ArrayList <QLLDPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLDPhatBUS(0).getHeaders();
        if (header.equals(headers[2])){
            for (QLLDPhatDTO e : table){
                if (e.getMucDo()< value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
    public ArrayList <QLLDPhatDTO> filterBy_LessThanOrEqualsTo_NUMBER_LDPhat(ArrayList <QLLDPhatDTO> table, String header, int value){
        ArrayList <QLLDPhatDTO> filter_res = new ArrayList<>();
        final String[] headers = new QLLDPhatBUS(0).getHeaders();
        if (header.equals(headers[2])){
            for (QLLDPhatDTO e : table){
                if (e.getMucDo()<= value){
                    filter_res.add(e);
                }
            }
        }
        return filter_res;
    }
    
}

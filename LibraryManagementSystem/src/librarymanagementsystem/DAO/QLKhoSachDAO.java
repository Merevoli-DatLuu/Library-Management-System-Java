package librarymanagementsystem.DAO;

import librarymanagementsystem.Toolkit.*;
import librarymanagementsystem.DTO.*;
import librarymanagementsystem.BUS.QLKhoSachBUS;
import librarymanagementsystem.BUS.QLPhieuNhapBUS;
import librarymanagementsystem.BUS.QLPhieuXuatBUS;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class QLKhoSachDAO {
    DBConnection DBKhoSach;
    
    public ArrayList<QLKhoSachDTO> readDB(){
        DBKhoSach = new DBConnection();
        ArrayList<QLKhoSachDTO> arrKhoSach = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM KhoSach";
            ResultSet rs = DBKhoSach.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    String maSach = rs.getString("maSach");
                    int soLuong = rs.getInt("soLuong");
                    arrKhoSach.add(new QLKhoSachDTO(maSach, soLuong));
                }
            }

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Kho Sách");
        } 
        finally{
            DBKhoSach.closeConnection();
        }
        return arrKhoSach;
    }
    
    // full view 'sach' X 'khosach'
    public ArrayList<QLKhoSachDTO> readDB_full(){
        DBKhoSach = new DBConnection();
        ArrayList<QLKhoSachDTO> arrKhoSach = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM KhoSach, LoaiSach Where KhoSach.maSach = LoaiSach.maSach";
            ResultSet rs = DBKhoSach.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    String maSach = rs.getString("maSach");
                    int soLuong = rs.getInt("soLuong");
                    String tenSach = rs.getString("tenSach");
                    String tenTacGia = rs.getString("tenTacGia");
                    String tenNXB = rs.getString("tenNXB");
                    String theLoai = rs.getString("theLoai");
                    String ngonNgu = rs.getString("ngonNgu");
                    String tomTatNoiDung = rs.getString("tomTatNoiDung");
                    int namXB = rs.getInt("namXB");
                    int giaTien = rs.getInt("giaTien");
                    int soTrang = rs.getInt("soTrang");
                    String hinh = rs.getString("hinhSach");
                    QLLoaiSachDTO sach = new QLLoaiSachDTO(maSach, tenSach, tenTacGia, tenNXB, theLoai, ngonNgu, tomTatNoiDung, namXB, giaTien, soTrang, hinh);
                    arrKhoSach.add(new QLKhoSachDTO(maSach, soLuong, sach));
                }
            }

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Kho Sách");
        } 
        finally{
            DBKhoSach.closeConnection();
        }
        return arrKhoSach;
    }
    
    public Boolean add(QLKhoSachDTO khoSach){
        DBKhoSach = new DBConnection();
        Boolean check = DBKhoSach.SQLUpdate("INSERT INTO KhoSach(maSach, soLuong) "
                + "VALUES ('"
                + khoSach.getMaSach()+ "',"       
                + khoSach.getSoLuong()+ ");");
        DBKhoSach.closeConnection();
        return check;
    }
    
    public Boolean del(String maSach){
        DBKhoSach = new DBConnection();
        Boolean check = DBKhoSach.SQLUpdate("DELETE FROM KhoSach WHERE KhoSach.maSach = '" + maSach + "';");
        DBKhoSach.closeConnection();
        return check;
    }
    
    public Boolean mod(QLKhoSachDTO khoSach){
        DBKhoSach = new DBConnection();
        Boolean check = DBKhoSach.SQLUpdate("Update KhoSach Set "
                + " soLuong=" + khoSach.getSoLuong()
                + " where maSach='" + khoSach.getMaSach()+ "';");
        DBKhoSach.closeConnection();
        return check;
    }
    
    public boolean refreshDB(){
        QLPhieuNhapBUS phieuNhap = new QLPhieuNhapBUS(0);
        QLPhieuXuatBUS phieuXuat = new QLPhieuXuatBUS(0);
        
        HashMap<String, Integer> hashmap = new HashMap<String, Integer>();
        for (QLPhieuNhapDTO e : phieuNhap.getArrNhapKho()){
            int size = e.getMaSach().size();
            for (int i=0; i<size; i++){
                if (!hashmap.containsKey(e.getMaSach().get(i))){
                    hashmap.put(e.getMaSach().get(i), e.getSoLuong().get(i));
                }
                else{
                    hashmap.put(e.getMaSach().get(i), hashmap.get(e.getMaSach().get(i)) + e.getSoLuong().get(i));
                }
            }
        }
        
        for (QLPhieuXuatDTO e : phieuXuat.getArrXuatKho()){
            int size = e.getMaSach().size();
            for (int i=0; i<size; i++){
                if (!hashmap.containsKey(e.getMaSach().get(i))){
                    hashmap.put(e.getMaSach().get(i), 0);
                    System.err.println("Lỗi refresh Kho Sách - Mã " + e.getMaSach().get(i) + " không tồn tại");
                    return false;
                }
                else{
                    if (hashmap.get(e.getMaSach().get(i)) - e.getSoLuong().get(i) < 0){
                        System.err.println("Lỗi refresh Kho Sách - " + e.getMaSach().get(i) + "Xuất nhiều hơn sách có trong kho");
                        return false;
                    }
                    hashmap.put(e.getMaSach().get(i), hashmap.get(e.getMaSach().get(i)) - e.getSoLuong().get(i));
                }
            }
        }
        
        DBKhoSach = new DBConnection();
        Boolean check = DBKhoSach.SQLUpdate("TRUNCATE TABLE khosach");
        DBKhoSach.closeConnection();
        if (!check){
            return check;
        }
        check = true;
        for (String e : hashmap.keySet()) {
            if (add(new QLKhoSachDTO(e, hashmap.get(e))) == false){
                check = false;
            }
//            System.out.println(e + " " + hashmap.get(e));
        }
        new QLKhoSachBUS();
        
        return check;
    }
    
    public static void main(String[] args) {
        new QLKhoSachDAO().refreshDB();
    }
}

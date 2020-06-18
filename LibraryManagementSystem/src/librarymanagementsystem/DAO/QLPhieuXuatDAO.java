package librarymanagementsystem.DAO;

import librarymanagementsystem.Toolkit.*;
import librarymanagementsystem.DTO.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class QLPhieuXuatDAO {
    DBConnection DBXuatKhoSach;
    
    public ArrayList<QLPhieuXuatDTO> readDB(){
        DBXuatKhoSach = new DBConnection();
        ArrayList<QLPhieuXuatDTO> arrXuatKho = new ArrayList<>();
        
        try{
            HashMap<String, ArrayList <String> > hashmap = new HashMap<String, ArrayList <String> >();
            HashMap<String, ArrayList <Integer> > hashmap_2 = new HashMap<String, ArrayList <Integer> >();
            String query_maSach = "SELECT * FROM chiTietPhieuXuat";
            ResultSet rs_maSach = DBXuatKhoSach.SQLQuery(query_maSach);
            if (rs_maSach != null){
                while (rs_maSach.next()){
                    String maPhieuNhap = rs_maSach.getString("maXuat");
                    String maSach = rs_maSach.getString("maSach");
                    int soLuong = rs_maSach.getInt("soLuong");
                    if (!hashmap.containsKey(maPhieuNhap)){
                        ArrayList <String > temp = new ArrayList<>();
                        temp.add(maSach);
                        hashmap.put(maPhieuNhap, temp);
                        
                        ArrayList <Integer > temp_2 = new ArrayList<>();
                        temp_2.add(soLuong);
                        hashmap_2.put(maPhieuNhap, temp_2);
                    }
                    else{
                        ArrayList <String > temp = hashmap.get(maPhieuNhap);
                        
                        temp.add(maSach);
                        hashmap.put(maPhieuNhap, temp);
                        
                        ArrayList <Integer > temp_2 = hashmap_2.get(maPhieuNhap);
                        
                        temp_2.add(soLuong);
                        hashmap_2.put(maPhieuNhap, temp_2);
                    }
                }
            }
            
            String query = "SELECT * FROM PhieuXuat";
            ResultSet rs = DBXuatKhoSach.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    String maXuat = rs.getString("maXuat");
                    String ngayXuat = rs.getString("ngayXuat");                    
                    ArrayList <String> maSach = hashmap.get(maXuat);
                    ArrayList <Integer> soLuong = hashmap_2.get(maXuat);
                    String maNhanVien = rs.getString("maNhanVien");
                    int tongSoLuong = rs.getInt("tongSoLuong");
                    
 
                    
                    arrXuatKho.add(new QLPhieuXuatDTO(maXuat, ngayXuat, maSach, soLuong, maNhanVien, tongSoLuong));
                }
            }

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Xuất Phiếu Xuất");
        } 
        finally{
            DBXuatKhoSach.closeConnection();
        }
        return arrXuatKho;
    }
    
    public Boolean add(QLPhieuXuatDTO xuatKho){
        DBXuatKhoSach = new DBConnection();
        Boolean check1 = DBXuatKhoSach.SQLUpdate("INSERT INTO PhieuXuat(maXuat, ngayXuat, maNhanVien, tongSoLuong) "
                + "VALUES ('"
                + xuatKho.getMaXuat()+ "','"     
                + xuatKho.getNgayXuat()+ "','"     
                + xuatKho.getMaNhanVien()+ "',"     
                + xuatKho.getTongSoLuong()+ ");");  
        
        Boolean check2 = true;
        for (int i=0; i<xuatKho.getMaSach().size(); i++){
            Boolean check = DBXuatKhoSach.SQLUpdate("INSERT INTO ChiTietPhieuXuat(maXuat, maSach, soLuong) "
                    + "VALUES ('"
                    + xuatKho.getMaXuat()+ "','"     
                    + xuatKho.getMaSach().get(i)+ "',"   
                    + xuatKho.getSoLuong().get(i)+ ");");
            if (!check){
                check2 = check;
            }
        }
        DBXuatKhoSach.closeConnection();
        return check1 && check2 && new QLKhoSachDAO().refreshDB();
    }
    
    public Boolean add(String maXuat, String ngayXuat, ArrayList <String> maSach, ArrayList <Integer> soLuong, String maNhanVien, int tongSoLuong){
        DBXuatKhoSach = new DBConnection();
        Boolean check1 = DBXuatKhoSach.SQLUpdate("INSERT INTO PhieuXuat(maXuat, ngayXuat, maNhanVien, tongSoLuong) "
                + "VALUES ('"
                + maXuat+ "','"
                + ngayXuat+ "','"    
                + maNhanVien+ "',"    
                + tongSoLuong+ ");");  
        
        Boolean check2 = true;
        for (int i=0; i<maSach.size(); i++){
            Boolean check = DBXuatKhoSach.SQLUpdate("INSERT INTO ChiTietPhieuXuat(maXuat, maSach, soLuong) "
                    + "VALUES ('"
                    + maXuat+ "','"     
                    + maSach.get(i)+ "',"   
                    + soLuong.get(i)+ ");");
            if (!check){
                check2 = false;
            }
        }
        DBXuatKhoSach.closeConnection();
        return check1 && check2 && new QLKhoSachDAO().refreshDB();
    }
    
    public Boolean del(String maXuat){
        DBXuatKhoSach = new DBConnection();
        Boolean check1 = DBXuatKhoSach.SQLUpdate("DELETE FROM PhieuXuat WHERE PhieuXuat.maXuat = '" + maXuat + "';");
        Boolean check2 = DBXuatKhoSach.SQLUpdate("DELETE FROM ChiTietPhieuXuat WHERE ChiTietPhieuXuat.maXuat = '" + maXuat + "';");
        DBXuatKhoSach.closeConnection();
        return check1 && check2 && new QLKhoSachDAO().refreshDB();
    }
    
    public Boolean mod(QLPhieuXuatDTO xuatKho){
        DBXuatKhoSach = new DBConnection();
        Boolean check1 = DBXuatKhoSach.SQLUpdate("Update PhieuXuat Set "
                + " ngayXuat='" + xuatKho.getNgayXuat()
                + " maNhanVien='" + xuatKho.getMaNhanVien()
                + " tongSoLuong='" + xuatKho.getTongSoLuong()
                + "' where maXuat='" + xuatKho.getMaXuat()+ "';");
        
        Boolean check2 = DBXuatKhoSach.SQLUpdate("DELETE FROM ChiTietPhieuXuat WHERE ChiTietPhieuXuat.maXuat = '" + xuatKho.getMaXuat() + "';");
        for (int i=0; i<xuatKho.getMaSach().size(); i++){
            Boolean check = DBXuatKhoSach.SQLUpdate("INSERT INTO ChiTietPhieuXuat(maXuat, maSach, soLuong) "
                    + "VALUES ('"
                    + xuatKho.getMaXuat()+ "','"     
                    + xuatKho.getMaSach().get(i)+ "',"   
                    + xuatKho.getSoLuong().get(i)+ ");");
            if (!check){
                check2 = check;
            }
        }
        DBXuatKhoSach.closeConnection();
        return check1 && check2 && new QLKhoSachDAO().refreshDB();
    }
    
    public Boolean mod(String maXuat, String ngayXuat, ArrayList <String> maSach, ArrayList <Integer> soLuong, String maNhanVien, int tongSoLuong){
        DBXuatKhoSach = new DBConnection();
        Boolean check1 = DBXuatKhoSach.SQLUpdate("Update PhieuXuat Set "
                + " ngayXuat='" + ngayXuat
                + " maNhanVien='" + maNhanVien
                + " tongSoLuong='" + tongSoLuong
                + "' where maXuat='" + maXuat+ "';");
        
        Boolean check2 = DBXuatKhoSach.SQLUpdate("DELETE FROM ChiTietPhieuXuat WHERE ChiTietPhieuXuat.maXuat = '" + maXuat + "';");
        for (int i=0; i<maSach.size(); i++){
            Boolean check = DBXuatKhoSach.SQLUpdate("INSERT INTO ChiTietPhieuXuat(maXuat, maSach, soLuong) "
                    + "VALUES ('"
                    + maXuat+ "','"     
                    + maSach.get(i)+ "',"   
                    + soLuong.get(i)+ ");");
            if (!check){
                check2 = check;
            }
        }
        DBXuatKhoSach.closeConnection();
        return check1 && check2 && new QLKhoSachDAO().refreshDB();
    }
}

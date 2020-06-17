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
            String query = "SELECT * FROM PhieuXuat";
            ResultSet rs = DBXuatKhoSach.SQLQuery(query);
            if (rs != null){
                while (rs.next()){
                    String maXuat = rs.getString("maXuat");
                    String ngayXuat = rs.getString("ngayXuat");                    
                    ArrayList <String> maSach = new ArrayList <String> ();
                    ArrayList <Integer> soLuong = new ArrayList <Integer> ();
                    String maNhanVien = rs.getString("maNhanVien");
                    int tongSoLuong = rs.getInt("tongSoLuong");
                    
                    String query_chiTietPhieuXuat = "SELECT * FROM chiTietPhieuXuat WHERE ChiTietPhieuXuat.maXuat = '"  + maXuat + "'";
                    ResultSet rs_chiTietPhieuXuat = DBXuatKhoSach.SQLQuery(query_chiTietPhieuXuat);
                    if (rs_chiTietPhieuXuat != null){
                        while (rs_chiTietPhieuXuat.next()){
                            maSach.add(rs_chiTietPhieuXuat.getString("maSach"));
                            soLuong.add(rs_chiTietPhieuXuat.getInt("soLuong"));
                        }
                    }
                    
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
        return check1 & check2;
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
        return check1 & check2;
    }
    
    public Boolean del(String maXuat){
        DBXuatKhoSach = new DBConnection();
        Boolean check1 = DBXuatKhoSach.SQLUpdate("DELETE FROM PhieuXuat WHERE PhieuXuat.maXuat = '" + maXuat + "';");
        Boolean check2 = DBXuatKhoSach.SQLUpdate("DELETE FROM ChiTietPhieuXuat WHERE ChiTietPhieuXuat.maXuat = '" + maXuat + "';");
        DBXuatKhoSach.closeConnection();
        return check1 && check2;
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
        return check1 && check2;
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
        return check1 && check2;
    }
}

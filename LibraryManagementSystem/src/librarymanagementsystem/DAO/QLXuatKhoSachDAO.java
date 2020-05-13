package librarymanagementsystem.DAO;

import librarymanagementsystem.Toolkit.*;
import librarymanagementsystem.DTO.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class QLXuatKhoSachDAO {
    DBConnection DBXuatKhoSach;
    
    public ArrayList<QLXuatKhoSachDTO> readDB(){
        DBXuatKhoSach = new DBConnection();
        ArrayList<QLXuatKhoSachDTO> arrXuatKho = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM xuatKhoSach, xuatKho WHERE xuatKhoSach.maXuat = xuatKho.maXuat";
            ResultSet rs = DBXuatKhoSach.SQLQuery(query);
            String maXuat, thoiDiemXuat = null;
            ArrayList <String> maSach = new ArrayList<>();
            ArrayList <Integer> soLuong = new ArrayList<>();
            
            ArrayList <String> _maXuat = new ArrayList<>();
            ArrayList <String> _thoiDiemXuat = new ArrayList<>();
            ArrayList <String> _maSach = new ArrayList<>();
            ArrayList <Integer> _soLuong = new ArrayList<>();
            
            if (rs != null){
                while (rs.next()){
                    _maXuat.add(rs.getString("maXuat"));
                    _thoiDiemXuat.add(rs.getString("thoiDiemXuat"));
                    _maSach.add(rs.getString("maSach"));
                    _soLuong.add(rs.getInt("soLuong"));
                }
            }
            
            // Bad java - đừng hỏi sao chỗ này viết tệ đến vậy. Đơn giản là do java như L
            
            HashMap <String, Integer> hm_maXuat = new HashMap <String, Integer> ();
          
            for (int i=0; i<_maXuat.size(); i++){
                hm_maXuat.put(_maXuat.get(i), 1);
            }
            
            for (String e : hm_maXuat.keySet()){
                maXuat = e;
                for (int i=0; i<=_maXuat.size() && _maXuat.get(i).equals(e); i++){
                    thoiDiemXuat = _thoiDiemXuat.get(i);
                    maSach.add(_maSach.get(i));
                    soLuong.add(_soLuong.get(i));
                }
                arrXuatKho.add(new QLXuatKhoSachDTO(maXuat, thoiDiemXuat, maSach, soLuong));
            }
            
            //
            
                

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Xuất Kho Sach");
        } 
        finally{
            DBXuatKhoSach.closeConnection();
        }
        return arrXuatKho;
    }
    
    public Boolean add(QLXuatKhoSachDTO xuatKho){
        DBXuatKhoSach = new DBConnection();
        Boolean check1 = DBXuatKhoSach.SQLUpdate("INSERT INTO xuatKhoSach(maXuat, thoiDiemXuat) "
                + "VALUES ('"
                + xuatKho.getMaXuat()+ "','"     
                + xuatKho.getThoiDiemXuat()+ ");");  
        
        Boolean check2 = true;
        for (int i=0; i<xuatKho.getMaSach().size(); i++){
            Boolean check = DBXuatKhoSach.SQLUpdate("INSERT INTO xuatKho(maXuat, maSach, soLuong) "
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
    
    public Boolean add(String maXuat, String thoiDiemXuat, ArrayList <String> maSach, ArrayList <Integer> soLuong){
        DBXuatKhoSach = new DBConnection();
        Boolean check1 = DBXuatKhoSach.SQLUpdate("INSERT INTO xuatKhoSach(maXuat, thoiDiemXuat) "
                + "VALUES ('"
                + maXuat+ "','"     
                + thoiDiemXuat+ ");");  
        
        Boolean check2 = true;
        for (int i=0; i<maSach.size(); i++){
            Boolean check = DBXuatKhoSach.SQLUpdate("INSERT INTO xuatKho(maXuat, maSach, soLuong) "
                    + "VALUES ('"
                    + maXuat+ "','"     
                    + maSach.get(i)+ "',"   
                    + soLuong.get(i)+ ");");
            if (!check){
                check2 = check;
            }
        }
        DBXuatKhoSach.closeConnection();
        return check1 & check2;
    }
    
    public Boolean del(String maXuat){
        DBXuatKhoSach = new DBConnection();
        Boolean check1 = DBXuatKhoSach.SQLUpdate("DELETE FROM xuatKhoSach WHERE xuatKhoSach.maXuat = '" + maXuat + "';");
        Boolean check2 = DBXuatKhoSach.SQLUpdate("DELETE FROM xuatKho WHERE xuatKho.maXuat = '" + maXuat + "';");
        DBXuatKhoSach.closeConnection();
        return check1 && check2;
    }
    
    public Boolean mod(QLXuatKhoSachDTO xuatKho){
        DBXuatKhoSach = new DBConnection();
        Boolean check1 = DBXuatKhoSach.SQLUpdate("Update xuatKhoSach Set "
                + " thoiDiemXuat='" + xuatKho.getThoiDiemXuat()
                + "' where maXuat='" + xuatKho.getMaXuat()+ "';");
        
        Boolean check2 = DBXuatKhoSach.SQLUpdate("DELETE FROM xuatKho WHERE xuatKho.maXuat = '" + xuatKho.getMaXuat() + "';");
        for (int i=0; i<xuatKho.getMaSach().size(); i++){
            Boolean check = DBXuatKhoSach.SQLUpdate("INSERT INTO xuatKho(maXuat, maSach, soLuong) "
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
    
    public Boolean mod(String maXuat, String thoiDiemXuat, ArrayList <String> maSach, ArrayList <Integer> soLuong){
        DBXuatKhoSach = new DBConnection();
        Boolean check1 = DBXuatKhoSach.SQLUpdate("Update xuatKhoSach Set "
                + " thoiDiemXuat='" + thoiDiemXuat
                + "' where maXuat='" + maXuat+ "';");
        
        Boolean check2 = DBXuatKhoSach.SQLUpdate("DELETE FROM xuatKho WHERE xuatKho.maXuat = '" + maXuat + "';");
        for (int i=0; i<maSach.size(); i++){
            Boolean check = DBXuatKhoSach.SQLUpdate("INSERT INTO xuatKho(maXuat, maSach, soLuong) "
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

package librarymanagementsystem.DAO;

import librarymanagementsystem.Toolkit.*;
import librarymanagementsystem.DTO.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class QLNhapKhoSachDAO {
    DBConnection DBNhapKhoSach;
    
    public ArrayList<QLNhapKhoSachDTO> readDB(){
        DBNhapKhoSach = new DBConnection();
        ArrayList<QLNhapKhoSachDTO> arrNhapKho = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM nhapKhoSach, nhapKho WHERE nhapKhoSach.maNhap = nhapKho.maNhap";
            ResultSet rs = DBNhapKhoSach.SQLQuery(query);
            String maNhap, thoiDiemNhap = null;
            ArrayList <String> maSach = new ArrayList<>();
            ArrayList <Integer> soLuong = new ArrayList<>();
            
            ArrayList <String> _maNhap = new ArrayList<>();
            ArrayList <String> _thoiDiemNhap = new ArrayList<>();
            ArrayList <String> _maSach = new ArrayList<>();
            ArrayList <Integer> _soLuong = new ArrayList<>();
            
            if (rs != null){
                while (rs.next()){
                    _maNhap.add(rs.getString("maNhap"));
                    _thoiDiemNhap.add(rs.getString("thoiDiemNhap"));
                    _maSach.add(rs.getString("maSach"));
                    _soLuong.add(rs.getInt("soLuong"));
                }
            }
            
            // Bad java - đừng hỏi sao chỗ này viết tệ đến vậy. Đơn giản là do java như L
            
            HashMap <String, Integer> hm_maNhap = new HashMap <String, Integer> ();
          
            for (int i=0; i<_maNhap.size(); i++){
                hm_maNhap.put(_maNhap.get(i), 1);
            }
            
            for (String e : hm_maNhap.keySet()){
                maNhap = e;
                for (int i=0; i<=_maNhap.size() && _maNhap.get(i).equals(e); i++){
                    thoiDiemNhap = _thoiDiemNhap.get(i);
                    maSach.add(_maSach.get(i));
                    soLuong.add(_soLuong.get(i));
                }
                arrNhapKho.add(new QLNhapKhoSachDTO(maNhap, thoiDiemNhap, maSach, soLuong));
            }
            
            //
            
                

        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Nhập Kho Sach");
        } 
        finally{
            DBNhapKhoSach.closeConnection();
        }
        return arrNhapKho;
    }
    
    public Boolean add(QLNhapKhoSachDTO nhapKho){
        DBNhapKhoSach = new DBConnection();
        Boolean check1 = DBNhapKhoSach.SQLUpdate("INSERT INTO nhapKhoSach(maNhap, thoiDiemNhap) "
                + "VALUES ('"
                + nhapKho.getMaNhap()+ "','"     
                + nhapKho.getThoiDiemNhap()+ ");");  
        
        Boolean check2 = true;
        for (int i=0; i<nhapKho.getMaSach().size(); i++){
            Boolean check = DBNhapKhoSach.SQLUpdate("INSERT INTO nhapKho(maNhap, maSach, soLuong) "
                    + "VALUES ('"
                    + nhapKho.getMaNhap()+ "','"     
                    + nhapKho.getMaSach().get(i)+ "',"   
                    + nhapKho.getSoLuong().get(i)+ ");");
            if (!check){
                check2 = check;
            }
        }
        DBNhapKhoSach.closeConnection();
        return check1 & check2;
    }
    
    public Boolean add(String maNhap, String thoiDiemNhap, ArrayList <String> maSach, ArrayList <Integer> soLuong){
        DBNhapKhoSach = new DBConnection();
        Boolean check1 = DBNhapKhoSach.SQLUpdate("INSERT INTO nhapKhoSach(maNhap, thoiDiemNhap) "
                + "VALUES ('"
                + maNhap+ "','"     
                + thoiDiemNhap+ ");");  
        
        Boolean check2 = true;
        for (int i=0; i<maSach.size(); i++){
            Boolean check = DBNhapKhoSach.SQLUpdate("INSERT INTO nhapKho(maNhap, maSach, soLuong) "
                    + "VALUES ('"
                    + maNhap+ "','"     
                    + maSach.get(i)+ "',"   
                    + soLuong.get(i)+ ");");
            if (!check){
                check2 = check;
            }
        }
        DBNhapKhoSach.closeConnection();
        return check1 & check2;
    }
    
    public Boolean del(String maNhap){
        DBNhapKhoSach = new DBConnection();
        Boolean check1 = DBNhapKhoSach.SQLUpdate("DELETE FROM nhapKhoSach WHERE nhapKhoSach.maNhap = '" + maNhap + "';");
        Boolean check2 = DBNhapKhoSach.SQLUpdate("DELETE FROM nhapKho WHERE nhapKho.maNhap = '" + maNhap + "';");
        DBNhapKhoSach.closeConnection();
        return check1 && check2;
    }
    
    public Boolean mod(QLNhapKhoSachDTO nhapKho){
        DBNhapKhoSach = new DBConnection();
        Boolean check1 = DBNhapKhoSach.SQLUpdate("Update nhapKhoSach Set "
                + " thoiDiemNhap='" + nhapKho.getThoiDiemNhap()
                + "' where maNhap='" + nhapKho.getMaNhap()+ "';");
        
        Boolean check2 = DBNhapKhoSach.SQLUpdate("DELETE FROM nhapKho WHERE nhapKho.maNhap = '" + nhapKho.getMaNhap() + "';");
        for (int i=0; i<nhapKho.getMaSach().size(); i++){
            Boolean check = DBNhapKhoSach.SQLUpdate("INSERT INTO nhapKho(maNhap, maSach, soLuong) "
                    + "VALUES ('"
                    + nhapKho.getMaNhap()+ "','"     
                    + nhapKho.getMaSach().get(i)+ "',"   
                    + nhapKho.getSoLuong().get(i)+ ");");
            if (!check){
                check2 = check;
            }
        }
        DBNhapKhoSach.closeConnection();
        return check1 && check2;
    }
    
    public Boolean mod(String maNhap, String thoiDiemNhap, ArrayList <String> maSach, ArrayList <Integer> soLuong){
        DBNhapKhoSach = new DBConnection();
        Boolean check1 = DBNhapKhoSach.SQLUpdate("Update nhapKhoSach Set "
                + " thoiDiemNhap='" + thoiDiemNhap
                + "' where maNhap='" + maNhap+ "';");
        
        Boolean check2 = DBNhapKhoSach.SQLUpdate("DELETE FROM nhapKho WHERE nhapKho.maNhap = '" + maNhap + "';");
        for (int i=0; i<maSach.size(); i++){
            Boolean check = DBNhapKhoSach.SQLUpdate("INSERT INTO nhapKho(maNhap, maSach, soLuong) "
                    + "VALUES ('"
                    + maNhap+ "','"     
                    + maSach.get(i)+ "',"   
                    + soLuong.get(i)+ ");");
            if (!check){
                check2 = check;
            }
        }
        DBNhapKhoSach.closeConnection();
        return check1 && check2;
    }
}

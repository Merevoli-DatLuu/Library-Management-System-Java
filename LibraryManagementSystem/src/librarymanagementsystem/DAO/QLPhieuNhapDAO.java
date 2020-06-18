package librarymanagementsystem.DAO;

import librarymanagementsystem.Toolkit.*;
import librarymanagementsystem.DTO.*;
import librarymanagementsystem.BUS.QLKhoSachBUS;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class QLPhieuNhapDAO {
    DBConnection DBNhapKhoSach;
      
    public ArrayList<QLPhieuNhapDTO> readDB(){
        DBNhapKhoSach = new DBConnection();
        ArrayList<QLPhieuNhapDTO> arrNhapKho = new ArrayList<>();
        
        try{
            HashMap<String, ArrayList <String> > hashmap = new HashMap<String, ArrayList <String> >();
            HashMap<String, ArrayList <Integer> > hashmap_2 = new HashMap<String, ArrayList <Integer> >();
            String query_maSach = "SELECT * FROM chiTietPhieuNhap";
            ResultSet rs_maSach = DBNhapKhoSach.SQLQuery(query_maSach);
            if (rs_maSach != null){
                while (rs_maSach.next()){
                    String maPhieuNhap = rs_maSach.getString("maNhap");
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
            
            String query = "SELECT * FROM PhieuNhap";
            ResultSet rs = DBNhapKhoSach.SQLQuery(query);
            
            if (rs != null){
                while (rs.next()){
                    String maNhap = rs.getString("maNhap");
                    String ngayNhap = rs.getString("ngayNhap");                    
                    ArrayList <String> maSach = hashmap.get(maNhap);
                    ArrayList <Integer> soLuong = hashmap_2.get(maNhap);
                    String maNhanVien = rs.getString("maNhanVien");
                    String maNCC = rs.getString("maNCC");
                    int tongSoLuong = rs.getInt("tongSoLuong");
                    int tongTien = rs.getInt("tongTien");
                    
                    arrNhapKho.add(new QLPhieuNhapDTO(maNhap, ngayNhap, maSach, soLuong, maNhanVien, maNCC, tongSoLuong, tongTien));
                }
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Nhập Phiếu Nhập");
        } 
        finally{
            DBNhapKhoSach.closeConnection();
        }
        return arrNhapKho;
    }
    
    public ArrayList<QLPhieuNhapDTO> readDB_temp(){
        DBNhapKhoSach = new DBConnection();
        ArrayList<QLPhieuNhapDTO> arrNhapKho = new ArrayList<>();
        
        try{
            String query = "SELECT * FROM PhieuNhap";
            ResultSet rs = DBNhapKhoSach.SQLQuery(query);
            
            if (rs != null){
                while (rs.next()){
                    String maNhap = rs.getString("maNhap");
                    String ngayNhap = rs.getString("ngayNhap");                    
                    ArrayList <String> maSach = new ArrayList <String> ();
                    ArrayList <Integer> soLuong = new ArrayList <Integer> ();
                    String maNhanVien = rs.getString("maNhanVien");
                    String maNCC = rs.getString("maNCC");
                    int tongSoLuong = rs.getInt("tongSoLuong");
                    int tongTien = rs.getInt("tongTien");
                    
                    String query_chiTietPhieuNhap = "SELECT * FROM chiTietPhieuNhap WHERE ChiTietPhieuNhap.maNhap = '"  + maNhap + "'";
                    ResultSet rs_chiTietPhieuNhap = DBNhapKhoSach.SQLQuery(query_chiTietPhieuNhap);
                    if (rs_chiTietPhieuNhap != null){
                        while (rs_chiTietPhieuNhap.next()){
                            maSach.add(rs_chiTietPhieuNhap.getString("maSach"));
                            soLuong.add(rs_chiTietPhieuNhap.getInt("soLuong"));
                        }
                    }
                    
                    arrNhapKho.add(new QLPhieuNhapDTO(maNhap, ngayNhap, maSach, soLuong, maNhanVien, maNCC, tongSoLuong, tongTien));
                }
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi!!! Lỗi đọc dữ liệu bảng Nhập Phiếu Nhập");
        } 
        finally{
            DBNhapKhoSach.closeConnection();
        }
        return arrNhapKho;
    }
    
    public Boolean add(QLPhieuNhapDTO nhapKho){
        DBNhapKhoSach = new DBConnection();
        Boolean check1 = DBNhapKhoSach.SQLUpdate("INSERT INTO PhieuNhap(maNhap, ngayNhap, maNhanVien, maNCC, tongSoLuong, tongTien) "
                + "VALUES ('"
                + nhapKho.getMaNhap()+ "','"
                + nhapKho.getNgayNhap()+ "','"
                + nhapKho.getMaNhanVien()+ "','"     
                + nhapKho.getMaNCC()+ "',"     
                + nhapKho.getTongSoLuong()+ ","     
                + nhapKho.getTongTien()+ ");");      
        
        Boolean check2 = true;
        for (int i=0; i<nhapKho.getMaSach().size(); i++){
            Boolean check = DBNhapKhoSach.SQLUpdate("INSERT INTO ChiTietPhieuNhap(maNhap, maSach, soLuong) "
                    + "VALUES ('"
                    + nhapKho.getMaNhap()+ "','"     
                    + nhapKho.getMaSach().get(i)+ "',"   
                    + nhapKho.getSoLuong().get(i)+ ");");
            if (!check){
                check2 = check;
            }
        }
        
        /** Cập Nhập Kho Sách **/
//        Boolean check3 = true;
//        QLKhoSachBUS khoSach = new QLKhoSachBUS(0);
//        for (int i=0; i<nhapKho.getMaSach().size(); i++){
//            String maSach = nhapKho.getMaSach().get(i);
//            int soLuong = nhapKho.getSoLuong().get(i);
//            if (khoSach.getKhoSach(maSach) == null){    // Nếu mã sách chưa có trong kho
//                check3 = DBNhapKhoSach.SQLUpdate("INSERT INTO `khosach`(`maSach`, `soLuong`) VALUES ('" + maSach + "'," + soLuong + ");");
//            }
//            else{                                       // Nếu mã sách có trong kho
//                check3 = DBNhapKhoSach.SQLUpdate("UPDATE `khosach` SET `soLuong`=`soLuong` + " + soLuong + " WHERE `maSach` = '" + maSach + "'");
//            }
//        }
        
        DBNhapKhoSach.closeConnection();
        return check1 && check2 && new QLKhoSachDAO().refreshDB();
    }
    
    public Boolean add(String maNhap, String ngayNhap, ArrayList <String> maSach, ArrayList <Integer> soLuong, String maNhanVien, String maNCC, int tongSoLuong, int tongTien){
        DBNhapKhoSach = new DBConnection();
        Boolean check1 = DBNhapKhoSach.SQLUpdate("INSERT INTO PhieuNhap(maNhap, ngayNhap, maNhanVien, maNCC, tongSoLuong, tongTien) "
                + "VALUES ('"
                + maNhap+ "','"
                + ngayNhap+ "','" 
                + maNhanVien+ "','"     
                + maNCC+ "',"     
                + tongSoLuong+ ","     
                + tongTien+ ");");
        
        Boolean check2 = true;
        for (int i=0; i<maSach.size(); i++){
            Boolean check = DBNhapKhoSach.SQLUpdate("INSERT INTO ChiTietPhieuNhap(maNhap, maSach, soLuong) "
                    + "VALUES ('"
                    + maNhap+ "','"     
                    + maSach.get(i)+ "',"   
                    + soLuong.get(i)+ ");");
            if (!check){
                check2 = check;
            }
        }
        
//        /** Cập Nhập Kho Sách **/
//        Boolean check3 = true;
//        QLKhoSachBUS khoSach = new QLKhoSachBUS(0);
//        for (int i=0; i<maSach.size(); i++){
//            String maSach_e = maSach.get(i);
//            int soLuong_e = soLuong.get(i);
//            if (khoSach.getKhoSach(maSach_e) == null){    // Nếu mã sách chưa có trong kho
//                check3 = DBNhapKhoSach.SQLUpdate("INSERT INTO `khosach`(`maSach`, `soLuong`) VALUES ('" + maSach_e + "'," + soLuong_e + ");");
//            }
//            else{                                       // Nếu mã sách có trong kho
//                check3 = DBNhapKhoSach.SQLUpdate("UPDATE `khosach` SET `soLuong`=`soLuong` + " + soLuong_e + " WHERE `maSach` = '" + maSach_e + "'");
//            }
//        }
        DBNhapKhoSach.closeConnection();
        return check1 && check2 && new QLKhoSachDAO().refreshDB();
    }
    
    public Boolean del(String maNhap){
        DBNhapKhoSach = new DBConnection();
        Boolean check1 = DBNhapKhoSach.SQLUpdate("DELETE FROM PhieuNhap WHERE PhieuNhap.maNhap = '" + maNhap + "';");
        Boolean check2 = DBNhapKhoSach.SQLUpdate("DELETE FROM ChiTietPhieuNhap WHERE ChiTietPhieuNhap.maNhap = '" + maNhap + "';");
        DBNhapKhoSach.closeConnection();
        return check1 && check2 && new QLKhoSachDAO().refreshDB();
    }
    
    public Boolean mod(QLPhieuNhapDTO nhapKho){
        DBNhapKhoSach = new DBConnection();
        Boolean check1 = DBNhapKhoSach.SQLUpdate("Update PhieuNhap Set "
                + " ngayNhap='" + nhapKho.getNgayNhap()
                + " maNhanVien='" + nhapKho.getMaNhanVien()
                + " maNCC='" + nhapKho.getMaNCC()
                + " tongSoLuong='" + nhapKho.getTongSoLuong()
                + " tongTien='" + nhapKho.getTongTien()
                + "' where maNhap='" + nhapKho.getMaNhap()+ "';");
        
        Boolean check2 = DBNhapKhoSach.SQLUpdate("DELETE FROM ChiTietPhieuNhap WHERE ChiTietPhieuNhap.maNhap = '" + nhapKho.getMaNhap() + "';");
        for (int i=0; i<nhapKho.getMaSach().size(); i++){
            Boolean check = DBNhapKhoSach.SQLUpdate("INSERT INTO ChiTietPhieuNhap(maNhap, maSach, soLuong) "
                    + "VALUES ('"
                    + nhapKho.getMaNhap()+ "','"     
                    + nhapKho.getMaSach().get(i)+ "',"   
                    + nhapKho.getSoLuong().get(i)+ ");");
            if (!check){
                check2 = false;
            }
        }
        DBNhapKhoSach.closeConnection();
        return check1 && check2 && new QLKhoSachDAO().refreshDB();
    }
    
    public Boolean mod(String maNhap, String ngayNhap, ArrayList <String> maSach, ArrayList <Integer> soLuong, String maNhanVien, String maNCC, int tongSoLuong, int tongTien){
        DBNhapKhoSach = new DBConnection();
        Boolean check1 = DBNhapKhoSach.SQLUpdate("Update PhieuNhap Set "
                + " ngayNhap='" + ngayNhap
                + " maNhanVien='" + maNhanVien
                + " maNCC='" + maNCC
                + " tongSoLuong='" + tongSoLuong
                + " tongTien='" + tongTien
                + "' where maNhap='" + maNhap+ "';");
        
        Boolean check2 = DBNhapKhoSach.SQLUpdate("DELETE FROM ChiTietPhieuNhap WHERE ChiTietPhieuNhap.maNhap = '" + maNhap + "';");
        for (int i=0; i<maSach.size(); i++){
            Boolean check = DBNhapKhoSach.SQLUpdate("INSERT INTO ChiTietPhieuNhap(maNhap, maSach, soLuong) "
                    + "VALUES ('"
                    + maNhap+ "','"     
                    + maSach.get(i)+ "',"   
                    + soLuong.get(i)+ ");");
            if (!check){
                check2 = check;
            }
        }
        DBNhapKhoSach.closeConnection();
        return check1 && check2 && new QLKhoSachDAO().refreshDB();
    }
}

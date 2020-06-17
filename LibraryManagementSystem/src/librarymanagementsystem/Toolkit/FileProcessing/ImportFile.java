package librarymanagementsystem.Toolkit.FileProcessing;

import librarymanagementsystem.DTO.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.awt.FileDialog;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

public class ImportFile {
    FileDialog fx = new FileDialog(new JFrame(), "Đọc file Excel", FileDialog.LOAD);
    
    private String getFile() {
        fx.setFile("*.xls");
        fx.setVisible(true);
        String url = fx.getDirectory() + fx.getFile();
        if (url.equals("nullnull")) {
            return null;
        }
        return url;
    }
    
    public ArrayList<QLLoaiSachDTO> readFileExcel_QLSach(){
        String url = getFile();
        if (url == null){
            System.out.println("Lỗi Read File Excel");
        }
        
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputFile);
            HSSFSheet sheet = workbook.getSheetAt(0); // Mặc định data ở sheet 0
            Iterator<Row> rowIterator = sheet.iterator();
            Row rowfirst = rowIterator.next();
            
            ArrayList <QLLoaiSachDTO> arrSach = new ArrayList <QLLoaiSachDTO>();
            
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                
                while (cellIterator.hasNext()){

                    String maSach = cellIterator.next().getStringCellValue();
                    String tenSach = cellIterator.next().getStringCellValue();
                    String tenTacGia = cellIterator.next().getStringCellValue();
                    String tenNXB = cellIterator.next().getStringCellValue();
                    int namXB = (int) cellIterator.next().getNumericCellValue();
                    String theLoai = cellIterator.next().getStringCellValue();
                    String ngonNgu = cellIterator.next().getStringCellValue();
                    String tomTatNoiDung = cellIterator.next().getStringCellValue();
                    int giaTien = (int) cellIterator.next().getNumericCellValue();
                    int soTrang = (int) cellIterator.next().getNumericCellValue();
                    String hinh = cellIterator.next().getStringCellValue();
                    
                    arrSach.add(new QLLoaiSachDTO(maSach, tenSach, tenTacGia, tenNXB, theLoai, ngonNgu, tomTatNoiDung, namXB, giaTien, soTrang, hinh));
                }
            }
            return arrSach;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
            return null;
        } 
        finally{
            try{
                if (inputFile != null) {
                    inputFile.close();
                }
            }
            catch (IOException ex){
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng file: " + ex.getMessage());
            }
        }
    }
    
    public ArrayList<QLTheDTO> readFileExcel_QLThe(){
        String url = getFile();
        if (url == null){
            System.out.println("Lỗi Read File Excel");
        }
        
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputFile);
            HSSFSheet sheet = workbook.getSheetAt(0); // Mặc định data ở sheet 0
            Iterator<Row> rowIterator = sheet.iterator();
            Row rowfirst = rowIterator.next();
            
            ArrayList <QLTheDTO> arrThe = new ArrayList <QLTheDTO>();
            
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()){

                    String maThe = cellIterator.next().getStringCellValue();
                    String maKhachHang = cellIterator.next().getStringCellValue();
                    String ngayCap = cellIterator.next().getStringCellValue();
                    String ngayHetHan = cellIterator.next().getStringCellValue();
                    
                    arrThe.add(new QLTheDTO(maThe, maKhachHang, ngayCap, ngayHetHan));
                }
            }
            return arrThe;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
            return null;
        } 
        finally{
            try{
                if (inputFile != null) {
                    inputFile.close();
                }
            }
            catch (IOException ex){
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng file: " + ex.getMessage());
            }
        }
    }
    
    /*public ArrayList<QLTheDTO> readFileExcel_QLThe_Full(){
        String url = getFile();
        if (url == null){
            System.out.println("Lỗi Read File Excel");
        }
        
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputFile);
            HSSFSheet sheet = workbook.getSheetAt(0); // Mặc định data ở sheet 0
            Iterator<Row> rowIterator = sheet.iterator();
            //Row rowfirst = rowIterator.next();
            
            ArrayList <QLTheDTO> arrThe = new ArrayList <QLTheDTO>();
            
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()){

                    String maThe = cellIterator.next().getStringCellValue();
                    String maKhachHang = cellIterator.next().getStringCellValue();
                    String ngayCap = cellIterator.next().getStringCellValue();
                    String ngayHetHan = cellIterator.next().getStringCellValue();
                    String hoTen = cellIterator.next().getStringCellValue();
                    String ngaySinh = cellIterator.next().getStringCellValue();
                    String diaChi = cellIterator.next().getStringCellValue();
                    String email = cellIterator.next().getStringCellValue();
                    String sdt = cellIterator.next().getStringCellValue();
                    
                    QLKhachHangDTO khachHang = new QLKhachHangDTO(maKhachHang, hoTen, ngaySinh, diaChi, email, maThe, sdt);
                    arrThe.add(new QLTheDTO(maThe, maKhachHang, ngayCap, ngayHetHan, khachHang));
                }
            }
            return arrThe;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
            return null;
        } 
        finally{
            try{
                if (inputFile != null) {
                    inputFile.close();
                }
            }
            catch (IOException ex){
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng file: " + ex.getMessage());
            }
        }
    }*/
    
    public ArrayList<QLNhanVienDTO> readFileExcel_QLNhanVien(){
        String url = getFile();
        if (url == null){
            System.out.println("Lỗi Read File Excel");
        }
        
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputFile);
            HSSFSheet sheet = workbook.getSheetAt(0); // Mặc định data ở sheet 0
            Iterator<Row> rowIterator = sheet.iterator();
            //Row rowfirst = rowIterator.next();
            
            ArrayList <QLNhanVienDTO> arrNhanVien = new ArrayList <QLNhanVienDTO>();
            
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()){

                    String maNhanVien = cellIterator.next().getStringCellValue();
                    String password = cellIterator.next().getStringCellValue();
                    String hoTen = cellIterator.next().getStringCellValue();
                    String ngaySinh = cellIterator.next().getStringCellValue();
                    String diaChi = cellIterator.next().getStringCellValue();
                    String email = cellIterator.next().getStringCellValue();
                    String chucVu = cellIterator.next().getStringCellValue();
                    String sdt = cellIterator.next().getStringCellValue();
                    
                    arrNhanVien.add(new QLNhanVienDTO(maNhanVien, password, hoTen, ngaySinh, diaChi, email, chucVu, sdt));
                }
            }
            return arrNhanVien;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
            return null;
        } 
        finally{
            try{
                if (inputFile != null) {
                    inputFile.close();
                }
            }
            catch (IOException ex){
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng file: " + ex.getMessage());
            }
        }
    }
    
    public ArrayList<QLKhachHangDTO> readFileExcel_QLKhachHang(){
        String url = getFile();
        if (url == null){
            System.out.println("Lỗi Read File Excel");
        }
        
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputFile);
            HSSFSheet sheet = workbook.getSheetAt(0); // Mặc định data ở sheet 0
            Iterator<Row> rowIterator = sheet.iterator();
            //Row rowfirst = rowIterator.next();
            
            ArrayList <QLKhachHangDTO> arrKhachHang = new ArrayList <QLKhachHangDTO>();
            
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()){

                    String maKhachHang = cellIterator.next().getStringCellValue();
                    String hoTen = cellIterator.next().getStringCellValue();
                    String ngaySinh = cellIterator.next().getStringCellValue();
                    String diaChi = cellIterator.next().getStringCellValue();
                    String email = cellIterator.next().getStringCellValue();
                    String sdt = cellIterator.next().getStringCellValue();
                    
                    arrKhachHang.add(new QLKhachHangDTO(maKhachHang, hoTen, ngaySinh, diaChi, email, sdt));
                }
            }
            return arrKhachHang;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
            return null;
        } 
        finally{
            try{
                if (inputFile != null) {
                    inputFile.close();
                }
            }
            catch (IOException ex){
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng file: " + ex.getMessage());
            }
        }
    }
    
    public ArrayList<QLNhaCungCapDTO> readFileExcel_QLNhaCungCap(){
        String url = getFile();
        if (url == null){
            System.out.println("Lỗi Read File Excel");
        }
        
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputFile);
            HSSFSheet sheet = workbook.getSheetAt(0); // Mặc định data ở sheet 0
            Iterator<Row> rowIterator = sheet.iterator();
            //Row rowfirst = rowIterator.next();
            
            ArrayList <QLNhaCungCapDTO> arrNhaCungCap = new ArrayList <QLNhaCungCapDTO>();
            
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()){

                    String maNCC = cellIterator.next().getStringCellValue();
                    String tenNCC = cellIterator.next().getStringCellValue();
                    String sdt = cellIterator.next().getStringCellValue();
                    String email = cellIterator.next().getStringCellValue();
                    String diaChi = cellIterator.next().getStringCellValue();
                    
                    arrNhaCungCap.add(new QLNhaCungCapDTO(maNCC, tenNCC, sdt, email, diaChi));
                }
            }
            return arrNhaCungCap;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
            return null;
        } 
        finally{
            try{
                if (inputFile != null) {
                    inputFile.close();
                }
            }
            catch (IOException ex){
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng file: " + ex.getMessage());
            }
        }
    }
    
    public ArrayList<QLPhieuMuonDTO> readFileExcel_QLPhieuMuon(){
        String url = getFile();
        if (url == null){
            System.out.println("Lỗi Read File Excel");
        }
        
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputFile);
            HSSFSheet sheet = workbook.getSheetAt(0); // Mặc định data ở sheet 0
            Iterator<Row> rowIterator = sheet.iterator();
            //Row rowfirst = rowIterator.next();
            
            ArrayList <QLPhieuMuonDTO> arrPhieuMuon = new ArrayList <QLPhieuMuonDTO>();
            
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()){

                    String maMuonSach = cellIterator.next().getStringCellValue();
                    String maThe = cellIterator.next().getStringCellValue();
                    //String IDSach = cellIterator.next().getStringCellValue(); bugs
                    String ngayMuon = cellIterator.next().getStringCellValue();
                    int thoiGianMuon = (int) cellIterator.next().getNumericCellValue();
                    String ngayTra = cellIterator.next().getStringCellValue();
                    
                    //arrPhieuMuon.add(new QLPhieuMuonDTO(maMuonSach, maThe, IDSach, ngayMuon, thoiGianMuon, ngayTra));
                }
            }
            return arrPhieuMuon;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
            return null;
        } 
        finally{
            try{
                if (inputFile != null) {
                    inputFile.close();
                }
            }
            catch (IOException ex){
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng file: " + ex.getMessage());
            }
        }
    }
    
    public ArrayList<QLKhoSachDTO> readFileExcel_QLKhoSach(){
        String url = getFile();
        if (url == null){
            System.out.println("Lỗi Read File Excel");
        }
        
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputFile);
            HSSFSheet sheet = workbook.getSheetAt(0); // Mặc định data ở sheet 0
            Iterator<Row> rowIterator = sheet.iterator();
            //Row rowfirst = rowIterator.next();
            
            ArrayList <QLKhoSachDTO> arrKhoSach = new ArrayList <QLKhoSachDTO>();
            
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()){

                    String maSach = cellIterator.next().getStringCellValue();
                    int soLuong = (int) cellIterator.next().getNumericCellValue();
                    
                    arrKhoSach.add(new QLKhoSachDTO(maSach, soLuong));
                }
            }
            return arrKhoSach;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
            return null;
        } 
        finally{
            try{
                if (inputFile != null) {
                    inputFile.close();
                }
            }
            catch (IOException ex){
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng file: " + ex.getMessage());
            }
        }
    }
    
    /*public ArrayList<QLKhoSachDTO> readFileExcel_QLKhoSach_Full(){
        String url = getFile();
        if (url == null){
            System.out.println("Lỗi Read File Excel");
        }
        
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputFile);
            HSSFSheet sheet = workbook.getSheetAt(0); // Mặc định data ở sheet 0
            Iterator<Row> rowIterator = sheet.iterator();
            //Row rowfirst = rowIterator.next();
            
            ArrayList <QLKhoSachDTO> arrKhoSach = new ArrayList <QLKhoSachDTO>();
            
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()){

                    String maSach = cellIterator.next().getStringCellValue();
                    int soLuong = (int) cellIterator.next().getNumericCellValue();
                    String tenSach = cellIterator.next().getStringCellValue();
                    String tenTacGia = cellIterator.next().getStringCellValue();
                    String tenNXB = cellIterator.next().getStringCellValue();
                    String theLoai = cellIterator.next().getStringCellValue();
                    String ngonNgu = cellIterator.next().getStringCellValue();
                    String tomTatNoiDung = cellIterator.next().getStringCellValue();
                    int namXB = (int) cellIterator.next().getNumericCellValue();
                    int giaTien = (int) cellIterator.next().getNumericCellValue();
                    int soTrang = (int) cellIterator.next().getNumericCellValue();
                    String hinh = cellIterator.next().getStringCellValue();
                    
                    QLLoaiSachDTO sach = new QLLoaiSachDTO(maSach, tenSach, tenTacGia, tenNXB, theLoai, ngonNgu, tomTatNoiDung, namXB, giaTien, soTrang, hinh);
                    arrKhoSach.add(new QLKhoSachDTO(maSach, soLuong, sach));
                }
            }
            return arrKhoSach;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
            return null;
        } 
        finally{
            try{
                if (inputFile != null) {
                    inputFile.close();
                }
            }
            catch (IOException ex){
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng file: " + ex.getMessage());
            }
        }
    }*/
    
    public ArrayList<QLChiTietSachDTO> readFileExcel_QLChiTietSach(){
        String url = getFile();
        if (url == null){
            System.out.println("Lỗi Read File Excel");
        }
        
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputFile);
            HSSFSheet sheet = workbook.getSheetAt(0); // Mặc định data ở sheet 0
            Iterator<Row> rowIterator = sheet.iterator();
            //Row rowfirst = rowIterator.next();
            
            ArrayList <QLChiTietSachDTO> arrChiTietSach = new ArrayList <QLChiTietSachDTO>();
            
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()){

                    String IDSach = cellIterator.next().getStringCellValue();
                    String maSach = cellIterator.next().getStringCellValue();
                    String tinhTrang = cellIterator.next().getStringCellValue();
                    
                    arrChiTietSach.add(new QLChiTietSachDTO(IDSach, maSach, tinhTrang));
                }
            }
            return arrChiTietSach;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
            return null;
        } 
        finally{
            try{
                if (inputFile != null) {
                    inputFile.close();
                }
            }
            catch (IOException ex){
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng file: " + ex.getMessage());
            }
        }
    }
    
    /*public ArrayList<QLChiTietSachDTO> readFileExcel_QLChiTietSach_Full(){
        String url = getFile();
        if (url == null){
            System.out.println("Lỗi Read File Excel");
        }
        
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputFile);
            HSSFSheet sheet = workbook.getSheetAt(0); // Mặc định data ở sheet 0
            Iterator<Row> rowIterator = sheet.iterator();
            //Row rowfirst = rowIterator.next();
            
            ArrayList <QLChiTietSachDTO> arrChiTietSach = new ArrayList <QLChiTietSachDTO>();
            
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()){

                    String IDSach = cellIterator.next().getStringCellValue();
                    String maSach = cellIterator.next().getStringCellValue();
                    String tinhTrang = cellIterator.next().getStringCellValue();
                    String tenSach = cellIterator.next().getStringCellValue();
                    String tenTacGia = cellIterator.next().getStringCellValue();
                    String tenNXB = cellIterator.next().getStringCellValue();
                    String theLoai = cellIterator.next().getStringCellValue();
                    String ngonNgu = cellIterator.next().getStringCellValue();
                    String tomTatNoiDung = cellIterator.next().getStringCellValue();
                    int namXB = (int) cellIterator.next().getNumericCellValue();
                    int giaTien = (int) cellIterator.next().getNumericCellValue();
                    int soTrang = (int) cellIterator.next().getNumericCellValue();
                    String hinh = cellIterator.next().getStringCellValue();
                    
                    QLLoaiSachDTO sach = new QLLoaiSachDTO(maSach, tenSach, tenTacGia, tenNXB, theLoai, ngonNgu, tomTatNoiDung, namXB, giaTien, soTrang, hinh);
                    arrChiTietSach.add(new QLChiTietSachDTO(IDSach, maSach, tinhTrang, sach));
                }
            }
            return arrChiTietSach;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
            return null;
        } 
        finally{
            try{
                if (inputFile != null) {
                    inputFile.close();
                }
            }
            catch (IOException ex){
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng file: " + ex.getMessage());
            }
        }
    }*/
    
    public ArrayList<QLAdminDTO> readFileExcel_QLAdmin(){
        String url = getFile();
        if (url == null){
            System.out.println("Lỗi Read File Excel");
        }
        
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputFile);
            HSSFSheet sheet = workbook.getSheetAt(0); // Mặc định data ở sheet 0
            Iterator<Row> rowIterator = sheet.iterator();
            //Row rowfirst = rowIterator.next();
            
            ArrayList <QLAdminDTO> arrAdmin = new ArrayList <QLAdminDTO>();
            
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()){

                    String tkAdmin = cellIterator.next().getStringCellValue();
                    String password = cellIterator.next().getStringCellValue();
                    
                    arrAdmin.add(new QLAdminDTO(tkAdmin, password));
                }
            }
            return arrAdmin;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
            return null;
        } 
        finally{
            try{
                if (inputFile != null) {
                    inputFile.close();
                }
            }
            catch (IOException ex){
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng file: " + ex.getMessage());
            }
        }
    }
    
    public ArrayList<QLPhieuXuatDTO> readFileExcel_QLXuatKhoSach(){
        String url = getFile();
        if (url == null){
            System.out.println("Lỗi Read File Excel");
        }
        
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputFile);
            HSSFSheet sheet = workbook.getSheetAt(0); // Mặc định data ở sheet 0
            Iterator<Row> rowIterator = sheet.iterator();
            //Row rowfirst = rowIterator.next();
            
            ArrayList <QLPhieuXuatDTO> arrXuatKhoSach = new ArrayList <QLPhieuXuatDTO>();
            
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()){

                    String maXuat = cellIterator.next().getStringCellValue();
                    String ngayXuat = cellIterator.next().getStringCellValue();
                    
                    ArrayList <String> maSach = new ArrayList<>();
                    ArrayList <Integer> soLuong = new ArrayList<>();
                    
                    ArrayList <String> maSachTemp = new ArrayList<>();
                    ArrayList <Integer> soLuongTemp = new ArrayList<>();
                    
                    HashMap < String, Integer> hmVT_Str = new HashMap < String, Integer>();
                    HashMap < Integer, Integer> hmVT_Int = new HashMap < Integer, Integer>();
                    HashMap < ArrayList <String>, String> hmStr = new HashMap < ArrayList <String>, String> ();
                    HashMap < ArrayList <Integer>, Integer> hmInt = new HashMap < ArrayList <Integer>, Integer>();
                    
                    for (int i=0; i<maSachTemp.size(); i++){
                        hmVT_Str.put(maSachTemp.get(i), 1);
                    }
                    for (ArrayList<String> e : hmStr.keySet()) {
                        maSachTemp=e;
                        for(int i=0; i<maSachTemp.size() && maSachTemp.get(i).equals(e); i++){
                            String _maSach = cellIterator.next().getStringCellValue();
                            hmStr.put(maSachTemp,_maSach);
                            maSach.add(hmStr.get(maSachTemp));
                        }
                    }
                    
                    for (int i=0; i<soLuongTemp.size(); i++){
                        hmVT_Int.put(soLuongTemp.get(i), 1);
                    }
                    for (ArrayList<Integer> e : hmInt.keySet()) {
                        soLuongTemp=e;
                        for(int i=0; i<soLuongTemp.size() && soLuongTemp.get(i).equals(e); i++){
                            int _soLuong = (int) cellIterator.next().getNumericCellValue();
                            hmInt.put(soLuongTemp,_soLuong);
                            soLuong.add(hmInt.get(soLuongTemp));
                        }
                    }
                    arrXuatKhoSach.add(new QLPhieuXuatDTO(maXuat, ngayXuat, maSach, soLuong));
                }
            }
            return arrXuatKhoSach;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
            return null;
        } 
        finally{
            try{
                if (inputFile != null) {
                    inputFile.close();
                }
            }
            catch (IOException ex){
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng file: " + ex.getMessage());
            }
        }
    }
    
    public ArrayList<QLPhieuNhapDTO> readFileExcel_QLNhapKhoSach(){
        String url = getFile();
        if (url == null){
            System.out.println("Lỗi Read File Excel");
        }
        
        FileInputStream inputFile = null;
        try {
            inputFile = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputFile);
            HSSFSheet sheet = workbook.getSheetAt(0); // Mặc định data ở sheet 0
            Iterator<Row> rowIterator = sheet.iterator();
            //Row rowfirst = rowIterator.next();
            
            ArrayList <QLPhieuNhapDTO> arrNhapKhoSach = new ArrayList <QLPhieuNhapDTO>();
            
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()){

                    String maNhap = cellIterator.next().getStringCellValue();
                    String ngayNhap = cellIterator.next().getStringCellValue();
                    
                    ArrayList <String> maSach = new ArrayList<>();
                    ArrayList <Integer> soLuong = new ArrayList<>();
                    
                    ArrayList <String> maSachTemp = new ArrayList<>();
                    ArrayList <Integer> soLuongTemp = new ArrayList<>();
                    
                    HashMap < String, Integer> hmVT_Str = new HashMap < String, Integer>();
                    HashMap < Integer, Integer> hmVT_Int = new HashMap < Integer, Integer>();
                    HashMap < ArrayList <String>, String> hmStr = new HashMap < ArrayList <String>, String> ();
                    HashMap < ArrayList <Integer>, Integer> hmInt = new HashMap < ArrayList <Integer>, Integer>();
                    
                    for (int i=0; i<maSachTemp.size(); i++){
                        hmVT_Str.put(maSachTemp.get(i), 1);
                    }
                    for (ArrayList<String> e : hmStr.keySet()) {
                        maSachTemp=e;
                        for(int i=0; i<maSachTemp.size() && maSachTemp.get(i).equals(e); i++){
                            String _maSach = cellIterator.next().getStringCellValue();
                            hmStr.put(maSachTemp,_maSach);
                            maSach.add(hmStr.get(maSachTemp));
                        }
                    }
                    
                    for (int i=0; i<soLuongTemp.size(); i++){
                        hmVT_Int.put(soLuongTemp.get(i), 1);
                    }
                    for (ArrayList<Integer> e : hmInt.keySet()) {
                        soLuongTemp=e;
                        for(int i=0; i<soLuongTemp.size() && soLuongTemp.get(i).equals(e); i++){
                            int _soLuong = (int) cellIterator.next().getNumericCellValue();
                            hmInt.put(soLuongTemp,_soLuong);
                            soLuong.add(hmInt.get(soLuongTemp));
                        }
                    }
                    arrNhapKhoSach.add(new QLPhieuNhapDTO(maNhap, ngayNhap, maSach, soLuong));
                }
            }
            return arrNhapKhoSach;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
            return null;
        } 
        finally{
            try{
                if (inputFile != null) {
                    inputFile.close();
                }
            }
            catch (IOException ex){
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng file: " + ex.getMessage());
            }
        }
    }
    
    public static void main(String[] args){
        new ImportFile().readFileExcel_QLSach();
    }
}

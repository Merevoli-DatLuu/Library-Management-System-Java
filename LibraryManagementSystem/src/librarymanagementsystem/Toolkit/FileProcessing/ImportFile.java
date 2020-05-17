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
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

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
    
    public ArrayList<QLSachDTO> readFileExcel_QLSach(){
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
            
            ArrayList <QLSachDTO> arrSach = new ArrayList <QLSachDTO>();
            
            while (rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()){

                    String maSach = cellIterator.next().getStringCellValue();
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
                    
                    arrSach.add(new QLSachDTO(maSach, tenSach, tenTacGia, tenNXB, theLoai, ngonNgu, tomTatNoiDung, namXB, giaTien, soTrang, hinh));
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
}

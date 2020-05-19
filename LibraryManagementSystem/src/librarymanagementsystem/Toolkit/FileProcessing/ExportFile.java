package librarymanagementsystem.Toolkit.FileProcessing;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import librarymanagementsystem.BUS.*;
import librarymanagementsystem.DTO.*;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class ExportFile {
    FileDialog fx = new FileDialog(new JFrame(), "Đọc file Excel", FileDialog.SAVE);
    
    public String WriteFile(){
        fx.setFilenameFilter(new FilenameFilter(){
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".xls");
            }
        });
        fx.setFile("untitled.xls");
        fx.setVisible(true);
        String url = fx.getDirectory() + fx.getFile();
        if (url.equals("nullnull")) {
            return null;
        }
        return url;
    }
    
    public void writeFileExcel_QLLoaiSach() {
        fx.setTitle("Xuất dữ liệu Loại Sách -> excel");
        String url = WriteFile();
        if (url == null) {
            return;
        }
        
        //System.out.println(url);

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Loại Sách");

            QLLoaiSachBUS qlnccBUS = new QLLoaiSachBUS();
            ArrayList<QLLoaiSachDTO> list = qlnccBUS.getArrSach();
            //qlnccBUS.show();
            int rownum = 1;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.STRING).setCellValue("Mã Sách");
            row.createCell(1, CellType.STRING).setCellValue("Tên Sách");
            row.createCell(2, CellType.STRING).setCellValue("Tên Tác Giả");
            row.createCell(3, CellType.STRING).setCellValue("Tên NXB");
            row.createCell(4, CellType.STRING).setCellValue("Năm XB");
            row.createCell(5, CellType.STRING).setCellValue("Thể Loại");
            row.createCell(6, CellType.STRING).setCellValue("Ngôn Ngữ");
            row.createCell(7, CellType.STRING).setCellValue("Tóm Tắt Nội Dung");
            row.createCell(8, CellType.NUMERIC).setCellValue("Giá Tiền");
            row.createCell(9, CellType.NUMERIC).setCellValue("Số Trang");
            row.createCell(10, CellType.STRING).setCellValue("Hình Sách");
            
            for (QLLoaiSachDTO sach : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.STRING).setCellValue(sach.getMaSach());
                row.createCell(1, CellType.STRING).setCellValue(sach.getTenSach());
                row.createCell(2, CellType.STRING).setCellValue(sach.getTenTacGia());
                row.createCell(3, CellType.STRING).setCellValue(sach.getTenNXB());
                row.createCell(4, CellType.STRING).setCellValue(sach.getNamXB());
                row.createCell(5, CellType.STRING).setCellValue(sach.getTheLoai());
                row.createCell(6, CellType.STRING).setCellValue(sach.getNgonNgu());
                row.createCell(7, CellType.STRING).setCellValue(sach.getTomTatNoiDung());
                row.createCell(8, CellType.NUMERIC).setCellValue(sach.getGiaTien());
                row.createCell(9, CellType.NUMERIC).setCellValue(sach.getSoTrang());
                row.createCell(10, CellType.STRING).setCellValue(sach.getHinh());
            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }
            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile); //bug here :((
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExportFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExportFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ExportFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    public static void main(String[] args){
        new ExportFile().writeFileExcel_QLLoaiSach();
    }
}

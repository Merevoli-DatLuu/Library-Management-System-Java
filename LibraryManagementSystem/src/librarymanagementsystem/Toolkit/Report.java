
package librarymanagementsystem.Toolkit;

import java.awt.Color;
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
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import librarymanagementsystem.DAO.QLPhieuMuonDAO;
import librarymanagementsystem.Toolkit.FileProcessing.ExportFile;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Cell.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

public class Report {
    Color colorBorder=new Color(115, 87, 115);
    
    Color colorNgan=new Color(247, 222, 185);
    Color colorNoiDung=new Color(64, 64, 64);
    Color colorHeader=new Color(89, 89, 89);
    
    FileDialog fx = new FileDialog(new JFrame(), "Ghi file Excel", FileDialog.SAVE);
 
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
    
    private static void writeToSheet(HSSFSheet sheet, Map<Integer, Object[]> sheetData,
    HSSFCellStyle headerStyle, HSSFCellStyle border, HSSFCellStyle center, Integer type) {

        Set<Integer> keyIds = sheetData.keySet();
        Row row;
        int rowId = 2;

        for (Integer key : keyIds) {
            // Tạo row
            row = sheet.createRow(rowId++);
            row.setHeightInPoints(50);

            Object[] objectArr = sheetData.get(key);
            int cellId = 1;

            for (Object obj : objectArr) {
                // Tạo cell
                Cell cell = row.createCell(cellId++);
                
                if (rowId == 3) {
                    // Với header, set value dạng String
                    cell.setCellValue((String) obj);
                    // Set style cho header
                    cell.setCellStyle(headerStyle);
                } else {
                    // Các row khác
                    if (cellId == 1) {
                    // Với cột MSNV, set value dạng number
                    cell.setCellValue(Integer.valueOf((String) obj));
                    // Set center style
                    } else {
                        // Các cột khác
                        if (type == 2 && cellId == 2) {
                        // Trường hợp Ngày công thì dạng number
                        cell.setCellValue(Integer.valueOf((String) obj));
                       } else {
                            // Bình thường thì dạng String
                            cell.setCellValue((String) obj);
                        }
                    }
                }
            }
        }
    }    
    
    public static void main(String[] args) {
        //new Report().WriteFile(); 
        String url = "D:\\untitle.xls";
        if (url == null) {
            return;
        }
        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Thống Kê Phiếu Mượn");
            sheet.setDisplayGridlines(false);
            sheet.setColumnWidth(0, 600);
            sheet.setColumnWidth(1, 3000);
            sheet.setColumnWidth(2, 3200);
            sheet.setColumnWidth(3, 3200);
            sheet.setColumnWidth(4, 3500);
            sheet.setColumnWidth(5, 3500);
            sheet.setColumnWidth(6, 3500);
            sheet.setColumnWidth(7, 700);
            sheet.setGridsPrinted(false);
            sheet.setPrintGridlines(false);
            
            HSSFFont fontFamily = workbook.createFont();
            fontFamily.setFontName("Calibri");
            fontFamily.setColor(HSSFColor.HSSFColorPredefined.GREY_80_PERCENT.getIndex());
            
            HSSFCellStyle styleSheet= workbook.createCellStyle();
            styleSheet.setFont(fontFamily);
            
            HSSFFont fontTitle = workbook.createFont();
            fontTitle.setFontHeightInPoints((short) 30);
            fontTitle.setColor(HSSFColor.HSSFColorPredefined.VIOLET.getIndex());
//            HSSFColor color = new HSSFColor(0, -1, new Color(115, 87, 115));
//            fontTitle.setColor(color.getIndex());            
            
            HSSFCellStyle styleTitle= workbook.createCellStyle();
            styleTitle.cloneStyleFrom(styleSheet);
            styleTitle.setVerticalAlignment(VerticalAlignment.CENTER);
            styleTitle.setFont(fontTitle);
            styleTitle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
            //styleTitle.setFillPattern(CellStyle.SOLID_FOREGROUND); 
            
            Row row = sheet.createRow(0);
            
            Cell cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("THỐNG KÊ PHIẾU MƯỢN");
            cell.setCellStyle(styleTitle);
            row.setHeightInPoints(50);
            
            HSSFFont fontNote = workbook.createFont();
            fontNote.setColor(HSSFColor.HSSFColorPredefined.ORCHID.getIndex());
            fontNote.setItalic(true);
            
            HSSFCellStyle styleNote= workbook.createCellStyle();
            styleNote.cloneStyleFrom(styleSheet);
            styleNote.setVerticalAlignment(VerticalAlignment.CENTER);
            styleNote.setFont(fontNote);
            
            row = sheet.createRow(1);
            cell = row.createCell(1,CellType.STRING);
            cell.setCellValue("Bảng thống kê phiếu mượn của mỗi năm");
            cell.setCellStyle(styleNote);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 3));
            row.setHeightInPoints(20);
            sheet.addMergedRegion(new CellRangeAddress(2, 2, 8, 10));
            
            Map<Integer, Object[]> header = new TreeMap<Integer, Object[]>();
            header.put(1, new Object[]{"GIAI ĐOẠN", "SỐ PHIẾU MƯỢN", "TỔNG SỐ SÁCH MƯỢN", "SỐ SÁCH MƯỢN/ PHIẾU",
            "SỐ PHIẾU MƯỢN/ NGÀY", "TỈ LỆ GIA TĂNG", "", "SÁCH MƯỢN"});
            
            
            
            HSSFCellStyle border = workbook.createCellStyle();
            border.cloneStyleFrom(styleSheet);
            border.setBorderBottom(BorderStyle.THIN);
            //border.setBottomBorderColor();
            
            HSSFCellStyle borderTop = workbook.createCellStyle();
            borderTop.cloneStyleFrom(styleSheet);
            borderTop.setBorderTop(BorderStyle.THIN);
            
            HSSFCellStyle styleWrapText = workbook.createCellStyle();
            styleWrapText.setWrapText(true);

            HSSFFont fontHeader = workbook.createFont();
            fontHeader.setBold(true);
            fontHeader.setColor(HSSFColor.HSSFColorPredefined.GREY_80_PERCENT.getIndex());
            
            HSSFCellStyle headerStyle = workbook.createCellStyle(); 
            headerStyle.cloneStyleFrom(styleSheet);
            headerStyle.cloneStyleFrom(styleWrapText);
            headerStyle.setAlignment(HorizontalAlignment.CENTER);
            headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            //headerStyle.setFillForegroundColor();
            headerStyle.setFont(fontHeader);
            
            HSSFCellStyle center = workbook.createCellStyle();
            center.cloneStyleFrom(styleSheet);
            center.setAlignment(HorizontalAlignment.CENTER);
            center.setVerticalAlignment(VerticalAlignment.CENTER);
            
            HSSFCellStyle styleBold = workbook.createCellStyle();
            styleBold.cloneStyleFrom(styleSheet);
            styleBold.cloneStyleFrom(center);
            styleBold.setFont(fontHeader);
            
            HSSFCellStyle stylePercent = workbook.createCellStyle();
            styleBold.cloneStyleFrom(styleSheet);
            stylePercent.cloneStyleFrom(styleBold);
            stylePercent.setDataFormat(workbook.createDataFormat().getFormat("0%"));
            
            sheet.setDefaultColumnStyle(1, styleBold);
            sheet.setDefaultColumnStyle(6, styleBold);
            for(int i=0;i<100;i++){
                sheet.setDefaultColumnStyle(i, center);
            }
            
            writeToSheet(sheet, header, headerStyle, border, center, 1);
            
            HSSFCellStyle style = workbook.createCellStyle();
            //style.setFillBackgroundColor(IndexedColors.LAVENDER.getIndex());
            style.setFillPattern(FillPatternType.FINE_DOTS);
            
            
            int rownum, cellnum = 0;
            while(cellnum < 6){
                rownum = 2;  cellnum++;
                int rownext=rownum+1;
                sheet.addMergedRegion(new CellRangeAddress(rownum, rownext, cellnum, cellnum));
            }
            
            QLLoaiSachBUS maSachBUS = new QLLoaiSachBUS();
            ArrayList<String> list =maSachBUS.getPKey();
       
            cellnum=1;
            row = sheet.createRow(3);
            for(int i=0;i<7;i++){
                cell= row.createCell(cellnum);
                cell.setCellStyle(border);
                cellnum++;
            }
            
            cellnum=8;
            for (int i=0;i<list.size();i++) {
                cell = row.createCell(cellnum, CellType.STRING);
                cell.setCellValue(list.get(i));
                cell.setCellStyle(border);
                cellnum++;
            }
            
            cellnum=1;
            row = sheet.createRow(22);
            for (int i=0;i<31;i++) {
                cell = row.createCell(cellnum);
                cell.setCellStyle(borderTop);
                cellnum++;
            }
            
            rownum=3;  
            String [] thang2019 ={"01/2019", "02/2019", "03/2019", "04/2019", "05/2019", "06/2019", 
            "07/2019", "08/2019", "09/2019", "10/2019", "11/2019", "12/2019"};
            new QLPhieuMuonBUS();
            ArrayList <Integer> phieuMuon = new ArrayList<>();
            phieuMuon= new QLPhieuMuonBUS(0).getArrSoPhieuMuon(2019);
            
            ArrayList <Integer> sachMuon = new ArrayList<>();
            sachMuon= new QLPhieuMuonBUS(0).getArrSoLuongSachMuon(2019);
            
            ArrayList <Integer> sachMuon_2019 = new ArrayList<>();
            for(int i=0;i<12;i++){
                for(int j=0;j<list.size();j++){
                    sachMuon_2019.add(new QLPhieuMuonBUS(0).getSoLuongSachMuon_MaSach(list.get(j), i+1, 2019));
                }
            }
           
            for (int i=0;i<phieuMuon.size();i++) {
                rownum++;
                cellnum=7;
                row = sheet.createRow(rownum);
                row.setHeightInPoints(30);
                cell = row.createCell(7);
                cell.setCellStyle(style);
                row.createCell(1, CellType.STRING).setCellValue(thang2019[i]);
                row.createCell(2, CellType.STRING).setCellValue(phieuMuon.get(i));
                row.createCell(3, CellType.NUMERIC).setCellValue(sachMuon.get(i));
                row.createCell(4, CellType.FORMULA).setCellFormula("ROUND(D"+(i+5)+"/C"+(i+5)+", 0)");
                row.createCell(5, CellType.FORMULA).setCellFormula("ROUNDUP(C"+(i+5)+"/30, 0)");
                cell=row.createCell(6, CellType.FORMULA);
                cell.setCellFormula("(D"+(i+5)+"/D"+(i+4)+" "+" - 1)");
                cell.setCellStyle(stylePercent);
                sheet.getRow(4).getCell(6).setCellType(CellType.NUMERIC);
                sheet.getRow(4).getCell(6).setCellValue(0);
                sheet.getRow(4).getCell(6).setCellStyle(stylePercent);
                
                for(int j=i*list.size(); j<(i+1)*list.size(); j++){
                    cellnum++;
                    cell =row.createCell(cellnum);
                    cell.setCellValue(sachMuon_2019.get(j));
                }
            }
            
            rownum=15;
            String [] thang2020 ={"01/2020", "02/2020", "03/2020", "04/2020", "05/2020", "06/2020"};
            phieuMuon= new QLPhieuMuonBUS(0).getArrSoPhieuMuonNuaNam(2020);
            sachMuon= new QLPhieuMuonBUS(0).getArrSoLuongSachMuonNuaNam(2020);
            
            ArrayList <Integer> sachMuon_2020 = new ArrayList<>();
            for(int i=0;i<6;i++){
                for(int j=0;j<list.size();j++){
                    sachMuon_2020.add(new QLPhieuMuonBUS(0).getSoLuongSachMuon_MaSach(list.get(j), i+1, 2020));
                }
            }
            
            for (int i=0;i<phieuMuon.size();i++) {
                rownum++;
                cellnum=7;
                row = sheet.createRow(rownum);
                row.setHeightInPoints(30);
                cell = row.createCell(7);
                cell.setCellStyle(style);
                row.createCell(1, CellType.STRING).setCellValue(thang2020[i]);
                row.createCell(2, CellType.STRING).setCellValue(phieuMuon.get(i));
                row.createCell(3, CellType.NUMERIC).setCellValue(sachMuon.get(i));
                row.createCell(4, CellType.FORMULA).setCellFormula("ROUND(D"+(i+17)+"/C"+(i+17)+", 0)");
                row.createCell(5, CellType.FORMULA).setCellFormula("ROUNDUP(C"+(i+17)+"/30, 0)");
                cell=row.createCell(6, CellType.FORMULA);
                cell.setCellFormula("(D"+(i+17)+"/D"+(i+16)+" "+" - 1)");
                cell.setCellStyle(stylePercent);
                for(int j=i*list.size(); j<(i+1)*list.size(); j++){
                    cellnum++;
                    cell =row.createCell(cellnum);
                    cell.setCellValue(sachMuon_2020.get(j));
                }
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
    
    public void exportReport() {
//        String url = "D:\\untitle.xls";
        String url = new Report().WriteFile();
        if (url == null) {
            return;
        }
        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Thống Kê Phiếu Mượn");
            sheet.setDisplayGridlines(false);
            sheet.setColumnWidth(0, 600);
            sheet.setColumnWidth(1, 3000);
            sheet.setColumnWidth(2, 3200);
            sheet.setColumnWidth(3, 3200);
            sheet.setColumnWidth(4, 3500);
            sheet.setColumnWidth(5, 3500);
            sheet.setColumnWidth(6, 3500);
            sheet.setColumnWidth(7, 700);
            sheet.setGridsPrinted(false);
            sheet.setPrintGridlines(false);
            
            HSSFFont fontFamily = workbook.createFont();
            fontFamily.setFontName("Calibri");
            fontFamily.setColor(HSSFColor.HSSFColorPredefined.GREY_80_PERCENT.getIndex());
            
            HSSFCellStyle styleSheet= workbook.createCellStyle();
            styleSheet.setFont(fontFamily);
            
            HSSFFont fontTitle = workbook.createFont();
            fontTitle.setFontHeightInPoints((short) 30);
            fontTitle.setColor(HSSFColor.HSSFColorPredefined.VIOLET.getIndex());
//            HSSFColor color = new HSSFColor(0, -1, new Color(115, 87, 115));
//            fontTitle.setColor(color.getIndex());            
            
            HSSFCellStyle styleTitle= workbook.createCellStyle();
            styleTitle.cloneStyleFrom(styleSheet);
            styleTitle.setVerticalAlignment(VerticalAlignment.CENTER);
            styleTitle.setFont(fontTitle);
            styleTitle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
            //styleTitle.setFillPattern(CellStyle.SOLID_FOREGROUND); 
            
            Row row = sheet.createRow(0);
            
            Cell cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("THỐNG KÊ PHIẾU MƯỢN");
            cell.setCellStyle(styleTitle);
            row.setHeightInPoints(50);
            
            HSSFFont fontNote = workbook.createFont();
            fontNote.setColor(HSSFColor.HSSFColorPredefined.ORCHID.getIndex());
            fontNote.setItalic(true);
            
            HSSFCellStyle styleNote= workbook.createCellStyle();
            styleNote.cloneStyleFrom(styleSheet);
            styleNote.setVerticalAlignment(VerticalAlignment.CENTER);
            styleNote.setFont(fontNote);
            
            row = sheet.createRow(1);
            cell = row.createCell(1,CellType.STRING);
            cell.setCellValue("Bảng thống kê phiếu mượn của mỗi năm");
            cell.setCellStyle(styleNote);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 3));
            row.setHeightInPoints(20);
            sheet.addMergedRegion(new CellRangeAddress(2, 2, 8, 10));
            
            Map<Integer, Object[]> header = new TreeMap<Integer, Object[]>();
            header.put(1, new Object[]{"GIAI ĐOẠN", "SỐ PHIẾU MƯỢN", "TỔNG SỐ SÁCH MƯỢN", "SỐ SÁCH MƯỢN/ PHIẾU",
            "SỐ PHIẾU MƯỢN/ NGÀY", "TỈ LỆ GIA TĂNG", "", "SÁCH MƯỢN"});
            
            
            
            HSSFCellStyle border = workbook.createCellStyle();
            border.cloneStyleFrom(styleSheet);
            border.setBorderBottom(BorderStyle.THIN);
            //border.setBottomBorderColor();
            
            HSSFCellStyle borderTop = workbook.createCellStyle();
            borderTop.cloneStyleFrom(styleSheet);
            borderTop.setBorderTop(BorderStyle.THIN);
            
            HSSFCellStyle styleWrapText = workbook.createCellStyle();
            styleWrapText.setWrapText(true);

            HSSFFont fontHeader = workbook.createFont();
            fontHeader.setBold(true);
            fontHeader.setColor(HSSFColor.HSSFColorPredefined.GREY_80_PERCENT.getIndex());
            
            HSSFCellStyle headerStyle = workbook.createCellStyle(); 
            headerStyle.cloneStyleFrom(styleSheet);
            headerStyle.cloneStyleFrom(styleWrapText);
            headerStyle.setAlignment(HorizontalAlignment.CENTER);
            headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
            //headerStyle.setFillForegroundColor();
            headerStyle.setFont(fontHeader);
            
            HSSFCellStyle center = workbook.createCellStyle();
            center.cloneStyleFrom(styleSheet);
            center.setAlignment(HorizontalAlignment.CENTER);
            center.setVerticalAlignment(VerticalAlignment.CENTER);
            
            HSSFCellStyle styleBold = workbook.createCellStyle();
//            styleBold.cloneStyleFrom(styleSheet);
            styleBold.cloneStyleFrom(center);
            styleBold.setFont(fontHeader);
            
            HSSFCellStyle stylePercent = workbook.createCellStyle();
            //styleBold.cloneStyleFrom(styleSheet);
            stylePercent.cloneStyleFrom(styleBold);
            stylePercent.setDataFormat(workbook.createDataFormat().getFormat("0%"));
            
            sheet.setDefaultColumnStyle(1, styleBold);
            sheet.setDefaultColumnStyle(6, styleBold);
            for(int i=0;i<100;i++){
                sheet.setDefaultColumnStyle(i, center);
            }
            
            writeToSheet(sheet, header, headerStyle, border, center, 1);
            
            HSSFCellStyle style = workbook.createCellStyle();
            //style.setFillBackgroundColor(IndexedColors.LAVENDER.getIndex());
            style.setFillPattern(FillPatternType.FINE_DOTS);
            
            
            int rownum, cellnum = 0;
            while(cellnum < 6){
                rownum = 2;  cellnum++;
                int rownext=rownum+1;
                sheet.addMergedRegion(new CellRangeAddress(rownum, rownext, cellnum, cellnum));
            }
            
            QLLoaiSachBUS maSachBUS = new QLLoaiSachBUS();
            ArrayList<String> list =maSachBUS.getPKey();
       
            cellnum=1;
            row = sheet.createRow(3);
            for(int i=0;i<7;i++){
                cell= row.createCell(cellnum);
                cell.setCellStyle(border);
                cellnum++;
            }
            
            cellnum=8;
            for (int i=0;i<list.size();i++) {
                cell = row.createCell(cellnum, CellType.STRING);
                cell.setCellValue(list.get(i));
                cell.setCellStyle(border);
                cellnum++;
            }
            
            cellnum=1;
            row = sheet.createRow(22);
            for (int i=0;i<31;i++) {
                cell = row.createCell(cellnum);
                cell.setCellStyle(borderTop);
                cellnum++;
            }
            
            rownum=3;  
            String [] thang2019 ={"01/2019", "02/2019", "03/2019", "04/2019", "05/2019", "06/2019", 
            "07/2019", "08/2019", "09/2019", "10/2019", "11/2019", "12/2019"};
            new QLPhieuMuonBUS();
            ArrayList <Integer> phieuMuon = new ArrayList<>();
            phieuMuon= new QLPhieuMuonBUS(0).getArrSoPhieuMuon(2019);
            
            ArrayList <Integer> sachMuon = new ArrayList<>();
            sachMuon= new QLPhieuMuonBUS(0).getArrSoLuongSachMuon(2019);
            
            ArrayList <Integer> sachMuon_2019 = new ArrayList<>();
            for(int i=0;i<12;i++){
                for(int j=0;j<list.size();j++){
                    sachMuon_2019.add(new QLPhieuMuonBUS(0).getSoLuongSachMuon_MaSach(list.get(j), i+1, 2019));
                }
            }
           
            for (int i=0;i<phieuMuon.size();i++) {
                rownum++;
                cellnum=7;
                row = sheet.createRow(rownum);
                row.setHeightInPoints(30);
                cell = row.createCell(7);
                cell.setCellStyle(style);
                row.createCell(1, CellType.STRING).setCellValue(thang2019[i]);
                row.createCell(2, CellType.STRING).setCellValue(phieuMuon.get(i));
                row.createCell(3, CellType.NUMERIC).setCellValue(sachMuon.get(i));
                row.createCell(4, CellType.FORMULA).setCellFormula("ROUND(D"+(i+5)+"/C"+(i+5)+", 0)");
                row.createCell(5, CellType.FORMULA).setCellFormula("ROUNDUP(C"+(i+5)+"/30, 0)");
                cell=row.createCell(6, CellType.FORMULA);
                cell.setCellFormula("(D"+(i+5)+"/D"+(i+4)+" "+" - 1)");
                cell.setCellStyle(stylePercent);
                sheet.getRow(4).getCell(6).setCellType(CellType.NUMERIC);
                sheet.getRow(4).getCell(6).setCellValue(0);
                sheet.getRow(4).getCell(6).setCellStyle(stylePercent);
                
                for(int j=i*list.size(); j<(i+1)*list.size(); j++){
                    cellnum++;
                    cell =row.createCell(cellnum);
                    cell.setCellValue(sachMuon_2019.get(j));
                }
            }
            
            rownum=15;
            String [] thang2020 ={"01/2020", "02/2020", "03/2020", "04/2020", "05/2020", "06/2020"};
            phieuMuon= new QLPhieuMuonBUS(0).getArrSoPhieuMuonNuaNam(2020);
            sachMuon= new QLPhieuMuonBUS(0).getArrSoLuongSachMuonNuaNam(2020);
            
            ArrayList <Integer> sachMuon_2020 = new ArrayList<>();
            for(int i=0;i<6;i++){
                for(int j=0;j<list.size();j++){
                    sachMuon_2020.add(new QLPhieuMuonBUS(0).getSoLuongSachMuon_MaSach(list.get(j), i+1, 2020));
                }
            }
            
            for (int i=0;i<phieuMuon.size();i++) {
                rownum++;
                cellnum=7;
                row = sheet.createRow(rownum);
                row.setHeightInPoints(30);
                cell = row.createCell(7);
                cell.setCellStyle(style);
                row.createCell(1, CellType.STRING).setCellValue(thang2020[i]);
                row.createCell(2, CellType.STRING).setCellValue(phieuMuon.get(i));
                row.createCell(3, CellType.NUMERIC).setCellValue(sachMuon.get(i));
                row.createCell(4, CellType.FORMULA).setCellFormula("ROUND(D"+(i+17)+"/C"+(i+17)+", 0)");
                row.createCell(5, CellType.FORMULA).setCellFormula("ROUNDUP(C"+(i+17)+"/30, 0)");
                cell=row.createCell(6, CellType.FORMULA);
                cell.setCellFormula("(D"+(i+17)+"/D"+(i+16)+" "+" - 1)");
                cell.setCellStyle(stylePercent);
                for(int j=i*list.size(); j<(i+1)*list.size(); j++){
                    cellnum++;
                    cell =row.createCell(cellnum);
                    cell.setCellValue(sachMuon_2020.get(j));
                }
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
    
}

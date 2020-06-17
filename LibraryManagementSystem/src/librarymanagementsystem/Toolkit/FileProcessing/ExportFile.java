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
import org.apache.poi.ss.usermodel.Cell.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.RichTextString;
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
            int rownum = 0;
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
            /** for Formula Excel **/
            /*rownum++;
            row = sheet.createRow(rownum);
            row.createCell(4).setCellFormula("1+1");
            //sheet.getRow(rownum+1).getCell(0).setCellFormula("=1 + 1");
            System.out.println(sheet.getRow(rownum).getCell(4).getNumericCellValue());
            System.out.println(sheet.getRow(rownum).getCell(4).getCellType());
            
            Cell cell = sheet.getRow(rownum).getCell(4);
            if(cell.getCellType() == CellType.FORMULA) {
                System.out.println("Formula is " + cell.getCellFormula());
                switch(cell.getCachedFormulaResultType()) {
                    case NUMERIC:
                        System.out.println("Last evaluated as: " + cell.getNumericCellValue());
                        break;
                    case STRING:
                        System.out.println("Last evaluated as \"" + cell.getRichStringCellValue() + "\"");
                        break;
                }
            }
            */
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
    public void writeFileExcel_QLNhaCungCap() {
        fx.setTitle("Xuất dữ liệu Nhà Cung Cấp -> excel");
        String url = WriteFile();
        if (url == null) {
            return;
        }
        
        //System.out.println(url);

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Nhà Cung Cấp");

            QLNhaCungCapBUS nhaCungCapBUS = new QLNhaCungCapBUS();
            ArrayList<QLNhaCungCapDTO> list = nhaCungCapBUS.getArrNhaCungCap();
            //qlnccBUS.show();
            int rownum = 1;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.STRING).setCellValue("Mã Nhà Cung Cấp");
            row.createCell(1, CellType.STRING).setCellValue("Tên Nhà Cung Cấp");
            row.createCell(2, CellType.STRING).setCellValue("Số Điện Thoại");
            row.createCell(3, CellType.STRING).setCellValue("Email");
            row.createCell(4, CellType.STRING).setCellValue("Địa Chỉ");
            
            for (QLNhaCungCapDTO nhaCungCap : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.STRING).setCellValue(nhaCungCap.getMaNCC());
                row.createCell(1, CellType.STRING).setCellValue(nhaCungCap.getTenNCC());
                row.createCell(2, CellType.STRING).setCellValue(nhaCungCap.getSdt());
                row.createCell(3, CellType.STRING).setCellValue(nhaCungCap.getEmail());
                row.createCell(4, CellType.STRING).setCellValue(nhaCungCap.getDiaChi());
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
    public void writeFileExcel_QLNhanVien() {
        fx.setTitle("Xuất dữ liệu Nhân Viên -> excel");
        String url = WriteFile();
        if (url == null) {
            return;
        }
        
        //System.out.println(url);

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Nhân Viên");

            QLNhanVienBUS nhanVienBUS = new QLNhanVienBUS();
            ArrayList<QLNhanVienDTO> list = nhanVienBUS.getArrNhanVien();
            //qlnccBUS.show();
            int rownum = 1;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.STRING).setCellValue("Mã Nhân Viên");
            row.createCell(1, CellType.STRING).setCellValue("Password");
            row.createCell(2, CellType.STRING).setCellValue("Họ Tên");
            row.createCell(3, CellType.STRING).setCellValue("Ngày Sinh");
            row.createCell(4, CellType.STRING).setCellValue("Địa Chỉ");
            row.createCell(5, CellType.STRING).setCellValue("Số Điện Thoại");
            row.createCell(6, CellType.STRING).setCellValue("Email");
            row.createCell(7, CellType.STRING).setCellValue("Chức Vụ");
            row.createCell(8, CellType.STRING).setCellValue("RFID_CODE");
            
            for (QLNhanVienDTO nhanVien : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.STRING).setCellValue(nhanVien.getMaNhanVien());
                row.createCell(1, CellType.STRING).setCellValue(nhanVien.getPassword());
                row.createCell(2, CellType.STRING).setCellValue(nhanVien.getHoTen());
                row.createCell(3, CellType.STRING).setCellValue(nhanVien.getNgaySinh());
                row.createCell(4, CellType.STRING).setCellValue(nhanVien.getDiaChi());
                row.createCell(5, CellType.STRING).setCellValue(nhanVien.getSdt());
                row.createCell(6, CellType.STRING).setCellValue(nhanVien.getEmail());
                row.createCell(7, CellType.STRING).setCellValue(nhanVien.getChucVu());
                row.createCell(8, CellType.STRING).setCellValue(nhanVien.getRFID_code());
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
    public void writeFileExcel_QLPhieuMuon() {
        fx.setTitle("Xuất dữ liệu Phiếu Mượn -> excel");
        String url = WriteFile();
        if (url == null) {
            return;
        }
        
        //System.out.println(url);

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Phiếu Mượn");

            QLPhieuMuonBUS phieuMuonBUS = new QLPhieuMuonBUS();
            ArrayList<QLPhieuMuonDTO> list = phieuMuonBUS.getArrMuonTra();
            //qlnccBUS.show();
            int rownum = 1;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.STRING).setCellValue("Mã Phiếu Mượn");
            row.createCell(1, CellType.STRING).setCellValue("Mã Thẻ");
            row.createCell(2, CellType.STRING).setCellValue("Ngày Mượn");
            row.createCell(3, CellType.NUMERIC).setCellValue("Thời Gian Mượn");
            row.createCell(4, CellType.STRING).setCellValue("Ngày Trả");
            row.createCell(5, CellType.STRING).setCellValue("ID Sách");
            
            for (QLPhieuMuonDTO phieuMuon : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.STRING).setCellValue(phieuMuon.getMaPhieuMuon());
                row.createCell(1, CellType.STRING).setCellValue(phieuMuon.getMaThe());
                row.createCell(2, CellType.STRING).setCellValue(phieuMuon.getNgayMuon());
                row.createCell(3, CellType.NUMERIC).setCellValue(phieuMuon.getThoiGianMuon());
                row.createCell(4, CellType.STRING).setCellValue(phieuMuon.getNgayTra());
                //row.createCell(5, CellType.STRING).setCellValue(phieuMuon.getIDSach());
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
    public void writeFileExcel_QLPhieuNhap() {
        fx.setTitle("Xuất dữ liệu Phiếu Nhập -> excel");
        String url = WriteFile();
        if (url == null) {
            return;
        }
        
        //System.out.println(url);

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Phiếu Nhập");

            QLPhieuNhapBUS phieuNhapBUS = new QLPhieuNhapBUS();
            ArrayList<QLPhieuNhapDTO> list = phieuNhapBUS.getArrNhapKho();
            //qlnccBUS.show();
            int rownum = 1;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.STRING).setCellValue("Mã Nhập");
            row.createCell(1, CellType.STRING).setCellValue("Ngày Nhập");
            row.createCell(2, CellType.STRING).setCellValue("Mã Sách");
            row.createCell(3, CellType.STRING).setCellValue("Số Lượng");
            row.createCell(4, CellType.STRING).setCellValue("Mã Nhân Viên");
            row.createCell(5, CellType.STRING).setCellValue("Mã Nhà Cung Cấp");
            
            for (QLPhieuNhapDTO phieuNhap : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.STRING).setCellValue(phieuNhap.getMaNhap());
                row.createCell(1, CellType.STRING).setCellValue(phieuNhap.getNgayNhap());
                //row.createCell(2, CellType.STRING).setCellValue(phieuNhap.getMaSach());
                //row.createCell(3, CellType.NUMERIC).setCellValue(phieuNhap.getSoLuong());
                row.createCell(4, CellType.STRING).setCellValue(phieuNhap.getMaNhanVien());
                row.createCell(5, CellType.STRING).setCellValue(phieuNhap.getMaNCC());
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
    public void writeFileExcel_QLPhieuPhat() {
        fx.setTitle("Xuất dữ liệu Phiếu Phạt -> excel");
        String url = WriteFile();
        if (url == null) {
            return;
        }
        
        //System.out.println(url);

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Phiếu Phạt");

            QLPhieuPhatBUS phieuPhatBUS = new QLPhieuPhatBUS();
            ArrayList<QLPhieuPhatDTO> list = phieuPhatBUS.getArrPhieuPhat();
            //qlnccBUS.show();
            int rownum = 1;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.STRING).setCellValue("Mã Phiếu Phạt");
            row.createCell(1, CellType.STRING).setCellValue("Mã Phiếu Mượn");
            row.createCell(2, CellType.STRING).setCellValue("Mã Lý Do Phạt");
            
            for (QLPhieuPhatDTO phieuPhat : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.STRING).setCellValue(phieuPhat.getMaPhieuPhat());
                row.createCell(1, CellType.STRING).setCellValue(phieuPhat.getMaPhieuMuon());
                row.createCell(2, CellType.STRING).setCellValue(phieuPhat.getMaLDPhat());
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
    public void writeFileExcel_QLPhieuXuat() {
        fx.setTitle("Xuất dữ liệu Phiếu Xuất -> excel");
        String url = WriteFile();
        if (url == null) {
            return;
        }
        
        //System.out.println(url);

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Phiếu Xuất");

            QLPhieuXuatBUS phieuXuatBUS = new QLPhieuXuatBUS();
            ArrayList<QLPhieuXuatDTO> list = phieuXuatBUS.getArrXuatKho();
            //qlnccBUS.show();
            int rownum = 1;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.STRING).setCellValue("Mã Phiếu Xuất");
            row.createCell(1, CellType.STRING).setCellValue("Ngày Xuất");
            row.createCell(2, CellType.STRING).setCellValue("Mã Sách");
            row.createCell(3, CellType.STRING).setCellValue("Số Lượng");
            row.createCell(4, CellType.STRING).setCellValue("Mã Nhân Viên");
            
            for (QLPhieuXuatDTO phieuXuat : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.STRING).setCellValue(phieuXuat.getMaXuat());
                row.createCell(1, CellType.STRING).setCellValue(phieuXuat.getNgayXuat());
                //row.createCell(2, CellType.STRING).setCellValue(phieuXuat.getMaSach());
                //row.createCell(3, CellType.NUMERIC).setCellValue(phieuXuat.getSoLuong());
                row.createCell(4, CellType.STRING).setCellValue(phieuXuat.getMaNhanVien());
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
    public void writeFileExcel_QLThe() {
        fx.setTitle("Xuất dữ liệu Thẻ -> excel");
        String url = WriteFile();
        if (url == null) {
            return;
        }
        
        //System.out.println(url);

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Thẻ");

            QLTheBUS theBUS = new QLTheBUS();
            ArrayList<QLTheDTO> list = theBUS.getArrThe();
            //qlnccBUS.show();
            int rownum = 1;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.STRING).setCellValue("Mã Thẻ");
            row.createCell(1, CellType.STRING).setCellValue("Mã Khách Hàng");
            row.createCell(2, CellType.STRING).setCellValue("Ngày Cấp");
            row.createCell(3, CellType.STRING).setCellValue("Ngày Hết Hạn");
            
            for (QLTheDTO the : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.STRING).setCellValue(the.getMaThe());
                row.createCell(1, CellType.STRING).setCellValue(the.getMaKhachHang());
                row.createCell(2, CellType.STRING).setCellValue(the.getNgayCap());
                row.createCell(3, CellType.STRING).setCellValue(the.getNgayHetHan());
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
    public void writeFileExcel_QLAdmin() {
        fx.setTitle("Xuất dữ liệu Admin -> excel");
        String url = WriteFile();
        if (url == null) {
            return;
        }
        
        //System.out.println(url);

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Admin");

            QLAdminBUS adminBUS = new QLAdminBUS();
            ArrayList<QLAdminDTO> list = adminBUS.getArrAdmin();
            //qlnccBUS.show();
            int rownum = 1;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.STRING).setCellValue("Tài Khoản Admin");
            row.createCell(1, CellType.STRING).setCellValue("Password");
            row.createCell(2, CellType.STRING).setCellValue("RFID_CODE");
            
            for (QLAdminDTO admin : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.STRING).setCellValue(admin.getTkAdmin());
                row.createCell(1, CellType.STRING).setCellValue(admin.getPassword());
                row.createCell(2, CellType.STRING).setCellValue(admin.getRFID_code());
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
    public void writeFileExcel_QLChiTietSach() {
        fx.setTitle("Xuất dữ liệu Chi Tiết Sách -> excel");
        String url = WriteFile();
        if (url == null) {
            return;
        }
        
        //System.out.println(url);

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Chi Tiết Sách");

            QLChiTietSachBUS chiTietSachBUS = new QLChiTietSachBUS();
            ArrayList<QLChiTietSachDTO> list = chiTietSachBUS.getArrChiTietSach();
            //qlnccBUS.show();
            int rownum = 1;
            Row row = sheet.createRow(rownum);
            
            row.createCell(0, CellType.STRING).setCellValue("ID Sách");
            row.createCell(1, CellType.STRING).setCellValue("Mã Sách");
            row.createCell(2, CellType.STRING).setCellValue("Tình Trạng");
            row.createCell(3, CellType.STRING).setCellValue("Tên Sách");
            row.createCell(4, CellType.STRING).setCellValue("Tên Tác Giả");
            row.createCell(5, CellType.STRING).setCellValue("Tên NXB");
            row.createCell(6, CellType.STRING).setCellValue("Năm XB");
            row.createCell(7, CellType.STRING).setCellValue("Thể Loại");
            row.createCell(8, CellType.STRING).setCellValue("Ngôn Ngữ");
            row.createCell(9, CellType.STRING).setCellValue("Tóm Tắt Nội Dung");
            row.createCell(10, CellType.NUMERIC).setCellValue("Giá Tiền");
            row.createCell(11, CellType.NUMERIC).setCellValue("Số Trang");
            row.createCell(12, CellType.STRING).setCellValue("Hình Sách");
            
            for (QLChiTietSachDTO chiTietSach : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.STRING).setCellValue(chiTietSach.getIDSach());
                row.createCell(1, CellType.STRING).setCellValue(chiTietSach.getMaSach());
                row.createCell(2, CellType.STRING).setCellValue(chiTietSach.getTinhTrang());
                row.createCell(3, CellType.STRING).setCellValue(chiTietSach.getSach().getTenSach());
                row.createCell(4, CellType.STRING).setCellValue(chiTietSach.getSach().getTenTacGia());
                row.createCell(5, CellType.STRING).setCellValue(chiTietSach.getSach().getTenNXB());
                row.createCell(6, CellType.NUMERIC).setCellValue(chiTietSach.getSach().getNamXB());
                row.createCell(7, CellType.STRING).setCellValue(chiTietSach.getSach().getTheLoai());
                row.createCell(8, CellType.STRING).setCellValue(chiTietSach.getSach().getNgonNgu());
                row.createCell(9, CellType.STRING).setCellValue(chiTietSach.getSach().getTomTatNoiDung());
                row.createCell(10, CellType.NUMERIC).setCellValue(chiTietSach.getSach().getGiaTien());
                row.createCell(11, CellType.NUMERIC).setCellValue(chiTietSach.getSach().getSoTrang());
                row.createCell(12, CellType.STRING).setCellValue(chiTietSach.getSach().getHinh());
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
    public void writeFileExcel_QLKhachHang() {
        fx.setTitle("Xuất dữ liệu Khách Hàng -> excel");
        String url = WriteFile();
        if (url == null) {
            return;
        }
        
        //System.out.println(url);

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Khách Hàng");

            QLKhachHangBUS khachHangBUS = new QLKhachHangBUS();
            ArrayList<QLKhachHangDTO> list = khachHangBUS.getArrKhachHang();
            //qlnccBUS.show();
            int rownum = 1;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.STRING).setCellValue("Mã Nhân Viên");
            row.createCell(1, CellType.STRING).setCellValue("Họ Tên");
            row.createCell(2, CellType.STRING).setCellValue("Ngày Sinh");
            row.createCell(3, CellType.STRING).setCellValue("Địa Chỉ");
            row.createCell(4, CellType.STRING).setCellValue("Số Điện Thoại");
            row.createCell(5, CellType.STRING).setCellValue("Email");
            
            for (QLKhachHangDTO khachHang : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.STRING).setCellValue(khachHang.getMaKhachHang());
                row.createCell(1, CellType.STRING).setCellValue(khachHang.getHoTen());
                row.createCell(2, CellType.STRING).setCellValue(khachHang.getNgaySinh());
                row.createCell(3, CellType.STRING).setCellValue(khachHang.getDiaChi());
                row.createCell(4, CellType.STRING).setCellValue(khachHang.getSdt());
                row.createCell(5, CellType.STRING).setCellValue(khachHang.getEmail());
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
    public void writeFileExcel_QLKhoSach() {
        fx.setTitle("Xuất dữ liệu Kho Sách -> excel");
        String url = WriteFile();
        if (url == null) {
            return;
        }
        
        //System.out.println(url);

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Kho Sách");

            QLKhoSachBUS khoSachBUS = new QLKhoSachBUS();
            ArrayList<QLKhoSachDTO> list = khoSachBUS.getArrKhoSach();
            //qlnccBUS.show();
            int rownum = 1;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.STRING).setCellValue("Mã Sách");
            row.createCell(1, CellType.NUMERIC).setCellValue("Số Lượng");
            
            for (QLKhoSachDTO khoSach : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.STRING).setCellValue(khoSach.getMaSach());
                row.createCell(1, CellType.NUMERIC).setCellValue(khoSach.getSoLuong());
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
    
    public void writeFileExcel_QLLDPhat() {
        fx.setTitle("Xuất dữ liệu Lý Do Phạt -> excel");
        String url = WriteFile();
        if (url == null) {
            return;
        }
        
        //System.out.println(url);

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Lý Do Phạt");

            QLLDPhatBUS LDPhatBUS = new QLLDPhatBUS();
            ArrayList<QLLDPhatDTO> list = LDPhatBUS.getArrLDPhat();
            //qlnccBUS.show();
            int rownum = 1;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.STRING).setCellValue("Mã Lý Do Phạt");
            row.createCell(1, CellType.STRING).setCellValue("Tên Lý Do Phạt");
            row.createCell(1, CellType.NUMERIC).setCellValue("Mức Độ");
            
            for (QLLDPhatDTO LDPhat : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.STRING).setCellValue(LDPhat.getMaLDPhat());
                row.createCell(1, CellType.STRING).setCellValue(LDPhat.getTenLDPhat());
                row.createCell(2, CellType.NUMERIC).setCellValue(LDPhat.getMucDo());
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
        String url = "D:\\untitle.xls";
        if (url == null) {
            return;
        }
        
        //System.out.println(url);

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Loại Sách");
            //qlnccBUS.show();
            int rownum = 1;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.STRING).setCellValue("Mã Sách");
            row.createCell(1, CellType.STRING).setCellValue("Tên Sách");
            row.createCell(2, CellType.STRING).setCellValue("Tên Tác Giả");
            
            /*for (QLLoaiSachDTO sach : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.STRING).setCellValue("123");
                row.createCell(1, CellType.STRING).setCellValue("567");
                row.createCell(2, CellType.STRING).setCellValue("9123012");
            }*/
            /*for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }*/
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

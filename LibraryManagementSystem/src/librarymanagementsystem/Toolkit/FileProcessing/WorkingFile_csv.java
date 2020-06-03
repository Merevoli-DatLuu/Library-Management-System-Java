
package librarymanagementsystem.Toolkit.FileProcessing;

import java.awt.FileDialog;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WorkingFile_csv {
    private static String csv_file = "";
    FileDialog fx = new FileDialog(new JFrame(), "Đọc file Excel", FileDialog.SAVE);
    static ArrayList <String> time_series = new ArrayList<>();
    static ArrayList <Integer> number_series = new ArrayList<>();
        
    public String WriteFile(){
        fx.setFilenameFilter(new FilenameFilter(){
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".csv");
            }
        });
        fx.setFile("untitled.csv");
        fx.setVisible(true);
        String url = fx.getDirectory() + fx.getFile();
        if (url.equals("nullnull")) {
            return null;
        }
        return url;
    }
    
    // Cái này viết cho mô hình dự đoán (chưa viết hàm tổng quát)
    public void ExportCSV(ArrayList <String> Time, ArrayList <Integer> Number){
        csv_file = WriteFile();
        try (
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(csv_file));

            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader("Time", "Number"));
        ) {
            for (int i=0; i<Time.size(); i++){
                csvPrinter.printRecord(Time.get(i), Number.get(i));
            }
            
            csvPrinter.flush();         
            System.out.println("Thành Công");
            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + csv_file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void ImportCSV(){
        try (
            Reader reader = Files.newBufferedReader(Paths.get(csv_file));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            int i = 0;
            for (CSVRecord csvRecord : csvParser) {
                String time = csvRecord.get(0);
                String number = csvRecord.get(1);
                
                if (i > 0){
                    time_series.add(time);
                    number_series.add(Integer.parseInt(number));
                }
                i++;
                
                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Time : " + time);
                System.out.println("Number : " + number);
                System.out.println("---------------\n\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getTime_series() {
        return time_series;
    }

    public ArrayList<Integer> getNumber_series() {
        return number_series;
    }
    
    public static void main(String[] args) throws IOException {
        ArrayList <String> Time = new ArrayList<>();
        ArrayList <Integer> Number = new ArrayList<>();

        Time.add("2019-01");
        Time.add("2019-02");
        Time.add("2019-03");
        Time.add("2019-04");
        Time.add("2019-05");
        Time.add("2019-06");
        Time.add("2019-07");
        Time.add("2019-08");
        Time.add("2019-10");
        Time.add("2019-11");
        Time.add("2019-12");
        Time.add("2020-01");
        Time.add("2020-02");
        Time.add("2020-03");
        Time.add("2020-04");
        Time.add("2020-05");
        Time.add("2020-06");
        Number.add(10);
        Number.add(12);
        Number.add(14);
        Number.add(15);
        Number.add(23);
        Number.add(25);
        Number.add(26);
        Number.add(31);
        Number.add(34);
        Number.add(35);
        Number.add(32);
        Number.add(34);
        Number.add(37);
        Number.add(38);
        Number.add(43);
        Number.add(31);
        Number.add(43);
        Number.add(45);
        
        new WorkingFile_csv().ExportCSV(Time, Number);
        new WorkingFile_csv().ImportCSV();
        
    }
}

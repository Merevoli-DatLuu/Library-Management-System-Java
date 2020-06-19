package librarymanagementsystem.Toolkit;

import java.lang.*;
import java.lang.Number;
import java.lang.Math;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.sql.Date;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
//import org.apache.commons.codec.binary.Base64;


public class DataProcessing {
    
    /***
     * ** Kiểm tra regex **
     * check_XXX()
     * @param str
     * @return Boolean 
     ***/
    public Boolean check_maSach(String str){
        String regex = "S\\d{6}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }
    public Boolean check_IDSach(String str){
        String regex = "IDS\\d{6}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }
    public Boolean check_maThe(String str){
        String regex = "T\\d{6}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }
    public Boolean check_maKhachHang(String str){
        String regex = "KH\\d{6}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }
    public Boolean check_maMuonSach(String str){
        String regex = "M\\d{6}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }
    public Boolean check_maQuanLy(String str){
        String regex = "QL\\d{6}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }
    public Boolean check_maAdmin(String str){
        String regex = "AD\\d{6}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }
    public Boolean check_maLDPhat(String str){
        String regex = "LDP\\d{6}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }
    public Boolean check_maPhieuNhap(String str){
        String regex = "N\\d{7}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }
    public Boolean check_maNCC(String str){
        String regex = "NCC\\d{6}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }
    public Boolean check_maPhieuXuat(String str){
        String regex = "X\\d{7}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }
    
    public Boolean check_ngay(String str){
        String regex = "\\d{1,2}";
        Pattern pattern = Pattern.compile(regex);
        return (pattern.matcher(str).matches() && (Integer.parseInt(str) < 31));
    }
    public Boolean check_thang(String str){
        String regex = "\\d{1,2}";
        Pattern pattern = Pattern.compile(regex);
        return (pattern.matcher(str).matches() && (Integer.parseInt(str) < 31));
    }
    public Boolean check_nam(String str){
        String regex = "\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }
    public Boolean check_ngaythangnam(String str){
        String regex = "\\d{4}[-|/]\\d{1,2}[-|/]\\d{1,2}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }
    public Boolean check_sdt(String sdt){
        String regex = "\\d{10,11}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(sdt).matches();
    }
    public Boolean check_email(String str){
        String regex = "^[a-zA-Z][a-zA-Z0-9_\\.]{5,32}@[a-zA-Z0-9]{2,}(\\.[a-zA-Z0-9]{2,4}){1,2}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }
    
    public Boolean check_number(String number){
        String regex = "\\d{1,11}";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(number).matches();
    }
    
    
    /***
     * ** Sinh mã kế tiếp **
     * next_XXX()
     * @param ma
     * @return String
     */
    public String next_ma(ArrayList <Integer> ma){
        int[] hashmap = new int[ma.size() + 107];
        for (int a : ma){
            if (a <= ma.size()){
                hashmap[a] = 1;
            }
        }
        int res = 1;
        while (hashmap[res] == 1){
            res++;
        }
        String nextma = Integer.toString(res);
        while (nextma.length() < 6){
            nextma = "0" + nextma;
        }
        return nextma;
    }
    public String next_maSach(ArrayList <String> ma){
        ArrayList <Integer> int_ma = new ArrayList <>();
        for (String i : ma){
            int_ma.add(Integer.parseInt(i.substring(1)));
        }
        return "S" + next_ma(int_ma);
    }
    public String next_IDSach(ArrayList <String> ma){
        ArrayList <Integer> int_ma = new ArrayList <>();
        for (String i : ma){
            int_ma.add(Integer.parseInt(i.substring(3)));
        }
        return "IDS" + next_ma(int_ma);
    }
    public String next_maThe(ArrayList <String> ma){
        ArrayList <Integer> int_ma = new ArrayList <>();
        for (String i : ma){
            int_ma.add(Integer.parseInt(i.substring(1)));
        }
        return "T" + next_ma(int_ma);
    }
    public String next_maKhachHang(ArrayList <String> ma){
        ArrayList <Integer> int_ma = new ArrayList <>();
        for (String i : ma){
            int_ma.add(Integer.parseInt(i.substring(2)));
        }
        return "KH" + next_ma(int_ma);
    }
    public String next_maMuonSach(ArrayList <String> ma){
        ArrayList <Integer> int_ma = new ArrayList <>();
        for (String i : ma){
            int_ma.add(Integer.parseInt(i.substring(1)));
        }
        return "M" + next_ma(int_ma);
    }
    public String next_maQuanLy(ArrayList <String> ma){
        ArrayList <Integer> int_ma = new ArrayList <>();
        for (String i : ma){
            int_ma.add(Integer.parseInt(i.substring(2)));
        }
        return "QL" + next_ma(int_ma);
    }
    public String next_maAdmin(ArrayList <String> ma){
        ArrayList <Integer> int_ma = new ArrayList <>();
        for (String i : ma){
            int_ma.add(Integer.parseInt(i.substring(2)));
        }
        return "AD" + next_ma(int_ma);
    }
    public String next_maPhieuPhat(ArrayList <String> ma){
        ArrayList <Integer> int_ma = new ArrayList <>();
        for (String i : ma){
            int_ma.add(Integer.parseInt(i.substring(1)));
        }
        return "P" + next_ma(int_ma);
    }
    public String next_maNCC(ArrayList <String> ma){
        ArrayList <Integer> int_ma = new ArrayList <>();
        for (String i : ma){
            int_ma.add(Integer.parseInt(i.substring(3)));
        }
        return "NCC" + next_ma(int_ma);
    }
    public String next_MaLDPhat(ArrayList <String> ma){
        ArrayList <Integer> int_ma = new ArrayList <>();
        for (String i : ma){
            int_ma.add(Integer.parseInt(i.substring(3)));
        }
        return "LDP" + next_ma(int_ma);
    }
    public String next_maPhieuNhap(ArrayList <String> ma){  // fix length sau
        ArrayList <Integer> int_ma = new ArrayList <>();
        for (String i : ma){
            int_ma.add(Integer.parseInt(i.substring(2)));
        }
        return "N0" + next_ma(int_ma);
    }
    public String next_maPhieuXuat(ArrayList <String> ma){  // fix length sau
        ArrayList <Integer> int_ma = new ArrayList <>();
        for (String i : ma){
            int_ma.add(Integer.parseInt(i.substring(2)));
        }
        return "X0" + next_ma(int_ma);
    }
        
    /** Thêm phẩy và Đơn vị **/
    public String toMoney(int m){
        String money = Integer.toString(m);
        for (int i=money.length()-3; i>0; i-=3){
            money = money.substring(0, i) + "," + money.substring(i);
        }
        return money + " VNĐ";
    }   
    
    public String toMoney(String m){
        String money = m;
        for (int i=money.length()-3; i>0; i-=3){
            money = money.substring(0, i) + "," + money.substring(i);
        }
        return money + " VNĐ";
    }   
    
    /** Mã Hóa Mật Khẩu **/ 
    public String hashPassword(String password){
        String hashedText = toMD5(password);
        return hashedText;
    }
    
    public String toMD5(String input){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            return convertByteToHex(messageDigest);
        } 
        catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    } 
    
    public String convertByteToHex(byte[] data){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < data.length; i++){
            sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
    
    public byte[] genSalt(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }
    
    public String dateToString(Date date){
        return date.toString();
    }
    
    public Date stringToDate(String date){
        return Date.valueOf(date);
    }
    
    /** Date Processing **/
    public int getDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DATE);
    }
    
    public int getDate(String date){
        Date dat = Date.valueOf(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dat);
        return cal.get(Calendar.DATE);
    }
    
    public int getMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }
    
    public int getMonth(String date){
        Date dat = Date.valueOf(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dat);
        return cal.get(Calendar.MONTH) + 1;
    }
    
    public int getYear(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }
    
    public int getYear(String date){
        Date dat = Date.valueOf(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dat);
        return cal.get(Calendar.YEAR);
    }
    
    public int getDay(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }
    
    public int getDay(String date){
        Date dat = Date.valueOf(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dat);
        return cal.get(Calendar.DAY_OF_WEEK);
    }
    
    public int getCurrentYear(){
        return Calendar.getInstance().get(Calendar.YEAR);
    }
    
    public int getCurrentMonth(){
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }
    
    public int getCurrentDay(){
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }
    
    // return numbers of years
    public int getAge(Date date_1){
        Calendar cal_1 = Calendar.getInstance();
        cal_1.setTime(date_1);
        Calendar cal_2 = Calendar.getInstance();
        return cal_2.get(Calendar.YEAR) - cal_1.get(Calendar.YEAR);
    }
    
    public int getAge(String date_1){
        Date dat = Date.valueOf(date_1);
        Calendar cal_1 = Calendar.getInstance();
        cal_1.setTime(dat);
        Calendar cal_2 = Calendar.getInstance();
        return cal_2.get(Calendar.YEAR) - cal_1.get(Calendar.YEAR);
    }
    
    /** Analysis Functions **/
    
    public double max(ArrayList <Double> arr){
        double res_max = -0x3f3f3f3f;
        for (double i : arr){
            if (res_max < i){
                res_max = i;
            }
        }
        return res_max;
    }
    
    public double min(ArrayList <Double> arr){
        double res_min = 0x3f3f3f3f;
        for (double i : arr){
            if (res_min < i){
                res_min = i;
            }
        }
        return res_min;
    }
    
    public double mean(ArrayList <Double> arr){
        double sum = 0;
        for (double i : arr){
            sum += i;
        }
        return sum/arr.size();
    }
    
    public double median(ArrayList <Double> arr){
        Collections.sort(arr);
        if ((arr.size() & 1) == 1){
            return arr.get(arr.size()/2 + 1);
        }
        else{
            return (arr.get(arr.size()/2) + arr.get(arr.size()/2 + 1))/2;
        }
    }
    
    public double mode(ArrayList <Double> arr){
        HashMap<Double, Integer> hashMap = new HashMap<Double, Integer>();
        for (double i : arr){
            Integer count = hashMap.get(i);
            if (count == null){
                hashMap.put(i, 1);
            }
            else{
                hashMap.put(i, hashMap.get(i) + 1);
            }
        }
        int max_mode = 0;
        double res_mode = arr.get(0);
        for (double i : hashMap.keySet()){
            if (max_mode < hashMap.get(i)){
                max_mode = hashMap.get(i);
                res_mode = i;
            }
        }
        return res_mode;
    }
    
    public double var(ArrayList <Double> arr){
        double mean = mean(arr);
        double res_var = 0;
        for (double i : arr){
            res_var += (i - mean)*(i - mean);
        }
        return res_var/arr.size();
    }
    
    public double std(ArrayList <Double> arr){
        return Math.sqrt(var(arr));
    }
    
    public double percentile(ArrayList <Double> arr, int percen){
        double per = (double)100/arr.size();
        int k = (int)(percen/per) - 1;
        if (k < 0){
            k = 0;
        }
        Collections.sort(arr);
        return arr.get(k);
    }
    
    /** Tiền Phạt **/
    public int calTienPhat(int mucDo){
        return 5000*mucDo;
    }
    
    /** data.length() = date.length() By Date**/ 
    /** Get Data from Analysis **/
    public Double[] getDateValue(ArrayList <String> date) { // count from 2019 && only this count from 0
        Double[] dat = new Double[10];
        for (int i=0; i<date.size(); i++){
            dat[getYear(date.get(i)) - 2019]++;
        }
        return dat;
    }
    
    public Double[] getDateValueByYear(ArrayList <String> date, int year) {
        Double[] dat = new Double[13];
        for (int i=0; i<date.size(); i++){
            if (getYear(date.get(i)) == year){
                dat[getMonth(date.get(i))]++;
            }
        }
        return dat;
    }
    
    public Double[] getDateValueByMonth(ArrayList <String> date, int month, int year) {
        Double[] dat = new Double[32];
        for (int i=0; i<date.size(); i++){
            if (getYear(date.get(i)) == year && getMonth(date.get(i)) == month){
                dat[getDate(date.get(i))]++;
            }
        }
        return dat;
    }
    
    public HashMap <String, Integer> getObjectValue(ArrayList <String> obj) { 
        HashMap <String, Integer> badjava= new HashMap <String, Integer>();
        for (int i=0; i<obj.size(); i++){
            Integer count = badjava.get(obj.get(i));
            if (count == null){
                badjava.put(obj.get(i), 1);
            }
            else{
                badjava.put(obj.get(i), count + 1);
            }
        }
        return badjava;
    }
    
    public HashMap <String, Integer> getObjectValueByYear(ArrayList <String> obj, ArrayList <String> date, int year) {
        HashMap <String, Integer> badjava= new HashMap <String, Integer>();
        for (int i=0; i<obj.size(); i++){
            if (getYear(date.get(i)) == year){
                Integer count = badjava.get(obj.get(i));
                if (count == null){
                    badjava.put(obj.get(i), 1);
                }
                else{
                    badjava.put(obj.get(i), count + 1);
                }
            }
        }
        return badjava;
    }
    
    public HashMap <String, Integer> getObjectValueByMonth(ArrayList <String> obj, ArrayList <String> date, int month, int year) {
        HashMap <String, Integer> badjava= new HashMap <String, Integer>();
        for (int i=0; i<obj.size(); i++){
            if (getYear(date.get(i)) == year && getMonth(date.get(i)) == month){
                Integer count = badjava.get(obj.get(i));
                if (count == null){
                    badjava.put(obj.get(i), 1);
                }
                else{
                    badjava.put(obj.get(i), count + 1);
                }
            }
        }
        return badjava;
    }
    
    /** Union and Intersection 2 Two Array **/
    
    public ArrayList <String> union_arr(ArrayList <String> arr_1, ArrayList <String> arr_2){
        Set<String> set_union = new HashSet<String>();
        ArrayList <String> res_union = new ArrayList <String>();
        
        for (String e : arr_1){
            set_union.add(e);
        }
        
        for (String e : arr_2){
            set_union.add(e);
        }
        
        for (String e : set_union){
            res_union.add(e);
        }
        
        return res_union;
    }
    
    public ArrayList <String> intersection_arr(ArrayList <String> arr_1, ArrayList <String> arr_2){
        Set<String> set_intersection = new HashSet<String>();
        ArrayList <String> res_intersection = new ArrayList <String>();
        
        for (String e : arr_1){
            set_intersection.add(e);
        }
        
        for (String e : arr_2){
            if (set_intersection.contains(e)){
                res_intersection.add(e);
            }
        }
        
        return res_intersection;
    }
    
    
    
    /***public String bytetoString(byte[] input) {
        return org.apache.commons.codec.binary.Base64.encodeBase64String(input);
    }
    
    public byte[] stringToByte(String input) {
        if (Base64.isBase64(input)) {
            return Base64.decodeBase64(input);

        } else {
            return Base64.encodeBase64(input.getBytes());
        }
    }***/
    
    public static void main(String[] args) {
        System.out.println(new DataProcessing().check_number("dfsdf"));
    }
}

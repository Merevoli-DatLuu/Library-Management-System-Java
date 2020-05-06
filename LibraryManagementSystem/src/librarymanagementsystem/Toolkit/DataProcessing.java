package librarymanagementsystem.Toolkit;

import java.lang.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
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
        String regex = "\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}";
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
    
    
    /***
     * ** Sinh mã kế tiếp **
     * next_XXX()
     * @param ma
     * @return String
     */
    public String next_ma(ArrayList <Integer> ma){
        int[] hashmap = new int[ma.size() + 1];
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
}

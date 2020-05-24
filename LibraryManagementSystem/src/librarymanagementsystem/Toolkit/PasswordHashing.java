/** 
*   Class này hashing password bằng thuật toán PBKDF2
**/

package librarymanagementsystem.Toolkit;

import org.apache.commons.codec.binary.Hex;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.SecureRandom;

public class PasswordHashing{
    private final int iterations = 65536;   // tham số cường độ, quy định số vòng lặp thuật toán
    private final int keyLength = 128;      // độ dài output (hashed password) của thuật toán (128 bits)
    private String salt; 

    public PasswordHashing(){
        salt = Hex.encodeHexString(genSalt());
    }

    private byte[] genSalt(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    private byte[] hashingWithPBKDF2(String password){
        try {
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), iterations, keyLength);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return hash;
        }
        catch ( NoSuchAlgorithmException | InvalidKeySpecException e ){
            throw new RuntimeException( e );
        }
    }

    public String getSalt(){
        return salt;
    }

    public void setSalt(String salt){
        this.salt = salt;
    }

    public String getHashedPassword(String password){
        return Hex.encodeHexString(hashingWithPBKDF2(password));
    }

    /** This is for testing **/
    public static void main(String[] args){
        PasswordHashing t = new PasswordHashing();
        //t.setSalt("0426906c0e1b20fe7b05bb4602bbbded");
        System.out.println(t.getHashedPassword("QL000010"));
        System.out.println(t.getSalt());
    }
}

package librarymanagementsystem.DTO;

public class QLAdminDTO {
    String tkAdmin, password, RFID_code;
    
    public QLAdminDTO(String tkAdmin, String password){
        this.tkAdmin = tkAdmin;
        this.password = password;
    }
    
    public QLAdminDTO(String tkAdmin, String password, String RFID_code){
        this.tkAdmin = tkAdmin;
        this.password = password;
        this.RFID_code = RFID_code;
    }
    
    public QLAdminDTO(QLAdminDTO admin){
        this.tkAdmin = admin.tkAdmin;
        this.password = admin.password;
        this.RFID_code = admin.RFID_code;
    }

    public String getTkAdmin() {
        return tkAdmin;
    }

    public void setTkAdmin(String tkAdmin) {
        this.tkAdmin = tkAdmin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRFID_code() {
        return RFID_code;
    }

    public void setRFID_code(String RFID_code) {
        this.RFID_code = RFID_code;
    }
    
    
}

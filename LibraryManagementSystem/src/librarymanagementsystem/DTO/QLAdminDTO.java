package librarymanagementsystem.DTO;

public class QLAdminDTO {
    String tkAdmin, password;
    
    public QLAdminDTO(String tkAdmin, String password){
        this.tkAdmin = tkAdmin;
        this.password = password;
    }
    
    public QLAdminDTO(QLAdminDTO admin){
        this.tkAdmin = admin.tkAdmin;
        this.password = admin.password;
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
    
    
}

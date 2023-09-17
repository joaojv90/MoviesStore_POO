package sys.model;
public class Users  implements java.io.Serializable {


     private Integer idUser;
     private String firstName;
     private String lastName;
     private String mail;
     private String password;

    public Users() {
    }

    public Users(String firstName, String lastName, String mail, String password) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.mail = mail;
       this.password = password;
    }
   
    public Integer getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getMail() {
        return this.mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}



package sys.bean;

import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.PrimeFaces;
import sys.dao.UsersDAO;
import sys.impl.UsersDAOImpl;
import sys.model.Users;

@ManagedBean
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private Users users;
    private String mail;
    private String password;

    public LoginBean() {
        this.users = new Users();
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void login(){
        
        FacesMessage message = null;
        boolean loggedIn = false;
        String route="";
        
        UsersDAO data = new UsersDAOImpl();
        this.users = data.login(users);
        
        if(this.users != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Mail", this.users.getMail());
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.users.getFirstName());
            route="/MoviesStore_POO/faces/views/Home.xhtml";
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error de acceso","Usuario y/o password incorrecta/s");
            users =new Users();
        }
        
        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
        PrimeFaces.current().ajax().addCallbackParam("route", route);
        
    }
    
    public String logout(){
        this.mail = null;
        this.password = null;
        HttpSession httpsession = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpsession.invalidate();
        return "/index";
    }

}

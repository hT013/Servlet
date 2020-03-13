import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Credential {

    @Id
    private String email;
    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
/**
 * Created by jgarcias on 15/11/16.
 */
public class Users {
    private String name;
    private String pass;
    private String email;

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {return email;}

    public Users(String name, String pass, String email){

        this.name = name;
        this.pass = pass;
        this.email = email;

    }
}

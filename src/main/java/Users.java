/**
 * Created by jgarcias on 15/11/16.
 *
 *@author Pablo i Joshua
 *@version 1.0.0
 */

/**
 * Aquesta classe representa a un usuari amb el seu nom, contrasenya y el seu email.
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

    /**
     *
     * @param name es el nom de l'usuari
     * @param pass el la password de l'usuari
     * @param email es l'email de l'usuari
     */
    public Users(String name, String pass, String email){

        this.name = name;
        this.pass = pass;
        this.email = email;

    }
}

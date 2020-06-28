package fr.iut.larochelle.modele;

/**
 *
 * @author yoann
 */
public abstract class Utilisateur {
    public static String username;
    private String password;
    
    /**
     *
     * @param username
     */
    public Utilisateur(String username, String password) {
        this.username=username;
        this.password=password;
    }
    
    /**
     *
     * @param password
     */
    public void changePassword(String password) {
        // TODO - implement Utilisateur.changePassword
        throw new UnsupportedOperationException();
    }
    
    public void seConnecter() {
        // TODO - implement Utilisateur.seConnecter
        throw new UnsupportedOperationException();
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    /** Définir un nom d'utilisateur.
     *
     * @param username String
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}

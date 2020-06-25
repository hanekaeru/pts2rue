package PTS2.modele;

/**
 *
 * @author yoann
 */
public class Professeur extends Utilisateur{
    
    private Matiere matiere;
    
    public Professeur(String username, String password, Matiere matiere) {
        super(username, password);
        this.matiere=matiere;
    }
    
    public Boolean ajouterQuestion() {
        // TODO - implement Professeur.ajouterQuestion
        throw new UnsupportedOperationException();
    }
    
    /**
     *
     * @param question
     */
    public Boolean modifierQuestion(int question) {
        // TODO - implement Professeur.modifierQuestion
        throw new UnsupportedOperationException();
    }
    
    /**
     *
     * @param question
     */
    public Boolean supprimerQuestion(int question) {
        // TODO - implement Professeur.supprimerQuestion
        throw new UnsupportedOperationException();
    }
    
    public void ajouterEvenement() {
        // TODO - implement Professeur.ajouterEvenement
        throw new UnsupportedOperationException();
    }
    
    public void supprimerEvenement() {
        // TODO - implement Professeur.supprimerEvenement
        throw new UnsupportedOperationException();
    }
    
    public void modifierEvenement() {
        // TODO - implement Professeur.modifierEvenement
        throw new UnsupportedOperationException();
    }
    
    public void modifierMessage() {
        // TODO - implement Professeur.modifierMessage
        throw new UnsupportedOperationException();
    }
    
    public Matiere getMatiere() {
        return this.matiere;
    }
    
    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
    
}

package PTS2.modele;

/**
 *
 * @author yoann
 */
public enum Niveau {
    PREMIERE_ANNEE (1),
    DEUXIEME_ANNEE (2);
    
    private final int niveau;
    
    Niveau(int niveau) {
        this.niveau=niveau;
    }
    
    public int getNiveau() {
        return this.niveau;
    }
    
    public static Niveau getPREMIERE_ANNEE() {
        return PREMIERE_ANNEE;
    }
    
    public static Niveau getDEUXIEME_ANNEE() {
        return DEUXIEME_ANNEE;
    }
    
    public static Niveau getNiveau(String e)
    {
        switch (e)
        {
            case "1":
                return Niveau.PREMIERE_ANNEE;
            case "2":
                return Niveau.DEUXIEME_ANNEE;
            default:
                return Niveau.PREMIERE_ANNEE;
        }
    }
}

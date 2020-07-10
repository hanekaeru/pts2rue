package fr.iut.larochelle.util;

/**
 * <h1>Classe Chrono</h1>
 * Classe chrono permettant l'utilisation d'un chronomètre dans le controller de la question.
 * 
 * @author maxime
 */
public class Chrono {
    private long tempsDepart = 0;
    private long tempsFin = 0;
    private long pauseDepart = 0;
    private long pauseFin = 0;
    private long duree = 0;
    
    /**
     * @author maxime
     * Méthode start() qui démarre le chrono.
     */
    public void start()
    {
        tempsDepart=System.currentTimeMillis();
        tempsFin = 0;
        pauseDepart = 0;
        pauseFin = 0;
        duree = 0;
    }
    
    /**
     * @author maxime
     * Méthode pause qui met en pause le chrono.
     */
    public void pause()
    {
        if(tempsDepart == 0) { return; }
        pauseDepart = System.currentTimeMillis();
    }
    
    /**
     * @author maxime
     * Remet un marche le chrono.
     */
    public void resume()
    {
        if(tempsDepart == 0) { return; }
        if(pauseDepart == 0) { return; }
        pauseFin = System.currentTimeMillis();
        tempsDepart = tempsDepart+pauseFin-pauseDepart;
        tempsFin = 0;
        pauseDepart = 0;
        pauseFin = 0;
        duree = 0;
    }
    
    /**
     * @author maxime
     * Arrête le chrono.
     */
    public void stop()
    {
        if(tempsDepart == 0) { return; }
        tempsFin = System.currentTimeMillis();
        duree = (tempsFin-tempsDepart) - (pauseFin-pauseDepart);
        tempsDepart = 0;
        tempsFin = 0;
        pauseDepart = 0;
        pauseFin = 0;
    }
    
    public long getDureeSec()
    {
        return duree/1000;
    }
    
    public long getDureeMs()
    {
        return duree;
    }
    
    public String getDureeTxt()
    {
        return timeToHMS(getDureeSec());
    }
    
    /**
     * @author maxime
     * Converti le temps en HMS
     * @param tempsS temps en seconde
     * @return String
     */
    public static String timeToHMS(long tempsS) {
        
        // IN : (long) temps en secondes
        // OUT : (String) temps au format texte : "1 h 26 min 3 s"
        
        int h = (int) (tempsS / 3600);
        int m = (int) ((tempsS % 3600) / 60);
        int s = (int) (tempsS % 60);
        
        String r = "";
        
        if(h > 0) {r += h + " h ";}
        if(m > 0) {r += m + " min ";}
        if(s > 0) {r += s + " s";}
        if(h <= 0 && m <= 0 && s <= 0) {r = "0 s";}
        
        return r;
    }
    
}

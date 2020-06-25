/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PTS2.modele;

/**
 *<h1>Classe Matiere</h1>
 * Switch case regroupant toutes les matières et leur abréviation.
 * @author maxime
 */
public enum Matiere {
    M111 ("EEJ"),
    M112 ("GCE"),
    M121 ("OME"),
    M122 ("ORI"),
    M211 ("ADM"),
    M212 ("TDG"),
    M221 ("LC"),
    M222 ("VD"),
    Projet ("AP"),
    M311 ("TC"),
    M312 ("ORC"),
    M321("DAP"),
    M322("CO"),
    M411 ("TCA"),
    M421 ("MEP"),
    Stage ("APS");
    
    private UE ue;
    private Niveau niveau;
    private String matiere;
    
    Matiere(String matiere) {
        this.matiere=matiere;
    }

    public String getMatiere() {
        return matiere;
    }

    public UE getUe() {
        return ue;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
    
    
    public static Matiere getMatiere(String e)
    {
        switch (e)
        {
            case "EEJ":
                return Matiere.M111;
            case "GCE":
                return Matiere.M112;
            case "ORI":
                return Matiere.M122;
            case "ADM":
                return Matiere.M211;
            case "TDG":
                return Matiere.M212;
            case "LC":
                return Matiere.M221;
            case "VD":
                return Matiere.M222;
            case "AP":
                return Matiere.Projet;
            case "TC":
                return Matiere.M311;         
            case "ORC":
                return Matiere.M312;
            case "DAP":
                return Matiere.M321;
            case "CO":
                return Matiere.M322;
            case "TCA":
                return Matiere.M411;
            case "MEP":
                return Matiere.M421;
            case "APS":
                return Matiere.Stage;                
            default:
                return null;
        }
    }
    
}

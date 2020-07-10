package fr.iut.larochelle.modele;

/**
 *
 * @author yoann
 */
public enum UE {
    UE11 ("11"),
    UE12 ("12"),
    UE21 ("21"),
    UE22 ("22"),
    UE23 ("23"),
    UE31 ("31"),
    UE32 ("32"),
    UE41 ("41"),
    UE42 ("42"),
    UE43 ("43");
    
    private final String module;
    
    UE(String module) {
        this.module=module;
    }
    
    public String getModule() {
        return this.module;
    }
    
    
    public static UE getUE(String e)
    {
        switch (e)
        {
            case "11":
                return UE.UE11;
            case "12":
                return UE.UE12;
            case "21":
                return UE21;
            case "22":
                return UE22;
            case "23":
                return UE23;
            case "31":
                return UE31;
            case "32":
                return UE32;
            case "41":
                return UE41;
            case "42":
                return UE42;
            case "43":
                return UE43;
            default:
                return null;
        }
    }
}
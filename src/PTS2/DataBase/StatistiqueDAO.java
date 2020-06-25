package PTS2.DataBase;


import PTS2.modele.Statistiques;
import PTS2.modele.Utilisateur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Enzo
 */
public class StatistiqueDAO {
    
    
    public StatistiqueDAO() {
    }
    
    
    /**
     * Permet d'initialiser les statistiques d'un nouvel utilisateur à zéro.
     * @author Enzo
     * @param utilisateur l'utilisateur à initialiser
     * @throws SQLException
     * @deprecated Il faut donner un étudiant et non un utilisateur à cause des changements de schémas
     */
    public static void initStatistique(Utilisateur utilisateur) throws SQLException{
        int id = CountDAO.getCount("Utilisateur")+1;
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        int idUser = utilisateurDAO.getIdUtilisateur(utilisateur.getUsername());
        
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = null;
        
        try {
            String query = "insert into statistique "
                    + "values(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, " + idUser + ", " + id
                    + ")";
            
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    /* ignored */
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                    myDemoDBConn.closeConnection();
                } catch (SQLException e) {
                    /* ignored */
                }
            }
        }
    }
    
    /**
     * Permet de récupérer un attribut de la table Statistique d'un utilisateur
     * @author Enzo
     * @param username le nom du propriétaire des statistiques
     * @param attribut l'attribut à récupérer
     * @return l'attribut au format int ou 0 si non trouvé
     * @throws SQLException
     */
    public int getAttribut(String username, String attribut) throws SQLException{
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        int id = utilisateurDAO.getIdUtilisateur(username);
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = conn.createStatement();
        
        String query = "select " + attribut + " from statistique where idEtudiant="
                + id;
        
        try {
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                return res.getInt(attribut);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    /* ignored */
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                    myDemoDBConn.closeConnection();
                } catch (SQLException e) {
                    /* ignored */
                }
            }
        }
        return 0;
    }
    
    /**
     * Permet de mettre à jour un attribut de la table statistique
     * @author Enzo
     * @param username le nom du propriétaire des statistiques
     * @param attribut l'attribut à mettre à jour
     * @param nombre   la valeur de l'attribut à mettre à jour
     * @throws SQLException
     */
    public void setAttribut(String username, String attribut, int nombre) throws SQLException{
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        int id = utilisateurDAO.getIdUtilisateur(username);
        
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = null;
        
        String query = "update statistique set statistique." + attribut + "=" + nombre + " where idEtudiant="
                + id;
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    /* ignored */
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                    myDemoDBConn.closeConnection();
                } catch (SQLException e) {
                    /* ignored */
                }
            }
        }
    }
    
    /**
     * Permet de créer en mémoire l'objet Statistique à partir de la base de donnée
     * @author Enzo
     * @param username le nom du propriétaire des statistiques
     * @return l'objet Statistiques créé, ou null si impossible
     * @throws SQLException
     */
    public Statistiques newStatistique(String username) throws SQLException {
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        int id = utilisateurDAO.getIdUtilisateur(username);
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = conn.createStatement();
        
        String query ="select * from statistique, Utilisateur where Utilisateur.username="
                + "'" + username +"'";
        
        try {
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                int nombreQuestion = res.getInt("nombreQuestion");
                int nombreBonnesQuestions =res.getInt("nombreBonnesQuestions");
                int nombreQuestionsRepondues = res.getInt("nombreQuestionsRepondues");
                float vitesseMoyenne = res.getFloat("vitesseMoyenne");
                int meilleureSerieBonnesReponses =res.getInt("meilleureSerieBonnesReponses");
                int meilleurClassement =res.getInt("meilleurClassement");
                int meilleurNombreDePointsSemaine =res.getInt("meilleurNombreDePointsSemaine");
                int nombreDeFoisGagnant =res.getInt("nombreDeFoisGagnant");
                float tempsReponse =0;
                
                
                return new Statistiques(nombreQuestion, nombreBonnesQuestions, nombreQuestionsRepondues,
                        vitesseMoyenne, meilleureSerieBonnesReponses, meilleurClassement, meilleurNombreDePointsSemaine, nombreDeFoisGagnant, tempsReponse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    /* ignored */
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                    myDemoDBConn.closeConnection();
                } catch (SQLException e) {
                    /* ignored */
                }
            }
        }
        return null;
    }
}

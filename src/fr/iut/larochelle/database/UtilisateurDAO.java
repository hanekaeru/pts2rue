package fr.iut.larochelle.database;

import fr.iut.larochelle.modele.Administrateur;
import fr.iut.larochelle.modele.Etudiant;
import fr.iut.larochelle.modele.Matiere;
import fr.iut.larochelle.modele.Niveau;
import fr.iut.larochelle.modele.Professeur;
import fr.iut.larochelle.modele.Statistiques;
import fr.iut.larochelle.modele.Utilisateur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Enzo
 */
public class UtilisateurDAO {
    private Connection conn;
    
    public UtilisateurDAO() {}
    
    public void addEtudiant(Etudiant etudiant) throws SQLException {
        int id = CountDAO.getCount("Utilisateur")+1;
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = null;
        
        try {
            String query = "insert into Utilisateur "
                    + "values('" + etudiant.getUsername()
                    + "', '" + etudiant.getPassword()
                    + "', '" + "Etudiant"
                    + "', " + "false" + ", "
                    + etudiant.getNiveau().getNiveau()
                    + ", NULL, "
                    + id
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
    
    public void addProfesseur(Professeur professeur) throws SQLException {
        int id = CountDAO.getCount("Utilisateur")+1;
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = null;
        try {
            String query = "insert into Utilisateur "
                    + "values('" + professeur.getUsername()
                    + "', '" + professeur.getPassword()
                    + "', " + "'Professeur', "
                    + "false, "
                    + "NULL, '"
                    + professeur.getMatiere().getMatiere()
                    + "', " + id + ")";
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
    
    public void addAdministrateur(Administrateur professeurAdmin) throws SQLException {
        int id = CountDAO.getCount("Utilisateur")+1;
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = null;
        try {
            String query = "insert into Utilisateur "
                    + "values('" + professeurAdmin.getUsername()
                    + "', '" + professeurAdmin.getPassword()
                    + "', " + "'Administrateur', "
                    + "false, "
                    + "NULL, '"
                    + professeurAdmin.getMatiere().getMatiere()
                    +"', " + id + ")";
            
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
    
    public void removeUtilisateur(Utilisateur utilisateur) {
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = null;
        String query = "delete from utilisateur where username='" + utilisateur +"'";
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
    
    public void changerPassword(String newPassword, String username) throws SQLException {
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = conn.createStatement();
        
        String query = "update utilisateur set utilisateur.password='"
                + newPassword
                + "' where utilisateur.username='" + username + "'";
        
        try {
            stmt.executeUpdate(query);
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
    
    public boolean connexion(String username, String password) throws SQLException {
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = conn.createStatement();
        
        String query = "select username, password, userType from utilisateur where username='"
                + username
                + "' and password='"
                + password + "'";
        
        try {
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                return true;
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
        return false;
    }
    
    public int getIdUtilisateur(String username) throws SQLException {
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = conn.createStatement();
        
        String query = "select username, idutilisateur from utilisateur where username='"
                + username
                + "'";
        
        try {
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                return res.getInt("idUtilisateur");
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
    
    public String getPassword(String username) throws SQLException {
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = conn.createStatement();
        
        String query = "select password from utilisateur where username='"
                + username
                + "'";
        
        try {
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                return res.getString("password");
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
    
    public String getTypeUser(String username) throws SQLException {
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = conn.createStatement();
        
        String query = "select username, userType from utilisateur where username='"
                + username
                + "'";
        
        try {
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                String typeUser = res.getString("userType");
                typeUser = typeUser.replace(" ", "");
                return typeUser;
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
        return "";
    }
    
    public Etudiant newEtudiant(String username, String password) throws SQLException {
        StatistiqueDAO statistiqueDAO = new StatistiqueDAO();
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = conn.createStatement();
        
        String query = "select * from utilisateur where username='"
                + username
                + "' and password='"
                + password + "'";
        
        try {
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                Niveau niveau = Niveau.getNiveau(res.getString("niveau"));
                Statistiques statistique = statistiqueDAO.newStatistique(username);
                int classement = statistiqueDAO.getAttribut(username, "classement");
                int points = statistiqueDAO.getAttribut(username, "points");
                
                return new Etudiant(username, password, niveau, statistique, classement, points);
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
    
    public Professeur newProfesseur(String username, String password) throws SQLException {
        StatistiqueDAO statistiqueDAO = new StatistiqueDAO();
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = conn.createStatement();
        
        String query = "select * from utilisateur where username='"
                + username
                + "' and password='"
                + password + "'";
        
        try {
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                Matiere matiere = Matiere.getMatiere(res.getString("matiere"));
                
                return new Professeur(username, password, matiere);
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
    
    public Administrateur newAdministrateur(String username, String password) throws SQLException {
        StatistiqueDAO statistiqueDAO = new StatistiqueDAO();
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = conn.createStatement();
        
        String query = "select * from utilisateur where username='"
                + username
                + "' and password='"
                + password + "'";
        
        try {
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                Niveau niveau = Niveau.getNiveau(res.getString("niveau"));
                Matiere matiere = Matiere.getMatiere(res.getString("matiere"));
                
                return new Administrateur(username, password, matiere);
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

package fr.iut.larochelle.database;

import fr.iut.larochelle.modele.Evenement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author Enzo
 */
public class EvenementDAO {
    private Connection conn;
    
    public EvenementDAO() {}
    
    public ArrayList<Evenement> getEvenement(LocalDate datedebut, LocalDate datefin) throws SQLException {
        ArrayList<Evenement> listeEvenement = new ArrayList<>();
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = conn.createStatement();
        
        String query = "select message from evenement where evenement.datedebut='" +
                datedebut.format(DateTimeFormatter.ISO_DATE).toString() + "' and evenement.datefin='" +
                datefin.format(DateTimeFormatter.ISO_DATE).toString() +"'";
        
        try {
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                Evenement evenement = new Evenement(res.getString("message"), datedebut, datefin);
                listeEvenement.add(evenement);
            }
            return listeEvenement;
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
    
    public void addEvenement(Evenement evenement) throws SQLException {
        int id = CountDAO.getCount("Utilisateur")+1;
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = conn.createStatement();
        
        String query = "insert into evenement values('"
                + evenement.getMessageEvenement()
                + "', '" + evenement.getDateDebut()
                + "', '" + evenement.getDateFin()
                + "', " + id + ")";
        
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
    
    public void setMsgEvenement(Evenement evenement, String newMessage) throws SQLException {
        int id = CountDAO.getCount("Utilisateur")+1;
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = conn.createStatement();
        
        String query = "update evenement set evenement.message='"
                + newMessage
                + "' where evenement.message='"
                + evenement.getMessageEvenement() + "'";
        
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
}

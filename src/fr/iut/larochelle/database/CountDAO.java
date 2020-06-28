package fr.iut.larochelle.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Permet de récupérer le nombre de n-uplets d'une table pour connaitre la future clé primaire
 * @author Enzo & Martin
 */
public class CountDAO {
    
    private Connection conn;
    
    public CountDAO() {
    }
    
    
    /**
     *
     * @param table : le nom de la table à compter
     * @return
     * @throws SQLException
     */
    public static int getCount(String table) throws SQLException {
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = conn.createStatement();
        String query = "select count(*) as compte from " + table;
        
        
        try {
            
            
            ResultSet res = stmt.executeQuery(query);
            if(res.next())
            {
                return res.getInt("compte");
            }
            //return res.getInt("compte")
            
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
}

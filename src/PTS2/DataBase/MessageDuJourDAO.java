/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PTS2.DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Enzo
 */
public class MessageDuJourDAO {
    private Connection conn;

    public MessageDuJourDAO() {}
    
    public static String getMsg() throws SQLException {
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = conn.createStatement();

        String query = "select message from messagedujour where messagedujour.idMessageDuJour=1";
        
         try {
             ResultSet res = stmt.executeQuery(query);
             if(res.next()){
                return res.getString("message");
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
    
    public String getIdEtudiant() throws SQLException {
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = conn.createStatement();

        String query = "select idetudiant from messagedujour where messagedujour.idMessageDuJour=1";
        
         try {
             ResultSet res = stmt.executeQuery(query);
             if(res.next()){
                return res.getString("idetudiant");
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
    
    public static void setMsg(String newMsg) throws SQLException {
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = conn.createStatement();

        String query = "update messagedujour set messagedujour.message='"
        + newMsg    
        + "' where messagedujour.idMessageDuJour=1";
        
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
    
    public void changerDroit(String username) throws SQLException {
        int idEtudiant = new UtilisateurDAO().getIdUtilisateur(username);
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = conn.createStatement();

        String query = "update messagedujour set messagedujour.idetudiant="
        + idEtudiant 
        + " where messagedujour.idMessageDuJour=1";
        
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

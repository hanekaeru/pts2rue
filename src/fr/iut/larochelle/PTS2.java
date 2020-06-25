package fr.iut.larochelle;

import PTS2.DataBase.DBConnection;
import PTS2.DataBase.DBProperties;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Antonin
 */
public class PTS2 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/PTS2/connexion/FXMLConnexion.fxml"));
        
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        DBProperties dbProps = new DBProperties();
        System.out.println("demo url : " + dbProps.getDbUrl());
        System.out.println("demo user : " + dbProps.getDbUser());
        System.out.println("demo passwd : " + dbProps.getDbPasswd());
        
        
        
        // Test DB Cnnnection
        DBConnection myDemoDBConn = new DBConnection ();
        Connection conn = null;
        try {
            conn = myDemoDBConn.getConnection();
            System.out.println("Connection Established Successfull and the DATABASE NAME IS:"
                    + conn.getMetaData().getDatabaseProductName());
            myDemoDBConn.closeConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    myDemoDBConn.closeConnection();
                } catch (SQLException e) {
                    /* ignored */
                }
            }
        }
        launch(args);
    }
}

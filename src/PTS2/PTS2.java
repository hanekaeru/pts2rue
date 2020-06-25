package PTS2;

import PTS2.DataBase.CountDAO;
import PTS2.DataBase.DBConnection;
import PTS2.DataBase.DBProperties;
import PTS2.DataBase.QuestionDAO;
import PTS2.DataBase.StatistiqueDAO;
import PTS2.DataBase.UtilisateurDAO;
import PTS2.modele.Etudiant;
import PTS2.modele.Matiere;
import PTS2.modele.Niveau;
import PTS2.modele.Professeur;
import PTS2.modele.Question;
import PTS2.modele.Statistiques;
import PTS2.modele.UE;
import PTS2.modele.Utilisateur;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

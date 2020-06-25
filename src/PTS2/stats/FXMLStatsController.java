package PTS2.stats;

import PTS2.DataBase.StatistiqueDAO;
import PTS2.modele.Statistiques;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Antonin
 */
public class FXMLStatsController implements Initializable {
        
    @FXML
    private Button btnQuitter;
    
    @FXML
    private Label nbquest;
    
    @FXML
    private Label vitmoy;
    
    @FXML
    private Label nbgoodrep;
    
    @FXML
    private Label nbfoisgagnant;
    
    @FXML
    private Label bestpoint;
    
    @FXML
    private Label bestserie;
    
    @FXML
    private Label nbquestrep;
    
    @FXML
    private Label bestclass;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
    }
    
    @FXML
    /*
    public void recupererStats(Etudiant etudiant)
    {
        label.setText(etudiant.stats.getStats());
    }
    */
    
    public void testerStats()
    {
        
    }
    
    public void quitter(){
        Stage fenetre = (Stage)btnQuitter.getScene().getWindow();
        fenetre.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //initialisation des statistiques
        StatistiqueDAO statDAO = new StatistiqueDAO();
        Statistiques stat = new Statistiques();
        try {
            stat = statDAO.newStatistique("etud"); //recupération des stat de l'utilisateur
            
            
            //affection des stat dans la vue
            this.nbquest.setText(stat.getNombreQuestionString());
            this.nbgoodrep.setText(stat.getNombreBonnesReponsesString());
            this.nbquestrep.setText(stat.getNombreQuestionsReponduesString());
            this.vitmoy.setText(stat.getVitesseMoyenneString());
            this.bestserie.setText(stat.getMeilleureSerieBonneReponseString());
            this.bestclass.setText(stat.getMeilleurClassementString());
            this.bestpoint.setText(stat.getMeilleurNombreDePointSemaineString());
            this.nbfoisgagnant.setText(stat.getNombreGagnantString());
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLStatsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
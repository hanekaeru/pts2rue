package fr.iut.larochelle.modererMessage;

import fr.iut.larochelle.database.MessageDuJourDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * <h1> Controller Modérer un message</h1>
 *
 * FXML controller, permettant de modifier le message de la semaine
 * dans la base de données.
 *
 * @author maxime
 */
public class FXMLModererMessageController implements Initializable {
    
    @FXML
    private Label messageDuJour;
    @FXML
    private TextArea taModerer;
    @FXML
    private Button btnSauvegarder;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.taModerer.setText(MessageDuJourDAO.getMsg());
        } catch (SQLException ex) {
            Logger.getLogger(FXMLModererMessageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sauvegarderMessage() throws SQLException
    {
        MessageDuJourDAO.setMsg(this.taModerer.getText());
    }
    
}

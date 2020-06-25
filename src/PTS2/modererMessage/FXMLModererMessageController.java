package PTS2.modererMessage;

import PTS2.DataBase.MessageDuJourDAO;
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
 * @author maxim
 */

public class FXMLModererMessageController implements Initializable {
    
    @FXML
    private Label messageDuJour;
    @FXML
    private TextArea taModerer;
    @FXML
    private Button btnSauvegarder;
    
    
    /**
     * Initializes the controller class.
     */
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

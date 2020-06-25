/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PTS2.gererUtilisateur;

import PTS2.DataBase.UtilisateurDAO;
import PTS2.modele.Administrateur;
import PTS2.modele.Etudiant;
import PTS2.modele.Matiere;
import PTS2.modele.Niveau;
import PTS2.modele.Professeur;
import PTS2.modele.Statistiques;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * <h1> Controller Ajouter un Utilisateur</h1>
 * 
 * FXML controller, permettant d'ajouter un nouvel utilisateur
 * dans la base de données.
 *
 * @author maxim
 */
public class FXMLAjouterUtilisateurController implements Initializable {

    @FXML
    private TextField username;
    
    @FXML
    private TextField password;
    
    @FXML
    private ComboBox niveau;
    
    @FXML
    private ComboBox matiere;
    
    @FXML
    private Button buttonSauvegarde;
    
    @FXML
    private RadioButton admin;
    
    @FXML
    private RadioButton etudiant;
    
    @FXML
    private RadioButton prof;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.niveau.setItems(FXCollections.observableArrayList(Niveau.values()));
        this.matiere.setItems(FXCollections.observableArrayList(Matiere.values()));
    }    
    
    /**
     * <h2>Méthode pour sauvegarder un utilisateur dans la BD.</h2>
     * @author enzo
     * 
     * @throws SQLException 
     */
    public void sauvegarderUtilisateur() throws SQLException{
        UtilisateurDAO userTemp = new UtilisateurDAO();
        if (admin.isSelected() == true)
        {
            Administrateur admin = new Administrateur(username.getText(), password.getText(), (Matiere) matiere.getValue());
            userTemp.addAdministrateur(admin);
        } else if (prof.isSelected() == true) {
            Professeur professeur = new Professeur(username.getText(), password.getText(), (Matiere) matiere.getValue());
            userTemp.addProfesseur(professeur);
        } else if (etudiant.isSelected() == true) {
            Statistiques stats = new Statistiques();
            Etudiant etudiant = new Etudiant(username.getText(), password.getText(), (Niveau) niveau.getValue(), stats, 0, 0);
            userTemp.addEtudiant(etudiant);
        }
    }

    
    public void recupererTypeUser(){
    
    }
}

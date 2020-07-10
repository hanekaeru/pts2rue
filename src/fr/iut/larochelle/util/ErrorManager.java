package fr.iut.larochelle.util;

import java.time.LocalDate;
import javafx.scene.control.Alert;

/**
 * Utility class used to handle failures.
 *
 * @author Antonin
 */
public class ErrorManager {
    
    /**
     * Displays an alert message on incomplete authentication fields.
     */
    public static void missingCredentialsWarner() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Authentification incomplète");
        alert.setHeaderText("Identification Impossible");
        alert.setContentText("Pas assez d'informations pour vous authentifier,"
                + "\nveuillez compléter tous les champs.");
        alert.showAndWait();
    }

    /**
     * Displays an warning dialog box on invalid credentials submission.
     */
    public static void unknownUserWarner() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Erreur de connexion");
        alert.setHeaderText("Identification Interrompue");
        alert.setContentText("Erreur d'identification, veuillez réessayer."
                + "\nVous pouvez également vous connecter sans mot de passe avec la connexion anonyme.");
        alert.showAndWait();
    }

    /**
     * Displays an informative dialog box when no question found for clicked day.
     * 
     * @param date
     */
    public static void displayNoQuestionFound(LocalDate date) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Aucune question ce jour");
        alert.setHeaderText("Impossible de charger la question");
        alert.setContentText("Pas de question trouvée en base pour le " + date
                + ",\nréessayez de vous connecter plus tard dans la journée.");
        alert.showAndWait();
    }

    /**
     * Displays the right answer.
     * 
     * @param bonneReponse
     */
    public static void displayResult(String bonneReponse) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Résultat");
        alert.setHeaderText("La réponse était : ");
        alert.setContentText("\n" + bonneReponse.replace("&#&", ", "));
        alert.showAndWait();
    }
    
}
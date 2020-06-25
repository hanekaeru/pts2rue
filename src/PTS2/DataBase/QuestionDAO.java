/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PTS2.DataBase;

import PTS2.modele.Etudiant;
import PTS2.modele.Matiere;
import PTS2.modele.Niveau;
import PTS2.modele.Professeur;
import PTS2.modele.Question;
import PTS2.modele.UE;
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
public class QuestionDAO {


    public QuestionDAO() {}

    
    /**
     * Permet 'lajout d'une question dans la base de données à partir de l'objet du modèle
     * author Martin
     * @param question l'objet du modèle à inscrire dans la base de données
     * @throws SQLException 
     */
    //TODO : -rendre anonyme pour chaque type de question
    public void addQuestion(Question question) throws SQLException {
        
        //stockage du futur id_question
        int idQuestion = CountDAO.getCount("Question") +1;
        
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = null;
        try {
            String reponses = "";
            for(String e : question.getReponses())
                reponses += e + "&#&";
                
            String query = "";
            query = "insert into Question"
            + " values("
            + "'" + question.getMatiere().getMatiere()       + "', "
            +       question.getNiveau().getNiveau()         + ", "
            + "'" + question.getDatePubliee().format(DateTimeFormatter.ISO_DATE).toString() + "', "
            + "'" + question.getQuestion()                   + "', "
            + "'" + question.getBonneReponse()               + "', "
            + "'" + reponses                                 + "', "
            + "'" + question.getImage()                      + "', "
            + "'" + "qcm" + "', " //change en fonction des class anonymes
            + "'11'" + ", " //change en fonction des class anonymes                   
            + "5" + ", "
            + idQuestion 
            + ")";
            
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.commit();
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
    
    /**
     * Permet de récupérer un objet du modèle Question à partir d'une date
     * @param date la date du jour à laquelle la quesiton est parrue
     * @return un objet Question
     * @throws SQLException 
     * @deprecated Il faut aussi demander le sélécteur d'année en fonction de l'utilisateur connecté
     */
    public Question getQuestion(LocalDate date) throws SQLException {
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = conn.createStatement();
        
        String query = "select * from Question where "
        + "datePubliee = '" + date.format(DateTimeFormatter.ISO_DATE).toString() + "'";
        

        try {
            ResultSet res = stmt.executeQuery(query);
            if (res.next())
            {
                Matiere matiere = Matiere.getMatiere(res.getString("matiere"));
                Niveau niveau   = Niveau.getNiveau(res.getString("niveau"));
                LocalDate dateRes = LocalDate.parse(res.getString("datePubliee"));
                String question = res.getString("question");
                String bonneReponse = res.getString("bonneReponse");
                ArrayList<String> reponses = toList(res.getString("reponses"));
                UE ue = UE.getUE(res.getString("ue"));
                

                return new Question(matiere, niveau, dateRes, question, bonneReponse, reponses, ue);
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
    
    /**
     * Permet de supprimer une question de la base de donnée à partir du modèle
     * @author Martin
     * @param question l'objet du modèle question à supprimer
     */
    public void removeQuestion(Question question) {
        DBConnection myDemoDBConn = new DBConnection();
        Connection conn = myDemoDBConn.getConnection();
        Statement stmt = null;
        String query = "delete from Question where datePubliee = '" + question.getDatePubliee().format(DateTimeFormatter.ISO_DATE).toString() +"'";
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.commit();
            conn.close();
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

    
    
    /* TODO :   - removeQuestion(LocalDate)
                - getQuestion(LocalDate, int niveau)
    */
    
    
    
    /**
     * Permet de convertir une suite de réponses de la forme
     *      reponse 1&#&reponse 2&#&reponse 3 [...] en une ArrayList<String>
     * @param chaine la chaine de caractère à traiter
     * @return une ArrayList<String> contenant les différentes réponses possibles d'une question
     */
    private ArrayList<String> toList(String chaine)
    {
        String chaineListee[];

        chaineListee = chaine.split("&#&");
        
        ArrayList<String> res = new ArrayList<>();
        
        for (String e : chaineListee)
            res.add(e);
        
        return (res);
    }
}

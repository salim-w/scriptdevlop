/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Wissal
 */
public class ExoJDBC2 { 
  public static void main(String[] args){
 //Information d'accès à la base de données
 String user = "root";
 String password = "";
 String url = "jdbc:mysql://localhost/scriptdevlop";
 Connection cn = null;
 Statement st = null;
 ResultSet res =null;
 try {
 //Etape 1 : Chargement du driver
 Class.forName("com.mysql.jdbc.Driver");
 //Etape 2 : Récupération de la connexion
 cn = DriverManager.getConnection(url, user, password);
 //Etape 3 : Création d'un statement
 st = cn.createStatement();
  String reqMaxScripts = "SELECT Developpeurs, jour, max(NBScripts) as max_scripts " +
                                     "FROM devdata " +
                                     "GROUP BY jour";
            res = st.executeQuery(reqMaxScripts);

            // Parcourir les résultats
            System.out.println("Personne ayant réalisé le nombre maximum de scripts en une journée :");
            while (res.next()) {
                String developpeur = res.getString("Developpeurs");
                String jour = res.getString("jour");
                int maxScripts = res.getInt("max_scripts");

                System.out.println("Le développeur " + developpeur + " a réalisé " + maxScripts + " scripts le " + jour);
            }

            // Fermer l'objet ResultSet pour libérer les ressources
            res.close();

            // Partie 2 : Calculer et afficher le nombre total de scripts réalisés en une semaine
            String TotalScripts = "SELECT SUM(NBScripts) AS total_scripts_semaine " +
                                       "FROM devdata";
            res = st.executeQuery(TotalScripts);
            // Parcourir les résultats
            if (res.next()) {
                int totalScripts = res.getInt("total_scripts_semaine");
                System.out.println("Nombre total de scripts réalisés en une semaine : " + totalScripts);
            }
 } catch (SQLException e) {
 System.out.println("Erreur SQL");
 } catch (ClassNotFoundException ex) {
 System.out.println("Impossible de charger le driver");
 } finally {
 try {
 //Etape 5 : Libérer les ressources de la mémoire
 st.close();
 cn.close();
 } catch (SQLException ex) {
 System.out.println("Impossible de libérer les ressources");
 }
 }
 }  
}

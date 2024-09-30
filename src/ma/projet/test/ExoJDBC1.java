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
public class ExoJDBC1 {
  public static void main(String[] args){
 //Information d'accès à la base de données
 String user = "root";
 String password = "";
 String url = "jdbc:mysql://localhost/scriptdevlop";
 Connection cn = null;
 Statement st = null;
 ResultSet resNBScripts =null;
 try {
 //Etape 1 : Chargement du driver
 Class.forName("com.mysql.jdbc.Driver");
 //Etape 2 : Récupération de la connexion
 cn = DriverManager.getConnection(url, user, password);
 //Etape 3 : Création d'un statement
 st = cn.createStatement();
    String reqNBScripts = "SELECT Developpeurs, sum(NBScripts) as c " +
                           "FROM devdata " +
                           "GROUP BY Developpeurs " +
                           "ORDER BY c DESC";
            resNBScripts = st.executeQuery(reqNBScripts);

            // Parcourir les résultats
            while (resNBScripts.next()) {
                String developpeur = resNBScripts.getString("Developpeurs");
                int nbScripts = resNBScripts.getInt("c");

                System.out.println("Le développeur " + developpeur + " a réalisé " + nbScripts + " scripts");
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

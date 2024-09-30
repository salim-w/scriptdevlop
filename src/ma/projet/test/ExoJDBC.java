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
public class ExoJDBC { 
  public static void main(String[] args){
 //Information d'accès à la base de données
 String user = "root";
 String password = "";
 String url = "jdbc:mysql://localhost/scriptdevlop";
 Connection cn = null;
 Statement st = null;
 ResultSet resmaxScripts =null;
 try {
 //Etape 1 : Chargement du driver
 Class.forName("com.mysql.jdbc.Driver");
 //Etape 2 : Récupération de la connexion
 cn = DriverManager.getConnection(url, user, password);
 //Etape 3 : Création d'un statement
 st = cn.createStatement();
 String reqmaxScripts = "SELECT Developpeurs, jour, max(NBScripts) as max_scripts " +
                           "FROM devdata " +
                           "GROUP BY jour";
            resmaxScripts = st.executeQuery(reqmaxScripts);

            while (resmaxScripts.next()) {
                String developpeur = resmaxScripts.getString("Developpeurs");
                String jour = resmaxScripts.getString("jour");
                int maxScripts = resmaxScripts.getInt("max_scripts");

                System.out.println("Le développeur " + developpeur + " a réalisé " + maxScripts + " scripts le " + jour);
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

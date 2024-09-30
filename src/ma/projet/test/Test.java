/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Wissal
 */
public class Test {
/**
 *
 * @author Wissal
 */
  public static void main(String[] args){
 //Information d'accès à la base de données
 String user = "root";
 String password = "";
 String url = "jdbc:mysql://localhost/scriptdevlop";
 Connection cn = null;
 Statement st = null;
 try {
 //Etape 1 : Chargement du driver
 Class.forName("com.mysql.jdbc.Driver");
 //Etape 2 : Récupération de la connexion
 cn = DriverManager.getConnection(url, user, password);
 //Etape 3 : Création d'un statement
 st = cn.createStatement();
 String req =  "CREATE TABLE DevData ("+
 "Developpeurs VARCHAR (32),"+
 "Jour CHAR (11),"+
 "NbScripts INTEGER)" ;
 st.executeUpdate(req);
  String reqinser = "INSERT INTO DevData VALUES " +
                                   "('ALAMI', 'Lundi', 1), " +
                                   "('WAFI', 'Lundi', 2), " +
                                   "('SALAMI', 'Mardi', 9), " +
                                   "('SAFI', 'Mardi', 2), " +
                                   "('ALAMI', 'Mardi', 2), " +
                                   "('SEBIHI', 'Mercredi', 2), " +
                                   "('WAFI', 'Jeudi', 3), " +
                                   "('ALAOUI', 'Vendredi', 9), " +
                                   "('WAFI', 'Vendredi', 3), " +
                                   "('SEBIHI', 'Vendredi', 4)";
            st.executeUpdate(reqinser);
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


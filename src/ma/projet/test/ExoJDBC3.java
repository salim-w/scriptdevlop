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
import java.util.Scanner;
/**
 *
 * @author Wissal
 */
public class ExoJDBC3 {
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
 ResultSet res =null;
    Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le nom du programmeur : ");
        String programmeur = scanner.nextLine();
 try {
 //Etape 1 : Chargement du driver
 Class.forName("com.mysql.jdbc.Driver");
 //Etape 2 : Récupération de la connexion
 cn = DriverManager.getConnection(url, user, password);
 //Etape 3 : Création d'un statement
 st = cn.createStatement();
  String queryTotalScriptsByDev = "SELECT Developpeurs, SUM(NBScripts) AS total_scripts "
                    + "FROM devdata "
                    + "WHERE Developpeurs = '" + programmeur + "' "
                    + "GROUP BY Developpeurs";

            res = st.executeQuery(queryTotalScriptsByDev);

            // Parcourir les résultats
            if (res.next()) {
                String dev = res.getString("Developpeurs");
                int totalScripts = res.getInt("total_scripts");
                System.out.println("Le développeur " + dev + " a réalisé un total de " + totalScripts + " scripts.");
            } else {
                System.out.println("Aucun résultat pour le programmeur " + programmeur);
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

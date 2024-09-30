/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.devdata;

/**
 *
 * @author Wissal
 */
public class Devdata {
    String  Developpeurs;
    String  Jour;
     int NbScripts;
    public DevData(String Developpeurs, String Jour, int NbScripts) {
        this.Developpeurs = Developpeurs;
        this.Jour = Jour;
        this.NbScripts = NbScripts;
    }
    public String getDeveloppeurs() {
        return Developpeurs;
    }
    public String getJour() {
        return Jour;
    }
    public int getNbScripts() {
        return NbScripts;
    }
    public void setDeveloppeurs(String Developpeurs) {
        this.Developpeurs = Developpeurs;
    }
    public void setJour(String Jour) {
        this.Jour = Jour;
    }

    public void setNbScripts(int NbScripts) {
        this.NbScripts = NbScripts;
    }

    @Override
    public String toString() {
        return "DevData{" + "Developpeurs=" + Developpeurs + ", Jour=" + Jour + ", NbScripts=" + NbScripts + '}';
    }
}
    
    
    


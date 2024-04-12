package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Pilot {
    /*Atributs de la classe*/
    String idPilot;
    String nomPilot;
    String cognomPilot;
    public int horesPilot;

    /*Constructor que genera un ID únic utilitzant la classe RandomUtils*/
    public Pilot() {
        this.idPilot = RandomUtils.getId();
    }

    /*Constructor amb paràmetres per inicialitzar el nom del dron, el fabricant i el model*/
    public Pilot(String nomPilot, String cognomPilot, int horesPilot){
        this(); //crida al primer constructor per inicialitzar l'ID del pilot
        this.setNomPilot(nomPilot); //estableix el nom del Pilot
        this.setCognomPilot(cognomPilot); //estableix el cognom del Pilot
        this.setHoresPilot(horesPilot);
    }

    /*Mètodes de setters i getters dels atributs*/

    public String getIdPilot() {
        return idPilot;
    }

    public void setIdPilot(String idPilot) {
        this.idPilot = idPilot;
    }

    public String getNomPilot() {
        return nomPilot;
    }

    public void setNomPilot(String nomPilot) {
        this.nomPilot = nomPilot;
    }

    public String getCognomPilot() {
        return cognomPilot;
    }

    public void setCognomPilot(String cognomPilot) {
        this.cognomPilot = cognomPilot;
    }

    public int getHoresPilot() {
        return horesPilot;
    }

    public void setHoresPilot(int horesPilot) {
        this.horesPilot = horesPilot;
    }
}

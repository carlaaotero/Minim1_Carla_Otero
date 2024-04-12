package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Dron {
    /*Atributs de la classe*/
    String idDron;
    String nomDron;
    String fabricant;
    String model;
    public int horesDron;

    /*Constructor que genera un ID únic utilitzant la classe RandomUtils*/
    public Dron() {
        this.idDron = RandomUtils.getId();
    }

    /*Constructor amb paràmetres per inicialitzar el nom del dron, el fabricant i el model*/
    public Dron(String nomDron, String fabricant, String model, int horesDron){
        this(); //crida al primer constructor per inicialitzar l'ID del dron
        this.setNomDron(nomDron); //estableix el nom del Dron
        this.setFabricant(fabricant); //estableix el fabricant
        this.setModel(model);
        this.setHoresDron(horesDron);
    }

    /*Mètodes de setters i getters dels atributs*/
    public String getIdDron() {
        return idDron;
    }

    public void setIdDron(String idDron) {
        this.idDron = idDron;
    }

    public String getNomDron() {
        return nomDron;
    }

    public void setNomDron(String nomDron) {
        this.nomDron = nomDron;
    }

    public String getFabricant() {
        return fabricant;
    }

    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHoresDron() {
        return horesDron;
    }

    public void setHoresDron(int horesDron) {
        this.horesDron = horesDron;
    }
}
